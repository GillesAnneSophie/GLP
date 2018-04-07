/**
 * 
 */
package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import catalog.Catalog;
import place.Apartment;
import place.AutomaticDecoration;
import place.Grid;
import place.Statistics;


/**
 * @author GILLES Anne-Sophie
 */


public class AutomaticDecorationGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();
	
	private JLabel lblStyle = new JLabel ("Choose the style:");
	private JLabel lblQuantity = new JLabel("Choose the quantity:");
	
	private JComboBox<String> comboBoxStyle = new JComboBox<String> ();
	private JComboBox<String> comboBoxQuantity = new JComboBox<String> ();
	
	private JButton btnAdd = new JButton ("Add");
	
	private String style = null;
	private String quantity = null;
	
	
	/**
	 * Launch the application.
	 * @param catalog
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void main(Catalog catalog, Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutomaticDecorationGUI frame = new AutomaticDecorationGUI(catalog, apartment, grid, gridPanel, tabGrid);
					frame.setVisible(true);
					frame.setTitle("Manag'Apart - Automatic decoration");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 * @param catalog
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public AutomaticDecorationGUI(Catalog catalog, Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][]){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 214);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblStyle.setBounds(24, 61, 106, 15);
		contentPane.add(lblStyle);
		
		comboBoxStyle.setBounds(151, 57, 123, 22);
		comboBoxStyle.setPreferredSize(new Dimension(35, 20));
		comboBoxStyle.addItem("- Select style -");
		comboBoxStyle.addItem("Basic");
		comboBoxStyle.addItem("Modern");
		comboBoxStyle.addItem("Rustic");
		comboBoxStyle.addItem("Vintage");
		contentPane.add(comboBoxStyle);
		
		lblQuantity.setBounds(24, 99, 121, 15);
		contentPane.add(lblQuantity);
		
		comboBoxQuantity.setBounds(151, 95, 123, 22);
		comboBoxQuantity.setPreferredSize(new Dimension(35, 20));
		comboBoxQuantity.addItem("- Select quantity -");
		comboBoxQuantity.addItem("Minimalist");
		comboBoxQuantity.addItem("Basic");
		comboBoxQuantity.addItem("Maximalist");
		contentPane.add(comboBoxQuantity);
		
		btnAdd.setBounds(299, 75, 89, 22);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				style = comboBoxStyle.getSelectedItem().toString(); 
				quantity = comboBoxQuantity.getSelectedItem().toString();
				
				if(Statistics.numberOfRooms(apartment.getRoomsList())==0)
				{
					JOptionPane.showMessageDialog(null,"ERROR: there is no room!", "ERROR",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(style != "- Select style -" && quantity != "- Select quantity -")
				{
					new AutomaticDecoration(quantity, style, catalog, apartment, grid, gridPanel, tabGrid);
					dispose();
				}
			}
		});
	}
}
