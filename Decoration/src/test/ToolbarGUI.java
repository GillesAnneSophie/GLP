package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author lauryanncoralie
 *
 */
public class ToolbarGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToolbarGUI frame = new ToolbarGUI();
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
	public ToolbarGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 77);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnAddARoom = new JButton("ADD A ROOM");
		btnAddARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddRoomGUI.main(null);
			}
		});
		toolBar.add(btnAddARoom);
		
		JButton btnRemoveARoom = new JButton("REMOVE A ROOM");
		btnRemoveARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveRoomGUI.main(null);
			}
		});
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		toolBar.add(btnRemoveARoom);
		
		JButton btnRemoveAFurn = new JButton("REMOVE A FURNITURE");
		btnRemoveAFurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurn);
	}

}
