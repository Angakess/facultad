program P1E1;
const
	dimF = 20;
type
	codRango = 0..15;
	cantVRango = 1..99;

	venta = record
		codigo: codRango;
		cantV: cantVRango;
	end;
	
	vVenta = array [1..dimF] of venta;
	
	lista = ^nodo;
	nodo = record
		datos: venta;
		sig: lista;
	end;

procedure CargarVector (var vV:vVenta; var dL:integer);
var
	i:integer;
	cod:codRango;
begin
	i:= 1;
	dL:= 0;
	Writeln('Ingrese el codigo de la venta ',i);
	Readln(cod);
	while((cod <> 0)and(dL < dimF))do begin
		dL:= dL + 1;
		vV[dL].codigo:= cod;
		Writeln('Ingrese la cantidad vendida ');
		Readln(vV[dL].cantV);
		
		i:= i + 1;
		Writeln('Ingrese el codigo de la venta ',i);
		Readln(cod);
	end;
end;
	
procedure MostrarVector (vector: vVenta; dL:integer);
var
	i:integer;
begin
	Writeln('Contenido del vector: ');
	for i:= 1 to dL do
		Writeln(vector[i].codigo,' ',vector[i].cantV);
end;

procedure OrdenarVector (var vector: vVenta; dL:integer);
var
	i,p,j: integer;
	dato: venta;
begin
	for i:=1 to dL - 1 do begin
		p:=i;
		for j:=i+1 to dL do
			if vector[j].codigo < vector[p].codigo then
				p:=j;
		dato:= vector[p];
		vector[p]:= vector[i];
		vector[i]:= dato;
	end;
end;

procedure EliminarElemento(var v:vVenta;var dL:integer; p1,p2:integer);
var
	pos,codx,i:integer;
begin
	pos:= 1;
	codx:= p1 * p2;
	while ((pos <= dL) and (v[pos].codigo <= codx)) do begin
		if(codx = v[pos].codigo)then begin
			for i:= pos + 1 to dL do
				v[i - 1] := v[i];
			dL:= dL - 1;
		end
		else
			pos:= pos + 1;
	end;
end;

procedure AgregarAlFinal(var pri, ult:lista; venta:venta);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos:=venta;
	nuevo^.sig:= NIL;
	if (pri <> NIL)then
		ult^.sig:= nuevo
	else
		pri:= nuevo;
	ult:= nuevo;
end;
procedure ListaOrdenada(var l:lista; v:vVenta; dl:integer);
var
	i:integer;
	Ult:lista;
begin
	l:=NIL;
	Ult:= NIL;
	for i:= 1 to dl do
		if(v[i].codigo MOD 2 = 0)then
			AgregarAlFinal(l,Ult,v[i]);
end;

procedure MostrarLista (l:lista);
begin
	Writeln('La lista contiene: ');
	while(l<>NIL)do begin
		Writeln(l^.datos.codigo,' ', l^.datos.cantV);
		l:=l^.sig;
	end;
end;
var 
	vectorVenta : vVenta;
	dimL,par1,par2: integer;
	l:lista;
BEGIN
	CargarVector(vectorVenta,dimL);
	MostrarVector(vectorVenta,dimL);
	OrdenarVector(vectorVenta,dimL);
	MostrarVector(vectorVenta,dimL);
	Writeln('Ingrese el primer parametro: ');
	Readln(par1);
	Writeln('Ingrese el segundo parametro: ');
	Readln(par2);
	EliminarElemento(vectorVenta,dimL,par1,par2);
	MostrarVector(vectorVenta,dimL);
	ListaOrdenada(l,vectorVenta,dimL);
	MostrarLista(l);
END.

