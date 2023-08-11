program Practica2Ej4;
const
	valorAlto = 9999;
	dimF = 5;
type
	sesion = record
		cod:integer;
		fecha:integer;
		tiempo:integer;
	end;
	
	maestro = file of sesion;
	detalle = file of sesion;
	
	arrDetalles = array[1..dimF] of detalle;
	regDetalles = array[1..dimF] of sesion;

procedure leer(var regD:detalle; var dato:sesion);
begin
	if(not eof(regD))then
		read(regD,dato)
	else
		dato.cod:= valorAlto;
end;
procedure leerDatos(var reg:sesion);
begin
	Write('Ingrese el codigo del usuario: ');
	readln(reg.cod);
	if(reg.cod <> -1)then begin
		Write('Ingrese la fecha: ');
		readln(reg.fecha);
		reg.tiempo:= 5;
		Write('Ingrese el tiempo de la sesion: ',reg.tiempo);
		//readln(reg.tiempo);
		
		Writeln('');
	end;
end;
procedure crearDetalles(var d:arrDetalles);
var
	i:integer;
	regD:sesion;
begin
	for i:= 1 to dimF do begin
		rewrite(d[i]);
		Writeln('Ingrese los datos de la computadora ',i);
		leerDatos(regD);
		while(regD.cod <> -1)do begin
			write(d[i], regD);
			leerDatos(regD);
		end;
		close(d[i]);
	end;
end;
procedure minimos(var d:arrDetalles; var regD:regDetalles; var min:sesion);
var
	i,iMin:integer;
begin
	min.cod:= valorAlto;
	min.fecha:= valorAlto;
	for i:= 1 to dimF do begin
		if(min.cod > regD[i].cod)then begin
			if(min.fecha > regD[i].fecha)then begin
				min:= regD[i];
				iMin:= i;
			end;
		end;
	end;
	if(min.cod <> valorAlto)then
		leer(d[iMin], regD[iMin]);
end;
procedure crearMaestro(var d:arrDetalles; var mae:maestro);
var
	min,regM:sesion;
	regD:regDetalles;
	i:integer;
begin
	rewrite(mae);
	for i:= 1 to dimF do begin
		reset(d[i]);
		leer(d[i], regD[i]);
	end;
	minimos(d,regD,min);
	while(min.cod <> valorAlto)do begin
		regM:= min;
		regM.tiempo:= 0;
		while(min.fecha = regM.fecha)do begin
			regM.tiempo:= regM.tiempo + min.tiempo;
			minimos(d,regD,min);
		end;
		write(mae,regM);
	end;
	close(mae);
	for i:= 1 to dimF do begin
		close(d[i]);
	end;
end;
procedure imprimirArchivo(var mae:maestro);
var
	regM:sesion;
begin
	reset(mae);
	while(not eof(mae))do begin
		read(mae,regM);
		Writeln('Codigo de usuario: ',regM.cod);
		Writeln('Fecha: ',regM.fecha);
		Writeln('Tiempo total: ',regM.tiempo);
		Writeln('');
	end;
	close(mae);
end;
var
	mae:maestro;
	det:arrDetalles;
	aux,s:string;
	i:integer;
	opcion:char;
BEGIN
	aux:= 'asdf';
	assign(mae,'archivoDeSesionesEJ4');
	for i:= 1 to dimF do begin
		Str(i,s);
		aux:= aux +'_'+ s;
		assign(det[i], aux);
	end;
	(*
	assign(det[1], 'archivoDeCompuEJ4(1)');
	assign(det[2], 'archivoDeCompuEJ4(2)');
	assign(det[3], 'archivoDeCompuEJ4(3)');
	assign(det[4], 'archivoDeCompuEJ4(4)');
	assign(det[5], 'archivoDeCompuEJ4(5)');
	*)
	Writeln('Elija una de las siguientes opciones:');
	Writeln('A- Crear archivos detalle.');
	Writeln('B- Crear archivo maestro.');
	writeln('C- imprimir el archivo maestro');
	readln(opcion);
	while((opcion<>'A')and(opcion<>'B')and(opcion<>'C'))do begin
		writeln('No ingreso una opcion valida, vueva a intentar.');
		readln(opcion);
	end;
	if(opcion='A')then
		crearDetalles(det)
	else if(opcion='B')then
		crearMaestro(det,mae)
	else
		imprimirArchivo(mae);
END.

