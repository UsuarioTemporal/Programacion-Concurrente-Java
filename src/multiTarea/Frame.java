package multiTarea;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Frame extends JFrame{
	public Frame() {
		setTitle("Pelota rebota");
		PanelPelota p=new PanelPelota();
		add(p,BorderLayout.CENTER);
		add(new PanelBotones(new PanelPelota.GestionaBotones(p)),BorderLayout.SOUTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
