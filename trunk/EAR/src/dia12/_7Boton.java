package dia12;

import javax.swing.*;
public class _7Boton {
   public static void main(String[] a) {
      JFrame f = new JFrame("My First Button");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      JButton b = new JButton("OK");
      f.getContentPane().add(b);
      
    
      f.pack();      
      f.setVisible(true);
   }
}