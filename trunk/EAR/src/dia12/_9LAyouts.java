package dia12;

/*
 * 
 * AWT offers a number of predefined layouts for you to use:
java.awt.BorderLayout - Divides the container into five regions: east, south, west, 
						north, and center and assigns one component for each region.
java.awt.FlowLayout - Takes unlimited number of components and let them flow naturally 
					horizontally first, then vertically.
java.awt.BoxLayout - Takes unlimited number of components and let them 
					flow horizontally or vertically in one direction.
java.awt.GridLayout - Divides the container into rows and columns and assigns one component
 					for each cell.
java.awt.GridBagLayout - Divides the container into rows and columns and assigns one 
					component for each cell with cell sizes not equal.
 */

import java.awt.*;
import javax.swing.*;
public class _9LAyouts {
   public static void main(String[] a) {
	   
	   
	   
      JFrame myFrame = new JFrame("FlowLayout Test");
      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container myPane = myFrame.getContentPane();
      
      
      myPane.setLayout(new BorderLayout());
      myPane.add(new JButton("North"), BorderLayout.NORTH);
      myPane.add(new JButton("South"), BorderLayout.SOUTH);
      myPane.add(new JButton("East"), BorderLayout.EAST);
      myPane.add(new JButton("West"), BorderLayout.WEST);
      myPane.add(new JButton(new ImageIcon("java.gif")), 
         BorderLayout.CENTER);
      
      
      myFrame.pack();
      myFrame.setVisible(true);
   }
}