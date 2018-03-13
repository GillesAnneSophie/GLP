package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

import catalog.Category;
import categories.*;
import place.Apartment;
import place.Room;

/**
 * @author CORALIE Laury Ann
 *
 */
public class AddRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField textField = new JTextField();
	private JTextField textField_2 = new JTextField();
	
	private int i;
	private int j;
	
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	private String string;
	
	private JButton btnEnter = new JButton("Add");
	
	private JLabel lblChooseTheSize = new JLabel("Enter the size of the room:");
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to add:");
	private JLabel lblX = new JLabel("x");
	
//TODO ajouter "Width: [champ text] x Lenght: []"
//TODO ajouter choix de la position avec deux JList pour choisir parmis les cases existantes
	
	/**
	 * Launch the application
	 */
	public static void main(Apartment apartment) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI(apartment);
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - Add a Room");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public AddRoomGUI(Apartment apartment) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sg = (String) comboBox.getSelectedItem();				
			}
		});
		
		comboBox.setBounds(186, 21, 99, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Kitchen");
		comboBox.addItem("Dining Room");
		comboBox.addItem("Living Room");
		comboBox.addItem("Bedroom/Office");
		comboBox.addItem("Bathroom");
		contentPane.add(btnEnter);
		
		
		lblChooseTheSize.setBounds(10, 69, 165, 14);
		contentPane.add(lblChooseTheSize);
		
		
		textField.setBounds(260, 66, 53, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i = Integer.parseInt(textField.getText()) ;
			}			
		});
		
		textField_2.setColumns(10);
		textField_2.setBounds(186, 66, 53, 17);
		contentPane.add(textField_2);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				j = Integer.parseInt(textField_2.getText());
			}			
		});
				
		btnEnter.setBounds(331, 38, 76, 23);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (string == "Kitchen") {
					Category kitchenCategory = new Kitchen();
					Room kitchen = new Room("kitchen", i, j, kitchenCategory);
					apartment.addRoom(kitchen);
				}
				if (string == "Dining Room") {
					Category diningRoomCategory = new DiningRoom();
					Room diningRoom = new Room("diningRoom", i, j, diningRoomCategory);
					apartment.addRoom(diningRoom);
				}
				if (string == "Living Room") {
					Category livingRoomCategory = new LivingRoom();
					Room livingRoom = new Room("livingRoom", i, j, livingRoomCategory);
					apartment.addRoom(livingRoom);
				}
				if (string == "Bedroom/Office") {
					Category bedroomOfficeCategory = new BedroomOffice();
					Room bedroomOffice = new Room("bedroomOffice", i, j, bedroomOfficeCategory);
					apartment.addRoom(bedroomOffice);
				}
				if(string == "Bathroom") {
					Category bathroomCategory = new Bathroom();
					Room bathroom = new Room("bathroom", i, j, bathroomCategory);
					apartment.addRoom(bathroom);
				}
			}
		});	
		
		contentPane.setLayout(null);
		
		lblChooseTheRoom.setBounds(10, 24, 155, 14);
		contentPane.add(lblChooseTheRoom);
		
		lblX.setBounds(244, 69, 19, 14);
		contentPane.add(lblX);
	}
}
