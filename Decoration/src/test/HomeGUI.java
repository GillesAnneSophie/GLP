package test;

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
//TODO GUI : afficher le titre du logiciel en grand du coup ? \/
	private JLabel lblName = new JLabel("Manag'Apart");
	private JLabel lblWelcome = new JLabel ( "Welcome!");
	private JLabel lblAuthor = new JLabel ("By CORALIE Laury Ann & GILLES Anne-Sophie & ZOUHOUDI Chabani");
	private final JLabel lblMessage = new JLabel("Here you can manage your apartment by clicking on 'New management'");
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
		setBounds(100, 100, 877, 272);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		contentPane.add(lblName);
		
		lblWelcome.setBounds(354, 45, 152, 57);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);	
		lblWelcome.setFont(new Font("Papyrus", Font.PLAIN, 36));
		contentPane.add(lblWelcome);
		
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMessage.setBounds(26, 113, 808, 15);
		contentPane.add(lblMessage);
		
		lblAuthor.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblAuthor.setLocation(10, 207);
		lblAuthor.setSize(346, 15);
		contentPane.add(lblAuthor);

		btnNew.setBounds(220, 160, 141, 22);
		btnNew.setHorizontalAlignment(JButton.CENTER);
		contentPane.add(btnNew);
		
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
