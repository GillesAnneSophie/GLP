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


/**
 * @author GILLES Anne-Sophie
 */
public class AutomaticDecorationGUI extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
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
	 */
	public static void main(Catalog catalog, Apartment apartment, Grid grid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutomaticDecorationGUI frame = new AutomaticDecorationGUI(catalog, apartment, grid);
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
	 */
	public AutomaticDecorationGUI(Catalog catalog, Apartment apartment, Grid grid)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 214);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStyle.setBounds(24, 61, 106, 15);
		contentPane.add(lblStyle);
		comboBoxStyle.setMinimumSize(new Dimension(30, 20));
		comboBoxStyle.setPreferredSize(new Dimension(35, 20));
		
		comboBoxStyle.addItem("- Select style -");
		comboBoxStyle.addItem("Basic");
		comboBoxStyle.addItem("Modern");
		comboBoxStyle.addItem("Rustic");
		comboBoxStyle.addItem("Vintage");
		
		comboBoxStyle.setBounds(151, 57, 123, 22);
		contentPane.add(comboBoxStyle);
		
		lblQuantity.setBounds(24, 99, 121, 15);
		contentPane.add(lblQuantity);
		comboBoxQuantity.setMinimumSize(new Dimension(30, 20));
		comboBoxQuantity.setPreferredSize(new Dimension(35, 20));
		
		comboBoxQuantity.addItem("- Select quantity -");
		comboBoxQuantity.addItem("Minimalist");
		comboBoxQuantity.addItem("Basic");
		comboBoxQuantity.addItem("Maximalist");
		
		comboBoxQuantity.setBounds(151, 95, 123, 22);
		contentPane.add(comboBoxQuantity);
		
		btnAdd.setBounds(299, 75, 89, 22);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				style = comboBoxStyle.getSelectedItem().toString(); 
				quantity = comboBoxQuantity.getSelectedItem().toString();
				
				if(style != null && quantity != null)
				{
					new AutomaticDecoration(quantity, style, catalog, apartment, grid);
				}
			}
		});
		
	}
}
