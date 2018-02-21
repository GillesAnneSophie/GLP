package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class HomeGUI extends JFrame {

	private JPanel contentPane;
	private static HomeGUI frame = new HomeGUI();

	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				    frame.setTitle(" Home ");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	/**
	 * 
	 */
	public HomeGUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{188, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 85, 136, 0};
		gbl_contentPane.rowHeights = new int[]{46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 7;
		gbc_lblWelcome.gridy = 4;
		contentPane.add(lblWelcome, gbc_lblWelcome);
		
		JButton btnNew = new JButton("New file");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DesignGUI.main(null);
				frame.setVisible(false);
			}
		});
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.anchor = GridBagConstraints.WEST;
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 6;
		gbc_btnNew.gridy = 7;
		contentPane.add(btnNew, gbc_btnNew);
		
		JButton btnOpenAFile = new JButton("Open a file");
		btnOpenAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_btnOpenAFile = new GridBagConstraints();
		gbc_btnOpenAFile.insets = new Insets(0, 0, 5, 5);
		gbc_btnOpenAFile.anchor = GridBagConstraints.WEST;
		gbc_btnOpenAFile.gridx = 8;
		gbc_btnOpenAFile.gridy = 7;
		contentPane.add(btnOpenAFile, gbc_btnOpenAFile);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION) {
			    		dispose();
			    }
			  }
			});
	}
}
