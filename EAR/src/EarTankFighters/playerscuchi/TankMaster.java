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
		this.Nombre="TM"+ cuenta;
		this.Equipo="Fran";
		this.color=Color.pink;
		contador=10;
		cuenta++;
		
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*400);
	}

	

	

	
	

	@Override
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, double[] posiciones,
			boolean izquierda) {
		
		int ancho_hueco=10;
		
		
		//calculo los lugares seguros por los proyectiles
		double offset=400;
		if (izquierda)offset=0;
		

		//Mypos en el array es ceil hasta el offset 
		int Mypos=(int) Math.ceil((this.getX()-offset-ancho_hueco/2)/ancho_hueco);
				
		//dos arrays, de huecos a ala derecha y a la izquierda		
		
		double [] lugares_seguros_d= 
				new double[(int) Math.ceil((400-this.getX()+offset)/ancho_hueco)]; 
		double [] lugares_seguros_i= 
				new double[(int) Math.ceil((this.getX()-offset)/ancho_hueco)]; 
		//contando con el cero es mi pos en los dos arrays
		
		
		
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
				if ((0<x_al_suelo) && (x_al_suelo<800)){
					//complicado, calculo la distancia al origen del intervalo de PX y en funcion de MyPos
					double d_px= this.getX()-x_al_suelo;
					
					//en funcion de los rangos, relleno los huecos
					//si d_px es menor que el hueco/2, relleno los dos ceros
					if (Math.abs(d_px)<(ancho_hueco/2)){
						lugares_seguros_d[0]=tiempo_al_suelo;
						lugares_seguros_i[0]=tiempo_al_suelo;
					}else
						//si no relleno a derecha o a izquierda
					{
					
					}
					
					
					
					lugares_seguros[Mypos - (int) Math.ceil (d_px/ancho_hueco)]=tiempo_al_suelo;
				}
				
				//
			
			}
			
		}
		
		//ahora a calcular el lugar más proximo con null
		//System.out.println("Mypos="+Mypos+"\t ");
		
		if(lugares_seguros[Mypos]==0.0d)return 0;
		
		//busco los 0.0d hacia la derecha
		//dos contadores, d para derecha, i para izquierda
		for (int d=Mypos,i=Mypos; (i>-1) && (d<lugares_seguros.length);d++,i--){
 			
			if (lugares_seguros[d]==0.0d) {
				System.out.println(this.getNombre()+ "mueve d");
				return +100;}
			if (lugares_seguros[i]==0.0d){
				System.out.println(this.getNombre()+ "mueve d");
				return -100;}
			
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
		
		if (proyectils.length<50){
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
