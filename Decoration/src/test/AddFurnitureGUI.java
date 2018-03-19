package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import catalog.Style;
import place.AbstractRoom;
import place.Grid;

public class AddFurnitureGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JLabel lblStyle = new JLabel ("Choose the style:");
	private JLabel lblColor = new JLabel ("Choose the color:");
	
	private JTextField textField_1 = new JTextField();
	private JTextField textField_2 = new JTextField();
	
	private int width;
	private int length;
	
	private JComboBox<Style> comboBoxStyle = new JComboBox<Style> ();
	private JComboBox<String> comboBoxColor = new JComboBox <String> ();
	
	private JButton btnAdd = new JButton ("Add");

	/**
	 * Launch the application.
	 */
	public static void main(AbstractRoom furniture, Grid grid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFurnitureGUI frame = new AddFurnitureGUI(furniture, grid);
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
	public AddFurnitureGUI(AbstractRoom furniture, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		textField_1.setBounds(179, 94, 34, 17);
		contentPane.add(textField_1);
		textField_1.setColumns(10);	
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				width = Integer.parseInt(textField_1.getText()) ;
			}			
		});
		
		textField_2.setBounds(270, 94, 34, 17);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				length = Integer.parseInt(textField_2.getText());
			}			
		});
		
		//TODO utiliser ImageIcon(getURL(getCodeBase(),"")) pour integrer les images des meubles
	}

}
