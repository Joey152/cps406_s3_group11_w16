import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Printer {
	
	private Transations transactions;
	private int account;
	private String name;
	private int[] type;
	private int[] dates;
	private int[] balance;
	private int[] amount;
	
	public Printer(Transactions t) {
		transactions = t;
		account = transactions.getAccount();
		name = transactions.getName();
		type = transactions.getTransactionType();
		dates = transactions.getTransactionDate();
		balance = transactions.getTransactionBalance();
		amount = transactions.getTransactionBalance();
	}
	
	public void printReceipt() throws IOException {
		String fileName = "Receipt - " + account + ".txt";
		PrintWriter pw = new PrintWriter(new FileWriter(filename));
		
		pw.println("Receipt");
		pw.println("Name:\t" + name);
		pw.println("Card Number:\t" + account);
		pw.println("Date:\t" + date[0]);
		pw.println();
		for(int i = 0; i < type.length; i++) {
			String t;
			switch(type[i]) {
			case 1:
				t = "Deposit";
				break;
			case 2:
				t = "Withdraw"
				break;
			case 3:
				t = "Donate"
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
		Scanner sc = new Scanner(account + ".txt");
		String history;
		history += sc.nextLine();
		return history;
	}
}