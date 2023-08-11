program P1E2;
const
	dimF = 300;
type
	info = record
		cod:integer;
		dni:integer;
		valor:real;
	end;
	vector = array [1..dimF] of info;

procedure CargarVector(var v:vector; var dimL:integer);
var
	c:integer;
begin
	dimL:= 0;
	Writeln('Ingrese el codigo de la oficina');
	Readln(c);
	While((c <> -1)and(dimL < dimF))do begin
		dimL:=dimL + 1;
		v[dimL].cod:= c;
		Writeln('Ingrese el dni del propietario');
		Readln(v[dimL].dni);
		Writeln('Ingrese el valor de la expensa');
		Readln(v[dimL].valor);
		Writeln('Ingrese el codigo de la siguiente oficina');
		Readln(c);
	end;
end;

procedure OrdenarInsercion (var v:vector; dl:integer);
var
	i,j:integer;
	actual:info;
begin
	for i:= 2 to dl do begin
		actual:= v[i];
		j:= i-1;
		while((j > 0)and(v[j].cod > actual.cod))do begin
			v[j+1]:= v[j];
			j:= j - 1;
		end;
		v[j+1]:= actual;
	end;
end;

procedure OrdenarSeleccion(var v:vector; dl:integer);
var
	item:info;
	i,j,p:integer;
begin
	for i:= 1 to dl-1 do begin
		p:= i;
		for j:= i+1 to dl do
			if(v[j].cod < v[p].cod)then
				p:=j;
		item:= v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;

procedure MostrarVector (vector: vector; dL:integer);
var
	i:integer;
begin
	Writeln('Contenido del vector: ');
	for i:= 1 to dL do
		Writeln(vector[i].cod,' ',vector[i].dni,' ',vector[i].valor:2:2);
end;
var
	vec:vector;
	dimL,x:integer;
	
BEGIN
	CargarVector(vec,dimL);
	MostrarVector(vec,dimL);
	Writeln('1. Ordenar por insercion');
	Writeln('2. Ordenar por seleccion');
	Readln(x);
	if(x = 1)then
		OrdenarInsercion(vec,dimL)
	else if(x = 2)then
		OrdenarSeleccion(vec,dimL)
	else
		Writeln('No se eligio ninguna opcion disponible');
	MostrarVector(vec,dimL);
END.

