package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EmptyBorder;

import catalog.Category;
import categories.*;
import place.*;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class AddRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox<Integer> comboBoxX = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxY = new JComboBox<Integer>();

	private JButton btnEnter = new JButton("Add");
	
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to add:");
	private JLabel lblX_2 = new JLabel("X");
	private JLabel lblX_3 = new JLabel("X");
	private JLabel lblWidth = new JLabel ("Width:");
	private JLabel lblLength = new JLabel("Length:");
	private JLabel lblPosition = new JLabel ("Coordinates:");
	
	private SpinnerModel spinnerModel1 = new SpinnerNumberModel (0,0,100,1);
	private SpinnerModel spinnerModel2 = new SpinnerNumberModel (0,0,100,1);
	private JSpinner textFieldWidth = new JSpinner(spinnerModel1);
	private JSpinner textFieldLength = new JSpinner(spinnerModel2);
	
	private String stringRoom;
	private int roomPositionX=-1;
	private int roomPositionY=-1;
	private int roomWidth=-1;
	private int roomLength=-1;
	
	
	/**
	 * Launch the application
	 * @param apartment
	 * @param grid
	 */
	public static void main(Apartment apartment, Grid grid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI(apartment, grid);
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - Add a room");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 * @param apartment
	 * @param grid
	 */
	public AddRoomGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		comboBoxRoom.setBounds(179, 39, 99, 20);
		contentPane.add(comboBoxRoom);
		comboBoxRoom.addItem("Kitchen");
		comboBoxRoom.addItem("Bathroom");
		comboBoxRoom.addItem("Bedroom/Office");
		comboBoxRoom.addItem("Dining Room");
		comboBoxRoom.addItem("Living Room");
		
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				stringRoom = (String) combo.getSelectedItem();	
			}
		});
		
		contentPane.add(btnEnter);
		contentPane.setLayout(null);
		
		lblChooseTheRoom.setBounds(25, 42, 151, 14);
		contentPane.add(lblChooseTheRoom);
		
		comboBoxX.setBounds(179, 110, 34, 15);
		contentPane.add(comboBoxX);
		comboBoxY.setBounds(232, 110, 34, 15);
		contentPane.add(comboBoxY);
		
		for(int i=1 ; i<=grid.getGridDimension().getWidth() ; i++)
		{
			comboBoxX.addItem(i);
		}
		for(int j=1 ; j<=grid.getGridDimension().getLength() ; j++)
		{
			comboBoxY.addItem(j);
		}
		
		lblX_2.setBounds(208, 78, 19, 14);
		contentPane.add(lblX_2);
		
		lblWidth.setLocation(123, 78);
		lblWidth.setSize(53, 14);
		contentPane.add(lblWidth);
		
		lblPosition.setLocation(98, 110);
		lblPosition.setSize(78, 14);
		contentPane.add(lblPosition);
		
		lblX_3.setBounds(220, 110, 19, 14);		
		contentPane.add(lblX_3);
		
		lblLength.setBounds(228, 78, 58, 17);
		contentPane.add(lblLength);
		
		textFieldWidth.setBounds(164, 78, 34, 20);
		contentPane.add(textFieldWidth);
		
		textFieldLength.setBounds(272, 78, 34, 20);
		contentPane.add(textFieldLength);
		
		textFieldWidth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				roomWidth = (int) textFieldWidth.getValue();
			}
		});
		
		textFieldLength.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				roomLength = (int) textFieldLength.getValue();
			}
		});
		
		btnEnter.setBounds(360, 64, 76, 23);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roomPositionY = Integer.valueOf(comboBoxY.getSelectedItem().toString())-1;
				roomPositionX = Integer.valueOf(comboBoxX.getSelectedItem().toString())-1;
				boolean dontClose = false;
				
				if(stringRoom == "Bathroom") {
					Category bathroomCategory = new Bathroom();
					Room bathroom = new Room("bathroom", roomWidth, roomLength, bathroomCategory);
					if(!apartment.addRoom(bathroom, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						//TODO POPUP qui dit : "ERROR: Bathroom could not be add!" avec bouton OK
					}
				}
				else if (stringRoom == "Bedroom/Office") {
					Category bedroomOfficeCategory = new BedroomOffice();
					Room bedroomOffice = new Room("bedroomOffice", roomWidth, roomLength, bedroomOfficeCategory);
					if(!apartment.addRoom(bedroomOffice, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						//TODO POPUP qui dit : "ERROR: Bathroom could not be add!" avec bouton OK
					}
				}
				else if (stringRoom == "Dining Room") {
					Category diningRoomCategory = new DiningRoom();
					Room diningRoom = new Room("diningRoom", roomWidth, roomLength, diningRoomCategory);
					if(!apartment.addRoom(diningRoom, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						//TODO POPUP qui dit : "ERROR: Bathroom could not be add!" avec bouton OK
					}
				}
				else if (stringRoom == "Kitchen") {
					Category kitchenCategory = new Kitchen();
					Room kitchen = new Room("kitchen", roomWidth, roomLength, kitchenCategory);
					if(!apartment.addRoom(kitchen, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						//TODO POPUP qui dit : "ERROR: Bathroom could not be add!" avec bouton OK
					}
				}
				else if (stringRoom == "Living Room") {
					Category livingRoomCategory = new LivingRoom();
					Room livingRoom = new Room("livingRoom", roomWidth, roomLength, livingRoomCategory);
					if(!apartment.addRoom(livingRoom, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						//TODO POPUP qui dit : "ERROR: Bathroom could not be add!" avec bouton OK
					}
				}
				if(stringRoom!=null && roomWidth!=-1 && roomLength!=-1 && roomPositionX!=-1 && roomPositionY!=-1 && dontClose==false)
				{
					dispose();
				}
			}
		});	
	}
}
