program PracticaEJ4;

type
	empleado = record
		num:integer;
		apellido:string;
		nombre:string;
		edad:integer;
		dni:integer;
	end;
	
	archivoEmpleados = file of empleado;
	textoEmpleados = Text;
	
procedure LeerDatos(var emp:empleado);
	begin
		Write('Ingrese el nombre del empleado: (finaliza con "fin")');
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
procedure opcionA(var empleados: archivoEmpleados);
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
	procedure opcionIV(var empleados: archivoEmpleados);
	var
		e,aux:empleado;
	begin
		LeerDatos(e);
		while((e.nombre <> 'fin')and(not eof(empleados)))do begin
			read(empleados, aux);
			while((not eof(empleados))and(aux.num <> e.num))do begin
				read(empleados, aux);
			end;
			if(aux.num = e.num)then
				Writeln('Ya existe alguien con ese numero de empleado, ingrese otro.')
			else
				write(empleados, e);
			LeerDatos(e);
			seek(empleados, 0);
		end;
	end;
	procedure opcionV(var empleados: archivoEmpleados);
	var
		numX:integer;
		aux:empleado;
	begin
		Write('Ingrese el numero de empleado al que quiera modificar la edad (finaliza esta accion con -1): ');
		readln(numX);
		while((numX <> -1)and(not eof(empleados)))do begin
			read(empleados, aux);
			while(not eof(empleados)and(numX <> aux.num))do begin
				read(empleados, aux);
			end;
			if(numX = aux.num)then begin
				Write('Ingrese la edad a actualizar: ');
				Readln(aux.edad);
				seek(empleados, (filepos(empleados)-1));
				write(empleados, aux);
			end
			else begin
				Write('No se encontro el empleado con ese numero.');
			end;
			seek(empleados, 0);
			write('Ingrese otro numero de empleado: ');
			readln(numX);
		end;
	end;
	procedure opcionVI(var empleados:archivoEmpleados);
	var
		empleadosTxt: textoEmpleados;
		aux:empleado;
	begin
		Assign(empleadosTxt, 'todos_empleados');
		rewrite(empleadosTxt);
		while(not eof(empleados))do begin
			read(empleados, aux);
			Writeln(empleadosTxt, aux.num,'||',aux.nombre,'||',aux.apellido,'||',aux.edad,'||',aux.dni);
		end;
		close(empleadosTxt);
	end;
	procedure opcionVII(var empleados:archivoEmpleados);
	var
		empleadosTxt: textoEmpleados;
		aux:empleado;
	begin
		Assign(empleadosTxt, 'faltaDNIEmpleado');
		rewrite(empleadosTxt);
		while(not eof(empleados))do begin
			read(empleados, aux);
			if(aux.dni = 00)then
				Writeln(empleadosTxt, aux.num,'||',aux.nombre,'||',aux.apellido,'||',aux.edad,'||',aux.dni);
		end;
		close(empleadosTxt);
	end;
var
	opcion:integer;
begin
	Writeln('Elija una de las siguientes opciones: ');
	Writeln('1 - Listar todos los empleados con cierto nombre/apellido. ');
	Writeln('2 - Listar todos los empleados. ');
	Writeln('3 - Listar todos los empleados mayores de 70. ');
	Writeln('4 - Agregar uno o mas empleados. ');
	Writeln('5 - Modificar la edad de algun empleado. ');
	Writeln('6 - Generar un archivo de texto con todos los empleados. ');
	Writeln('7 - Generar un archivo de texto con los empleados con DNI 00. ');
	readln(opcion);
	while((opcion <> 1)and(opcion <> 2)and(opcion <> 3)and(opcion <> 4)and(opcion <> 5)and(opcion <> 6)and(opcion <> 7))do begin
		Write('No se eligio una opcion valida, vuelva a ingresar un integer: ');
		Readln(opcion);
	end;
	reset(empleados);
	if(opcion = 1)then
		opcionI(empleados)
	else if(opcion = 2)then
		opcionII(empleados)
	else if(opcion = 3)then
		opcionIII(empleados)
	else if(opcion = 4)then
		opcionIV(empleados)
	else if(opcion = 5)then
		opcionV(empleados)
	else if(opcion = 6)then
		opcionVI(empleados)
	else if(opcion = 7)then
		opcionVII(empleados);
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
	while((opcion <> 'A')and(opcion <> 'B'))do begin
		Write('No se eligio una opcion valida, vuelva a ingresar un caracter: ');
		Readln(opcion);
	end;
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
