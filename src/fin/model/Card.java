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
	
	private String getName()
	{
		return this.name;
	}
	
	private int getValue()
	{
		return this.value;
	}
	
	private String getSuit()
	{
		return this.suit;
	}
}
