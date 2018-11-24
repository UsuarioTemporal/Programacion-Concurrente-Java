package condicionesDeBloqueo;
import masSobreSincronizacion.Banco;
public class App {
	public static void main(String[] args) {
		Banco banco=new Banco();
		Thread[] hilos=new Thread[100];
		for(int i=0;i<hilos.length;i++) {
			int origen=i;
			hilos[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						banco.transf(origen,((int)(Math.random()*100)),Math.random()*2000);
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							
						}
					}
					
				}
			});
			hilos[i].start();
		}
	}
}
