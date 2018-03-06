package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;


/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveRoomGUI extends JFrame {

	private JPanel contentPane;

	private JLabel lblChooseTheRoom = new JLabel("Choose the room to remove :");
	
	private JComboBox<String> comboBox = new JComboBox<String>();
	
	private JButton btnEnter = new JButton("Enter");
	
	private String sg;
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveRoomGUI frame = new RemoveRoomGUI();
					frame.setVisible(true);
				    frame.setTitle(" Remove a room");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public RemoveRoomGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lblChooseTheRoom.setBounds(10, 56, 166, 14);
		contentPane.add(lblChooseTheRoom);		
		
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
