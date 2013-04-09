package EarBall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.List;

public abstract class BallPlayer extends ObjetoTablero{

	@Override
	public String toString() {
		return "BallPlayer [partida=" + partida + ", Nombre=" + Nombre
				+ ", Equipo=" + Equipo + ", color=" + color + ", x=" + x
				+ ", y=" + y + ", Ancho=" + Ancho + ", Alto=" + Alto
				+ ", Explota=" + Explota + "]";
	}

	public TableroEarBall partida;
	public String Nombre;
	public String Equipo;
	
	public Color color;
	
		 
	 

	public TableroEarBall getPartida() {
		return partida;
	}

	public void setPartida(TableroEarBall partida) {
		this.partida = partida;
	}


	public String getEquipo() {
		return Equipo;
	}


	public String getNombre() {
		return Nombre;
	}

   

	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}
	
	@Override
	public final boolean Colision(ObjetoTablero o) {
		
		
		return o.AreaImpacto().intersects(this.AreaImpacto());
	}

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect((int)this.x,(int) this.y,(int) this.Alto/2,(int) this.Ancho/2);
		
	}

	public abstract Point2D muevete(Proyectil[] Proyectiles, Muro[] Muros,
			Point2D tu_posicion, Point2D su_posicion, boolean izquierda) ;

	
	
}


