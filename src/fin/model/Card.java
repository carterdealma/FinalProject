package fin.model;

public class Card
{
	private String name;
	private int value;
	private String suit;
	
	public Card(String name, int value, String suit)
	{
		this.name = name;
		this.value = value;
		this.suit = suit;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public String getSuit()
	{
		return this.suit;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
	
	@Override
	public String toString()
	{
		String description = "Card Value: " + value + ", Card Suit: " + suit + ", Card Name: " + name;
		
		return description;
	}
	
	
}
