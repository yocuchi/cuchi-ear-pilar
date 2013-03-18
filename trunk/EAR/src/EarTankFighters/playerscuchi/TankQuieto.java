package EarTankFighters.playerscuchi;


import java.awt.Color;
import java.awt.Graphics;

import EarTankFighters.Muro;
import EarTankFighters.ObjetoTablero;
import EarTankFighters.Proyectil;
import EarTankFighters.TableroTankFighters;
import EarTankFighters.TankPlayer;

public class TankQuieto extends TankPlayer {
	
	int contador;
	static int cuenta;
	int pos;
	
	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TankQuieto( int pos){
		this.Nombre="Quieto"+ cuenta;
		this.Equipo="Fran";
		this.color=Color.GREEN;
		contador=10;
		cuenta++;
		this.pos=pos;
		
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return pos;
	}

	

	

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, double[] posiciones,
			boolean izquierda) {
		
return 0;
	}

	

	@Override
	public Proyectil dispara(Proyectil[] proyectils, Muro[] muros,
			double[] posiciones, boolean izquierda) {
			
		if (izquierda==true){return new Proyectil(36,50,this);}
		else{return null;}
		
			
		
		
	}

}
