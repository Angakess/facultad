program Practica2Ej9;
const
	valorAlto = 9999;
type
	mesa = record
		prov:integer;
		loc:integer;
		num:integer;
		votos:integer;
	end;
	
	archivoMesas = file of mesa;

procedure leer(var reg:archivoMesas; var dato:mesa);
begin
	if(not eof(reg))then
		read(reg, dato)
	else
		dato.num:= valorAlto;
end;
procedure leerDatos(var m:mesa);
begin
	Write('Mesa: ');
	readln(m.num);
	if(m.num <> -1)then begin
		Write('Provincia: ');
		readln(m.prov);
		Write('Localidad: ');
		readln(m.loc);
		Write('Cantidad de votos: ');
		readln(m.votos);
	end;
end;
procedure crearArchivo(var mae:archivoMesas);
var
	m:mesa;
begin
	rewrite(mae);
	leerDatos(m);
	while(m.num <> -1)do begin
		write(mae, m);
		leerDatos(m);
	end;
	close(mae);
end;
procedure imprimirVotos(var mae:archivoMesas);
var
	dato:mesa;
	total,totalLoc,totalProv:integer;
	provAct,locAct:integer;
begin
	reset(mae);
	leer(mae,dato);
	total:= 0;
	while(dato.num <> valorAlto)do begin
		totalProv:= 0;
		provAct:= dato.prov;
		Writeln('Provincia: ',provAct);
		while((dato.num <> valorAlto)and(provAct = dato.prov))do begin
			totalLoc:= 0;
			locAct:= dato.loc;
			write('Localidad ',locAct,'		');
			while((dato.num <> valorAlto)and(locAct = dato.loc))do begin
				totalLoc:= totalLoc + dato.votos;
				leer(mae,dato);
			end;
			Writeln('Votos: ',totalLoc);
			totalProv:= totalProv + totalLoc;
		end;
		writeln('Total de votos provincia: ',totalProv);
		total:= total + totalProv;
	end;
	Writeln('Total General de votos: ',total);
	close(mae);
end;

var
	mae:archivoMesas;
	i:integer;
BEGIN
	assign(mae,'MesasP2E9');
	writeln('Crear (1) o imprimir (2):');
	readln(i);
	if(i = 1)then
		crearArchivo(mae)
	else
		imprimirVotos(mae);
END.

