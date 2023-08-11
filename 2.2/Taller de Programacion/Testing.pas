program Testing;
type
	
	lista = ^nodo;
	nodo = record
		dato:integer;
		sig:lista;
	end;
	
procedure agregarOrdenado(var l:lista; x:integer);
var
	act,ant,nuevo:lista;
begin
	new(nuevo);
	nuevo^.dato:= x;
	act:= l;
	ant:= l;
	while((act <> nil)and(act^.dato < x))do begin
		ant:= act;
		act:= act^.sig;
	end;
	if(act = ant)then
		l:= nuevo
	else
		ant^.sig:= nuevo;
	nuevo^.sig:= act;
end;
procedure cargarLista(var l:lista);
var
	x:integer;
begin
	l:=nil;
	Write('Ingrese numeros: ');
	readln(x);
	while(x<>0)do begin
		agregarOrdenado(l,x);
		readln(x);
	end;
end;
procedure imprimirLista(l:lista);
begin
	while(l<>nil)do begin
		Writeln(l^.dato);
		l:= l^.sig;
	end;
end;
procedure imprimirRecursivo(l:lista);
begin
	if(l <> nil)then begin
		imprimirRecursivo(l^.sig);
		Writeln(l^.dato);
	end;
end;

var
	lst:lista;

BEGIN
	cargarLista(lst);
	Writeln('');
	imprimirLista(lst);
	Writeln('+++++++++++++++++++++++++++++++++++++++++++++++++++++');
	imprimirRecursivo(lst);
	Writeln('+++++++++++++++++++++++++++++++++++++++++++++++++++++');
END.

