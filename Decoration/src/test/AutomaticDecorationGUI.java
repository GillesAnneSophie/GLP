/**
 * 
 */
package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
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
	 */
	public AutomaticDecorationGUI(Catalog catalog, Apartment apartment, Grid grid)
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 399, 214);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblStyle.setBounds(35, 61, 106, 15);
		contentPane.add(lblStyle);
		
		comboBoxStyle.addItem("- Select style -");
		comboBoxStyle.addItem("Basic");
		comboBoxStyle.addItem("Modern");
		comboBoxStyle.addItem("Rustic");
		comboBoxStyle.addItem("Vintage");
		
		comboBoxStyle.setBounds(151, 57, 92, 22);
		contentPane.add(comboBoxStyle);
		
		lblQuantity.setBounds(35, 99, 106, 15);
		contentPane.add(lblQuantity);
		
		comboBoxQuantity.addItem("- Select quantity -");
		comboBoxQuantity.addItem("Minimalist");
		comboBoxQuantity.addItem("Basic");
		comboBoxQuantity.addItem("Maximalist");
		
		comboBoxQuantity.setBounds(151, 95, 92, 22);
		contentPane.add(comboBoxQuantity);
		
		btnAdd.setBounds(284, 75, 89, 22);
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
