import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javax.swing.*;

/**
 * This class implements the Vending Machine frame with all of its components.
 * 
 * CSCE 155A Spring 2016
 * Assignment 6
 * @author TRIEU HUNG TRAN
 * @date April 23, 2016
 */
public class VendingMachineFrame extends JFrame implements ActionListener {
	
	//Data members
	private DecimalFormat 			df = new DecimalFormat("0.00");
	private JTextArea 				menu;
	private JLabel					itemText;
	private JLabel					moneyText;
	private JLabel 					searchLabel;
	private JLabel 					resultLabel;
	private JLabel 					keyPadsLabel;
	private JLabel					itemLabel;
	private JLabel 					moneyLabel;
	private JTextField				searchText;
	private JPanel					letterPanel;
	private JPanel					numberPanel;
	private JPanel 					panel;
	private JButton					buttonA;
	private JButton					buttonB;
	private JButton					buttonC;
	private JButton					buttonD;
	private JButton					buttonE;
	private JButton					buttonF;
	private JButton					button1;
	private JButton					button2;
	private JButton					button3;
	private JButton					button4;
	private JButton					button5;
	private JButton					button6;
	private JButton 				getChangeButton;
	private JButton					addMoneyButton;
	private JButton 				vendButton;
	private VendingMachine 			data;
	private VendingMachineDriver 	selectionFrame;
	private double					money = 0.0;
	
	/**
	 * This constructor creates Vending Machine frame to interact with users. 
	 * @param data vending machine data
	 * @param selectionFrame the selection frame to switch back after using
	 * @param type a String represents the vending machine's type
	 * @throws FileNotFoundException
	 */
	public VendingMachineFrame(VendingMachine data, VendingMachineDriver selectionFrame, 
			String type) throws FileNotFoundException {
		this.data = data;
		this.selectionFrame = selectionFrame;
		
		//Set frame
		if (type.equals("d"))
			setTitle("Drinks Vending Machine");
		else
			setTitle("Snacks Vending Machine");
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		Container contentPane = getContentPane();
		
		//Create panel to add components
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(605, 570));

		//Add menu
		menu = new JTextArea();
		menu.setEditable(false);
		menu.setColumns(18);
		menu.setRows(8);
		printMenu();

		JScrollPane scrollText = new JScrollPane(menu);
		scrollText.setBounds(330, 20, 265, 487);
		panel.add(scrollText);

		//Add search
		searchLabel = new JLabel("Search for Item:");
		searchLabel.setBounds(20, 29, 95, 20);

		searchText = new JTextField();
		searchText.setBounds(120, 26, 180, 30);
		searchText.addActionListener(this);

		resultLabel = new JLabel("");
		resultLabel.setBounds(60, 66, 240, 20);

		panel.add(searchLabel);
		panel.add(searchText);
		panel.add(resultLabel);

		//Add Key Pads
		keyPadsLabel = new JLabel("Make a selection:");
		keyPadsLabel.setFont(new Font("Arial", Font.BOLD, 20));
		keyPadsLabel.setBounds(100, 120, 200, 40);

		letterPanel = new JPanel();
		letterPanel.setBounds(40, 190, 120, 175);
		letterPanel.setBorder(BorderFactory.createEtchedBorder());
		letterPanel.setLayout(null);

		numberPanel = new JPanel();
		numberPanel.setBounds(180, 190, 120, 175);
		numberPanel.setBorder(BorderFactory.createEtchedBorder());
		numberPanel.setLayout(null);

		buttonA = new JButton("A");
		buttonA.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonA.setBounds(10, 10, 45, 45);
		letterPanel.add(buttonA);
		buttonA.addActionListener(this);

		buttonB = new JButton("B");
		buttonB.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonB.setBounds(65, 10, 45, 45);
		letterPanel.add(buttonB);
		buttonB.addActionListener(this);

		buttonC = new JButton("C");
		buttonC.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonC.setBounds(10, 65, 45, 45);
		letterPanel.add(buttonC);
		buttonC.addActionListener(this);

		buttonD = new JButton("D");
		buttonD.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonD.setBounds(65, 65, 45, 45);
		letterPanel.add(buttonD);
		buttonD.addActionListener(this);

		buttonE = new JButton("E");
		buttonE.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonE.setBounds(10, 120, 45, 45);
		letterPanel.add(buttonE);
		buttonE.addActionListener(this);

		buttonF = new JButton("F");
		buttonF.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonF.setBounds(65, 120, 45, 45);
		letterPanel.add(buttonF);
		buttonF.addActionListener(this);

		button1 = new JButton("1");
		button1.setFont(new Font("Arial", Font.PLAIN, 15));
		button1.setBounds(10, 10, 45, 45);
		numberPanel.add(button1);
		button1.addActionListener(this);

		button2 = new JButton("2");
		button2.setFont(new Font("Arial", Font.PLAIN, 15));
		button2.setBounds(65, 10, 45, 45);
		numberPanel.add(button2);
		button2.addActionListener(this);

		button3 = new JButton("3");
		button3.setFont(new Font("Arial", Font.PLAIN, 15));
		button3.setBounds(10, 65, 45, 45);
		numberPanel.add(button3);
		button3.addActionListener(this);

		button4 = new JButton("4");
		button4.setFont(new Font("Arial", Font.PLAIN, 15));
		button4.setBounds(65, 65, 45, 45);
		numberPanel.add(button4);
		button4.addActionListener(this);

		button5 = new JButton("5");
		button5.setFont(new Font("Arial", Font.PLAIN, 15));
		button5.setBounds(10, 120, 45, 45);
		numberPanel.add(button5);
		button5.addActionListener(this);

