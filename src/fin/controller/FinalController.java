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
	 * The GUI frame for the game of Blackjack.
	 */
	
	private Card card;
	
	private DeadpoolCard dpCard;
	
	private DealtCard dealtCard;
	
	String [] cardFace = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
	
	String [] cardSuit = {"C", "D", "H", "S"};
	
	int [] cardValue = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	/**
	 * The ArrayList of Card values that make up Blackjack.
	 */
	private ArrayList<Card> cardList;
	
	private ArrayList<DeadpoolCard> dpCardList;
	
	private ArrayList<DealtCard> playerCardList;
	
	private ArrayList<DealtCard> houseCardList;
	
	private HashMap<String, String> userData;
	
	private HashMap<String, String> userPasswd;
	
	private File saveFile;
	
	private File passwdFile;
	
	private FinalFrame frame;
	
	/**
	 * Starts the GUI
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
	 * Called by the runner to start the game of Blackjack
	 */
	public void start()
	{
		
	}
	
	/**
	 * Adds all 52 cards to the correctly themed Blackjack deck
	 * @Param isThemed: Checks if the game is themed
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
	 * Shuffles all 52 cards in the correctly themed Blackjack deck
	 * @param isThemed: Checks if the game is themed
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
	 * Updates the userData HashMap and saves the HashMap to a file after user has saved and quit the game
	 * @param user: Username that the player entered
	 * @param chips: Amount of chips the player has
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
	 * @param userKey: Username that the player entered
	 * @return returns the amount of chips the user has
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
	 * Updates the user's username and password via HashMap to a file
	 * @param userid: The username the user input
	 * @param encryptedPasswd: The encrypted password created in authenticateUser
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
	
	public void updateCardValues(String playerOrHouse, ArrayList<Integer> newCardValues)
	{
		if (playerOrHouse == "player")
		{
			for (int index = 0; index < newCardValues.size() - 1; index++)
			{
				playerCardList.get(index).setValue(newCardValues.get(index));
			}
		}
		else
		{
			for (int index = 0; index < newCardValues.size() - 1; index++)
			{
				houseCardList.get(index).setValue(newCardValues.get(index));
			}
		}
	}
	
	public int sendLastCardValue(String playerOrHouse)
	{
		int lastCardValue = 0;
		if (playerOrHouse == "player")
		{
			lastCardValue = playerCardList.get(playerCardList.size() - 1).getValue();
		}
		else
		{
			lastCardValue = houseCardList.get(houseCardList.size() - 1).getValue();
		}
		return lastCardValue;
	}
	
	public void setCardValues (String playerOrHouse, ArrayList<Integer> newCardValues)
	{
		for (int card : newCardValues)
		{
			
		}
	}
	
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
