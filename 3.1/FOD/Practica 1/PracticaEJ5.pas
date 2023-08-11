program PracticaEJ5;
type
	celular = record
		cod:integer;
		nombre:string;
		desc:string;
		marca:string;
		precio:real;
		stkMin:integer;
		stk:integer;
	end;
	
	archivoCelulares = file of celular;
	textoCelulares = Text;
	
procedure LeerDatos(var c:celular);
begin
	Write('Ingrese el codigo del celular: ');
	Readln(c.cod);
	if(c.cod <> -1)then begin
		Write('Ingrese el nombre del celular: ');
		Readln(c.nombre);
		Write('Ingrese la descripcion del celular: ');
		Readln(c.desc);
		Write('Ingrese la marca: ');
		Readln(c.marca);
		Write('Ingrese el precio: ');
		Readln(c.precio);
		Write('Ingrese el stock minimo: ');
		Readln(c.stkMin);
		Write('Ingrese el stock disponible: ');
		Readln(c.stk);
	end;
end;
procedure opcionA();
var
	c:celular;
	celulares:archivoCelulares;
	celularesTxt: textoCelulares;
	nombre:string;
begin
	Write('Ingrese el nombre del archivo a crear: ');
	Readln(nombre);
	Assign(celulares, nombre);
	Assign(celularesTxt, 'celulares.txt');
	reset(celularesTxt);
	rewrite(celulares);
	while(not eof(celularesTxt))do begin
		Readln(celularesTxt, c.cod, c.precio, c.marca);
		Readln(celularesTxt, c.stk, c.stkMin, c.desc);
		Readln(celularesTxt, c.nombre);
		Write(celulares, c);
	end;
	close(celularesTxt);
	close(celulares);
end;
procedure opcionB();
var
	celulares: archivoCelulares;
	c:celular;
	nombre:string;
begin
	Write('Ingrese el nombre del archivo a usar: ');
	Readln(nombre);
	Assign(celulares, nombre);
	reset(celulares);
	while(not eof(celulares))do begin
		read(celulares, c);
		if(c.stkMin > c.stk)then begin
			Writeln('Codigo: ', c.cod);
			Writeln('Nombre: ', c.nombre);
			Writeln('Descripcion: ', c.desc);
			Writeln('Marca: ', c.marca);
			Writeln('Precio: $', c.precio:2:2);
			Writeln('Stock minimo: ', c.stkMin);
			Writeln('Stock disponible: ', c.stk);
			Writeln('---------------------------------------------------------');
		end;
	end;
	close(celulares);
end;
procedure opcionC();
var
	celulares: archivoCelulares;
	c:celular;
	desc:string;
	nombre:string;
begin
	Write('Ingrese el nombre del archivo a usar: ');
	Readln(nombre);
	Assign(celulares, nombre);
	reset(celulares);
	Write('Ingrese la descripcion del celular que quiera buscar: ');
	Readln(desc);
	while(not eof(celulares))do begin
		read(celulares, c);
		if(c.desc = (' '+desc))then begin
			Writeln('Codigo: ', c.cod);
			Writeln('Nombre: ', c.nombre);
			Writeln('Descripcion: ', c.desc);
			Writeln('Marca: ', c.marca);
			Writeln('Precio: $', c.precio:2:2);
			Writeln('Stock minimo: ', c.stkMin);
			Writeln('Stock disponible: ', c.stk);
			Writeln('---------------------------------------------------------');
		end;
	end;
	close(celulares);
end;
procedure opcionD();
var
	celularesTxt: textoCelulares;
	celulares: archivoCelulares;
	c:celular;
	nombre:string;
begin
	Assign(celularesTxt, 'celulares_1.txt');
	Write('Ingrese el nombre del archivo a usar: ');
	Readln(nombre);
	Assign(celulares, nombre);
	rewrite(celularesTxt);
	reset(celulares);
	while(not eof(celulares))do begin
		Read(celulares, c);
		Writeln(celularesTxt, c.cod,' ',c.precio:2:2,' ',c.marca);
		Writeln(celularesTxt, c.stk,' ',c.stkMin,' ',c.desc);
		Writeln(celularesTxt, c.nombre);
	end;
	close(celularesTxt);
	close(celulares);
end;
procedure opcionE();
var
	celulares:archivoCelulares;
	c:celular;
begin
	assign(celulares, 'archivoDeCelulares');
	reset(celulares);
	LeerDatos(c);
	seek(celulares, filesize(celulares));
	while(c.cod <> -1)do begin
		write(celulares, c);
		LeerDatos(c);
	end;
	close(celulares);
end;
procedure opcionF();
var
	celulares:archivoCelulares;
	c:celular;
	nombre:string;
begin
	assign(celulares, 'archivoDeCelulares');
	reset(celulares);
	Write('Ingrese el nombre del celular que quiera actualizar: ');
	Readln(nombre);
	read(celulares, c);
	while((not eof(celulares))and(nombre <> c.nombre))do
		read(celulares, c);
	if(c.nombre = nombre)then begin
		Write('Ingrese la cantidad en stock nueva: ');
		readln(c.stk);
		seek(celulares, (filepos(celulares)-1));
		write(celulares, c);
	end;
	close(celulares);
end;
procedure opcionG();
var
	celulares:archivoCelulares;
	celularesStk0: textoCelulares;
	c:celular;
begin
	assign(celulares, 'archivoDeCelulares');
	assign(celularesStk0, 'SinStock.txt');
	reset(celulares);
	rewrite(celularesStk0);
	while(not eof(celulares))do begin
		read(celulares, c);
		if(c.stk = 0)then begin
			Writeln(celularesStk0, c.cod,' ', c.precio:2:2,' ', c.marca);
			Writeln(celularesStk0, c.stk,' ', c.stkMin,' ', c.desc);
			Writeln(celularesStk0, c.nombre);
		end;
	end;
	close(celulares);
	close(celularesStk0);
end;

var
	car: char;
BEGIN
	Writeln('Elija una de las siguientes opciones: ');
	Writeln('A - Crear un archivo de celulares. ');
	Writeln('B - Listar todos los celulares que tengan stock menor al stock minimo. ');
	Writeln('C - Listar todos los celulares con cierta descripcion. ');
	Writeln('D - Exportar el archivo previamente creado a un archivo de texto. ');
	Writeln('E - Agregar uno o mas celulares al archivo binario. ');
	Writeln('F - Modificar el stock de un celular dado. ');
	Writeln('G - Exportar los celulares sin stock a un archivo de texto. ');
	Readln(car);
	while((car <> 'A')and(car <> 'B')and(car <> 'C')and(car <> 'D')and(car <> 'E')and(car <> 'F')and(car <> 'G'))do begin
		Write('El caracter ingresado no es una opcion valida, ingrese otro caracter: ');
		Readln(car);
	end;
	if(car = 'A')then
		opcionA()
	else if(car = 'B')then
		opcionB()
	else if(car = 'C')then
		opcionC()
	else if(car = 'D')then
		opcionD()
	else if(car = 'E')then
		opcionE()
	else if(car = 'F')then
		opcionF()
	else if(car = 'G')then
		opcionG();
END.
