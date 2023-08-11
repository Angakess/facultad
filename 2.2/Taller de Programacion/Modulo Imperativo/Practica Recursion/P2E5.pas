program P2E5;
const
	dimF = 11;
type
	indice=integer;
	
	vector= array [1..dimF]of integer;
	
{procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice); 
begin
	repeat
		pos:= ((fin - ini)DIV 2) + ini;
		
		if (dato < v[pos] )then
			fin:= pos - 1
		else
			ini:= pos + 1;
		Writeln('pos: ',pos);
		Writeln('ini: ',ini);
		Writeln('fin: ',fin);
		Writeln('---------------------------------')
	until(ini = fin)or(v[pos]=dato);
end;}

procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice); 
begin
	pos:= ((fin - ini)DIV 2) + ini;
	while((v[pos]<>dato)and(ini <= fin))do begin
		if (dato < v[pos] )then
			fin:= pos - 1
		else
			ini:= pos + 1;
		pos:= ((fin - ini)DIV 2) + ini;
	end;
	if(ini > fin)then
		pos:= -1;
end;

procedure CargarVector(var v:vector; var dimL:integer);
var
	i:integer;
begin
	dimL:= 0;
	for i:= 1 to dimF do begin
		dimL:=dimL + 1;
		Writeln('Ingrese el codigo de la oficina');
		//Readln(v[dimL]);
		v[dimL]:= random(200);
	end;
end;
procedure OrdenarInsercion (var v:vector; dl:integer);
var
	i,j,actual:integer;
	
begin
	for i:= 2 to dl do begin
		actual:= v[i];
		j:= i-1;
		while((j > 0)and(v[j] > actual))do begin
			v[j+1]:= v[j];
			j:= j - 1;
		end;
		v[j+1]:= actual;
	end;
end;
procedure MostrarVector (v: vector);
var
	i:integer;
begin
	Writeln('Contenido del vector: ');
	for i:= 1 to dimF do
		Writeln(v[i]);
end;
var
	vec:vector;
	diml,x:integer;
	inf,sup,pos:indice;
BEGIN
	CargarVector(vec,diml);
	OrdenarInsercion(vec,diml);
	MostrarVector(vec);
	inf:=1;
	sup:=dimF;
	Writeln('Parametro a buscar: ');
	Readln(x);
	busquedaDicotomica(vec,inf,sup,x,pos);
	Writeln('la posicion es: ',pos);
END.

