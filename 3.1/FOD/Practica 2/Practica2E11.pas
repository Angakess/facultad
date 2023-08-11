program Practica2E11;
const
	valorAlto = 9999;
type
	dato = record
		prov:string;
		alf:integer;
		enc:integer;
	end;
	info = record
		prov:string;
		loc:integer;
		alf:integer;
		enc:integer;
	end;
	
	maestro = file of dato;
	detalle = file of info;
	
procedure leerD(var reg:detalle; var i:info);
begin
	if(not eof(reg))then
		read(reg,i)
	else
		i.prov:= 'ZZZZZ';
end;
procedure leerM(var reg:maestro; var i:dato);
begin
	if(not eof(reg))then
		read(reg,i)
	else
		i.prov:= 'ZZZZZ';
end;
procedure actualizarMaestro(var mae:maestro; var det1,det2:detalle);
var
	i1,i2:info;
	d:dato;
begin
	reset(mae); reset(det1); reset(det2);
	leer(mae); leer(det1); leer(det2);
	while(d.prov <> valorAlto)do begin
		d.alf:= 0;
		d.enc:= 0;
		while((d.prov = i1.prov)or(d.prov = 12.prov))do begin
			if(i1.prov < i2.prov)then begin
				d.alf:= d.alf + i1.alf;
				d.enc:= d.enc + i1.enc;
				leerD(det1,i1);
			end;
			else if(i1.prov > i2.prov)then begin
				d.alf:= d.alf + i2.alf;
				d.enc:= d.enc + i2.enc;
				leerD(det1,i2);
			end;
			else begin
				d.alf:= d.alf + i1.alf + i2.alf;
				d.enc:= d.enc + i1.enc + i2.enc;
				leerD(det1,i1);
				leerD(det1,i2);
			end;
		end;
		seek(mae,filepos(mae)-1);
		write(mae,d);
		leerM(mae,d);
	end;
	close(mae); close(det1); close(det2);
end;
	
var i : byte;

BEGIN
	
	
END.

