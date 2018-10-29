package ReboteSincronizacion;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class PanelBotones extends JPanel{
	private JButton btnAceptar;
	private JButton btnSalir;
	private JButton btnDetener;
	
	public PanelBotones(ActionListener e) {
		btnAceptar=new JButton("Correr Hilo");
		btnDetener=new JButton("Detener Hilo");
		btnSalir=new JButton("Salir");
		btnAceptar.addActionListener(e);
		btnDetener.addActionListener(e);
		btnSalir.addActionListener(e);
		add(btnAceptar);
		add(btnSalir);
		add(btnDetener);
	}
}
