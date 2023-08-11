{
Un cine posee la lista de películas que proyectará durante el mes de octubre. De cada película se conoce: código de película, código de género (1: acción, 2: aventura, 3: drama, 
* 4: suspenso, 5: comedia, 6: bélica, 7: documental y 8: terror) y puntaje promedio otorgado por las críticas. Implementar un programa que contenga:
* 
-Un módulo que lea los datos de películas y los almacene ordenados por código de película y agrupados por código de género, en una estructura de datos adecuada. La lectura finaliza 
* cuando se lee el código de película -1. 
* 
-Un módulo que reciba la estructura generada en el punto a y retorne una estructura de datos donde estén todas las películas almacenadas ordenadas por código de película.

   
   
}

program P4E2;
const
	dimF = 8;
type
	genRango = 1..dimF;
	
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
	
	vectorGen = array [genRango] of lista;
	
procedure CargarVector(var v:vectorGen);
	procedure InicializarVector(var v:vectorGen);
	var
		i:genRango;
	begin
		for i:= 1 to dimF do
			v[i]:= NIL;
	end;
	procedure LeerPelicula(var x:info);
	begin
		Write('Ingrese el codigo de la pelicula: ');
		Readln(x.cod);
		if (x.cod <> -1)then begin
			Write('Ingrese el genero: ');
			Readln(x.gen);
			Writeln('Ingrese el puntaje promedio: ');
			Readln(x.punt);
		end;
	end;
	procedure InsertarElementoEnLista(var l:lista; dato:info);
	var 
		ant, nuevo, act: lista;
	begin
		new (nuevo);
		nuevo^.datos := dato;
		act := l;
		{Recorro mientras no se termine la lista y no encuentro la posición correcta}
		while (act <> NIL) and (act^.datos.cod < dato.cod) do begin
			ant := act;
			act := act^.sig ;
		end;
		if (act = l)  then 
			l:= nuevo   {el dato va al principio}
		else 
			ant^.sig  := nuevo; {va entre otros dos o al final}
		nuevo^.sig := act ;
	end;
var
	x:info;
begin
	InicializarVector(v);
	LeerPelicula(x);
	while(x.cod <> -1)do begin
		InsertarElementoEnLista(v[x.gen],x);
		LeerPelicula(x);
	end;
end;

procedure merge(var l:lista; v:vectorGen);
	procedure AgregarAtras(var l,ult:lista; dato:info);
	var
		nuevo:lista;
	begin 
		new (nuevo); nuevo^.datos:= dato; nuevo^.sig := nil;
		if (l = nil) then 
			l:= nuevo
		else 
			ult^.sig := nuevo;
		ult := nuevo;
	end;
	Procedure minimo (var v: vectorGen; var peliculaMin: info);
	var 
		indiceMin,i:genRango;
	Begin
		peliculaMin.cod:= 9999;
		for i:= 1 to dimF do begin
			if (v[i] <> nil) then 
				if (v [i]^.datos.cod <= peliculaMin.cod) then begin
					indiceMin:= i;
					peliculaMin:= v [i]^.datos;  
				end; 
		end;
		if (peliculaMin.cod <> 9999) then 
			v[indiceMin]:= v[indiceMin]^.sig;
	end;
var
	ult:lista;
	peliculaMin:info;
begin
	l:=nil;
	minimo(v,peliculaMin);
	while(peliculaMin.cod <> 9999)do begin
		AgregarAtras(l,ult,peliculaMin);
		minimo(v,peliculaMin);
	end;
end;

var
	vec:vectorGen;
	lis:lista;

BEGIN
	CargarVector(vec);
	merge(lis,vec);
END.

