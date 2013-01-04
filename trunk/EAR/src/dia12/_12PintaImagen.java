package dia12;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class _12PintaImagen {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		 JFrame myFrame = new JFrame("GridBagLayout Test");
	      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      myFrame.setSize(1200,800);
	      
	      Container myPane = myFrame.getContentPane();
	      myPane.setLayout(new GridBagLayout());
	      GridBagConstraints c = new GridBagConstraints();
	      
	      ClassLoader classLoader = _12PintaImagen.class.getClassLoader();
	      File classpathRoot = new File(classLoader.getResource("").getPath());

	      System.out.println(classpathRoot.getPath());
	      
	      File f = new File("car.png");
	      System.out.println(f.getAbsolutePath());
	      
	      BufferedImage myPicture = ImageIO.read(f);
	      JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
	      myPane.add( picLabel );
	      
	      
	      //myFrame.pack();
	      myFrame.setVisible(true);

	}

}
