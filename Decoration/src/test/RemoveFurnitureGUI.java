package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import catalog.Category;
import categories.Bathroom;
import categories.BedroomOffice;
import categories.DiningRoom;
import categories.Kitchen;
import categories.LivingRoom;
import place.AbstractRoom;
import place.Apartment;
import place.Grid;
import place.Room;

/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveFurnitureGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JLabel lblFurnitureRemove;
	
	private JComboBox <Integer>comboBox = new JComboBox <Integer>();
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	
	private JButton btnRemove = new JButton ("Remove");
	
	private String stringRoom;
	
	private Room chosenRoom;
	
	/**
	 * Launch the application.
	 */
	public static void main(AbstractRoom furniture, Grid grid,HashMap<Integer, AbstractRoom> roomList,Apartment apartment) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFurnitureGUI frame = new RemoveFurnitureGUI(furniture,grid,roomList,apartment);
					frame.setVisible(true);
					frame.setTitle("Remove a furniture");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RemoveFurnitureGUI(AbstractRoom furniture, Grid grid,HashMap<Integer, AbstractRoom> roomList,Apartment apartment) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		HashMap<Integer, Room> room = apartment.getRoomsList();
		for (Integer it : room.keySet()) {
			comboBox.addItem (it);
		}
		comboBoxRoom.setBounds(179, 39, 99, 20);
		contentPane.add(comboBoxRoom);
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				stringRoom = (String) combo.getSelectedItem();	
				apartment.getRoomsList();
				if (stringRoom == "Kitchen") {
					
				}
				if (stringRoom == "Dining Room") {
				
				}
				if (stringRoom == "Living Room") {
					
				}
				if (stringRoom == "Bedroom/Office") {
					
				}
				if(stringRoom == "Bathroom") {
					
				}
			}
		});
		
		lblFurnitureRemove.setBounds(10, 56, 166, 14);
		contentPane.add(lblFurnitureRemove);	
		
		/*HashMap<Integer, AbstractRoom> furnitures = stringRoom.getAllTheFurnitureOfTheRoom(); //TODO trouver un moyen de recuperer la liste des pieces 
		for (Integer it : furnitures.keySet()) {
			comboBox.addItem (it);
		}
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				String chosenFurniture = (String) combo.getSelectedItem();	
				stringRoom.removeFurniture(chosenFurniture,grid,apartment);
			}
		});
		*/
		btnRemove.setBounds(337, 52, 86, 23);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});	

	}

}
