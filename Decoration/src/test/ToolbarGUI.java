 package test;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import catalog.Catalog;
import place.AbstractRoom;

import java.awt.event.*;

/**
 * @author ZOUHOUDI Chabani
 * @author CORALIE Laury Ann
 */
public class ToolbarGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3392452619174690772L;
	
	private JPanel contentPane;
	private JPanel panel = new JPanel();
	private static ToolbarGUI frame = new ToolbarGUI();
	
	private Object[] room = {"Kitchen","Living Room", "Dining Room", "Bedroom/Office","Bathroom","Wall","Floor"};
	
	private 	JToolBar toolBar = new JToolBar();
	
	private JButton btnAddARoom = new JButton("ADD A ROOM");
	private JButton btnRemoveARoom = new JButton("REMOVE A ROOM");
	private JButton btnRemoveAFurn = new JButton("REMOVE A FURNITURE");
	
	private JSeparator separator = new JSeparator();
	private JSeparator separator_1 = new JSeparator();
	
	private String [] catalog = {"Kitchen","Living Room","Dining Room","Bedroom/Office","Bathroom"};
	private JList <String >list = new JList <String> (catalog);
	private String [] kitchenFurniture = {"<< Return","Fridge","Gas Cooker","Sink","Countertop"};
	private JList <String> kitchenList = new JList <String> (kitchenFurniture);
	private String [] livingRoomFurniture = {"<< Return","Coffee Table" ,"Small sofa","Big sofa","Armchair"};
	private JList <String> livingRoomList = new JList <String> (livingRoomFurniture);
	private String [] diningRoomFurniture = {"<< Return","Small Dining Table", "Big Dining Table","Chair","Sideboard"};
	private JList <String> diningRoomList = new JList <String> (diningRoomFurniture);
	private String [] bedroomOfficeFurniture = {"<< Return","Single Bed","Double Bed","Nightstand","Chest of Drawers","Wardrobe","Desk","Chair"};
	private JList <String> bedroomOfficeList = new JList <String> (bedroomOfficeFurniture);
	private String [] bathroomFurniture = {"<< Return","Toilet","Shower","Bathtub","Sink","Contertop"};
	private JList <String> bathroomList = new JList <String> (bathroomFurniture);
	private String [] wallFurniture = {"<< Return","Wallpaper","Paint","Panelling","Doors","Windows","Arts"};
	private JList <String> wallList = new JList <String> (wallFurniture);
	private String [] floarFurniture = {"<< Return","Carpeting", "Parquet","Tiles","Rugs"};
	private JList <String> floarList = new JList <String> (floarFurniture);
	
	
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					frame.setVisible(true);
				    frame.setTitle(" Toolbar ");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame
	 */
	public ToolbarGUI() {
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
				
				AddRoomGUI.main(null);
			}
		});
		toolBar.add(btnAddARoom);
		
		btnRemoveARoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RemoveRoomGUI.main(null);
			}
		});
			
		toolBar.add(separator);
		toolBar.add(btnRemoveARoom);
		
		btnRemoveAFurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	
		toolBar.add(separator_1);
		toolBar.add(btnRemoveAFurn);
		
		panel.add(list);
		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
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
				if (list.getSelectedValue() == "Floar") {
					panel.add(floarList);
					list.setVisible(false);
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
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
				if (list.getSelectedValue() == "Floar") {
					panel.add(floarList);
					list.setVisible(false);
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
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
				if (list.getSelectedValue() == "Floar") {
					panel.add(floarList);
					list.setVisible(false);
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
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
				if (list.getSelectedValue() == "Floar") {
					panel.add(floarList);
					list.setVisible(false);
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Stub de la méthode généré automatiquement
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
				if (list.getSelectedValue() == "Floar") {
					panel.add(floarList);
					list.setVisible(false);
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
