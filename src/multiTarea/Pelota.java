package multiTarea;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {
	//tamaño de la pelota
	private static final int maxPelotaX=15;
	private static final int maxPelotaY=15;
	
	//posisicion cambiante segun el plano cartesiano
	private double x=0;
	private double y=0;
	
	//direccion hacia donde se tiene que mover
	private double dx=1;
	private double dy=1;
	
	public void moveBall(Rectangle2D limites) {
		x+=dx;
		y+=dy;
		
		//Para la coordenada x
		if(x<limites.getMinX()) {
			x=limites.getMinX();
			dx=-dx;
		}
		if(x+maxPelotaX>limites.getMaxX()) {
			x=limites.getMaxX()-maxPelotaX;
			dx=-dx;
		}
		
		//Para la coordenada y
		if(y<limites.getMinY()) {
			y=limites.getMinY();
			dy=-dy;
		}
		if(y+maxPelotaY>limites.getMaxY()) {
			y=limites.getMaxY()-maxPelotaY;
			dy=-dy;
		}
	}
	
	
	//formando la pelota
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, maxPelotaX, maxPelotaY);
		
	}
	
}
