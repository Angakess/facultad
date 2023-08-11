program Practica3EJ4;
const
	valorAlto = 9999;
type
	novela = record
		cod:integer;
		precio:real;
	end;
	
	novelas = file of novela;

procedure leer(var archivo:novelas; var dato:novela);
begin
	if(not eof(archivo))then
		read(archivo,dato)
	else
		dato.cod:= valorAlto;
end;
procedure leerDatos(var n:novela);
begin
	n.cod:= random(100)+1;
	n.precio:= random(100)+2000;
	Write('Ingrese el codigo: ');
	Writeln(n.cod);
	Write('Ingrese el precio: ');
	Writeln(n.precio:2:2);
	Writeln('');
end;
procedure crearArchivo(var archivo:novelas);
var
	i:integer;
	n:novela;
begin
	rewrite(archivo);
	n.cod:= 0;
	Write(archivo, n);
	for i:=1 to 10 do begin
		leerDatos(n);
		Write(archivo, n);
	end;
	close(archivo);
end;
procedure abrirArchivo(var archivo:novelas);
	procedure agregarNovela(var archivo:novelas);
	var
		n,nuevo:novela;
	begin
		leerDatos(nuevo);
		reset(archivo);
		leer(archivo, n);
		if((n.cod < 0)and(n.cod <> valorAlto))then
			seek(archivo, -(n.cod))
		else
			seek(archivo, filesize(archivo));
		leer(archivo, n);
		seek(archivo, filepos(archivo)-1);
		write(archivo, nuevo);
		seek(archivo, 0);
		write(archivo, n);
		close(archivo);
	end;
	procedure modificarNovela(var archivo:novelas);
	var
		n:novela;
		codX:integer;
	begin
		Write('codigo a buscar: ');
		readln(codX);
		reset(archivo);
		leer(archivo, n);
		while((n.cod <> valorAlto)and(n.cod <> codX))do
			leer(archivo, n);
		if(n.cod = codX)then begin
			seek(archivo, filepos(archivo) - 1);
			n.precio:= n.precio - 100;
			write(archivo, n);
		end
		else
			Writeln('No se encontro el codigo ingresado');
		close(archivo);
	end;
	procedure borrarNovela(var archivo:novelas);
	var
		n:novela;
		codX,ant,ult:integer;
	begin
		Write('codigo a buscar: ');
		readln(codX);
		reset(archivo);
		leer(archivo, n);
		ant:= n.cod;
		while((n.cod <> valorAlto)and(n.cod <> codX))do
			leer(archivo, n);
		if(n.cod = codX)then begin
			ult:= filepos(archivo) - 1; 
			seek(archivo, ult);
			n.cod:= ant;
			write(archivo, n);
			n.cod:= -ult;
			seek(archivo, 0);
			write(archivo, n);
		end
		else
			Writeln('No se encontro el codigo ingresado');
		close(archivo);
	end;
var
	opcion:char;
begin
	Writeln('Opciones: ');
	Writeln('1- agregar novela.');
	Writeln('2- modificar novela');
	Writeln('3- borrar novela');
	Readln(opcion);
	if(opcion = '1')then
		agregarNovela(archivo)
	else if(opcion = '2')then
		modificarNovela(archivo)
	else if(opcion = '3')then
		borrarNovela(archivo);
end;
procedure imprimirArchivo(var archivo:novelas);
var
	n:novela;
	novelasTxt: Text;
begin
	assign(novelasTxt, 'novelas.txt');
	reset(archivo); rewrite(novelasTxt);
	while(not eof(archivo))do begin
		read(archivo, n);
		writeln(novelasTxt,'Codigo: ',n.cod);
		writeln(novelasTxt,'Precio: ',n.precio:2:2);
		writeln(novelasTxt,'');
	end;
	close(archivo); close(novelasTxt);
end;
procedure listarArchivo(var archivo:novelas);
var
	n:novela;
begin
	reset(archivo);
	while(not eof(archivo))do begin
		read(archivo, n);
		if(n.cod > 0)then begin
			Writeln('codigo: ',n.cod);
			Writeln('precio: $',n.precio:2:2);
			Writeln('');
		end;
	end;
	close(archivo);
end;
var
	archivo: novelas;
	opcion:char;
BEGIN
	assign(archivo,'archivoDeNovelas');
	Writeln('Opciones: ');
	Writeln('1- crear archivo');
	Writeln('2- abrir archivo');
	Writeln('3- imprimir archivo');
	Writeln('4- listar archivo');
	Readln(opcion);
	if(opcion = '1')then
		crearArchivo(archivo)
	else if(opcion = '2')then
		abrirArchivo(archivo)
	else if(opcion = '3')then
		imprimirArchivo(archivo)
	else if(opcion = '4')then
		listarArchivo(archivo);
END.


