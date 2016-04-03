
public class BankAccount {
	int accountNumber;
	int pin;
	boolean allowAccess = false;
	int pinTries = 5;
	String name;
	int maxWithdraw;
	int minWithdraw;
	boolean cardStatus;
	Card c;
	CardManager cm;
	
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
}
