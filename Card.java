import java.util.Calendar;

public class Card {
	int cardNumber;
	int pin;
	Calendar expirationDate = Calendar.getInstance();
	String cardName;
	
	public Card(int cardNum, int pin, int month, int year)
	{                            
		expirationDate.set(year,month-1,1,0,0,0);                       //sets the expiration date
		this.cardNumber = cardNum;
		this.pin = pin;
	}
	
	public void setCardNumber(int num)
	{
		cardNumber = num;
	}
	
	public int getCardNumber()
	{
		return cardNumber;
	}
	
	public void setPin(int pin)
	{
		this.pin = pin;
	}
	
	public int getPin()
	{
		return pin;
	}
	
	public void setExpirationDate(int month, int year)
	{
		expirationDate.set(year, month-1, 1);
	}
	
	public Calendar getExpirationDate()
	{
		return expirationDate;
	}
	
	public void setCardName(String name)
	{
		cardName = name;
	}
	
	public String getCardName()
	{
		return cardName;
	}
}
