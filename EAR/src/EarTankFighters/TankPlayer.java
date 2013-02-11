package EarTankFighters;

public abstract class TankPlayer {

	public TableroTankFighters partida;
	public int vida;
	public int fuerza;
	public String Nombre;
	public String Equipo;
	public String Ataque_debil;
	public String getAtaque_debil() {
		return Ataque_debil;
	}

	public String getAtaque_fuerte() {
		return Ataque_fuerte;
	}

	public String Ataque_fuerte;
	
	
	 
	 public abstract String diAlgo();//dice algo
	 
	 public abstract Accion que_haces();//devuelve la accion que decide hacer el jugador	

	public PartidaContact getPartida() {
		return partida;
	}

	public void setPartida(PartidaContact partida) {
		this.partida = partida;
	}

	public int getVida() {
		return vida;
	}

	public String getEquipo() {
		return Equipo;
	}

	public int getFuerza() {
		return fuerza;
	}

	public String getNombre() {
		return Nombre;
	}

	 public abstract int getPosInicial();
}