		button6 = new JButton("6");
		button6.setFont(new Font("Arial", Font.PLAIN, 15));
		button6.setBounds(65, 120, 45, 45);
		numberPanel.add(button6);
		button6.addActionListener(this);

		panel.add(keyPadsLabel);
		panel.add(letterPanel);
		panel.add(numberPanel);

		//Add item selection
		itemLabel = new JLabel("Item Selection:");
		itemLabel.setBounds(40, 410, 95, 20);

		itemText = new JLabel("");
		itemText.setBounds(180, 405, 120, 30);
		itemText.setBorder (BorderFactory.createLoweredBevelBorder());

		panel.add(itemLabel);
		panel.add(itemText);

		//Add money remaining
		moneyLabel = new JLabel("Money Remaining:");
		moneyLabel.setBounds(40, 472, 120, 20);

		moneyText = new JLabel(" ");
		moneyText.setBounds(180, 468, 120, 30);
		moneyText.setBorder (BorderFactory.createLoweredBevelBorder());

		panel.add(moneyLabel);
		panel.add(moneyText);

		//Get change button
		getChangeButton = new JButton("Get Change");
		getChangeButton.setBounds(40, 522, 120, 30);
		getChangeButton.addActionListener(this);
		panel.add(getChangeButton);

		//Add money button
		addMoneyButton = new JButton("Add Money");
		addMoneyButton.setBounds(180, 522, 120, 30);
		addMoneyButton.addActionListener(this);
		panel.add(addMoneyButton);

		//Vend! button
		vendButton = new JButton("Vend!");
		vendButton.setBounds(400, 522, 120, 30);
		vendButton.addActionListener(this);
		panel.add(vendButton);		

		//Add panel in frame
		contentPane.add(panel);
		pack();
		setLocationRelativeTo(null);
	}//End VendingMachineFrame constructor
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JTextField) { //If user searches for item
			String item = searchText.getText().trim();
			int found = data.searchItem(item);
			if (found != -1)
				resultLabel.setText(data.getInfo(found));
			else
				resultLabel.setText("No item was found");
		}
		else {
			JButton button = (JButton)e.getSource();
			if (button == addMoneyButton) 			//If user pressed Add Money
				addMoney();
			else if (button == vendButton) 			//If user pressed Vend!
				vend();
			else if (button == getChangeButton){	//If user pressed Get Change
				JOptionPane.showMessageDialog(this, "You did not buy anything.\n"
						+ "Your change is $" + df.format(money) + ".");
				switchFrame();
			}
			else {								//If user pressed key pad buttons
				String selection = itemText.getText() + button.getText();
				if (selection.length() == 4)
					selection = selection.substring(2);
				itemText.setText((selection.charAt(0) == ' ' ? "" : " ") + 
						selection);
			}
		}
	}//End actionPerformed method
	
	/**
	 * This method implements the process of adding money into the machine.
	 */
	public void addMoney() {
		boolean inputIsValid = false;
		double newMoney = 0.0;
		do {
			String input = JOptionPane.showInputDialog(selectionFrame, "Please enter "
					+ "money into the machine:", "Input Money", 
					JOptionPane.PLAIN_MESSAGE);
			if (input == null)
				inputIsValid = true;
			else 
				try {
					newMoney = Double.parseDouble(input.trim());
					if (newMoney < 0) 
						throw new Exception();
					inputIsValid = true;
				} catch (Exception e) {
					JOptionPane.showMessageDialog(selectionFrame, "Invalid Money! Please "
							+ "try again!", "Error", JOptionPane.ERROR_MESSAGE);
				}
		} while (!inputIsValid);
		money += newMoney;
		moneyText.setText(" $" + df.format(money));
	}//End addMoney method

	/**
	 * Print out the Menu into JTextArea component
	 */
	private void printMenu() {
		menu.setText("\tMachine Menu:\n\n");
		for(int index = 0; index < Math.min(data.getStock().length, 36); index++) 
			menu.append(" " + data.getInfo(index) + "\n");
	}
	
	/**
	 * This method implements the processing of vending.
	 */
	private void vend() {
		String selection = itemText.getText().trim();
		int found = data.searchID(selection);
		if (found == -1) 
			JOptionPane.showMessageDialog(this, "Sorry! Invalid item"
					+ " selection.", "Error", JOptionPane.ERROR_MESSAGE);
		else if (money < data.getStock()[found].getPrice())
			JOptionPane.showMessageDialog(this, "Sorry! You don't "
					+ "have enough money.\nPlease add more money or "
					+ "select another item.", "Error", 
					JOptionPane.ERROR_MESSAGE);
		else if (data.getStock()[found].getQuantity() == 0)
			JOptionPane.showMessageDialog(this, "Sorry! We are out"
					+ " of this item.");
		else {
			money -= data.getStock()[found].getPrice();
			moneyText.setText(" $" + df.format(money));
			data.getStock()[found].setQuantity(data.getStock()[found].getQuantity() - 1);
			printMenu();
			JOptionPane.showMessageDialog(this, "You have bought "
					+ data.getStock()[found].getDesc() + " with $" 
					+ df.format(data.getStock()[found].getPrice()) + ".\n "
					+ "Your change is $" + df.format(money) 
					+ ".\nThank you for your purchase!", "Congratulation",
					JOptionPane.INFORMATION_MESSAGE);
			switchFrame();
		}
	}//End vend method
	
	/**
	 * This method switchs from vending machine frame to selection frame
	 */
	private void switchFrame() {
		searchText.setText("");
		resultLabel.setText("");
		itemText.setText("");
		moneyText.setText("");
		money = 0.0;
		selectionFrame.setVisible(true);
		setVisible(false);
	}
	
}//End VendingMachineFrame class definition