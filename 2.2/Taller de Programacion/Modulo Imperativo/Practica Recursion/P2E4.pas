program P2E4;
const
	dimF = 20;
type
	vector = array [1..dimF] of integer;

procedure CargarVector(var v:vector);
	procedure CargarVectorRecursivo(var v:vector; var dimL:integer);
	var
		num:integer;
	begin
		Writeln('Ingrese un numero: ');
		num:= random(99)+1;
		if(dimL < dimF)then begin
			dimL:= dimL + 1;
			v[dimL]:=num;
			CargarVectorRecursivo(v,dimL);
		end;
	end;
var
	dimL:integer;
begin
	dimL:= 0;
	CargarVectorRecursivo(v,dimL);
end;

procedure maximo(var max:integer; v:vector; pos:integer);
begin
	if(pos < dimF)then begin
		pos:= pos +1;
		if(max < v[pos])then
			max:= v[pos];
		maximo(max,v,pos);
	end;
end;

procedure suma(v:vector; pos:integer; var total:integer);
begin
	if(pos < dimF)then begin
		pos:= pos + 1;
		total:= total + v[pos];
		suma(v,pos,total)
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
	max,pos,total:integer;
	v:vector;

BEGIN
	max:= 0;
	pos:= 0;
	total:= 0;
	CargarVector(v);
	MostrarVector(v);
	maximo(max,v,pos);
	suma(v,pos,total);
	Writeln('El numero maximo es: ',max);
	Writeln('La suma de todos los numeros dan: ', total);
END.

