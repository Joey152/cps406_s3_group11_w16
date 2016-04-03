
public class BankAccount {
	private int accountNumber;
	private int pin;
	private boolean allowAccess = false;
	private int pinTries = 5;
	private String name;
	private int maxWithdraw;
	private int minWithdraw;
	private boolean cardStatus;
	private Card c;
	private CardManager cm;
	private int balance;
		
	public BankAccount(int cardNum, int pin, int month, int year, String name)
	{
		c = new Card(cardNum, pin, month, year);
		cm = new CardManager(c);
		this.name = name;
		minWithdraw = 20;
		maxWithdraw = 100;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void suspendCard()
	{
		// TBD
	}
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public int getAccountBalance()
	{
		return balance;		
	}
	
	public void setAccountBalance(int newBal)
	{
		this.balance = newBal;
	}
	
	public int getMinWithdraw()
	{
		return this.minWithdraw;
	}
	
	public int getMaxWithdraw()
	{
		return this.maxWithdraw;
	}
}
