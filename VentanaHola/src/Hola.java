import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings({ "serial", "unused" })
public class Hola extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldx;
	private JTextField textFieldy;
	private JMenuBar menuBar;
	private JMenu mnHola;
	private JMenuItem mntmSalir;
	private JLabel lblAncho;
	private JTextField textField_ancho;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hola frame = new Hola();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Hola() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnHola = new JMenu("Hola");
		menuBar.add(mnHola);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		mnHola.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(59, 137, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnOtro = new JButton("Pinta");
		btnOtro.setBounds(24, 10, 57, 23);
		btnOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Graphics g=getGraphics();
				g.clearRect(0, 50, getWidth(), getHeight());
				
				g.setColor(Color.BLUE);
				g.fillRect(Integer.parseInt(textFieldx.getText()), Integer.parseInt(textFieldy.getText()),
						
						   Integer.parseInt(textField_ancho.getText()),Integer.parseInt(textField_ancho.getText()));
				lblNewLabel.setLocation(lblNewLabel.getLocation().x+5, lblNewLabel.getLocation().y);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnOtro);
		
		JLabel lblHolaMascachapas = new JLabel("x");
		lblHolaMascachapas.setBounds(86, 14, 6, 14);
		contentPane.add(lblHolaMascachapas);
		
		textFieldx = new JTextField();
		textFieldx.setBounds(97, 11, 86, 20);
		contentPane.add(textFieldx);
		textFieldx.setColumns(10);
		
		JLabel lblAdios = new JLabel("y");
		lblAdios.setBounds(188, 14, 6, 14);
		contentPane.add(lblAdios);
		
		textFieldy = new JTextField();
		textFieldy.setBounds(199, 11, 86, 20);
		contentPane.add(textFieldy);
		textFieldy.setColumns(10);
		
		lblAncho = new JLabel("ancho");
		lblAncho.setBounds(290, 14, 29, 14);
		contentPane.add(lblAncho);
		
		textField_ancho = new JTextField();
		textField_ancho.setBounds(324, 11, 86, 20);
		contentPane.add(textField_ancho);
		textField_ancho.setColumns(10);
		
		
	}
	
	public void muevebicho(){
	
	}
}
