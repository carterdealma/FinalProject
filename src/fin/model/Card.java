package fin.model;

public class Card
{
	private String name;
	private int value;
	
	public Card(String name, int value, String suit)
	{
		this.name = name;
		this.value = value;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	@Override
	public String toString()
	{
		String description = "Card Value: " + value + ", Card Name: " + name;
		
		return description;
	}
	
	
}
