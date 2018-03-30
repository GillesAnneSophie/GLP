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
	
	private JPanel contentPane;

	private JLabel lblChooseRoom = new JLabel("Choose the room to remove the furniture from:");
	private JLabel lblChooseTheFurniture = new JLabel("Choose the furniture to remove:");
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox<String> comboBoxFurniture = new JComboBox<String>();
	
	private JButton btnRemove = new JButton ("Remove");
	
	private String chosenRoomName = null;
	private String chosenFurnitureInfo = null;
	
	
	/**
	 * Launch the application.
	 * @param apartment
	 * @param grid
	 */
	public static void main(Apartment apartment, Grid grid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFurnitureGUI frame = new RemoveFurnitureGUI(apartment, grid);
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
	 */
	public RemoveFurnitureGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 608, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		comboBoxRoom.addItem("-- Select a room --");
		HashMap<Integer, Room> room = apartment.getRoomsList();
		for (int index=0 ; index<room.size() ; index++) {
			String roomName = room.get(index).getName();
			comboBoxRoom.addItem (roomName);
			
		}

		comboBoxFurniture.addItem("-- Select a room first --");
		comboBoxRoom.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Room selectedRoom = (Room) comboBoxRoom.getSelectedItem();
				HashMap<Integer, AbstractRoom> y = selectedRoom.getAllTheFurnitureOfTheRoom();
				for (int index =0;index<y.size();index++) {
					String furnitureName = y.get(index).getName();
					comboBoxFurniture.addItem(index + "-" + furnitureName);
				}
			}
		});
		
		comboBoxRoom.setBounds(300, 30, 135, 22);
		contentPane.add(comboBoxRoom);
		
		btnRemove.setBounds(473, 57, 109, 22);
		contentPane.add(btnRemove);
		
		lblChooseRoom.setBounds(23, 34, 264, 15);
		contentPane.add(lblChooseRoom);
		
		lblChooseTheFurniture.setBounds(23, 89, 182, 15);
		contentPane.add(lblChooseTheFurniture);
	
//TODO GUI : FONCTIONNE PAS > Si on clique sur le choix du meuble alors on doit afficher la liste des meubles correspondante � la pi�ce s�lectionn�e avant (il faut un Listener?)
		
		
		comboBoxFurniture.setBounds(278, 85, 157, 22);
		contentPane.add(comboBoxFurniture);
	
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chosenFurnitureInfo = (String) comboBoxFurniture.getSelectedItem();
				chosenRoomName = (String) comboBoxRoom.getSelectedItem();
				if(chosenRoomName!=null && chosenFurnitureInfo!=null)
				{
					String[] chosenFurnitureInfoTab = chosenFurnitureInfo.split("-");
					int chosenFurniture = Integer.valueOf(chosenFurnitureInfoTab[0]);
					Room chosenRoom = apartment.getRoom(chosenRoomName);
					chosenRoom.removeFurniture(chosenFurniture, grid, apartment);
					dispose();
				}
			}
		});
	}
}
