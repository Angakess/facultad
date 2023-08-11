program FinalFotografia;
const
	dimF = 200;
type
	foto = record
		cod:integer;
		autor:String;
		likes:integer;
		clics:integer;
		comm:integer;
	end;
	
	vector = array[1..dimF] of foto;

procedure LeerDatos(var f:foto);
begin
	randomize;
	Writeln('Ingrese el autor de la foto: ');
	readln(f.autor);
	if(f.autor <> 'ZZZ')then begin
		f.cod:= Random(200)+1;
		//Writeln('Ingrese el codigo de la foto: ');
		//readln(f.cod);
		f.likes:= Random(100);
		//Writeln('Ingrese la cantidad de likes de la foto: ');
		//readln(f.likes);
		f.clics:= Random(300);
		//Writeln('Ingrese la cantidad de clics de la foto: ');
		//readln(f.clics);
		//f.clics:= 20;
		f.comm:= Random(50);
		//Writeln('Ingrese la cantidad de comentarios de la foto: ');
		//readln(f.comm);
		//f.comm:= 10;
		Writeln('');
	end;
end;
procedure cargarVector(var v:vector; var dimL:integer);
var
	f:foto;
begin
	dimL:= 0;
	LeerDatos(f);
	while((f.autor <> 'ZZZ')and(dimL < dimF))do begin
		dimL:= dimL + 1;
		v[dimL]:= f;
		LeerDatos(f);
	end;
end;

procedure ordenarInsercion(var v:vector;dimL:integer);
var
	i,j:integer;
	actual:foto;
begin
	for i:= 2 to dimL do begin
		actual:= v[i];
		j:= i - 1;
		while((j > 0)and(v[j].cod > actual.cod))do begin
			v[j+1]:= v[j];
			j:= j - 1;
		end;
		v[j+1]:= actual;
	end;
end;

procedure busquedaDicotomica(v:vector; inf,sup:integer; cod:integer);
var
	pos:integer;
begin
	pos:= (inf + sup) DIV 2;
	if(inf <= sup)then begin
		if(v[pos].cod = cod)then begin
			Writeln('Autor: ',v[pos].autor);
			Writeln('Likes: ',v[pos].likes);
			Writeln('Clics: ',v[pos].clics);
			Writeln('Comentarios: ',v[pos].comm);
			Writeln('');
		end
		else if(v[pos].cod < cod)then
			busquedaDicotomica(v,pos+1,sup,cod)
		else
			busquedaDicotomica(v,inf,pos-1,cod);
	end
	else
		Writeln('No se encontro el codigo ingresado');
end;

//procedure maximo(v:vector;dimL:integer; var codMax,lMax:integer);
//var
//	lMax:integer
//begin
//	if(dimL = 0)then
//		lMax:= -1
//	else begin
//		maximo(v,dimL-1,codMax,lMax);
//		if(v[dimL].likes > lMax)then begin
//			lMax:= v[dimL].likes;
//			codMax:= v[dimL].cod;
//		end;
//	end;
//end;

//procedure maximo(v:vector;dimL,lMax:integer; var codMax:integer);
//begin
//	if(dimL > 0)then begin
//		if(v[dimL].likes > lMax)then begin
//			lMax:= v[dimL].likes;
//			codMax:= v[dimL].cod;
//		end;
//		maximo(v,dimL-1,lMax,codMax);
//	end;
//end;

function maximo(v:vector;dimL,lMax:integer):integer;
begin
	if(dimL > 0)then begin
		if(v[dimL].likes > lMax)then begin
			lMax:= v[dimL].likes;
			maximo:= v[dimL].cod;
		end
		else
			maximo:= maximo(v,dimL-1,lMax);
	end;
end;

procedure imprimirVector(v:vector;dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		Writeln('codigo: ',v[i].cod);
		Writeln('autor: ',v[i].autor);
		Writeln('likes: ',v[i].likes);
		Writeln('clics: ',v[i].clics);
		Writeln('comentarios: ',v[i].comm);
		Writeln('---------------------------------------------------------------------------------------');
	end;
end;

var
	vec:vector;
	dL,c:integer;

BEGIN
	cargarVector(vec,dL);
	imprimirVector(vec,dL);
	ordenarInsercion(vec,dL);
	imprimirVector(vec,dL);
	Writeln('Ingrese un codigo para buscar: ');
	Readln(c);
	busquedaDicotomica(vec,1,dL,c);
	Writeln('Ingrese un codigo para buscar: ');
	Readln(c);
	busquedaDicotomica(vec,1,dL,c);
	Writeln('Ingrese un codigo para buscar: ');
	Readln(c);
	busquedaDicotomica(vec,1,dL,c);
	//maximo(vec,dL,-1,cM);
	Writeln('La foto ',maximo(vec,dL,-1),' tiene mas likes');
END.

