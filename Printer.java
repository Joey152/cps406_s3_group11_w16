import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Printer {
	
	private Transations transactions;
	
	public Printer(Transactions t) {
		transactions = t;
	}
	
	public void printReceipt() throws IOException {
		
		int account = transactions.account();
		int[] type = transactions.getTransactionType();
		
		PrintWriter pw = new PrintWriter(new FileWriter(""));
	}
	
	public void printTransactionHistory() {
		
	}
}
