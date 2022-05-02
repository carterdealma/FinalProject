package fin.view;

import fin.controller.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FinalPanel extends JPanel
{
	private boolean ifFirstDeal;
	private ArrayList<Integer> cardValues;
	private String playerOrHouse;
	private boolean isThemed;
	private int chipNumber;
	private String userid;
	private String passwd;
	
	private FinalController controller;
	
	private JPanel startPanel;
	private JPanel loginPanel;
	private JPanel themePanel;
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
	private JLabel playerImageLabel;
	private JLabel houseImageLabel;
	private ArrayList<JLabel> playerLabelList;
	private ArrayList<JLabel> houseLabelList;
	private JLabel faceDownCard;
	private ImageIcon faceDownCardIcon;
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
	private JButton loginButton;
	private JButton doubleButton;
	private JButton hitButton;
	private JButton standButton;
	private JButton playAgainButton;
	private JButton submitBetButton;
	private JButton exitAndSaveButton;
	private JButton confirmThemeButton;
	private String [] themeArray = {"Default", "Deadpool"};
	private JComboBox<String> themeSelectorBox;
	private JTextArea houseScoreText;
	private JTextArea playerScoreText;
	private JTextArea chipNumberText;
	private JTextArea betSelectorText;
	private JTextArea themeText;
	private JTextArea loginText;
	private JTextArea passwordText;
	private JTextField loginField;
	private JPasswordField passwdField;
	private int playerScore;
	private int houseScore;
	private int playerHitNumber;
	private String [] chipBetsArray = {"5 Chips", "10 Chips", "25 Chips", "50 Chips", "100 Chips"};
	private JComboBox<Integer> betSelectorBox;
	boolean houseHasBlackjack = false;
	boolean betDoubled = false;
	private String cardPath;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		addAllElements();
		setupLogin();
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void addAllElements()
	{
		this.layout = new SpringLayout();
		this.startPanel = new JPanel();
		this.loginPanel = new JPanel(new GridLayout (0,1));
		layout.putConstraint(SpringLayout.NORTH, loginPanel, 210, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, loginPanel, -210, SpringLayout.SOUTH, this);
		this.themePanel = new JPanel(new GridLayout(0,1));
		this.cardPanel = new JPanel(new GridLayout (0,1));
		cardPanel.setBackground(new Color(0, 153, 0));
		this.housePanel = new JPanel();
		housePanel.setBackground(new Color(0, 153, 0));
		this.playerPanel = new JPanel();
		playerPanel.setBackground(new Color(0, 153, 0));
		this.buttonPanel = new JPanel(new GridLayout (0,1));
		this.scorePanel = new JPanel(new GridLayout(0,1));
		this.tempScorePanel = new JPanel(new GridLayout(0,1));
		this.chipPanel = new JPanel();
		this.loginButton = new JButton("Login");
		this.doubleButton = new JButton("Double");
		this.hitButton = new JButton("Hit");
		this.standButton = new JButton("Stand");
		this.submitBetButton = new JButton("Submit Bet");
		this.playAgainButton = new JButton("Play Again?");
		this.exitAndSaveButton = new JButton("Exit and Save?");
		this.confirmThemeButton = new JButton("Confirm Theme");
		this.themeSelectorBox = new JComboBox(themeArray);
		this.houseScoreText = new JTextArea("House Score: ");
		this.playerScoreText = new JTextArea("Your Score: ");
		this.chipNumberText = new JTextArea("Your Chips: " + chipNumber);
		this.themeText = new JTextArea("Choose your theme:");
		this.loginText = new JTextArea("Username: ");
		this.passwordText = new JTextArea("Password : ");
		this.loginField = new JTextField("");
		this.passwdField = new JPasswordField("");
		this.playerScore = 0;
		this.houseScore = 0;
		this.playerHitNumber = 0;
		this.betSelectorText = new JTextArea("Select your bet: ");
		this.betSelectorBox = new JComboBox(chipBetsArray);
		this.playerLabelList = new ArrayList<JLabel>();
		this.houseLabelList = new ArrayList<JLabel>();
		this.faceDownCard = new JLabel();
		this.playerImageLabel = new JLabel();
		this.houseImageLabel = new JLabel();
		this.cardValues = new ArrayList<Integer>();
//		this.playerImageLabel1 = new JLabel();
//		this.playerImageLabel2 = new JLabel();
//		this.playerImageLabel3 = new JLabel();
//		this.playerImageLabel4 = new JLabel();
//		this.playerImageLabel5 = new JLabel();
//		this.houseImageLabel1 = new JLabel();
//		this.houseImageLabel2 = new JLabel();
//		this.houseImageLabel3 = new JLabel();
//		this.houseImageLabel4 = new JLabel();
//		this.houseImageLabel5 = new JLabel();
		
	}
	
	public void setupLogin()
	{
		this.add(loginPanel);
		loginPanel.add(themeText);
		loginPanel.add(themeSelectorBox);
		loginPanel.add(confirmThemeButton);
		loginPanel.add(loginText);
		loginPanel.add(loginField);
		loginPanel.add(passwordText);
		loginPanel.add(passwdField);
		loginPanel.add(loginButton);
		this.add(themePanel);
		this.add(startPanel);
		loginText.setEditable(false);
		passwordText.setEditable(false);
		doubleButton.setVisible(false);
		hitButton.setVisible(false);
		standButton.setVisible(false);
		playAgainButton.setVisible(false);
		playAgainButton.setEnabled(false);
		exitAndSaveButton.setVisible(false);
		exitAndSaveButton.setEnabled(false);
		betSelectorText.setVisible(false);
		betSelectorBox.setEnabled(false);
		submitBetButton.setVisible(false);
		loginButton.setEnabled(false);
		confirmThemeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				if (themeSelectorBox.getSelectedIndex() == 0)
				{
					setupLoginListeners();
					isThemed = false;
					controller.createDeck(isThemed);
					controller.shuffleCards(isThemed);
					faceDownCardIcon = new ImageIcon(getClass().getResource("/fin/view/images/" + "face_down" + ".png"));
					faceDownCard.setIcon(faceDownCardIcon);
//					cardPath = controller.sendPath(isThemed);
					setupBet();
					firstDeal();
					ifFirstDeal = true;
					calculateScore(ifFirstDeal);
					ifFirstDeal = false;
//					setupCards();
//					firstFourCards();
					loginButton.setEnabled(true);
					confirmThemeButton.setEnabled(false);
				}
				else if (themeSelectorBox.getSelectedIndex() == 1)
				{
					setupLoginListeners();
					System.out.println("Cards are deadpool");
					isThemed = true;
					controller.createDeck(isThemed);
					controller.shuffleCards(isThemed);
					faceDownCardIcon = new ImageIcon(getClass().getResource("/fin/view/deadpool/" + "face_down" + ".png"));
					faceDownCard.setIcon(faceDownCardIcon);
//					cardPath = controller.sendPath(isThemed);
					setupBet();
					firstDeal();
					ifFirstDeal = true;
					calculateScore(ifFirstDeal);
					ifFirstDeal = false;
//					setupCards();
//					firstFourCards();
					setupListeners();
					setupLayout();
					loginButton.setEnabled(true);
					confirmThemeButton.setEnabled(false);
				}
			}
		});
	}
	
