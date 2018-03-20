 package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.border.EmptyBorder;

import catalog.Catalog;
import place.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class ToolbarGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JToolBar toolBar = new JToolBar();
	
	private JButton btnAddARoom = new JButton("Add a Room");
	private JButton btnRemoveARoom = new JButton("Remove a Room");
	private JButton btnRemoveAFurniture = new JButton("Remove a Furniture");
	
	private JSeparator separator = new JSeparator();
	private JSeparator separator_1 = new JSeparator();
	
	private JComboBox comboBoxRoom = new JComboBox();
	
	private DefaultListModel<String>  dml = new DefaultListModel<String> ();
	private JList list = new JList(dml);
	
	private String [] room = {"-- Select a room --","Kitchen","Living Room","Dining Room","Bedroom/Office","Bathroom","Wall","Floor"};
	private String [] kitchenFurniture = {"Fridge","Gas Cooker","Sink","Kitchen Worktop"};	
	private String [] livingRoomFurniture = {"Coffee Table" ,"Small Sofa","Large Sofa","Armchair"};
	private String [] diningRoomFurniture = {"Small Dining Table", "Large Dining Table","Chair","Buffet"};
	private String [] bedroomOfficeFurniture = {"Single Bed","Double Bed","Nightstand","Dresser","Wardrobe","Desk","Office Chair"};
	private String [] bathroomFurniture = {"Toilet","Shower","Bath","Washbasin","Worktop"};
	private String [] wallFurniture = {/*"Wallpaper","Paint","Panelling",*/"Small Door","Large Door","Small Window","Large Window","Pictures"}; //TODO a changer / a voir
	private String [] floorFurniture = {/*"Carpeting", "Parquet","Tiles",*/"Carpet"};//TODO a changer / a voir
	private String chosenRoom;
	private String choiceList;
	
	
	
	/**
	 * Launch the application
	 */
	public static void main(Apartment apartment, Grid grid, Catalog catalog, AbstractRoom furniture,HashMap<Integer, Room> roomList) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					ToolbarGUI frame = new ToolbarGUI (apartment, grid, catalog,furniture,roomList);
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - ToolBar");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public ToolbarGUI(Apartment apartment, Grid grid, Catalog catalog,AbstractRoom furniture,HashMap<Integer, Room> roomList) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		toolBar.setBounds(9, 10, 414, 33);
		
		contentPane.add(toolBar);
		
		btnAddARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddRoomGUI.main(apartment,grid, roomList);
			}
		});
		toolBar.add(btnAddARoom);
		
		btnRemoveARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveRoomGUI.main(apartment, grid);
			}
		});
			
		toolBar.add(separator);
		toolBar.add(btnRemoveARoom);
		
		btnRemoveAFurniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveFurnitureGUI.main(furniture, grid, roomList,apartment);
			}
		});
	
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurniture);
		comboBoxRoom.setBounds(9, 40, 414, 33);
		
		comboBoxRoom = new JComboBox(room);
		comboBoxRoom.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				chosenRoom = (String) combo.getSelectedItem();	
				switch (chosenRoom) {
					case "-- Select a room --":
						dml.clear();
						break;
					case "Kitchen":
						dml.clear();
						for (int i =0; i < kitchenFurniture.length;i++) {
							dml.addElement(kitchenFurniture[i]);
						}
						break;
					case "Living Room":
						dml.clear();
						for (int i =0; i < livingRoomFurniture.length;i++) {
							dml.addElement(livingRoomFurniture[i]);
						}
						break;
					case "Dining Room":
						dml.clear();
						for (int i =0; i < diningRoomFurniture.length;i++) {
							dml.addElement(diningRoomFurniture[i]);
						}
						break;
					case "Bedroom/Office":
						dml.clear();
						for (int i =0; i < bedroomOfficeFurniture.length;i++) {
							dml.addElement(bedroomOfficeFurniture[i]);
						}
						break;
					case "Bathroom":
						dml.clear();
						for (int i =0; i < bathroomFurniture.length;i++) {
							dml.addElement(bathroomFurniture[i]);
						}
						break;
					case "Wall":
						dml.clear();
						for (int i =0; i < wallFurniture.length;i++) {
							dml.addElement(wallFurniture[i]);
						}
						break;
					case "Floor":
						dml.clear();
						for (int i =0; i < floorFurniture.length;i++) {
							dml.addElement(floorFurniture[i]);
						}
						break;
				}
			}
		});
		
		comboBoxRoom.setToolTipText("");
		comboBoxRoom.setLocation(0, 43);
		comboBoxRoom.setSize(423, 20);
		contentPane.add(comboBoxRoom);
		
		
		list.setBounds(133, 97, 127, 135);
		contentPane.add(list);
		
		list.addMouseListener(new MouseListener (){ 
			public void mouseClicked(MouseEvent arg0) {
				choiceList = (String) list.getSelectedValue();
				switch (choiceList) {
					case "Fridge":
						AbstractRoom fridge = catalog.getFurniture("fridge");
						AddFurnitureGUI.main(fridge,grid);
						break;
					case "Gas Cooker":
						AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
						AddFurnitureGUI.main(gasCooker,grid);
						break;
					case "Sink":
						AbstractRoom sink = catalog.getFurniture("sink");
						AddFurnitureGUI.main(sink,grid);
						break;
					case "Kitchen Worktop":
						AbstractRoom countertop = catalog.getFurniture("worktop");
						AddFurnitureGUI.main(countertop,grid);
						break;		
					case "Coffee Table":
						AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
						AddFurnitureGUI.main(coffeeTable,grid);
						break;
					case "Small Sofa":
						AbstractRoom smallSofa = catalog.getFurniture("small sofa");
						AddFurnitureGUI.main(smallSofa,grid);
						break;
					case "Large Sofa":
						AbstractRoom largeSofa = catalog.getFurniture("large sofa");
						AddFurnitureGUI.main(largeSofa,grid);
						break;
					case "Armchair":
						AbstractRoom armchair = catalog.getFurniture("armchair");
						AddFurnitureGUI.main(armchair,grid);
						break;
					case "Small Dining Table":
						AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
						AddFurnitureGUI.main(smallDiningTable,grid);
						break;
					case "Large Dining Table":
						AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
						AddFurnitureGUI.main(largeDiningTable,grid);
						break;
					case "Chair":
						AbstractRoom chair = catalog.getFurniture("chair");
						AddFurnitureGUI.main(chair,grid);
						break;
					case "Buffet":
						AbstractRoom sideboard = catalog.getFurniture("buffet");
						AddFurnitureGUI.main(sideboard,grid);
					case "Single Bed":
						AbstractRoom singleBed = catalog.getFurniture("single bed");
						AddFurnitureGUI.main(singleBed,grid);
						break;
					case "Double Bed":
						AbstractRoom doubleBed = catalog.getFurniture("double bed");
						AddFurnitureGUI.main(doubleBed,grid);
						break;
					case "Nightstand":
						AbstractRoom nightstand = catalog.getFurniture("nightstand");
						AddFurnitureGUI.main(nightstand,grid);
						break;
					case "Dresser":
						AbstractRoom dresser = catalog.getFurniture("dresser");
						AddFurnitureGUI.main(dresser,grid);
						break;
					case "Wardrobe":
						AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
						AddFurnitureGUI.main(wardrobe,grid);
						break;
					case "Desk":
						AbstractRoom desk = catalog.getFurniture("desk");
						AddFurnitureGUI.main(desk,grid);	
						break;
					case "Office Chair":
						AbstractRoom officeChair = catalog.getFurniture("office chair");
						AddFurnitureGUI.main(officeChair,grid);
						break;
					case "Toilet":
						AbstractRoom toilet = catalog.getFurniture("toilet");
						AddFurnitureGUI.main(toilet,grid);
						break;
					case "Bath":
						AbstractRoom bath = catalog.getFurniture("bath");
						AddFurnitureGUI.main(bath,grid);
						break;
					case "Shower":
						AbstractRoom shower = catalog.getFurniture("shower");
						AddFurnitureGUI.main(shower,grid);
						break;
					case "Washbasin":
						AbstractRoom washbasin = catalog.getFurniture("washbasin");
						AddFurnitureGUI.main(washbasin,grid);	
						break;
					case "Worktop":
						AbstractRoom worktop = catalog.getFurniture("worktop");
						AddFurnitureGUI.main(worktop,grid);		
						break;
	
				/*	case "Carpeting":		//TODO a changer / a voir
						AbstractRoom wallpaper = catalog.getFurniture("wallpaper");
						AddFurnitureGUI.main(wallpaper,grid);
						break;
					case == "Paint";
						AbstractRoom paint = catalog.getFurniture("paint");
						AddFurnitureGUI.main(paint,grid);
						break;
					case "Panelling":
						AbstractRoom panelling = catalog.getFurniture("panelling");
						AddFurnitureGUI.main(panelling,grid);
						break;
				 */
					case "Small Door":
						AbstractRoom smallDoor = catalog.getFurniture("small door");
						AddFurnitureGUI.main(smallDoor, grid);
						break;
					case "Large Door":
						AbstractRoom largeDoor = catalog.getFurniture("large door");
						AddFurnitureGUI.main(largeDoor, grid);
						break;
					case "Small Window":
						AbstractRoom smallWindow = catalog.getFurniture("small window");
						AddFurnitureGUI.main(smallWindow, grid);
						break;
					case "Large Window":
						AbstractRoom largeWindow = catalog.getFurniture("large window");
						AddFurnitureGUI.main(largeWindow, grid);
						break;
					case "Pictures":
						AbstractRoom pictures = catalog.getFurniture("pictures");
						AddFurnitureGUI.main(pictures, grid);
						break;
				/*	case "Carpeting" :	//TODO a changer / a voir
						AbstractRoom carpeting = catalog.getFurniture("carpeting");
						AddFurnitureGUI.main(carpeting, grid);
						break;
					case "Parquet":
						AbstractRoom parquet = catalog.getFurniture("parquet");
						AddFurnitureGUI.main(parquet, grid);
						break;
					case "Tiles":
						AbstractRoom tiles = catalog.getFurniture("tiles");
						AddFurnitureGUI.main(tiles, grid);
						break;
				 */
					case "Carpet":
						AbstractRoom carpet = catalog.getFurniture("carpet");
						AddFurnitureGUI.main(carpet, grid);
						break;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the toolbar?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION) {
			    		dispose();
			    }
			  }
			});
		}
}
