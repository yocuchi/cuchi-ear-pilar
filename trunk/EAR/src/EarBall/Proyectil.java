package EarBall;

import java.awt.Color;
import java.awt.Graphics;

public class Proyectil extends ObjetoTablero {

	/**
	 * @param args
	 */
	
	double velocidad_x, velocidad_y;
	BallPlayer Lanzador;

	public Proyectil(int velocidad_x, int velocidad_y, BallPlayer lanzador) {
		
		this.velocidad_x = velocidad_x;
		this.velocidad_y = velocidad_y;
		this.Ancho=TableroEarBall.Ancho_proyectil;
		this.Alto=TableroEarBall.Alto_proyectil;
		Lanzador = lanzador;
	}



	public double getVelocidad_x() {
		return velocidad_x;
	}
	
	
	public double getVelocidad_y() {
		return velocidad_y;
	}
	
	
	public void mueve(int ms){
		//la formula matematica es
		double delta_t= (double)(ms)/1000;
		this.x= (this.x + this.velocidad_x * delta_t);
		this.y= (this.y - this.velocidad_y * delta_t + 4.5 *delta_t*delta_t);
		this.velocidad_y= (this.velocidad_y - 9*delta_t);
	}



	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(Lanzador.getColor());
		g.fillOval((int)(x-Ancho/2), (int) (y -Alto/2),
				(int)Ancho,(int) Alto);
		g.setColor(Color.black);
		
	}



	@Override
	public boolean Colision(ObjetoTablero o) {
		//me aprovecho de las funciones de JAVA 2D
				return o.AreaImpacto().intersects(this.AreaImpacto());
	}
	
	
	public void Explota(Graphics g) {
		//me aprovecho de las funciones de JAVA 2D
		g.setColor(Color.RED);
		g.fillOval((int)(x-Ancho/2), (int) (y -Alto/2),
				(int)Ancho*2,(int) Alto*2);
		g.setColor(Color.black);
	}

}
