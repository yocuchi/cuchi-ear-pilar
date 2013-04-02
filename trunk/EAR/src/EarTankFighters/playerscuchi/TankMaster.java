package EarTankFighters.playerscuchi;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

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
		if (cuenta>0) this.color=Color.BLACK;
		contador=10;
		cuenta++;
		
		
	}

	@Override
	public int getPosInicial() {
		// TODO Auto-generated method stub
		return (int) (Math.random()*300)+50;
	}

	

	
	public double menor_tiempo(double valor_vector,double tiempo){
		
		//calculo el tiempo de impacto si llegase alli moviendo en esa direccion sin parar
		
		//this.partida.getMax_move(); //esto son los max px que puedo mover por segundo
		
		
		if (valor_vector==0){
			return tiempo;
		}else
		{
			if (tiempo <=0){
				return valor_vector;
			}else{
			return Math.min(valor_vector, tiempo);
			}
		}
		
		
	}

	
	

	@Override
	public int muevete(Proyectil[] Proyectiles, Muro[] Muros, double[] posiciones,
			boolean izquierda) {
		
		int ancho_hueco=40;
		double umbral_tiempo_movimiento=3.0d; //3 segundos para moverse
		
		
		//calculo los lugares seguros por los proyectiles
		double offset=400;
		if (izquierda)offset=0;
		

		//Mypos en el array es ceil hasta el offset 
		int Mypos=(int) Math.ceil((this.getX()-offset-ancho_hueco/2)/ancho_hueco);
				
		//dos arrays, de huecos a ala derecha y a la izquierda		
		
		double [] lugares_seguros_d= 
				new double[(int) Math.floor((400-this.getX()+offset-ancho_hueco/2)/ancho_hueco)]; 
		double [] lugares_seguros_i= 
				new double[(int) Math.floor((this.getX()-offset-ancho_hueco/2)/ancho_hueco)]; 
		
		Arrays.fill(lugares_seguros_d, 99d);
		Arrays.fill(lugares_seguros_i, 99d);
		//para que evite las paredes extremas
		lugares_seguros_d[lugares_seguros_d.length-1]=umbral_tiempo_movimiento*3;
		lugares_seguros_i[lugares_seguros_i.length-1]=umbral_tiempo_movimiento*3;
		
		//contando con el cero es mi pos en los dos arrays
		
		
		
		
		
		for (int i=0; i< Proyectiles.length; i++){
			//
			if (Proyectiles[i].getLanzador().equals(this)==false)
			{
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
					//TODO: que coja el menor valor de todos
					//si d_px es menor que el hueco/2, relleno los dos ceros
					
					if (Math.abs(d_px)<(ancho_hueco+1/2)){
						lugares_seguros_d[0]=menor_tiempo(lugares_seguros_d[0],tiempo_al_suelo);
						lugares_seguros_i[0]=menor_tiempo(lugares_seguros_i[0],tiempo_al_suelo);
					}
					else if (d_px>0) //cae a mi izquierda pongo el tiempo que tarda en caer menos lo que yo tardo en llegar
					{
						int sitio= lugares_seguros_i.length-(int) Math.ceil((d_px-(ancho_hueco/2))/ancho_hueco);
						//System.out.print(sitio);
						
						lugares_seguros_i[sitio]=menor_tiempo(lugares_seguros_i[sitio],tiempo_al_suelo-(sitio-1)*ancho_hueco/this.partida.getMax_move());
					}
					else{ //cae a mi derecha
						int sitio=(int) Math.ceil((-d_px-(ancho_hueco/2))/ancho_hueco);
						lugares_seguros_d[sitio]=menor_tiempo(lugares_seguros_d[sitio],tiempo_al_suelo-(sitio-1)*ancho_hueco/this.partida.getMax_move());
								
					}
					
				}
				
				//
			
			}
			
		}//relleno
		
		//pinto el mapa para el izquierdo
		if (izquierda==true){
		for (int i=0; i<(lugares_seguros_d.length + lugares_seguros_i.length); i++ ){
			System.out.print("|");
			if (i<lugares_seguros_i.length){
				//System.out.print(lugares_seguros_i[i]>0);
				System.out.printf("i%1$.2f", lugares_seguros_i[lugares_seguros_i.length-i-1]);
			
			}else
			{
				//System.out.print(String.format( lugares_seguros_d[i-lugares_seguros_i.length+1],".1.1d"));
				System.out.printf("d%1$.2f", lugares_seguros_d[i-lugares_seguros_i.length]);
			}
			
			
		}System.out.println();
		  
		}//PINTO MAPA */
		
		//Ahora a ver si me muevo en donde estoy si cae el pepino
		
		if(lugares_seguros_i[0]>umbral_tiempo_movimiento)return 0;
		
		//busco los 0.0d hacia la derecha
		//dos contadores, d para derecha, i para izquierda
		System.out.println("PEPINO INCOMING");
		
		for (int i=1; i<Math.max(lugares_seguros_i.length,lugares_seguros_d.length);i++){
 			//hay que puntuar los lugares
			double[] puntuacion=new double[2];
			boolean hay_sitio_seguro=false;
			if ((i<lugares_seguros_i.length) &&  
					(lugares_seguros_i[i]>umbral_tiempo_movimiento)){
					puntuacion[0]=lugares_seguros_i[i];
					hay_sitio_seguro=true;		}
					
			
			if ((i<lugares_seguros_d.length) && 
			 (lugares_seguros_d[i]>umbral_tiempo_movimiento)) {
				puntuacion[1]=lugares_seguros_d[i];
				hay_sitio_seguro=true;}
			
			if (hay_sitio_seguro){
				if (puntuacion[1]>puntuacion[0]) return +100;
				else return -100;
			}
			
			
		}
		System.out.println("ESTO NO DEBERIA OCURRIR");
		return (int)Math.random()*200-100;
		
			 
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
		//System.out.println("d="+ distancia);
		
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
