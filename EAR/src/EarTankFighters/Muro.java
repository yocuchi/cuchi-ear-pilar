package EarTankFighters;

import java.awt.Color;
import java.awt.Graphics;

public class Muro extends ObjetoTablero {

	/**
	 * @param args
	 */
	
	boolean rompible;
	Color color;

	public Muro(int x, int y, int Ancho, int Alto, Color color) {
		
		this.x=x;
		this.y=y;
		this.Ancho=Ancho;
		this.Alto=Alto;
		this.color=color;
		this.rompible=false;
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
