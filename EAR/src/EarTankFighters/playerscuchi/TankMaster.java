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
		return (int) (100);
	}

	

	

	
	

	@Override
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, int[] posiciones,
			boolean izquierda) {
		
		//calculo el proyectil enemigo mas cercano
		Proyectil P = null;
		//P= Proyectiles[0];
		int distancia=100000;
		
		for (int i=0; i< Proyectiles.length; i++){
			if (Proyectiles[i].getLanzador().equals(this)==false){
			if (CalculaDistancia(Proyectiles[i])<distancia){
				distancia=CalculaDistancia(Proyectiles[i]);
				P= Proyectiles[i];
			}
			}
			
		}
		//ya tengo el proyectil mas cercano
		if (distancia < 50){
		//calculo el angulo
		int angulo=CalculaAngulo(P);
		System.out.println("Angulo="+ angulo);
		if (angulo < 60 || angulo > 150){
			//huye del proyectil
			return -(int) (Math.signum(Math.cos(Math.toRadians(angulo)))*10);
			
		}else
		{ //acercate al muro
			return (int) (Math.signum(Math.cos(Math.toRadians(angulo)))*10);
			
		}}
		else{
			return 0;
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
		
		//soy el
		int soy=0;
		if (izquierda==false) soy=1;
		
		//voy a ver a que distancia x esta el enemigo
		
		int distancia=posiciones[0]+posiciones[1]; 
		
		double Vy=10;
		double Vx=distancia* Math.sqrt(2*Vy/ (9));
		if (izquierda){ return  new Proyectil((int)Vx,(int)Vy,this);}
		else {
			return new Proyectil((int)Vx,(int)Vy,this);
		}
		
	}

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
