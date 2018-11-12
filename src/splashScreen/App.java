package splashScreen;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import cronometro.*;
public class App {
	public static void main(String[] args) {
		new Frame();
	}
}
class Splash extends JDialog{
	private JLabel lblSplashScreen;
	private JProgressBar barraProgreso;
	private JLabel porcentaje;
	
	public Splash() {
		setLayout(new BorderLayout());
		lblSplashScreen=new JLabel("Splash Screen");
		lblSplashScreen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblSplashScreen,BorderLayout.NORTH);
		barraProgreso=new JProgressBar();
		porcentaje=new JLabel("0%");
		add(barraProgreso,BorderLayout.CENTER);
		add(porcentaje,BorderLayout.SOUTH);
		pack();
		setLocationRelativeTo(null);
	}
}