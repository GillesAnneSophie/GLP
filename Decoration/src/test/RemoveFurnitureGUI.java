package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import place.*;

/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveFurnitureGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JLabel lblFurnitureRemove;
	
	private JComboBox <Integer>comboBox = new JComboBox <Integer>();
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	
	private JButton btnRemove = new JButton ("Remove");

	private Room chosenRoom;
	private AbstractRoom chosenFurniture;
	
	/**
	 * Launch the application.
	 */
	public static void main(AbstractRoom furniture, Grid grid,HashMap<Integer, Room> roomList,Apartment apartment) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFurnitureGUI frame = new RemoveFurnitureGUI(furniture,grid,roomList,apartment);
					frame.setVisible(true);
					frame.setTitle("Remove a furniture");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RemoveFurnitureGUI(AbstractRoom furniture, Grid grid,HashMap<Integer, Room> roomList,Apartment apartment) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		HashMap<Integer, Room> room = apartment.getRoomsList();
		for (Integer it : room.keySet()) {
			comboBox.addItem (it);
		}
		contentPane.setLayout(null);
		comboBoxRoom.setBounds(246, 62, 99, 20);
		contentPane.add(comboBoxRoom);
		comboBoxRoom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				chosenFurniture = (AbstractRoom) combo.getSelectedItem();	
				chosenRoom.removeFurniture(chosenFurniture.getName(), grid, roomList);
				
			}
		});
		
		lblFurnitureRemove.setBounds(10, 56, 166, 14);
		contentPane.add(lblFurnitureRemove);	
		
		btnRemove.setBounds(315, 93, 109, 18);
		contentPane.add(btnRemove);
		
		JLabel lblChooseRoom = new JLabel("Choose the room to remove the furniture from:");
		lblChooseRoom.setBounds(10, 65, 234, 14);
		contentPane.add(lblChooseRoom);
		
		JLabel lblChooseTheFurniture = new JLabel("Choose the furniture to remove:");
		lblChooseTheFurniture.setBounds(10, 123, 166, 14);
		contentPane.add(lblChooseTheFurniture);
		
		JComboBox<String> comboBoxFurniture = new JComboBox<String>();
		comboBoxFurniture.setBounds(173, 120, 99, 20);
		contentPane.add(comboBoxFurniture);
		comboBoxFurniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				String chosenFurniture = (String) combo.getSelectedItem();	
				chosenRoom.removeFurniture(chosenFurniture, grid, apartment.getRoomsList());
			}
		});
		
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});	

	}
}
