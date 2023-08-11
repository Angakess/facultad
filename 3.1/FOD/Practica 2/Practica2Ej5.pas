program Practica2Ej5;
const
	valorAlto = 9999;
type
	padre = record
		dni:integer;
		nombre:string;
		apellido:string;
	end;
	nacimiento = record
		num:integer;
		nombre:string;
		apellido:string;
		dir:string;
		medico:integer;
		mama:padre;
		papa:padre;
	end;
	fallecimiento = record
		num:integer;
		dni:integer;
		nombre:string;
		apellido:string;
		medico:integer;
		fecha:string;
		hora:string;
		lugar:string;
	end;
	
	info = record
		num:integer;
		nombre:string;
		apellido:string;
		dir:string;
		medicoN:integer;
		mama:padre;
		papa:padre;
		medicoF:integer;
		fecha:string;
		hora:string;
		lugar:string;
	end;
	
	maestro = file of info;
	detalleN = file of nacimiento;
	detalleF = file of fallecimiento;


procedure leerN(var reg:detalleN; var dato:nacimiento);
begin
	if(not eof(reg))then
		read(reg, dato)
	else
		dato.num:= valorAlto;
end;
procedure leerF(var reg:detalleF; var dato:fallecimiento);
begin
	if(not eof(reg))then
		read(reg, dato)
	else
		dato.num:= valorAlto;
end;	
procedure leerNacimiento(var n:nacimiento);
begin
	Write('Ingrese el numero: ');
	Readln(n.num);
	if(n.num <> -1)then begin
		Write('Ingrese el nombre: ');
		Readln(n.nombre);
		Write('Ingrese el apellido: ');
		Readln(n.apellido);
		Write('Ingrese la direccion: ');
		Readln(n.dir);
		Write('Ingrese la matricula del medico: ');
		Readln(n.medico);
		Write('Ingrese el dni de la madre: ');
		Readln(n.mama.dni);
		Write('Ingrese el nombre de la madre: ');
		Readln(n.mama.nombre);
		Write('Ingrese el apellido de la madre: ');
		Readln(n.mama.apellido);
		Write('Ingrese el dni del padre: ');
		Readln(n.papa.dni);
		Write('Ingrese el nombre del padre: ');
		Readln(n.papa.nombre);
		Write('Ingrese el apellido del padre: ');
		Readln(n.papa.apellido);
		writeln('');
	end;
end;
procedure leerFallecimiento(var f:fallecimiento);
begin
	Write('Ingrese el numero: ');
	Readln(f.num);
	if(f.num <> -1)then begin
		Write('Ingrese el nombre: ');
		Readln(f.nombre);
		Write('Ingrese el apellido: ');
		Readln(f.apellido);
		Write('Ingrese el dni: ');
		Readln(f.dni);
		Write('Ingrese la matricula del medico: ');
		Readln(f.medico);
		Write('Ingrese la fecha de deceso: ');
		Readln(f.fecha);
		Write('Ingrese la hora de deceso: ');
		Readln(f.hora);
		Write('Ingrese el lugar de deceso: ');
		Readln(f.lugar);
		writeln('');
	end;
end;
procedure crearDetalleN(var det:detalleN);
var
	n:nacimiento;
begin
	writeln('Ingrese los datos de los nacimientos');
	leerNacimiento(n);
	rewrite(det);
	while(n.num <> -1)do begin
		write(det, n);
		leerNacimiento(n);
	end;
	close(det);
end;
procedure crearDetalleF(var det:detalleF);
var
	f:fallecimiento;
begin
	writeln('Ingrese los datos de los fallecimientos');
	leerFallecimiento(f);
	rewrite(det);
	while(f.num <> -1)do begin
		write(det, f);
		leerFallecimiento(f);
	end;
	close(det);
end;
procedure crearMaestro(var mae:maestro; var detN:detalleN; var detF:detalleF);
	procedure armarRegistro(var i:info; n:nacimiento);
	begin
		i.num:= n.num;
		i.nombre:= n.nombre;
		i.apellido:= n.apellido;
		i.dir:= n.dir;
		i.medicoN:= n.medico;
		i.mama.nombre:= n.mama.nombre;
		i.mama.apellido:= n.mama.apellido;
		i.mama.dni:= n.mama.dni;
		i.papa.nombre:= n.papa.nombre;
		i.papa.apellido:= n.papa.apellido;
		i.papa.dni:= n.papa.dni;
		i.medicoF:= 0;
		i.fecha:= 'N/A';
		i.hora:= 'N/A';
		i.lugar:= 'N/A';
	end;
	procedure agregarFallecimiento(var i:info; f:fallecimiento);
	begin
		i.medicoF:= f.medico;
		i.fecha:= f.fecha;
		i.hora:= f.hora;
		i.lugar:= f.lugar;
	end;
var
	n:nacimiento;
	f:fallecimiento;
	i:info;
begin
	reset(detN); reset(detF); rewrite(mae);
	leerN(detN,n);
	leerF(detF,f);
	while(n.num <> valorAlto)do begin
		armarRegistro(i,n);
		if(n.num = f.num)then begin
			agregarFallecimiento(i,f);
			leerF(detF, f);
		end;
		write(mae, i);
		leerN(detN, n);
	end;
	close(detN); close(detF); close(mae);
end;
procedure crearTexto(var mae:maestro);
var
	txt:Text;
	dato:info;
begin
	Assign(txt, 'MaestroTexto.txt');
	rewrite(txt); reset(mae);
	while(not eof(mae))do begin
		read(mae, dato);
		writeln(txt,'Numero de partida: ', dato.num);
		writeln(txt,'Nombre: ',dato.nombre);
		writeln(txt,'Apellido: ',dato.apellido);
		writeln(txt,'Direccion: ',dato.dir);
		writeln(txt,'Matricula del medico: ',dato.medicoN);
		writeln(txt,'Nombre de la madre: ',dato.mama.nombre);
		writeln(txt,'Apellido de la madre: ',dato.mama.apellido);
		writeln(txt,'DNI de la madre: ',dato.mama.dni);
		writeln(txt,'Nombre del padre: ',dato.papa.nombre);
		writeln(txt,'Apellido del padre: ',dato.papa.apellido);
		writeln(txt,'DNI del padre: ',dato.papa.dni);
		writeln(txt,'Medico de deceso: ',dato.medicoF);
		writeln(txt,'Fecha de deceso: ',dato.fecha);
		writeln(txt,'Hora de deceso: ',dato.hora);
		writeln(txt,'Lugar de deceso: ',dato.lugar);
		Writeln(txt,'---------------------------------------------');
	end;
	close(txt); close(mae);
end;

var
	detN:detalleN;
	detF:detalleF;
	mae:maestro;
	opcion: char;
BEGIN
	assign(detN,'NacimientosP2E5');
	assign(detF,'FallecimientosP2E5');
	assign(mae,'MaestroP2E5');
	Writeln('Elija una de las siguientes opciones');
	Writeln('A- Crear detalle de nacimientos');
	Writeln('B- Crear detalle de fallecimientos');
	Writeln('C- Crear maestro');
	Writeln('D- Crear texto de maestro');
	Readln(opcion);
	case opcion of
		'A': crearDetalleN(detN);
		'B': crearDetalleF(detF);
		'C': crearMaestro(mae,detN,detF);
		'D': crearTexto(mae);
		else Writeln('No se eligio ninguna opcion');
	end;
	
END.

