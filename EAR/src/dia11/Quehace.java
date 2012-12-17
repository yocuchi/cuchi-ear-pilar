package dia11;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Quehace extends JPanel {

    Image bardejov;

    public Quehace() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("ecce.jpg"));
        bardejov = ii.getImage();
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bardejov, 10, 10, null); 
    }
}