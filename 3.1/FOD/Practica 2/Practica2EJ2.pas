program Practica2EJ2;
const
	valorAlto = 9999;

type
	alumnoM = record
		cod:integer;
		apellido:string;
		nombre:string;
		cursadas:integer;
		finales:integer;
	end;

	alumnoD = record
		cod:integer;
		promocion:string;
	end;
	
	maestro = file of alumnoM;
	detalle = file of alumnoD;
	
procedure leer(var regD:detalle; var dato:alumnoD);
begin
	if(not eof(regD))then
		read(regD,dato)
	else
		dato.cod:= valorAlto;
end;
procedure leerDatosM(var regM:alumnoM);
begin
	Write('Ingrese el codigo del alumno: ');
	readln(regM.cod);
	if(regM.cod <> -1)then begin
		Write('Ingrese el apellido del alumno: ');
		readln(regM.apellido);
		Write('Ingrese el nombre del alumno: ');
		readln(regM.nombre);
		Write('Ingrese la cantidad de materias con cursada aprobadas del alumno: ');
		readln(regM.cursadas);
		Write('Ingrese la cantidad de materias con final aprobadas del alumno: ');
		readln(regM.finales);
		Writeln('');
	end;
end;
procedure leerDatosD(var regD:alumnoD);
begin
	Write('Ingrese el codigo del alumno: ');
	readln(regD.cod);
	if(regD.cod <> -1)then begin
		Write('Ingrese si la materia esta aprobada con final ("si" o "no"): ');
		readln(regD.promocion);
	end;
end;
procedure crearArhivos(var mae:maestro; var det:detalle);
var
	regM:alumnoM;
	regD:alumnoD;
begin
	rewrite(mae); rewrite(det);
	Writeln('Ingrese los datos del archivo maestro.');
	leerDatosM(regM);
	while(regM.cod <> -1)do begin
		write(mae, regM);
		leerDatosM(regM);
	end;
	Writeln('');
	Writeln('Ingrese los datos del archivo detalle');
	leerDatosD(regD);
	while(regD.cod <> -1)do begin
		write(det, regD);
		leerDatosD(regD);
	end;
	close(mae); close(det);
end;
procedure actualizarMaestro(var mae:maestro; var det:detalle);
var
	regM:alumnoM;
	regD:alumnoD;
begin
	reset(mae); reset(det);
	leer(det, regD);	
	while(regD.cod <> valorAlto)do begin
		read(mae, regM);
		while(regM.cod <> regD.cod)do begin
			read(mae, regM);
		end;
		while(regD.cod = regM.cod)do begin
			if(regD.promocion = 'si')then
				regM.cursadas:= regM.cursadas+1
			else if(regD.promocion = 'no')then
				regM.finales:= regM.finales+1;
			leer(det, regD);
		end;
		seek(mae, filepos(mae)-1);
		write(mae, regM);
	end;
	close(mae); close(det);
end;
procedure crearTexto(var mae:maestro);
var
	txt: Text;
	regM:alumnoM;
begin
	assign(txt, 'alumnosCuatroCursadas.txt');
	reset(mae); rewrite(txt);
	while(not eof(mae))do begin
		read(mae, regM);
		if(regM.cursadas > 4)then begin
			Writeln(txt,'Codigo: ',regM.cod);
			Writeln(txt,'Apellido: ',regM.apellido);
			Writeln(txt,'Nombre: ',regM.nombre);
			Writeln(txt,'Cursadas: ',regM.cursadas);
			Writeln(txt,'Finales: ',regM.finales);
			Writeln(txt,'----------------------------------------');
		end;
	end;
	close(mae);close(txt);
end;

var
	mae:maestro;
	det:detalle;
	opcion:char;
BEGIN
	assign(mae, 'maestroAlumnosEJ2');
	assign(det, 'detalleAlumnosEJ2');
	Writeln('Elija una de las siguientes opciones:');
	Writeln('A- Crear archivos.');
	Writeln('B- Actulizar archivos.');
	writeln('C- Listar alumnos con mas de cuatro cursadas aprobadas sin final en un arhivo de texto.');
	readln(opcion);
	while((opcion<>'A')and(opcion<>'B')and(opcion<>'C'))do begin
		writeln('No ingreso una opcion valida, vueva a intentar.');
		readln(opcion);
	end;
	if(opcion='A')then
		crearArhivos(mae,det)
	else if(opcion='B')then
		actualizarMaestro(mae,det)
	else if(opcion='C')then
		crearTexto(mae);
END.

