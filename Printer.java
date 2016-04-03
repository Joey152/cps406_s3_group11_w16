import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Printer {
	
	private Transactions transactions;
	private BankAccount account;
	private String name;
	private int[] type;
	private String[] date;
	private int[] balance;
	private int[] amount;

	
	public Printer(Transactions t) {
		transactions = t;
		account = transactions.getAccount();
		name = account.getName();
		type = transactions.getTransactionType();
		date = transactions.getTransactionDate();
		balance = transactions.getTransactionBalance();
		amount = transactions.getTransactionBalance();
	}
	
	public void printReceipt() throws IOException {
		String fileName = "Receipt - " + account.getAccountNumber() + ".txt";
		PrintWriter pw = new PrintWriter(new FileWriter(fileName));
		
		pw.println("Receipt");
		pw.println("Name:\t" + name);
		pw.println("Card Number:\t" + account.getAccountNumber());
		pw.println("Date:\t" + date[0]);
		pw.println();
		for(int i = 0; i < type.length; i++) {
			String t = "";
			switch(type[i]) {
			case 1:
				t = "Deposit";
				break;
			case 2:
				t = "Withdraw";
				break;
			case 3:
				t = "Donate";
				break;
			}
			pw.println("Transaction:\t" + t);
			pw.println("Amount:\t" + amount[i]);
			pw.println("Balance:\t" + balance[i]);
			pw.println();
		}
		pw.close();
	}
	
	public String printTransactionHistory() {
		Scanner sc = new Scanner(account.getAccountNumber() + ".txt");
		String history = "";
		history = history + sc.nextLine() + " ";
		sc.close();
		return history;
	}
}