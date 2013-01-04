package dia12;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class _13MueveImagen {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 
		JFrame f = new JFrame();
	      f.setTitle("Drawing Graphics in a Frame"
	         +" by Adding a Component");
	      f.setBounds(100,50,500,300);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      f.setVisible(true);
	      coche elcoche= new coche();
	      f.add(elcoche);
	      
	      
	      while (true){
	      elcoche.x++;
	      elcoche.y++;
	      Thread.sleep(100L);
	      
	      Utilidades.log("tic "+ elcoche.x +" "+ elcoche.y);
	      //f.validate();
	      f.repaint();
	      //f.setVisible(true);
	      
	      }
	      
	      

	}

}

class coche extends JComponent{
	public int x,y;
	
	public void paint(Graphics g) {
		 File ff = new File("car.png");
	      System.out.println(ff.getAbsolutePath());
	      BufferedImage myPicture = null;
	      try {
	    	  myPicture = ImageIO.read(ff);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 //tras hacerse visible puedo acceder al getgraphics
	      
	      g.drawImage(myPicture, x, y,null);
	     
	    }	
	
	

}
