package EarTankFighters.playerscuchi;


import java.awt.Color;
import java.awt.Graphics;

import EarTankFighters.Muro;
import EarTankFighters.ObjetoTablero;
import EarTankFighters.Proyectil;
import EarTankFighters.TableroTankFighters;
import EarTankFighters.TankPlayer;

public class TankMaster0 extends TankPlayer {
	
	int contador;
	static int cuenta;

	@Override
	public String diAlgo() {
		// TODO Auto-generated method stub
		return null;
	}

	public TankMaster0(){
		this.Nombre="Tank Master"+ cuenta;
		this.Equipo="Fran";
		this.color=Color.pink;
		contador=10;
		cuenta++;
		
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*390);
	}

	

	

	
	

	@Override
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, double[] posiciones,
			boolean izquierda) {
		
		int [] lugares_seguros= new int[400/10];
		
		//calculo los lugares seguros por los proyectiles
		
		//P= Proyectiles[0];
		int distancia=100000;
		
		for (int i=0; i< Proyectiles.length; i++){
			//
			if (Proyectiles[i].getLanzador().equals(this)==false){
			if (CalculaDistancia(Proyectiles[i])<distancia){
				distancia=CalculaDistancia(Proyectiles[i]);
				P= Proyectiles[i];
			}
			}
			
		}
		//ya tengo el proyectil mas cercano
		if (P!=null){
		//calcular la zona de impacto y si me toca
		double tiempo_al_suelo=(P.getVelocidad_y()+
								Math.sqrt(P.getVelocidad_y()*P.getVelocidad_y() + 
								18 * (this.getY()-P.getY()-this.getAlto()/2-P.getAlto()/2+1)))
				 				/9; //el -1 no se muy bien porque es, creo que es para la colision y no tangencia.
		double x_al_suelo=P.getX()+P.getVelocidad_x()*tiempo_al_suelo;
		System.out.println("P=\t"+ P.getVelocidad_y()+"\t"+P.getY()+"\t"+tiempo_al_suelo + "\t"+ x_al_suelo);
		
		double resta=this.getX()-x_al_suelo;
		
		
		if ((distancia < 250) && ((Math.abs(resta)-1) < (this.getAncho()/2+20)) ){
			//Es decir, esta al lado y me va a endiñar
			System.out.println("PELIGRO A MOVERSE");
			int cambio=-1;
			if (izquierda)cambio=1;
			
			//angulo de llegada
			double Angulo =Math.acos((P.getX()-this.getX())*cambio/distancia);
			System.out.println("Angulo="+Angulo);
			
			
			if (Angulo>Math.PI/5){
				//en funcion de mi distancia me muevo
				if (izquierda){
			return (int) (100 *cambio * Math.signum(resta) * (this.getX()-200) );
				} else{
					return (int) (100 *cambio * Math.signum(resta) * (this.getX()-600) );		
				}
			}
			else{ //viene muy bajo, hay que ir hacia el muro
				return (int) (100 *cambio );	
			}
		} 		
		else{//no esta lejos no me muevo
			
				return 0;
		}
		}
		return 0;
		 
	}

	private int CalculaDistancia(ObjetoTablero o){
		return (int) Math.sqrt(Math.pow(o.getX()-this.getX(), 2)+Math.pow(o.getY()-this.getY(), 2));
		   
	}
	
	private int CalculaAngulo(ObjetoTablero o){
		return (int)Math.toDegrees( Math.acos((o.getX()-this.getX())/CalculaDistancia(o)));
		   
	}

	

	@Override
	public Proyectil dispara(Proyectil[] proyectils, Muro[] muros,
			double[] posiciones, boolean izquierda) {
		
		if (proyectils.length==0){
		//	if (true){
		//soy el
		int soy=-1; //estoy en la izquierda
		if (izquierda==false) soy=1; //derecha
		
		//voy a ver a que distancia x esta el enemigo
		
		double distancia=posiciones[1]-posiciones[0]; 
		System.out.println("d="+ distancia);
		
		double Vy=40 ;// proporcional a distancia al muro
		double Vx= distancia * 9 /(Vy * 2);
		
		//debugging
		
		//System.out.println(this.toString());
		//System.out.println(muros[0].toString());
		
		
		
		if (izquierda){ 
			return  new Proyectil(Vx,Vy,this);}
		else {
			return new Proyectil(-Vx,Vy,this);
		}
		}else
		{
			return null;
		}
	}

	@Override
	public void pintame(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
