package EarBall;

import java.awt.Color;
import java.awt.Graphics;

public class Porteria extends ObjetoTablero {

	/**
	 * @param args
	 */
	
	
	Color color;
	BallPlayer Jugador;

	public Porteria(int x, int y, int Ancho, int Alto, Color color, BallPlayer Jugador) {
		
		this.x=x;
		this.y=y;
		this.Ancho=Ancho;
		this.Alto=Alto;
		this.color=color;
		this.Jugador=Jugador;
	}

	



	@Override
	public void pintame(Graphics g) {
		
		
		g.setColor(color);
		g.fillRect((int)(x-Ancho/2), (int) (y -Alto/2),
				(int)Ancho,(int) Alto);
		//g.drawString(x+","+y, (int)x, (int)y);
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
	}

}
