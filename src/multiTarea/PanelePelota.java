package multiTarea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

class PanelePelota extends JPanel{
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2D=(Graphics2D)g;
		for(Pelota p : pelotas) {
			g2D.fill(p.getShape());
		}
		
	}
	public  ArrayList<Pelota> getPelotas() {
		return pelotas;
	}
	public void setPelotas(ArrayList<Pelota> pelotas) {
		this.pelotas = pelotas;
	}
	
}