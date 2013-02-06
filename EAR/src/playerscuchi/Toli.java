package playerscuchi;

import EarContactFighters.*;

public class Toli extends ContactPlayer{

	
	public Toli(){
		//Esto es el constructor
		this.vida=150;
		this.fuerza=50;
		this.Nombre="Tolufas";
		this.Equipo="Fran";
		this.Ataque_debil="tos";
		this.Ataque_fuerte="Mordisco";
	}
	
	

	
	public String diAlgo() {
		// TODO Auto-generated method stub
		if (vida>30){
			return "vas a morir";	
		}else
		{
			return "tranki tio...";
		}
		
		
	}

	
	
	public Accion que_haces() {
		// TODO Auto-generated method stub
		return Accion.ATAQUE_DEBIL;
	}

}
