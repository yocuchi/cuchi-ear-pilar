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
	
	static int Ancho=900;
	static int Alto=600;
	
	static int Alto_tank=6;
	static int Ancho_tank=50;
	
	static int Ancho_proyectil=8;
	static int Alto_proyectil=8;
	
	double Tiempo;
	double Factor_tiempo=2; //factor para que vaya mas rapido
	double intervalo=50; //ms por cada intervalo de reloj
	int max_move= 50; //numero de px que se puede mover por segundo
	
	
	 DecimalFormat df = new DecimalFormat("#.#");
	 
	List<Proyectil> Proyectiles = new ArrayList<Proyectil>();
	
	List<Muro> Muros = new ArrayList<Muro>();
	
	List<Porteria> Porterias = new ArrayList<Porteria>();
	
	BallPlayer [] P;
	BallPlayer Vencedor;
	
	Point [] posiciones; //donde están los tanques
	static int [] Victorias; //las victorias de cada jugador
	
	public String texto_victoria; 
	boolean fin;
	
	JLabel tiempo;
	JLabel Mensaje;
	JLabel [] LabelP;
	
	
	
	Utilidades u;
	
	public TableroEarBall(BallPlayer tankPlayer, BallPlayer tankPlayer2) {
		// TODO Auto-generated constructor stub
		
		
		
		P= new BallPlayer[2];
		P[0]=tankPlayer;
		P[1]=tankPlayer2;
		
		P[0].Ancho=this.Ancho_tank;
		P[1].Ancho=this.Ancho_tank;
		
		P[0].Alto=this.Alto_tank;
		P[1].Alto=this.Alto_tank;
		
		P[0].y=Alto-2-this.Alto_tank/2-1;
		P[1].y=Alto-2-this.Alto_tank/2-1;
		
		this.setBounds(50, 50, Ancho+100, Alto+150);
	
		//relleno los campos estáticos
		posiciones = new Point[2];
		posiciones[0]= new Point(5,Alto/2);
		posiciones[1]= new Point(Ancho-5,Alto/2);
		
		
		 
		//una clase de utilidades siempre viene bien
		u= new Utilidades();
		
		//añado el muro del medio, ojo que los muros hay que dar la corrdenada central
		//this.Muros.add(new Muro(Ancho/2-2, Alto-10, 4, 20,Color.black));
		//y las paredes superiores e inferiores
		this.Muros.add(new Muro(Ancho/2+50, 0+110, Ancho, 3, Color.black));
		this.Muros.add(new Muro(Ancho/2+50, Alto+110, Ancho, 3, Color.black));
		
		//y las porterias
		this.Porterias.add(new Porteria(50, Alto/2+110, 3, Alto+2, Color.green,P[0]));
		this.Porterias.add(new Porteria(Ancho+50, Alto/2+110, 3, Alto+2, Color.green,P[1]));
		
				
		
		
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
		
		//añado los labels
		this.LabelP = new JLabel[2];
		
		this.LabelP[0]= new JLabel("Player 1");
		this.LabelP[0].setBounds(20,10, Ancho/2,100);
		this.LabelP[0].setHorizontalAlignment(SwingConstants.LEFT);
		this.LabelP[0].setFont(new Font("Serif", Font.BOLD, 18));
		this.add(this.LabelP[0]);

		this.LabelP[1]= new JLabel("Player 2");
		this.LabelP[1].setBounds(600,10, 200,100);
		this.LabelP[1].setHorizontalAlignment(SwingConstants.RIGHT);
		this.LabelP[1].setFont(new Font("Serif", Font.BOLD, 18));
		this.add(this.LabelP[1]);
		
		
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
	    f.setTitle("EARBALL");
	    f.setBounds(50,50,Ancho+100,Alto+150);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	     
	    
	    Victorias = new int [2];
		Victorias[0]=0; Victorias[1]=0;
	   	
	     //empieza el juego
	     while ((Victorias[0]<2) && (Victorias[1]<2)){
	    	 
	    	 TableroEarBall Tab = new TableroEarBall(new BallToli(), new BallToli());
				 
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
		
		
		//creamos la bola del saque
		
		
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

		//pintamos los nombres
		this.LabelP[0].setText("<HTML>"+P[0].getNombre()+"<br/>"+P[0].getEquipo()+"<br/> Goles:"+this.Victorias[0]+"</html>");
		
		this.LabelP[1].setText("<HTML>"+P[1].getNombre()+"<br/>"+P[1].getEquipo()+"<br/> Goles:"+this.Victorias[1]+"</html>");
		
		
		
		//pintamos el tiempo
		this.tiempo.setText(df.format(Tiempo).replace(",", "."));
		
		//g.drawString("Tiempo="+df.format(Tiempo), Ancho/2-("Tiempo="+Tiempo).length()*10, 20);
		
		//pintamos los Jugadors
		pintajugadores(g);
		
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
	
	

	public void pintajugadores (Graphics g){
		//
		
		for (int i=0;i<this.P.length;i++){
			
			g.setColor(P[i].getColor());
			Color c= P[i].getColor();
			
			g.fillRect((int)(P[i].x-P[i].Ancho/2),(int) (Alto-P[i].Alto),this.Ancho_tank,this.Alto_tank);
				
		}
	
		g.setColor(Color.BLACK);
	}

	
	
}




