package dia11;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Skeleton extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8218715515529917755L;
	public Skeleton() {
        
    	Foto f = new Foto();
    	f.repaint(10);
    	add(f);
        setTitle("Skeleton");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 580);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        @SuppressWarnings("unused")
		Skeleton sk=new Skeleton();
       
        
        
    }
}

class Foto extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 551095378222514422L;
	Image bardejov;
    int i=0;

    public Foto() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("ecce.jpg"));
        bardejov = ii.getImage();
        
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bardejov, 10, 10, null); 
    }
    
    public void repaint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, 600, 600);
        g2d.fillRect(10+i, 10+i, 10, 10);
        i=i+2;
        
    }
    
}