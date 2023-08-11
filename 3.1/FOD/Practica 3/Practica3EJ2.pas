program Practica3EJ2;
const
	valoralto = 9999;
type
	asistente = record
		num:integer;
		name:string;
	end;
	
	asistentes = file of asistente;

procedure leer (var archivo:asistentes; var dato:asistente);
begin
	if (not eof(archivo))then
		read (archivo,dato)
	else
		dato.num:= valoralto;
end;
procedure leerDatos(var a:asistente);
begin
	write('codigo: ');
	readln(a.num);
	if(a.num <> -1)then begin
		write('nombre: ');
		readln(a.name);
	end;
end;	
procedure crearArchivo(var archivo:asistentes);
var
	a:asistente;
begin
	rewrite(archivo);
	writeln('Datos...');
	leerDatos(a);
	while(a.num <> -1)do begin
		write(archivo, a);
		writeln('');
		leerDatos(a);
	end;
	close(archivo);
end;
procedure borrar1000(var archivo:asistentes);
var
	aux:asistente;
begin
	reset(archivo);
	while(not eof(archivo))do begin
		read(archivo, aux);
		if(aux.num < 1000)then begin
			aux.name:= '@' + aux.name;
			seek(archivo, (filepos(archivo)-1));
			write(archivo, aux);
		end;
	end;
	close(archivo);
end;
procedure imprimirArchivo(var archivo:asistentes);
var
	a:asistente;
begin
	reset(archivo);
	while(not eof(archivo))do begin
		read(archivo, a);
		writeln('Numero: ',a.num);
		writeln('Nombre: ',a.name);
		writeln('');
	end;
	close(archivo);
end;	

var
	archivo: asistentes;
	opcion:char;

BEGIN
	assign(archivo, 'archivoDeAsistentes');
	Writeln('1- crear archivo');
	Writeln('2- borrar');
	Writeln('3- imprimir');
	readln(opcion);
	if(opcion = '1')then
		crearArchivo(archivo)
	else if(opcion = '2')then
		borrar1000(archivo)
	else if(opcion = '3')then
		imprimirArchivo(archivo);
END.

