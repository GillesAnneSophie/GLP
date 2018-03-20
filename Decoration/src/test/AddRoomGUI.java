package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

import catalog.Category;
import categories.*;
import place.*;

/**
 * @author CORALIE Laury Ann
 *
 */
public class AddRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	

	private int roomPositionX;
	private int roomPositionY;
	private int roomWidth;
	private int roomLenght;
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox<Integer> comboBoxX = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxY = new JComboBox<Integer>();

	private String stringRoom;
	
	private JButton btnEnter = new JButton("Add");
	
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to add:");
	private JLabel lblX_2 = new JLabel("X");
	private JLabel lblX_3 = new JLabel("X");
	private JLabel lblWidth = new JLabel ("Width:");
	private JLabel lblLength = new JLabel("Length:");
	private JLabel lblPosition = new JLabel ("Coordonates:");
	
	private JTextField textFieldWidth = new JTextField();
	private JTextField textFieldLength = new JTextField();
	
//TODO ajouter choix de la position avec deux JList pour choisir parmis les cases existantes
	
	/**
	 * Launch the application
	 */
	public static void main(Apartment apartment, Grid grid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI(apartment, grid);
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
	public AddRoomGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				stringRoom = (String) combo.getSelectedItem();	
			}
		});
		
		comboBoxRoom.setBounds(179, 39, 99, 20);
		contentPane.add(comboBoxRoom);
		comboBoxRoom.addItem("Bathroom");
		comboBoxRoom.addItem("Bedroom/Office");
		comboBoxRoom.addItem("Dining Room");
		comboBoxRoom.addItem("Kitchen");
		comboBoxRoom.addItem("Living Room");
		
		contentPane.add(btnEnter);

				
		btnEnter.setBounds(360, 64, 76, 23);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(stringRoom == "Bathroom") {
					Category bathroomCategory = new Bathroom();
					Room bathroom = new Room("bathroom", roomWidth, roomLenght, bathroomCategory);
					apartment.addRoom(bathroom, roomPositionX, roomPositionY, grid);
					apartment.getRoomsList().put(null, bathroom);
				}
				if (stringRoom == "Bedroom/Office") {
					Category bedroomOfficeCategory = new BedroomOffice();
					Room bedroomOffice = new Room("bedroomOffice", roomWidth, roomLenght, bedroomOfficeCategory);
					apartment.addRoom(bedroomOffice, roomPositionX, roomPositionY, grid);
					apartment.getRoomsList().put(null, bedroomOffice);
				}
				if (stringRoom == "Dining Room") {
					Category diningRoomCategory = new DiningRoom();
					Room diningRoom = new Room("diningRoom", roomWidth, roomLenght, diningRoomCategory);
					apartment.addRoom(diningRoom, roomPositionX, roomPositionY, grid);
					apartment.getRoomsList().put(null,diningRoom );
				}
				if (stringRoom == "Kitchen") {
					Category kitchenCategory = new Kitchen();
					Room kitchen = new Room("kitchen", roomWidth, roomLenght, kitchenCategory);
					apartment.addRoom(kitchen, roomPositionX, roomPositionY, grid);
					apartment.getRoomsList().put(null, kitchen);
				}
				
				if (stringRoom == "Living Room") {
					Category livingRoomCategory = new LivingRoom();
					Room livingRoom = new Room("livingRoom", roomWidth, roomLenght, livingRoomCategory);
					apartment.addRoom(livingRoom, roomPositionX, roomPositionY, grid);
					apartment.getRoomsList().put(null, livingRoom);
				}
			}
		});	
		contentPane.setLayout(null);
		
		lblChooseTheRoom.setBounds(56, 42, 120, 14);
		contentPane.add(lblChooseTheRoom);
			
		comboBoxX.setBounds(179, 125, 34, 14);
		contentPane.add(comboBoxX);
		for(int i=1 ; i<=grid.getGridDimension().getWidth() ; i++)
		{
			comboBoxX.addItem(i);
		}
		
		comboBoxX.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();			
				roomPositionX = (Integer) combo.getSelectedItem();
				
			}
		});
		
		comboBoxY.setBounds(232, 125, 34, 14);
		contentPane.add(comboBoxY);
		for(int j=1 ; j<=grid.getGridDimension().getLength() ; j++)
		{
			comboBoxY.addItem(j);
		}
		
		comboBoxY.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();			
				roomPositionY = (Integer) combo.getSelectedItem();
					
			}
		});
		
		
		lblX_2.setBounds(220, 94, 19, 14);
		contentPane.add(lblX_2);
		
		lblWidth.setLocation(142, 94);
		lblWidth.setSize(34, 14);
		contentPane.add(lblWidth);
		
		lblPosition.setLocation(123, 125);
		lblPosition.setSize(53, 14);
		contentPane.add(lblPosition);
		
		lblX_3.setBounds(220, 125, 19, 14);		
		contentPane.add(lblX_3);
		lblLength.setBounds(232, 94, 46, 17);
		
		contentPane.add(lblLength);
		
//TODO ça fonctionne pas ça, on rentre jamais dedans
		textFieldWidth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roomWidth = Integer.parseInt(textFieldWidth.getText());
System.err.println(roomWidth);
			}
		});
		textFieldWidth.setBounds(179, 91, 34, 20);
		contentPane.add(textFieldWidth);
		textFieldWidth.setColumns(10);
		
		textFieldLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roomLenght = Integer.parseInt(textFieldLength.getText());
System.err.println(roomLenght);
			}
		});
		textFieldLength.setBounds(272, 91, 34, 20);
		contentPane.add(textFieldLength);
		textFieldLength.setColumns(10);
	}
}
