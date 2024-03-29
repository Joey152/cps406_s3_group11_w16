import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Panel extends JFrame implements ActionListener{
	
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	
	private String cardPin;
	public JFrame frame;
	public JPanel mainPanel;
	public JPanel welcomePanel;
	public JPanel passwordPanel;
	public JPanel transactionPanel;
	public JPanel chgPinPanel;
	public JPanel infoPanel;
	//added---------------------------------------------------------------------------------------------------------------------------------------
	public JPanel donatePanel;
	public JPanel printingPanel, printingPanel2;
	public JLabel donateLabel, printingLabel, printingLabel2;
	public JButton yesButton;
	public JButton noButton;
	//added-------------------------------------------------------------
	private JPanel historyPanel;
	public JPanel withdrawPanel;
	public JPanel depositPanel;
	public GridBagConstraints gbc;
	public JLabel welcomeLabel;
	public JLabel insertCardLabel;
	public JLabel passwordLabel;
	public JLabel transactionLabel;
	public JLabel oldPinLabel;
	public JLabel newPinLabel;
	public JLabel newPinLabel2;
	public JLabel withdrawLabel;
	public JLabel depositLabel;
	private JLabel historyLabel;
	private JLabel info;
	public JButton cardButton;
	public JButton depositButton;
	public JButton withdrawButton;
	public JButton infoButton;
	public JButton chgPinButton;
	public JButton exitButton;
	private JButton backToMenu;
	private JButton backToInfo;
	private JButton historyButton;
	public JButton submitWithdrawBtn;
	public JButton submitDepositBtn;
	public JButton submitChgPinBtn;
	private Card card = new Card(0,0,0,0); //sadly needed to do this, lazy programming, I know
	private JButton emergencyButton;
	private CardManager cMan = new CardManager(card);
	public JButton cancelButton;
	public CardLayout mainLayout;
	public JPasswordField pinField;
	public JPasswordField newPinField;
	public JPasswordField newPinField2;
	public JPasswordField oldPinField;
	public JTextField withdrawField;
	public JTextField depositField;
	public int oldPin;
	public int newPin;
	public int newPin2;	
	public static final String OK = "OK";
	private File selectedFile;
	private int transAmount;
	private BankAccount bAccount;
	private Transactions transaction;
	
	public Panel() 
	{
		frame = new JFrame();
		mainPanel = new JPanel();
		welcomePanel = new JPanel();
		passwordPanel = new JPanel();
		transactionPanel = new JPanel();
		chgPinPanel = new JPanel();
		infoPanel = new JPanel();
		historyPanel = new JPanel();
		withdrawPanel = new JPanel();
		depositPanel = new JPanel();
		mainLayout = new CardLayout();
		gbc = new GridBagConstraints();
		welcomeLabel = new JLabel("Welcome!");
		insertCardLabel  = new JLabel("Please Insert Card");
		cardButton = new JButton("Browse Card");
		passwordLabel = new JLabel("Enter Pin:");	
		oldPinLabel = new JLabel("Enter old pin:");
		newPinLabel = new JLabel("Enter new pin:");
		newPinLabel2 = new JLabel("Verify new pin:");
		//========================================================================================================================================================
		donatePanel= new JPanel();
		printingPanel = new JPanel(); //no
		printingPanel2 = new JPanel(); //yes
		donateLabel = new JLabel("Would you like to donate a looney to the DDF today?");
		printingLabel = new JLabel("Thank you. Printing Receipt...");
		printingLabel2 = new JLabel("Thank you SO MUCH. Printing Receipt...");
		yesButton = new JButton("YES");
		noButton = new JButton("NO");
		//======================================================================================
		withdrawLabel = new JLabel("Enter amount to withdraw:");
		depositLabel = new JLabel("Enter amount to deposit:");
		info = new JLabel();
		historyLabel = new JLabel();
		pinField = new JPasswordField(4);
		newPinField = new JPasswordField(4);
		newPinField2 = new JPasswordField(4);
		oldPinField = new JPasswordField(4);
		withdrawField = new JTextField(3);
		depositField = new JTextField(3);
		transactionLabel = new JLabel("Please select a transaction.");
		withdrawButton = new JButton("Withdraw");
		depositButton = new JButton("Deposit");
		chgPinButton = new JButton("Change Pin");
		infoButton = new JButton("View Account Information");
		exitButton = new JButton("Exit");
		submitChgPinBtn = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		backToMenu = new JButton("Back");
		backToInfo = new JButton("Back");
		emergencyButton = new JButton("I need Assistance!");
		historyButton = new JButton("Print transaction history");
		submitWithdrawBtn = new JButton("Withdraw");
		submitDepositBtn = new JButton("Deposit");

	}
	
	public void gui()
	{
		mainPanel.setLayout(mainLayout);
		mainPanel.add(welcomePanel , "1");
		mainPanel.add(passwordPanel, "2");
		mainPanel.add(transactionPanel, "3");
		mainPanel.add( chgPinPanel  , "4");
		mainPanel.add(infoPanel, "5");
		mainPanel.add(historyPanel, "6");
		mainPanel.add(withdrawPanel , "7");
		mainPanel.add(depositPanel , "8");
		//this too-------------------------------------------------------------------------------------------------------------------------------------------------
		mainPanel.add(donatePanel, "69");
		mainPanel.add(printingPanel, "70");//no
		mainPanel.add(printingPanel2, "71");//yes
		//this too-------------------------------------------------------------------------------------------------------------------------------------------------
		
		this.welcomeMenu();
		this.passwordMenu();
		this.transactionMenu();
		this.chgPinMenu();
		this.withdrawMenu();
		this.depositMenu();
		//this too-----------------------------------------------------------------------------------------------------------------------------------------------------
		this.donatePanel();
		//this.printingPanel();
		//this.printingPanel2();
		//this too--------------------------------------------------------------------------------------------------------------------------------------------------

		add(mainPanel);
		setSize(FRAME_WIDTH , FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void welcomeMenu()
	{
		welcomePanel.setLayout(new GridBagLayout());
		
		welcomeLabel.setFont(new Font("Calibri" , Font.BOLD , 40));
		gbc.anchor = GridBagConstraints.CENTER; 
		gbc.weighty = 10;
		gbc.gridx = 0;
		gbc.gridy = 0;
		welcomePanel.add(welcomeLabel , gbc);
		
		insertCardLabel.setFont(new Font("Calibri" , Font.BOLD , 30));
		gbc.anchor = GridBagConstraints.PAGE_END; 
		gbc.weighty = 10;
		gbc.gridx = 0;
		gbc.gridy = 1;
		welcomePanel.add(insertCardLabel , gbc);
		
		cardButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.PAGE_START; 
		gbc.weighty = 20;
		gbc.gridx = 0;
		gbc.gridy = 2;
		welcomePanel.add(cardButton , gbc);
	}	
	public void passwordMenu()
	{
		passwordPanel.setLayout(new GridBagLayout());
		
		passwordLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.weighty = 50;
		gbc.gridx = 0;
		gbc.gridy = 0;
		passwordPanel.add(passwordLabel, gbc);
		
		pinField.setActionCommand(OK);
		pinField.addActionListener(this);
		pinField.setEchoChar('*');
		pinField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.weighty = 50;
		gbc.gridx = 0;
		gbc.gridy = 1;
		passwordPanel.add(pinField , gbc);
		
		gbc.weighty = 0;
	}	
	public void transactionMenu()
	{
		transactionPanel.setLayout(new GridBagLayout());
		
		transactionLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.insets = new Insets(0 , 0 , 60 , 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		transactionPanel.add(transactionLabel , gbc);
		
		gbc.insets = new Insets(0 , 0 , 0 , 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.ipady = 40;
		gbc.ipadx = 40;
		gbc.gridx = 0 ;
		gbc.gridy = 1;
		transactionPanel.add(withdrawButton , gbc);
		
		gbc.gridx = 0 ;
		gbc.gridy = 2;
		transactionPanel.add(depositButton , gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		chgPinButton.addActionListener(this);
		transactionPanel.add(chgPinButton, gbc);
		
		gbc.gridx = 0 ;
		gbc.gridy = 4;
		infoButton.addActionListener(this);
		transactionPanel.add(infoButton , gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		exitButton.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.ipady = 20;
		gbc.ipadx = 20;
		gbc.insets = new Insets(20 , 0 , 0 , 0);
		transactionPanel.add(exitButton, gbc);
		
		emergencyButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.SOUTH;
		gbc.gridx = 0;
		gbc.gridy = 6;
		transactionPanel.add(emergencyButton, gbc);
	}
	
	public void infoPanel(){
		infoPanel.setLayout(new GridBagLayout());
		
		JLabel title = new JLabel("View Account Information");
		title.setFont(new Font("calibri", Font.BOLD, 30));
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.weighty = .2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		infoPanel.add(title, gbc);
		
		info.setFont(new Font("calibri", Font.BOLD, 30));
		gbc.anchor = GridBagConstraints.CENTER; 
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		infoPanel.add(info, gbc);
		
		backToMenu.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		infoPanel.add(backToMenu, gbc);
		
		historyButton.addActionListener(this);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		infoPanel.add(historyButton, gbc);
	}
	//and this-------------------------------------------------------------------------------------------------------------------------------------------
	public void donatePanel(){
		donatePanel.setLayout(new GridBagLayout());
		//gbc.fill = GridBagConstraints.HORIZONTAL;
		
		donateLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.insets = new Insets(0 , 0 , 60 , 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		donatePanel.add(donateLabel , gbc);

		yesButton.addActionListener(this);
		gbc.insets = new Insets(100 , 0 , 0 , 0);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 3;
		donatePanel.add(yesButton , gbc);
		
		noButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 1;
		gbc.gridy = 3;
		donatePanel.add(noButton , gbc);
	}
	public void printingPanel(){
		printingPanel.setLayout(new GridBagLayout());
		
		printingLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.insets = new Insets(0 , 0 , 60 , 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		printingPanel.add(printingLabel , gbc);
		Printer printer = new Printer(transaction);
		try {
			printer.printReceipt();
		} catch (IOException e) {
			System.out.println("Cannot write receipt to file!");
		}
		
		//this is supposed to pause for 2 seconds then exit
		//pause(2000);		
		//setVisible(false); 
		//dispose();
	}
	public void printingPanel2(){
		printingPanel2.setLayout(new GridBagLayout());
		
		printingLabel2.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.insets = new Insets(0 , 0 , 60 , 0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		printingPanel2.add(printingLabel2 , gbc);
		Printer printer = new Printer(transaction);
		try {
			printer.printReceipt();
		} catch (IOException e) {
			System.out.println("Cannot write receipt to file!");
		}
		//this is supposed to pause for 2 seconds then exit
		//pause(2000);		
		//setVisible(false); 
		//dispose();
	}
	//till here--------------------------------------------------------------------------------------------------------------------------------------------
	public void showHistory() {
		historyPanel.setLayout(new GridBagLayout());
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		historyPanel.add(historyLabel, gbc);
		
		backToInfo.addActionListener(this);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0;
		gbc.gridy = 1;
		historyPanel.add(backToInfo, gbc);
	}
	
	public void chgPinMenu()
	{
		chgPinPanel.setLayout(new GridBagLayout());
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		oldPinLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 0;
		gbc.gridy = 0;
		chgPinPanel.add(oldPinLabel , gbc);
		
		oldPinField.setEchoChar('*');
		oldPinField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 1;
		gbc.gridy = 0;
		chgPinPanel.add( oldPinField ,  gbc);
		
		newPinLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 0;
		gbc.gridy = 1;
		chgPinPanel.add( newPinLabel , gbc);
		
		newPinField.setEchoChar('*');
		newPinField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 1;
		gbc.gridy = 1;
		chgPinPanel.add( newPinField , gbc);
		
		newPinLabel2.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 0;
		gbc.gridy = 2;
		chgPinPanel.add(newPinLabel2 , gbc);
		
		newPinField2.setEchoChar('*');
		newPinField2.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 1;
		gbc.gridy = 2;
		chgPinPanel.add(newPinField2 , gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		
		cancelButton.addActionListener(this);
		gbc.insets = new Insets(100 , 0 , 0 , 0);
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.gridx = 0;
		gbc.gridy = 3;
		chgPinPanel.add(cancelButton , gbc);
		
		submitChgPinBtn.addActionListener(this);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 1;
		gbc.gridy = 3;
		chgPinPanel.add(submitChgPinBtn , gbc);	
	}
	public void withdrawMenu()
	{
		withdrawPanel.setLayout(new GridBagLayout());
		
		withdrawButton.addActionListener(this);
		
		withdrawLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 0;
		gbc.gridy = 0;
		withdrawPanel.add(withdrawLabel , gbc);
		
		withdrawField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(0 , 0 , 50 , 0 );
		gbc.gridx = 0;
		gbc.gridy = 1;
		withdrawPanel.add(withdrawField, gbc);
		
		submitWithdrawBtn.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 2;
		withdrawPanel.add(submitWithdrawBtn , gbc);
	}
	public void depositMenu()
	{
		depositPanel.setLayout(new GridBagLayout());
		
		depositButton.addActionListener(this);
		
		depositLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.gridx = 0;
		gbc.gridy = 0;
		depositPanel.add(depositLabel , gbc);
		
		depositField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.insets = new Insets(0 , 0 , 50 , 0 );
		gbc.gridx = 0;
		gbc.gridy = 1;
		depositPanel.add(depositField, gbc);
		
		submitDepositBtn.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 2;
		depositPanel.add(submitDepositBtn , gbc);
	}
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();		
		if(event.getSource() == cardButton){
			
		    Scanner in = null;
			JFileChooser chooser = new JFileChooser();
			
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				selectedFile = chooser.getSelectedFile();
				try {
					in = new Scanner(selectedFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if(in.hasNextLine()){
					cardPin = in.nextLine();
					card.setPin(Integer.parseInt(cardPin), selectedFile);
					bAccount = new BankAccount(card, "Ted");
					transaction = new Transactions(bAccount);
				} //yes it writes it to itself, I'm being lazy
				this.infoPanel();
				this.printingPanel();
				this.printingPanel2();
				this.showHistory();
				mainLayout.show(mainPanel , "2");
			}			
		}
		//changed this------------------------------------------------------------------------------------------------------------------------------------------
		else if(event.getSource() == exitButton){
			mainLayout.show(mainPanel, "69");
		}
		else if(event.getSource()== noButton){
			mainLayout.show(mainPanel, "70");
// 			pause(2000);		
// 			setVisible(false); 
// 			dispose();
		}
		else if(event.getSource()==yesButton){
			mainLayout.show(mainPanel, "71");
		}
		//changed this--------------------------------------------------------------------------------------------------------------------------------------------
		else if(event.getSource() == exitButton){
			//prompt for donate to charity
			//if yes
			boolean donate = false;
			if(donate)
			{
				Transactions transaction = new Transactions(bAccount);
				transaction.withdraw(1);
				/*transaction = new Transactions(charity);
				 * transaction.deposit(1)
				 */
				//likely this is not how an atm would do it, this is placeholder
			}
			setVisible(false); 
			dispose();
		}
		else if(event.getSource() == submitChgPinBtn){
			oldPin = Integer.parseInt(new String(oldPinField.getPassword()));
			newPin = Integer.parseInt(new String(newPinField.getPassword()));
			newPin2 = Integer.parseInt(new String(newPinField2.getPassword()));					
			
			cMan.setPin(oldPin,newPin,newPin2,selectedFile);
			
			mainLayout.show(mainPanel , "3");
		}
		else if(event.getSource() == cancelButton){
		 	mainLayout.show(mainPanel, "3");
			System.out.println("cancel (going back)");	
		}
		else if(event.getSource() == chgPinButton){
			mainLayout.show(mainPanel , "4");
		}
		else if(event.getSource() == submitWithdrawBtn){
			//need to enter amount
			//save amount to variable transAmount (need to parse int)
			transAmount = Integer.parseInt(withdrawField.getText());
			transaction.withdraw(transAmount);
			mainLayout.show(mainPanel, "3");
		}
		else if(event.getSource() == submitDepositBtn){
			//need to enter amount
			//save amount to variable transAmount (need to parse int)
			transAmount = Integer.parseInt(depositField.getText());
			transaction.deposit(transAmount);
			mainLayout.show(mainPanel, "3");
		}
		else if(event.getSource() == infoButton || event.getSource() == backToInfo){
			String str = new String("<html>Name: " + bAccount.getName() +
					"<br>Balance: " + bAccount.getAccountBalance() + "</html>");
			info.setText(str);
			mainLayout.show(mainPanel , "5");
		}
		else if(event.getSource() == emergencyButton) {
			// stuff
		}
		else if(event.getSource() == withdrawButton){
			mainLayout.show(mainPanel , "7");
		}
		else if(event.getSource() == depositButton){
			mainLayout.show(mainPanel , "8");
		}
		else if(event.getSource() == emergencyButton) {
			// stuff
		}
		else if(event.getSource() == historyButton) {
			/*Printer p = new Printer(transaction);
			String str = p.printTransactionHistory();*/
			historyLabel.setText("<html>Transaction history not working<br>because there is no database</html>");
			mainLayout.show(mainPanel, "6");
		}
		else if(event.getSource() == backToMenu) {
			mainLayout.show(mainPanel, "3");
		}
		
		if(OK.equals(command)){
//--------------------This part does not belong here.-----------------------------//	
			String userPin = new String(pinField.getPassword());
			if(userPin.equals(cardPin)){
				System.out.println("Password Correct!");
				mainLayout.show(mainPanel, "3");
			}else{
				System.out.println("Password Incorrect!");
				pinField.selectAll();
			}
//------------------------------------------------------------------------------------------//			
		}
	}
	//pause added
	public static void pause (int intMS){
		try{
			Thread.sleep(intMS);
		}catch(InterruptedException e){
		
		}
	}
	//pasue end
}
