package test;

import javax.swing.*;
import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;

import catalog.Catalog;

/**
 * @author lauryanncoralie
 *
 */
public class AddRoomGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private Catalog cat;
	private int i;
	private int j;
	
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI();
					frame.setVisible(true);
				    frame.setTitle(" Add a Room");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public AddRoomGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 473, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(331, 38, 76, 23);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblChooseTheRoom = new JLabel("Choose the room to add :");
		lblChooseTheRoom.setBounds(10, 24, 155, 14);
		contentPane.add(lblChooseTheRoom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sg = (String) comboBox.getSelectedItem();
				switch (sg) {
					case "Kitchen":
						break;
					case "Dining Room":
						break;
					case "Living Room":
						/*Category livingRoomCategory = new LivingRoom();
						Room livigRoom = new Room("livingRoom", i, j, livingRoomCategory);
						*/
						break;
					case "Bedroom/Office":
						break;
					case "Bathroom":
						break;
				}
			}
		});
		comboBox.setBounds(186, 21, 99, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Kitchen");
		comboBox.addItem("Dining Room");
		comboBox.addItem("Living Room");
		comboBox.addItem("Bedroom/Office");
		comboBox.addItem("Bathroom");
		contentPane.add(btnEnter);
		
		JLabel lblChooseTheSize = new JLabel("Choose the size of the room :");
		lblChooseTheSize.setBounds(10, 69, 165, 14);
		contentPane.add(lblChooseTheSize);
		
		textField = new JTextField();
		textField.setBounds(260, 66, 53, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		/*i = Integer.parseInt(textField.getText()) ;*/
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(244, 69, 19, 14);
		contentPane.add(lblX);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 66, 53, 17);
		contentPane.add(textField_2);
		/*j = Integer.parseInt(textField_2.getText());*/
	}
}
