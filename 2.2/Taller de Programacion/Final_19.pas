program Final_19;
type
	producto = record
		cod:integer;
		cant:integer;
		cliente:integer;
	end;
	
	lista = ^nodo;
	nodo = record
		datos:producto;
		sig:lista;
	end;
	
	vector = array [1..5] of lista;
	
	info = record
		cod:integer;
		total:integer;
	end;
	lista2 = ^nodo2;
	nodo2 = record
		datos:info;
		sig:lista2;
	end;
	
	
	
procedure LeerDatos (var p:pedido);
begin
	Writeln('Ingrese el codigo de producto: ');
	readln(p.cod);
	if (p.cod <> -1) then begin
		Writeln('Ingrese la cantidad vendida: ');
		readln(p.cant);
		Writeln('Ingrese el codigo del cliente: ');
		readln(p.cliente);
	end;
end;
procedure insertarOrdenado(var l:lista; p:producto);
var
	act,ant,nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos:= p;
	act:= l;
	ant:= l;
	while ((act <> nil)and(act^.datos.cod < p.cod))do begin
		ant:= act;
		act:= act^.sig;
	end;
	if (act = ant)then
		l:= nuevo;
	else
		ant^.sig:= nuevo;
	nuevo^.sig:= act;
end;
procedure cargarVector (var v:vector);
var
	i,j:integer;
	p:producto;
begin
	for i:= 1 to 5 do
		v[i]:= nil;
	for j:= 1 to 5 do begin
		LeerDatos(p);
		while(p.cod <> -1)do begin
			insertarOrdenado(v[i],p);
			LeerDatos(p);
		end;
	end;
end;
procedure agregarAtras(var l,ult:lista2; cod,cant:integer);
var
	nuevo:lista2;
begin
	new(nuevo);
	nuevo^.datos.cod:= cod;
	nuevo^.datos.total:= cant;
	nuevo^.sig:= nil;
	if (l <> nil)then
		ult^.sig:= nuevo;
	else
		l:= nuevo;
	ult:= nuevo;
end;
procedure minimo(var v:vector; var codMin:integer; var cant:integer);
var
	i,indiceMin:integer;
begin
	codMin:= 999;
	for i:= 1 to 5 do
		if (v[i] <> nil) then
			if(v[i]^.datos.cod <= codMin)then begin
				indiceMin:= i;
				codMin:= v[i]^.datos.cod;
			end;
	if (codMin <> 999)then begin
		cant:= v[indiceMin]^.datos.cant;
		v[indiceMin]:= v[indiceMin]^.sig;
	end;
end;
procedure mergeAcumulador (v:vector; var nue:lista2);
var
	act,codMin:integer;
	cant,cantTotal:integer;
	ult:lista2;
begin
	nue:= nil;
	ult:= nil;
	minimo(v,codMin,cant)
	while(codMin <> 999)do begin
		act:= codMin;
		cantTotal:= 0;
		while((codMin <> 999)and(codMin = act))do begin
			cantTotal:= cantTotal + cant;
			minimo(v,codMin,cant);
		end;
		agregarAtras(nue,ult,act,cantTotal);
	end;
end;

procedure buscarMax (l:lista2; var cantMax,codMax:integer);
begin
	if (l = nil)then
		cantMax:= -1
	else begin
		buscarMax(l^.sig, cantMax, codMax);
		if(l^.datos.cant > cantMax)then begin
			codMax:= l^.datos.cod;
			cantMax:= l^.datos.cant;
		end;
	end;
end;

var
	vec:vector;
	list:lista2;
BEGIN
	cargarVector(vec);
	mergeAcumulador(vec,list);
	buscarMax(list);
END.

