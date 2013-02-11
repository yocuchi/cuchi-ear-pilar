package EarTankFighters;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import EarContactFighters.ContactPlayer;
import EarTankFighters.playerscuchi.TankToli;


import dia12.Utilidades;

public class TableroTankFighters extends JFrame {
	
	/* Reglas:
	 *  1m=1px
	 * 	un proyectil te mata, hasta las dos victorias
	 *  en medio hay un pared de 50 px de altura
	 *  se dispara cada segundo (velocidad )
	 * 	se mueve cada 0.1 segundo unos 3 px
	 * 
	 * 
	 * 
	 */
	

	TankPlayer [] P;
	TankPlayer Vencedor;
	
	int [] posiciones; //donde están los tankes, es siempre positivo, midiendo desde el centro
	
	public String texto_victoria; 
	
	
	
	Utilidades u;
	
	public TableroTankFighters(TankPlayer tankPlayer, TankPlayer tankPlayer2) {
		// TODO Auto-generated constructor stub
		P= new TankPlayer[2];
		P[0]=tankPlayer;
		P[1]=tankPlayer2;
	
		//relleno los campos estáticos
		posiciones = new int[2];
		posiciones[0]=P[0].getPosInicial();
		posiciones[1]=P[1].getPosInicial();
	
		
		 this.setTitle("EAR TANK FIGHTERS");
		 this.setBounds(50,50,800,800);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setVisible(true);
		 
		//
		u= new Utilidades();
		
	
		 
	}


	public static void main(String[] args) throws Exception{
		
		TableroTankFighters Tab = new TableroTankFighters(new TankToli(), new TankToli());
		
		
		
		
		
		while (true){
		u.log("Bienvenido al pintador de Moñas, que deseas pintar:");
		u.log("\t-[C]:Cuadrado");
		u.log("\t-[O]:Circulo");
		String tipo=u.leelinea();
		 //lo vacio de dibujos
		//f.setVisible(false);
		
		if (tipo.equalsIgnoreCase("C")){
			u.log("Coordenada X del esquina superior izquierda");
			int x =Integer.parseInt(u.leelinea());
			u.log("Coordenada Y del esquina superior izquierda");
			int y =Integer.parseInt(u.leelinea());
			u.log("lado");
			int l =Integer.parseInt(u.leelinea());
				
			f.setContentPane(new MiCuadrado(x,y,l));
		} else if (tipo.equalsIgnoreCase("O")) {
			
			u.log("Coordenada X del centro");
			int x =Integer.parseInt(u.leelinea());
			u.log("Coordenada Y del centro");
			int y =Integer.parseInt(u.leelinea());
			u.log("radio");
			int r =Integer.parseInt(u.leelinea());
			
			
			f.setContentPane(new MiCirculo(x,y,r));
		}
		else
		{	
		u.log("Eres un gañan, esa letra no hace nada");	
		}
		f.validate();
		
		
		
		}
	}

	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(arg0);
	}

	
	
}




class MiCuadrado extends JComponent {
int x,y,l;
public MiCuadrado(int x, int y, int l) {
	// TODO Auto-generated constructor stub
	this.x=x;
	this.y=y;
	this.l=l;
}

public void paint(Graphics g) {
   g.drawRect(x,y,l,l);
}
}
class MiCirculo extends JComponent {
int x,y,r;
public MiCirculo(int x, int y, int r) {
	// TODO Auto-generated constructor stub
	this.x=x;
	this.y=y;
	this.r=r;
}

public void paint(Graphics g) {
   g.drawOval(x, y, r,r);
}
}
