package fin.view;

import fin.controller.FinalController;

import java.awt.*;
import javax.swing.*;

public class FinalPanel extends JPanel
{
	private FinalController controller;
	
	private JPanel cardPanel;
	private JPanel buttonPanel;
	private SpringLayout layout;
	private JLabel houseImageLabel;
	private JLabel playerImageLabel;
	private ImageIcon playerFirstCard;
	private ImageIcon houseFirstCard;
	private JButton hitButton;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.layout = new SpringLayout();
		this.cardPanel = new JPanel(new GridLayout (0,1));
		this.buttonPanel = new JPanel(new GridLayout (0,1));
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 30, SpringLayout.EAST, cardPanel);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, 0, SpringLayout.SOUTH, cardPanel);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -30, SpringLayout.EAST, this);
		this.hitButton = new JButton("Hit");
		this.playerFirstCard = new ImageIcon(getClass().getResource("/fin/view/images/" + "7H" + ".png"));
		this.houseFirstCard = new ImageIcon(getClass().getResource("/fin/view/images/" + "8H" + ".png"));
		this.houseImageLabel = new JLabel();
		this.playerImageLabel = new JLabel();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void setupPanel()
	{
		this.setLayout(layout);
		Color prettyPink = new Color(255, 204, 255);
		this.setBackground(prettyPink);
		
		this.add(cardPanel);
		cardPanel.add(houseImageLabel);
		cardPanel.add(playerImageLabel);
		houseImageLabel.setIcon(houseFirstCard);
		
		this.add(buttonPanel);
		buttonPanel.add(hitButton);
	}
	
	public void setupListeners()
	{
		hitButton.addActionListener(click -> playerImageLabel.setIcon(playerFirstCard));
		hitButton.addActionListener(click -> controller.cardPlayed());
	}
	
	public void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, cardPanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cardPanel, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, cardPanel, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, cardPanel, -150, SpringLayout.EAST, this);
	}
}
