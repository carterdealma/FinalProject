package fin.view;

import fin.controller.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * FinalPanel for the game Blackjack.
 * @author Carter Ma
 *
 */
public class FinalPanel extends JPanel
{
	/**
	 * ArrayList of cardValues used by both the player and the house.
	 */
	private ArrayList<Integer> cardValues;
	
	/**
	 * Reference to the FinalController instance.
	 */
	private FinalController controller;
	
	/**
	 * A blank starting panel which holds the login and theme panels.
	 */
	private JPanel startPanel;
	
	/**
	 * A panel where the user logs in.
	 */
	private JPanel loginPanel;
	
	/**
	 * A panel where the user selects the theme of the cards within the game.
	 */
	private JPanel themePanel;
	
	/**
	 * A panel that holds the house and player panels which contain cards.
	 */
	private JPanel cardPanel;
	
	/**
	 * A panel for the house's cards to be displayed.
	 */
	private JPanel housePanel;
	
	/**
	 * A panel for the player's cards to be displayed.
	 */
	private JPanel playerPanel;
	
	/**
	 * A panel for the buttons the user must use to play the game.
	 */
	private JPanel buttonPanel;
	
	/**
	 * A panel which holds the score for both the player and the house.
	 */
	private JPanel scorePanel;
	
	/**
	 * A blank score panel which hides the score panel while the user logs in.
	 */
	private JPanel tempScorePanel;
	
	/**
	 * A panel that holds the amount of chips the player has and their bet selection.
	 */
	private JPanel chipPanel;
	
	/**
	 * A layout manager for the panel. Uses constraints between components to align or spring from edges.
	 */
	private SpringLayout layout;
	
	/**
	 * The image of the face down card.
	 */
	private ImageIcon faceDownCardIcon;
	
	/**
	 * A label used to hold the image of a face down card.
	 */
	private JLabel faceDownCard;
	
	/**
	 * An ArrayList of labels to hold the images of the player's cards.
	 */
	private ArrayList<JLabel> playerLabelList;
	
	/**
	 * An ArrayList of labels to hold the images of the house's cards.
	 */
	private ArrayList<JLabel> houseLabelList;
	
	/**
	 * A button used to login before the game begins.
	 */
	private JButton loginButton;
	
	/**
	 * A button used to double a player's bet and deal one card to the player.
	 */
	private JButton doubleButton;
	
	/**
	 * A button used to deal one card to the player.
	 */
	private JButton hitButton;
	
	/**
	 * A button used to end the player's turn.
	 */
	private JButton standButton;
	
	/**
	 * A button used to play the Blackjack game again.
	 */
	private JButton playAgainButton;
	
	/**
	 * A button used to submit the player's chosen bet of chips.
	 */
	private JButton submitBetButton;
	
	/**
	 * A button used to exit the game and save the player's username and chip amount.
	 */
	private JButton exitAndSaveButton;
	
	/**
	 * A button used to confirm the chosen theme for the cards in the Blackjack game.
	 */
	private JButton confirmThemeButton;
	
	/**
	 * An array of available themes of cards for the player.
	 */
	private String [] themeArray = {"Default", "Deadpool"};
	
	/**
	 * A selection box for the user to select a theme.
	 */
	private JComboBox<String> themeSelectorBox;
	
	/**
	 * A text area that displays the house's score.
	 */
	private JTextArea houseScoreText;
	
	/**
	 * A text area that displays the player's score.
	 */
	private JTextArea playerScoreText;
	
	/**
	 * A text area that displays the player's chip amount.
	 */
	private JTextArea chipNumberText;
	
	/**
	 * A selection box for the user to select a bet.
	 */
	private JTextArea betSelectorText;
	
	/**
	 * A text area of starting instructions for the user
	 */
	private JTextArea instructionText;
	
	/**
	 * A text area that instructs the user to select a theme.
	 */
	private JTextArea themeText;
	
	/**
	 * A text area that instructs the user to input a username.
	 */
	private JTextArea loginText;
	
	/**
	 * A text area that instructs the user to input a password.
	 */
	private JTextArea passwordText;
	
	/**
	 * A text field that the user inputs a username into.
	 */
	private JTextField loginField;
	
	/**
	 * A password field that the user inputs a password into.
	 */
	private JPasswordField passwdField;
	
	/**
	 * A text area that displays if the user inputs an incorrect password.
	 */
	private JTextArea incorrectPasswordText;
	
	/**
	 * An array of bet amounts that will be displayed to the user via selection box.
	 */
	private String [] chipBetsArray = {"5 Chips", "10 Chips", "25 Chips", "50 Chips", "100 Chips"};
	
