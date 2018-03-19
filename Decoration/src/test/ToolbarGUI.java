 package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.border.EmptyBorder;

import catalog.Catalog;
import place.*;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class ToolbarGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
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
	public static void main(Apartment apartment, Grid grid, Catalog catalog, AbstractRoom furniture,HashMap<Integer, AbstractRoom> roomList) {
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
	public ToolbarGUI(Apartment apartment, Grid grid, Catalog catalog,AbstractRoom furniture,HashMap<Integer, AbstractRoom> roomList) {
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
			public void mouseClicked(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main(fridge,grid);
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main(gasCooker,grid);
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main(sink,grid);
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(countertop,grid);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main(fridge,grid);
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main(gasCooker,grid);
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main(sink,grid);
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(countertop,grid);
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main(fridge,grid);
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main(gasCooker,grid);
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main(sink,grid);
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(countertop,grid);
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main(fridge,grid);
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main(gasCooker,grid);
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main(sink,grid);
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(countertop,grid);
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (kitchenList.getSelectedValue() == "<< Return") {
					panel.remove(kitchenList);
					list.setVisible(true);
				}
				if (kitchenList.getSelectedValue() == "Fridge") {
					AbstractRoom fridge = catalog.getFurniture("fridge");
					AddFurnitureGUI.main(fridge,grid);
				}
				if (kitchenList.getSelectedValue() == "Gas Cooker"){
					AbstractRoom gasCooker = catalog.getFurniture("gas cooker");
					AddFurnitureGUI.main(gasCooker,grid);
				}
				if (kitchenList.getSelectedValue() == "Sink"){
					AbstractRoom sink = catalog.getFurniture("sink");
					AddFurnitureGUI.main(sink,grid);
				}
				if (kitchenList.getSelectedValue() == "Worktop"){
					AbstractRoom countertop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(countertop,grid);
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
					AddFurnitureGUI.main(coffeeTable,grid);
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main(smallSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main(largeSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main(armchair,grid);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main(coffeeTable,grid);
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main(smallSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main(largeSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main(armchair,grid);
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main(coffeeTable,grid);
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main(smallSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main(largeSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main(armchair,grid);
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main(coffeeTable,grid);
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main(smallSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main(largeSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main(armchair,grid);
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (livingRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(kitchenList);	
				}
				if (livingRoomList.getSelectedValue() == "Coffee Table") {
					AbstractRoom coffeeTable = catalog.getFurniture("coffee table");
					AddFurnitureGUI.main(coffeeTable,grid);
				}
				if (livingRoomList.getSelectedValue() == "Small Sofa"){
					AbstractRoom smallSofa = catalog.getFurniture("small sofa");
					// TODO livingRoom.addFurniture(smallSofa, 5, 5, grid);
					AddFurnitureGUI.main(smallSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Large Sofa"){
					AbstractRoom largeSofa = catalog.getFurniture("large sofa");
					AddFurnitureGUI.main(largeSofa,grid);
				}
				if (livingRoomList.getSelectedValue() == "Armchair"){
					AbstractRoom armchair = catalog.getFurniture("armchair");
					AddFurnitureGUI.main(armchair,grid);
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
					AddFurnitureGUI.main(smallDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main(largeDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main(sideboard,grid);
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main(smallDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main(largeDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main(sideboard,grid);
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main(smallDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main(largeDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main(sideboard,grid);
				}
			}

			public void mousePressed(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main(smallDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main(largeDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main(sideboard,grid);
				}
			}

			public void mouseReleased(MouseEvent arg0) {
				if (diningRoomList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(diningRoomList);
				}
				if (diningRoomList.getSelectedValue()== "Small Dining Table"){
					AbstractRoom smallDiningTable = catalog.getFurniture("small dining table");
					AddFurnitureGUI.main(smallDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Large Dining Table"){
					AbstractRoom largeDiningTable = catalog.getFurniture("large dining table");
					AddFurnitureGUI.main(largeDiningTable,grid);
				}
				if (diningRoomList.getSelectedValue()== "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
				if (diningRoomList.getSelectedValue()== "Buffet"){
					AbstractRoom sideboard = catalog.getFurniture("buffet");
					AddFurnitureGUI.main(sideboard,grid);
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
					AddFurnitureGUI.main(singleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main(doubleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main(nightstand,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main(dresser,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main(wardrobe,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main(desk,grid);				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main(singleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main(doubleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main(nightstand,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main(dresser,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main(wardrobe,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main(desk,grid);				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (bedroomOfficeList.getSelectedValue() == "<< Return") {
					list.setVisible(true);
					panel.remove(bedroomOfficeList);
				}
				if (bedroomOfficeList.getSelectedValue()== "Single Bed"){
					AbstractRoom singleBed = catalog.getFurniture("single bed");
					AddFurnitureGUI.main(singleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main(doubleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main(nightstand,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main(dresser,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main(wardrobe,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main(desk,grid);				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
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
					AddFurnitureGUI.main(singleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main(doubleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main(nightstand,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main(dresser,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main(wardrobe,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main(desk,grid);				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
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
					AddFurnitureGUI.main(singleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Double Bed"){
					AbstractRoom doubleBed = catalog.getFurniture("double bed");
					AddFurnitureGUI.main(doubleBed,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Nightstand"){
					AbstractRoom nightstand = catalog.getFurniture("nightstand");
					AddFurnitureGUI.main(nightstand,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Dresser"){
					AbstractRoom dresser = catalog.getFurniture("dresser");
					AddFurnitureGUI.main(dresser,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Wardrobe"){
					AbstractRoom wardrobe = catalog.getFurniture("wardrobe");
					AddFurnitureGUI.main(wardrobe,grid);
				}
				if (bedroomOfficeList.getSelectedValue()== "Desk"){
					AbstractRoom desk = catalog.getFurniture("desk");
					AddFurnitureGUI.main(desk,grid);				}
				if (bedroomOfficeList.getSelectedValue() == "Chair"){
					AbstractRoom chair = catalog.getFurniture("chair");
					AddFurnitureGUI.main(chair,grid);
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
					AddFurnitureGUI.main(toilet,grid);
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main(bath,grid);
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main(shower,grid);
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main(washbasin,grid);	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(worktop,grid);		
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
					AddFurnitureGUI.main(toilet,grid);
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main(bath,grid);
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main(shower,grid);
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main(washbasin,grid);	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(worktop,grid);		
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
					AddFurnitureGUI.main(toilet,grid);
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main(bath,grid);
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main(shower,grid);
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main(washbasin,grid);	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(worktop,grid);		
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
					AddFurnitureGUI.main(toilet,grid);
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main(bath,grid);
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main(shower,grid);
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main(washbasin,grid);	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(worktop,grid);		
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
					AddFurnitureGUI.main(toilet,grid);
				}
				if (bathroomList.getSelectedValue()== "Bath"){
					AbstractRoom bath = catalog.getFurniture("bath");
					AddFurnitureGUI.main(bath,grid);
				}
				if (bathroomList.getSelectedValue()== "Shower"){
					AbstractRoom shower = catalog.getFurniture("shower");
					AddFurnitureGUI.main(shower,grid);
				}
				if (bathroomList.getSelectedValue()== "Washbasin"){
					AbstractRoom washbasin = catalog.getFurniture("washbasin");
					AddFurnitureGUI.main(washbasin,grid);	
				}
				if (bathroomList.getSelectedValue()== "Worktop"){
					AbstractRoom worktop = catalog.getFurniture("worktop");
					AddFurnitureGUI.main(worktop,grid);		
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
					AddFurnitureGUI.main(smallDoor, grid);
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom largeDoor = catalog.getFurniture("large door");
					AddFurnitureGUI.main(largeDoor, grid);
				}
				if (wallList.getSelectedValue() == "Small Window") {
					AbstractRoom smallWindow = catalog.getFurniture("small window");
					AddFurnitureGUI.main(smallWindow, grid);
				}
				if (wallList.getSelectedValue() == "Large Window") {
					AbstractRoom largeWindow = catalog.getFurniture("large window");
					AddFurnitureGUI.main(largeWindow, grid);
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom pictures = catalog.getFurniture("pictures");
					AddFurnitureGUI.main(pictures, grid);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
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
					AddFurnitureGUI.main(smallDoor, grid);
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom largeDoor = catalog.getFurniture("large door");
					AddFurnitureGUI.main(largeDoor, grid);
				}
				if (wallList.getSelectedValue() == "Small Window") {
					AbstractRoom smallWindow = catalog.getFurniture("small window");
					AddFurnitureGUI.main(smallWindow, grid);
				}
				if (wallList.getSelectedValue() == "Large Window") {
					AbstractRoom largeWindow = catalog.getFurniture("large window");
					AddFurnitureGUI.main(largeWindow, grid);
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom pictures = catalog.getFurniture("pictures");
					AddFurnitureGUI.main(pictures, grid);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
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
					AddFurnitureGUI.main(smallDoor, grid);
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom largeDoor = catalog.getFurniture("large door");
					AddFurnitureGUI.main(largeDoor, grid);
				}
				if (wallList.getSelectedValue() == "Small Window") {
					AbstractRoom smallWindow = catalog.getFurniture("small window");
					AddFurnitureGUI.main(smallWindow, grid);
				}
				if (wallList.getSelectedValue() == "Large Window") {
					AbstractRoom largeWindow = catalog.getFurniture("large window");
					AddFurnitureGUI.main(largeWindow, grid);
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom pictures = catalog.getFurniture("pictures");
					AddFurnitureGUI.main(pictures, grid);
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
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
					AddFurnitureGUI.main(smallDoor, grid);
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom largeDoor = catalog.getFurniture("large door");
					AddFurnitureGUI.main(largeDoor, grid);
				}
				if (wallList.getSelectedValue() == "Small Window") {
					AbstractRoom smallWindow = catalog.getFurniture("small window");
					AddFurnitureGUI.main(smallWindow, grid);
				}
				if (wallList.getSelectedValue() == "Large Window") {
					AbstractRoom largeWindow = catalog.getFurniture("large window");
					AddFurnitureGUI.main(largeWindow, grid);
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom pictures = catalog.getFurniture("pictures");
					AddFurnitureGUI.main(pictures, grid);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
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
					AddFurnitureGUI.main(smallDoor, grid);
				}
				if (wallList.getSelectedValue () == "Large Door") {
					AbstractRoom largeDoor = catalog.getFurniture("large door");
					AddFurnitureGUI.main(largeDoor, grid);
				}
				if (wallList.getSelectedValue() == "Small Window") {
					AbstractRoom smallWindow = catalog.getFurniture("small window");
					AddFurnitureGUI.main(smallWindow, grid);
				}
				if (wallList.getSelectedValue() == "Large Window") {
					AbstractRoom largeWindow = catalog.getFurniture("large window");
					AddFurnitureGUI.main(largeWindow, grid);
				}
				if (wallList.getSelectedValue() == "Pictures"){
					AbstractRoom pictures = catalog.getFurniture("pictures");
					AddFurnitureGUI.main(pictures, grid);
				}
			}
		});
		
		floorList.addMouseListener (new MouseListener(){
			public void mouseCLicked (MouseEvent arg0 ){
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
					AddFurnitureGUI.main(carpet, grid);
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
					AddFurnitureGUI.main(carpet, grid);
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
					AddFurnitureGUI.main(carpet, grid);
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
					AddFurnitureGUI.main(carpet, grid);
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
					AddFurnitureGUI.main(carpet, grid);
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
					AddFurnitureGUI.main(carpet, grid);
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
