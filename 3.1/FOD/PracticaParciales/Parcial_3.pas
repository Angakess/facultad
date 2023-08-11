program Parcial_3;
const
	valorAlto = 9999;
	cantDistr = 5;
type
	producto = record
		cod:integer;
		nombre:string;
		desc:string;
		stk:integer;
	end;
	venta = record
		cod:integer;
		cant:integer;
	end;
	
	maestro = file of producto;
	
	detalle = file of venta;
	vectorD = array[1..cantDistr]of detalle;
	
	vectorRD = array[1..cantDistr]of venta;

procedure leer(var archivo:detalle; var datos:venta);
begin
	if(not eof(archivo))then
		read(archivo,datos)
	else
		datos.cod:= valorAlto;
end;

procedure minimo(var archivos:vectorD; var regs:vectorRD; var min:venta);
var
	i,iMin:integer;
begin
	min.cod:= valorAlto;
	for i:= 1 to cantDistr do begin
		if(regs[i].cod < min.cod)then begin
			iMin:= i;
			min:= regs[i];
		end;
	end;
	if(min.cod <> valorAlto)then begin
		leer(archivos[iMin],regs[iMin]);
	end;
end;

procedure procesarArchivos(var mae:maestro; var dets:vectorD);
var
	regDs:vectorRD;
	regM:producto;
	min:venta;
	i:integer;
begin
	reset(mae);
	read(mae,regM);
	for i:= 1 to cantDistr do begin
		reset(dets[i]);
		leer(dets[i],regDs[i])
	end;
	
	minimo(dets,regDs,min);
	while(min.cod <> valorAlto)do begin
		while(min.cod <> regM.cod)do begin
			read(mae,regM);
		end;
		while(min.cod = regM.cod)do begin
			regM.stk:= regM.stk - min.cant;
			minimo(dets,regDs,min);
		end;
		seek(mae, filepos(mae)-1);
		write(mae, regM);
	end;


	close(mae);
	for i:= 1 to cantDistr do begin
		close(dets[i]);
	end;
end;

var i : byte;

BEGIN
	
	
END.

