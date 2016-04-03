import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Transactions {
	private BankAccount account;
	private ArrayList<Integer> transactionType;
	private ArrayList<String> transactionDates;
	private ArrayList<Integer> transactionBalance;
	private ArrayList<Integer> transactionAmount;
	private PrintWriter pw;
	
	public Transactions(BankAccount account) throws IOException {
		String fileName;
		
		this.account = account;
		transactionType = new ArrayList<>();
		transactionDates = new ArrayList<>();
		transactionBalance = new ArrayList<>();
		transactionAmount = new ArrayList<>();
		fileName = account.getAccountNumber() + ".txt";
		pw = new PrintWriter(new FileWriter(fileName));
	}
	
	/**
	 * 
	 * @param amount
	 * @return 0 is success
	 * @return 1 is not enough money in account
	 * @return 2 is over/under the withdraw max/min
	 * @throws IOException 
	 */
	public int withdraw(int amount) {
		int newBalance = account.getAccountBalance() - amount;
		if(newBalance < 0) {
			return 1;
		}
		if(amount < account.getMinWithdraw() && amount > account.getMaxWithdraw()) {
			return 2;
		}		
		
		account.setAccountBalance(newBalance);
		transactionType.add(1);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateobj = new Date();
		transactionDates.add(df.format(dateobj));
		transactionBalance.add(newBalance);
		transactionAmount.add(amount);
		
		pw.println("Date: " + df.format(dateobj));
		pw.println("Withdraw: $" + amount);
		pw.println("Balance: $" + newBalance);
		pw.println();
		return 0;
	}
	
	public int deposit(int amount) {
		int newBalance = account.getAccountBalance() + amount;
		account.setAccountBalance(newBalance);
		transactionType.add(1);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateobj = new Date();
		transactionDates.add(df.format(dateobj));
		transactionBalance.add(newBalance);
		transactionAmount.add(amount);
		
		pw.println("Date: " + df.format(dateobj));
		pw.println("Deposit: $" + amount);
		pw.println("Balance: $" + newBalance);
		pw.println();
		return 0;
	}
	
	/**
	 * Always donate $1, money is not another account yet
	 * @param amount
	 * @return 0 is success
	 * @return 1 is not enough money in account 
	 */
	public int donate(int amount) {
		int newBalance = account.getAccountBalance() - 1;
		if(newBalance < 0) {
			return 1;
		}
		account.setAccountBalance(newBalance);
		transactionType.add(2);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateobj = new Date();
		transactionDates.add(df.format(dateobj));
		transactionBalance.add(newBalance);
		transactionAmount.add(amount);
		
		pw.println("Date: " + df.format(dateobj));
		pw.println("Donate: $" + amount);
		pw.println("Balance: $" + newBalance);
		pw.println();
		return 0;
	}
	
	public BankAccount getAccount() {
		return account;
	}
	
	public ArrayList<Integer> getTransactionType() {
		return transactionType;
	}
	
	public ArrayList<String> getTransactionDate() {
		return transactionDates;
	}
	
	public ArrayList<Integer> getTransactionBalance() {
		return transactionBalance;
	}
	
	public ArrayList<Integer> getTransactionAmount() {
		return transactionAmount;
	}
}
