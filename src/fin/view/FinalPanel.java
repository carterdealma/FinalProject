package fin.view;

import fin.controller.FinalController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FinalPanel extends JPanel
{
	private FinalController controller;
	
	private JPanel cardPanel;
	private JPanel housePanel;
	private JPanel playerPanel;
	private JPanel buttonPanel;
	private JPanel scorePanel;
	private SpringLayout layout;
	private JLabel houseImageLabel1;
	private JLabel houseImageLabel2;
	private JLabel playerImageLabel1;
	private JLabel playerImageLabel2;
	private ImageIcon playerCard1;
	private ImageIcon playerCard2;
	private ImageIcon houseCard1;
	private ImageIcon houseCard2;
	private JButton hitButton;
	private JTextArea scoreText;
	private int score;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.layout = new SpringLayout();
		this.cardPanel = new JPanel(new GridLayout (0,1));
		this.housePanel = new JPanel();
		housePanel.setBackground(new Color(0, 153, 0));
		this.playerPanel = new JPanel();
		playerPanel.setBackground(new Color(0, 153, 0));
		this.buttonPanel = new JPanel(new GridLayout (0,1));
		this.scorePanel = new JPanel(new GridLayout(0,1));
		this.hitButton = new JButton("Hit");
		this.scoreText = new JTextArea("Score: ");
		this.score = 0;
		this.playerImageLabel1 = new JLabel();
		this.playerImageLabel2 = new JLabel();
		this.houseImageLabel1 = new JLabel();
		this.houseImageLabel2 = new JLabel();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void setupPanel()
	{
		this.setLayout(layout);
		Color prettyPink = new Color(255, 204, 255);
		this.setBackground(Color.DARK_GRAY);
		this.add(cardPanel);
		cardPanel.add(housePanel);
		housePanel.setLayout(new BoxLayout(housePanel, BoxLayout.X_AXIS));
		housePanel.add(houseImageLabel1);
		housePanel.add(houseImageLabel2);
		cardPanel.add(playerPanel);
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.X_AXIS));
		playerPanel.add(playerImageLabel1);
		playerPanel.add(playerImageLabel2);
		this.add(buttonPanel);
		this.add(scorePanel);
		
		/*
		 * Player receives their first card
		 */
		playerCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerImageLabel1.setIcon(playerCard1);
		score += controller.sendValue();
		if (controller.sendName().charAt(0) == "A".charAt(0))
		{
			scoreText.setText("Score: " + String.valueOf(score + " or " + String.valueOf(score + 10)));
		}
		else
		{
			scoreText.setText("Score: " + String.valueOf(score));
		}
		controller.cardPlayed();
		
		/*
		 * House receives their first card
		 */
		houseCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseImageLabel1.setIcon(houseCard1);
		controller.cardPlayed();
		
		/*
		 * Player receives their second card
		 */
		playerCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerImageLabel2.setIcon(playerCard2);
		score += controller.sendValue();
		if (controller.sendName().charAt(0) == "A".charAt(0))
		{
			scoreText.setText("Score: " + String.valueOf(score + " or " + String.valueOf(score + 10)));
		}
		else
		{
			scoreText.setText("Score: " + String.valueOf(score));
		}
		controller.cardPlayed();
		
		/*
		 * House receives their first card
		 */
		houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		controller.cardPlayed();
		
		
		buttonPanel.add(hitButton);
		
		
		scorePanel.add(scoreText);
		scoreText.setEditable(false);
	}
	
	public void setupListeners()
	{
		hitButton.addActionListener(click -> controller.cardPlayed());
	}
	
	public void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, cardPanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cardPanel, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, cardPanel, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, cardPanel, -150, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 30, SpringLayout.EAST, cardPanel);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, 0, SpringLayout.SOUTH, cardPanel);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -30, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, scorePanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scorePanel, 0, SpringLayout.WEST, buttonPanel);
		layout.putConstraint(SpringLayout.SOUTH, scorePanel, 0, SpringLayout.NORTH, buttonPanel);
		layout.putConstraint(SpringLayout.EAST, scorePanel, 0, SpringLayout.EAST, buttonPanel);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 100, SpringLayout.NORTH, this);
	}
}
