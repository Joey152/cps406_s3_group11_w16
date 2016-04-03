
public class ChequingAccount extends BankAccount{

	private int chequingBalance;

	public ChequingAccount(int cardNum, int pin, int month, int year, String name)
	{
		super (cardNum, pin, month, year, name);
	}
	public int getChequingBalance()
	{
		return chequingBalance;		
	}
	public void setChequingBalance(int newBal)
	{
		this.chequingBalance = newBal;
	}
}
