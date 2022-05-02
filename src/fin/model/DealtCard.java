package fin.model;

import javax.swing.*;

public class DealtCard
{
	private JLabel image;
	private ImageIcon imageIcon;
	private int value;
	private String name;
	
	public DealtCard(String name, int value)
	{
		this.value = value;
		this.name = name;
	}
	
	public JLabel getImage()
	{
		return this.image;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setImage(String path, String fileName)
	{
		this.image = new JLabel();
		this.imageIcon = new ImageIcon(getClass().getResource(path + fileName + ".png"));
		this.image.setIcon(imageIcon);
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

}
