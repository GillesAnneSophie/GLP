package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

import place.Apartment;
import place.Grid;

/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveRoomGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblChooseTheRoom = new JLabel("Choose the room to remove:");
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JButton btnEnter = new JButton("Remove");
	private String sg;
//TODO "sg" je sais toujours pas ce que c'est
	
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
		contentPane.add(comboBox);
		comboBox.addItem("Kitchen");
		comboBox.addItem("Dining Room");
		comboBox.addItem("Living Room");
		comboBox.addItem("Bedroom/Office");
		comboBox.addItem("Bathroom");
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sg = (String) comboBox.getSelectedItem();				
			}
		});
		
		btnEnter.setBounds(337, 52, 86, 23);
		contentPane.add(btnEnter);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//TODO l'action liée est "apartment.removeRoom("NomDeLaPièce", grid);" (il faut donc aussi passer la grille en paramètre
				if (sg == "Kitchen") {
				
				}
				if (sg == "Dining Room") {
				
				}
				if (sg == "Living Room") {
					
				}
				if (sg == "Bedroom/Office") {
					
				}
				if(sg == "Bathroom") {
					
				}
			}
		});	

	}
}
