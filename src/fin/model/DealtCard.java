package fin.model;

import javax.swing.*;

/**
 * The class used to recreate cards that have been dealt to either the player or the house.
 * @author Carter Ma
 */
public class DealtCard
{
	/**
	 * The image label used to display the image of the card.
	 */
	private JLabel image;
	
	/**
	 * The image of the card.
	 */
	private ImageIcon imageIcon;
	
	/**
	 * The value of the card.
	 */
	private int value;
	
	/**
	 * The name of the card.
	 */
	private String name;
	
	/**
	 * Creates a DealtCard instance with the supplied name and value.
	 * @param name
	 * @param value
	 */
	public DealtCard(String name, int value)
	{
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Supplies the image of the card.
	 * @return
	 */
	public JLabel getImage()
	{
		return this.image;
	}
	
	/**
	 * Supplies the value of the card.
	 * @return
	 */
	public int getValue()
	{
		return this.value;
	}
	
	/**
	 * Supplies the name of the card.
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the image of the card using the supplied path and file name.
	 * @param path
	 * @param fileName
	 */
	public void setImage(String path, String fileName)
	{
		this.image = new JLabel();
		this.imageIcon = new ImageIcon(getClass().getResource(path + fileName + ".png"));
		this.image.setIcon(imageIcon);
	}
	
	/**
	 * Updates the value to the provided value.
	 * @param value
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	
	/**
	 * Updates the name to the provided name.
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

}
