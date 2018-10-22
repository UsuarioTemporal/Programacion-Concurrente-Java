package multiTarea;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Rebota extends JFrame {
	private JPanel contentPane;
	PanelePelota  panel= new PanelePelota();
	
	
	public Rebota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel PanelBotones = new JPanel();
		contentPane.add(PanelBotones, BorderLayout.SOUTH);
		
		JButton btnCorrer = new JButton("Correr");
		btnCorrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pelota pelota=new Pelota();
				panel.getPelotas().add(pelota);
				Runnable r=new Runnable() {
					
					@Override
					public void run() {
						for (int i=1; i<=3000; i++){
							
							pelota.moveBall(panel.getBounds());
							
							panel.paint(panel.getGraphics());
							
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
		});
		PanelBotones.add(btnCorrer);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		PanelBotones.add(btnSalir);
	}
	
	public static void main(String[] args) {
		Rebota frame = new Rebota();
		frame.setVisible(true);

	}

}

