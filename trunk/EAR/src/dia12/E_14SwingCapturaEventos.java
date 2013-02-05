package dia12;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class E_14SwingCapturaEventos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Genero el FRAME
		JFrame f = new JFrame();
	    f.setTitle("Drawing Graphics in a Frame"
	         +" by Adding a Component");
	    f.setBounds(100,50,500,300);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //elijo el border layout
	    f.setLayout(new BorderLayout());
	    
	    
	    //añado una etiqueta
	    JLabel jl = new JLabel("Texto");
	    //UN TEXTBOS
	    JTextField texto = new JTextField();
	    //UN BOTON
	    JButton bt = new JButton("Pulsame para que acabe el mundo");
	    
	    //LOS PEGO
	    f.add(jl,BorderLayout.PAGE_START);
	    f.add(texto, BorderLayout.CENTER);
	    f.add(bt, BorderLayout.PAGE_END);
	    
	    //PREPARO EL LISTENER
	    
	    
	    
	    
	    f.setVisible(true);
		

	}

}
