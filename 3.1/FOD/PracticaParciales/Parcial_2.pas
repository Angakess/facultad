program Parcial_2;
const
	valorAlto = 9999;
type
	tVta = record
		codSuc:word;
		idAutor:longword;
		isbn:longword;
		idEj:word;
	end;

	tArchVtas = file of tVta;

procedure leer(var archivo:tArchVtas; var datos:tVta);
begin
	if(not eof(archivo))then
		read(archivo,datos)
	else
		datos.codSuc:= valorAlto;
end;

procedure totalizar(var archivo:tArchVtas; nombreTXT:string);
var
	informe: Text;
	total, sucTotal, autorTotal, isbnTotal:integer;
	sucAct:word;
	autorAct:longword;
	isbnAct:longword;
	regAux:tVta;
begin
	assign(informe,nombreTXT);
	rewrite(informe);
	reset(archivo);
	
	leer(archivo,regAux);
	total:= 0;
	while(regAux.codSuc <> valorAlto)do begin
		sucAct:= regAux.codSuc;
		Writeln(informe,'Codigo de Sucursal: ',sucAct);
		sucTotal:= 0;
		while(sucAct = regAux.codSuc)do begin
			autorAct:= regAux.idAutor;
			Writeln(informe,'    Identificacion de Autor: ',autorAct);
			autorTotal:= 0;
			while((autorAct = regAux.idAutor)and(sucAct = regAux.codSuc))do begin
				isbnAct:= regAux.isbn;
				Write(informe,'        ISBN: ',isbnAct);
				isbnTotal:= 0;
				while((isbnAct = regAux.isbn)and(autorAct = regAux.idAutor)and(sucAct = regAux.codSuc))do begin
					isbnTotal:= isbnTotal + 1;
					leer(archivo,regAux);
				end;
				Writeln(informe,'. Total de ejemplares vendidos del libro: ',isbnTotal);
				autorTotal:= autorTotal + isbnTotal;
			end;
			Writeln(informe,'    Total de ejemplares vendidos del autor: ',autorTotal);
			sucTotal:= sucTotal + autorTotal;
		end;
		Writeln(informe,'Total de ejemplares vendidos en la sucursal: ',sucTotal);
		total:= total + sucTotal;
	end;
	Writeln(informe,'TOTAL GENERAL DE EJEMPLARES VENDIDOS EN LA CADENA: ',total);
	
	close(informe);
	close(archivo);
end;



var i : byte;

BEGIN
	
	
END.

