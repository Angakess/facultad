program Parcial_1;
const
	cantSucursale = 2;
	valorAlto = 9999;
type
	producto = record
		cod:integer;
		precio:real;
		stkAct:integer;
		stkMin:integer;
	end;
	
	pedido = record;
		cod:integer;
		fecha:real;
		cant:integer;
	end;
	
	maestro = file of producto;
	
	detalle = file of pedido;
	
	vectorD = array [1..cantSucursales] of detalle;
	
	vectorRD = array [1..cantSucursales] of pedido;
	
procedure leer(var archivo:detalle; var dato:pedido);
begin
	if(not eof(archivo))then
		read(archivo, dato)
	else
		dato.cod:= valorAlto;
end;

procedure minimo(var archivos:vectorD; var datos:vectorRD; var min:pedido; var iMin:integer);
var
	i:integer;
begin
	min.cod:= valorAlto;
	for i:= 1 to cantSucursales do begin
		if(min.cod > datos[i].cod)then begin
			min:= datos[i];
			iMin:= i;
		end;
	end;
	if(min.cod <> valorAlto)then begin
		leer(archivos[iMin], datos[iMin]);
	end;
end;

procedure actualizarMaestro(var regM:producto; regMin:pedido; var cantSinEnviar:integer);
begin
	regM.stkAct:= regM.stkAct - regMin.cant;
	if(regM.stkAct < 0)then begin
		cantSinEnviar:= -regM.stkAct;
		regM.stkAct:= 0;
	end;
end;


procedure procesarArchivos(var mae:maestro; var dets:vectorD);
var
	regM:producto;
	regDs:vectorRD;
	regMin:pedido;
	suc:integer;
	cantSinEnviar:integer;
begin

	//Inicializacion
	reset(mae);
	leer(mae, regM);
	for i:= 1 to cantSucursale do begin
		reset(dets[i]);
		leer(dets[i], regDs[i]);
	end;
	
	//Proceso hasta llegar al final de todos los detalles
	read(mae,regM);
	minimo(dets,regDs,regMin,suc);
	while(regMin.cod <> valorAlto)do begin
		
		//Recorro el archivo maestro hasta encontrar el cod correcto
		while(regM.cod <> regMin.cod)do begin
			read(mae,regM);						
		end;
		
		//Mientras los codigos se repitan entre los detalles, trabajo en el maestro (separado por cada detalle)
		while(regM.cod = regMin.cod)do begin
			cantSinEnviar:= 0;
			actualizarMaestro(regM,regMin,cantSinEnviar);
			if(cantSinEnviar > 0)then begin
				Writeln('A la sucursal ',suc,'le falta ',cantSinEnviar, 'de ',regMin.cod);
			end;
			minimo(dets,regDs,regMin,suc);
		end;
		
		
		if(regM.stkAct < regM.stkMin)then
			Writeln('El producto ',regM.cod 'esta por debajo del stock minimo');
		seek(mae, filepos(mae)-1);
		write(mae,regM);		
	end;
	
	//Cierre de archivos
	close(mae);
	for i:= 1 to cantSucursales do begin
		close(dets[i]);
	end;
end;
	
var i : byte;

BEGIN
	
	
END.

