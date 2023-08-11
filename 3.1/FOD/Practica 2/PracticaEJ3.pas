program Practica2EJ3;
const
	valorAlto = 9999;
	dimF = 5;
type
	producto = record
		cod:integer;
		nombre:string;
		desc:string;
		stk:integer;
		stkMin:integer;
		precio:real;
	end;
	sucursal = record
		cod:integer;
		vendido:integer;
	end;
	
	maestro = file of producto;
	detalle = file of sucursal;
	
	sucursales = array[1..dimF] of detalle;
	
	regDetalles = array[1..dimF] of sucursal;

procedure leer(var regD:detalle; var dato:sucursal);
begin
	if(not eof(regD))then
		read(regD,dato)
	else
		dato.cod:= valorAlto;
end;
procedure leerDatosM(var regM:producto);
begin
	Write('Ingrese el codigo del producto: ');
	readln(regM.cod);
	if(regM.cod <> -1)then begin
		Write('Ingrese el nombre del producto: ');
		readln(regM.nombre);
		Write('Ingrese la descripcion del producto: ');
		readln(regM.desc);
		Write('Ingrese el stock actual del producto: ');
		readln(regM.stk);
		Write('Ingrese el stock minimo del producto: ');
		readln(regM.stkMin);
		(*
		Write('Ingrese el precio del producto: ');
		readln(regM.precio);
		*)
		regM.precio:= random(500);
		Writeln('');
	end;
end;
procedure leerDatosD(var regD:sucursal);
begin
	Write('Ingrese el codigo del producto: ');
	readln(regD.cod);
	if(regD.cod <> -1)then begin
		Write('Ingrese la cantidad vendida: ');
		readln(regD.vendido);
	end;
end;
procedure crearArhivos(var mae:maestro; var s:sucursales);
var
	regM:producto;
	regD:sucursal;
	i:integer;
begin
	rewrite(mae);
	for i:= 1 to dimF do
		rewrite(s[i]);
	Writeln('Ingrese los datos del archivo maestro.');
	leerDatosM(regM);
	while(regM.cod <> -1)do begin
		write(mae, regM);
		leerDatosM(regM);
	end;
	Writeln('');
	for i:= 1 to dimF do begin
		Writeln('Ingrese los datos del archivo detalle ',i);
		leerDatosD(regD);
		while(regD.cod <> -1)do begin
			write(s[i], regD);
			leerDatosD(regD);
		end;
		writeln('');
	end;
	close(mae);
	for i:= 1 to dimF do
		close(s[i]);
end;

procedure minimo(var s:sucursales; var rD:regDetalles; var min:sucursal);
var
	iMin,i:integer;
begin
	min.cod:= valorAlto;
	for i:= 1 to dimF do begin
		if(min.cod > rD[i].cod)then begin
			min.cod:= rD[i].cod;
			iMin:= i;
		end;
	end;
	if(min.cod <> 9999)then begin
		min:= rD[iMin];
		leer(s[iMin],rD[iMin]);
	end;
end;
procedure actualizarMaestro(var mae:maestro; var s:sucursales);
var
	regM:producto;
	regD:regDetalles;
	min:sucursal;
	i:integer;
begin
	reset(mae);
	for i:= 1 to dimF do begin
		reset(s[i]);
		leer(s[i],regD[i]);
	end;
	minimo(s,regD,min);
	while(min.cod <> valorAlto)do begin
		read(mae,regM);
		while(regM.cod <> min.cod)do
			read(mae,regM);
		while(regM.cod = min.cod)do begin
			regM.stk:= regM.stk - min.vendido;
			minimo(s,regD,min);
		end;
		seek(mae,filepos(mae)-1);
		write(mae,regM);
	end;
	close(mae);
	for i:= 1 to dimF do
		close(s[i]);
end;
procedure crearTexto(var mae:maestro);
var
	txt: Text;
	regM:producto;
begin
	assign(txt, 'productosStockEJ3.txt');
	reset(mae); rewrite(txt);
	while(not eof(mae))do begin
		read(mae, regM);
		if(regM.stk < regM.stkMin)then begin
			Writeln(txt,'Codigo: ',regM.cod);
			Writeln(txt,'Nombre: ',regM.nombre);
			Writeln(txt,'Descripcion: ',regM.desc);
			Writeln(txt,'Stock: ',regM.stk);
			Writeln(txt,'Precio: ',regM.precio:2:2);
			Writeln(txt,'----------------------------------------');
		end;
	end;
	close(mae);close(txt);
end;


var
	mae:maestro;
	suc:sucursales;
	opcion:char;
	regM:producto;
BEGIN
	assign(mae,'archivoDeProductosEJ3');
	assign(suc[1], 'archivoDeSucursalEJ3(1)');
	assign(suc[2], 'archivoDeSucursalEJ3(2)');
	assign(suc[3], 'archivoDeSucursalEJ3(3)');
	assign(suc[4], 'archivoDeSucursalEJ3(4)');
	assign(suc[5], 'archivoDeSucursalEJ3(5)');
	Writeln('Elija una de las siguientes opciones:');
	Writeln('A- Crear archivos.');
	Writeln('B- Actualizar archivos.');
	writeln('C- Listar los productos con menos stock que el minimo en un arhivo de texto.');
	readln(opcion);
	while((opcion<>'A')and(opcion<>'B')and(opcion<>'C'))do begin
		writeln('No ingreso una opcion valida, vueva a intentar.');
		readln(opcion);
	end;
	if(opcion='A')then
		crearArhivos(mae,suc)
	else if(opcion='B')then
		actualizarMaestro(mae,suc)
	else if(opcion='C')then
		crearTexto(mae);
	reset(mae);
	while(not eof(mae))do begin
		read(mae, regM);
		Writeln('Codigo: ',regM.cod);
		Writeln('Nombre: ',regM.nombre);
		Writeln('Descripcion: ',regM.desc);
		Writeln('Stock: ',regM.stk);
		Writeln('Stock minimo: ',regM.stkMin);
		Writeln('Precio: ',regM.precio:2:2);
		Writeln('----------------------------------------');
	end;
	close(mae);
END.

