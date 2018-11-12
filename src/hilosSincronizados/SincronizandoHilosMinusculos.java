package hilosSincronizados;

public class SincronizandoHilosMinusculos {
	public static void main(String[] args) {
		Thread hilo1=new Thread(new Hilo("Hilo Primero"));
		Thread hilo2=new Thread(new Hilo("Hilo Segundo"));
		hilo1.start();
//			
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hilo2.start();
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Yo soy hilo del main");
	}
}

class Hilo implements Runnable{
	private String nombreHilo;
	public Hilo(String nombreHilo) {
		this.nombreHilo=nombreHilo;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++) {
			System.out.println(i+" "+nombreHilo);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}

