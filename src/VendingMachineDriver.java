import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

/**
 * This class implements the selection frame for the Vending Machine program.
 * It is also a driver which includes the main method for other classes.
 * 
 * CSCE 155A Spring 2016
 * Assignment 6
 * @author TRIEU HUNG TRAN
 * @date April 23, 2016
 */
public class VendingMachineDriver extends JFrame implements ActionListener {

	//Data members
	private JComboBox 			comboBox;
	private JLabel 				selectionLabel;
	private VendingMachineFrame drinksFrame;
	private VendingMachineFrame snacksFrame;
	
	/**
	 * This is the main method which is the starting point of the solution 
	 * that creates frames to interact with users. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//Create vending machine data
		VendingMachine drinks = new VendingMachine("drinks.txt"); 
		VendingMachine snacks = new VendingMachine("snacks.txt");
		
		VendingMachineDriver selectionFrame = 
				new VendingMachineDriver(drinks, snacks);
		selectionFrame.setVisible(true);
	}//End main method

	/**
	 * This constructor creates a frame that prompts user for vending machine
	 * selection (Drinks or Snacks).
	 * @param drinks drinks vending machine data
	 * @param snacks snacks vending machine data
	 * @throws FileNotFoundException
	 */
	public VendingMachineDriver(VendingMachine drinks, VendingMachine snacks) 
			throws FileNotFoundException {
		//Create frames for each vending machine
		drinksFrame = new VendingMachineFrame(drinks, this, "d");
		snacksFrame = new VendingMachineFrame(snacks, this, "s");
		
		//Set frame
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setTitle("Vending Machine Selection");
		setResizable(false);
		Container contentPane = getContentPane();

		//Create panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize (new Dimension(380, 70));

		//Selection label
		selectionLabel = new JLabel("Please select a Vending Machine:");
		selectionLabel.setBounds(30, 25, 200, 20);
		panel.add(selectionLabel);

		//Combo box
		String[] vendingMachine = {"Snacks", "Drinks"};
		comboBox = new JComboBox(vendingMachine);
		comboBox.setBounds(250, 20, 100, 30);
		comboBox.addActionListener(this);
		panel.add(comboBox);

		contentPane.add(panel);
		pack();
		setLocationRelativeTo(null);
	}//End VendingMachineDriver constructor

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event) {
		JComboBox 			cb = (JComboBox)event.getSource();
		String 				selection = (String)cb.getSelectedItem();
		VendingMachineFrame newFrame;
		
		this.setVisible(false);
		if (selection.equals("Drinks"))
			newFrame = drinksFrame;
		else
			newFrame = snacksFrame;
		newFrame.addMoney();
		newFrame.setVisible(true);
	}//End actionPerformed method
	
}//End VendingMachineDriver class definition
