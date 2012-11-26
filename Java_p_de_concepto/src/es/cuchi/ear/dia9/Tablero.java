package es.cuchi.ear.dia9;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.awt.Component;
import javax.swing.Box;

public class Tablero {

	private JFrame frame;
	
	public Color[] Colores={Color.BLACK,Color.BLUE,Color.GREEN,Color.RED,Color.ORANGE,Color.WHITE,Color.YELLOW};
	public int linea_actual=0;
	JButton[][] results = new JButton[5][12];
	final JButton [] btnJ =new JButton[5];
	final JButton [] btnSecret =new JButton[5];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablero window = new Tablero();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tablero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnJuego = new JMenu("Juego");
		menuBar.add(mnJuego);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnJuego.add(mntmNuevo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnJuego.add(mntmSalir);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{78,78, 78, 78, 78, 78, 0, 0, 78};
		gridBagLayout.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 1;
		gbc_horizontalStrut.gridy = 16;
		frame.getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		
		
		
		JLabel lblTuJugada = new JLabel("Tu Jugada");
		GridBagConstraints gbc_lblTuJugada = new GridBagConstraints();
		gbc_lblTuJugada.insets = new Insets(0, 0, 0, 5);
		gbc_lblTuJugada.gridx = 0;
		gbc_lblTuJugada.gridy = 17;
		frame.getContentPane().add(lblTuJugada, gbc_lblTuJugada);
		
		
		
		//botones del secret
		
		
		
		for (int i=0;i<5;i++){
			btnSecret[i] = new JButton("");
			btnSecret[i].setBackground(this.Colores[(int) (Math.random()*this.Colores.length)]);
			final JButton fjb=btnSecret[i];
			
			GridBagConstraints gbc_btnSecret = new GridBagConstraints();
			gbc_btnSecret.fill = GridBagConstraints.BOTH;
			gbc_btnSecret.insets = new Insets(0, 0, 0, 5);
			gbc_btnSecret.gridx = 1+i;
			gbc_btnSecret.gridy = 1;
			frame.getContentPane().add(btnSecret[i], gbc_btnSecret);
			
		}
		
		
		//botones de jugada
		
		for (int i=0;i<5;i++){
			btnJ[i] = new JButton("");
			btnJ[i].setBackground(Color.WHITE);
			final JButton fjb=btnJ[i];
			btnJ[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CambiaColorBTN(fjb);
					
				}
			});
			GridBagConstraints gbc_btnJ = new GridBagConstraints();
			gbc_btnJ.fill = GridBagConstraints.BOTH;
			gbc_btnJ.insets = new Insets(0, 0, 0, 5);
			gbc_btnJ.gridx = 1+i;
			gbc_btnJ.gridy = 17;
			frame.getContentPane().add(btnJ[i], gbc_btnJ);
			
		}
		
		
		JButton btnJuega = new JButton(" JUEGA ");
		btnJuega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JuegaLinea();
			}
		});
		GridBagConstraints gbc_btnJuega = new GridBagConstraints();
		gbc_btnJuega.gridx = 7;
		gbc_btnJuega.gridy = 17;
		frame.getContentPane().add(btnJuega, gbc_btnJuega);
		
		
		//vamos a crear los resultados son 12x5 con offset de X 2 e Y desde 16 bajando
		
		for (int y=0;y<12;y++){
			for (int x=0;x<5;x++){
				results[x][y]=new JButton("");
				results[x][y].setBackground(Color.WHITE);
				GridBagConstraints gbc_btn = new GridBagConstraints();
				gbc_btn.fill = GridBagConstraints.BOTH;
				gbc_btn.gridx = 1+x;
				gbc_btn.gridy = 15-y;
				frame.getContentPane().add(results[x][y], gbc_btn);
				
				
			}
			JLabel label = new JLabel(y+"");
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 15-y;
			frame.getContentPane().add(label, gbc_label);
		}
	}

	public void CambiaColorBTN (JButton JB){
		
		//busco el indice del color del boton
		int i=0;
		while (this.Colores[i]!=JB.getBackground()){
			
			i++;};
		i++;
		if (i==(this.Colores.length-1)){i=0;}
		JB.setBackground(this.Colores[i]);
		
		
	}
	
	
	public void JuegaLinea(){
		//cuando pulso el boton juega
		
		//pongo los colores actuales en la linea
		for (int i=0; i<5;i++){
			results[i][this.linea_actual].setBackground(this.btnJ[i].getBackground());
		}
		//calculo los exitos
		JLabel label_sitio = new JLabel("sitio:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 8;
		gbc_label.gridy = 15-this.linea_actual;
		frame.getContentPane().add(label_sitio, gbc_label);
		
		//calculo los exitos
				JLabel label_ok = new JLabel("acierto:");
				GridBagConstraints gbc_label_ok = new GridBagConstraints();
				gbc_label_ok.insets = new Insets(0, 0, 5, 5);
				gbc_label_ok.gridx = 9;
				gbc_label_ok.gridy = 15-this.linea_actual;
				frame.getContentPane().add(label_ok, gbc_label);
				
				
		this.linea_actual++;
		
	}
	
	public int calcula_sitio(){
		//calcula los en su sitio en funcoina de lo elegido
		int sitio=0;
		for (int i=0; i<5;i++){
			
		}
		return sitio;
		
	}
	
	public int calcula_acierto(){
		return 0;
	}
}
