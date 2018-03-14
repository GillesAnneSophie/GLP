package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.border.EmptyBorder;

import place.*;

/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to remove:");
	private JComboBox<Integer> comboBox = new JComboBox<Integer>();
	private JButton btnEnter = new JButton("Remove");
	private String string;
	
	/**
	 * Launch the application
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
	 */
	public RemoveRoomGUI(Apartment apartment, Grid grid) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lblChooseTheRoom.setBounds(10, 56, 166, 14);
		contentPane.add(lblChooseTheRoom);		

//TODO la liste doit être la liste des pièces présentent dans l'Apartement (à passer en paramètre, donc)
		comboBox.setBounds(209, 53, 99, 20);
		HashMap<Integer, Room> room = apartment.getRoomsList();
		for (Integer it : room.keySet()) {
			comboBox.addItem (it);
		}
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String string = (String) comboBox.getSelectedItem();				
			}
		});
		
		btnEnter.setBounds(337, 52, 86, 23);
		contentPane.add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (string == "Kitchen") {
					apartment.removeRoom("kitchen", grid);
				}
				if (string == "Dining Room") {
					apartment.removeRoom("diningRoom", grid);
				}
				if (string == "Living Room") {
					apartment.removeRoom("livingRoom", grid);
				}
				if (string == "Bedroom/Office") {
					apartment.removeRoom("bedroomOffice", grid);
				}
				if(string == "Bathroom") {
					apartment.removeRoom("bathroom", grid);
				}
			}
		});	

	}
}
