package test;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import catalog.Style;
import place.*;

/**
 * @author CORALIE Laury Ann
 * @author GILLES Anne-Sophie
 */
public class AddFurnitureGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JLabel lblStyle = new JLabel ("Choose the style:");
	private JLabel lblColor = new JLabel ("Choose the color:");
	private JLabel lblPosition = new JLabel ("Coordinates:");
	private JLabel lblX = new JLabel("X");
	private JLabel furnitureName;
	private JLabel lblRoom = new JLabel ("Choose the room:");
	private JLabel lblOrientation = new JLabel ("Choose the furniture's orientation :");
	
	private JComboBox<Style> comboBoxStyle = new JComboBox<Style> ();
	private JComboBox<String> comboBoxColor = new JComboBox <String> ();
	private JComboBox<Integer> comboBoxX = new JComboBox<Integer>();
	private JComboBox<Integer> comboBoxY = new JComboBox<Integer>();
	private JComboBox<String> comboBoxRoom = new JComboBox<String>();
	private JComboBox <String> comboBoxOrientation = new JComboBox <String> ();
	
	private JButton btnAdd = new JButton ("Add");

	private String currentRoomName = null;
	private Room currentRoom = null;
	
	private int furniturePositionY = -1;
	private int furniturePositionX = -1;
	
	//private String furnitureStyle = null; //TODO quand style + color sera impl�ment�
	//private String furnitureColor = null;
	
//TODO ajouter une option pour choisir la direction du meuble : North/South/East/West je ferais les m�thodes pour que �a fonctionne
	/**
	 * Launch the application.
	 * @param furniture
	 * @param grid
	 * @param apartment 
	 */
	public static void main(AbstractRoom furniture, Grid grid, Apartment apartment) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFurnitureGUI frame = new AddFurnitureGUI(furniture, grid, apartment);
					frame.setVisible(true);
					frame.setTitle("Manag'Apart - Add a furniture");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 * @param furnitureToAdd
	 * @param grid
	 * @param apartment 
	 */
	public AddFurnitureGUI(AbstractRoom furnitureToAdd, Grid grid, Apartment apartment) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 454, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		furnitureName = new JLabel (furnitureToAdd.getName().toUpperCase());
		furnitureName.setHorizontalAlignment(SwingConstants.CENTER);
		furnitureName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		furnitureName.setLocation(138, 0);
		furnitureName.setSize(161, 55);
		contentPane.add(furnitureName);
		
		lblColor.setBounds(47, 65, 103, 15);
		contentPane.add(lblColor);
		
		lblStyle.setBounds(47, 95, 103, 15);
		contentPane.add(lblStyle);
		
		comboBoxColor.setBounds(143, 60, 71, 22);
		contentPane.add(comboBoxColor);
		
		comboBoxStyle.setBounds(143, 90, 71, 22);
		contentPane.add(comboBoxStyle);
		
		lblPosition.setBounds(47, 125, 86, 15);
		contentPane.add(lblPosition);
		
		comboBoxX.setBounds(143, 125, 34, 15);
		contentPane.add(comboBoxX);
		comboBoxY.setBounds(205, 125, 35, 15);
		contentPane.add(comboBoxY);
		for(int i=1 ; i<=grid.getGridDimension().getWidth() ; i++)
		{
			comboBoxX.addItem(i);
		}
		for(int j=1 ; j<=grid.getGridDimension().getLength() ; j++)
		{
			comboBoxY.addItem(j);
		}
		
		lblX.setBounds(195, 125, 19, 14);
		contentPane.add(lblX);
		
		lblRoom.setBounds(195,300,19,14);
		contentPane.add(lblRoom);
		
		contentPane.add(lblOrientation);
		
		comboBoxOrientation.addItem("NORTH");
		comboBoxOrientation.addItem("SOUTH");
		comboBoxOrientation.addItem("EAST");
		comboBoxOrientation.addItem("WEST");
		contentPane.add(comboBoxOrientation);
		
		btnAdd.setBounds(294, 95, 89, 23);
		contentPane.add(btnAdd);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				furniturePositionY = Integer.valueOf(comboBoxY.getSelectedItem().toString())-1;
				furniturePositionX = Integer.valueOf(comboBoxX.getSelectedItem().toString())-1;
				currentRoom = apartment.getRoom(currentRoomName);
				//furnitureStyle = comboBoxStyle.getSelectedItem().toString(); //TODO quand impl�ment�s + en dessous
				//furnitureColor = comboBoxColor.getSelectedItem().toString();
				
				if(furniturePositionY!=-1 && furniturePositionX!=-1 /*&& furnitureColor!=null && furnitureStyle!=null*/ && currentRoom!=null)
				{
//TODO tjr le meme pb avec la jcombobox ???? 
					// TODO Quel pb?
					if(!currentRoom.addFurniture(furnitureToAdd, furniturePositionX, furniturePositionY, grid))
					{
						JOptionPane.showMessageDialog(null,"ERROR: furnitureToAdd could not be add!", "ERROR",JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						dispose();
					}
				}
			}
		});
		
		
		comboBoxRoom.setBounds(179, 39, 99, 20);
		contentPane.add(comboBoxRoom);
		HashMap<Integer, Room> room = apartment.getRoomsList();
		
		for (int index=0 ; index<room.size() ; index++) {
			String roomName = room.get(index).getName();
			comboBoxRoom.addItem (roomName);
		}
		
		comboBoxRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComboBox<?> combo = (JComboBox<?>)arg0.getSource();
				currentRoomName = (String) combo.getSelectedItem();	
			}
		});
	}
		//TODO utiliser ImageIcon(getURL(getCodeBase(),"")) pour integrer les images des meubles
		
		public void paintComponent(Graphics g) throws IOException{
		   
		      Image img = ImageIO.read(new File("Decoration/drawings/"+furnitureName+".jpg"));
		      g.drawImage(img, furniturePositionX, furniturePositionY, this);
	}
	
	
}
