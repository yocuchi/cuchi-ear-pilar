package EarTankFighters;

import java.awt.Color;

public abstract class TankPlayer {

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

    public abstract int muevete( TableroTankFighters TTF, boolean izquierda);
    //indica la variacion en int respecto de la posicion inicial
    //para acceder a las variables de la partida, se pasa la partida como argumento
	
	public abstract int getPosInicial();

	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}


	
	public abstract Proyectil dispara(TableroTankFighters TTF, boolean izquierda);
}


