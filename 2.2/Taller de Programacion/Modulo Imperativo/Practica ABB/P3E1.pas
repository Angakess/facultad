{
   Escribir un programa que:
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol binario de búsqueda. De cada socio se lee número de socio, nombre y edad. 
* La lectura finaliza con el número de socio 0 y el árbol debe quedar ordenado por número de socio.
* 
b. Una vez generado el árbol, realice módulos independientes que reciban el árbol como parámetro y que : 
i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que retorne dicho valor.
ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un módulo recursivo que retorne dicho socio.
iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que retorne dicho valor.
iv. Aumente en 1 la edad de todos los socios.
v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a un módulo recursivo que reciba el valor leído y retorne verdadero o 
* falso.
vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o 
* falso.
vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo que retorne dicha cantidad.
viii. Informe el promedio de edad de los socios. Debe invocar al módulo recursivo del inciso vii e invocar a un módulo recursivo que retorne la suma de las edades 
* de los socios.
ix. Informe, a partir de dos valores que se leen, la cantidad de socios en el árbol cuyo número de socio se encuentra entre los dos valores ingresados. Debe invocar
*  a un módulo recursivo
*  que reciba los dos valores leídos y retorne dicha cantidad.
x. Informe los números de socio en orden creciente. 
xi. Informe los números de socio pares en orden decreciente.
   
}


program P3E1;
type
	info = record
		num:integer;
		nombre:string;
		edad:integer;
	end;
	arbol=^nodo;
	nodo=record
		datos:info;
		HI:arbol;
		HD:arbol;
	end;
{
procedure CargarArbol(var a:arbol);
	procedure crear(var a:arbol; i:info);
	begin
		if(a = nil)then begin
			new(a);
			a^.datos:= i; a^.HI:=nil; a^.HD:=nil;
		end
		else
			if(i.num < a^.datos.num)then
				crear(a^.HI,i)
			else
				crear(a^.HD,i);
	end;
var
	x:info;
begin
	a:=nil;
	Write('Ingrese el numero de socio: ');
	x.num:= random(20);
	while(x.num <> 0)do begin
		Write('Ingrese su nombre: ');
		Readln(x.nombre);
		Write('Ingrese su edad: ');
		x.edad:= random(99)+1;
		crear(a,x);
		Write('Ingrese el numero del siguiente socio: ');
		x.num:= x.num - 1;
	end;
end;
}
procedure CargarArbol(var a:arbol);
	procedure crear(var a:arbol; i:info);
	begin
		if(a = nil)then begin
			new(a);
			a^.datos:= i; a^.HI:=nil; a^.HD:=nil;
		end
		else
			if(i.num < a^.datos.num)then
				crear(a^.HI,i)
			else
				crear(a^.HD,i);
	end;
var
	x:info;
begin
	a:=nil;
	Write('Ingrese el numero de socio: ');
	Readln(x.num);
	while(x.num <> 0)do begin
		Write('Ingrese su nombre: ');
		Readln(x.nombre);
		Write('Ingrese su edad: ');
		Readln(x.edad);
		crear(a,x);
		Write('Ingrese el numero del siguiente socio: ');
		Readln(x.num);
	end;
end;

function maximo(a:arbol):integer;
begin
	if(a <> nil)then begin
		maximo:= maximo(a^.HD);
		if(maximo < a^.datos.num)then
			maximo:= a^.datos.num;
	end
	else
		maximo:= -1;
end;

procedure minimo(a:arbol; var min:info);
begin
	if(a <> nil)then begin
		minimo(a^.HI,min);
		if(min.num > a^.datos.num)then
			min:= a^.datos;
	end
	else
		min.num:= 9999;
end;


//Writeln(maximoEdad(arb, -1)); EN EL PROGRAMA PRINCIPAL

function maximoEdad(a:arbol):integer;
begin
	if(a <> nil)then begin
		maximoEdad:= maximoEdad(a^.HI);
		if(a^.HD <> NIL)then
			maximoEdad:= maximoEdad(a^.HD);
		if(maximoEdad < a^.datos.edad)then
			maximoEdad:= a^.datos.edad;		
		Writeln('---------------------------------------');
		Writeln(maximoEdad);
	end
	else
		maximoEdad:= -1;
