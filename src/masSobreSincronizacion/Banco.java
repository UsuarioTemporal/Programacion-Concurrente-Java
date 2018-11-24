package masSobreSincronizacion;

public class Banco {
	private final double[] cuentas;
	
	public Banco() {
		cuentas=new double[100];
		for(double i : cuentas) {
			i=2000;
		}
		
	}
	
	
	public synchronized void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) {
		if(cuentas[cuentaOrigen]<cantidad) {
			return ;
		}
		System.out.println(Thread.currentThread()+" ... ");
		cuentas[cuentaOrigen]-=cantidad;
		System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);
		cuentas[cuentaDestino]+=cantidad;
		System.out.printf("Saldo total : %10.2f/n",getGastoTotal());
		
	}
	
	
	public double getGastoTotal() {
		double sumaCuentas = 0;
		for(double c: cuentas) {
			sumaCuentas+=c;
		}
		return sumaCuentas;
	}
}
