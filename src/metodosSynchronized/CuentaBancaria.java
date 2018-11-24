package metodosSynchronized;

public class CuentaBancaria {
	private double saldoInicial = 50;
	public CuentaBancaria() {
		
	}
	public double getSSaltoIniciar() {
		return saldoInicial;
	}
	
	public void setSaltoActual(double retiro) {
		saldoInicial-=retiro;
	}
}
