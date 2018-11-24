package metodosSynchronized;
//esta clase simulara el proceso de las transacciones
public class CajeroAutomatico implements Runnable{
	
	CuentaBancaria cuenta=new CuentaBancaria();
	public CajeroAutomatico() {
		
	}
	private synchronized void retirarDineroCuenta(double dinero) {
		if(cuenta.getSSaltoIniciar()>=dinero) {
			System.out.println("El saldo actual = "+cuenta.getSSaltoIniciar());
			System.out.println("El usuaro : "+Thread.currentThread().getName()+" eta realizando un retiro de "+dinero);
			cuenta.setSaltoActual(dinero);
			System.out.println("Nuevo saldo es "+cuenta.getSSaltoIniciar());
		}else {
			System.out.println("No hay saldo suficiento para realizar la trnazaccion");
		}
	}
	@Override
	public void run() {
		for(int i=0;i<45;i++) {
			
			try {
				retirarDineroCuenta(10);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
			}
		}
		
	}
}
