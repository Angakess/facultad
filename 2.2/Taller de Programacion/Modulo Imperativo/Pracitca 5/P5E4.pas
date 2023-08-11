{
   4.- Un teatro tiene funciones los 7 días de la semana. Para cada día se tiene una lista con las entradas vendidas. 
	Se desea procesar la información de una semana. Se pide:

	-	Generar 7 listas con las entradas vendidas para cada día. De cada entrada se lee día (de 1 a 7), código de la obra, asiento, monto. La lectura finaliza con el código de obra
		igual a 0. Las listas deben estar ordenadas por código de obra de forma ascendente.
		
	-	Generar una nueva lista que totalice la cantidad de entradas vendidas por obra. Esta lista debe estar ordenada por código de obra de forma ascendente.
	
	-	Realice un módulo recursivo que informe el contenido de la lista generada en b)
   
}
program P5E4;
const
	dimF = 7;
type
	rangoDia = 1..dimF;
	info = record
		cod:integer;
		dia:rangoDia;
		asiento:integer;
		monto:real;
	end;
	entrada = record
		cod:integer;
		asiento:integer;
		monto:real;
	end;
	listaE = ^nodoE;
	nodoE = record
		datos:entrada;
		sig:listaE;
	end;
	venta = record
		cod:integer;
		cant:integer;
	end;
	listaV = ^nodoV;
	nodoV = record
		datos:venta;
		sig:listaV;
	end;
	vListas = array [rangoDia] of listaE;

procedure CargarVector(var v:vListas);
	procedure InicializarVector(var v:vListas);
	var
		i:rangoDia;
	begin
		for i:= 1 to dimF do
			v[i]:= nil;
	end;
	procedure LeerDatos(var x:info);
	begin
		Write('Ingrese el codigo de la obra: ');
		Readln(x.cod);
		if(x.cod <> 0)then begin
			x.dia:= random(6)+1;
			Writeln('Ingrese el dia de la obra: ',x.dia);
			x.asiento:= random(100)+1;
			Writeln('Ingrese el asiento: ',x.asiento);
			x.monto:= random(500)+1;
			Writeln('Ingrese el monto: ',x.monto:2:2);
		end;
	end;
	procedure ArmarEntrada(x:info; var e:entrada);
	begin
		e.cod:= x.cod;
		e.asiento:= x.asiento;
		e.monto:= x.monto;
	end;
	procedure InsertarElemento(var l:listaE; e:entrada);
	var
		ant,nuevo,act:listaE;
	begin
		new(nuevo);
		nuevo^.datos:= e;
		act:= l;
		while((act <> nil)and(act^.datos.cod < e.cod))do begin
			ant:= act;
			act:= act^.sig;
		end;
		if(act = l)then
			l:= nuevo
		else
			ant^.sig:= nuevo;
		nuevo^.sig:= act;
	end;
var
	x:info;
	e:entrada;
begin
	InicializarVector(v);
	LeerDatos(x);
	Writeln('');
	while(x.cod <> 0)do begin
		ArmarEntrada(x,e);
		InsertarElemento(v[x.dia],e);
		LeerDatos(x);
		Writeln('');
	end;
end;

procedure MergeAcumulador(v:vListas; var l:listaV);
	procedure Minimo(var v:vListas; var min:integer);
	var
		indiceMin,i:integer;
	begin
		min:= 9999;
		for i:= 1 to dimF do begin
			if(v[i] <> nil)then
				if(v[i]^.datos.cod <= min)then begin
					min:= v[i]^.datos.cod;
					indiceMin:= i;
				end;
		end;
		if (min <> 9999)then
			v[indiceMin]:= v[indiceMin]^.sig;
	end;
	procedure AgregarAtras(var l,ult:listaV; vt:venta);
	var
		nuevo:listaV;
	begin
		new(nuevo);
		nuevo^.datos:= vt;
		nuevo^.sig:= nil;
		if (l = nil)then
			l:= nuevo
		else
			ult^.sig:= nuevo;
		ult:= nuevo;
	end;
var
	min:integer;
	ult:listaV;
	actual:venta;
begin
	l:= nil;
	Minimo(v,min);
	while(min <> 9999)do begin
		actual.cod:= min;
		actual.cant:= 0;
		while(actual.cod = min)do begin
			actual.cant:= actual.cant + 1;
			Minimo(v,min)
		end;
		AgregarAtras(l,ult,actual);
	end;
end;

procedure imprimirListaRecursiva(l:listaV);
begin
	if (l <> nil)then begin
		writeln('codigo: ',l^.datos.cod,'	cantidad vendida en total: ',l^.datos.cant);
		imprimirListaRecursiva(l^.sig);
	end;
	Writeln('');
end;

procedure imprimirVector(v:vListas);
var
	i:integer;
begin
	for i:= 1 to dimF do begin
		if(v[i]<>nil)then
			while(v[i]<>nil)do begin
				Writeln(i,')	codigo: ',v[i]^.datos.cod,'	asiento: ',v[i]^.datos.asiento,'	monto: ',v[i]^.datos.monto:2:2);
				v[i]:= v[i]^.sig;
			end
		else
			Writeln('El dia ',i,' no vendio entradas');
		Writeln('-----------------------------------------------------------------------------------------------------------------');
	end;
	Writeln('');
end;

var
	LV:listaV;
	vecL:vListas;

BEGIN
	CargarVector(vecL);
	imprimirVector(vecL);
	MergeAcumulador(vecL,LV);
	imprimirListaRecursiva(LV);
END.

