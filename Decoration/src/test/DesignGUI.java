package test;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import catalog.Catalog;
import place.Apartment;
import place.Grid;

/**
 * @author CORALIE Laury Ann
 *
 */
public class DesignGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	private Catalog catalog = new Catalog("furniture_catalog.txt");
	private Apartment apartment = new Apartment();
	private place.Dimension dimGrid = new place.Dimension(20, 20);
	private Grid grid = new Grid(dimGrid);
	
	private JPanel contentPane;
	private JPanel[][] cells;

	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu = new JMenu("?");
	private JMenu mnView = new JMenu("View");
	private JMenuItem mntmHelp = new JMenuItem("Help");
	private JMenuItem mntmExit = new JMenuItem("Exit ");
	
	private JCheckBoxMenuItem chckbxmntmShowToolbar = new JCheckBoxMenuItem("Show Toolbar");

	
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
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 688, 477);
		
		
		setJMenuBar(menuBar);
		
		menuBar.add(menu);
		
		menu.add(mntmHelp);
		
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}	
		});
		
		menu.add(mntmExit);
		
		menuBar.add(mnView);
		
		chckbxmntmShowToolbar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxmntmShowToolbar.isSelected() == true) {
					ToolbarGUI.main(apartment, grid, catalog);
				}
			}
		});
		mnView.add(chckbxmntmShowToolbar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); 
	
		cells= contentGrille (contentPane);
		this.setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				    int confirmed = JOptionPane.showConfirmDialog(null,"Are you sure you want to exit the program?", "Exit Program Message Box",JOptionPane.YES_NO_OPTION);
				    if (confirmed == JOptionPane.YES_OPTION) {
				    		System.exit(0);
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