//	public void setupCards()
//	{
//		System.out.println("cardPath in setupCards: " + cardPath);
//		this.faceDownCard = new ImageIcon(getClass().getResource(cardPath + "face_down" + ".png"));
//		playerCard1 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		playerCard1Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed); 
//		playerCard2 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		playerCard2Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		playerCard3 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		playerCard3Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		playerCard4 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		playerCard4Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		playerCard5 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		playerCard5Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		houseCard1 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		houseCard1Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		houseCard2 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		houseCard2Value = controller.sendValue(isThemed);
//		houseCard2Name = controller.sendName(isThemed);
//		controller.cardPlayed(isThemed);
//		houseCard3 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		houseCard3Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		houseCard4 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		houseCard4Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//		houseCard5 = new ImageIcon(getClass().getResource(cardPath + controller.sendName(isThemed)) + ".png");
//		houseCard5Value = controller.sendValue(isThemed);
//		controller.cardPlayed(isThemed);
//	}

	public void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.DARK_GRAY);
		this.add(cardPanel);
		cardPanel.add(housePanel);
//		housePanel.add(houseImageLabel1);
//		housePanel.add(houseImageLabel2);
//		housePanel.add(houseImageLabel3);
//		housePanel.add(houseImageLabel4);
//		housePanel.add(houseImageLabel5);
		cardPanel.add(playerPanel);
