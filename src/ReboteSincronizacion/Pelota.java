package ReboteSincronizacion;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public final class Pelota {
	private final int sizeBallX=20;
	private final int sizeBallY=20;
	
	private double posX=0;
	private double posY=0;
	
	private double dirX=1;
	private double dirY=1;
	
	public void moverPelota(Rectangle2D medidasPanel) {
		posX+=dirX;
		posY+=dirY;
		
		if(posX<medidasPanel.getMinX()) {
			posX=medidasPanel.getMinX();
			dirX=-dirX;
		}
		
		if(sizeBallX+posX>medidasPanel.getMaxX()) {
			posX=medidasPanel.getMaxX()-sizeBallX;
			dirX=-dirX;
		}
		
		if(posY<medidasPanel.getMinY()) {
			posY=medidasPanel.getMinY();
			dirY=-dirY;
		}
		
		if(sizeBallY+posY>medidasPanel.getMaxY()) {
			posY=medidasPanel.getMaxY()-sizeBallY;
			dirY=-dirY;
		}
	}
	
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(posX,posY,sizeBallX,sizeBallY);
	}
	
}
