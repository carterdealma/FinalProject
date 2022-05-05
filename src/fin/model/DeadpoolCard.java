package fin.model;

/**
 * Subclass of the Card class. Used as a themed card.
 * @author Carter Ma
 */
public class DeadpoolCard extends Card
{
	/**
	 * Creates a DeadpoolCard instance with the supplied name and value.
	 * @param name
	 * @param value
	 */
	public DeadpoolCard(String name, int value, String path)
	{
		super(name, value, path);
	}
	
	/**
	 * Supplies the path of the card.
	 */
	@Override
	public String getPath()
	{
		return "/fin/view/deadpool/";
	}
}
