package dia12;

/**
 * ScreenResolution.java
 * Copyright (c) 2002 by Dr. Herong Yang, http://www.herongyang.com/
 */
import java.awt.*;
import javax.swing.*;
public class ScreenResolution {
   static int dpi;
   static int width, height;
   public static void main(String[] a) {
      Toolkit t = Toolkit.getDefaultToolkit();
      dpi = t.getScreenResolution();
      width = t.getScreenSize().width;
      height = t.getScreenSize().height;
      System.out.println("Width = "+width);
      System.out.println("Height = "+height);
      System.out.println("DPI = "+dpi);
      JFrame f = new JFrame("Screen Size and Resolution");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setContentPane(new MyComponent());
      f.setExtendedState(Frame.MAXIMIZED_BOTH);
      f.setVisible(true);
   }
   static class MyComponent extends JComponent {
      public void paint(Graphics g) {
         g.drawString("100 pixel boxes",0,20);
         for (int i=0; i<width/100+1; i++) {
            g.drawRect(i*100,20,100,100);
         }
         g.drawString("One inch ("+dpi+" pixel) boxes",0,140);
         for (int i=0; i<width/dpi+1; i++) {
            g.drawRect(i*dpi,140,dpi,dpi);
         }
      }
   }
}