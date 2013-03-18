package EarTankFighters;

import java.awt.Color;
import java.util.List;

public abstract class TankPlayer extends ObjetoTablero{

	public TableroTankFighters partida;
	public String Nombre;
	public String Equipo;
	
	public Color color;
	
	

	public String Ataque_fuerte;
	
	
	 
	 public abstract String diAlgo();//dice algo
	 

	public TableroTankFighters getPartida() {
		return partida;
	}

	public void setPartida(TableroTankFighters partida) {
		this.partida = partida;
	}


	public String getEquipo() {
		return Equipo;
	}


	public String getNombre() {
		return Nombre;
	}

    public abstract int muevete( Proyectil [] Proyectiles, Muro[] Muros,
			double[] ds, boolean izquierda);
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

	
	public abstract Proyectil dispara(Proyectil[] proyectils, Muro[] muros,
										double[] ds, boolean izquierda);


	@Override
	public String toString() {
		return "TankPlayer [partida=" + partida + ", Nombre=" + Nombre
				+ ", Equipo=" + Equipo + ", color=" + color
				+ ", Ataque_fuerte=" + Ataque_fuerte + ", x=" + x + ", y=" + y
				+ ", Ancho=" + Ancho + ", Alto=" + Alto + "]";
	}
}


