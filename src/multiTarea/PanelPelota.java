package multiTarea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelPelota extends JPanel{
	
	private static ArrayList<Pelota> pelotas=new ArrayList<>();
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;
		for(Pelota p : pelotas) {
			g2D.fill(p.getShape());
		}
		
	}
	
	final static class GestionaBotones implements ActionListener{
		PanelPelota p;
		public GestionaBotones(PanelPelota p) {
			// TODO Auto-generated constructor stub
			this.p=p;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Salir")) {
				System.exit(0);
			}else {
				Pelota pelota=new Pelota();
				pelotas.add(pelota);
				Runnable r=new Runnable() {
					
					@Override
					public void run() {
						for (int i=1; i<=3000; i++){
							
							pelota.moveBall(p.getBounds());
							
							p.paint(p.getGraphics());
							
							try {
								Thread.sleep(3);
							}catch (InterruptedException ex) {
								// TODO: handle exception
							}
							
						}
					}
				};
				
				Thread hilo=new Thread(r);
				hilo.start();
			}
			
		}
		
	}
	
	
}
