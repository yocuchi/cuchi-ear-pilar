package EarTankFighters.playerscuchi;


import java.awt.Color;

import EarTankFighters.Proyectil;
import EarTankFighters.TableroTankFighters;
import EarTankFighters.TankPlayer;

public class TankToli extends TankPlayer {

	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TankToli(){
		this.Nombre="TOliTank";
		this.Equipo="Fran";
		this.color=Color.BLUE;
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public int muevete(TableroTankFighters TTF, boolean izquierda) {
		// TODO Auto-generated method stub
		if (izquierda) return 10;
		else return -10;
		
	}

	@Override
	public Proyectil dispara(TableroTankFighters TTF, boolean izquierda) {
		// TODO Auto-generated method stub
		Proyectil P = new Proyectil(20,20,this);
		
		return P;
	}

}
