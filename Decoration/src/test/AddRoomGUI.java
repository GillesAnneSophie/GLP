package test;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

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
	 * Launch the application.
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
	 * Create the frame.
	 * @param apartment
	 * @param grid
	 */
	public AddRoomGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		comboBoxRoom.setBounds(172, 36, 127, 22);
		contentPane.add(comboBoxRoom);
		comboBoxRoom.addItem("-- Select a room --");
		comboBoxRoom.addItem("Bathroom");
		comboBoxRoom.addItem("Bedroom/Office");
		comboBoxRoom.addItem("Dining Room");
		comboBoxRoom.addItem("Kitchen");
		comboBoxRoom.addItem("Living Room");
		
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				stringRoom = (String) combo.getSelectedItem();	
			}
		});
		
		contentPane.add(btnEnter);
		contentPane.setLayout(null);
		
		lblChooseTheRoom.setBounds(161, 11, 142, 15);
		contentPane.add(lblChooseTheRoom);
		
		comboBoxX.setBounds(240, 80, 41, 22);
		contentPane.add(comboBoxX);
		comboBoxY.setBounds(315, 80, 41, 22);
		contentPane.add(comboBoxY);
		
		for(int i=1 ; i<=grid.getGridDimension().getWidth() ; i++)
		{
			comboBoxX.addItem(i);
		}
		for(int j=1 ; j<=grid.getGridDimension().getLength() ; j++)
		{
			comboBoxY.addItem(j);
		}
		
		lblWidth.setLocation(27, 70);
		lblWidth.setSize(41, 15);
		contentPane.add(lblWidth);
		
		lblPosition.setLocation(145, 84);
		lblPosition.setSize(85, 15);
		contentPane.add(lblPosition);
		
		lblX_3.setBounds(295, 84, 19, 14);		
		contentPane.add(lblX_3);
		
		lblLength.setBounds(27, 100, 51, 15);
		contentPane.add(lblLength);
		
		textFieldWidth.setBounds(88, 66, 47, 22);
		contentPane.add(textFieldWidth);
		
		textFieldLength.setBounds(88, 96, 47, 22);
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
		
		btnEnter.setBounds(371, 66, 76, 22);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roomPositionY = Integer.valueOf(comboBoxY.getSelectedItem().toString())-1;
				roomPositionX = Integer.valueOf(comboBoxX.getSelectedItem().toString())-1;
				boolean dontClose = false;
				
				if(stringRoom == "Bathroom") {
					Category bathroomCategory = new Bathroom();
					Room bathroom = new Room("Bathroom", roomWidth, roomLength, bathroomCategory);
					if(!apartment.addRoom(bathroom, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						JOptionPane.showMessageDialog(null,"ERROR: Bathroom could not be add!", "ERROR",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (stringRoom == "Bedroom/Office") {
					Category bedroomOfficeCategory = new BedroomOffice();
					Room bedroomOffice = new Room("Bedroom/Office", roomWidth, roomLength, bedroomOfficeCategory);
					if(!apartment.addRoom(bedroomOffice, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						JOptionPane.showMessageDialog(null,"ERROR: Bedroom/Office could not be add!", "ERROR",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (stringRoom == "Dining Room") {
					Category diningRoomCategory = new DiningRoom();
					Room diningRoom = new Room("Dining Room", roomWidth, roomLength, diningRoomCategory);
					if(!apartment.addRoom(diningRoom, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						JOptionPane.showMessageDialog(null,"ERROR: Dining Room could not be add!", "ERROR",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (stringRoom == "Kitchen") {
					Category kitchenCategory = new Kitchen();
					Room kitchen = new Room("Kitchen", roomWidth, roomLength, kitchenCategory);
					if(!apartment.addRoom(kitchen, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						JOptionPane.showMessageDialog(null,"ERROR: Kitchen could not be add!", "ERROR",JOptionPane.INFORMATION_MESSAGE);	
					}
				}
				else if (stringRoom == "Living Room") {
					Category livingRoomCategory = new LivingRoom();
					Room livingRoom = new Room("Living Room", roomWidth, roomLength, livingRoomCategory);
					if(!apartment.addRoom(livingRoom, roomPositionX, roomPositionY, grid))
					{
						dontClose = true;
						JOptionPane.showMessageDialog(null,"ERROR: Living Room could not be add!", "ERROR",JOptionPane.INFORMATION_MESSAGE);	
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
