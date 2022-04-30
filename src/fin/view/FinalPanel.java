package fin.view;

import fin.controller.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FinalPanel extends JPanel
{
	private FinalController controller;
	private IOController ioController;
	
	private JPanel startPanel;
	private JPanel cardPanel;
	private JPanel housePanel;
	private JPanel playerPanel;
	private JPanel buttonPanel;
	private JPanel scorePanel;
	private JPanel tempScorePanel;
	private JPanel chipPanel;
	private SpringLayout layout;
	private JLabel houseImageLabel1;
	private JLabel houseImageLabel2;
	private JLabel houseImageLabel3;
	private JLabel houseImageLabel4;
	private JLabel houseImageLabel5;
	private JLabel playerImageLabel1;
	private JLabel playerImageLabel2;
	private JLabel playerImageLabel3;
	private JLabel playerImageLabel4;
	private JLabel playerImageLabel5;
	private ImageIcon faceDownCard;
	private ImageIcon playerCard1;
	private int playerCard1Value;
	private ImageIcon playerCard2;
	private int playerCard2Value;
	private ImageIcon playerCard3;
	private int playerCard3Value;
	private ImageIcon playerCard4;
	private int playerCard4Value;
	private ImageIcon playerCard5;
	private int playerCard5Value;
	private ImageIcon houseCard1;
	private int houseCard1Value;
	private ImageIcon houseCard2;
	private String houseCard2Name;
	private int houseCard2Value;
	private ImageIcon houseCard3;
	private int houseCard3Value;
	private ImageIcon houseCard4;
	private int houseCard4Value;
	private ImageIcon houseCard5;
	private int houseCard5Value;
	private JButton doubleButton;
	private JButton hitButton;
	private JButton standButton;
	private JButton playAgainButton;
	private JButton submitBetButton;
	private JButton exitAndSaveButton;
	private JTextArea houseScoreText;
	private JTextArea playerScoreText;
	private JTextArea chipNumberText;
	private JTextArea betSelectorText;
	private int playerScore;
	private int houseScore;
	private int playerHitNumber;
	private int chipNumber = 1000;
	private String [] chipBetsArray = {"5 Chips", "10 Chips", "25 Chips", "50 Chips", "100 Chips"};
	private JComboBox<Integer> betSelectorBox;
	boolean houseHasBlackjack = false;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		addAllElements();
		setupPanel();
		setupBet();
		firstFourCards();
		setupListeners();
		setupLayout();
	}
	
	public void addAllElements()
	{
		this.layout = new SpringLayout();
		this.startPanel = new JPanel();
		this.cardPanel = new JPanel(new GridLayout (0,1));
		this.housePanel = new JPanel();
		housePanel.setBackground(new Color(0, 153, 0));
		this.playerPanel = new JPanel();
		playerPanel.setBackground(new Color(0, 153, 0));
		this.buttonPanel = new JPanel(new GridLayout (0,1));
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 245, SpringLayout.NORTH, this);
		this.scorePanel = new JPanel(new GridLayout(0,1));
		this.tempScorePanel = new JPanel(new GridLayout(0,1));
		this.chipPanel = new JPanel();
		this.doubleButton = new JButton("Double");
		this.hitButton = new JButton("Hit");
		this.standButton = new JButton("Stand");
		this.submitBetButton = new JButton("Submit Bet");
		this.playAgainButton = new JButton("Play Again?");
		this.exitAndSaveButton = new JButton("Exit and Save?");
		this.houseScoreText = new JTextArea("House Score: ");
		this.playerScoreText = new JTextArea("Your Score: ");
		this.chipNumberText = new JTextArea("Your Chips: " + chipNumber);
		this.playerScore = 0;
		this.houseScore = 0;
		this.playerHitNumber = 0;
		this.betSelectorText = new JTextArea("Select your bet: ");
		this.betSelectorBox = new JComboBox(chipBetsArray);
		this.faceDownCard = new ImageIcon(getClass().getResource("/fin/view/images/" + "red_back" + ".png"));
		this.playerImageLabel1 = new JLabel();
		playerCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerCard1Value = controller.sendValue();
		controller.cardPlayed();
		this.playerImageLabel2 = new JLabel();
		playerCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerCard2Value = controller.sendValue();
		controller.cardPlayed();
		this.playerImageLabel3 = new JLabel();
		playerCard3 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerCard3Value = controller.sendValue();
		controller.cardPlayed();
		this.playerImageLabel4 = new JLabel();
		playerCard4 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerCard4Value = controller.sendValue();
		controller.cardPlayed();
		this.playerImageLabel5 = new JLabel();
		playerCard5 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		playerCard5Value = controller.sendValue();
		controller.cardPlayed();
		this.houseImageLabel1 = new JLabel();
		houseCard1 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseCard1Value = controller.sendValue();
		controller.cardPlayed();
		this.houseImageLabel2 = new JLabel();
		houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseCard2Value = controller.sendValue();
		houseCard2Name = controller.sendName();
		controller.cardPlayed();
		this.houseImageLabel3 = new JLabel();
		houseCard3 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseCard3Value = controller.sendValue();
		controller.cardPlayed();
		this.houseImageLabel4 = new JLabel();
		houseCard4 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseCard4Value = controller.sendValue();
		controller.cardPlayed();
		this.houseImageLabel5 = new JLabel();
		houseCard5 = new ImageIcon(getClass().getResource("/fin/view/images/" + controller.sendName() + ".png"));
		houseCard5Value = controller.sendValue();
		controller.cardPlayed();
	}
	
	public void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.DARK_GRAY);
		this.add(startPanel);
		this.add(cardPanel);
		cardPanel.add(housePanel);
		housePanel.add(houseImageLabel1);
		housePanel.add(houseImageLabel2);
		housePanel.add(houseImageLabel3);
		housePanel.add(houseImageLabel4);
		cardPanel.add(playerPanel);
		playerPanel.add(playerImageLabel1);
		playerPanel.add(playerImageLabel2);
		playerPanel.add(playerImageLabel3);
		playerPanel.add(playerImageLabel4);
		this.add(buttonPanel);
		buttonPanel.add(doubleButton);
		doubleButton.setEnabled(false);
		buttonPanel.add(hitButton);
		hitButton.setEnabled(false);
		buttonPanel.add(standButton);
		standButton.setEnabled(false);
		buttonPanel.add(playAgainButton);
		playAgainButton.setEnabled(false);
		buttonPanel.add(exitAndSaveButton);
		exitAndSaveButton.setEnabled(false);
		this.add(tempScorePanel);
		tempScorePanel.add(scorePanel);
		scorePanel.add(houseScoreText);
		houseScoreText.setEditable(false);
		scorePanel.add(playerScoreText);
		playerScoreText.setEditable(false);
		this.add(chipPanel);
		chipPanel.add(chipNumberText);
		chipNumberText.setEditable(false);
		chipPanel.add(betSelectorText);
		betSelectorText.setEditable(false);
		chipPanel.add(betSelectorBox);
		chipPanel.add(submitBetButton);
		playerPanel.setVisible(false);
		housePanel.setVisible(false);
		scorePanel.setVisible(false);
	}
	
	public void setupListeners()
	{
		System.out.println(playerHitNumber);
		if(houseHasBlackjack == true)
		{
			standButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent mouseClick)
				{
					playerStand();
					standButton.setEnabled(false);
					hitButton.setEnabled(false);
					doubleButton.setEnabled(false);
					houseBlackjack();
				}
			});
		}
		else
		{
			standButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent mouseClick)
				{
					playerStand();
					standButton.setEnabled(false);
					hitButton.setEnabled(false);
					doubleButton.setEnabled(false);
				}
			});
		}
		
		if (playerHitNumber == 0 && houseHasBlackjack == true)
		{
			hitButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent mouseClick)
				{
					playerImageLabel3.setIcon(playerCard3);
					playerScore += playerCard3Value;
					if (playerCard3Value == 1 || playerCard2Value == 1 || playerCard1Value == 1)
					{
						if (playerScore + 10 > houseScore && playerScore + 10 <= 21)
						{
							playerScore = playerScore + 10;
							playerWin();
						}
						else if (playerScore + 10 < 21)
						{
							playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
						}
						else
						{
							playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
						}
						
					}
					else
					{
						playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
					}
					((AbstractButton) mouseClick.getSource()).removeActionListener(this);
					doubleButton.setEnabled(false);
					houseBlackjack();
				}
			});
		}
		else if(playerHitNumber == 0)
		{
		hitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				playerFirstHit();
				((AbstractButton) mouseClick.getSource()).removeActionListener(this);
				doubleButton.setEnabled(false);
			}
		});
		}
		else if(playerHitNumber == 1)
		{
		hitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				playerSecondHit();
				((AbstractButton) mouseClick.getSource()).removeActionListener(this);
				doubleButton.setEnabled(false);
			}
		});
		}
		else if(playerHitNumber == 2)
		{
		hitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				playerThirdHit();
				((AbstractButton) mouseClick.getSource()).removeActionListener(this);
				doubleButton.setEnabled(false);
			}
		});
		}
		
		if (houseHasBlackjack == true)
		{
			doubleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent mouseClick)
				{
					betDoubled();
					playerImageLabel3.setIcon(playerCard3);
					playerScore += playerCard3Value;
					if (playerCard3Value == 1 || playerCard2Value == 1 || playerCard1Value == 1)
					{
						if (playerScore + 10 > houseScore && playerScore + 10 <= 21)
						{
							playerScore = playerScore + 10;
							playerWin();
						}
						else if (playerScore + 10 < 21)
						{
							playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
						}
						else
						{
							playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
						}
						
					}
					else
					{
						playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
					}
					houseBlackjack();
					((AbstractButton) mouseClick.getSource()).setEnabled(false);
				}
			});
		}
		else
		{
			doubleButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent mouseClick)
				{
					betDoubled();
					playerFirstHit();
					((AbstractButton) mouseClick.getSource()).setEnabled(false);
				}
			});
		}
		
		playAgainButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				playAgain();
				((AbstractButton) mouseClick.getSource()).setEnabled(false);
			}
		});
	}
	
	public void setupBet()
	{
		submitBetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				betSelected();
				((AbstractButton) mouseClick.getSource()).setEnabled(false);
				standButton.setEnabled(true);
				hitButton.setEnabled(true);
				doubleButton.setEnabled(true);
				betSelectorBox.setEnabled(false);
				playerPanel.setVisible(true);
				housePanel.setVisible(true);
				scorePanel.setVisible(true);
			}
		});
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
		layout.putConstraint(SpringLayout.EAST, scorePanel, 0, SpringLayout.EAST, buttonPanel);
		housePanel.setLayout(new BoxLayout(housePanel, BoxLayout.X_AXIS));
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.X_AXIS));
		layout.putConstraint(SpringLayout.EAST, cardPanel, -240, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, chipPanel, 0, SpringLayout.SOUTH, scorePanel);
		layout.putConstraint(SpringLayout.WEST, chipPanel, 0, SpringLayout.WEST, buttonPanel);
		layout.putConstraint(SpringLayout.SOUTH, chipPanel, 0, SpringLayout.NORTH, buttonPanel);
		layout.putConstraint(SpringLayout.EAST, chipPanel, 0, SpringLayout.EAST, buttonPanel);
		layout.putConstraint(SpringLayout.SOUTH, scorePanel, 130, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.NORTH, tempScorePanel, 0, SpringLayout.NORTH, scorePanel);
		layout.putConstraint(SpringLayout.WEST, tempScorePanel, 0, SpringLayout.WEST, scorePanel);
		layout.putConstraint(SpringLayout.SOUTH, tempScorePanel, 0, SpringLayout.SOUTH, scorePanel);
		layout.putConstraint(SpringLayout.EAST, tempScorePanel, 0, SpringLayout.EAST, scorePanel);
	}
		
	public void firstFourCards()
	{
		/*
		 * Player receives their first card
		 */
		playerImageLabel1.setIcon(playerCard1);
		playerScore += playerCard1Value;
		System.out.println("player receives 1st: player score: " + playerScore);
		System.out.println("player receives 1st: house score: " + houseScore);
		if (playerCard1Value == 1)
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		
		/*
		 * House receives their first card
		 */
		houseImageLabel1.setIcon(houseCard1);
		houseScore += houseCard1Value;
		System.out.println("house receives 1st: player score: " + playerScore);
		System.out.println("house receives 1st: house score: " + houseScore);
		if (houseCard1Value == 1)
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore + " or " + String.valueOf(houseScore + 10)));
		}
		else
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
		}
		
		/*
		 * Player receives their second card
		 */
		playerImageLabel2.setIcon(playerCard2);
		playerScore += playerCard2Value;
		System.out.println("player receives 2nd: player score: " + playerScore);
		System.out.println("player receives 2nd: house score: " + houseScore);
		if (playerCard2Value == 1 || playerCard1Value == 1)
		{
			if ((playerCard2Value == 1 || playerCard1Value == 1) && playerScore + 10 == 21)
			{
				playerScore = 21;
				houseScore += houseCard2Value;
				houseImageLabel2.setIcon(houseCard2);
				if (houseScore + 10 == 21 && (houseCard1Value == 1 || houseCard2Value == 1))
				{
					if (playerScore == 21)
					{
						push();
					}
					else
					{
						houseImageLabel2.setIcon(houseCard2);
					}
				}
				playerBlackjack();
			}
			else if (playerScore + 10 < 21)
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
			}
			else
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
			}
		}
		else if (playerScore > 21)
		{
			playerBust();
		}
		else if (playerCard2Value == 1 && playerCard1Value == 1)
		{
			if (playerScore + 10 < 21)
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
			}
			else
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
				houseHasBlackjack = true;
			}
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		controller.cardPlayed();
		
		/*
		 * House receives their second card
		 */
		houseScore += houseCard2Value;
		System.out.println("house receives 2nd: player score: " + playerScore);
		System.out.println("house receives 2nd: house score: " + houseScore);
		System.out.println("house receives 2nd: houseCard2Value: " + houseCard2Value);
		if (houseScore + 10 == 21 && (houseCard1Value == 1 || houseCard2Value == 1))
		{
			if (playerScore == 21)
			{
				push();
			}
			else
			{
				houseImageLabel2.setIcon(houseCard2);
			}
		}
		else if (playerScore == 21)
		{
			houseImageLabel2.setIcon(houseCard2);
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
		}
		houseImageLabel2.setIcon(faceDownCard);
	}
	
	public void playerFirstHit()
	{
		/*
		 * Player plays their first "Hit"
		 */
		playerImageLabel3.setIcon(playerCard3);
		playerScore += playerCard3Value;
		System.out.println("playerFirstHit: player score: " + playerScore);
		System.out.println("playerFirstHit: house score: " + houseScore);
		if (playerScore == 21)
		{
			playerWin();
		}
		else if (playerScore > 21)
		{
			playerBust();
		}
		else if (playerCard3Value == 1 || playerCard2Value == 1 || playerCard1Value == 1)
		{
			if (playerScore + 10 > houseScore && playerScore + 10 <= 21)
			{
				playerScore = playerScore + 10;
				playerWin();
			}
			else if (playerScore + 10 < 21)
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
			}
			else
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
			}
			
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		playerHitNumber++;
		setupListeners();
	}
	
	public void playerSecondHit()
	{
		playerImageLabel4.setIcon(playerCard4);
		playerScore += playerCard4Value;
		System.out.println("playerSecondHit: player score: " + playerScore);
		System.out.println("House: house score: " + houseScore);
		if (playerScore == 21)
		{
			playerWin();
		}
		else if (playerScore > 21)
		{
			playerBust();
		}
		else if (playerCard3Value == 1 || playerCard2Value == 1 || playerCard1Value == 1)
		{
			if (playerScore + 10 > houseScore && playerScore + 10 <= 21)
			{
				playerScore = playerScore + 10;
				playerWin();
			}
			else if (playerScore + 10 < 21)
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
			}
			else
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
			}
			
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		playerHitNumber++;
	}
	
	public void playerThirdHit()
	{
		playerImageLabel5.setIcon(playerCard5);
		playerScore += playerCard5Value;
		System.out.println("playerSecondHit: player score: " + playerScore);
		System.out.println("House: house score: " + houseScore);
		if (playerScore == 21)
		{
			playerWin();
		}
		else if (playerScore > 21)
		{
			playerBust();
		}
		else if (playerCard5Value == 1 || playerCard4Value == 1 || playerCard3Value == 1 || playerCard2Value == 1 || playerCard1Value == 1)
		{
			if (playerScore + 10 > houseScore && playerScore + 10 <= 21)
			{
				playerScore = playerScore + 10;
				playerWin();
			}
			else if (playerScore + 10 < 21)
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
			}
			else
			{
				playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
			}
			
		}
		else
		{
			playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
		}
		playerHitNumber++;
	}
	
	public void playerStand()
	{
		houseRevealsSecondCard();
	}
	
	public void houseRevealsSecondCard()
	{
		houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + houseCard2Name + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		System.out.println("house reveals 2nd: player score: " + playerScore);
		System.out.println("house reveals 2nd: house score: " + houseScore);
		if ((houseCard1Value == 1 || houseCard2Value == 1) && houseScore + 10 == 21)
		{
			houseScore = 21;
			houseBlackjack();
		}
		else if (playerScore == 21 && houseScore != 21)
		{
			playerScoreText.setText("Your Score: BLACKJACK! (" + playerScore + ")");
			standButton.setEnabled(false);
			hitButton.setEnabled(false);
			doubleButton.setEnabled(false);
			playAgainButton.setEnabled(true);
			exitAndSaveButton.setEnabled(true);
			betWon();
		}
		else if ((playerCard2Value == 1 || playerCard1Value == 1) && houseScore > playerScore + 10)
		{
			houseWin();
		}
		else if (houseScore > 21)
		{
			houseBust();
		}
		else if (houseCard2Value == 1 || houseCard1Value == 1)
		{
			if (houseScore + 10 == 21)
			{
				houseBlackjack();
			}
			else if ((houseScore + 10 > playerScore) && (houseScore + 10 >= 17))
			{
				houseScore = houseScore + 10;
				houseWin();
			}
			else if (houseScore + 10 >= 17)
			{
				houseStand();
			}
			else
			{
				houseFirstHit();
			}
		}
		else if (houseScore >= 17)
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseStand();
		}
		else
		{
			houseFirstHit();
		}
	}
	
	public void houseFirstHit()
	{
		houseImageLabel3.setIcon(houseCard3);
		houseScore += houseCard3Value;
		System.out.println("house first hit: player score: " + playerScore);
		System.out.println("house first hit: house score: " + houseScore);
		if (houseScore > 21)
		{
			houseBust();
		}
		else if ((houseCard3Value == 1 && houseCard2Value == 1) || (houseCard2Value == 1 && houseCard1Value == 1) || (houseCard3Value == 1 && houseCard1Value == 1))
		{
			if (houseScore + 10 < 17)
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore + " or " + String.valueOf(houseScore + 10)));
				houseSecondHit();
			}
			else if (houseScore + 10 >= 17 && houseScore + 10 <= 21)
			{
				houseScore = houseScore + 10;
				houseStand();
			}
			else if (houseScore + 10 > 21)
			{
				houseScore = houseScore + 10;
				houseScoreText.setText("House Score: " + houseScore);
			}
		}
		else if (houseCard3Value == 1 || houseCard2Value == 1 || houseCard1Value == 1)
		{
			if (houseScore + 10 > playerScore && houseScore + 10 <= 21 && houseScore + 10 < 17)
			{
				houseScore += 10;
				houseWin();
			}
			else if (houseScore + 10 >= 17 && houseScore + 10 <= 21)
			{
				houseScore += 10;
				houseStand();
			}
			else if (houseScore + 10 < 17)
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore + " or " + String.valueOf(houseScore + 10)));
				houseSecondHit();
			}
			else
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore));
				houseSecondHit();
			}
			
		}
		else if (houseScore >= 17)
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseStand();
		}
		else
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseSecondHit();
		}
	}
	
	public void houseSecondHit()
	{
		houseImageLabel4.setIcon(houseCard4);
		houseScore += houseCard4Value;
		System.out.println("house second hit: player score: " + playerScore);
		System.out.println("house second hit: house score: " + houseScore);
		if (houseScore > 21)
		{
			houseBust();
		}
		else if (houseScore > playerScore && houseScore <= 21 && houseScore >= 17)
		{
			houseWin();
		}
		else if (houseCard4Value == 1 || houseCard3Value == 1 || houseCard2Value == 1 || houseCard1Value == 1)
		{
			if (houseScore + 10 > playerScore && houseScore + 10 <= 21 && houseScore + 10 < 17)
			{
				houseScore += 10;
				houseWin();
			}
			else if (houseScore + 10 >= 17 && houseScore + 10 <= 21)
			{
				houseScore += 10;
				houseStand();
			}
			else if (houseScore + 10 < 17)
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore + " or " + String.valueOf(houseScore + 10)));
				houseThirdHit();
			}
			else
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore));
				houseThirdHit();
			}
			
		}
		else if (houseScore >= 17)
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseStand();
		}
		else
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseThirdHit();
		}
	}
	
	public void houseThirdHit()
	{
		houseImageLabel5.setIcon(houseCard5);
		houseScore += houseCard5Value;
		System.out.println("house second hit: player score: " + playerScore);
		System.out.println("house second hit: house score: " + houseScore);
		if (houseScore > 21)
		{
			houseBust();
		}
		else if (houseScore > playerScore && houseScore <= 21 && houseScore >= 17)
		{
			houseWin();
		}
		else if (houseCard4Value == 1 || houseCard3Value == 1 || houseCard2Value == 1 || houseCard1Value == 1)
		{
			if (houseScore + 10 > playerScore && houseScore + 10 <= 21 && houseScore + 10 < 17)
			{
				houseScore += 10;
				houseWin();
			}
			else if (houseScore + 10 >= 17 && houseScore + 10 <= 21)
			{
				houseScore += 10;
				houseStand();
			}
			else if (houseScore + 10 < 17)
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore + " or " + String.valueOf(houseScore + 10)));
				houseFourthHit();
			}
			else
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore));
				houseFourthHit();
			}
			
		}
		else if (houseScore >= 17)
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseStand();
		}
		else
		{
			houseScoreText.setText("House Score: " + String.valueOf(houseScore));
			houseFourthHit();
		}
	}
	
	public void houseFourthHit()
	{
		System.out.println("HOUSE FOURTH HIT");
	}
	
	public void houseStand()
	{
		System.out.println("house stand: player score: " + playerScore);
		System.out.println("house stand: house score: " + houseScore);
		if ((playerCard2Value == 1 || playerCard1Value == 1) && playerHitNumber == 0)
		{
			if (houseScore > playerScore + 10 && playerScore + 10 <= 21)
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore + 10));
				houseWin();
			}
			else if (houseScore == playerScore + 10 && playerScore + 10 <= 21)
			{
				draw();
			}
			else
			{
				if (houseScore > playerScore + 10 && playerScore + 10 <= 21)
				{
					houseWin();
				}
				else if (houseScore > playerScore && playerScore + 10 > 21)
				{
					houseWin();
				}
				else if (houseScore == playerScore + 10 && playerScore + 10 <= 21)
				{
					draw();
				}
				else if (houseScore < playerScore && playerScore + 10 <= 21)
				{
					playerScore += 10;
					playerWin();
				}
			}
		}
		else if ((playerCard3Value == 1 || playerCard2Value == 1 || playerCard1Value == 1) && playerHitNumber == 1)
		{
			if (houseScore > playerScore + 10 && playerScore + 10 <= 21)
			{
				houseScoreText.setText("House Score: " + String.valueOf(houseScore + 10));
				houseWin();
			}
			else if (houseScore == playerScore + 10 && playerScore + 10 <= 21)
			{
				draw();
			}
			else
			{
				if (houseScore > playerScore && playerScore + 10 > 21)
				{
					houseWin();
				}
				else if (houseScore + 10 > playerScore && houseScore + 10 <= 21)
				{
					houseScore += 10;
					houseScoreText.setText("House Score: " + String.valueOf(houseScore + 10));
					houseWin();
				}
				else if (houseScore < playerScore && playerScore + 10 <= 21)
				{
					playerScore += 10;
					playerScoreText.setText("Your Score: " + String.valueOf(playerScore + 10));
					playerWin();
				}
				else if (houseScore < playerScore && playerScore <= 21)
				{
					playerWin();
				}
			}
		}
		else if (houseScore > playerScore)
		{
			houseWin();
		}
		else if (houseScore == playerScore)
		{
			draw();
		}
		else
		{
			playerWin();
		}
	}
	
	public void playerWin()
	{
		houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + houseCard2Name + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		playerScoreText.setText("Your Score: WIN! (" + playerScore + ")");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		betWon();
	}
	
	public void playerBust()
	{
		houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + houseCard2Name + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		houseScoreText.setText("House Score: " + houseScore);
		playerScoreText.setText("Your Score: BUST! (" + playerScore + ")");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
	}
	
	public void playerBlackjack()
	{	houseCard2 = new ImageIcon(getClass().getResource("/fin/view/images/" + houseCard2Name + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		playerScoreText.setText("Your Score: BLACKJACK! (" + playerScore + ")");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		betWon();
	}
	
	public void houseWin()
	{
		houseScoreText.setText("House Score: WIN! (" + houseScore + ")");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
	}
	
	public void houseBust()
	{
		houseScoreText.setText("House Score: BUST! (" + houseScore + ")");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		betWon();
	}
	
	public void houseBlackjack()
	{
		houseScoreText.setText("House Score: BLACKJACK! (" + houseScore + ")");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		if (playerScore == 21)
		{
			push();
		}
	}
	
	public void draw()
	{
		playerScoreText.setText("Your Score: DRAW!");
		houseScoreText.setText("House Score: DRAW!");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		betReturned();
	}
	
	public void push()
	{
		playerScoreText.setText("Your Score: PUSH!");
		houseScoreText.setText("House Score: PUSH!");
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		betReturned();
	}
	
	public void playAgain()
	{
		housePanel.removeAll();
		playerPanel.removeAll();
		buttonPanel.removeAll();
		scorePanel.removeAll();
		chipPanel.removeAll();
		controller.fillAndShuffle();
		addAllElements();
		setupPanel();
		setupBet();
		setupListeners();
		setupLayout();
		firstFourCards();
		revalidate();
		repaint();
	}
	
	public void betSelected()
	{
		if (betSelectorBox.getSelectedIndex() == 0)
		{
			chipNumber -= 5;
			chipNumberText.setText("Your Chips: " + chipNumber);
			
		}
		else if (betSelectorBox.getSelectedIndex() == 1)
		{
			chipNumber -= 10;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 2)
		{
			chipNumber -= 25;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 3)
		{
			chipNumber -= 50;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 4)
		{
			chipNumber -= 100;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
	}
	
	public void betDoubled()
	{
		if (betSelectorBox.getSelectedIndex() == 0)
		{
			chipNumber -= 5;
			chipNumberText.setText("Your Chips: " + chipNumber);
			
		}
		else if (betSelectorBox.getSelectedIndex() == 1)
		{
			chipNumber -= 10;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 2)
		{
			chipNumber -= 25;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 3)
		{
			chipNumber -= 50;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 4)
		{
			chipNumber -= 100;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
	}
	
	public void betWon()
	{
		if (betSelectorBox.getSelectedIndex() == 0)
		{
			chipNumber += 10;
			chipNumberText.setText("Your Chips: " + chipNumber);
			
		}
		else if (betSelectorBox.getSelectedIndex() == 1)
		{
			chipNumber += 20;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 2)
		{
			chipNumber += 50;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 3)
		{
			chipNumber += 100;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 4)
		{
			chipNumber += 200;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
	}
	
	public void betReturned()
	{
		if (betSelectorBox.getSelectedIndex() == 0)
		{
			chipNumberText.setText("Your Chips: " + chipNumber);
			
		}
		else if (betSelectorBox.getSelectedIndex() == 1)
		{
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 2)
		{
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 3)
		{
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 4)
		{
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
	}
}
