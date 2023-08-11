program PracticaEJ2;
type
	archEnteros = file of integer;
	
	

var
	Enteros: archEnteros;
	nombre:string;
	num:integer;
	cant:integer;
	prom:real;

BEGIN
	Write('Ingrese el nombre del archivo: ');
	readln(nombre);
	Assign(Enteros,nombre);
	cant:= 0;
	prom:= 0;
	reset(Enteros);
	while not eof(Enteros)do begin
		read(Enteros,num);
		Writeln(num);
		if(num < 1500)then
			cant:= cant + 1;
		prom:= prom + num;
	end;
	prom:= (prom / filesize(Enteros));
	Writeln('El promedio de los numeros es: ',prom:2:2);
	Writeln('Hay ',cant,' numeros menores de 1500');
	
	close(Enteros);
END.

