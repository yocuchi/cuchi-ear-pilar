package EarBall;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import EarContactFighters.ContactPlayer;
import EarTankFighters.playerscuchi.TankQuieto;
import EarTankFighters.playerscuchi.TankToli;




public class TableroEarBall extends Container  {
	
	/* Reglas:
	 *  1m=1px
	 * 	un proyectil te mata, hasta las dos victorias
	 *  en medio hay un pared de 100 px de altura
	 *  se dispara cada segundo (velocidad )
	 * 	se mueve cada 0.1 segundo unos 3 px
	 * 
	 * 
	 * 
	 */
	
	int Ancho; // se reciben del constructor
	int Alto;
	
	int Alto_Player;// se reciben del constructor
	int Ancho_Player;
	
	static int Ancho_proyectil=8;
	static int Alto_proyectil=8;
	
	double Tiempo;
	double Factor_tiempo=2; //factor para que vaya mas rapido
	double intervalo=50; //ms por cada intervalo de reloj
	int max_move= 50; //numero de px que se puede mover por segundo
	 
	List<Proyectil> Proyectiles = new ArrayList<Proyectil>();
	
	List<Muro> Muros = new ArrayList<Muro>();
	
	List<Porteria> Porterias = new ArrayList<Porteria>();
	
	BallPlayer [] P;
	BallPlayer Vencedor;
	
	Point [] posiciones; //donde están los tanques
	
	DecimalFormat df = new DecimalFormat("#.#");
	
	Utilidades u;
	
	public TableroEarBall(BallPlayer tankPlayer, BallPlayer tankPlayer2, 
			int Ancho, int Alto, int Ancho_Jugador, int Alto_Jugador) {
		// TODO Auto-generated constructor stub
		
		this.Ancho=Ancho;
		this.Alto=Alto;
		
		this.Alto_Player=Alto_Jugador;
		this.Ancho_Player=Ancho_Jugador;
		
		P= new BallPlayer[2];
		
		P[0]=tankPlayer;
		P[1]=tankPlayer2;
		
		P[0].Ancho=this.Ancho_Player;
		P[1].Ancho=this.Ancho_Player;
		
		
		
		
		P[0].Alto=this.Alto_Player;
		P[1].Alto=this.Alto_Player;
		
		P[1].y=Alto/2;
		P[0].y=Alto/2+5;
		
		
		System.out.println("==============");
		System.out.println(P[0]);
		System.out.println(P[1]);
		
		P[0].x=10;
		P[1].x=Ancho-10;
		
		System.out.println("==============");
		System.out.println(P[0]);
		System.out.println(P[1]);
		
		//this.setBounds(0, 0, Ancho, Alto);
		
		this.setSize(Ancho, Alto);
	
		//relleno los campos estáticos
		posiciones = new Point[2];
		posiciones[0]= new Point((int)P[0].x, (int)P[0].y);
		posiciones[1]= new Point((int)P[1].x, (int)P[1].y);
		
		
		 
		//una clase de utilidades siempre viene bien
		u= new Utilidades();
		
		//añado el muro del medio, ojo que los muros hay que dar la corrdenada central
		//this.Muros.add(new Muro(Ancho/2-2, Alto-10, 4, 20,Color.black));
		//y las paredes superiores e inferiores
		this.Muros.add(new Muro(Ancho/2, 0, Ancho, 3, Color.black));
		this.Muros.add(new Muro(Ancho/2, Alto, Ancho, 3, Color.black));
		
		//y las porterias
		this.Porterias.add(new Porteria(0, Alto/2, 3, Alto, Color.gray,P[0]));
		this.Porterias.add(new Porteria(Ancho, Alto/2, 3, Alto, Color.gray,P[1]));
		
				
		System.out.println(P[0]);
		System.out.println(P[1]);
		
		
		
	
		 
	}


	
	
	

