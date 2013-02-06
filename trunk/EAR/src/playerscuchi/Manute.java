package playerscuchi;

import EarContactFighters.*;

public class Manute extends ContactPlayer {

	/**
	 * @param args
	 */
	

	public Manute(){
		this.fuerza=160;
		this.vida=40;
		this.Ataque_debil="Puño";
		this.Ataque_fuerte="patada chuck";
		this.Equipo="Fran";
		this.Nombre="Manute";
		
	}
	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return "grgrgrgr";
	}

	@Override
	public Accion que_haces() {
		// TODO Auto-generated method stub
		int opt=(int) (Math.random()*100);
		if (opt>90){return Accion.ATAQUE_DEBIL;	}
		else if (opt>30){return Accion.ATAQUE_F;	}
		else if (opt>25){return Accion.DEFENSA;	}
		else  {return Accion.ESQUIVA;	}
		
		
		
	}

}
