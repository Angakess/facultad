program P2E3;

type
	lista = ^nodo;
	nodo = record
		datos:integer;
		sig:lista;
	end;

procedure CargarLista(var l:lista);
	procedure AgregarAdelante(var li:lista; n:integer);
	var
		nuevo:lista;
	begin
		new(nuevo);
		nuevo^.datos:= n;
		nuevo^.sig:= li;
		li:= nuevo;
	end;
var
	num:integer;
begin
	writeln('Ingrese un numero: ');
	//Readln(num);
	num:= random(100);
	if(num <> 0)then begin
		if((num < 100)and(num > 0))then begin
			AgregarAdelante(l,num);
			CargarLista(l);
		end
		else
			writeln('No se puede ingresar numeros fuera del rango');
	end
end;

procedure minimo(l:lista; var min:integer);
begin
	if(l<>NIL)then begin
		if(min > l^.datos)then
			min:= l^.datos;
		l:=l^.sig;
		minimo(l,min);
	end
end;

procedure maximo(l:lista; var max:integer);
begin
	if(l<>NIL)then begin
		if(max < l^.datos)then
			max:= l^.datos;
		maximo(l^.sig,max);
	end
end;

function exito (l:lista; x:integer):boolean;
begin
	exito:= false;
	if(l<>NIL) then begin
		if(l^.datos = x)then
			exito:= true
		else
			exito:=exito(l^.sig, x);
	end;
end;

procedure MostrarLista (l:lista);
begin
	Writeln('La lista contiene: ');
	while(l<>NIL)do begin
		Writeln(l^.datos);
		l:=l^.sig;
	end;
end;

var
	l:lista;
	max,min,x:integer;
BEGIN
	CargarLista(l);
	MostrarLista(l);
	max:= -1;
	min:= 100;
	maximo(l,max);
	minimo(l,min);
	Writeln('El minimo es: ',min);
	Writeln('El maximo es: ',max);
	Writeln('Ingrese un numero para buscar: ');
	Readln(x);
	if(exito(l,x))then
		Writeln('Se encontro el numero ',x,' en la lista')
	else
		Writeln('No se encontro el numero');
	
END.

