 package test;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;

import catalog.*;
import place.*;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class ToolbarGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Grid keepGrid;
	private Catalog keepCatalog;
	
	private JPanel contentPane;
	private JPanel panel = new JPanel();

	private JToolBar toolBar = new JToolBar();
	
	private JButton btnAddARoom = new JButton("Add a Room");
	private JButton btnRemoveARoom = new JButton("Remove a Room");
	private JButton btnRemoveAFurniture = new JButton("Remove a Furniture");
	
	private JSeparator separator = new JSeparator();
	private JSeparator separator_1 = new JSeparator();
	
	private JList<String> addFurniture;
	private DefaultListModel<String> listRooms;
	private DefaultListModel<String> listBathroom;
	private DefaultListModel<String> listBedroomOffice;
	private DefaultListModel<String> listDiningRoom;
	private DefaultListModel<String> listFloor;
	private DefaultListModel<String> listKitchen;
	private DefaultListModel<String> listLivingRoom;
	private DefaultListModel<String> listWall;
	
	private String [] room = {"-- Select a room to see the furnitures --","Kitchen","Living Room","Dining Room","Bedroom/Office","Bathroom","Wall","Floor"};
	private String chosenRoom;
	
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	
	private JPanel listPanel;

	
	
	
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
		keepGrid = grid;
		keepCatalog = catalog;
		
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
				
				AddRoomGUI.main(apartment, grid);
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
				RemoveFurnitureGUI.main(apartment, grid);
			}
		});
	
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurniture);
		
		comboBoxRoom = new JComboBox<String>(room);
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				chosenRoom = (String) combo.getSelectedItem(); 
				switch (chosenRoom) {
					case "-- Select a room to see the furnitures --":
						DefaultListModel curentModel = (DefaultListModel) addFurniture.getModel();
						curentModel.clear(); 
						break;
					case "Kitchen":
						addFurniture.setModel(listKitchen);
						break;
					case "Living Room":
						addFurniture.setModel(listLivingRoom);
						break;
					case "Dining Room":
						addFurniture.setModel(listDiningRoom);
						break;
					case "Bedroom/Office":
						addFurniture.setModel(listBedroomOffice);
						break;
					case "Bathroom":
						addFurniture.setModel(listBathroom);
						break;
					case "Wall":
						addFurniture.setModel(listWall);
						break;
					case "Floor":
						addFurniture.setModel(listFloor);
						break;
				}
			}
		});
		comboBoxRoom.setToolTipText("");
		comboBoxRoom.setLocation(0, 43);
		comboBoxRoom.setSize(423, 20);
		contentPane.add(comboBoxRoom);
		
		listRooms = new DefaultListModel<String>();
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
        addFurniture = new JList<String>();
        addFurniture.setModel(listRooms);
        addFurniture.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addFurniture.setLayoutOrientation(JList.VERTICAL);
        addFurniture.addMouseListener(new ClickAction());
        addFurniture.setBounds(133,555, 127, 135);
       
        this.add(listPanel);
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
			
			//TODO If room > changer la liste sinon addRoom
			
				name = name.toLowerCase();
				AbstractRoom selectedFurniture = keepCatalog.getFurniture(name);
				AddFurnitureGUI.main(selectedFurniture, keepGrid);
				addFurniture.setModel(listRooms);
			
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
