package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import place.*;

/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveFurnitureGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	private JLabel lblChooseRoom = new JLabel("Choose the room to remove the furniture from:");
	private JLabel lblChooseTheFurniture = new JLabel("Choose the furniture to remove:");
	
	private JComboBox <Integer>comboBox = new JComboBox <Integer>();
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox<String> comboBoxFurniture = new JComboBox<String>();
	
	private JButton btnRemove = new JButton ("Remove");

	private Room chosenRoom;
	private AbstractRoom chosenFurniture;
	
	/**
	 * Launch the application.
	 */
	public static void main(Apartment apartment, Grid grid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFurnitureGUI frame = new RemoveFurnitureGUI(apartment, grid);
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
	public RemoveFurnitureGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		HashMap<Integer, Room> room = apartment.getRoomsList();
		for (Integer it : room.keySet()) {
			comboBox.addItem (it);
		}
		contentPane.setLayout(null);
		comboBoxRoom.setBounds(284, 31, 99, 20);
		contentPane.add(comboBoxRoom);
		comboBoxRoom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				chosenFurniture = (AbstractRoom) combo.getSelectedItem();	
				chosenRoom.removeFurniture(chosenFurniture.getName(), grid, apartment.getRoomsList());
				
			}
		});
		
		btnRemove.setBounds(390, 64, 109, 18);
		contentPane.add(btnRemove);
		
		lblChooseRoom.setBounds(10, 34, 275, 14);
		contentPane.add(lblChooseRoom);
		
		lblChooseTheFurniture.setBounds(78, 95, 207, 14);
		contentPane.add(lblChooseTheFurniture);
		
		comboBoxFurniture.setBounds(284, 92, 99, 20);
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
