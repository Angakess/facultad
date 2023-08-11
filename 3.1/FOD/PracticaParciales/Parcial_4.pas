program Parcial_4;
const
	valorAlto = 9999;
	
type
	tJugador = record
		dni:longint;
		nombre:string;
		apellido:string;
		pais_nacimiento:string;
	end;
	
	tArchivo = file of tJugador;
	
procedure leer(var archivo:tArchivo; var datos:tJugador);
begin
	if(not eof(archivo))then
		read(archivo,datos)
	else
		datos.dni:= valorAlto;
end;

procedure agregarJugador(var archivo:tArchivo; jugador:tJugador);
var
	reg:tJugador;
begin
	reset(archivo);
	leer(archivo,reg);
	if(reg.dni < 0)then begin
		seek(archivo,-reg.dni);
		leer(archivo,reg);
		seek(archivo, filepos(archivo)-1);
		write(archivo,jugador);
		seek(archivo,0);
		write(archivo,reg); 
	end
	else begin
		seek(archivo,filesize(archivo));
		write(archivo,jugador);
	end;
	close(archivo);
end;
procedure eliminarJugador(var archivo:tArchivo; dniJugador:longint);
var
	reg,ult:tJugador;
begin
	reset(archivo);
	leer(archivo,reg);
	ult:= reg;
	while((reg.dni <> dniJugador)and(reg.dni <> valorAlto))do begin
		leer(archivo,reg);
	end;
	if(reg.dni = dniJugador)then begin
		seek(archivo,filepos(archivo)-1);
		reg.dni:= -filepos(archivo);
		write(archivo,ult);
		seek(archivo, 0);
		write(archivo,reg);
	end
	else
		Writeln('No se encontro el jugador');
	close(archivo);
end;

var i : byte;

BEGIN
	
	
END.

