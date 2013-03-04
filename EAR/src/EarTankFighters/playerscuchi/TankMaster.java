package EarTankFighters.playerscuchi;


import java.awt.Color;
import java.awt.Graphics;

import EarTankFighters.Muro;
import EarTankFighters.ObjetoTablero;
import EarTankFighters.Proyectil;
import EarTankFighters.TableroTankFighters;
import EarTankFighters.TankPlayer;

public class TankMaster extends TankPlayer {
	
	int contador;
	static int cuenta;

	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TankMaster(){
		this.Nombre="Tank Master"+ cuenta;
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
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, int[] posiciones,
			boolean izquierda) {
		
		//calculo el proyectil mas cercano
		Proyectil P;
		P= Proyectiles[0];
		int distancia=CalculaDistancia(P);
		
		for (int i=1; i< Proyectiles.length; i++){
			if (CalculaDistancia(Proyectiles[i])<distancia){
				distancia=CalculaDistancia(Proyectiles[i]);
				P= Proyectiles[i];
			}
			
		}
		//ya tengo el proyectil mas cercano
		
		//calculo el angulo
		int angulo=CalculaAngulo(P);
		System.out.println("Angulo="+ angulo);
		if (angulo < 60 || angulo > 150){
			//huye del proyectil
			return (int) (Math.signum(Math.cos(angulo))*10);
			
		}else
		{
			return -(int) (Math.signum(Math.cos(angulo))*10);
			
		}
		}

	private int CalculaDistancia(ObjetoTablero o){
		return (int) Math.sqrt(Math.pow(o.getX()-this.getX(), 2)+Math.pow(o.getY()-this.getY(), 2));
		   
	}
	
	private int CalculaAngulo(ObjetoTablero o){
		return (int)Math.toDegrees( Math.acos((o.getX()-this.getX())/CalculaDistancia(o)));
		   
	}

	

	@Override
	public Proyectil dispara(Proyectil[] proyectils, Muro[] muros,
			int[] posiciones, boolean izquierda) {

		if (izquierda){ return  new Proyectil(30,50,this);}
		else {
			return new Proyectil(-80,80,this);
		}
		
	}

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
