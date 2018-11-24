package masSobreSincronizacion;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
	private final double[] cuentas;
	private Lock cierre=new ReentrantLock();
	private Condition saldoSuficiente;
	public Banco() {
		cuentas=new double[100];
		for(int i=0;i<cuentas.length;i++) {
			cuentas[i]=2000;
		}
		saldoSuficiente = cierre.newCondition();
	}
	
	
	public synchronized void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) {
		
		if(cuentas[cuentaOrigen]<cantidad) {
			return ;
//			wait();
		}
		System.out.println(Thread.currentThread().getName()+" ... ");
		cuentas[cuentaOrigen]-=cantidad;
		System.out.printf("%10.2f de %d para %d\n",cantidad,cuentaOrigen,cuentaDestino);
		cuentas[cuentaDestino]+=cantidad;
		System.out.printf("Saldo total : %10.2f\n",getGastoTotal());
//		notifyAll();
	}
	
	// look
	public  void trans(int cuentaOrigen,int cuentaDestino,double cantidad) {
		cierre.lock();
		try {
			if(cuentas[cuentaOrigen]<cantidad) {
				return ;
			}
			System.out.println(Thread.currentThread().getName()+" ... ");
			cuentas[cuentaOrigen]-=cantidad;
			System.out.printf("%10.2f de %d para %d\n",cantidad,cuentaOrigen,cuentaDestino);
			cuentas[cuentaDestino]+=cantidad;
			System.out.printf("Saldo total : %10.2f\n",getGastoTotal());
		}finally {
			cierre.unlock();
		}
		
	}
	
	
	//mejoras con condiciones de bloqueo
	public  void transf(int cuentaOrigen,int cuentaDestino,double cantidad)throws InterruptedException {
		cierre.lock();
		try {
			while(cuentas[cuentaOrigen]<cantidad) {
				saldoSuficiente.await();
			}
			System.out.println(Thread.currentThread().getName()+" ... ");
			cuentas[cuentaOrigen]-=cantidad;
			System.out.printf("%10.2f de %d para %d\n",cantidad,cuentaOrigen,cuentaDestino);
			cuentas[cuentaDestino]+=cantidad;
			System.out.printf("Saldo total : %10.2f\n",getGastoTotal());
			saldoSuficiente.signalAll();
		}finally {
			cierre.unlock();
		}
		
	}
	public double getGastoTotal() {
		double sumaCuentas = 0;
		for(double c: cuentas) {
			sumaCuentas+=c;
		}
		return sumaCuentas;
	}
}