end;
{
function maximoEdad(a:arbol; maxEdad:integer):integer;
begin
	if(a <> nil)then begin
		if(maxEdad < a^.datos.edad)then begin
			maxEdad:= a^.datos.edad;		
		end;
		maximoEdad:= maximoEdad(a^.HI,maxEdad);
		maximoEdad:= maximoEdad(a^.HD,maximoEdad);
	end
	else
		maximoEdad:= maxEdad;
end;}

procedure AumentarUno(a:arbol);
begin
	if(a <> nil)then begin
		AumentarUno(a^.HI);
		a^.datos.edad:= a^.datos.edad + 1;
		AumentarUno(a^.HD);
	end;
end;

function BuscarNum(a:arbol; n:integer):boolean;
begin
	if(a<>nil)then begin
		if(n < a^.datos.num)then
			BuscarNum:=BuscarNum(a^.HI,n)
		else if( n > a^.datos.num)then
			BuscarNum:=BuscarNum(a^.HD,n)
		else
			BuscarNum:=true;
	end
	else
		BuscarNum:= false;
end;

function BuscarNombre(a:arbol; s:string):boolean;
begin
	if(a<>nil)then begin
		BuscarNombre:=BuscarNombre(a^.HI,s);
		BuscarNombre:=BuscarNombre(a^.HD,s);
		if(s = a^.datos.nombre)then
			BuscarNombre:=true;
	end
	else
		BuscarNombre:= false;
end;


//Writeln('El arbol contiene ',contarSocios(arb,0),' socios');
function contarSocios(a:arbol; cant:integer):integer;
begin
	if(a<>nil)then begin
		cant:=cant + 1;
		contarSocios:=contarSocios(a^.HI,cant);
		contarSocios:=contarSocios(a^.HD,contarSocios);
	end
	else
		contarSocios:= cant;
end;

Procedure posOrden ( a : arbol );
begin
   if ( a<> nil ) then begin
    posOrden (a^.HI);
    posOrden (a^.HD);
    writeln (a^.datos.num,' ',a^.datos.nombre,' ',a^.datos.edad);

   end;
end;
Procedure preOrden ( a : arbol );
begin
   if ( a<> nil ) then begin
    writeln (a^.datos.num,' ',a^.datos.nombre,' ',a^.datos.edad);
    preOrden (a^.HI);
    preOrden (a^.HD);
   end;
end;
Procedure enOrden ( a : arbol );
begin
   if ( a<> nil ) then begin
    enOrden (a^.HI);
    writeln (a^.datos.num,' ',a^.datos.nombre,' ',a^.datos.edad);
    enOrden (a^.HD);
   end;
end;


var
	arb:arbol;
	min:info;
	num:integer;
	str:string;
BEGIN
	CargarArbol(arb);
	Writeln('EN ORDEN');
	enOrden(arb);
	Writeln('---------------------------------------------------');
	Writeln('El numero maximo es: ',maximo(arb));
	Writeln('---------------------------------------------------');
	Writeln('Los datos del socio con numero mas chico son:');
	minimo(arb,min);
	Writeln(min.num);
	Writeln(min.nombre);
	Writeln(min.edad);
	Writeln('---------------------------------------------------');
	Writeln('El socio con mas edad tiene: ');
	Writeln(maximoEdad(arb));
	Writeln('---------------------------------------------------');
	AumentarUno(arb);
	enOrden(arb);
	Writeln('---------------------------------------------------');
	Write('Ingrese un numero de socio para buscar: ');
	Readln(num);
	if(BuscarNum(arb,num))then
		Writeln('Se encontro el valor ingresado')
	else
		Writeln('No se encontro el valor ingresado');
	Writeln('---------------------------------------------------');
	Write('Ingrese un nombre de socio para buscar: ');
	Readln(str);
	if(BuscarNombre(arb,str))then
		Writeln('Se encontro el nombre ingresado')
	else
		Writeln('No se encontro el nombre ingresado');
	Writeln('---------------------------------------------------');
	Writeln('El arbol contiene ',contarSocios(arb,0),' socios');
END.

