package fin.model;

public class Card
{
	/**
	 * The name of the card that matches the name of it's image in fin.view.images.
	 */
	private String name;
	
	/**
	 * The pip value of the card.
	 */
	private int value;
	
	/**
	 * Creates a Card instance with the supplied name and value
	 * @param name
	 * @param value
	 */
	public Card(String name, int value)
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
