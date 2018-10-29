package ReboteSincronizacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class PanelPelota extends JPanel{
	
	private static LinkedList<Pelota> listaDePelotas=new LinkedList<>();
	private static Thread hilos[]=new Thread[3];
	private static int pos=0;
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;
		listaDePelotas.forEach(p->g2D.fill(p.getShape()));
	}
	
	static final class GestionaBotones implements ActionListener{
		PanelPelota panel;
		public GestionaBotones(PanelPelota panel) {
			// TODO Auto-generated constructor stub
			this.panel=panel;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Salir")) {
				System.exit(0);
			}else if(e.getActionCommand().equals("Detener Hilo")) {
				if(pos>=0) {
					
					hilos[pos].interrupt();
					pos--;
				}else {
					pos=0;
					((JButton)e.getSource()).setEnabled(false);
				}
			}else {
			
				if(pos!=3) {
					
					Pelota pelota=new Pelota();
					listaDePelotas.add(pelota);
					Runnable run=new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							while(!Thread.currentThread().isInterrupted()) {
								pelota.moverPelota(panel.getBounds());
								panel.paint(panel.getGraphics());
								try {
									 Thread.sleep(4);
								} catch (InterruptedException e) {
									Thread.currentThread().interrupt();
								}
							}
							
						}
					};
					hilos[pos]=new Thread(run);
					hilos[pos].start();
					pos++;
				}else {
					pos=2;
					((JButton)e.getSource()).setEnabled(false);
				}
				
			}
		}
		
	}
}
