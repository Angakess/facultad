program PracticaEJ1;
const
	valorAlto = 9999;
type
	empleado = record
		cod:integer;
		nombre:string;
		monto:real;
	end;
	
	archivoEmpleados = file of empleado;
	
procedure imprimirArchivo(var empleados: archivoEmpleados);
var
	e:empleado;
begin
	while(not eof(empleados))do begin
		read(empleados,e);
		Writeln('Codigo: ', e.cod);
		Writeln('Nombre: ',e.nombre);
		Writeln('Monto: ',e.monto:2:2);
	end;
end;
procedure leer(var empleados: archivoEmpleados; var reg:empleado);
begin
	if(not eof(empleados))then
		read(empleados, reg)
	else
		reg.cod:= valorAlto;
end;
procedure leerDatos(var e:empleado);
begin
	Write('Ingrese el codigo del empleado: ');
	readln(e.cod);
	if(e.cod <> -1)then begin
		Write('Ingrese el nombre del empleado: ');
		readln(e.nombre);
		Write('Ingrese el monto: ');
		readln(e.monto);
	end;
end;
procedure crearArchivo(var empleados: archivoEmpleados);
var
	e:empleado;
begin
	rewrite(empleados);
	leerDatos(e);
	while(e.cod <> -1)do begin
		write(empleados, e);
		leerDatos(e);
	end;
	close(empleados);
end;
procedure compactarArchivo(var empleados: archivoEmpleados; var empleadosCompact: archivoEmpleados);
var
	e,eAct:empleado;
begin
	reset(empleados);
	rewrite(empleadosCompact);
	leer(empleados, e);
	while(e.cod <> valorAlto)do begin
		eAct:= e;
		eAct.monto:= 0;
		while(eAct.cod = e.cod)do begin
			eAct.monto:= eAct.monto + e.monto;
			leer(empleados, e);
		end;
		write(empleadosCompact, eAct);
	end;
	close(empleados);
	close(empleadosCompact);
end;


var
	empleados, empleadosCompact: archivoEmpleados;
	num:integer;
BEGIN
	assign(empleados, 'archivoDeEmpleados');
	assign(empleadosCompact, 'archivoDeEmpleadosCompact');
	writeln('Elija una opcion: ');
	Writeln('1- Crear el archivo original');
	Writeln('2- Crear el archivo compacto');
	readln(num);
	if(num = 1)then begin
		crearArchivo(empleados);
		reset(empleados);
		imprimirArchivo(empleados);
		close(empleados);
	end
	else if(num = 2)then begin
		compactarArchivo(empleados, empleadosCompact);
		reset(empleadosCompact);
		imprimirArchivo(empleadosCompact);
		close(empleadosCompact);
	end
	else 
		Writeln('No eligio ninguna opcion valida.');
END.

