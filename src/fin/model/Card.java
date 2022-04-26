package fin.model;

public class Card
{
	private int value;
	private String suit;
	
	public Card(String name, int value, String suit)
	{
		this.value = value;
		this.suit = suit;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public void setValue()
	{
		this.value = value;
	}
	
	public void setSuit()
	{
		this.suit = suit;
	}
	
	@Override
	public String toString()
	{
		String description = "Card Value: " + value + ", Card Suit:" + suit;
		
		return description;
	}
	
	
}
