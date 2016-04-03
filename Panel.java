import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
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
	public GridBagConstraints gbc;
	public JLabel welcomeLabel;
	public JLabel insertCardLabel;
	public JLabel passwordLabel;
	public JLabel transactionLabel;
	public JLabel oldPinLabel;
	public JLabel newPinLabel;
	public JLabel newPinLabel2;
	public JButton cardButton;
	public JButton depositButton;
	public JButton withdrawButton;
	public JButton infoButton;
	public JButton chgPinButton;
	public JButton exitButton;
	private JButton emergencyButton;
	private Card card = new Card(0,0,0,0);
	private CardManager cMan = new CardManager(card);
	public JButton submitButton;
	public JButton cancelButton;
	public CardLayout mainLayout;
	public JPasswordField pinField;
	public JPasswordField newPinField;
	public JPasswordField newPinField2;
	public JPasswordField oldPinField;
	public int oldPin;
	public int newPin;
	public int newPin2;	
	public static final String OK = "OK";
	private File selectedFile;
	
	public Panel() 
	{
		frame = new JFrame();
		mainPanel = new JPanel();
		welcomePanel = new JPanel();
		passwordPanel = new JPanel();
		transactionPanel = new JPanel();
		chgPinPanel = new JPanel();
		infoPanel = new JPanel();
		mainLayout = new CardLayout();
		gbc = new GridBagConstraints();
		welcomeLabel = new JLabel("Welcome!");
		insertCardLabel  = new JLabel("Please Insert Card");
		cardButton = new JButton("Browse Card");
		passwordLabel = new JLabel("Enter Pin:");	
		oldPinLabel = new JLabel("Enter old pin:");
		newPinLabel = new JLabel("Enter new pin:");
		newPinLabel2 = new JLabel("Verify new pin:");
		pinField = new JPasswordField(4);
		newPinField = new JPasswordField(4);
		newPinField2 = new JPasswordField(4);
		oldPinField = new JPasswordField(4);
		transactionLabel = new JLabel("Please select a transaction.");
		withdrawButton = new JButton("Withdraw");
		depositButton = new JButton("Deposit");
		chgPinButton = new JButton("Change Pin");
		infoButton = new JButton("View Account Information");
		exitButton = new JButton("Exit");
		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		emergencyButton = new JButton("I need Assistance!");
	}
	
	public void gui()
	{
		mainPanel.setLayout(mainLayout);
		mainPanel.add(welcomePanel , "1");
		mainPanel.add(passwordPanel, "2");
		mainPanel.add(transactionPanel, "3");
		mainPanel.add( chgPinPanel  , "4");
		mainPanel.add(infoPanel, "5");
		
		this.welcomeMenu();
		this.passwordMenu();
		this.transactionMenu();
		this.chgPinMenu();
		this.infoPanel();
		
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
		
		emergencyButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.SOUTH;
		welcomePanel.add(emergencyButton, gbc);
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
		
		emergencyButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.SOUTH;
		passwordPanel.add(emergencyButton, gbc);
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
		transactionPanel.add(emergencyButton, gbc);
	}
	public void infoPanel(){
		
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
		
		submitButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.gridx = 1;
		gbc.gridy = 3;
		chgPinPanel.add(submitButton , gbc);	
		
		emergencyButton.addActionListener(this);
		gbc.anchor = GridBagConstraints.SOUTH;
		chgPinPanel.add(emergencyButton, gbc);
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
				} //yes it writes it to itself, I'm being lazy				
				mainLayout.show(mainPanel , "2");
			}			
		}
		else if(event.getSource() == exitButton){
			setVisible(false); 
			dispose();
		}
		else if(event.getSource() == submitButton){
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
		else if(event.getSource() == withdrawButton){
			//stuff
		}
		else if(event.getSource() == depositButton){
			//stuff
		}
		else if(event.getSource() == infoButton){
			//stuff
		}
		else if(event.getSource() == emergencyButton)
		
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
}
