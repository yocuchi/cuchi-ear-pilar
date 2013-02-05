package dia12;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class E_6TestFranciscoPintador {

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
			
			
			
			f.setContentPane(new MiCuadrado_simple());
		} else if (tipo.equalsIgnoreCase("O")) {
			f.setContentPane(new MiCirculo_simple());
		}
		else
		{	
		u.log("Eres un gañan, esa letra no hace nada");	
		}
		f.validate();
		
		
		
		}
	}

}

class MiCuadrado_simple extends JComponent {
    public void paint(Graphics g) {
       g.drawRect(20,10,100,60);
    }
 }
class MiCirculo_simple extends JComponent {
    public void paint(Graphics g) {
       g.drawOval(20, 20, 100,100);
    }
 }
