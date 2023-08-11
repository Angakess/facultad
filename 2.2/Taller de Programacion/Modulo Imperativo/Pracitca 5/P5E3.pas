{
   3.- Un supermercado requiere el procesamiento de sus productos. De cada producto se conoce código, rubro (1..10), stock y precio unitario. Se pide:
 
	-	Generar una estructura adecuada que permita agrupar los productos por rubro. A su vez, para cada rubro, se requiere que la búsqueda de un producto por código sea lo 
		más eficiente posible. La lectura finaliza con el código de producto igual a -1..
		
	-	Implementar un módulo que reciba la estructura generada en a), un rubro y un código de producto y retorne si dicho código existe o no para ese rubro.
	
	-	Implementar un módulo que reciba la estructura generada en a), y retorne, para cada rubro, el código y stock del producto con mayor código.
	
	-	Implementar un módulo que reciba la estructura generada en a), dos códigos y retorne, para cada rubro, la cantidad de productos con códigos entre los dos valores ingresados.
   
}
program P5E3;
const
	dimF = 10;
type
	rangoRubro = 1..dimF;
	info = record
		cod:integer;
		rubro:rangoRubro;
		stock:integer;
		precio:real;
	end;
	
	producto = record
		cod:integer;
		stock:integer;
		precio:real;
	end;
	
	arbol = ^nodo;
	nodo = record
		datos:producto;
		HI:arbol;
		HD:arbol;
	end;
	
	vProd = array[rangoRubro] of arbol;
	vCant = array[rangoRubro] of integer;
	
procedure CargarVector(var v:vProd);
	procedure InicializarVector(var v:vProd);
	var
		i:integer;
	begin
		for i:= 1 to dimF do
			v[i]:= nil;
	end;
	procedure LeerDatos(var x:info);
	begin
		Write('Ingrese el codigo del producto: ');
		Readln(x.cod);
		if(x.cod <> -1)then begin
			{Write('Ingrese el rubro al que pertenece: ');
			Readln(x.rubro);
			Write('Ingrese el stock del producto: ');
			Readln(x.stock);
			Write('Ingrese el precio del prodcuto: ');
			Readln(x.precio);
			Writeln('');}
			x.rubro:= random(10)+1;
			Writeln('Ingrese el rubro al que pertenece: ',x.rubro);
			x.stock:= random(301);
			Writeln('Ingrese el stock del producto: ',x.stock);
			x.precio:= random(501);
			Writeln('IIngrese el precio del prodcuto: ',x.precio:2:2);
			Writeln('');
		end;
	end;
	procedure ArmarProducto(x:info; var p:producto);
	begin
		p.cod:= x.cod;
		p.stock:= x.stock;
		p.precio:= x.precio;
	end;
	procedure AgregarNodo(var a:arbol; p:producto);
	begin
		if(a = nil)then begin
			new(a);
			a^.datos:= p;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else if(p.cod < a^.datos.cod)then
			AgregarNodo(a^.HI,p)
		else
			AgregarNodo(a^.HD,p);
	end;
var
	x:info;
	p:producto;
begin
	InicializarVector(v);
	LeerDatos(x);
	while(x.cod <> -1)do begin
		ArmarProducto(x,p);
		AgregarNodo(v[x.rubro],p);
		LeerDatos(x);
	end;
end;

procedure InformarCodEnRubro(v:vProd);
	function BuscarCodEnArbol(a:arbol; c:integer):boolean;
	begin
		if(a = nil)then
			BuscarCodEnArbol:= false
		else if (a^.datos.cod = c)then
			BuscarCodEnArbol:= true
		else if (a^.datos.cod > c)then
			BuscarCodEnArbol:= BuscarCodEnArbol(a^.HI,c)
		else
			BuscarCodEnArbol:= BuscarCodEnArbol(a^.HD,c);
	end;
var
	c:integer;
	r:rangoRubro;
begin
	Writeln('');
	Write('Ingrese un rubro (1 a ',dimF,'): ');
	Readln(r);
	Write('Ingrese un codigo de prodcuto: ');
	Readln(c);
	Writeln('');
	if(BuscarCodEnArbol(v[r],c))then
		Writeln('El producto existe en ese rubro')
	else
		Writeln('El producto NO existe en ese rubro');
	Writeln('');
end;

procedure MaximoPorRubro(v:vProd);
	procedure MaximoCod(a:arbol; var cMax,sMax:integer);
	begin
		if(a <> nil)then begin
			cMax:= a^.datos.cod;
			sMax:= a^.datos.stock;
			MaximoCod(a^.HD,cMax,sMax);
		end;
	end;
var
	i:rangoRubro;
	codMax,stkMax:integer;
begin
	for i:= 1 to dimF do begin
		if(v[i] <> nil)then begin
			codMax:= -1;
			MaximoCod(v[i],codMax,stkMax);
			Writeln('El codigo maximo del rubro ',i,' es ',codMax);
			Writeln('Y hay ',stkMax,' en stock');
		end
		else
			Writeln('No hay productos en el rubro ',i);
		Writeln('');
	end;
end;

procedure InformarProductosEnRango(v:vProd; var vc:vCant);
	procedure RangoPorRubro(v:vProd; inf,sup:integer; var vC:vCant);
		procedure ContarEntreRango(a:arbol; inf,sup:integer; var cant :integer);
		begin
			if(a <> nil)then begin
				if ((a^.datos.cod >= inf)and(a^.datos.cod <= sup))then
					cant:= cant + 1;
				ContarEntreRango(a^.HI,inf,sup,cant);
				ContarEntreRango(a^.HD,inf,sup,cant);
			end;
		end;
	var
		i:rangoRubro;
		cant:integer;
	begin
		for i:= 1 to dimF do begin
			cant:=0;
			ContarEntreRango(v[i],inf,sup,cant);
			vC[i]:= cant;
		end;
	end;
var
	x,y,i:integer;
begin
	Write('Ingrese el extremo inferior del rango: ');
	Readln(x);
	Write('Ingrese el extremo superior del rango: ');
	Readln(y);
	Writeln('');
	RangoPorRubro(v,x,y,vc);
	for i:= 1 to dimF do
		Write(i,':',vc[i],'	');
end;

var
	vecP:vProd;
	vecC:vCant;
BEGIN
	CargarVector(vecP);
	InformarCodEnRubro(vecP);
	MaximoPorRubro(vecP);
	InformarProductosEnRango(vecP,vecC);
	
END.

