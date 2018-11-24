package cronometro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	public Frame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Paneles(),BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}

class Paneles extends JPanel{
	private JLabel lblCronometro;
	private JButton btnIniciar;
	private JButton btnDetener ;
	private JPanel containerButton=new JPanel();
	int hora=0,minuto=0,segundo=0;
	private Thread hilo;
	int conteo=0;
	public Paneles() {
		lblCronometro=new JLabel("00 : 00 : 00");
		btnDetener=new JButton("Detener");
		btnIniciar=new JButton("Iniciar");
		btnDetener.setEnabled(false);
		containerButton.add(btnIniciar);
		containerButton.add(btnDetener);
		ActionListener gestionaEventos=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btnIniciar) {
					conteo=0;
					btnIniciar.setEnabled(false);
					btnDetener.setEnabled(true);
					iniciarHilo();
				}else {
					conteo++;
					btnIniciar.setEnabled(true);
					if(conteo==2) {
						btnDetener.setEnabled(false);
						conteo=0;
						hora=0;
						minuto=0;
						segundo=0;
						lblCronometro.setText("00 : 00 : 00");
					}else {
						detenerHilo();
					}
				}
				
			}
		};
		btnDetener.addActionListener(gestionaEventos);
		btnIniciar.addActionListener(gestionaEventos);
		setLayout(new BorderLayout());
		add(lblCronometro,BorderLayout.CENTER);
		add(containerButton, BorderLayout.SOUTH);
	}
	private void iniciarHilo() {
		hilo=new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(!Thread.currentThread().isInterrupted()) {
					getCronometro();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						Thread.currentThread().interrupt();
					}
				}
			}
		});
		hilo.start();
	}
	private void detenerHilo() {
		hilo.interrupt();
	}
	private void getCronometro() {
		String horaString="",segundoString="",minutoString="";
		segundo++;
		if(segundo>59) {
			segundo=0;
			minuto++;
			if(minuto>59) {
				minuto=0;
				hora++;
			}
		}
		if(segundo<=9) {
			segundoString="0"+segundo;
		}else {
			segundoString=segundo+"";
		}
		if(minuto<=9) {
			minutoString="0"+minuto;
		}else {
			minutoString=""+minuto;
		}
		if(hora<=9) {
			horaString="0"+hora;
		}else {
			horaString=""+hora;
		}
		lblCronometro.setText(horaString+" : "+minutoString+" : "+segundoString);
	}
}
