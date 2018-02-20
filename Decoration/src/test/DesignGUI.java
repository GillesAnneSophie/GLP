package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import catalog.Catalog;
import place.Apartment;

import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JMenu;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;

/**
 * @author lauryanncoralie
 *
 */
public class DesignGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel cells[][];
	Catalog catalog = new Catalog();
	Apartment apartment = new Apartment();
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
		setBounds(100, 100, 688, 477);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("?");
		menuBar.add(menu);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		menu.add(mntmHelp);
		
		JMenuItem mntmExit = new JMenuItem("Exit ");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}	
		});
		menu.add(mntmExit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JCheckBoxMenuItem chckbxmntmShowToolbar = new JCheckBoxMenuItem("Show Toolbar");
		chckbxmntmShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxmntmShowToolbar.isSelected() == true) {
					ToolbarGUI.main(null);
				}
				else {
				
				}
			}
		});
		mnView.add(chckbxmntmShowToolbar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPopupMenu popupMenu = new JPopupMenu();
		contentPane.add(popupMenu);
		popupMenu.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent arg0) {
		if (arg0.isPopupTrigger()) {
		popupMenu.show(popupMenu,arg0.getX(),arg0.getY());
		}
		}
		});

		JMenu mnKitchen = new JMenu("Kitchen");
		popupMenu.add(mnKitchen);

		JMenuItem mntmFridge = new JMenuItem("Fridge");
		mnKitchen.add(mntmFridge);

		JMenuItem mntmGasCooker = new JMenuItem("Gas Cooker");
		mnKitchen.add(mntmGasCooker);

		JMenuItem mntmSink = new JMenuItem("Sink");
		mnKitchen.add(mntmSink);

		JMenuItem mntmCountertop = new JMenuItem("Countertop");
		mnKitchen.add(mntmCountertop);

		JMenu mnDiningRoom = new JMenu("Dining Room");
		popupMenu.add(mnDiningRoom);

		JMenuItem mntmSmallDiningTable = new JMenuItem("Small Dining Table");
		mnDiningRoom.add(mntmSmallDiningTable);

		JMenuItem mntmBigDiningTable = new JMenuItem("Big Dining Table");
		mnDiningRoom.add(mntmBigDiningTable);

		JMenuItem mntmChiar = new JMenuItem("Chair");
		mnDiningRoom.add(mntmChiar);

		JMenuItem mntmSideboard = new JMenuItem("Sideboard");
		mnDiningRoom.add(mntmSideboard);

		JMenu mnLivingRoom = new JMenu("Living Room");
		popupMenu.add(mnLivingRoom);

		JMenuItem mntmCoffeeTable = new JMenuItem("Coffee Table");
		mnLivingRoom.add(mntmCoffeeTable);

		JMenuItem mntmSmallSofa = new JMenuItem("Small Sofa");
		mnLivingRoom.add(mntmSmallSofa);

		JMenuItem mntmBigSofa = new JMenuItem("Big Sofa");
		mnLivingRoom.add(mntmBigSofa);

		JMenuItem mntmArmchair = new JMenuItem("Armchair");
		mnLivingRoom.add(mntmArmchair);

		JMenu mnBedroomoffice = new JMenu("Bedroom/Office");
		popupMenu.add(mnBedroomoffice);

		JMenuItem mntmSingleBed = new JMenuItem("Single Bed");
		mnBedroomoffice.add(mntmSingleBed);

		JMenuItem mntmDoubleBed = new JMenuItem("Double Bed");
		mnBedroomoffice.add(mntmDoubleBed);

		JMenuItem mntmNightstand = new JMenuItem("Nightstand");
		mnBedroomoffice.add(mntmNightstand);

		JMenuItem mntmChestOfDrawers = new JMenuItem("Chest of Drawers");
		mnBedroomoffice.add(mntmChestOfDrawers);

		JMenuItem mntmWardrobe = new JMenuItem("Wardrobe");
		mnBedroomoffice.add(mntmWardrobe);

		JMenuItem mntmDesk = new JMenuItem("Desk");
		mnBedroomoffice.add(mntmDesk);

		JMenu mnBathroom = new JMenu("Bathroom");
		popupMenu.add(mnBathroom);

		JMenuItem mntmToilet = new JMenuItem("Toilet");
		mntmToilet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*bathroom.addFurniture(catalog.getFurniture("toilet"));*/
			}
		});
		mnBathroom.add(mntmToilet);

		JMenuItem mntmShower = new JMenuItem("Shower");
		mnBathroom.add(mntmShower);

		JMenuItem mntmBathtub = new JMenuItem("Bathtub");
		mnBathroom.add(mntmBathtub);

		JMenuItem mntmSink_1 = new JMenuItem("Sink");
		mnBathroom.add(mntmSink_1);

		JMenuItem mntmH = new JMenuItem("Contertop");
		mnBathroom.add(mntmH);

		JMenu mnWall = new JMenu("Wall");
		popupMenu.add(mnWall);

		JMenuItem mntmWallpaper = new JMenuItem("Wallpaper");
		mnWall.add(mntmWallpaper);

		JMenuItem mntmPaint = new JMenuItem("Paint");
		mnWall.add(mntmPaint);

		JMenuItem mntmPanelling = new JMenuItem("Panelling");
		mnWall.add(mntmPanelling);

		JMenu mnDoors = new JMenu("Doors");
		mnWall.add(mnDoors);

		JMenuItem mntmSmallDoor = new JMenuItem("Small Door");
		mnDoors.add(mntmSmallDoor);

		JMenuItem mntmBigDoor = new JMenuItem("Big Door");
		mnDoors.add(mntmBigDoor);

		JMenu mnWindows = new JMenu("Windows");
		mnWall.add(mnWindows);

		JMenuItem mntmSmallWindow = new JMenuItem("Small Window");
		mnWindows.add(mntmSmallWindow);

		JMenuItem mntmBigWindow = new JMenuItem("Big Window ");
		mnWindows.add(mntmBigWindow);

		JMenu mnArt = new JMenu("Art");
		mnWall.add(mnArt);

		JMenuItem mntmPicture = new JMenuItem("Picture");
		mnArt.add(mntmPicture);

		JMenuItem mntmPainting = new JMenuItem("Painting");
		mnArt.add(mntmPainting);

		JMenuItem mntmPoster = new JMenuItem("Poster");
		mnArt.add(mntmPoster);

		JMenu mnFloor = new JMenu("Floor");
		popupMenu.add(mnFloor);

		JMenuItem mntmCarpeting = new JMenuItem("Carpeting");
		mnFloor.add(mntmCarpeting);

		JMenuItem mntmParquet = new JMenuItem("Parquet");
		mnFloor.add(mntmParquet);

		JMenuItem mntmTiles = new JMenuItem("Tiles");
		mnFloor.add(mntmTiles);

		JMenuItem mntmSmallRug = new JMenuItem("Small Rug");
		mnFloor.add(mntmSmallRug);

		JMenuItem mntmBigRug = new JMenuItem("Big Rug");
		mnFloor.add(mntmBigRug);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		contentPane.addMouseListener(new MouseAdapter() {  
		            public void mouseClicked(MouseEvent e) {              
		                popupMenu.show(contentPane , e.getX(), e.getY());  
		            }                 
		        });  

		cells = contentGrille (contentPane);
		this.setVisible(true);
		
	}
	
	public static JPanel[][] contentGrille (JPanel content){
		JPanel grid = new JPanel();		
		grid.setLayout(new GridLayout (40,40));
		grid.setPreferredSize(new Dimension (700,700));		
		JPanel cell [][] = creatGrid (grid);
		grid.setBackground(Color.white);
		content.add(grid,BorderLayout.CENTER);
		return cell;
	}

	public static JPanel[][] creatGrid(JPanel grid){
		JPanel cell[][]= new JPanel[40][40];
		for(int i=0; i<cell.length; i++){
			for(int j=0; j<cell.length; j++){
				cell[i][j]= new JPanel();
		        cell[i][j].setSize(new Dimension(100, 100));
		        cell[i][j].setBackground(Color.white);
		        cell[i][j].setBorder(new MatteBorder(1,1,2,2,Color.BLACK));
		        grid.add(cell[i][j]);
		    }
		}
		return cell;
	}		
}