package dia11;

import javax.swing.JFrame;

public class Skeleton extends JFrame {

    public Skeleton() {
        
    	add(new Quehace());
        setTitle("Skeleton");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 580);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    public static void main(String[] args) {
        new Skeleton();
    }
}