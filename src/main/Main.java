package main;
import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setResizable(false);
		marco.setVisible(true);

	}

}



class PelotaHilos implements Runnable{
	private Pelota pelota;
	private Component componente;
	public PelotaHilos(Pelota pelota,Component componente) {
		// TODO Auto-generated constructor stub
		this.pelota=pelota;
		this.componente=componente;
		
	}

	@Override
	public void run() { //aqui estara la tarea que queremos que sea simultanea
		
		for (int i=1; i<=300000; i++){
			
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			try {
				Thread.sleep(5);
			}catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
	
	
}
//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{

	private static final int TAMX=20;//tamaño de la pelota x
	
	private static final int TAMY=20;//tamañp de la pelota y
	
	private double x=(int)Math.random()*(2);
	
	private double y=(int)Math.random()*(2);
	
	private double dx=2;
	
	private double dy=2;
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){ //limites recibira las dimensiones de la lamina 
		
		x+=dx; 
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{

	private ArrayList<Pelota> pelotas=new ArrayList<>();
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	
	
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	private LaminaPelota lamina;
	public MarcoRebote(){
		
		setBounds(600,300,400,350);
		
		setTitle ("Rebotes");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
		
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				comienza_el_juego();
			}
			
		});
		
		
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			
			public void actionPerformed(ActionEvent evento){
				
				System.exit(0);
				
			}
			
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	
	//Ponemos botones
	
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		
		JButton boton=new JButton(titulo);
		
		c.add(boton);
		
		boton.addActionListener(oyente);
		
	}
	
	//Añade pelota y la bota 3000 veces
	
	public void comienza_el_juego (){
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r=new PelotaHilos(pelota, lamina);
			
			Thread hilo=new Thread(r);
			hilo.start();
			
		
		
	}
	
	
	
	
}
