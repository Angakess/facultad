program AlgoritmosGenericos;
const
	cantDetalles = X;
	valorAlto = 9999;

type
	infoM = record
		x:integer;
		y:string;
		z:real;
	end;
	
	infoD = record
		x:integer;
		w:real;
	end;
	
	maestro = file of infoM;
	
	detalle = file of infoD;
	
	vectorD = array[1..cantDetalles] of detalle;
	vectorI = array[1..cantDetalles] of infoD;
	
procedure leer(var archivo:detalle; var dato:infoD);
begin
	if(not eof(archivo))then
		read(archivo, dato)
	else
		dato.x:= valorAlto;
end;
procedure minimo(var archivos:vectorD; var datos:vectorI; var infoMin,iMin:integer);
var
	i:integer;
begin
	infoMin.x:= valorAlto;
	for i:= 1 to cantDetalles do begin
		if(datos[i].x < infoMin.x)then begin
			infoMin:= datos[i];
			iMin:= i;
		end;
	end;
	if(xMin <> valorAlto)then begin
		leer(archivos[iMin],datos[i]);
	end;
end;


var i : byte;

BEGIN
	
	
END.

