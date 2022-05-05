package fin.controller;

import fin.view.*;
import fin.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.io.*; 
import javax.swing.*;

public class FinalController
{
	/**
	 * Instance of the "Card" object from the model.
	 */
	private Card card;
	
	/**
	 * Instance of the "DeadpoolCard" object from the model.
	 */
	private DeadpoolCard dpCard;
	
	/**
	 * Instance of the "DealtCard" object from the model. Used to create an ArrayList of dealt cards.
	 */
	private DealtCard dealtCard;
	
	/**
	 * The array of card faces used to create the deck
	 */
	String [] cardFace = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	
	/**
	 * The array of card suits used to create the deck
	 */
	String [] cardSuit = {"C", "D", "H", "S"};
	
	/**
	 * The array of card values used to create the deck
	 */
	int [] cardValue = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	/**
	 * The ArrayList of Card values that make up Blackjack if the player selects the default theme.
	 */
	private ArrayList<Card> cardList;
	
	/**
	 * The ArrayList of DeadpoolCard values that make up Blackjack if the player selects the Deadpool theme.
	 */
	private ArrayList<DeadpoolCard> dpCardList;
	
	
	/**
	 * The ArrayList of DealtCard values that make up the cards that have been dealt to the player.
	 */
	private ArrayList<DealtCard> playerCardList;
	
	/**
	 * The ArrayList of DealtCard values that make up the cards that have been dealt to the house.
	 */
	private ArrayList<DealtCard> houseCardList;
	
	/**
	 * The HashMap which holds the user's username, (as the key) and amount of chips (as the value).
	 */
	private HashMap<String, String> userData;
	
	/**
	 * The HashMap which holds the user's username, (as the key) and encrypted password (as the value).
	 */
	private HashMap<String, String> userPasswd;
	
	/**
	 * File that the userData HashMap writes to. Keeps saved usernames and chip amounts.
	 */
	private File saveFile;
	
	/**
	 * File that the userPasswd HashMap writes to. Keeps saved usernames and encrypted passwords.
	 */
	private File passwdFile;
	
	/**
	 * The GUI frame for the game of Blackjack.
	 */
	private FinalFrame frame;
	
	/**
	 * Starts the GUI and initializes data structures and files.
	 */
	public FinalController()
	{
		this.cardList = new ArrayList<Card>();
		this.dpCardList = new ArrayList<DeadpoolCard>();
		this.playerCardList = new ArrayList<DealtCard>();
		this.houseCardList = new ArrayList<DealtCard>();
		this.passwdFile = new File("blackjack.passwd");
		this.saveFile = new File("blackjack.save");
		this.userPasswd = new HashMap<String, String>();
		this.userData = new HashMap<String, String>();
		this.cardList = new ArrayList<Card>();
		this.frame = new FinalFrame(this);
	}
	
	/**
	 * Called by the runner to start the game of Blackjack.
	 */
	public void start()
	{
		
	}
	
	/**
	 * Adds all 52 cards to the correctly themed Blackjack deck.
	 * @Param isThemed: Checks if the game is themed.
	 */
	public void createDeck(boolean isThemed)
	{
		if (isThemed)
		{
			for (String suit : cardSuit)
			{
				for (int index = 0; index < cardFace.length - 1; index++)
				{
					DeadpoolCard dpCard = new DeadpoolCard(cardFace[index] + suit, cardValue[index], "/fin/view/deadpool/");
					dpCardList.add(dpCard);
				}
			}
		}
		else
		{
			for (String suit : cardSuit)
			{
				for (int index = 0; index < cardFace.length - 1; index++)
				{
					Card card = new Card(cardFace[index] + suit, cardValue[index], "/fin/view/images/");
					cardList.add(card);
				}
			}
		}
	}
	
