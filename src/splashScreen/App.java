package splashScreen;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import cronometro.*;
public class App {
	public static void main(String[] args) {
		new Splash();
	}
}
class Splash extends JDialog{
	private JLabel lblSplashScreen;
	private JProgressBar barraProgreso;
	private JLabel porcentaje;
	
	public Splash() {
		setUndecorated(true);
		setLayout(new BorderLayout());
		lblSplashScreen=new JLabel("Splash Screen");
		lblSplashScreen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblSplashScreen,BorderLayout.NORTH);
		barraProgreso=new JProgressBar();
		porcentaje=new JLabel("0%");
		porcentaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(barraProgreso,BorderLayout.CENTER);
		add(porcentaje,BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
//		setResizable(false);
		
		iniciarHilo();
		setVisible(true);
	}
	private void iniciarHilo() {
		Thread hilo=new Thread(new Runnable() {
		int porcentajeNumerico=0;
		String puntos="";
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while(!Thread.currentThread().isInterrupted()) {
						porcentajeNumerico+=5;
						puntos+=".";
						Thread.sleep(100);
						if(porcentajeNumerico<=100) {
							porcentaje.setText(puntos+porcentajeNumerico+"%");
							barraProgreso.setValue(porcentajeNumerico);
						}else {
							dispose();
							new Frame();
							Thread.currentThread().interrupt();
						}
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();

				}
				
			}
		});
		hilo.start();
	}
}