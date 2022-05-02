package fin.model;

public class Card
{
	/**
	 * The name of the card that matches the name of it's corresponding image.
	 */
	private String name;
	
	/**
	 * The pip value of the card.
	 */
	private int value;
	
	private String path;
	
	/**
	 * Creates a Card instance with the supplied name and value.
	 * @param name
	 * @param value
	 */
	public Card(String name, int value, String path)
	{
		this.name = name;
		this.value = value;
		setPath("/fin/view/images/");
	}
	
	/**
	 * Supplies the name of the Card.
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Supplies the pip value of the Card.
	 * @return
	 */
	public int getValue()
	{
		return this.value;
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	/**
	 * Updates the name to the provided String.
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Updates the value to the provided integer.
	 * @param value
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public void setPath(String path)
	{
		this.path = path;
	}
	
	/**
	 * Provides a String representation of the Card.
	 */
	@Override
	public String toString()
	{
		String description = "Card Name: " + name + ", Card Value: " + value;
		
		return description;
	}
	
	
}
