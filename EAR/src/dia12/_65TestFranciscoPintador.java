package dia12;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

import dia12._5JFramePaint2.MyComponent;

public class _65TestFranciscoPintador {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//Defino el JFRAME
		JFrame f = new JFrame();
	      f.setTitle("Drawing Graphics in a Frame"
	         +" by Adding a Component");
	      f.setBounds(100,50,500,300);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      f.setVisible(true);
		
		// TODO Auto-generated method stub
		Utilidades u= new Utilidades();
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
