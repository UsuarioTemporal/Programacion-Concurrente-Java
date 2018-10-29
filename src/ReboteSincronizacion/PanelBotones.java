package ReboteSincronizacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class PanelBotones extends JPanel{
	private LinkedList<Pelota> listaDePelotas;
	private Thread hilos[]=new Thread[3];
	private int pos=-1;
	private JButton btnAceptar;
	private JButton btnSalir;
	private JButton btnDetener;
	PanelPelota panelPelota;
	public PanelBotones(PanelPelota panelPelota) {
		this.panelPelota=panelPelota;
		listaDePelotas=panelPelota.getListaDePelotas();
		btnAceptar=new JButton("Correr Hilo");
		btnDetener=new JButton("Detener Hilo");
		btnSalir=new JButton("Salir");
		ActionListener e =new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(e.getActionCommand().equals("Salir")) {
						System.exit(0);
					}else if(e.getActionCommand().equals("Detener Hilo")) {
						if(pos>=0) {
							btnAceptar.setEnabled(true);
							hilos[pos].interrupt();
							pos--;
						}else {
							pos=0;
							btnDetener.setEnabled(false);
						}
					}else {
						pos++;
						if(pos!=3) {
							btnDetener.setEnabled(true);
							Pelota pelota=new Pelota();
							listaDePelotas.add(pelota);
							
							hilos[pos]=new Thread(new Runnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									while(!Thread.currentThread().isInterrupted()) {
										pelota.moverPelota(panelPelota.getBounds());
										panelPelota.paint(panelPelota.getGraphics());
										try {
											 Thread.sleep(4);
										} catch (InterruptedException e) {
											Thread.currentThread().interrupt();
										}
									}
									
								}
							});
							
							hilos[pos].start();
							
						}else {
							pos=2;
							btnAceptar.setEnabled(false);
						}
						
					}
				}
				
			
		};
		btnAceptar.addActionListener(e);
		btnDetener.addActionListener(e);
		btnSalir.addActionListener(e);
		btnDetener.setEnabled(false);
		add(btnAceptar);
		add(btnSalir);
		add(btnDetener);
	}
	
	
}
