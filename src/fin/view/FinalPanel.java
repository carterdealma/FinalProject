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
	private JLabel houseImageLabel1;
	private JLabel houseImageLabel2;
	private JLabel playerImageLabel1;
	private JLabel playerImageLabel2;
	private ImageIcon playerCard1;
	private ImageIcon playerCard2;
	private ImageIcon houseCard1;
	private ImageIcon houseCard2;
	private JButton startButton;
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
		this.startButton = new JButton("Start");
		this.hitButton = new JButton("Hit");
		this.playerImageLabel1 = new JLabel();
		this.houseImageLabel1 = new JLabel();
		
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
		cardPanel.add(houseImageLabel1);
		cardPanel.add(playerImageLabel1);
		houseImageLabel1.setIcon(houseCard1);
		
		this.add(buttonPanel);
		buttonPanel.add(startButton);
		buttonPanel.add(hitButton);
	}
	
	public void setupListeners()
	{
		startButton.addActionListener(click -> playerImageLabel1.setIcon(playerCard1));
		startButton.addActionListener(click -> houseImageLabel1.setIcon(houseCard1));
		startButton.addActionListener(click -> houseCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png")));
		startButton.addActionListener(click -> controller.cardPlayed());
		startButton.addActionListener(click -> playerCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png")));
		startButton.addActionListener(click -> controller.cardPlayed());
		startButton.addActionListener(click -> startButton.setEnabled(false));
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
