package EarTankFighters;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
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




public class TableroTankFighters extends Container  {
	
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
	
	static int Ancho=800;
	static int Alto=800;
	
	static int Alto_tank=10;
	static int Ancho_tank=10;
	
	static int Ancho_proyectil=8;
	static int Alto_proyectil=8;
	
	double Tiempo;
	double Factor_tiempo=2; //factor para que vaya mas rapido
	double intervalo=50; //ms por cada intervalo de reloj
	int tiempo_recarga=3; //Segundos para recargar
	int [] Segundos_pdte_recarga; //segundo pendientes para acabar la recarga
	int max_move= 50; //numero de px que se puede mover por segundo
	
	
	 DecimalFormat df = new DecimalFormat("#.#");
	 
	List<Proyectil> Proyectiles = new ArrayList<Proyectil>();
	
	List<Muro> Muros = new ArrayList<Muro>();
	
	TankPlayer [] P;
	TankPlayer Vencedor;
	
	int [] posiciones; //donde están los tanques
	static int [] Victorias; //las victorias de cada jugador
	
	public String texto_victoria; 
	boolean fin;
	
	JLabel tiempo;
	JLabel Mensaje;
	
	
	Utilidades u;
	
	public TableroTankFighters(TankPlayer tankPlayer, TankPlayer tankPlayer2) {
		// TODO Auto-generated constructor stub
		
		
		
		P= new TankPlayer[2];
		P[0]=tankPlayer;
		P[1]=tankPlayer2;
		
		P[0].Ancho=this.Ancho_tank;
		P[1].Ancho=this.Ancho_tank;
		
		P[0].Alto=this.Alto_tank;
		P[1].Alto=this.Alto_tank;
		
		P[0].y=Alto-2-this.Alto_tank/2-1;
		P[1].y=Alto-2-this.Alto_tank/2-1;
		
		this.setBounds(0, 0, Ancho, Alto);
	
		//relleno los campos estáticos
		posiciones = new int[2];
		posiciones[0]=Ancho/2-P[0].getPosInicial();
		posiciones[1]=P[1].getPosInicial()+Ancho/2;
	
		this.Segundos_pdte_recarga=new int [2];
		
		 
		//una clase de utilidades siempre viene bien
		u= new Utilidades();
		
		//añado el muro del medio, ojo que los muros hay que dar la corrdenada central
		this.Muros.add(new Muro(Ancho/2-2, Alto-10, 4, 20,Color.black));
		//y la base
		this.Muros.add(new Muro(Ancho/2, Alto+1, Ancho, 1,Color.LIGHT_GRAY));
		
		//añado los labels
		this.tiempo=new JLabel("0.0");
		this.tiempo.setBounds(0, 30, Ancho,60);
		this.tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		this.tiempo.setFont(new Font("Serif", Font.BOLD, 48));
		this.add(this.tiempo);
		
		//añado los labels
		this.Mensaje=new JLabel("PREPARADOS?");
		this.Mensaje.setBounds(0, Alto/2, Ancho,60);
		this.Mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		this.Mensaje.setFont(new Font("Serif", Font.BOLD, 48));
		this.add(this.Mensaje);
		
		
		
		
		//
		//JButton b = new JButton("OKKKKKK");
		//b.setBounds(250 + 10, 50 + 10,
        //           300, 400);
	    //  f.getContentPane().add(b);
	     //Demo.addComponentsToPane(Tab);
  	 //this.add(b);
		
	
		 
	}


