

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
	public GridBagConstraints gbc;
	public JLabel welcomeLabel;
	public JLabel insertCardLabel;
	public JLabel passwordLabel;
	public JLabel transactionLabel;
	public JButton cardButton;
	public JButton depositButton;
	public JButton withdrawButton;
	public JButton infoButton;
	public JButton chgPinButton;
	public JButton exitButton;
	public CardLayout cLayout;
	public JPasswordField passwordField;
	private Card card = new Card(0,0,0,0);
	private CardManager cMan = new CardManager(card);
	
	public static final String OK = "OK";
	
	public Panel() 
	{
		frame = new JFrame();
		mainPanel = new JPanel();
		welcomePanel = new JPanel();
		passwordPanel = new JPanel();
		transactionPanel = new JPanel();
		cLayout = new CardLayout();
		gbc = new GridBagConstraints();
		welcomeLabel = new JLabel("Welcome!");
		insertCardLabel  = new JLabel("Please Insert Card");
		cardButton = new JButton("Browse Card");
		passwordLabel = new JLabel("Enter Pin:");	
		passwordField = new JPasswordField(4);
		transactionLabel = new JLabel("Please select a transaction.");
		withdrawButton = new JButton("Withdraw");
		depositButton = new JButton("Deposit");
		chgPinButton = new JButton("Change Pin");
		infoButton = new JButton("View Account Information");
		exitButton = new JButton("Exit");
	}
	public void gui()
	{
		mainPanel.setLayout(cLayout);
		mainPanel.add(welcomePanel , "1");
		mainPanel.add(passwordPanel, "2");
		mainPanel.add(transactionPanel, "3");
		
		this.welcomeMenu();
		this.passwordMenu();
		this.transactionMenu();
		
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
		
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.weighty = 50;
		gbc.gridx = 0;
		gbc.gridy = 1;
		passwordPanel.add(passwordField , gbc);
		
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
		
	}
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();
		if(event.getSource() == cardButton){	    
			Scanner in = null;
			JFileChooser chooser = new JFileChooser();
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				File selectedFile = chooser.getSelectedFile();
				try {
					in = new Scanner(selectedFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if(in.hasNextLine()){
					cardPin = in.nextLine();
					card.setPin(Integer.parseInt(cardPin), selectedFile);
				} //yes it writes it to itself, I'm being lazy
				cLayout.show(mainPanel , "2");		
			}			

		}
		else if(event.getSource() == exitButton){
			setVisible(false); 
			dispose();
		}
		if(OK.equals(command)){
//--------------------This part does not belong here.-----------------------------//	
			String userPin = new String(passwordField.getPassword());
			if(userPin.equals(cardPin)){
				System.out.println("Password Correct!");
				cLayout.show(mainPanel, "3");
			}else{
				System.out.println("Password Incorrect!");
				passwordField.selectAll();
			}
//------------------------------------------------------------------------------------------//			
		}
	}
}