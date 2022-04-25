package fin.view;

import fin.controller.FinalController;

import java.awt.*;
import javax.swing.*;

public class FinalPanel extends JPanel
{
	private FinalController controller;
	
	private JPanel cardPanel;
	private SpringLayout layout;
	private JLabel houseImageLabel;
	private JLabel playerImageLabel;
	private ImageIcon playerFirstCard;
	private ImageIcon houseFirstCard;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.layout = new SpringLayout();
		this.cardPanel = new JPanel(new GridLayout (0,1));
		this.playerFirstCard = new ImageIcon();
		this.houseFirstCard = new ImageIcon();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void setupPanel()
	{
		Color prettyPink = new Color(255, 204, 255);
		this.setBackground(prettyPink);
		this.setLayout(layout);
		this.add(cardPanel);
	}
	
	public void setupListeners()
	{
		
	}
	
	public void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, cardPanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, cardPanel, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, cardPanel, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, cardPanel, -30, SpringLayout.EAST, this);
	}
}
