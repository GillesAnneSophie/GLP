package test;

import javax.swing.*;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EmptyBorder;

/**
 * @author CORALIE Laury Ann
 *
 */
public class RemoveRoomGUI extends JFrame {

	private JPanel contentPane;

	
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
		
		JLabel lblChooseTheRoom = new JLabel("Choose the room to remove :");
		lblChooseTheRoom.setBounds(10, 56, 166, 14);
		contentPane.add(lblChooseTheRoom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(209, 53, 99, 20);
		contentPane.add(comboBox);
		comboBox.addItem("Kitchen");
		comboBox.addItem("Dining Room");
		comboBox.addItem("Living Room");
		comboBox.addItem("Bedroom/Office");
		comboBox.addItem("Bathroom");
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setBounds(337, 52, 86, 23);
		contentPane.add(btnEnter);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit ?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION) {
			    		dispose();
			    }
			  }
			});
	}
}
