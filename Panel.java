package cps406;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.Dimension;
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
	
	public static final String OK = "OK";
	
	public Panel() 
	{
		frame = new JFrame();
		
		mainPanel = new JPanel();
		welcomePanel = new JPanel();
		passwordPanel = new JPanel();
		transactionPanel = new JPanel();
		
		cLayout = new CardLayout();
		mainPanel.setLayout(cLayout);
		mainPanel.add(welcomePanel , "1");
		mainPanel.add(passwordPanel, "2");
		mainPanel.add(transactionPanel, "3");
		
		
		welcomePanel.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		welcomeLabel = new JLabel("Welcome!");
		welcomeLabel.setFont(new Font("Calibri" , Font.BOLD , 40));
		gbc.weighty = 10;
		gbc.anchor = GridBagConstraints.CENTER; 
		gbc.gridx = 0;
		gbc.gridy = 0;
		welcomePanel.add(welcomeLabel , gbc);
		
		insertCardLabel  = new JLabel("Please Insert Card");
		insertCardLabel.setFont(new Font("Calibri" , Font.BOLD , 30));
		gbc.weighty = 10;
	    gbc.anchor = GridBagConstraints.PAGE_END; 
		gbc.gridx = 0;
		gbc.gridy = 1;
		welcomePanel.add(insertCardLabel , gbc);
		
		cardButton = new JButton("Browse Card");
		cardButton.addActionListener(this);
		
		gbc.weighty = 20;
	    gbc.anchor = GridBagConstraints.PAGE_START; 
		gbc.gridx = 0;
		gbc.gridy = 2;
		welcomePanel.add(cardButton , gbc);
		
		
		passwordPanel.setLayout(new GridBagLayout());
		
		passwordLabel = new JLabel("Enter Pin:");
		passwordLabel.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.weighty = 50;
		gbc.anchor = GridBagConstraints.PAGE_END;
		gbc.gridx = 0;
		gbc.gridy = 0;
		passwordPanel.add(passwordLabel, gbc);
		
		passwordField = new JPasswordField(4);
		passwordField.setActionCommand(OK);
		passwordField.addActionListener(this);
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("calibri" , Font.BOLD , 30));
		gbc.weighty = 50;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 1;
		passwordPanel.add(passwordField , gbc);
		
		gbc.weighty = 0;
		
		transactionPanel.setLayout(new GridBagLayout());

		transactionLabel = new JLabel("Please select a transaction.");
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
		
		
		withdrawButton = new JButton("Withdraw");
		gbc.gridx = 0 ;
		gbc.gridy = 1;
		transactionPanel.add(withdrawButton , gbc);
		
		depositButton = new JButton("Deposit");
		gbc.gridx = 0 ;
		gbc.gridy = 2;
		transactionPanel.add(depositButton , gbc);
		
		chgPinButton = new JButton("Change Pin");
		gbc.gridx = 0;
		gbc.gridy = 3;
		transactionPanel.add(chgPinButton, gbc);
		
		infoButton = new JButton("View Account Information");
		gbc.gridx = 0 ;
		gbc.gridy = 4;
		transactionPanel.add(infoButton , gbc);
		
		gbc.fill = GridBagConstraints.NONE;
		exitButton = new JButton("Exit");
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.ipady = 20;
		gbc.ipadx = 20;
		gbc.insets = new Insets(20 , 0 , 0 , 0);
		transactionPanel.add(exitButton, gbc);
		
		add(mainPanel);
		setSize(FRAME_WIDTH , FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent event)
	{
		String command = event.getActionCommand();
		if(event.getSource() == cardButton){
			Scanner in;
			in = null;
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
				}
				cLayout.show(mainPanel , "2");
			}
		}
		
		if(OK.equals(command)){
			String userPin = new String(passwordField.getPassword());
			if(userPin.equals(cardPin)){
				System.out.println("Password Correct!");
				cLayout.show(mainPanel, "3");
			}else{
				System.out.println("Password Incorrect!");
				passwordField.selectAll();
			}
		}
		
	}
}
