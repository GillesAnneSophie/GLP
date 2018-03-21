package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import java.util.HashMap;

import place.*;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class RemoveRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to remove:");
	
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	private JButton btnRemove = new JButton("Remove");
	
	private String roomInfo = null;
	
	
	/**
	 * Launch the application
	 * @param apartment
	 * @param grid
	 */
	public static void main(Apartment apartment, Grid grid){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveRoomGUI frame = new RemoveRoomGUI(apartment, grid);
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - Remove a room");
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
	public RemoveRoomGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
				
		lblChooseTheRoom.setBounds(10, 56, 166, 14);
		contentPane.add(lblChooseTheRoom);		

		comboBox.setBounds(209, 53, 99, 20);
		contentPane.add(comboBox);
		
		HashMap<Integer, Room> roomsList = apartment.getRoomsList();
		
		for (int index=0 ; index<roomsList.size() ; index++) 
		{
			String roomListName = roomsList.get(index).getName();
			comboBox.addItem (index + "-" + roomListName);
		}
		
		btnRemove.setBounds(337, 52, 86, 23);
		contentPane.add(btnRemove);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roomInfo = (String) comboBox.getSelectedItem();
				if(roomInfo!=null)
				{
					String[] roomInfoTab = roomInfo.split("-");
					int chosenRoom = Integer.valueOf(roomInfoTab[0]);
					apartment.removeRoom(chosenRoom, grid);
					dispose();
				}
			}
		});
	}
}
