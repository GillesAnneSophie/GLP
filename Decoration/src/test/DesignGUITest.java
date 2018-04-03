package test;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import java.io.File;
import java.util.ArrayList;

import catalog.Catalog;
import place.Statistics;
import place.Apartment;
import place.Grid;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class DesignGUITest extends JFrame 
{
	private static final long serialVersionUID = 1L;

	private Catalog catalog = new Catalog("furniture_catalog.txt");
	private Apartment apartment = new Apartment();
	private place.Dimension dimGrid = new place.Dimension(20, 0);
	private Grid grid = new Grid(dimGrid);
	
	private JPanel contentPane = new JPanel();
	private JPanel gridPanel = new JPanel();
	private JPanel statisticsPanel = new JPanel();

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuFile = new JMenu("File");
	private JMenuItem mntmOpen = new JMenuItem("Open a existing file");
	private JMenuItem mntmSave = new JMenuItem("Save this file");
	private JMenuItem mntmHelp = new JMenuItem("Help");
	private JMenuItem mntmExit = new JMenuItem("Exit");
	
	private JButton btnAutomaticDecoration = new JButton("Automatic Decoration");
	private JButton btnShowToolbar = new JButton("Open Toolbar");

	private JLabel lblNumberOfRoom = new JLabel ("Number of rooms:");
	private JLabel lblNumberOfFurniture = new JLabel ("Number of furniture:");	
	private JLabel roomCounter = new JLabel ("");
	private JLabel furnitureCounter = new JLabel ("");
	
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignGUITest frame = new DesignGUITest();
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart TEST");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	public DesignGUITest() 
	{
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(500, 40, 880, 990);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
		
		gridPanel.setBackground(Color.LIGHT_GRAY);
		gridPanel.setPreferredSize(new Dimension(860, 860));

	/*Grid configuration*/
		JLabel tabI[] = new JLabel[20];
		JLabel tabJ[] = new JLabel[20];
		int counterI = 0;
		int counterJ = 0;

		for(int i=1 ; i<=735 ; i+=35)
		{
			for(int j=1 ; j<=735 ; j+=35)
			{
				if(i==1 && j==1)
				{
					JLabel xy = new JLabel("Y\\/ X>");
					xy.setBounds(i, j, 35, 35);
					xy.setPreferredSize(new Dimension(35, 35));
					gridPanel.add(xy);
				}
				else if(i==1)
				{
					JLabel tmp = new JLabel();
					tmp.setText(String.valueOf(counterI+1));
					tabI[counterI] = tmp;
					tabI[counterI].setBounds(i, j, 35, 35);
					tabI[counterI].setPreferredSize(new Dimension(35, 35));
					gridPanel.add(tabI[counterI]);
					
					counterI++;
				}
				else if(j==1)
				{
					JLabel tmp = new JLabel();
					tmp.setText(String.valueOf(counterJ+1));
					tabJ[counterJ] = tmp;
					tabJ[counterJ].setBounds(i, j, 35, 35);
					tabJ[counterJ].setPreferredSize(new Dimension(35, 35));
					gridPanel.add(tabJ[counterJ]);
					
					counterJ++;
				}
				else
				{
					ImageIcon image = new ImageIcon("./drawings/empty.png");
					Image image1 = image.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
					ImageIcon imageToSet = new ImageIcon(image1);
					JLabel test = new JLabel(imageToSet);
					test.setBounds(i, j, 35, 35);
					gridPanel.add(test);
				}
			}
		}
		/*ImageIcon imageIcon = new ImageIcon("./drawings/toilet.png");
		Image image2 = imageIcon.getImage().getScaledInstance(34, 34, Image.SCALE_DEFAULT);
		ImageIcon imageIcon2 = new ImageIcon(image2);
		
		JLabel test2 = new JLabel(imageIcon2);
		test2.setBounds(50, 5, 34, 34);
		gridPanel.add(test2);*/
		contentPane.add(gridPanel);
		
	/*Menu Bar*/
		menuBar.setBackground(SystemColor.menu);
		menuBar.setPreferredSize(new Dimension(50, 30));
		menuBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setJMenuBar(menuBar);
		
		menuFile.setPreferredSize(new Dimension(30, 22));
		menuFile.add(mntmOpen);
		menuFile.add(mntmSave);
		menuFile.add(mntmHelp);
		menuFile.add(mntmExit);
		
		btnAutomaticDecoration.setBackground(SystemColor.menu);
		btnAutomaticDecoration.setBorderPainted(false);
		
		btnShowToolbar.setBackground(SystemColor.menu);
		btnShowToolbar.setBorderPainted(false);
		
		menuBar.add(menuFile);
		menuBar.add(btnAutomaticDecoration);
		menuBar.add(btnShowToolbar);
		
	/*Statistics Panel*/
		Component horizontalStrut = Box.createHorizontalStrut(10);
		horizontalStrut.setPreferredSize(new Dimension(60, 15));
		
		statisticsPanel.setPreferredSize(new Dimension(650, 30));
		statisticsPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		statisticsPanel.add(lblNumberOfRoom);
		statisticsPanel.add(roomCounter);
		statisticsPanel.add(horizontalStrut);
		statisticsPanel.add(lblNumberOfFurniture);
		statisticsPanel.add(furnitureCounter);
		contentPane.add(statisticsPanel);

		String currentRoomCounter = Integer.toString(Statistics.numberOfRooms(apartment.getRoomsList()));
		String currentFurnitureCounter = Integer.toString(Statistics.numberOfFurniture(apartment.getRoomsList()));
		
		roomCounter.setText(currentRoomCounter);
		furnitureCounter.setText(currentFurnitureCounter);
		
	/*Menu Listeners*/
		mntmOpen.addActionListener(new ActionListener() {
			private File file;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);		
				if(arg0.getSource() == mntmOpen) {					
					int returnV = fc.showOpenDialog(DesignGUITest.this);					
					if(returnV == JFileChooser.APPROVE_OPTION) {					
						file = fc.getSelectedFile();
					}
				}
			}		
		});
		
		btnAutomaticDecoration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AutomaticDecorationGUI.main(catalog, apartment, grid);
			}
		});
		
		btnShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ToolbarGUI.main(apartment, grid, catalog);
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
}