	/**
	 * A selection box that displays an array of bet amounts to the user.
	 */
	private JComboBox<Integer> betSelectorBox;
	
	/**
	 * Determines whether to pass in-game methods to either the player or the house.
	 */
	private String playerOrHouse;
	
	/**
	 * The username the user input.
	 */
	private String userid;
	
	/**
	 * The password the user input.
	 */
	private String passwd;
	
	/**
	 * The player's score which is displayed via text area.
	 */
	private int playerScore;
	
	/**
	 * The house's score which is displayed via text area.
	 */
	private int houseScore;
	
	/**
	 * The status of the game represented as an integer.
	 * 0 = Game is NOT over, 1 = House wins, 2 = Player wins, 3 = Push
	 */
	private int gameStatus;
	
	/**
	 * The house's actual score while the house's second card remains face down.
	 */
	private int realHouseScore;
	
	/**
	 * The amount of aces the house has in it's hand.
	 */
	private int houseAces;
	
	/**
	 * The amount of aces the player has in their hand.
	 */
	private int playerAces;
	
	/**
	 * The amount of chips the player has.
	 */
	private double chipNumber;
	
	/**
	 * The amount the player chose to bet.
	 */
	private double chipBet;
	
	/**
	 * Whether or not the game is themed.
	 */
	private boolean isThemed;
	
	/**
	 * Whether or not the house has Blackjack.
	 */
	private boolean houseBlackjack;
	
	/**
	 * Whether or not the player has Blackjack.
	 */
	private boolean playerBlackjack;
	
	/**
	 * Whether or not it is both the house and player's first hand.
	 */
	private boolean ifFirstHand;
	
	/**
	 * Whether or not it is the player's turn. The player only has one turn per game.
	 */
	private boolean ifPlayerTurn;
	
	/**
	 * Builds the FinalPanel. Calls methods to initialize all data members, set up the login, panel, listeners, and layout.
	 * @param controller: Reference to the Blackjack game passed when the FinalPanel is instantiated in the FinalFrame.
	 */
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
	
	/**
	 * Initializes all data members.
	 */
	private void addAllElements()
	{
		this.layout = new SpringLayout();
		this.startPanel = new JPanel();
		this.loginPanel = new JPanel(new GridLayout (0,1));
		this.themePanel = new JPanel(new GridLayout(0,1));
		this.cardPanel = new JPanel(new GridLayout (0,1));
		this.housePanel = new JPanel();
		this.playerPanel = new JPanel();
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
		this.betSelectorBox = new JComboBox(chipBetsArray);
		this.betSelectorText = new JTextArea("Select your bet: ");
		this.houseScoreText = new JTextArea("House Score: ");
		this.playerScoreText = new JTextArea("Your Score: ");
		this.chipNumberText = new JTextArea("Your Chips: " + chipNumber);
		this.instructionText = new JTextArea("LOGIN INSTRUCTIONS:\nIf it is your first time playing, create a login below and begin playing!\nOtherwise, you may use a previous login to play!");
		this.themeText = new JTextArea("Choose your theme:");
		this.loginText = new JTextArea("Username: ");
		this.passwordText = new JTextArea("Password : ");
		this.loginField = new JTextField("");
		this.passwdField = new JPasswordField("");
		this.incorrectPasswordText = new JTextArea("Incorrect Password!");
		this.faceDownCard = new JLabel();
		this.playerLabelList = new ArrayList<JLabel>();
		this.houseLabelList = new ArrayList<JLabel>();
		this.cardValues = new ArrayList<Integer>();
		this.playerScore = 0;
		this.houseScore = 0;
		this.chipBet = 0;
		this.playerAces = 0;
		this.houseAces = 0;
		this.realHouseScore = 0;
		this.gameStatus = 0;
		this.playerBlackjack = false;
		this.houseBlackjack = false;
	}
	
