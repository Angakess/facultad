program P1E;
type
	genRango = 1..8;
	
	info = record
		cod:integer;
		gen:genRango;
		punt:real;
	end;
	
	lista = ^nodo;
	nodo = record
		datos:info;
		sig:lista;
	end;
	
	vGeneros = array [genRango] of info;
	
procedure AgregarAlFinal(var pri, ult:lista; inf:info);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos:=inf;
	nuevo^.sig:= NIL;
	if (pri <> NIL)then
		ult^.sig:= nuevo
	else
		pri:= nuevo;
	ult:= nuevo;
end;
procedure CargarLista(var l:lista);
var
	a:info;
	Ult:lista;
begin
	l:=NIL;
	Ult:= NIL;
	Writeln('Ingrese el codigo de la pelicula');
	Readln(a.cod);
	While (a.cod <> -1)do begin
		Writeln('Ingrese el genero (1 a 8)');
		Readln(a.gen);
		Writeln('Ingrese el puntaje promedio otorgado');
		Readln(a.punt);
		
		AgregarAlFinal(l,Ult,a);
		
		Writeln('Ingrese el codigo de la siguiente pelicula');
		Readln(a.cod);
	end;
end;

procedure CargarVector(var v:vGeneros; l:lista);
var
	i:integer;
begin
	for i:= 1 to 8 do //Inicializa vector
		v[i].punt:= 0;
	while(l<>nil)do begin
		if(l^.datos.punt > v[l^.datos.gen].punt)then begin
			v[l^.datos.gen].cod:= l^.datos.cod;
			v[l^.datos.gen].punt:= l^.datos.punt;
		end;
		l:= l^.sig;
	end;
end;

procedure OrdenarVector (var v: vGeneros);
var
	i,p,j: integer;
	dato: info;
begin
	for i:=1 to 7 do begin
		p:=i;
		for j:=i+1 to 8 do
			if v[j].punt < v[p].punt then
				p:=j;
		dato:= v[p];
		v[p]:= v[i];
		v[i]:= dato;
	end;
end;
procedure MostrarVector (vector: vGeneros);
var
	i:integer;
begin
	Writeln('Contenido del vector: ');
	for i:= 1 to 8 do
		Writeln(vector[i].cod,' ',vector[i].punt:2:2);
end;

var
	l:lista;
	vect:vGeneros;
BEGIN
	CargarLista(l);
	CargarVector(vect,l);
	MostrarVector(vect);
	OrdenarVector(vect);
	MostrarVector(vect);
	Writeln('El codigo con mayor puntaje es: ',vect[8].cod);
	Writeln('El codigo con menor puntaje es: ',vect[1].cod);
END.

