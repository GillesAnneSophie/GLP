 package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

import catalog.Catalog;
import place.AbstractRoom;
import place.Apartment;
import place.Grid;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class ToolbarGUI extends JFrame {
	private JPanel contentPane;
	private JPanel panel = new JPanel();

	private JToolBar toolBar = new JToolBar();
	
	private JButton btnAddARoom = new JButton("Add a Room");
	private JButton btnRemoveARoom = new JButton("Remove a Room");
	private JButton btnRemoveAFurniture = new JButton("Remove a Furniture");
	
	private JSeparator separator = new JSeparator();
	private JSeparator separator_1 = new JSeparator();
	
	private String[] room = {"Kitchen","Living Room", "Dining Room", "Bedroom/Office","Bathroom","Wall","Floor"};
	private JList <String >list = new JList <String> (room);
	private String [] kitchenFurniture = {"<< Return","Fridge","Gas Cooker","Sink","Worktop"};
	private JList <String> kitchenList = new JList <String> (kitchenFurniture);
	private String [] livingRoomFurniture = {"<< Return","Coffee Table" ,"Small Sofa","Large Sofa","Armchair"};
	private JList <String> livingRoomList = new JList <String> (livingRoomFurniture);
	private String [] diningRoomFurniture = {"<< Return","Small Dining Table", "Large Dining Table","Chair","Buffet"};
	private JList <String> diningRoomList = new JList <String> (diningRoomFurniture);
	private String [] bedroomOfficeFurniture = {"<< Return","Single Bed","Double Bed","Nightstand","Dresser","Wardrobe","Desk","Office Chair"};
	private JList <String> bedroomOfficeList = new JList <String> (bedroomOfficeFurniture);
	private String [] bathroomFurniture = {"<< Return","Toilet","Shower","Bath","Washbasin","Worktop"};
	private JList <String> bathroomList = new JList <String> (bathroomFurniture);
	private String [] wallFurniture = {"<< Return",/*"Wallpaper","Paint","Panelling",*/"Small Door","Large Door","Small Window","Large Window","Pictures"}; //TODO a changer / a voir
	private JList <String> wallList = new JList <String> (wallFurniture);
	private String [] floorFurniture = {"<< Return",/*"Carpeting", "Parquet","Tiles",*/"Carpet"};//TODO a changer / a voir
	private JList <String> floorList = new JList <String> (floorFurniture);
	
	
	/**
	 * Launch the application
	 */
	public static void main(Apartment apartment, Grid grid, Catalog catalog) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					ToolbarGUI frame = new ToolbarGUI (apartment, grid, catalog);
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
	public ToolbarGUI(Apartment apartment, Grid grid, Catalog catalog) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 440, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		contentPane.add(panel, BorderLayout.CENTER);
		
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnAddARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddRoomGUI.main(apartment,grid);
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
			}
		});
	
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurniture);
		
		panel.add(list);
		list.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				if (list.getSelectedValue()=="Kitchen") {
					panel.add(kitchenList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Living Room") {
					panel.add(livingRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Dining Room") {
					panel.add(diningRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bedroom/Office") {
					panel.add(bedroomOfficeList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bathroom") {
					panel.add(bathroomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Wall") {
					panel.add(wallList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Floor") {
					panel.add(floorList);
					list.setVisible(false);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (list.getSelectedValue()=="Kitchen") {
					panel.add(kitchenList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Living Room") {
					panel.add(livingRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Dining Room") {
					panel.add(diningRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bedroom/Office") {
					panel.add(bedroomOfficeList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bathroom") {
					panel.add(bathroomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Wall") {
					panel.add(wallList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Floor") {
					panel.add(floorList);
					list.setVisible(false);
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (list.getSelectedValue()=="Kitchen") {
					panel.add(kitchenList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Living Room") {
					panel.add(livingRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Dining Room") {
					panel.add(diningRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bedroom/Office") {
					panel.add(bedroomOfficeList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bathroom") {
					panel.add(bathroomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Wall") {
					panel.add(wallList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Floor") {
					panel.add(floorList);
					list.setVisible(false);
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (list.getSelectedValue()=="Kitchen") {
					panel.add(kitchenList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Living Room") {
					panel.add(livingRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Dining Room") {
					panel.add(diningRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bedroom/Office") {
					panel.add(bedroomOfficeList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bathroom") {
					panel.add(bathroomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Wall") {
					panel.add(wallList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Floor") {
					panel.add(floorList);
					list.setVisible(false);
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (list.getSelectedValue()=="Kitchen") {
					panel.add(kitchenList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Living Room") {
					panel.add(livingRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Dining Room") {
					panel.add(diningRoomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bedroom/Office") {
					panel.add(bedroomOfficeList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Bathroom") {
					panel.add(bathroomList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Wall") {
					panel.add(wallList);
					list.setVisible(false);
				}
				if (list.getSelectedValue() == "Floor") {
					panel.add(floorList);
					list.setVisible(false);
					
				}
			}
			
		});
		
		kitchenList.addMouseListener(new MouseListener (){ 
// TODO changer addfunirture par AddFurnitureGUI + mettre furniture/grid en param

			public void mouseClicked(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main("fridge");
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main("gas cooker");
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main("sink");
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main("fridge");
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main("gas cooker");
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main("sink");
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main("fridge");
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main("gas cooker");
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main("sink");
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main("fridge");
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main("gas cooker");
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main("sink");
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main("fridge");
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main("gas cooker");
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main("sink");
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");
				}
			}
			
		});
		
		livingRoomList.addMouseListener(new MouseListener (){

			public void mouseClicked(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main("coffee table");
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main("small sofa");
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main("large sofa");
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main("armchair");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main("coffee table");
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main("small sofa");
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main("large sofa");
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main("armchair");
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main("coffee table");
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main("small sofa");
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main("large sofa");
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main("armchair");
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main("coffee table");
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main("small sofa");
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main("large sofa");
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main("armchair");
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main("coffee table");
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main("small sofa");
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main("large sofa");
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main("armchair");
				}
			}
			
		});
		
		diningRoomList.addMouseListener(new MouseListener (){

			public void mouseClicked(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main("smallDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main("largeDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main("sideboard");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main("smallDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main("largeDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main("sideboard");
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main("smallDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main("largeDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main("sideboard");
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main("smallDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main("largeDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main("sideboard");
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main("smallDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main("largeDiningTable");
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main("sideboard");
				}
			}
			
		});
		
		bedroomOfficeList.addMouseListener(new MouseListener (){

			public void mouseClicked(MouseEvent arg0) {
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main("single bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main("double bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main("nightstand");
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main("dresser");
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main("wardrobe");
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main("desk");				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main("single bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main("double bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main("nightstand");
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main("dresser");
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main("wardrobe");
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main("desk");				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main("single bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main("double bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main("nightstand");
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main("dresser");
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main("wardrobe");
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main("desk");				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main("single bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main("double bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main("nightstand");
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main("dresser");
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main("wardrobe");
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main("desk");				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main("single bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main("double bed");
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main("nightstand");
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main("dresser");
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main("wardrobe");
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main("desk");				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main("chair");
				}
			}			
		});
		
		bathroomList.addMouseListener(new MouseListener (){

			public void mouseClicked(MouseEvent arg0) {
				if (bathroomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bathroomList);
				}
				if (bathroomList.getSelectedValue()== "Toilet"){
					AbstractRoom toilet = catalog.getFurniture("toilet");
					AddFurnitureGUI.main("toilet");
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main("bath");
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main("shower");
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main("washbasin");	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");		
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (bathroomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bathroomList);
				}
				if (bathroomList.getSelectedValue()== "Toilet"){
					AbstractRoom toilet = catalog.getFurniture("toilet");
					AddFurnitureGUI.main("toilet");
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main("bath");
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main("shower");
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main("washbasin");	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");		
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				if (bathroomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bathroomList);
				}
				if (bathroomList.getSelectedValue()== "Toilet"){
					AbstractRoom toilet = catalog.getFurniture("toilet");
					AddFurnitureGUI.main("toilet");
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main("bath");
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main("shower");
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main("washbasin");	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");		
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				if (bathroomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bathroomList);
				}
				if (bathroomList.getSelectedValue()== "Toilet"){
					AbstractRoom toilet = catalog.getFurniture("toilet");
					AddFurnitureGUI.main("toilet");
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main("bath");
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main("shower");
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main("washbasin");	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");		
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (bathroomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bathroomList);
				}
				if (bathroomList.getSelectedValue()== "Toilet"){
					AbstractRoom toilet = catalog.getFurniture("toilet");
					AddFurnitureGUI.main("toilet");
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main("bath");
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main("shower");
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main("washbasin");	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main("worktop");		
				}
			}		
		});
		
		wallList.addMouseListener(new MouseListener (){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (wallList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(wallList);
				}
			/*	if (wallList.getSelectedValue() == "Carpeting") {		//TODO a changer / a voir
					AbstractRoom carpeting = catalog.getFurniture("carpeting");
				}
				if (wallList.getSelectedValue() == "Paint"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Panelling"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Small Door") {
					AbstractRoom smallDoor = catalog.getFurniture("small door");
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom smallDoor = catalog.getFurniture("large door");
				}
				if (wallList.getSelectedValue() == "Small Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("small window");
				}
				if (wallList.getSelectedValue() == "Large Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("large window");
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom smallDoor = catalog.getFurniture("pictures");
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				if (wallList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(wallList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Paint"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Panelling"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Small Door") {
					AbstractRoom smallDoor = catalog.getFurniture("small door");
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom smallDoor = catalog.getFurniture("large door");
				}
				if (wallList.getSelectedValue() == "Small Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("small window");
				}
				if (wallList.getSelectedValue() == "Large Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("large window");
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom smallDoor = catalog.getFurniture("pictures");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (wallList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(wallList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Painting"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Panelling"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Small Door") {
					AbstractRoom smallDoor = catalog.getFurniture("small door");
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom smallDoor = catalog.getFurniture("large door");
				}
				if (wallList.getSelectedValue() == "Small Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("small window");
				}
				if (wallList.getSelectedValue() == "Large Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("large window");
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom smallDoor = catalog.getFurniture("pictures");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (wallList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(wallList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Paint"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Panelling"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Small Door") {
					AbstractRoom smallDoor = catalog.getFurniture("small door");
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom smallDoor = catalog.getFurniture("large door");
				}
				if (wallList.getSelectedValue() == "Small Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("small window");
				}
				if (wallList.getSelectedValue() == "Large Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("large window");
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom smallDoor = catalog.getFurniture("pictures");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (wallList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(wallList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Paint"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Panelling"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Small Door") {
					AbstractRoom smallDoor = catalog.getFurniture("small door");
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom smallDoor = catalog.getFurniture("large door");
				}
				if (wallList.getSelectedValue() == "Small Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("small window");
				}
				if (wallList.getSelectedValue() == "Large Windows") {
					AbstractRoom smallDoor = catalog.getFurniture("large window");
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom smallDoor = catalog.getFurniture("pictures");
				}
			}
		});
		
		floorList.addMouseListener (new MouseListener(){
			public void mouseCLicked (MouseEvent arg0){
				if (floorList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(floorList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Parquet"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Tiles"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Carpet") {
					AbstractRoom carpet = catalog.getFurniture("carpet");
				}
			}
				
			@Override
			public void mousePressed(MouseEvent e) {
				if (floorList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(floorList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Parquet"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Tiles"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Carpet") {
					AbstractRoom carpet = catalog.getFurniture("carpet");
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (floorList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(floorList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Parquet"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Tiles"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Carpet") {
					AbstractRoom carpet = catalog.getFurniture("carpet");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (floorList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(floorList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Parquet"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Tiles"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Carpet") {
					AbstractRoom carpet = catalog.getFurniture("carpet");
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (floorList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(floorList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Parquet"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Tiles"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Carpet") {
					AbstractRoom carpet = catalog.getFurniture("carpet");
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if (floorList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(floorList);
				}
			/*	if (wallList.getSelectedValue() == "Wallpaper") {		//TODO a changer / a voir
					AbstractRoom wallpaper = catalog.getFurniture("wallpapar");
				}
				if (wallList.getSelectedValue() == "Parquet"){
					AbstractRoom
				}
				if (wallList.getSelectedValue() == "Tiles"){
					
				}
			*/
				if (wallList.getSelectedValue () == "Carpet") {
					AbstractRoom carpet = catalog.getFurniture("carpet");
				}
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
