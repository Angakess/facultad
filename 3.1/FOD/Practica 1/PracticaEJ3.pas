program PracticaEJ3;
type
	empleado = record
		num:integer;
		apellido:string;
		nombre:string;
		edad:integer;
		dni:integer;
	end;
	
	archivoEmpleados = file of empleado;
	

procedure opcionA(var empleados: archivoEmpleados);
	procedure LeerDatos(var emp:empleado);
		begin
			Write('Ingrese el nombre del empleado: ');
			readln(emp.nombre);
			if(emp.nombre <> 'fin')then begin
				Write('Ingrese el numero del empleado: ');
				readln(emp.num);
				Write('Ingrese el apellido del empleado: ');
				readln(emp.apellido);
				Write('Ingrese la edad del empleado: ');
				readln(emp.edad);
				Write('Ingrese el DNI del empleado: ');
				readln(emp.dni);
			end;
		end;
var
	e:empleado;
begin
	rewrite(empleados);
	LeerDatos(e);
	while(e.nombre <> 'fin')do begin
		write(empleados, e);
		LeerDatos(e);
	end;
end;
procedure opcionB(var empleados: archivoEmpleados);
	procedure opcionI(var empleados: archivoEmpleados);
	var
		nombre:string;
		e:empleado;
	begin
		Write('Ingrese el nombre o apellido que quiera buscar: ');
		Readln(nombre);
		while not eof(empleados)do begin
			read(empleados, e);
			if((e.nombre = nombre)or(e.apellido = nombre))then begin
				Writeln(e.num);
				Writeln(e.apellido);
				Writeln(e.nombre);
				Writeln(e.edad);
				Writeln(e.dni);
				Writeln('-----------------------------------');
			end;
		end;
	end;
	procedure opcionII(var empleados: archivoEmpleados);
	var
		e:empleado;
	begin
		while not eof(empleados)do begin
			read(empleados, e);
			Write(e.num,'	');
			Write(e.apellido,'	');
			Write(e.nombre,'	');
			Write(e.edad,'	');
			Writeln(e.dni);
		end;
	end;
	procedure opcionIII(var empleados: archivoEmpleados);
	var
		e:empleado;
	begin
		while not eof(empleados)do begin
			read(empleados, e);
			if(e.edad > 70)then begin
				Writeln(e.num);
				Writeln(e.apellido);
				Writeln(e.nombre);
				Writeln(e.edad);
				Writeln(e.dni);
				Writeln('-----------------------------------');
			end;
		end;
	end;
var
	opcion:integer;
begin
	Writeln('Elija una de las siguientes opciones: ');
	Writeln('1 - Listar todos los empleados con cierto nombre/apellido. ');
	Writeln('2 - Listar todos los empleados. ');
	Writeln('3 - Listar todos los empleados mayores de 70. ');
	readln(opcion);
	reset(empleados);
	if(opcion = 1)then
		opcionI(empleados)
	else if(opcion = 2)then
		opcionII(empleados)
	else if(opcion = 3)then
		opcionIII(empleados)
	else
		Writeln('No se eligio ninguna opcion');
end;
var
	Empleados: archivoEmpleados;
	opcion:char;
	nombre:string;
BEGIN
	Writeln('Elija una de las siguientes opciones: ');
	Writeln('A - Crear un archivo de empleado.');
	Writeln('B - Abrir el archivo creado previamente.');
	readln(opcion);
	if (opcion = 'A')then begin
		Write('Ingrese el nombre del archivo a crear: ');
		readln(nombre);
		assign(Empleados, nombre);
		opcionA(Empleados);
		close(Empleados);
	end
	else if (opcion = 'B')then begin
		Write('Ingrese el nombre del archivo para abrir: ');
		readln(nombre);
		assign(Empleados, nombre);
		opcionB(Empleados);
		close(Empleados);
	end
	else
		Writeln('No se eligio ninguna opcion');
	
END.

