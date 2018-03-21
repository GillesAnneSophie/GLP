package test;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import catalog.Style;
import place.AbstractRoom;
import place.Grid;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class AddFurnitureGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JLabel lblStyle = new JLabel ("Choose the style:");
	private JLabel lblColor = new JLabel ("Choose the color:");
	
	private int furniturePositionY;
	private int furniturePositionX;
	
	private JLabel lblPosition = new JLabel ("Coordonates:");
	private JLabel lblX = new JLabel("X");
	private JLabel furnitureName ;
	
	private JComboBox<Style> comboBoxStyle = new JComboBox<Style> ();
	private JComboBox<String> comboBoxColor = new JComboBox <String> ();
	private JComboBox<Integer> comboBoxX = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxY = new JComboBox<Integer>();
	
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
		setBounds(100, 100, 454, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblColor.setBounds(47, 65, 103, 15);
		
		furnitureName = new JLabel (furniture.getName().toUpperCase());
		furnitureName.setHorizontalAlignment(SwingConstants.CENTER);
		furnitureName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		furnitureName.setLocation(138, 0);
		furnitureName.setSize(161, 55);
		contentPane.add(furnitureName);
		
		contentPane.add(lblColor);
		lblStyle.setBounds(47, 95, 103, 15);
		
		contentPane.add(lblStyle);
		comboBoxColor.setBounds(143, 60, 71, 22);
		
		contentPane.add(comboBoxColor);
		comboBoxStyle.setBounds(143, 90, 71, 22);
		
		contentPane.add(comboBoxStyle);
		lblPosition.setBounds(47, 125, 86, 15);
		
		contentPane.add(lblPosition);
		comboBoxX.setBounds(138, 125, 45, 22);
		
		contentPane.add(comboBoxX);
		comboBoxY.setBounds(205, 125, 35, 15);
		comboBoxX.setBounds(143, 125, 34, 15);
		contentPane.add(comboBoxX);
		for(int i=1 ; i<=grid.getGridDimension().getWidth() ; i++)
		{
			comboBoxX.addItem(i);
		}
		
		comboBoxX.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();			
				furniturePositionX = (Integer) combo.getSelectedItem();
				
			}
		});
		
		contentPane.add(comboBoxY);
		for(int j=1 ; j<=grid.getGridDimension().getLength() ; j++)
		{
			comboBoxY.addItem(j);
		}
		
		comboBoxY.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();			
				furniturePositionY = (Integer) combo.getSelectedItem();
					
			}
		});
		contentPane.add(comboBoxY);
		
		lblX.setBounds(195, 125, 19, 14);
		contentPane.add(lblX);
	
		btnAdd.setBounds(294, 95, 89, 23);
		contentPane.add(btnAdd);
		//TODO utiliser ImageIcon(getURL(getCodeBase(),"")) pour integrer les images des meubles
	}
}
