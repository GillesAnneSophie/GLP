package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;


/**
 * @author ZOUHOUDI Chabani
 * @author GILLES Anne-Sophie
 * @author CORALIE Laury Ann
 */


public class HomeGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane = new JPanel();
	private static HomeGUI frame = new HomeGUI();
	private JLabel lblManagApart = new JLabel("Manag'Apart");
	private JLabel lblWelcome = new JLabel("Welcome in Manag'Apart!");
	private JLabel lblMessage = new JLabel("You can start a new management by clicking on \"New management\".");
	private JLabel lblHaveFun = new JLabel("Have fun!");
	private JLabel lblAuthors = new JLabel("By CORALIE Laury Ann & GILLES Anne-Sophie & ZOUHOUDI Chabani");
	
	
	private JButton btnNew = new JButton("New management");

	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - Home");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public HomeGUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(200, 100, 582, 324);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		lblManagApart.setBounds(153, 11, 250, 57);
		lblManagApart.setHorizontalAlignment(SwingConstants.CENTER);	
		lblManagApart.setFont(new Font("Papyrus", Font.BOLD, 36));
		contentPane.add(lblManagApart);
		
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWelcome.setBounds(205, 90, 174, 15);
		contentPane.add(lblWelcome);
		
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMessage.setBounds(82, 116, 429, 15);
		contentPane.add(lblMessage);
		
		btnNew.setBounds(215, 169, 141, 22);
		btnNew.setHorizontalAlignment(JButton.CENTER);
		contentPane.add(btnNew);
		
		lblHaveFun.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblHaveFun.setBounds(263, 202, 70, 14);
		contentPane.add(lblHaveFun);
		
		lblAuthors.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblAuthors.setLocation(111, 259);
		lblAuthors.setSize(346, 15);
		contentPane.add(lblAuthors);
		
		
		btnNew.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent arg0) {
				DesignGUI.main(null);
				frame.setVisible(false);
			}
		});
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
				    if (confirmed == JOptionPane.YES_OPTION) {
				    		System.exit(0);
				    }
			  }
		});
	}
}
