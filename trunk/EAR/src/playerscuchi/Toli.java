package playerscuchi;

import EarContactFighters.*;

public class Toli extends ContactPlayer{

	
	public Toli(){
		//Esto es el constructor
		vida=150;
		fuerza=50;
		Nombre="Tolufas";
		Equipo="Fran";
		Ataque_debil="tos";
		Ataque_fuerte="Mordisco";
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

	
	
	public Accion que_haces(boolean FalloElOtro, Accion AccionDelOtro) {
		// TODO Auto-generated method stub
		return Accion.ATAQUE_DEBIL;
	}

}
