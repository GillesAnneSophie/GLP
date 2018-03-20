package test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import catalog.Catalog;
import place.AbstractRoom;
import place.Apartment;
import place.Grid;
import place.Room;

/**
 * @author CORALIE Laury Ann
 *
 */
public class DesignGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private Catalog catalog = new Catalog();
	private Apartment apartment = new Apartment();
	private place.Dimension dimGrid = new place.Dimension(20, 20);
	private Grid grid = new Grid(dimGrid);
	private AbstractRoom furniture;
	private HashMap<Integer, Room> roomList = new HashMap<Integer, Room>();
	
	private JPanel contentPane;
	private JPanel[][] cells;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("?");
	private JMenu mnView = new JMenu("View");
	private JMenu mnKitchen = new JMenu("Kitchen");
	private JMenu mnDiningRoom = new JMenu("Dining Room");
	private JMenu mnLivingRoom = new JMenu("Living Room");
	private JMenu mnBedroomoffice = new JMenu("Bedroom/Office");
	private JMenu mnBathroom = new JMenu("Bathroom");
	private JMenu mnWall = new JMenu("Wall");
	private JMenu mnDoors = new JMenu("Doors");
	private JMenu mnWindows = new JMenu("Windows");
	private JMenu mnArt = new JMenu("Art");
	private JMenu mnFloor = new JMenu("Floor");
	
	private JMenuItem mntmHelp = new JMenuItem("Help");
	private JMenuItem mntmExit = new JMenuItem("Exit ");
	private JMenuItem mntmFridge = new JMenuItem("Fridge");
	private JMenuItem mntmGasCooker = new JMenuItem("Gas Cooker");
	private JMenuItem mntmSink = new JMenuItem("Sink");
	private JMenuItem mntmCountertop = new JMenuItem("Countertop");
	private JMenuItem mntmSmallDiningTable = new JMenuItem("Small Dining Table");
	private JMenuItem mntmBigDiningTable = new JMenuItem("Big Dining Table");
	private JMenuItem mntmChiar = new JMenuItem("Chair");
	private JMenuItem mntmSideboard = new JMenuItem("Sideboard");
	private JMenuItem mntmCoffeeTable = new JMenuItem("Coffee Table");
	private JMenuItem mntmSmallSofa = new JMenuItem("Small Sofa");
	private JMenuItem mntmBigSofa = new JMenuItem("Big Sofa");
	private JMenuItem mntmArmchair = new JMenuItem("Armchair");
	private JMenuItem mntmSingleBed = new JMenuItem("Single Bed");
	private JMenuItem mntmDoubleBed = new JMenuItem("Double Bed");
	private JMenuItem mntmNightstand = new JMenuItem("Nightstand");
	private JMenuItem mntmChestOfDrawers = new JMenuItem("Chest of Drawers");
	private JMenuItem mntmWardrobe = new JMenuItem("Wardrobe");
	private JMenuItem mntmDesk = new JMenuItem("Desk");
	private JMenuItem mntmToilet = new JMenuItem("Toilet");
	private JMenuItem mntmShower = new JMenuItem("Shower");
	private JMenuItem mntmBathtub = new JMenuItem("Bathtub");
	private JMenuItem mntmSink_1 = new JMenuItem("Sink");
	private JMenuItem mntmH = new JMenuItem("Contertop");
	private JMenuItem mntmWallpaper = new JMenuItem("Wallpaper");
	private JMenuItem mntmPaint = new JMenuItem("Paint");
	private JMenuItem mntmPanelling = new JMenuItem("Panelling");
	private JMenuItem mntmSmallDoor = new JMenuItem("Small Door");
	private JMenuItem mntmBigDoor = new JMenuItem("Big Door");
	private JMenuItem mntmSmallWindow = new JMenuItem("Small Window");
	private JMenuItem mntmBigWindow = new JMenuItem("Big Window ");
	private JMenuItem mntmPicture = new JMenuItem("Picture");
	private JMenuItem mntmPainting = new JMenuItem("Painting");
	private JMenuItem mntmPoster = new JMenuItem("Poster");
	private JMenuItem mntmCarpeting = new JMenuItem("Carpeting");
	private JMenuItem mntmParquet = new JMenuItem("Parquet");
	private JMenuItem mntmTiles = new JMenuItem("Tiles");
	private JMenuItem mntmSmallRug = new JMenuItem("Small Rug");
	private JMenuItem mntmBigRug = new JMenuItem("Big Rug");
	
	private JCheckBoxMenuItem chckbxmntmShowToolbar = new JCheckBoxMenuItem("Show Toolbar");

	private JPopupMenu popupMenu = new JPopupMenu();
	
	
	/**
	 * Launch the application
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 477);
		
		
		setJMenuBar(menuBar);
		
		menuBar.add(menu);
		
		menu.add(mntmHelp);
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					dispose();
				}
			}	
		});
		
		menu.add(mntmExit);
		
		menuBar.add(mnView);
		
		chckbxmntmShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxmntmShowToolbar.isSelected() == true) {
					ToolbarGUI.main(apartment, grid, catalog, furniture, roomList);
				}
				else {
				
				}
			}
		});
		mnView.add(chckbxmntmShowToolbar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.add(popupMenu);
		popupMenu.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (arg0.isPopupTrigger()) {
						popupMenu.show(popupMenu,arg0.getX(),arg0.getY());
				}
			}
		}); 

		popupMenu.add(mnKitchen);

		mnKitchen.add(mntmFridge);
		mnKitchen.add(mntmGasCooker);
		mnKitchen.add(mntmSink);
		mnKitchen.add(mntmCountertop);
	
		popupMenu.add(mnDiningRoom);
		
		mnDiningRoom.add(mntmSmallDiningTable);
		mnDiningRoom.add(mntmBigDiningTable);
		mnDiningRoom.add(mntmChiar);
		mnDiningRoom.add(mntmSideboard);

		popupMenu.add(mnLivingRoom);

		mnLivingRoom.add(mntmCoffeeTable);	
		mnLivingRoom.add(mntmSmallSofa);
		mnLivingRoom.add(mntmBigSofa);
		mnLivingRoom.add(mntmArmchair);

		popupMenu.add(mnBedroomoffice);

		mnBedroomoffice.add(mntmSingleBed);
		mnBedroomoffice.add(mntmDoubleBed);
		mnBedroomoffice.add(mntmNightstand);
		mnBedroomoffice.add(mntmChestOfDrawers);
		mnBedroomoffice.add(mntmWardrobe);
		mnBedroomoffice.add(mntmDesk);

		popupMenu.add(mnBathroom);

		mnBathroom.add(mntmToilet);
		mnBathroom.add(mntmShower);
		mnBathroom.add(mntmBathtub);
		mnBathroom.add(mntmSink_1);
		mnBathroom.add(mntmH);
		
		popupMenu.add(mnWall);
		
		mnWall.add(mntmWallpaper);
		mnWall.add(mntmPaint);
		mnWall.add(mntmPanelling);		
		mnWall.add(mnDoors);		
		mnDoors.add(mntmSmallDoor);
		mnDoors.add(mntmBigDoor);
		mnWall.add(mnWindows);
		mnWindows.add(mntmSmallWindow);
		mnWindows.add(mntmBigWindow);
		mnWall.add(mnArt);	
		mnArt.add(mntmPicture);
		mnArt.add(mntmPainting);
		mnArt.add(mntmPoster);
		
		popupMenu.add(mnFloor);
		
		mnFloor.add(mntmCarpeting);
		mnFloor.add(mntmParquet);
		mnFloor.add(mntmTiles);
		mnFloor.add(mntmSmallRug);
		mnFloor.add(mntmBigRug);
		
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentPane.addMouseListener(new MouseAdapter() {  
		            public void mouseClicked(MouseEvent e) {              
		                popupMenu.show(contentPane , e.getX(), e.getY());  
		            }                 
		        });  
	
		cells= contentGrille (contentPane);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION) {
			    		dispose();
			    }
			  }
			});
		
	}
	
	public static JPanel[][] contentGrille (JPanel content){
		JPanel grid = new JPanel();		
		grid.setLayout(new GridLayout (20,20));
		grid.setPreferredSize(new Dimension (700,700));		
		JPanel cell [][] = creatGrid (grid);
		grid.setBackground(Color.white);
		content.add(grid,BorderLayout.CENTER);
		return cell;
	}

	public static JPanel[][] creatGrid(JPanel grid){
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
}