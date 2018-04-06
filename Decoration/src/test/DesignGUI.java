package test;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import catalog.Catalog;
import place.Statistics;
import place.Apartment;
import place.Grid;
import place.PrintDrawing;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */


public class DesignGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private Catalog catalog = new Catalog("furniture_catalog.txt");
	private static Apartment apartment = new Apartment();
	private place.Dimension dimGrid = new place.Dimension(20, 20);
	private Grid grid = new Grid(dimGrid);
	
	private JPanel contentPane = new JPanel(null);
	private JPanel gridPanel = new JPanel();
	private JPanel statisticsPanel = new JPanel();
	
	JScrollPane scrollPane = new JScrollPane(gridPanel);

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu("File");
	private JMenuItem mntmHelp = new JMenuItem("Help");
	private JMenuItem mntmExit = new JMenuItem("Exit");
	
	private JButton btnAutomaticDecoration = new JButton("Automatic Decoration");
	private JButton btnShowToolbar = new JButton("Open Toolbar");

	private JLabel lblNumberOfRoom = new JLabel ("Number of rooms:");
	private JLabel lblNumberOfFurniture = new JLabel ("Number of furniture:");	
	private static JLabel roomCounter = new JLabel ("");
	private static JLabel furnitureCounter = new JLabel ("");
	
	
	/**
	 * Launch the application.
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
	 * Create the frame.
	 */
	public DesignGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 40, 918, 700);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		gridPanel.setBackground(new Color(100, 149, 237));
		gridPanel.setPreferredSize(new Dimension(875, 860));
	
	/*ScrollPane*/
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(5, 5, 890, 590);
        contentPane.add(scrollPane);

	/*Grid configuration*/
		JLabel tabI[] = new JLabel[20];
		JLabel tabJ[] = new JLabel[20];
		JLabel tabGrid[][] = new JLabel[20][20];
		
		PrintDrawing.printGrid(gridPanel, tabI, tabJ, tabGrid);
		
	/*Menu Bar*/
		menuBar.setBackground(SystemColor.menu);
		menuBar.setPreferredSize(new Dimension(50, 30));
		menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setJMenuBar(menuBar);
		
		menuFile.setPreferredSize(new Dimension(30, 22));
		menuFile.add(mntmHelp);
		menuFile.add(mntmExit);
		menuBar.add(menuFile);
		
		btnAutomaticDecoration.setBackground(SystemColor.menu);
		btnAutomaticDecoration.setBorderPainted(false);
		menuBar.add(btnAutomaticDecoration);
		
		btnShowToolbar.setBackground(SystemColor.menu);
		btnShowToolbar.setBorderPainted(false);
		menuBar.add(btnShowToolbar);
		
	/*Statistics*/
		Component horizontalStrut = Box.createHorizontalStrut(10);
		horizontalStrut.setPreferredSize(new Dimension(60, 15));
		
		statisticsPanel.setBounds(160, 600, 600, 27);
		statisticsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		statisticsPanel.add(lblNumberOfRoom);
		statisticsPanel.add(roomCounter);
		statisticsPanel.add(horizontalStrut);
		statisticsPanel.add(lblNumberOfFurniture);
		statisticsPanel.add(furnitureCounter);
		contentPane.add(statisticsPanel);

		setStatistics();
		
	/*Menu Listeners*/
		btnAutomaticDecoration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AutomaticDecorationGUI.main(catalog, apartment, grid, gridPanel, tabGrid);
			}
		});
		
		btnShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToolbarGUI.main(apartment, grid, catalog, gridPanel, tabGrid);
			}
		});
		
	/*Close Window*/
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
	}
	
	
	/**
	 * Set current statistics
	 */
	public static void setStatistics()
	{
		String currentRoomCounter = Integer.toString(Statistics.numberOfRooms(apartment.getRoomsList()));
		String currentFurnitureCounter = Integer.toString(Statistics.numberOfFurniture(apartment.getRoomsList()));
		
		roomCounter.setText(currentRoomCounter);
		furnitureCounter.setText(currentFurnitureCounter);
	}
}