	/**
	 * Shuffles all 52 cards in the correctly themed Blackjack deck.
	 * @param isThemed: Checks if the game is themed.
	 */
	public void shuffleCards(boolean isThemed)
	{
		if (isThemed)
		{
			Collections.shuffle(dpCardList);
		}
		else
		{
			Collections.shuffle(cardList);
		}
	}
	
	/**
	 * 
	 * Updates the userData HashMap and saves the HashMap to a file after user has saved and quit the game.
	 * @param user: Username that the player entered.
	 * @param chips: Amount of chips the player has.
	 */
	public void updateUserData(String user, String chips)
	{
		userData.put(user, chips);
		Properties properties = new Properties();
		properties.putAll(userData);
		try 
		{
			properties.store(new FileOutputStream(saveFile), null);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds the user's data to a HashMap if it's the user's first time playing. Otherwise, it retrieves the user's amount of chips.
	 * @param userKey: Username that the player entered.
	 * @return returns the amount of chips the user has.
	 */
	public double readUserData(String userKey)
	{
		System.out.println("saveFile is:" + saveFile);
		if (saveFile.exists())
		{
			Properties properties = new Properties();
			try 
			{
				properties.load(new FileInputStream(saveFile));
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			for (String key : properties.stringPropertyNames())
			{
				userData.put(key, properties.get(key).toString());
			}
			System.out.println("Read userData: " + userData);
			if (userData.get(userKey) == null)
			{
				double chipAmount = 1000;
				return chipAmount;
			}
			else
			{
				double chipAmount = Double.parseDouble(userData.get(userKey));
				System.out.println("Chip Amount:" + chipAmount);
				return chipAmount;
			}
		}
		else
		{
			try 
			{
				saveFile.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return 1000;
		}
	}
	
	/**
	 * Updates the user's username and password via HashMap to a file.
	 * @param userid: The username the user input.
	 * @param encryptedPasswd: The encrypted password created in authenticateUser.
	 */
	public void updatePasswdData(String userid, String encryptedPasswd)
	{
		userPasswd.put(userid, encryptedPasswd);
		Properties properties = new Properties();
		properties.putAll(userPasswd);
		try 
		{
			properties.store(new FileOutputStream(passwdFile), null);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Encrypts the user's password and checks it against the encrypted password which was previously saved to blackjack.passwd unless it is the user's first time.
	 * @param userid: The username the user input.
	 * @param passwd: The password the user input.
	 * @return
	 */
	public boolean authenticateUser(String userid, String passwd)
	{
		String saltValue = EncryptPassword.getSaltvalue(27);
		System.out.println("Salt: " + saltValue);
		String encryptedPassword = EncryptPassword.generateSecurePassword(passwd, saltValue);
		String saltEncryptedPassword = saltValue + encryptedPassword;
		System.out.println("User id:" + userid);
		System.out.println("password:" + passwd);
		System.out.println("encrypted password:" + encryptedPassword);
		System.out.println("salt encrypted password:" + saltEncryptedPassword);
		if (passwdFile.exists())
		{
			Properties properties = new Properties();
			try 
			{
				properties.load(new FileInputStream(passwdFile));
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			for (String key : properties.stringPropertyNames())
			{
				userPasswd.put(key, properties.get(key).toString());
			}
			System.out.println("Read userData: " + userPasswd);
			if (userPasswd.get(userid) == null)
			{
				updatePasswdData(userid, saltEncryptedPassword);
				return true;
			}
			else
			{
				System.out.println("password entered: " + passwd);
				System.out.println("password encrypted: " + encryptedPassword);
				System.out.println("password stored: " + userPasswd.get(userid));
				String storedHash = userPasswd.get(userid);
				String storedSaltValue = storedHash.substring(0, 27);
				System.out.println("stored salt value: " + storedSaltValue);
				String storedEncryptedPassword = storedHash.substring(27, storedHash.length());
				System.out.println("Stored encrypted password:" + storedEncryptedPassword);
				encryptedPassword = EncryptPassword.generateSecurePassword(passwd, storedSaltValue);
				if (encryptedPassword.equals(storedEncryptedPassword))
				{
					System.out.println("Password match");
					return true;
				}
				else
				{
					System.out.println("Password incorrect");
					return false;
				}
			}
		}
		else
		{
			try 
			{
				passwdFile.createNewFile();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			updatePasswdData(userid, passwd);
			System.out.println("user did not exist, created");
			return true;
		}
	}
	
	/**
	 * Removes a card from the deck when a card is played.
	 * @param isThemed: Checks if the game is themed.
	 */
	public void cardPlayed(boolean isThemed)
	{
		if (isThemed)
		{
			dpCardList.remove(0);
		}
		else
		{
			cardList.remove(0);
		}
	}
	
	/**
	 * Deals a card to the player or house.
	 * @param isThemed: Checks if the game is themed.
	 * @param playerOrHouse Checks who to deal the card to.
	 */
	public void dealCard(boolean isThemed, String playerOrHouse)
	{
		DealtCard dealtCard = new DealtCard("a", 1);
		if (isThemed)
		{
			dealtCard.setName(dpCardList.get(0).getName());
			dealtCard.setValue(dpCardList.get(0).getValue());
			dealtCard.setImage(dpCardList.get(0).getPath(), dpCardList.get(0).getName());
			System.out.println("dpCardList.get(0)'s path: " + dpCardList.get(0).getPath());
			dpCardList.remove(0);
			if (playerOrHouse == "player")
			{
				playerCardList.add(dealtCard);
			}
			else
			{
				houseCardList.add(dealtCard);
			}
			
		}
		else
		{
			dealtCard.setName(cardList.get(0).getName());
			dealtCard.setValue(cardList.get(0).getValue());
			dealtCard.setImage(cardList.get(0).getPath(), cardList.get(0).getName());
			cardList.remove(0);
			if (playerOrHouse == "player")
			{
				playerCardList.add(dealtCard);
			}
			else
			{
				houseCardList.add(dealtCard);
			}
		}
	}
	
	/**
	 * Sends the card values in the player or house's hand when called.
	 * @param playerOrHouse: Checks whether to send the player or house's hand.
	 * @return Returns the player or house's card values.
	 */
	public ArrayList<Integer> sendCardValues(String playerOrHouse)
	{
		ArrayList<Integer> cardValues = new ArrayList<Integer>();
		if (playerOrHouse == "player")
		{
			for (DealtCard card : playerCardList)
			{
				cardValues.add(card.getValue());
			}
		}
		else
		{
			for (DealtCard card : houseCardList)
			{
				cardValues.add(card.getValue());
			}
		}
		return cardValues;
	}
	
	/**
	 * 
	 * @param isThemed
	 */
	public void resetGame(boolean isThemed)
	{
		if (isThemed)
		{
			if (dpCardList.size() < 15)
			{
				createDeck(isThemed);
				shuffleCards(isThemed);
			}
		}
		else
		{
			if (cardList.size() < 15)
			{
				createDeck(isThemed);
				shuffleCards(isThemed);
			}
		}
		playerCardList.clear();
		houseCardList.clear();
	}
	
	public String sendName(String playerOrHouse)
	{
		if (playerOrHouse == "player")
		{
			return playerCardList.get(playerCardList.size() - 1).getName();
		}
		else
		{
			return houseCardList.get(houseCardList.size() - 1).getName();
		}
	}
	
	public int sendValue(String playerOrHouse)
	{
		if (playerOrHouse == "player")
		{
			return playerCardList.get(playerCardList.size() - 1).getValue();
		}
		else
		{
			return houseCardList.get(houseCardList.size() - 1).getValue();
		}
	}
	
	public JLabel sendImage(String playerOrHouse)
	{
		if (playerOrHouse == "player")
		{
			return playerCardList.get(playerCardList.size() - 1).getImage();
		}
		else
		{
			return houseCardList.get(houseCardList.size() - 1).getImage();
		}
	}

}
