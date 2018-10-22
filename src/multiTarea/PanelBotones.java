package multiTarea;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotones extends JPanel{
	private JButton btnLanzar=new JButton("Lanzar");
	private JButton btnSalir=new JButton("Salir");
	
	public PanelBotones(ActionListener e) {
		btnLanzar.addActionListener(e);
		btnSalir.addActionListener(e);
		add(btnLanzar);
		add(btnSalir);
	}
	
	
}
