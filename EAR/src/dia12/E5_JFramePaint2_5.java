package dia12;



	import java.awt.*;
	import javax.swing.*;
	public class E5_JFramePaint2_5 {
	   public static void main(String[] a) {
	      JFrame f = new JFrame();
	      f.setTitle("Drawing Graphics in a Frame"
	         +" by Adding a Component");
	      f.setBounds(100,50,500,300);
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.getContentPane().add(new MyComponent());
	      f.setVisible(true);
	   }
	   
	   static class MyComponent extends JComponent {
	      public void paint(Graphics g) {
	         g.drawRect(20,10,100,60);
	      }
	   }
	}