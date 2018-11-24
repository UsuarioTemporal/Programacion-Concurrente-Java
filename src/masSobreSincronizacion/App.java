package masSobreSincronizacion;

public class App {
	public static void main(String[] args) {
		Banco banco=new Banco();
		Thread[] hilos=new Thread[100];
		for(int i=0;i<hilos.length;i++) {
			hilos[i]=new Thread(new Runnable() {
				
				@Override
				public void run() {
					
					
				}
			});
			hilos[i].start();
		}
	}
}

