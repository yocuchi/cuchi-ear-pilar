
import javax.swing.*;

public class cuadrado {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 JFrame f = new JFrame("Frame Title");
		   int x=0;
		      while(x<10){
	      f.setBounds(50,50,150,150);
	      f.setVisible(true);
	      int i=0;
	      int j=0;
	      int k=0;
	      int l=0;
	   
	for(; i<500; i++){
	      
	      f.setBounds(50,50+i,150,150);
	      f.setVisible(true);
	      Thread.sleep(1);
	      }
	     
	for(; j<700; j++){
		  f.setBounds(50+j,50+i,150,150);
	      f.setVisible(true);
	      Thread.sleep(1);
		
	}
	   
	for(;k<500;k++){
		f.setBounds(50+j,50+i-k,150,150);
	      f.setVisible(true);
	      Thread.sleep(1);
	}
	for(;l<700;l++){
		f.setBounds(50+j-l,50+i-k,150,150);
	      f.setVisible(true);
	      Thread.sleep(1);
	}
	
	}}}
