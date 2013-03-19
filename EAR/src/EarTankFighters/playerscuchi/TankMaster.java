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
		
		double [] lugares_seguros= new double[400/10];
		
		//calculo los lugares seguros por los proyectiles
		double offset=400;
		if (izquierda)offset=0;
		
		for (int i=0; i< Proyectiles.length; i++){
			//
			if (Proyectiles[i].getLanzador().equals(this)==false){
				Proyectil P=Proyectiles[i];
				double distancia=CalculaDistancia(Proyectiles[i]);
				//calcular la zona de impacto y si me toca
				double tiempo_al_suelo=(P.getVelocidad_y()+
										Math.sqrt(P.getVelocidad_y()*P.getVelocidad_y() + 
										18 * (this.getY()-P.getY()-this.getAlto()/2-P.getAlto()/2+1)))
						 				/9; //el -1 no se muy bien porque es, creo que es para la colision y no tangencia.
				double x_al_suelo=P.getX()+P.getVelocidad_x()*tiempo_al_suelo;
				
				
				
				//relleno los vacios con lo que va a tardar el proyectil en caer
				lugares_seguros[(int) (x_al_suelo/10)]=tiempo_al_suelo;
				
				//
			
			}
			
		}
		
		//ahora a calcular el lugar m�s proximo con null
		int Mypos=(int) ((this.getX()-offset)/10);
		
		//busco los 0.0d
		for (int i=0; i<(lugares_seguros.length/2);i++){
			if (lugares_seguros[Mypos+i]==0.0d) return +10;
			if (lugares_seguros[Mypos-i]==0.0d) return -10;
			
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
