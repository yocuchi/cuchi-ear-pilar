package es.oepm.ear.dia10;


import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class QueHace2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("HelloWorldSwing");
		 	 frame.setLayout(new FlowLayout());
		 	
		    final JLabel label = new JLabel("Hello World");
		    
		    
		    
		    frame.setBounds(300, 300,300,500);
		    	
		    
		    
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    
		    frame.setVisible(true);
		    
		    frame.getContentPane().add(label);
		   
		    
		    
		    
	}
	
	
	

}
