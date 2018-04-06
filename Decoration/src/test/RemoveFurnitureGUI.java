package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import place.*;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class RemoveFurnitureGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();

	private JLabel lblChooseRoom = new JLabel("Choose the room to remove the furniture from:");
	private JLabel lblChooseTheFurniture = new JLabel("Choose the furniture to remove:");
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox<String> comboBoxFurniture = new JComboBox<String>();
	
	private JButton btnRemove = new JButton ("Remove");
	
	private String chosenFurnitureInfo = null;
	
	
	/**
	 * Launch the application.
	 * @param apartment
	 * @param grid
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void main(Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFurnitureGUI frame = new RemoveFurnitureGUI(apartment, grid, gridPanel, tabGrid);
					frame.setVisible(true);
					frame.setTitle("Manag'Apart - Remove a furniture");
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
	public RemoveFurnitureGUI(Apartment apartment, Grid grid, JPanel gridPanel, JLabel tabGrid[][]) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 172);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		comboBoxRoom.setBounds(300, 30, 135, 22);
		comboBoxRoom.addItem("-- Select a room --");
		contentPane.add(comboBoxRoom);
		HashMap<Integer, Room> roomsList = apartment.getRoomsList();
		for (int index=0 ; index<roomsList.size() ; index++) {
			String roomName = roomsList.get(index).getName();
			comboBoxRoom.addItem (index + "-" + roomName);
		}
		
		btnRemove.setBounds(473, 57, 109, 22);
		contentPane.add(btnRemove);
		
		lblChooseRoom.setBounds(23, 34, 264, 15);
		contentPane.add(lblChooseRoom);
		
		lblChooseTheFurniture.setBounds(23, 89, 182, 15);
		contentPane.add(lblChooseTheFurniture);
	
		comboBoxFurniture.setBounds(278, 85, 157, 22);
		comboBoxFurniture.addItem("-- Select a room first --");
		contentPane.add(comboBoxFurniture);
	
		
		comboBoxRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String selectedRoom = (String) comboBoxRoom.getSelectedItem();			
				String[] roomInfoTab = selectedRoom.split("-");
				int chosenRoomIndex = Integer.valueOf(roomInfoTab[0]);
				Room choosenRoom = apartment.getRoom(chosenRoomIndex);
				
				HashMap<Integer, AbstractRoom> y = choosenRoom.getAllTheFurnitureOfTheRoom();
				for (int index =0;index<y.size();index++) {
					String furnitureName = y.get(index).getName();
					comboBoxFurniture.addItem(index + "-" + furnitureName);
				}
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chosenFurnitureInfo = (String) comboBoxFurniture.getSelectedItem();
				String selectedRoom = (String) comboBoxRoom.getSelectedItem();			
				String[] roomInfoTab = selectedRoom.split("-");
				int chosenRoomIndex = Integer.valueOf(roomInfoTab[0]);
				
				if(chosenRoomIndex>=0 && chosenFurnitureInfo!=null)
				{
					String[] chosenFurnitureInfoTab = chosenFurnitureInfo.split("-");
					int chosenFurniture = Integer.valueOf(chosenFurnitureInfoTab[0]);
					
					Room chosenRoom = apartment.getRoom(chosenRoomIndex);
					chosenRoom.removeFurniture(chosenFurniture, grid, apartment);
					
					PrintDrawing.updateRooms(grid, gridPanel, tabGrid);
					DesignGUI.setStatistics();
					dispose();
				}
			}
		});
	}
}
