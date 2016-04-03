import java.util.Calendar;

public class CardManager{
	int account;
	Card card;
	int newPin;
	boolean validated = false;
	
	public CardManager(Card c)
	{
		this.card = c;
	}
	
	public boolean validatePin(int pin)
	{
		if(pin == card.getPin())
			return true;
		return false;
	}
	
	public boolean setPin(int oldPin, int newPin, int newPin2)
	{
		if(oldPin != card.getPin())
		{
			return false;
		}
		if(newPin != newPin2)
		{
			return false;
		}
		card.setPin(newPin);
		return true;
	}
	
	public boolean checkExpirationDate()
	{
		if(Calendar.getInstance().compareTo(card.getExpirationDate())!=0)
			return true;
		else
			return false;
	}
}
