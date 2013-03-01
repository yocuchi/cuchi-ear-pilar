

import java.io.IOException;

import javax.swing.JFrame;
public class circulo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Frame Title");
		int a=100;
		int R=200;
		f.setBounds(R+a,a,50,50);
		f.setVisible(true);
		
		
		
		for(double i=0; i>-1; i=i+0.2){
		int c = (int) ((Math.cos(i)*R));
		int s = (int) ((Math.sin(i)*R));
		f.setBounds(a+R+c,a+R-s,50,50);
	    f.setVisible(true);
	    Thread.sleep(100);
	    System.out.println(i+" "+c+" "+s);
		
		
		}
	}}
	