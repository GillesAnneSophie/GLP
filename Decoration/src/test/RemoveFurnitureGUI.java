package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
	
//TODO totalement bugg� > suppr fonctionne pas + g�n�re nullPointerException en cliquand tu le bouton toolbar ensuite.
	/**
	 * Launch the application
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
	 * Create the frame
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
		
		HashMap<Integer, Room> room = apartment.getRoomsList();
		for (int index=0 ; index<room.size() ; index++) {
			String roomName = room.get(index).getName();
			comboBoxRoom.addItem (roomName);
		}
		
		comboBoxRoom.setBounds(289, 30, 135, 22);
		contentPane.add(comboBoxRoom);
		
		btnRemove.setBounds(473, 57, 109, 22);
		contentPane.add(btnRemove);
		
		lblChooseRoom.setBounds(23, 34, 264, 15);
		contentPane.add(lblChooseRoom);
		
		lblChooseTheFurniture.setBounds(105, 89, 182, 15);
		contentPane.add(lblChooseTheFurniture);
		
		for (int index=0;index<room.size();index++) {
			HashMap<Integer, AbstractRoom> y = room.get(index).getAllTheFurnitureOfTheRoom();
			for (int index2 =0;index2<y.size();index2++) {
				String furnitureName = y.get(index2).getName();
				comboBoxFurniture.addItem(index + "-" + furnitureName);
			}
		}
		
		comboBoxFurniture.setBounds(289, 85, 120, 22);
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
