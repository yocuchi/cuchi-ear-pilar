package EarBall;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public abstract class BallPlayer extends ObjetoTablero{

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

    public abstract int muevete( Proyectil [] Proyectiles, Muro[] Muros,
			int [] posiciones, boolean izquierda);
    //indica la variacion en int respecto de la posicion inicial
    //para acceder a las variables de la partida, se pasa la partida como argumento
	
	public abstract int getPosInicial();

	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}
	
	@Override
	public final boolean Colision(ObjetoTablero o) {
		//No colisiona nunca
		
		return o.AreaImpacto().intersects(this.AreaImpacto());
	}

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect((int)this.x,(int) this.y,(int) this.Alto,(int) this.Ancho);
		
	}

	
	
}


