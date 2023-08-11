{
   a)	Leer informacion de impresiones (nombre de documento, paginas, tamaño en KB, nombre del usuario) y generar una estructura eficiente para la busqueda por usuario, que guarde
   * para cada usuario la cantidad total de documentos impresos, la cantidad total de paginas impresas y el nombre del ultimo documento impreso. La lectura es en orden temporal 
   * y finaliza con tamaño 0
   * 
	A partir de la estructura generada en a), realice modulos independientes para:
	* 
	b)	Obtener la informacion del usuario que imprimio mas documentos en total
	* 
	c)	Generar una estructura con los ultimos documentos impresos de los usuarios con nombre comprendido entre dos valores, sabiendo que como maximo son 20. La estructura debe guardar
	* nombre de usuario y su ultimo documento impreso, y quedar ordenada por nombre de usuario                                    
	* 
  El programa debe invocar a los modulos realizados, mostrar las estructuras generadas e informacion obtenida
   
}
program ParcialImperatico1;
const
	dimF = 20;
type
	info = record
		nombre:string;
		pags:integer;
		kb:integer;
		user:string;
	end;
	usuario = record
		user:string;
		cant:integer;
		pTotal:integer;
		nUlt:string;
	end;
	arbol = ^nodo;
	nodo = record
		datos:usuario;
		HI:arbol;
		HD:arbol;
	end;
	ultimos = record
		user:string;
		nUlt:string;
	end;
	vDocs = array[1..dimF]of ultimos;
	
procedure CargarArbol(var a:arbol);
	procedure LeerDatos(var x:info);
	begin
		Write('Ingrese el tamanio del archivo en KB: ');
		Readln(x.kb);
		if(x.kb <> 0)then begin
			Write('Ingrese el nombre del documento: ');
			//Readln(x.nombre);
			x.nombre:= chr(random(127 - 32)+32);
			Writeln(x.nombre);
			Write('Ingrese la cantidad de paginas que tiene el documento: ');
			//Readln(x.pags);
			x.pags:= random(100)+1;
			Writeln(x.pags);
			Write('Ingrese el nombre del usuario: ');
			Readln(x.user);
		end;
	end;
	procedure AgregarNodo(var a:arbol; x:info);
	begin
		if(a=nil)then begin
			new(a);
			a^.datos.user:= x.user;
			a^.datos.cant:= 1;
			a^.datos.pTotal:= x.pags;
			a^.datos.nUlt:= x.nombre;
		end
		else if(a^.datos.user > x.user)then
			AgregarNodo(a^.HI,x)
		else if(a^.datos.user < x.user)then
			AgregarNodo(a^.HD,x)
		else begin
			a^.datos.cant:= a^.datos.cant + 1;
			a^.datos.pTotal:= a^.datos.pTotal + x.pags;
			a^.datos.nUlt:= x.nombre;
		end;
	end;
var
	x:info;
begin
	LeerDatos(x);
	Writeln('');
	While(x.kb <> 0)do begin
		AgregarNodo(a,x);
		LeerDatos(x);
		Writeln('');
	end;
end;

procedure imprimirArbol(a:arbol);
begin
	if(a <> nil)then begin	
		imprimirArbol(a^.HI);
		Writeln('usuario: ',a^.datos.user);
		Writeln('cantidad de documentos: ',a^.datos.cant);
		Writeln('cantidad total de paginas: ',a^.datos.pTotal);
		Writeln('nombre del ultimo documento agregado: ',a^.datos.nUlt);
		Writeln('');
		imprimirArbol(a^.HD);
	end;
end;

procedure UsuarioMaximo(a:arbol; var max:usuario);
	procedure maximo(var max:usuario; a:arbol);
	begin
		if(a <> nil)then begin
			if(max.cant < a^.datos.cant)then
				max:= a^.datos;
			maximo(max, a^.HI);
			maximo(max, a^.HD);
		end;
	end;
begin
	if(a<>nil)then begin
		max.cant:= -1;
		maximo(max,a);
	end
	else
		Writeln('El arbol esta vacio...');
end;

procedure CargarVectorUltimos(var v:vDocs; var dimL:integer; a:arbol);
	procedure recorrerArbol(a:arbol; var v:vDocs; var dimL:integer; inf,sup:string);
	begin
		if(a<>nil)then begin
			recorrerArbol(a^.HI,v,dimL,inf,sup);
			if(((a^.datos.user >= inf)and(a^.datos.user <= sup))and(dimL < dimF))then begin
				dimL:= dimL + 1;
				v[dimL].user:= a^.datos.user;
				v[dimL].nUlt:= a^.datos.nUlt; 
			end;
			recorrerArbol(a^.HD,v,dimL,inf,sup);
		end;
	end;
var
	inf,sup:string;
begin
	dimL:= 0;
	Write('Ingrese el extremo inferior del rango (string): ');
	Readln(inf);
	Write('Ingrese el extremo superior del rango (string): ');
	Readln(sup);
	recorrerArbol(a,v,dimL,inf,sup);
end;

procedure imprimirVector(v:vDocs; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do
		Writeln('user: ',v[i].user,'	ultimo nombre: ',v[i].nUlt);
end;
var
	arb:arbol;
	userMax:usuario;
	dL:integer;
	vec:vDocs;
BEGIN
	CargarArbol(arb);
	imprimirArbol(arb);
	UsuarioMaximo(arb,userMax);
	Writeln('user: ',userMax.user,'	|| cantidad total: ',userMax.cant,'	|| paginas totales: ',userMax.pTotal,'	|| ultimo nombre: ',userMax.nUlt);
	CargarVectorUltimos(vec,dL,arb);
	imprimirVector(vec,dL);
END.

