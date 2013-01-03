package dia12;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class _8BotonConAccion implements ActionListener {
   
   JButton myButton = null;
   JLabel myLebal = null;
   String text = null;
   
   public static void main(String[] a) {
      _8BotonConAccion myTest = new _8BotonConAccion();
      myTest.createFrame();
   }
   
   
   public void createFrame() {
   
	   JFrame f = new JFrame("My Switch Button");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = f.getContentPane();
      c.setLayout(new GridLayout(2,1));
      text = "On";
      myButton = new JButton(text);
      //AQUI ESTA LA MAGIA
      myButton.addActionListener(this);
      c.add(myButton);
      myLebal = new JLabel(text,SwingConstants.CENTER);
      c.add(myLebal);
      f.pack();
      f.setVisible(true);
      
   }
   
   public void actionPerformed(ActionEvent e) {
      if (text.equals("On")) text = "Off";
      else text = "On"; 
      myButton.setText(text);
      myLebal.setText(text);
   }
}