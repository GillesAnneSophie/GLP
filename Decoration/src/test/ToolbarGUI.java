 package test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

import catalog.*;
import place.*;


/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 * @author ZOUHOUDI Chabani
 */


public class ToolbarGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private JPanel listPanel;

	private JButton btnAddARoom = new JButton("Add a Room");
	private JButton btnRemoveARoom = new JButton("Remove a Room");
	private JButton btnRemoveAFurniture = new JButton("Remove a Furniture");
	
	private JList<String> addFurniture;
	private DefaultListModel<String> listBathroom;
	private DefaultListModel<String> listBedroomOffice;
	private DefaultListModel<String> listDiningRoom;
	private DefaultListModel<String> listFloor;
	private DefaultListModel<String> listKitchen;
	private DefaultListModel<String> listLivingRoom;
	private DefaultListModel<String> listWall;
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	
	private String chosenRoom;

	private Grid keepGrid; 
	private Catalog keepCatalog;
	private Apartment keepApartment;
	private JPanel keepGridPanel;
	private JLabel[][] keepTabGrid;

	
	/**
	 * Launch the application.
	 * @param apartment
	 * @param grid
	 * @param catalog
	 * @param gridPanel
	 * @param tabGrid
	 */
	public static void main(Apartment apartment, Grid grid, Catalog catalog, JPanel gridPanel, JLabel tabGrid[][]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					ToolbarGUI frame = new ToolbarGUI (apartment, grid, catalog, gridPanel, tabGrid);
					frame.setVisible(true);
				    frame.setTitle("Manag'Apart - ToolBar");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 * @param apartment
	 * @param grid
	 * @param catalog
	 * @param gridPanel
	 * @param tabGrid
	 */
	public ToolbarGUI(Apartment apartment, Grid grid, Catalog catalog, JPanel gridPanel, JLabel tabGrid[][]) {
		keepGrid = grid;
		keepCatalog = catalog;
		keepApartment = apartment;
		keepGridPanel = gridPanel;
		keepTabGrid = tabGrid;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 416, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		contentPane.add(panel, BorderLayout.CENTER);
		
		listBathroom = new DefaultListModel<String>();
		listBedroomOffice = new DefaultListModel<String>();
		listDiningRoom = new DefaultListModel<String>();
		listFloor = new DefaultListModel<String>();
		listKitchen = new DefaultListModel<String>();
		listLivingRoom = new DefaultListModel<String>();
		listWall = new DefaultListModel<String>();

		setListBathroom();
		setListBedroomOffice();
		setListDiningRoom();
		setListFloor();
		setListKitchen();
		setListLivingRoom();
		setListWall();
		
		listPanel = new JPanel();
        getContentPane().add(listPanel);
		listPanel.setLayout(null);
		
		comboBoxRoom = new JComboBox<String>();
		comboBoxRoom.setToolTipText("");
		comboBoxRoom.setLocation(84, 11);
		comboBoxRoom.setSize(247, 20);
		listPanel.add(comboBoxRoom);

		comboBoxRoom.addItem("-- Select a room to add a furniture --");
		comboBoxRoom.addItem("Bathroom");
		comboBoxRoom.addItem("Bedroom/Office");
		comboBoxRoom.addItem("Dining Room");
		comboBoxRoom.addItem("Kitchen");
		comboBoxRoom.addItem("Living Room");
		comboBoxRoom.addItem("Wall");
		comboBoxRoom.addItem("Floor");
		
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				chosenRoom = (String) combo.getSelectedItem(); 
				switch (chosenRoom) {
					case "-- Select a room to see the furnitures --":	
						addFurniture.setBounds(135, 51, 0, 0);
						break;
					case "Kitchen":
						addFurniture.setModel(listKitchen);
						addFurniture.setBounds(135, 51, 144, 80);
						
						break;
					case "Living Room":
						addFurniture.setModel(listLivingRoom);
						addFurniture.setBounds(135, 51, 144, 80);
						break;
					case "Dining Room":
						addFurniture.setModel(listDiningRoom);
						addFurniture.setBounds(135, 51, 144, 80);
						break;
					case "Bedroom/Office":
						addFurniture.setModel(listBedroomOffice);
						addFurniture.setBounds(135, 51, 144, 140);
						break;
					case "Bathroom":
						addFurniture.setModel(listBathroom);
						addFurniture.setBounds(135, 51, 144, 90);
						break;
					case "Wall":
						addFurniture.setModel(listWall);
						addFurniture.setBounds(135, 51, 144, 90);
						break;
					case "Floor":
						addFurniture.setModel(listFloor);
						addFurniture.setBounds(135, 51, 144, 17);
						break;
				}
			}
		});
		
		addFurniture = new JList<String>();
		addFurniture.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addFurniture.setLayoutOrientation(JList.VERTICAL);
		addFurniture.setBounds(135, 51, 0, 0);
		addFurniture.addMouseListener(new ClickAction());
		
		grid = keepGrid;
		apartment = keepApartment;
		catalog = keepCatalog;
		gridPanel = keepGridPanel;
		tabGrid = keepTabGrid;
		
		listPanel.add(addFurniture);
			
		JPanel buttonsPanel = new JPanel();
		contentPane.add(buttonsPanel, BorderLayout.NORTH);
		buttonsPanel.add(btnAddARoom);
		buttonsPanel.add(btnRemoveARoom);
		buttonsPanel.add(btnRemoveAFurniture);
			
		btnRemoveAFurniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveFurnitureGUI.main(keepApartment, keepGrid, keepGridPanel, keepTabGrid);
			}
		});
		
		btnRemoveARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveRoomGUI.main(keepApartment, keepGrid, keepGridPanel, keepTabGrid);
			}
		});
		
		btnAddARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddRoomGUI.main(keepApartment, keepGrid, keepGridPanel, keepTabGrid);
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
	
	
	private void setListBathroom()
	{
		listBathroom.removeAllElements();
		
		listBathroom.addElement("Toilet");
		listBathroom.addElement("Bath");
		listBathroom.addElement("Shower");
		listBathroom.addElement("Washbasin");
		listBathroom.addElement("Worktop");
	}
	
	private void setListBedroomOffice()
	{
		listBedroomOffice.removeAllElements();
		
		listBedroomOffice.addElement("Single Bed");
		listBedroomOffice.addElement("Double Bed");
		listBedroomOffice.addElement("Nightstand");
		listBedroomOffice.addElement("Dresser");
		listBedroomOffice.addElement("Wardrobe");
		listBedroomOffice.addElement("Office Chair");
		listBedroomOffice.addElement("Desk");
	}
	
	private void setListDiningRoom()
	{
		listDiningRoom.removeAllElements();
		
		listDiningRoom.addElement("Small Dining Table");
		listDiningRoom.addElement("Large Dining Table");
		listDiningRoom.addElement("Buffet");
		listDiningRoom.addElement("Chair");
	}
	
	private void setListFloor()
	{
		listFloor.removeAllElements();

		listFloor.addElement("Carpet");
	}
	
	private void setListKitchen()
	{
		listKitchen.removeAllElements();
		
		listKitchen.addElement("Fridge");
		listKitchen.addElement("Gas Cooker");
		listKitchen.addElement("Sink");
		listKitchen.addElement("Kitchen Worktop");
	}
	
	private void setListLivingRoom()
	{
		listLivingRoom.removeAllElements();
		
		listLivingRoom.addElement("Armchair");
		listLivingRoom.addElement("Coffee Table");
		listLivingRoom.addElement("Small Sofa");
		listLivingRoom.addElement("Large Sofa");
	}
	
	private void setListWall()
	{
		listWall.removeAllElements();
		
		listWall.addElement("Small Door");
		listWall.addElement("Large Door");
		listWall.addElement("Small Window");
		listWall.addElement("Large Window");
		listWall.addElement("Pictures");
	}
	
	class ClickAction implements MouseListener
	{
		public void mouseClicked(MouseEvent e) 
		{
				int selectedItem = addFurniture.getSelectedIndex();
				String name = (String) addFurniture.getModel().getElementAt(selectedItem);
				
				if(!name.isEmpty())
				{
					name = name.toLowerCase();
					Furniture selectedFurniture = keepCatalog.getFurniture(name);
					AddFurnitureGUI.main(selectedFurniture, keepGrid, keepApartment, keepGridPanel, keepTabGrid);
				}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
}
