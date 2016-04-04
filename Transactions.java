import java.io.File;
import java.io.FileOutputStream;
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
	
	public Transactions(BankAccount account){
		this.account = account;
		transactionType = new ArrayList<>();
		transactionDates = new ArrayList<>();
		transactionBalance = new ArrayList<>();
		transactionAmount = new ArrayList<>();
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
		PrintWriter pw = null;
		String fileName = account.getAccountNumber() + ".txt";
		try {			
			pw = new PrintWriter(new FileOutputStream(new File(fileName)), true);
		} catch (IOException e) {
			System.out.println("Error: Printing File Not Found");
		}
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
		
		pw.append("Date: " + df.format(dateobj) + "<br>");
		pw.append("Withdraw: $" + amount + "<br>");
		pw.append("Balance: $" + newBalance + "<br>\n");
		pw.close();
		return 0;
	}
	
	public int deposit(int amount) {
		PrintWriter pw = null;
		String fileName = account.getAccountNumber() + ".txt";
		try {			
			pw = new PrintWriter(new FileOutputStream(new File(fileName)), true);
		} catch (IOException e) {
			System.out.println("Error: Printing File Not Found");
		}
		int newBalance = account.getAccountBalance() + amount;
		account.setAccountBalance(newBalance);
		transactionType.add(1);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date dateobj = new Date();
		transactionDates.add(df.format(dateobj));
		transactionBalance.add(newBalance);
		transactionAmount.add(amount);
		
		pw.append("Date: " + df.format(dateobj) + "<br><br>");
		pw.append("Deposit: $" + amount + "<br><br>");
		pw.append("Balance: $" + newBalance + "<br>\n");
		pw.close();
		return 0;
	}
	
	/**
	 * Always donate $1, money is not another account yet
	 * @param amount
	 * @return 0 is success
	 * @return 1 is not enough money in account 
	 */
	public int donate(int amount) {
		PrintWriter pw = null;
		String fileName = account.getAccountNumber() + ".txt";
		try {			
			pw = new PrintWriter(new FileOutputStream(new File(fileName)), true);
		} catch (IOException e) {
			System.out.println("Error: Printing File Not Found");
		}
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
		
		pw.append("Date: " + df.format(dateobj) + "<br><br>");
		pw.append("Donate: $" + amount + "<br><br>");
		pw.append("Balance: $" + newBalance + "<br>\n");
		pw.close();
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