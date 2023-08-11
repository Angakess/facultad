program Practica3EJ6;
const
	valorAlto = 9999;

type
	prenda = record
		cod:integer;
		stk:integer;
	end;
	
	maestro = file of prenda;
	detalle = file of integer;
	
procedure leerDetalle (var archivo:detalle; var dato:integer);
begin
	if(not eof(archivo))then
		read(archivo, dato)
	else
		dato:= valorAlto;
end;
procedure leerMaestro (var archivo:maestro; var dato:prenda);
begin
	if(not eof(archivo))then
		read(archivo, dato)
	else
		dato.cod:= valorAlto;
end;
procedure leerDatosMaestro(var p:prenda);
begin
	p.cod:= random(100)+1;
	p.stk:= random(100)+1;
end;
procedure crearArchivoMaestro(var archivo:maestro);
var
	i:integer;
	p:prenda;
begin
	assign(archivo,'archivoDePrendas');
	rewrite(archivo);
	for i:= 1 to 10 do begin
		leerDatosMaestro(p);
		write(archivo, p);
	end;
	close(archivo);	
end;
procedure crearArchivoDetalle(var archivo:detalle);
var
	c:integer;
begin
	assign(archivo,'archivoDetallePrendas');
	rewrite(archivo);
	write('codigo: ');
	readln(c);
	while(c <> -1)do begin
		write(archivo, c);
		write('codigo: ');
		readln(c);
	end;
	close(archivo);
end;
procedure ordenarMaestro(var viejo,nuevo:maestro);
var
	
begin
	assign(viejo,'archivoDePrendasDesordenado'); assign(nuevo,'archivoDePrendas');
end;
procedure actualizarMaestro(var mae:maestro; var det:detalle);
	
	procedure borrarPrendas(var mae:maestro; var det:detalle);
	var
		regM:prenda;
		regD:integer;
	begin
		reset(mae); reset(det);
		leerMaestro(mae,regM);
		while(regM <> valorAlto)do begin
			leerDetalle(det,regD);
			while((regM.cod <> regD)and(regD <> valorAlto))do begin
				leerDetalle(det, regD);
			end;
			
		end;
		close(mae); close(det);
	end;
var
	nuevo:maestro;
begin
	assign(mae,'archivoDePrendasViejo'); assign(det,'archivoDetallePrendas'); assign(nuevo,'archivoDePrendas');
	
end;


var i : byte;

BEGIN
	
	
END.

