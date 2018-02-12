package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class DesignGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignGUI frame = new DesignGUI();
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
	public DesignGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRooms = new JMenu("Rooms");
		menuBar.add(mnRooms);
		
		JMenu mnKitchen = new JMenu("Kitchen");
		mnRooms.add(mnKitchen);
		
		JMenu mnBedroomoffice = new JMenu("BedroomOffice");
		mnRooms.add(mnBedroomoffice);
		
		JMenu mnLivingroom = new JMenu("LivingRoom");
		mnRooms.add(mnLivingroom);
		
		JMenu mnWall = new JMenu("Wall");
		mnRooms.add(mnWall);
		
		JMenu mnFloor = new JMenu("Floor");
		mnRooms.add(mnFloor);
		
		JMenu mnBathroom = new JMenu("Bathroom");
		mnRooms.add(mnBathroom);
		
		JMenu mnDiningroom = new JMenu("DiningRoom");
		mnRooms.add(mnDiningroom);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
