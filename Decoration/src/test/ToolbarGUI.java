 package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

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

	private JToolBar toolBar = new JToolBar();
	
	private JButton btnAddARoom = new JButton("Add a Room");
	private JButton btnRemoveARoom = new JButton("Remove a Room");
	private JButton btnRemoveAFurniture = new JButton("Remove a Furniture");
	
	private JSeparator separator = new JSeparator();
	private JSeparator separator_1 = new JSeparator();
	private final JList<String> addFurniture;
	private DefaultListModel<String> listBathroom;
	private DefaultListModel<String> listBedroomOffice;
	private DefaultListModel<String> listDiningRoom;
	private DefaultListModel<String> listFloor;
	private DefaultListModel<String> listKitchen;
	private DefaultListModel<String> listLivingRoom;
	private DefaultListModel<String> listWall;
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	
	private String [] room = {"-- Select a room to add a furniture --", "Bathroom", "BedroomOffice","Kitchen","LivingRoom","DiningRoom","Wall","Floor"};
	private String chosenRoom;

	private Grid keepGrid; 
	private Catalog keepCatalog;
	private Apartment keepApartment;

	
	/**
	 * Launch the application
	 * @param apartment
	 * @param grid
	 * @param catalog
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
	 * @param apartment
	 * @param grid
	 * @param catalog
	 */
	public ToolbarGUI(Apartment apartment, Grid grid, Catalog catalog) {
		keepGrid = grid;
		keepCatalog = catalog;
		keepApartment = apartment;
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 440, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
			
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(toolBar, BorderLayout.NORTH);
	
		toolBar.add(btnAddARoom);
		toolBar.add(separator);
		toolBar.add(btnRemoveARoom);
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurniture);
		
		btnAddARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddRoomGUI.main(apartment, grid);
			}
		});
		
		btnRemoveARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveRoomGUI.main(apartment, grid);
			}
		});
		
		btnRemoveAFurniture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveFurnitureGUI.main(apartment, grid);
			}
		});
		
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
		
		comboBoxRoom = new JComboBox<String>(room);
		comboBoxRoom.setToolTipText("");
		comboBoxRoom.setLocation(100, 5);
		comboBoxRoom.setSize(213, 20);
		listPanel.add(comboBoxRoom);
		
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
					case "LivingRoom":
						addFurniture.setModel(listLivingRoom);
						addFurniture.setBounds(135, 51, 144, 80);
						break;
					case "DiningRoom":
						addFurniture.setModel(listDiningRoom);
						addFurniture.setBounds(135, 51, 144, 80);
						break;
					case "BedroomOffice":
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
		listPanel.add(addFurniture);
		
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
		
		listBedroomOffice.addElement("Single bed");
		listBedroomOffice.addElement("Double bed");
		listBedroomOffice.addElement("DiningRoom");
		listBedroomOffice.addElement("Nightstand");
		listBedroomOffice.addElement("Dresser");
		listBedroomOffice.addElement("Wardrobe");
		listBedroomOffice.addElement("Office chair");
		listBedroomOffice.addElement("Desk");
	}
	
	private void setListDiningRoom()
	{
		listDiningRoom.removeAllElements();
		
		listDiningRoom.addElement("Small dining table");
		listDiningRoom.addElement("Large dining table");
		listDiningRoom.addElement("Buffet");
		listDiningRoom.addElement("Chair");
	}
	
	private void setListFloor()
	{
		listFloor.removeAllElements();

		listFloor.addElement("Carpet");
//TODO ajouter les sols
	}
	
	private void setListKitchen()
	{
		listKitchen.removeAllElements();
		
		listKitchen.addElement("Fridge");
		listKitchen.addElement("Gas cooker");
		listKitchen.addElement("Sink");
		listKitchen.addElement("Kitchen worktop");
	}
	
	private void setListLivingRoom()
	{
		listLivingRoom.removeAllElements();
		
		listLivingRoom.addElement("Armchair");
		listLivingRoom.addElement("Coffee table");
		listLivingRoom.addElement("Small sofa");
		listLivingRoom.addElement("Large sofa");
	}
	
	private void setListWall()
	{
		listWall.removeAllElements();
		
		listWall.addElement("Small door");
		listWall.addElement("Large door");
		listWall.addElement("Small window");
		listWall.addElement("Large window");
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
					AbstractRoom selectedFurniture = keepCatalog.getFurniture(name);
					AddFurnitureGUI.main(selectedFurniture, keepGrid, keepApartment);
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
