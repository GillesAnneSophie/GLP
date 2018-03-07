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
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static HomeGUI frame = new HomeGUI();
	
	private GridBagLayout gbl_contentPane = new GridBagLayout();
	
	private JLabel lblWelcome = new JLabel("Manag'Apart");
//TODO ajouter un texte centré en dessous du nom du programme : "Welcome! Here you can manage your apartment by clicking on "New management" or continue a previous magament with "Open a existing management""
//TODO + "By GILLES Anne-Sophie & CORALIE Laury Ann & ZOUHOUDI Chabani
	
	private GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
	private GridBagConstraints gbc_btnNew = new GridBagConstraints();
	private GridBagConstraints gbc_btnOpenAFile = new GridBagConstraints();
	
	private JButton btnNew = new JButton("New management");
	private JButton btnOpenAFile = new JButton("Open a existing management");
//TODO Changer la taille de la fenêtre :c ça entre pas avec les nouveaux noms	
//TODO Gerer un fichier déjà existant (Je pense pas qu'on va avoir le temps !)

	/**
	 * Launch the application
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
	 * Create the frame
	 */
	public HomeGUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		gbl_contentPane.columnWidths = new int[]{188, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 85, 136, 0};
		gbl_contentPane.rowHeights = new int[]{46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
			
		lblWelcome.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 42));
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWelcome.gridx = 7;
		gbc_lblWelcome.gridy = 4;
		contentPane.add(lblWelcome, gbc_lblWelcome);
		
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DesignGUI.main(null);
				frame.setVisible(false);
			}
		});
		
		gbc_btnNew.anchor = GridBagConstraints.WEST;
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 6;
		gbc_btnNew.gridy = 7;
		contentPane.add(btnNew, gbc_btnNew);
		
		btnOpenAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
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
