package EarTankFighters.playerscuchi;


import java.awt.Color;
import java.awt.Graphics;

import EarTankFighters.Muro;
import EarTankFighters.ObjetoTablero;
import EarTankFighters.Proyectil;
import EarTankFighters.TableroTankFighters;
import EarTankFighters.TankPlayer;

public class TankToli extends TankPlayer {
	
	int contador;
	static int cuenta;

	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TankToli(){
		this.Nombre="TOliTank"+ cuenta;
		this.Equipo="Fran";
		this.color=Color.BLUE;
		contador=10;
		cuenta++;
		
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return (int) (200);
	}

	

	

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, int[] posiciones,
			boolean izquierda) {
		contador--;
		if (contador<-30) contador=30;
		if (izquierda) return -contador;
		else return contador;
	}

	

	@Override
	public Proyectil dispara(Proyectil[] proyectils, Muro[] muros,
			int[] posiciones, boolean izquierda) {

		if (izquierda){ return  new Proyectil(30,50,this);}
		else {
			return new Proyectil(-80,80,this);
		}
		
	}

}
