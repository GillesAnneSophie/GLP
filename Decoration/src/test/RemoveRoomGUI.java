package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import java.util.HashMap;

import place.*;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class RemoveRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();
	
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to remove:");
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	
	private JButton btnRemove = new JButton("Remove");
	
	private String roomInfo = null;
	
	
	/**
	 * Launch the application.
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void main(Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveRoomGUI frame = new RemoveRoomGUI(apartment, grid, gridPanel, tabGrid);
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - Remove a room");
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
	 * @param gridPanel
	 * @param tabGrid
	 */
	public RemoveRoomGUI(Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][]) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 458, 106);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
				
		lblChooseTheRoom.setBounds(21, 25, 174, 15);
		contentPane.add(lblChooseTheRoom);		

		comboBoxRoom.setBounds(192, 21, 135, 22);
		comboBoxRoom.addItem("-- Select a room --");
		contentPane.add(comboBoxRoom);
		
		HashMap<Integer, Room> roomsList = apartment.getRoomsList();
		int size = roomsList.size();
		int counter=0;
		int index=0;
		while(counter<size)
		{
			if(roomsList.get(index) != null)
			{
				String roomListName = roomsList.get(index).getName();
				comboBoxRoom.addItem (index + "-" + roomListName);
				counter++;
			}
			index++;
		}
		
		btnRemove.setBounds(346, 21, 86, 22);
		contentPane.add(btnRemove);
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roomInfo = (String) comboBoxRoom.getSelectedItem();
				if(roomInfo != "-- Select a room --")
				{
					String[] roomInfoTab = roomInfo.split("-");
					int chosenRoom = Integer.valueOf(roomInfoTab[0]);
					apartment.removeRoom(chosenRoom, grid);
					
					PrintDrawing.updateRooms(apartment, grid, gridPanel, tabGrid);
					DesignGUI.setStatistics();
					dispose();
				}
			}
		});
	}
}
