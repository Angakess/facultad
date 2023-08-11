program Algoritmos;

procedure agregarAdelante(var l:lista; x:tipo);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos:= x;
	nuevo^.sig:= l;
	l:= nuevo;
end;

procedure agregarAtras(var l,ult:lista; x:tipo);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos:= x;
	if(l = nil)then
		l:= nuevo;
	else
		ult^.sig:= nuevo;
	ult:= nuevo;
end;

procedure agregarOrdenado(var l:lista; x:tipo);
var
	ant,act,nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos:= x;
	act:=l;
	ant:=l;
	while((act <> nil)and(act^.datos < x))do begin
		ant:= act;
		act:= act^.sig;
	end;
	if(act = ant)then
		l:= nuevo;
	else
		ant^.sig:= nuevo;
	nuevo^.sig:= act;
end;

procedure ordenarSeleccion(var v:vector; dimL:integer);
var
	i,j,aux:integer;
	x:tipo;
begin
	for i:= 1 to dimL-1 do begin
		aux:= i;
		for j:= i+1 to dimL do
			if(v[j] < v[aux])then
				aux:= j;
		x:= v[aux];
		v[aux]:= v[i];
		v[i]:= x;
	end;
end;

procedure ordenarInsercion(var v:vector; dimL:integer);
var
	i,j,aux:integer;
begin
	for i:= 2 to dimL do begin
		aux:= v[i];
		j:= i-1;
		while((j > 0)and(v[j] > aux))do begin
			v[j+1]:= v[j];
			j:= j-1;
		end;
		v[j+1]:= aux;
	end;
end;

procedure crearArbol(var a:arbol; x:tipo);
begin
	if(a = nil)then begin
		new(a);
		a^.datos:= x;
		a^.HI:= nil;
		a^.HD:= nil;
	end
	else
		if(x > a^.datos)then
			crearArbol(a^.HD, x);
		else
			crearArbol(a^.HI, x);
end;

function buscarArbol(a:arbol; x:tipo):arbol;
begin
	if(a = nil) then
		buscarArbol:= nil;
	else if(x = a^.datos)then
		buscarArbol:= a;
	else 
		if(x > a^.datos)then
			buscarArbol:= buscarArbol(a^.HD, x);
		else
			buscarArbol:= buscarArbol(a^.HI, x);
end;

procedure minimoMergeDosListas(var l1,l2:lista; var xM:tipo);
begin
	xM:= 9999;
	if((l1 <> nil)and(l2 <> nil))then begin
		if(l1^.datos < l2^.datos)then begin
			xM:= l1^.datos;
			l1:= l1^.sig;
		end;
		else
			xM:= l2^.datos;
			l2:= l2^.sig;
	end
	else if((l1 <> nil)and(l2 = nil))then begin
			xM:= l1^.datos;
			l1:= l1^.sig;
	end
	else if ((l1 = nil)and(l2 <> nil))then begin
		xM:= l2^.datos;
		l2:= l2^.sig;
	end;
end;
procedure merge(l1,l2:lista; var lNuevo:lista);
var
	xMin:tipo;
	ult:lista;
begin
	lNuevo:= nil;
	minimo(l1,l2,xMin);
	while(xMin <> 9999)do begin
		agregarAtras(lNuevo,ult,xMin);
		minimo(l1,l2,xMin);
	end;
end;

procedure minimoVariasListas(var v:vectorL; var xM:tipo);
var
	i,iMin:integer;
begin
	xM:= 9999;
	for i:= 1 to cantListas do begin
		if(v[i].datos < xM)then begin
			iMin:= i;
			xM:= v[i].datos;
		end;
	end;
	if(xM <> 9999)then
		v[iMin]:= v[iMin]^.sig;
end;
procedure merge(v:vectorL; var lNuevo:lista);
var
	xMin:tipo;
	ult:lista;
begin
	lNuevo:= nil;
	minimo(v,xMin);
	while(xMin <> 9999)do begin
		agregarAtras(lNuevo,ult,xMin);
		minimo(v,xMin);
	end;
end;

procedure minimoAcumulador(var v:vectorL; var xM:tipo; var cant:integer);
var
	i,iMin:integer;
begin
	xM:= 9999;
	for i:= 1 to cantListas do begin
		if(v[i].datos.x < xM)then
			iMin:= i;
			xM:= v[i].datos.x;
	end;
	if(xM <> 9999)then begin
		cant:= v[iMin].datos.cant;
		v[iMin]:= v[iMin]^.sig;
	end;
end;
procedure mergeAcumulador(v:vectorL; var lNuevo:lista2);
var
	act,xMin:tipo;
	cant,total:integer;
	ult:lista2;
begin
	lNuevo:= nil;
	minimo(v,xMin,cant);
	while(xMin <> 9999)do begin
		act:= xMin;
		total:= 0;
		while((xMin <> 9999)and(xMin = act))do begin
			total:= total + cant;
			minimo(v,xMin,cant);
		end;
		agregarAtras(lNuevo,ult,total);
	end;
end;

procedure cargarVector(var v:vector; var dimL:integer);
var
	x:tipo;
begin
	dimL:= 0;
	LeerDatos(x);
	while((x <> -1)and(dimL < dimF))do begin
		dimL:= dimL + 1;
		v[dimL]:= x;
		LeerDatos(x);
	end;
end;

var i : byte;

BEGIN
	
	
END.

