program P2E2;

procedure Digitos (n:longint);
begin
	if(n <> 0)then begin
		Digitos(n DIV 10);
		Writeln(n MOD 10);
	end;
end;

var num : longint;

BEGIN
	writeln('Ingrese un numero: ');
	Readln(num);
	while(num <> 0)do begin
		Digitos(num);
		writeln('Ingrese otro numero: ');
		Readln(num);
	end;
END.

