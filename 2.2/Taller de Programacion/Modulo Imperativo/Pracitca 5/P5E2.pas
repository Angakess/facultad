{
   2.- Una agencia dedicada a la venta de autos ha organizado su stock y, dispone en papel de la información de los autos en venta.
	Implementar un programa que:

	-	Genere un árbol binario de búsqueda ordenado por patente identificatoria del auto en venta. Cada nodo del árbol debe contener patente, año de fabricación (2010..2018), la 
		marca y el modelo.
		
	-	Invoque a un módulo que reciba el árbol generado en a) y una marca y retorne la cantidad de autos de dicha marca que posee la agencia. Mostrar el resultado. 
	
	-	Invoque a un módulo que reciba el árbol generado en a) y retorne una estructura con la información de los autos agrupados por año de fabricación.
	
	-	Contenga un módulo que reciba el árbol generado en a) y una patente y devuelva el año de fabricación del auto con dicha patente. Mostrar el resultado. 

   
   
}


program P5E2;
type
	rangoAnio = 2010..2018;
	
	info = record
		pat:string;
		anio:rangoAnio;
		marca:string;
		modelo:string;
	end;
	
	arbol = ^nodoA;
	nodoA = record
		datos:info;
		HD:arbol;
		HI:arbol;
	end;
	
	lista = ^nodoL;
	nodoL = record
		datos:info;
		sig:lista;
	end;
	
procedure CargarArbol(var a:arbol);
	procedure LeerDatos(var x:info);
	begin
		Write('Ingrese la patente del auto: ');
		Readln(x.pat);
		if(x.pat <> '-1')then begin
			{Write('Ingrese el anio de fabricacion: ');
			Readln(x.anio);}
			x.anio:= random(9) + 2010;
			Writeln('Ingrese el anio de fabricacion: ', x.anio);
			Write('Ingrese la marca: ');
			//Readln(x.marca);
			x.marca:= chr(random(57)+64);
			Writeln(x.marca);
			Write('Ingrese el modelo: ');
			//Readln(x.modelo);
			x.modelo:= chr(random(57)+64);
			Writeln(x.modelo);
			Writeln('');
		end;
	end;
	procedure AgregarNodo(var a:arbol; x:info);
	begin
		if(a = nil)then begin
			new(a);
			a^.datos:= x;
			a^.HD:=nil;
			a^.HI:=nil;
		end
		else if(x.pat < a^.datos.pat)then
			AgregarNodo(a^.HI,x)
		else
			AgregarNodo(a^.HD,x);
	end;
var
	aux:info;
begin
	a:=nil;
	LeerDatos(aux);
	while(aux.pat <> '-1')do begin
		AgregarNodo(a,aux);
		LeerDatos(aux);
	end;
end;

procedure InformarCantMarca(a:arbol);
	procedure contarMarca(a:arbol; mar:string; var cant:integer);
	begin
		if(a <> nil)then begin
			if(mar = a^.datos.marca)then
				cant:= cant + 1;
			contarMarca(a^.HI, mar, cant);
			contarMarca(a^.HD, mar, cant);
		end;
	end;
var
	aux:string;
	cant:integer;
begin
	cant:= 0;
	Write('Ingrese la marca que quiera contar: ');
	Readln(aux);
	Writeln('');
	contarMarca(a,aux,cant);
	Writeln('Se encontraron ',cant,' autos de esa marca');
	Writeln('');
end;

procedure CargarListaOrdenada (a:arbol; var l:lista);
	procedure InsertarOrdenado(var l:lista; x:info);
	var
		ant,act,nuevo:lista;
	begin
		new(nuevo);
		nuevo^.datos:= x;
		act:= l;
		while((act <> nil)and(act^.datos.anio < x.anio))do begin
			ant:= act;
			act:= act^.sig;
		end;
		if(act = l)then
			l:= nuevo
		else
			ant^.sig:= nuevo;
		nuevo^.sig:= act;
	end;
	procedure RecorrerArbolInfo(a:arbol; var l:lista);
	begin
		if(a <> nil)then begin
			InsertarOrdenado(l, a^.datos);
			RecorrerArbolInfo(a^.HI, l);
			RecorrerArbolInfo(a^.HD, l);
		end;
	end;
begin
	l:=nil;
	RecorrerArbolInfo(a,l);
end;

procedure InformarAnioDelAuto(a:arbol; var anio:integer);
	{
	function RecorrerArbolAnio(a:arbol; patente:string):integer;			NO FUNCIONA!!! HACELO CON UN PROCESO
	begin
		if(a <> nil)then begin
			if(a^.datos.pat = patente)then
				RecorrerArbolAnio:= a^.datos.anio
			else begin
				RecorrerArbolAnio:= -1;
				RecorrerArbolAnio:= RecorrerArbolAnio(a^.HI,patente);
				RecorrerArbolAnio:= RecorrerArbolAnio(a^.HD,patente);
			end;
		end;
	end;}
var
	patente:string;
begin
	Write('Ingrese una patente para buscar: ');
	Readln(patente);
	Writeln('');
	if(RecorrerArbolAnio(a,patente) <> -1)then begin
		anio:= RecorrerArbolAnio(a,patente);
		Writeln('El anio del auto ingresado es: ',RecorrerArbolAnio(a,patente));
	end
	else
		Writeln('No se encontro la patente ingresada...');
end;

procedure imprimirLista(l: lista);
  begin
     if (l <> nil) then 
     begin
        writeln('      patente: ', l^.datos.pat, '  anio de fabricacion: ', l^.datos.anio,'	marca: ',l^.datos.marca,'	modelo: ',l^.datos.modelo);
        imprimirLista (l^.sig);
     end;
  end;

procedure imprimirArbol(a:arbol);
begin
	if(a <> nil)then begin
		imprimirArbol(a^.HI);
		Writeln('	patente: ', a^.datos.pat, '  anio de fabricacion: ', a^.datos.anio,'	marca: ',a^.datos.marca,'	modelo: ',a^.datos.modelo);
		imprimirArbol(a^.HD);
	end;
end;


var
	A:arbol; L:lista;
	anio:integer;
BEGIN
	CargarArbol(A);
	if(A <> NIL)THEN BEGIN
		Writeln('ARBOL: ');
		imprimirArbol(A);
		Writeln('--------------------------------------------------------');
	END
	ELSE
		Writeln('El arbol esta vacio');
	InformarCantMarca(A);
	CargarListaOrdenada(A,L);
	if(L <> NIL)THEN BEGIN
		Writeln('LISTA: ');
		imprimirLista(L);
		Writeln('--------------------------------------------------------');
	END
	ELSE
		Writeln('La lista esta vacia');
	InformarAnioDelAuto(A,anio);
END.

