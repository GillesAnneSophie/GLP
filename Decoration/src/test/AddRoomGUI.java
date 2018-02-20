package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

/**
 * @author lauryanncoralie
 *
 */
public class AddRoomGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRoomGUI frame = new AddRoomGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
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
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(244, 69, 19, 14);
		contentPane.add(lblX);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(186, 66, 53, 17);
		contentPane.add(textField_2);
	}
}
/*	class RoomListener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
		}
	}
*/
