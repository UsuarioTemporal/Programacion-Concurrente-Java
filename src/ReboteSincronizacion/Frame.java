package ReboteSincronizacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public final class Frame extends JFrame{
	public Frame() {
		PanelPelota panelPelota=new PanelPelota();
		add(panelPelota,BorderLayout.CENTER);
		add(new PanelBotones(panelPelota),BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
