
public class Transactions {
	private BankAccount account;
	private int[] transactionType;
	private String[] transactionDates;
	private int[] transactionBalance;
	private int[] transactionAmount;
	
	public Transactions(BankAccount account) {
		this.account = account;
	}
	
	public int withdraw(int amount) {
		if(amount < account.minWithdraw && amount > account.maxWithdraw) {
			return 1;
		}
		else if(true) {
			
		}
		return 0;
	}
	
	public int deposit(int amount) {
		return 0;
	}
	
	public int donate(int amount) {
		return 0;
	}
	
	public BankAccount getAccount() {
		return account;
	}
	
	public int[] getTransactionType() {
		return transactionType;
	}
	
	public String[] getTransactionDate() {
		return transactionDates;
	}
	
	public int[] getTransactionBalance() {
		return transactionBalance;
	}
	
	public int[] getTransactionAmount() {
		return transactionAmount;
	}
}
