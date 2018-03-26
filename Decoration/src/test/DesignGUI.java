package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import catalog.Catalog;
import place.Statistics;
import place.Apartment;
import place.Grid;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class DesignGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private Catalog catalog = new Catalog("furniture_catalog.txt");
	private Apartment apartment = new Apartment();
	private place.Dimension dimGrid = new place.Dimension(20, 20);
	private Grid grid = new Grid(dimGrid);
	
	private JPanel contentPane = new JPanel();
	private JPanel[][] cells;
	private JPanel statBar = new JPanel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("?");
	private JMenuItem mntmHelp = new JMenuItem("Help");
	private JMenuItem mntmExit = new JMenuItem("Exit");
	
	private JCheckBoxMenuItem chckbxmntmShowToolbar = new JCheckBoxMenuItem("Show Toolbar");

	private JLabel lblNumberOfRoom = new JLabel ("Number of rooms:");
	private JLabel lblNumberOfFurniture = new JLabel ("Number of furniture:");	
	private JLabel roomCounter = new JLabel ("");
	private JLabel furnitureCounter = new JLabel ("");
	
	private static Graphics graphics;

	
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignGUI frame = new DesignGUI();
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public DesignGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 736, 824);
		menuBar.setPreferredSize(new Dimension(50, 30));
		menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		setJMenuBar(menuBar);
		menu.setPreferredSize(new Dimension(20, 22));
		menuBar.add(menu);
		menu.add(mntmHelp);
		menu.add(mntmExit);
		chckbxmntmShowToolbar.setPreferredSize(new Dimension(50, 22));
		menuBar.add(chckbxmntmShowToolbar);
		
		chckbxmntmShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxmntmShowToolbar.isSelected() == true) {
					ToolbarGUI.main(apartment, grid, catalog);
				}
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
	
		cells = contentGrille (contentPane);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
				    if (confirmed == JOptionPane.YES_OPTION) {
				    	System.exit(0);
				    }
			  }
		});
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}	
		});
		
		statBar.setPreferredSize(new Dimension(650, 30));
		statBar.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(statBar);
		statBar.add(lblNumberOfRoom);
		statBar.add(roomCounter);
		Component horizontalStrut = Box.createHorizontalStrut(10);
		horizontalStrut.setPreferredSize(new Dimension(60, 15));
		statBar.add(horizontalStrut);
		statBar.add(lblNumberOfFurniture);
		statBar.add(furnitureCounter);

		String currentRoomCounter = Integer.toString(Statistics.numberOfRooms(apartment.getRoomsList()));
		String currentFurnitureCounter = Integer.toString(Statistics.numberOfFurniture(apartment.getRoomsList()));
		
		roomCounter.setText(currentRoomCounter);
		furnitureCounter.setText(currentFurnitureCounter);
	}

	
	public static JPanel[][] contentGrille (JPanel content){
		JPanel grid = new JPanel();		
		grid.setLayout(new GridLayout (20,20));
		grid.setPreferredSize(new Dimension (700,700));		
		JPanel cell [][] = createGrid (grid);
		grid.setBackground(Color.white);
		content.add(grid,BorderLayout.CENTER);
		return cell;
	}

	public static JPanel[][] createGrid(JPanel grid){
		JPanel cell[][]= new JPanel[20][20];
		for(int i=0; i<cell.length; i++){
			for(int j=0; j<cell.length; j++){
				cell[i][j]= new JPanel();
		        cell[i][j].setSize(new Dimension(100, 100));
		        cell[i][j].setBackground(Color.white);
		        cell[i][j].setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
		        grid.add(cell[i][j]);
		    }
		}
		return cell;
	}
	//TODO GUI : utiliser ImageIcon(getURL(getCodeBase(),"")) pour integrer les images des meubles

	public static void paintComponent(String name, int furniturePositionX, int furniturePositionY) throws IOException {
		      Image image = ImageIO.read(new File("./Decoration/drawings/"+name+".png"));
		      graphics.drawImage(image, furniturePositionX, furniturePositionY, null);
	}
}