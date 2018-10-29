package ReboteSincronizacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class PanelPelota extends JPanel{
	
	private LinkedList<Pelota> listaDePelotas=new LinkedList<>();
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;
		listaDePelotas.forEach(p->g2D.fill(p.getShape()));
	}
	public LinkedList<Pelota> getListaDePelotas() {
		return listaDePelotas;
	}
	
	
}
