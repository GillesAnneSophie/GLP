 package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import catalog.Catalog;
import place.AbstractRoom;

import java.awt.event.*;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class ToolbarGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3392452619174690772L;
	
	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private static ToolbarGUI frame = new ToolbarGUI();
	
	private Object[] room = {"Kitchen","Living Room", "Dining Room", "Bedroom/Office","Bathroom","Wall","Floor"};
	
	private 	JToolBar toolBar = new JToolBar();
	
	private JButton btnAddARoom = new JButton("ADD A ROOM");
	private JButton btnRemoveARoom = new JButton("REMOVE A ROOM");
	private JButton btnRemoveAFurn = new JButton("REMOVE A FURNITURE");
	
	private JSeparator separator = new JSeparator();
	private JSeparator separator_1 = new JSeparator();
	
	private String [] catalog = {"Kitchen","Living Room","Dining Room","Bedroom/Office","Bathroom"};
	private JList <String >list = new JList <String> (catalog);

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame.setVisible(true);
				    frame.setTitle(" Toolbar ");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public ToolbarGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		contentPane.add(panel, BorderLayout.CENTER);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnAddARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddRoomGUI.main(null);
			}
		});
		toolBar.add(btnAddARoom);
		
		btnRemoveARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveRoomGUI.main(null);
			}
		});
			
		toolBar.add(separator);
		toolBar.add(btnRemoveARoom);
		
		btnRemoveAFurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurn);
		
		panel.add(list);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the toolbar?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION) {
			    		dispose();
			    }
			  }
			});
		}
}
