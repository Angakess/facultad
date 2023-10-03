package ar.edu.unlp.info.oo1.ejercicio9;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro() {
		super();
	}
	
	public void depositar(double monto) {
		super.depositar(monto * 1.02);
	}
	
	public boolean extraer(double monto) {
		return super.extraer(monto * 0.98);
	}
	
	public boolean transferir(double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta(monto * 1.02, cuentaDestino);
	}
	
	public boolean puedeExtraer(double monto) {
		if(this.getSaldo() >= monto) {
			return true;
		}
		return false;
	}
}
