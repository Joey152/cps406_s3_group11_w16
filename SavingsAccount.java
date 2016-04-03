
public class SavingsAccount extends BankAccount{

	private int savingsBalance;

	public SavingsAccount(int cardNum, int pin, int month, int year, String name)
	{
		super (cardNum, pin, month, year, name);
	}
	public int getChequingBalance()
	{
		return savingsBalance;		
	}
	public void setChequingBalance(int newBal)
	{
		this.savingsBalance = newBal;
	}
}
