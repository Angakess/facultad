program Final_18;
type
	pedido = record
		dni:integer;
		nombre:string;
		fecha:integer;
		monto:real;
	end;
	
	p = record
		fecha:integer;
		monto:real;
	end;
	lista = ^nodo;
	nodo = record
		datos:p;
		sig:lista;
	end;
	cliente = record
		dni:integer;
		nombre:string;
		lst:lista;
	end;
	arbol = ^nodoA;
	nodoA = record
		datos:cliente;
		HI:arbol;
		HD:arbol;
	end;
	
procedure LeerDatos (var p:pedido);
begin
	Writeln('Ingrese el monto del pedido: ');
	readln(p.monto);
	if(p.monto <> 0)then begin
		Writeln('Ingrese el DNI del cliente: ');
		readln(p.dni);
		//Writeln('Ingrese el nombre del cliente: ');
		//readln(p.nombre);
		Writeln('Ingrese la fecha del pedido: ');
		readln(p.fecha);
	end;
end;	
procedure AgregarAdelante(var l:lista; f:integer; m:real);
var
	nuevo:lista;
begin
	new(nuevo);
	nuevo^.datos.fecha:= f;
	nuevo^.datos.monto:= m;
	nuevo^.sig:= l;
	l:= nuevo;
end;
procedure crearA(var a:arbol; p:pedido);
begin
	if (a = nil)then begin
		new(a);
		a^.datos.dni:= p.dni;
		a^.datos.nombre:= p.nombre;
		a^.datos.lst:= nil;
		AgregarAdelante(a^.datos.lst, p.fecha, p.monto);
	end
	else
		if (a^.datos.dni = p.dni)then
			AgregarAdelante(a^.datos.lst, p.fecha, p.monto)
		else if (a^.datos.dni > p.dni)then
			crearA(a^.HI, p)
		else
			crearA(a^.HD, p);
end;
procedure cargarArbol(var a:arbol);
var
	p:pedido;
begin
	a:= nil;
	LeerDatos(p);
	Writeln('');
	while(p.monto <> 0)do begin
		crearA(a,p);
		LeerDatos(p);
		Writeln('');
	end;
end;

procedure contarFecha(a:arbol; f:integer; var cant:integer);
var
	aux:lista;
begin
	if (a <> nil)then begin
		aux:= a^.datos.lst;
		while((aux <> nil)and(aux^.datos.fecha <> f))do
			aux:= aux^.sig;
		if((aux <> nil)and(aux^.datos.fecha = f))then
			cant:= cant + 1;
		contarFecha(a^.HI, f, cant);
		contarFecha(a^.HD, f, cant);
	end;
end;


function buscarHoja(a:arbol; dni:integer):arbol;
begin
	if(a = nil)then
		buscarHoja:= nil
	else
		if(dni = a^.datos.dni) then
			buscarHoja:= a
		else
			if(dni < a^.datos.dni)then
				buscarHoja:= buscarHoja(a^.HI, dni)
			else
				buscarHoja:= buscarHoja(a^.HD, dni);
end;
procedure contarPedidos (a:arbol; dni:integer; var mTotal:real; var vTotal:integer);
var
	aux:lista;
begin
	aux:= buscarHoja(a,dni)^.datos.lst;
	mTotal:= 0;
	vTotal:= 0;
	while(aux <> nil)do begin
		mTotal:= mTotal + aux^.datos.monto;
		vTotal:= vTotal + 1;
		aux:= aux^.sig;
	end;
end;

procedure imprimirLista(l:lista);
begin
	while(l <> nil)do begin
		Writeln('Fecha: ',l^.datos.fecha);
		Writeln('Monto: ',l^.datos.monto:2:2);
		Writeln('+++++');
		l:= l^.sig;
	end;
end;
procedure imprimirArbol(a:arbol);
begin
	if(a <> nil)then begin
		imprimirArbol(a^.HI);
		Writeln('DNI: ',a^.datos.dni);
		//Writeln('Nombre: ',a^.datos.nombre);
		imprimirLista(a^.datos.lst);
		Writeln('++++++++++++++++++++++++++++++++++++++++++++++++++');
		imprimirArbol(a^.HD);
	end;
end;



var
	arb:arbol;
	dni:integer;
	fec:integer;
	cantF, cantP:integer;
	montoTotal:real;
BEGIN
	cargarArbol(arb);
	imprimirArbol(arb);
	Writeln('---------------------------------------------------');
	Writeln('Ingrese una fecha para contar: ');
	readln(fec);
	cantF:= 0;
	contarFecha(arb,fec,cantF);
	Writeln('Hay ',cantF,' clientes que hicieron pedidos en esa fecha');
	Writeln('---------------------------------------------------');
	imprimirArbol(arb);
	Writeln('Ingrese un DNI para contar: ');
	readln(dni);
	contarPedidos(arb,dni,montoTotal,cantP);
	Writeln('Monto total: ',montoTotal:2:2,'	Total de pedidos: ',cantP);
	imprimirArbol(arb);
	Writeln('---------------------------------------------------');
	Writeln('Ingrese una fecha para contar: ');
	readln(fec);
	cantF:= 0;
	contarFecha(arb,fec,cantF);
	Writeln('Hay ',cantF,' clientes que hicieron pedidos en esa fecha');
	Writeln('---------------------------------------------------');
	imprimirArbol(arb);
	Writeln('Ingrese un DNI para contar: ');
	readln(dni);
	contarPedidos(arb,dni,montoTotal,cantP);
	Writeln('Monto total: ',montoTotal:2:2,'	Total de pedidos: ',cantP);
	imprimirArbol(arb);
	
END.

