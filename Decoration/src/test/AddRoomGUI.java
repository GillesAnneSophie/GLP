package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Random;

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
	

	private int positionX;
	private int positionY;
	private int n;
	private int width;
	private int lenght;
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox<Integer> comboBoxX = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxY = new JComboBox<Integer>();

	private String stringRoom;
	
	private JButton btnEnter = new JButton("Add");
	
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to add:");
	private JLabel lblX_2 = new JLabel("X");
	private JLabel lblX_3 = new JLabel("X");
	private JLabel lblWidth = new JLabel ("Width:");
	private JLabel lblPosition = new JLabel ("Coodinate:");
	private final JLabel lblLength = new JLabel("Length:");

	private Random rand = new Random();
	
	private JTextField textField_2 = new JTextField();
	private JTextField textField_1 = new JTextField();;
	
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
		
		n = rand.nextInt(10) + 1;
		
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
		comboBoxRoom.addItem("Kitchen");
		comboBoxRoom.addItem("Dining Room");
		comboBoxRoom.addItem("Living Room");
		comboBoxRoom.addItem("Bedroom/Office");
		comboBoxRoom.addItem("Bathroom");
		contentPane.add(btnEnter);

				
		btnEnter.setBounds(360, 64, 76, 23);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (stringRoom == "Kitchen") {
					Category kitchenCategory = new Kitchen();
					Room kitchen = new Room("kitchen"+n, width, lenght, kitchenCategory);
					apartment.addRoom(kitchen,positionX,positionY,grid);
					apartment.getRoomsList().put(null, kitchen);
				}
				if (stringRoom == "Dining Room") {
					Category diningRoomCategory = new DiningRoom();
					Room diningRoom = new Room("diningRoom"+n, width, lenght, diningRoomCategory);
					apartment.addRoom(diningRoom,positionX,positionY,grid);
					apartment.getRoomsList().put(null,diningRoom );
				}
				if (stringRoom == "Living Room") {
					Category livingRoomCategory = new LivingRoom();
					Room livingRoom = new Room("livingRoom"+n, width, lenght, livingRoomCategory);
					apartment.addRoom(livingRoom,positionX,positionY,grid);
					apartment.getRoomsList().put(null, livingRoom);
				}
				if (stringRoom == "Bedroom/Office") {
					Category bedroomOfficeCategory = new BedroomOffice();
					Room bedroomOffice = new Room("bedroomOffice"+n, width, lenght, bedroomOfficeCategory);
					apartment.addRoom(bedroomOffice,positionX,positionY,grid);
					apartment.getRoomsList().put(null, bedroomOffice);
				}
				if(stringRoom == "Bathroom") {
					Category bathroomCategory = new Bathroom();
					Room bathroom = new Room("bathroom"+n, width, lenght, bathroomCategory);
					apartment.addRoom(bathroom,positionX,positionY,grid);
					apartment.getRoomsList().put(null, bathroom);
				}
			}
		});	
		contentPane.setLayout(null);
		
		lblChooseTheRoom.setBounds(56, 42, 120, 14);
		contentPane.add(lblChooseTheRoom);
			
		comboBoxX.setBounds(179, 125, 34, 14);
		contentPane.add(comboBoxX);
		comboBoxX.addItem(0);
		comboBoxX.addItem(1);
		comboBoxX.addItem(2);
		comboBoxX.addItem(3);
		comboBoxX.addItem(4);
		comboBoxX.addItem(5);
		comboBoxX.addItem(6);
		comboBoxX.addItem(7);
		comboBoxX.addItem(8);
		comboBoxX.addItem(9);
		comboBoxX.addItem(10);
		comboBoxX.addItem(11);
		comboBoxX.addItem(12);
		comboBoxX.addItem(13);
		comboBoxX.addItem(14);
		comboBoxX.addItem(15);
		comboBoxX.addItem(16);
		comboBoxX.addItem(17);
		comboBoxX.addItem(18);
		comboBoxX.addItem(19);
		
		comboBoxX.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();			
				positionX = (Integer) combo.getSelectedItem();
				
			}
		});
		
		comboBoxY.setBounds(232, 125, 34, 14);
		contentPane.add(comboBoxY);
		comboBoxY.addItem(0);
		comboBoxY.addItem(1);
		comboBoxY.addItem(2);
		comboBoxY.addItem(3);
		comboBoxY.addItem(4);
		comboBoxY.addItem(5);
		comboBoxY.addItem(6);
		comboBoxY.addItem(7);
		comboBoxY.addItem(8);
		comboBoxY.addItem(9);
		comboBoxY.addItem(10);
		comboBoxY.addItem(11);
		comboBoxY.addItem(12);
		comboBoxY.addItem(13);
		comboBoxY.addItem(14);
		comboBoxY.addItem(15);
		comboBoxY.addItem(16);
		comboBoxY.addItem(17);
		comboBoxY.addItem(18);
		comboBoxY.addItem(19);
		
		comboBoxY.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();			
				positionY = (Integer) combo.getSelectedItem();
					
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
		
		
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				width = Integer.parseInt(textField_2.getText());
			}
		});
		textField_2.setBounds(179, 91, 34, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lenght = Integer.parseInt(textField_1.getText());
			}
		});
		textField_1.setBounds(272, 91, 34, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
