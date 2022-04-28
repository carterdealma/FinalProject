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
	private JLabel houseImageLabel3;
	private JLabel playerImageLabel1;
	private JLabel playerImageLabel2;
	private JLabel playerImageLabel3;
	private ImageIcon playerCard1;
	private String playerCard1Name;
	private ImageIcon playerCard2;
	private String playerCard2Name;
	private ImageIcon playerCard3;
	private String playerCard3Name;
	private ImageIcon houseCard1;
	private String houseCard1Name;
	private ImageIcon houseCard2;
	private String houseCard2Name;
	private ImageIcon houseCard3;
	private String houseCard3Name;
	private JButton doubleButton;
	private JButton hitButton;
	private JButton standButton;
	private JTextArea houseScoreText;
	private JTextArea playerScoreText;
	private int playerScore;
	private int houseScore;
	private int turnNumber;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.layout = new SpringLayout();
		this.cardPanel = new JPanel(new GridLayout (0,1));
		layout.putConstraint(SpringLayout.EAST, cardPanel, -180, SpringLayout.EAST, this);
		this.housePanel = new JPanel();
		housePanel.setBackground(new Color(0, 153, 0));
		this.playerPanel = new JPanel();
		playerPanel.setBackground(new Color(0, 153, 0));
		this.buttonPanel = new JPanel(new GridLayout (0,1));
		this.scorePanel = new JPanel(new GridLayout(0,1));
		this.doubleButton = new JButton("Double");
		this.hitButton = new JButton("Hit");
		this.standButton = new JButton("Stand");
		this.houseScoreText = new JTextArea("House Score: ");
		this.playerScoreText = new JTextArea("Your Score: ");
		this.playerScore = 0;
		this.houseScore = 0;
		this.turnNumber = 0;
		this.playerImageLabel1 = new JLabel();
		this.playerImageLabel2 = new JLabel();
		this.playerImageLabel3 = new JLabel();
		this.houseImageLabel1 = new JLabel();
		this.houseImageLabel2 = new JLabel();
		this.houseImageLabel3 = new JLabel();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.DARK_GRAY);
		this.add(cardPanel);
		cardPanel.add(housePanel);
		housePanel.add(houseImageLabel1);
		housePanel.add(houseImageLabel2);
		housePanel.add(houseImageLabel3);
		cardPanel.add(playerPanel);
		playerPanel.add(playerImageLabel1);
		playerPanel.add(playerImageLabel2);
		playerPanel.add(playerImageLabel3);
		this.add(buttonPanel);
		this.add(scorePanel);
		
		/*
		 * Player receives their first card
		 */
		playerCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerImageLabel1.setIcon(playerCard1);
		playerCard1Name = String.valueOf(controller.sendName());
		playerScore += controller.sendValue();
		if (playerCard1Name.charAt(0) == "A".charAt(0))
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		controller.cardPlayed();
		
		/*
		 * House receives their first card
		 */
		houseCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseImageLabel1.setIcon(houseCard1);
		houseCard1Name = String.valueOf(controller.sendName());
		houseScore += controller.sendValue();
		if (houseCard1Name.charAt(0) == "A".charAt(0))
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore + " or " + String.valueOf(houseScore + 10)));
		}
		else
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
		}
		controller.cardPlayed();
		
		/*
		 * Player receives their second card
		 */
		playerCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerImageLabel2.setIcon(playerCard2);
		playerCard2Name = String.valueOf(controller.sendName());
		playerScore += controller.sendValue();
		if (playerCard2Name.charAt(0) == "A".charAt(0) && playerCard1Name.charAt(0) == "A".charAt(0))
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 20)));
		}
		else if (playerCard2Name.charAt(0) == "A".charAt(0))
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		controller.cardPlayed();
		
		/*
		 * House receives their second card
		 */
		houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + "red_back" + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		
		buttonPanel.add(doubleButton);
		buttonPanel.add(hitButton);
		buttonPanel.add(standButton);
		
		scorePanel.add(houseScoreText);
		scorePanel.add(playerScoreText);
		houseScoreText.setEditable(false);
	}
	
	public void setupListeners()
	{
		hitButton.addActionListener(click -> turnOneHit());
	}
	
	public void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, cardPanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cardPanel, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, cardPanel, 30, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, buttonPanel, 30, SpringLayout.EAST, cardPanel);
		layout.putConstraint(SpringLayout.SOUTH, buttonPanel, 0, SpringLayout.SOUTH, cardPanel);
		layout.putConstraint(SpringLayout.EAST, buttonPanel, -30, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, scorePanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scorePanel, 0, SpringLayout.WEST, buttonPanel);
		layout.putConstraint(SpringLayout.SOUTH, scorePanel, 0, SpringLayout.NORTH, buttonPanel);
		layout.putConstraint(SpringLayout.EAST, scorePanel, 0, SpringLayout.EAST, buttonPanel);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 100, SpringLayout.NORTH, this);
		housePanel.setLayout(new BoxLayout(housePanel, BoxLayout.X_AXIS));
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.X_AXIS));
	}
	
	public void turnOneHit()
	{
		playerCard3 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerImageLabel3.setIcon(playerCard3);
		playerCard3Name = String.valueOf(controller.sendName());
		playerScore += controller.sendValue();
		if (playerCard3Name.charAt(0) == "A".charAt(0) && playerCard2Name.charAt(0) == "A".charAt(0) && playerCard1Name.charAt(0) == "A".charAt(0))
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 30)));
		}
		else if (playerCard3Name.charAt(0) == "A".charAt(0) && playerCard2Name.charAt(0) == "A".charAt(0) || playerCard2Name.charAt(0) == "A".charAt(0) && playerCard1Name.charAt(0) == "A".charAt(0))
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 20)));
		}
		else if (playerCard3Name.charAt(0) == "A".charAt(0) || playerCard2Name.charAt(0) == "A".charAt(0) || playerCard1Name.charAt(0) == "A".charAt(0))
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		controller.cardPlayed();
	}
}
