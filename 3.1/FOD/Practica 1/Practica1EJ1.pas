program Practica1EJ1;
type
	archivoEnteros = file of integer;
	
	
var
	Enteros: archivoEnteros;
	num: integer;
	nombre:string;

BEGIN
	Write('Ingrese el nombre del archivo: ');
	readln(nombre);
	
	assign(Enteros, nombre);
	
	rewrite(Enteros);
	writeln('Ingrese el numero a ingresar: ');
	readln(num);
	while(num <> 30000)do begin
		write(Enteros, num);
		writeln('Ingrese el numero a ingresar: ');
		readln(num);
	end;
	close(Enteros);
END.

