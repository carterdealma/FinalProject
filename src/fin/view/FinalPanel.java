package fin.view;

import fin.controller.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FinalPanel extends JPanel
{
	private boolean playerBlackjack;
	private boolean houseBlackjack;
	private int gameStatus;
	private int realHouseScore;
	private int houseAces;
	private int playerAces;
	private boolean ifFirstHand;
	private boolean ifPlayerTurn;
	private ArrayList<Integer> cardValues;
	private String playerOrHouse;
	private boolean isThemed;
	private double chipNumber;
	private double chipBet;
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
	private JTextArea incorrectPasswordText;
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
		this.incorrectPasswordText = new JTextArea("Incorrect Password!");
		this.playerScore = 0;
		this.houseScore = 0;
		this.playerHitNumber = 0;
		this.chipBet = 0;
		this.playerAces = 0;
		this.houseAces = 0;
		this.realHouseScore = 0;
		this.gameStatus = 0;
		this.playerBlackjack = false;
		this.houseBlackjack = false;
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
		loginPanel.add(incorrectPasswordText);
		this.add(themePanel);
		this.add(startPanel);
		loginText.setEditable(false);
		passwordText.setEditable(false);
		incorrectPasswordText.setEditable(false);
		incorrectPasswordText.setVisible(false);
		doubleButton.setVisible(false);
		hitButton.setVisible(false);
		standButton.setVisible(false);
		playAgainButton.setVisible(false);
		playAgainButton.setEnabled(false);
		exitAndSaveButton.setVisible(false);
		exitAndSaveButton.setEnabled(false);
		betSelectorText.setVisible(false);
		betSelectorBox.setEnabled(false);
		betSelectorBox.setVisible(false);
		submitBetButton.setVisible(false);
		loginButton.setEnabled(false);
		chipNumberText.setVisible(false);
		themeText.setEditable(false);
		confirmThemeButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				if (themeSelectorBox.getSelectedIndex() == 0)
				{
					setupLoginListeners();
					isThemed = false;
//					controller.createDeck(isThemed);
//					controller.shuffleCards(isThemed);
////					cardPath = controller.sendPath(isThemed);
//					setupBet();
//					firstDeal(isThemed);
//					calculateScore(ifPlayerTurn, ifFirstHand);
//					ifFirstHand = false;
					loginButton.setEnabled(true);
					confirmThemeButton.setEnabled(false);
				}
				else if (themeSelectorBox.getSelectedIndex() == 1)
				{
					setupLoginListeners();
					System.out.println("Cards are deadpool");
					isThemed = true;
//					controller.createDeck(isThemed);
//					controller.shuffleCards(isThemed);
////					cardPath = controller.sendPath(isThemed);
//					setupBet();
//					firstDeal(isThemed);
//					calculateScore(ifPlayerTurn, ifFirstHand);
//					ifFirstHand = false;
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
					if (controller.authenticateUser(userid, passwd) == true)
					{
						chipNumber = controller.readUserData(userid);
						System.out.println("chipNumber after login is: " + chipNumber);
						chipNumberText.setText("Your Chips: " + chipNumber);
						controller.createDeck(isThemed);
						controller.shuffleCards(isThemed);
						setupBet();
						firstDeal(isThemed);
						calculateScore(ifPlayerTurn, ifFirstHand);
						ifFirstHand = false;
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
						chipNumberText.setVisible(true);
						betSelectorBox.setVisible(true);
					}
					else
					{
						passwdField.setText("");
						incorrectPasswordText.setVisible(true);
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
				if (houseBlackjack == true || playerBlackjack == true)
				{
					standButton.setEnabled(false);
					hitButton.setEnabled(false);
					doubleButton.setEnabled(false);
					betSelectorBox.setEnabled(false);
					playAgainButton.setEnabled(true);
					exitAndSaveButton.setEnabled(true);
					playerPanel.setVisible(true);
					housePanel.setVisible(true);
					scorePanel.setVisible(true);
					
				}
				else
				{
					standButton.setEnabled(true);
					hitButton.setEnabled(true);
					doubleButton.setEnabled(true);
					betSelectorBox.setEnabled(false);
					playerPanel.setVisible(true);
					housePanel.setVisible(true);
					scorePanel.setVisible(true);
				}
			}
		});
	}
	
	public void setupListeners()
	{
		exitAndSaveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				controller.updateUserData(userid, String.valueOf(chipNumber));
				System.exit(0);
			}
		});

		standButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				ifPlayerTurn = false;
				playerStand();
				houseTurn();
			}
		});

		hitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				ifFirstHand = false;
				dealNextCard("player");
				doubleButton.setEnabled(false);
				calculateScore(ifPlayerTurn, ifFirstHand);
			}
		});
		
		doubleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				betSelected();
				dealNextCard("player");
				calculateScore(ifPlayerTurn, ifFirstHand);
				houseTurn();
				doubleButton.setEnabled(false);
				hitButton.setEnabled(false);
				standButton.setEnabled(false);
				playAgainButton.setEnabled(true);
				exitAndSaveButton.setEnabled(true);
			}
		});
		
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
		layout.putConstraint(SpringLayout.NORTH, loginPanel, 200, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, loginPanel, -200, SpringLayout.SOUTH, this);
	}
	
	public void calculateScore(boolean ifPlayerTurn, boolean ifFirstHand)
	{
		System.out.println("calculate Score chipBet: " + chipBet);
		System.out.println("calculate Score chipNumber: " + chipNumber);
		System.out.println("ifPlayerTurn: " + ifPlayerTurn);
		//Calculate score for the player
		gameStatus = 0; //0 = Game is NOT over, 1 = House wins, 2 = Player wins, 3 = Push
		realHouseScore = 0;
		playerBlackjack = false;
		houseBlackjack = false;
		boolean playerBust = false;
		boolean houseBust = false;
		playerScore = 0;
		playerAces = 0;
		int playerAcesSubtracted = 0;
		int houseAcesSubtracted = 0;
		houseScore = 0;
		houseAces = 0;
		cardValues = controller.sendCardValues("player");
		for (int value : cardValues)
		{
			playerScore += value;
			if (value == 11)
			{
				playerAces++;
			}
		}
		
		//Player ace logic
		for (int card : cardValues)
		{
			System.out.println("Player card: " + card);
		}
		for (int index = 0; index < playerAces; index++)
		{
			if (playerScore > 21)
			{
				playerScore -= 10;
				playerAcesSubtracted++;
			}
		}
		
		//Printing the player's score
		if (playerAces > playerAcesSubtracted)
		{
			playerScoreText.setText("Your Score: " + (playerScore - 10) + " or " + playerScore);
		}
		else
		{
			playerScoreText.setText("Your Score: " + playerScore);
		}
		
		//Calculate score for the House
		int houseAces = 0; 
		cardValues = controller.sendCardValues("house");
		for (int value : cardValues)
		{
			realHouseScore += value;
		}
		if (ifPlayerTurn == true)
		{
			houseScore = cardValues.get(0);
		}
		else
		{
			for (int value : cardValues)
			{
				houseScore += value;
				if (value == 11)
				{
					houseAces++;
				}
			}
		}

		//House ace logic
		for (int card : cardValues)
		{
			System.out.println("house card: " + card);
		}
		for (int index = 0; index < houseAces; index++)
		{
			if (houseScore > 21)
			{
				houseScore -= 10;
				realHouseScore -= 10;
				houseAcesSubtracted++;
			}
		}
		//Printing the house's score
		if (houseAces > houseAcesSubtracted)
		{
			houseScoreText.setText("House Score: " + (houseScore - 10) + " or " + houseScore);
		}
		else
		{
			houseScoreText.setText("House Score: " + houseScore);
		}
		//Check for blackjack
		if (realHouseScore == 21 && ifFirstHand == true)
		{
			houseBlackjack = true;
		}
		if (playerScore == 21 && ifFirstHand == true)
		{
			playerBlackjack = true;
		}
		if (playerBlackjack == true && houseBlackjack == true)
		{
			gameStatus = 3;
		}
		else if (playerBlackjack == true)
		{
			gameStatus = 2;
		}
		else if (houseBlackjack == true)
		{
			gameStatus = 1;
		}
		//Check for bust
		if (playerScore > 21)
		{
			houseScore = realHouseScore;
			gameStatus = 1;
			playerBust = true;
			playerStand();
		}
		else if (houseScore > 21)
		{
			gameStatus = 2;
			houseBust = true;
		}
		//Check for player hitting and getting 21
		else if (playerScore == 21 && gameStatus == 0 && houseScore < 17)
		{
			houseScore = realHouseScore;
			playerStand();
			houseTurn();
		}
		//Checking for push, player win, or house win after no more cards can be dealt
		if (houseScore >= 17 && ifPlayerTurn == false && gameStatus == 0 && houseBust == false && playerBust == false)
		{
			if (houseScore == playerScore)
			{
				gameStatus = 3;
			}
			else if (playerScore > houseScore)
			{
				gameStatus = 2;
			}
			else
			{
				gameStatus = 1;
			}
		}
		//Checks if game is over. Resets buttons and reveals house's second card.
		System.out.println("gameStatus BBR: " + gameStatus);
		if (gameStatus > 0)
		{
			System.out.println("inside gameStatus BBR: " + gameStatus);
			playerStand();
			System.out.println("hit button enabled?: " + hitButton.isEnabled());
			housePanel.add(houseLabelList.get(houseLabelList.size() - 1));
		}
		System.out.println("realHouseScore is: " + realHouseScore);
		switch (gameStatus)
		{
		case 1: //House wins
			if (playerBust == true)
			{
				playerScoreText.setText("Your Score: BUST! " + "(" + playerScore + ")");
			}
			if (houseBlackjack == true)
			{
				houseScore = realHouseScore;
				houseScoreText.setText("House Score: BLACKJACK! " + "(" + houseScore + ")");
				housePanel.remove(faceDownCard);
			}
			else
			{
				houseScoreText.setText("House Score: WINS! " + "(" + houseScore + ")");
			}
			settleBet(gameStatus, playerBlackjack);
			break;
		case 2: //Player wins
			if (houseBust == true)
			{
				houseScoreText.setText("House Score: BUST! " + "(" + houseScore + ")");
			}
			if (playerBlackjack == true)
			{
				houseScore = realHouseScore;
				playerScoreText.setText("Your Score: BLACKJACK! " + "(" + playerScore + ")");
				houseScoreText.setText("House Score: " + houseScore);
			}
			else
			{
				playerScoreText.setText("Your Score: WINS! " + "(" + playerScore + ")");
			}
			settleBet(gameStatus, playerBlackjack);
			break;
		case 3: //Push
			houseScoreText.setText("House Score: PUSH! " + "(" + houseScore + ")");
			playerScoreText.setText("Your Score: PUSH! " + "(" + playerScore + ")");
			settleBet(gameStatus, playerBlackjack);
			break;
		}
		System.out.println("calculated player score end: " + playerScore);
		System.out.println("calculated house score end: " + houseScore);
	}
	
	public void firstDeal(boolean isThemed)
	{
		if (isThemed == true)
		{
			faceDownCardIcon = new ImageIcon(getClass().getResource("/fin/view/deadpool/" + "face_down" + ".png"));
			faceDownCard.setIcon(faceDownCardIcon);
		}
		else
		{
			faceDownCardIcon = new ImageIcon(getClass().getResource("/fin/view/images/" + "face_down" + ".png"));
			faceDownCard.setIcon(faceDownCardIcon);
		}
		ifFirstHand = true;
		ifPlayerTurn = true;
		for (int index = 0; index < 2; index++)
		{
			controller.dealCard(isThemed, "player");
			playerLabelList.add(controller.sendImage("player"));
			playerPanel.add(playerLabelList.get(index));
			
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
		}
		
	}
	
	public void dealNextCard(String playerOrHouse)
	{
		controller.dealCard(isThemed, playerOrHouse);
		if (playerOrHouse == "player")
		{
			playerLabelList.add(controller.sendImage(playerOrHouse));
			playerPanel.add(playerLabelList.get(playerLabelList.size() - 1));
		}
		else
		{
			houseLabelList.add(controller.sendImage(playerOrHouse));
			housePanel.add(houseLabelList.get(houseLabelList.size() - 1));
		}
	}
	
	public void houseTurn()
	{
		housePanel.remove(faceDownCard);
		housePanel.add(houseLabelList.get(houseLabelList.size() - 1));
		ifPlayerTurn = false;
		ifFirstHand = false;
		System.out.println("outside house turn: " + houseScore);
		while (houseScore < 17 && gameStatus == 0)
		{
			System.out.println("inside house turn: " + houseScore);
			dealNextCard("house");
			calculateScore(ifPlayerTurn, ifFirstHand);
		}
		if (houseScore >= 17 && gameStatus == 0)
		{
			calculateScore(ifPlayerTurn, ifFirstHand);
		}
	}
	
	public void playerStand()
	{
		ifPlayerTurn = false;
		houseScore = realHouseScore;
		housePanel.remove(faceDownCard);
		standButton.setEnabled(false);
		hitButton.setEnabled(false);
		doubleButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
	}
	
	public void settleBet(int gameStatus, boolean playerBlackjack)
	{
		System.out.println("settle chipBet: " + chipBet);
		System.out.println("settle chipNumber: " + chipNumber);
		switch(gameStatus)
		{
		case 2: //Player wins
			if (playerBlackjack == true)
			{
				chipNumber += (2 * chipBet) + (0.5 * chipBet);
			}
			else
			{
				chipNumber += 2 * chipBet;
			}
			break;
		case 3: //Push
			chipNumber += chipBet;
			break;
		}
		chipNumberText.setText("Your Chips: " + chipNumber);
		doubleButton.setEnabled(false);
		hitButton.setEnabled(false);
		standButton.setEnabled(false);
		playAgainButton.setEnabled(true);
		exitAndSaveButton.setEnabled(true);
		System.out.println("hit button enabled2?: " + hitButton.isEnabled());
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
		setupBet();
		setupListeners();
		setupLayout();
		controller.resetGame(isThemed);
		firstDeal(isThemed);
		calculateScore(ifPlayerTurn, ifFirstHand);
		revalidate();
		repaint();
	}
	
	public void betSelected()
	{
		switch (betSelectorBox.getSelectedIndex())
		{
		case 0: //Player bets 5 chips
			chipBet += 5;
			chipNumber -= 5;
			break;
		case 1: //Player bets 10 chips
			chipBet += 10;
			chipNumber -= 10;
			break;
		case 2: //Player bets 25 chips
			chipBet += 25;
			chipNumber -= 25;
			break;
		case 3: //Player bets 50 chips
			chipBet += 50;
			chipNumber -= 50;
			break;
		case 4: //Player bets 100 chips
			chipBet += 100;
			chipNumber -= 100;
			break;
		}
		chipNumberText.setText("Your Chips: " + chipNumber);
	}
}