	/**
	 * Creates the login screen and sets up the listener for the theme button.
	 */
	private void setupLogin()
	{
		instructionText.setEditable(false);
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
					loginButton.setEnabled(true);
					confirmThemeButton.setEnabled(false);
					themeSelectorBox.setEnabled(false);
				}
				else if (themeSelectorBox.getSelectedIndex() == 1)
				{
					setupLoginListeners();
					System.out.println("Cards are deadpool");
					isThemed = true;
					loginButton.setEnabled(true);
					confirmThemeButton.setEnabled(false);
					themeSelectorBox.setEnabled(false);
				}
			}
		});
	}
	
	/**
	 * Sets up login button listener and starts the Blackjack game. 
	 */
	private void setupLoginListeners()
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
	
	/**
	 * Sets up the submit bet button listener.
	 */
	private void setupBet()
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
					ifPlayerTurn = true;
					ifFirstHand = true;
					standButton.setEnabled(false);
					hitButton.setEnabled(false);
					doubleButton.setEnabled(false);
					betSelectorBox.setEnabled(false);
					playAgainButton.setEnabled(false);
					exitAndSaveButton.setEnabled(false);
					playerPanel.setVisible(true);
					housePanel.setVisible(true);
					scorePanel.setVisible(true);
					playerStand();
					if(playerBlackjack == true && houseBlackjack == true)
					{
						chipNumber += chipBet;
						chipNumberText.setText("Your Chips: " + chipNumber);
					}
					else if(playerBlackjack == true && houseBlackjack != true)
					{
						if (playerBlackjack == true)
						{
							chipNumber += (2 * chipBet) + (0.5 * chipBet);
						}
						else
						{
							chipNumber += 2 * chipBet;
						}
						chipNumber += chipBet;
						chipNumberText.setText("Your Chips: " + chipNumber);
					}
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
	
	/**
	 * Sets up listeners for the double, hit, stand, play again, and save and exit buttons.
	 */
	private void setupListeners()
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
	
	/**
	 * Calculates the score for the player and the house.
	 * @param ifPlayerTurn: Checks whether or not it is the player's turn.
	 * @param ifFirstHand: Checks whether or not it is the house and player's first hand.
	 */
	private void calculateScore(boolean ifPlayerTurn, boolean ifFirstHand)
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
		//Checking for all game outcomes below
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
		
		//Checking for push, player win, or house win after no more cards can be dealt.
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
				standButton.setEnabled(false);
				hitButton.setEnabled(false);
				doubleButton.setEnabled(false);
				playAgainButton.setEnabled(false);
				exitAndSaveButton.setEnabled(false);
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
				standButton.setEnabled(false);
				hitButton.setEnabled(false);
				doubleButton.setEnabled(false);
				playAgainButton.setEnabled(false);
				exitAndSaveButton.setEnabled(false);
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
	
	/**
	 * Deals the four cards. Two to the player and two to the house.
	 * @param isThemed: Checks whether or not the game is themed.
	 */
	private void firstDeal(boolean isThemed)
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
	
	/**
	 * Deals a card to either the player or the house.
	 * @param playerOrHouse: Checks who to deal the card to. 
	 */
	private void dealNextCard(String playerOrHouse)
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
	
	/**
	 * Decides what the house should do during it's turn when called.
	 */
	private void houseTurn()
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
	
	/**
	 * Called when the player stands. Reveals the house's second card and disables/enables necessary buttons.
	 */
	private void playerStand()
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
	
	/**
	 * Calculates the player's bet against the game's outcome and displays to the user their amount of chips.
	 * @param gameStatus: The status of the game represented as an integer.
	 * @param playerBlackjack: Whether or not the player has Blackjack.
	 */
	private void settleBet(int gameStatus, boolean playerBlackjack)
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
		System.out.println("hit button enabled2?: " + hitButton.isEnabled());
	}
	
	/**
	 * Called when the user clicks the play again button. Restarts the game.
	 */
	private void playAgain()
	{
		housePanel.removeAll();
		playerPanel.removeAll();
		buttonPanel.removeAll();
		scorePanel.removeAll();
		chipPanel.removeAll();
		controller.createDeck(isThemed);
		controller.shuffleCards(isThemed);
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
	
	/**
	 * Calculates the chip bet and amount when the user selects and confirms their chosen bet. Displays the user's amount of chips.
	 */
	private void betSelected()
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
		if (chipNumber < 0)
		{
			chipNumber = 1000;
			chipNumberText.setText("Your Chips: " + chipNumber + " (ur welcome)");
		}
		chipNumberText.setText("Your Chips: " + chipNumber);
	}
	
	/**
	 * Helper method to set up the main panel for the Blackjack game.
	 */
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(Color.DARK_GRAY);
		this.add(cardPanel);
		cardPanel.add(housePanel);
		cardPanel.add(playerPanel);
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
		cardPanel.setBackground(new Color(0, 153, 0));
		housePanel.setBackground(new Color(0, 153, 0));
		playerPanel.setBackground(new Color(0, 153, 0));
	}
	
	/**
	 * Helper method to hold all the constraints for the GUI components in the panel.
	 */
	private void setupLayout()
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
}
