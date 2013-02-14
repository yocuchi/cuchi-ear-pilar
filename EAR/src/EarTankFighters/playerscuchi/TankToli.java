package EarTankFighters.playerscuchi;


import java.awt.Color;
import java.awt.Graphics;

import EarTankFighters.ObjetoTablero;
import EarTankFighters.Proyectil;
import EarTankFighters.TableroTankFighters;
import EarTankFighters.TankPlayer;

public class TankToli extends TankPlayer {
	
	int contador;

	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TankToli(){
		this.Nombre="TOliTank";
		this.Equipo="Fran";
		this.color=Color.BLUE;
		contador=10;
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return 200;
	}

	@Override
	public int muevete(TableroTankFighters TTF, boolean izquierda) {
		// TODO Auto-generated method stub
		
		contador--;
		if (contador<-30) contador=30;
		if (izquierda) return contador;
		else return -contador;
		
		
	}

	@Override
	public Proyectil dispara(TableroTankFighters TTF, boolean izquierda) {
		// TODO Auto-generated method stub
		if (izquierda){ return  new Proyectil(20,50,this);}
		else {
			return new Proyectil(-80,80,this);
		}
		
		
	}

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Colision(ObjetoTablero o) {
		// TODO Auto-generated method stub
		return false;
	}

}