	void EjecutaTurno() throws Exception{
		//esperamos el tiempo propicio
		u.espera((int)(intervalo/this.Factor_tiempo));
		u.log("Segundo "+ df.format( this.Tiempo));
		/*
		//vamos a mover los tanques
		for( int i=0; i< this.P.length;i++){
			BallPlayer TP=P[i];
			//puedes moverte?
			int mov_P=TP.muevete(getCopiaProyectiles(),getCopiaMuros(),
								posiciones.clone(),(posiciones[i]<Ancho/2));
			int mov= (int) (Math.signum(mov_P)*Math.min(Math.abs(mov_P), this.max_move*this.intervalo/1000));
			
			int old_pos=this.posiciones[i];
			this.posiciones[i]=posiciones[i]+mov;
			//ojo no te salgas, ver las colisiones con los muros
			for (int m=0; m<this.Muros.size() ;m++){
				Muro m1 = this.Muros.get(m);
				 if (P[i].Colision(m1)){
					  u.log("Choco con muro");
					  this.posiciones[i]=old_pos; //para que no te muevas
				  }
			}
			//actualizo el x para que lo tenga
			P[i].x=posiciones[i];
			//u.log(P[i].getNombre()+"_x:"+P[i].x +"\ty:"+P[i].y);
			
			
			//descienden las recargas
			this.Segundos_pdte_recarga[i]--;
			if (this.Segundos_pdte_recarga[i]<=0){
				//le pido un disparo
				Proyectil proy;
				proy=P[i].dispara(getCopiaProyectiles(),getCopiaMuros(),
						posiciones.clone(),(posiciones[i]<Ancho/2));
				if (proy!=null){
				proy.x=P[i].x;
				proy.y=P[i].y-this.Alto_tank/2-proy.Alto/2;
				this.Proyectiles.add(proy);
				this.Segundos_pdte_recarga[i]=(int) (this.tiempo_recarga*1000/this.intervalo);
				}
			}
		
			
		}
		*/
		//que pase el tiempo
		
		this.Tiempo=this.Tiempo+ (double) this.intervalo/1000;
		
	}
	
	
	public Proyectil[] getCopiaProyectiles(){
		return Proyectiles.toArray(new Proyectil[Proyectiles.size()]);
	}
	
	public Muro[] getCopiaMuros(){
		return Muros.toArray(new Muro[Muros.size()]);
	}
	


	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//pintamos los muros
		for (Muro m : this.Muros){
			m.pintame(g);
		}
		
		//pintamos las porterias
		for (Porteria p : this.Porterias){
			p.pintame(g);
		}

		
		//g.drawString("Tiempo="+df.format(Tiempo), Ancho/2-("Tiempo="+Tiempo).length()*10, 20);
		
		//pintamos los Jugadors
		pintajugadores(g);
		
		//pintamos  y movemos los proyectiles
		//Muevo los proyectiles
		/*
		for (int p1=0;p1<this.Proyectiles.size();p1++){
			Proyectil v = this.Proyectiles.get(p1);
			v.pintame(g);
			v.mueve((int) this.intervalo );
			
			boolean boom = false;
			
			//colision con Jugadores
			int otro_j=1;
			for (int j=0; (j<this.P.length) && (boom==false);j++){
				
				 if (v.Colision(P[j])){
					  v.Explota(g);
					  // OJOOOO  Victorias[otro_j]++;
					  this.Vencedor=P[otro_j];  
					  this.Proyectiles.remove(v);
					  p1++;boom=true;
					  //this.fin=true;
					  return;
				  }
				 otro_j--;
			}
			
			
			//colision con otros proyectiles, solo explotan los de un mismo tanke
			for (int p2=0; (p2<this.Proyectiles.size()) && (boom==false);p2++){
				Proyectil v2 = this.Proyectiles.get(p2);
				 if (v.Colision(v2) && p2!=p1 && v.Lanzador.equals(v2.Lanzador)){
					  v.Explota(g);
					  v2.Explota(g);
					  this.Proyectiles.remove(v);
					  this.Proyectiles.remove(v2);
					  p2++;p1++;boom=true;
					  u.log("BOOM");
				  }
			}
			//colision con muross
			for (int m=0; (m<this.Muros.size()) && (boom==false);m++){
				Muro m1 = this.Muros.get(m);
				 if (v.Colision(m1)){
					  v.Explota(g);
					  
					  this.Proyectiles.remove(v);
					  p1++;boom=true;
				  }
			}
			
		
			
		}
		*/
				
		
		
	}
	
	

	public void pintajugadores (Graphics g){
		//
		
		for (int i=0;i<this.P.length;i++){
			
			g.setColor(P[i].getColor());
			Color c= P[i].getColor();
			System.out.println(P[i].x+";"+P[i].y); 
			g.fillRect(
					(int)(P[i].x-P[i].Ancho/2),
					(int) (P[i].y-P[i].Alto/2),
					this.Ancho_Player,this.Alto_Player);
				
		}
	
		g.setColor(Color.BLACK);
	}

	
	
}




