package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class HomeGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private static HomeGUI frame = new HomeGUI();
	
	private JLabel lblName = new JLabel("Manag'Apart"); // TODO Je pense qu'on devrait voter pour le nom 
	private JLabel lblWelcome = new JLabel ( "Welcome!");
//TODO ajouter un texte centré en dessous du nom du programme : "Welcome! Here you can manage your apartment by clicking on "New management" or continue a previous magament with "Open a existing management""
	private JLabel lblAuthor = new JLabel ("By GILLES Anne-Sophie & CORALIE Laury Ann & ZOUHOUDI Chabani");
	private final JLabel lblMessage = new JLabel(" Here you can manage your apartment by clicking on 'New management' or continue a previous magament with 'Open a existing management'");
	
	private JButton btnOpenAFile = new JButton("Open a existing management");
	private JButton btnNew = new JButton("New management");
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
		setBounds(100, 100, 877, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblWelcome.setBounds(354, 45, 152, 57);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblWelcome.setFont(new Font("Papyrus", Font.PLAIN, 36));
		contentPane.add(lblWelcome);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMessage.setBounds(26, 113, 808, 14);
		contentPane.add(lblMessage);
		btnOpenAFile.setBounds(501, 160, 173, 23);
		
		btnOpenAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(btnOpenAFile);
		
		
		btnNew.setBounds(220, 160, 141, 23);
		contentPane.add(btnNew);
		
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
