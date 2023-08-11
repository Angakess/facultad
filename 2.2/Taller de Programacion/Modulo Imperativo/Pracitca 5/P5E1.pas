{
1.- El administrador de un edificio de oficinas, cuenta en papel, con la información del pago de las expensas de dichas oficinas. 
	Implementar un programa que:
	
	-	Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina se ingresa código de identificación, DNI del propietario y valor 
 		de la expensa. La lectura finaliza cuando llega el código de identificación -1.
 
	-	Ordene el vector, aplicando uno de los métodos vistos en la cursada, para obtener el vector ordenado por código de identificación de la oficina.
		 
	-	Realice una búsqueda dicotómica que recibe el vector generado en b) y un código de identificación de oficina y retorne si dicho código está en el vector. En
  		el caso de encontrarlo, se debe informar el DNI del propietario y en caso contrario informar que el código buscado no existe.

	-	Tenga un módulo recursivo que retorne el monto total de las expensas.

   
   
}


program P5E1;
const
	dimF = 300;
type
	info = record
		cod:integer;
		dni:integer;
		valor:real;
	end;
	
	vExpensas = array [1..dimF] of info;
	
procedure CargarVector(var v:vExpensas; var dimL:integer);
	procedure LeerDatos(var x:info);
	begin
		Write('Ingrese el codigo de identificacion: ');
		Readln(x.cod);
		if(x.cod <> -1)then begin
			Write('Ingrese el dni del propietario: ');
			Readln(x.dni);
			Write('Ingrese el valor de la expensa: ');
			Readln(x.valor);
			Writeln('');
		end;
	end;
	
var
	aux:info;
begin
	dimL:= 0;
	LeerDatos(aux);
	While((aux.cod <> -1)and(dimL < dimF))do begin
		dimL:= dimL + 1;
		v[dimL]:= aux;
		LeerDatos(aux);
	end;
end;

procedure OrdenarVector(var v:vExpensas; dimL:integer);
var
	i,j,pos:integer;
	item:info;
begin
	for i:= 1 to dimL - 1 do begin
		pos:= i;
		for j:= i+1 to dimL do
			if (v[j].cod < v[pos].cod)then
				pos:= j;
		item:= v[pos];
		v[pos]:= v[i];
		v[i]:= item;
	end;
end;

procedure BuscarCodigo(v:vExpensas; dimL:integer);
	procedure BusquedaDicotomica (v:vExpensas; dimL,x:integer; var pos:integer);
	var
		sup,inf:integer;
	begin
		sup:=dimL;
		inf:= 1;
		pos:= ((sup - inf)div 2) + inf;
		while((v[pos].cod <> x)and(inf <= sup))do begin
			if(x > v[pos].cod)then
				inf:= inf + 1
			else
				sup:= sup - 1;
			pos:= ((sup - inf)div 2) + inf;
		end;
		if(inf > sup)then
			pos:= -1;
	end;
var
	aux,pos:integer;
begin
	Write('Ingrese un codigo a buscar: ');
	Readln(aux);
	BusquedaDicotomica(v,dimL,aux,pos);
	if(pos <> -1)then
		Writeln('Se encotro el codigo y el dni del propietario es: ',v[pos].dni)
	else
		Writeln('El codigo buscado no existe');
end;

function MontoTotal(v:vExpensas; dimL:integer):real;
begin
	if(dimL > 0)then begin
		MontoTotal:= MontoTotal(v,dimL - 1);
		MontoTotal:= MontoTotal + v[dimL].valor;
	end
	else
		MontoTotal:= 0;
end;

procedure MostrarVector (v: vExpensas; dimL:integer);
var
	i:integer;
begin
	Writeln('Contenido del vector: ');
	for i:= 1 to dimL do
		Writeln(v[i].cod,'	',v[i].dni,'	',v[i].valor:2:2);
	Writeln('');
end;

var
	vec:vExpensas;
	dimL:integer;

BEGIN
	CargarVector(vec,dimL);
	MostrarVector(vec,dimL);
	OrdenarVector(vec,dimL);
	MostrarVector(vec,dimL);
	BuscarCodigo(vec,dimL);
	Writeln('El monto total de todas las expensas es: $',MontoTotal(vec,dimL):2:2);
	
END.

