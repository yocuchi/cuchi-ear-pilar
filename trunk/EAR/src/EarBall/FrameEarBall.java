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




public class FrameEarBall extends Container  {
	
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
	
	TableroEarBall Tab;
	
	static int Ancho=900; //ancho del tablero
	static int Alto=600; //alto del tablero
	
	static int Alto_tank=50;
	static int Ancho_tank=5;
	
	static int Ancho_proyectil=8;
	static int Alto_proyectil=8;
	
	double Tiempo;
	double Factor_tiempo=2; //factor para que vaya mas rapido
	double intervalo=50; //ms por cada intervalo de reloj
	
	
	
	
	DecimalFormat df = new DecimalFormat("#.#");
	
	static int [] Victorias; //las victorias de cada jugador
	public String texto_victoria; 
	boolean fin;
	
	JLabel tiempo;
	JLabel Mensaje;
	JLabel [] LabelP;
	
	
	
	Utilidades u;
	
	public FrameEarBall(BallPlayer BPlayer, BallPlayer BPlayer2) {
		// TODO Auto-generated constructor stub
		
		Tab= new TableroEarBall(BPlayer,BPlayer,Ancho,Alto,Ancho_tank,Alto_tank);
		
		
		
		
		//this.setBounds(50, 50, Ancho+200, Alto+150);
	
		 
		//una clase de utilidades siempre viene bien
		u= new Utilidades();
		
	
		
		
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
		
		
		//añado el tablero
		
		this.Tab.setBounds(50, 100, Ancho, Alto);
		this.add(this.Tab);
		
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
	      
	    FrameEarBall FeB= new FrameEarBall(new BallToli(), new BallToli()); 
	    
	    Victorias = new int [2];
		Victorias[0]=0; Victorias[1]=0;
	   	
	     //empieza el juego
	     while ((Victorias[0]<2) && (Victorias[1]<2)){
	    	 
	    	 FeB.accion_saque();
				 
	    	//TableroTankFighters Tab = new TableroTankFighters(new TankQuieto(200), new TankQuieto(200));
			 f.setContentPane(FeB);
		     
		     f.setVisible(true);
		 //  	f.validate(); //repinta
		     //descomenta para solo pintar 
		   // if (Tab.fin==false){	return;}
		    FeB.SecuenciaInicio();
		    
		   	while(FeB.fin == false){
		   	
		   	FeB.EjecutaTurno();
		   	f.validate();
		   	FeB.repaint();
	    	 
		   	}
		   	FeB.SecuenciaVictoria();
	    	 
	     }
		
		
		}

	
	private void accion_saque() {
		// TODO Auto-generated method stub
		this.Tab = new TableroEarBall(Tab.P[0], Tab.P[1],Ancho,Alto,Ancho_tank,Alto_tank);
		
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
		this.Mensaje.setText("Victoria para el jugador: "+ Tab.Vencedor.getNombre());
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
	
	
	

	@Override
	public void paint(Graphics g) {
		
		//pintamos los nombres
				this.LabelP[0].setText("<HTML>"+Tab.P[0].getNombre()+"<br/>"+Tab.P[0].getEquipo()+"<br/> Goles:"+Victorias[0]+"</html>");
				
				this.LabelP[1].setText("<HTML>"+Tab.P[1].getNombre()+"<br/>"+Tab.P[1].getEquipo()+"<br/> Goles:"+Victorias[1]+"</html>");
				
				//pintamos el tiempo
				this.tiempo.setText(df.format(Tiempo).replace(",", "."));
		
		
		super.paint(g);
		
		//Tab.paint(g);
		
		
		
		
		
		
				
				
		
		
	}
	
	

	
	
	
}