//		playerPanel.add(playerImageLabel1);
//		playerPanel.add(playerImageLabel2);
//		playerPanel.add(playerImageLabel3);
//		playerPanel.add(playerImageLabel4);
//		playerPanel.add(playerImageLabel5);
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
	
	public void setupLoginListeners()
	{
		loginButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				if (!loginField.getText().equals(""))
				{
					userid = loginField.getText().trim().toLowerCase();
					passwd = new String(passwdField.getPassword());
					if (controller.authenticateUser(userid, passwd))
					{
						chipNumber = readUserData(userid);
						System.out.println("chipNumber after login is: " + chipNumber);
						chipNumberText.setText("Your Chips: " + chipNumber);
						startPanel.setVisible(false);
						loginPanel.setVisible(false);
						doubleButton.setVisible(true);
						hitButton.setVisible(true);
						standButton.setVisible(true);
						playAgainButton.setVisible(true);
						playAgainButton.setEnabled(false);
						exitAndSaveButton.setVisible(true);
						exitAndSaveButton.setEnabled(false);
						betSelectorText.setVisible(true);
						betSelectorBox.setEnabled(true);
						submitBetButton.setVisible(true);
					}
					else
					{
						loginField.setText("");
						passwdField.setText("");
					}
				}
				else
				{
					loginField.setText("");
					passwdField.setText("");
				}
			}
		});
	}
	
	public void setupBet()
	{
		submitBetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				System.out.println("chipNumber after bet is: " + chipNumber);
				betSelected();
				System.out.println("chipNumber after bet is selected: " + chipNumber);
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
	
	public void setupListeners()
	{
		System.out.println("playerHitNumber: " + playerHitNumber);
		
		exitAndSaveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				controller.updateUserData(userid, String.valueOf(chipNumber));
				System.exit(0);
			}
		});

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
		else if(playerHitNumber == 0 && houseHasBlackjack == false)
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
						if (playerScore + 10 == 21)
						{
							push();
						}
						else if (playerScore + 10 < 21)
						{
							playerScoreText.setText("Your Score: " + String.valueOf(playerScore + " or " + String.valueOf(playerScore + 10)));
							houseBlackjack();
						}
						else
						{
							playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
							houseBlackjack();
						}
					}
					else
					{
						playerScoreText.setText("Your Score: " + String.valueOf(playerScore));
						houseBlackjack();
					}
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
		layout.putConstraint(SpringLayout.WEST, loginPanel, 520, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.EAST, loginPanel, -520, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, startPanel, 0, SpringLayout.NORTH, cardPanel);
		layout.putConstraint(SpringLayout.WEST, startPanel, 0, SpringLayout.WEST, cardPanel);
		layout.putConstraint(SpringLayout.SOUTH, startPanel, 0, SpringLayout.SOUTH, cardPanel);
		layout.putConstraint(SpringLayout.EAST, startPanel, 0, SpringLayout.EAST, buttonPanel);
		layout.putConstraint(SpringLayout.NORTH, buttonPanel, 245, SpringLayout.NORTH, this);
	}
	
	public void calculateScore(boolean firstDeal)
	{
		int totalScore = 0;
		int playerAces = 0;
		cardValues = controller.sendCardValues("player");
		for (int value : cardValues)
		{
			totalScore += value;
			if (value == 11)
			{
				playerAces++;
			}
		}
		playerScore = totalScore;
		if (playerAces == 0 || playerScore > 21)
		{
			playerScoreText.setText("Your Score: " + playerScore);
		}
		else
		{
			playerScoreText.setText("Your Score: " + (playerScore - 10) + " or " + playerScore);
		}
		
		int houseAces = 0;
		totalScore = 0;
		cardValues = controller.sendCardValues("house");
		if (firstDeal)
		{
			totalScore = cardValues.get(0);
		}
		else
		{
			for (int value : cardValues)
			{
				totalScore += value;
				if (value == 11)
				{
					houseAces++;
				}
			}
		}
		houseScore = totalScore;
		if (houseAces == 0 || houseScore > 21)
		{
			houseScoreText.setText("Your Score: " + houseScore);
		}
		else
		{
			houseScoreText.setText("Your Score: " + (houseScore - 10) + " or " + houseScore);
		}
	}
	
	public void firstDeal()
	{
		for (int index = 0; index < 2; index++)
		{
			controller.dealCard(isThemed, "player");
			playerLabelList.add(controller.sendImage("player"));
			playerPanel.add(playerLabelList.get(index));
			System.out.println("player card name: " + controller.sendName("player"));
			
			controller.dealCard(isThemed, "house");
			houseLabelList.add(controller.sendImage("house"));
			if (index == 0)
			{
				housePanel.add(houseLabelList.get(index));
			}
			else
			{
				housePanel.add(faceDownCard);
			}
			System.out.println("house card name: " + controller.sendName("house"));
		}
		System.out.println("size of player label list: " + playerLabelList.size());
		System.out.println("size of house label list: " + houseLabelList.size());
		
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
		else
		{
//		houseImageLabel2.setIcon(faceDownCard);
		}
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
			if (playerScore + 10 < 21)
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
		System.out.println("playerSecondHit: house score: " + houseScore);
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
	
	public void playerThirdHit()
	{
		playerImageLabel5.setIcon(playerCard5);
		playerScore += playerCard5Value;
		System.out.println("playerThirdHit: player score: " + playerScore);
		System.out.println("playerThirdHit: house score: " + houseScore);
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
		setupListeners();
	}
	
	public void playerStand()
	{
		houseRevealsSecondCard();
	}
	
	public void houseRevealsSecondCard()
	{
		houseCard2 = new ImageIcon(getClass().getResource(cardPath + houseCard2Name + ".png"));
		houseImageLabel2.setIcon(houseCard2);
		System.out.println("house reveals 2nd: player score: " + playerScore);
		System.out.println("house reveals 2nd: house score: " + houseScore);
		if ((houseCard1Value == 1 || houseCard2Value == 1) && houseScore + 10 == 21)
		{
			houseScore = 21;
			houseBlackjack();
		}
//		else if (playerScore == 21 && houseScore != 21)
//		{
//			playerScoreText.setText("Your Score: BLACKJACK! (" + playerScore + ")");
//			standButton.setEnabled(false);
//			hitButton.setEnabled(false);
//			doubleButton.setEnabled(false);
//			playAgainButton.setEnabled(true);
//			exitAndSaveButton.setEnabled(true);
//			betWon();
//		}
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
			if ((houseScore + 10 > playerScore) && (houseScore + 10 >= 17))
			{
				houseScore = houseScore + 10;
				houseWin();
			}
			else if (houseScore + 10 >= 17)
			{
				houseScore = houseScore + 10;
				houseScoreText.setText("House Score: " + String.valueOf(houseScore));
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
		houseCard2 = new ImageIcon(getClass().getResource(cardPath + houseCard2Name + ".png"));
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
		houseCard2 = new ImageIcon(getClass().getResource(cardPath + houseCard2Name + ".png"));
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
	{	
		houseCard2 = new ImageIcon(getClass().getResource(cardPath + houseCard2Name + ".png"));
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
		controller.createDeck(isThemed);
		addAllElements();
		setupPanel();
//		setupCards();
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
		betDoubled = true;
		
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
		if (betDoubled == true)
		{
			betWonDouble();
		}
		else if (betSelectorBox.getSelectedIndex() == 0)
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
	
	public void betWonDouble()
	{
		if (betSelectorBox.getSelectedIndex() == 0)
		{
			chipNumber += 20;
			chipNumberText.setText("Your Chips: " + chipNumber);
			
		}
		else if (betSelectorBox.getSelectedIndex() == 1)
		{
			chipNumber += 40;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 2)
		{
			chipNumber += 100;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 3)
		{
			chipNumber += 200;
			chipNumberText.setText("Your Chips: " + chipNumber);
		}
		else if (betSelectorBox.getSelectedIndex() == 4)
		{
			chipNumber += 400;
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
	
	public int readUserData(String userid)
	{
		return this.controller.readUserData(userid);
	}
}
