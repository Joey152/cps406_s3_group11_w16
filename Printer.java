import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Printer {
	
	private Transations transactions;
	
	public Printer(Transactions t) {
		transactions = t;
	}
	
	public void printReceipt() throws IOException {
		
		int account = transactions.getAccount();
		int[] type = transactions.getTransactionType();
		int[] dates = transactions.getTransactionDate();
		int[] balance = transactions.getTransactionBalance();
		int[] amount = transactions.getTransactionBalance();
		
		String fileName = "Receipt - " + account + ".txt";
		PrintWriter pw = new PrintWriter(new FileWriter(filename));
		
		pw.write("wow");
		
		pw.close();
	}
	
	public void printTransactionHistory() {
		
	}
}