	public static void main(String[] args) throws Exception{
		
		
		
		JFrame f = new JFrame();
	    f.setTitle("EAR FIGHTERS");
	    f.setBounds(50,50,Ancho+26,Alto+37);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	     
	      
	      Victorias = new int [2];
		Victorias[0]=0; Victorias[1]=0;
	   	
	     //empieza el juego
	     while ((Victorias[0]<2) && (Victorias[1]<2)){
	    	 
	    	 TableroTankFighters Tab = new TableroTankFighters(new TankToli(), new TankQuieto(200));
				 
	    	//TableroTankFighters Tab = new TableroTankFighters(new TankQuieto(200), new TankQuieto(200));
			 f.setContentPane(Tab);
		     
		     f.setVisible(true);
		 //  	f.validate(); //repinta
		     //descomenta para solo pintar 
		   // if (Tab.fin==false){	return;}
		    Tab.SecuenciaInicio();
		    
		   	while(Tab.fin == false){
		   	
		   	Tab.EjecutaTurno();
		   	f.validate();
		   	Tab.repaint();
	    	 
		   	}
		   	Tab.SecuenciaVictoria();
	    	 
	     }
		
		
		}

	
	private void SecuenciaInicio() throws Exception {
		// TODO Auto-generated method stub
		this.Mensaje.setForeground(Color.BLACK);
		this.Mensaje.setText("PREPARADOS");
		this.validate();
		u.espera(1000);
		this.Mensaje.setText("LISTOS");
		this.validate();
		
		u.espera(1000);
		this.Mensaje.setForeground(Color.RED);
		this.Mensaje.setText("FUEGO!!!!");
		this.validate();
		
		u.espera(1000);
		
		this.Mensaje.setText("");
		this.validate();
		
	}
	
	private void SecuenciaVictoria() throws Exception {
		// TODO Auto-generated method stub
		this.Mensaje.setForeground(Color.GREEN);
		this.Mensaje.setText("Victoria para el jugador: "+ this.Vencedor.getNombre());
		this.validate();
		u.espera(1000);
		
		
	}


	void EjecutaTurno() throws Exception{
		//esperamos el tiempo propicio
		u.espera((int)(intervalo/this.Factor_tiempo));
		u.log("Segundo "+ df.format( this.Tiempo));
		
		//vamos a mover los tanques
		for( int i=0; i< this.P.length;i++){
			TankPlayer TP=P[i];
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
		
		//pintamos los nombres
		g.drawChars(P[0].getNombre().toCharArray(), 0, P[0].getNombre().length(), 20, 20);
		g.drawChars(P[0].getEquipo().toCharArray(), 0, P[0].getEquipo().length(), 20, 40);
		g.drawChars(("Victorias="+this.Victorias[0]).toCharArray(), 0, ("Victorias="+this.Victorias[0]).length(), 20, 60);
		
		g.drawChars(P[1].getNombre().toCharArray(), 0, P[1].getNombre().length(), Ancho-20-P[1].getNombre().length()*20, 20);
		g.drawChars(P[1].getEquipo().toCharArray(), 0, P[1].getEquipo().length(), Ancho-20-P[1].getNombre().length()*20, 40);
		g.drawChars(("Victorias="+this.Victorias[1]).toCharArray(), 0, ("Victorias="+this.Victorias[1]).length(), Ancho-20-P[1].getNombre().length()*20, 60);
		
		//pintamos el tiempo
		this.tiempo.setText(df.format(Tiempo).replace(",", "."));
		
		//g.drawString("Tiempo="+df.format(Tiempo), Ancho/2-("Tiempo="+Tiempo).length()*10, 20);
		
		//pintamos los Tankes
		pintaTanks(g);
		
		//pintamos  y movemos los proyectiles
		//Muevo los proyectiles
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
					  Victorias[otro_j]++;
					  this.Vencedor=P[otro_j];  
					  this.Proyectiles.remove(v);
					  p1++;boom=true;
					  this.fin=true;
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
		
				
		
		
	}
	
	

	public void pintaTanks (Graphics g){
		//
		for (int i=0;i<this.P.length;i++){
			
			g.setColor(P[i].getColor());
			Color c= P[i].getColor();
			
			g.fillRect((int)(P[i].x-P[i].Ancho/2),(int) (Alto-P[i].Alto),this.Ancho_tank,this.Alto_tank);
				
		}
	
		g.setColor(Color.BLACK);
	}

	
	
}




