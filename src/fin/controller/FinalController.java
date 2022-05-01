package fin.controller;

import fin.view.*;
import fin.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.io.*; 

public class FinalController
{
	/**
	 * The GUI frame for the game of Blackjack.
	 */
	private FinalFrame frame;
	
	private Card defaultCard;
	
	private DeadpoolCard deadpoolCard;
	
	/**
	 * The ArrayList of Card values that make up Blackjack.
	 */
	private ArrayList<Card> cardList;
	
	private HashMap<String, String> userData;
	
	private HashMap<String, String> userPasswd;
	
	private File saveFile;
	
	private File passwdFile;
	
	/**
	 * Starts the GUI
	 */
	public FinalController()
	{
		this.passwdFile = new File("blackjack.passwd");
		this.saveFile = new File("blackjack.save");
		this.userPasswd = new HashMap<String, String>();
		this.userData = new HashMap<String, String>();
		this.cardList = new ArrayList<Card>();
		fillAndShuffle("default");
		this.frame = new FinalFrame(this);
	}
	
	/**
	 * Prepares the game of Blackjack by re-initializing the cardList
	 */
	public void start()
	{
		
	}
	
	/**
	 * Adds all 52 cards to the Blackjack cardList and shuffles them and returns the shuffled deck
	 * @return A shuffled deck of Cards
	 */
	public void fillAndShuffle(String theme)
	{
		
		Card aceC = new Card("AC", 1, theme);
		Card aceD = new Card("AD", 1, theme);
		Card aceH = new Card("AH", 1, theme);
		Card aceS = new Card("AS", 1, theme);
		Card twoC = new Card("2C", 2, theme);
		Card twoD = new Card("2D", 2, theme);
		Card twoH = new Card("2H", 2, theme);
		Card twoS = new Card("2S", 2, theme);
		Card threeC = new Card("3C", 3, theme);
		Card threeD = new Card("3D", 3, theme);
		Card threeH = new Card("3H", 3, theme);
		Card threeS = new Card("3S", 3, theme);
		Card fourC = new Card("4C", 4, theme);
		Card fourD = new Card("4D", 4, theme);
		Card fourH = new Card("4H", 4, theme);
		Card fourS = new Card("4S", 4, theme);
		Card fiveC = new Card("5C", 5, theme);
		Card fiveD = new Card("5D", 5, theme);
		Card fiveH = new Card("5H", 5, theme);
		Card fiveS = new Card("5S", 5, theme);
		Card sixC = new Card("6C", 6, theme);
		Card sixD = new Card("6D", 6, theme);
		Card sixH = new Card("6H", 6, theme);
		Card sixS = new Card("6S", 6, theme);
		Card sevenC = new Card("7C", 7, theme);
		Card sevenD = new Card("7D", 7, theme);
		Card sevenH = new Card("7H", 7, theme);
		Card sevenS = new Card("7S", 7, theme);
		Card eightC = new Card("8C", 8, theme);
		Card eightD = new Card("8D", 8, theme);
		Card eightH = new Card("8H", 8, theme);
		Card eightS = new Card("8S", 8, theme);
		Card nineC = new Card("9C", 9, theme);
		Card nineD = new Card("9D", 9, theme);
		Card nineH = new Card("9H", 9, theme);
		Card nineS = new Card("9S", 9, theme);
		Card tenC = new Card("10C", 10, theme);
		Card tenD = new Card("10D", 10, theme);
		Card tenH = new Card("10H", 10, theme);
		Card tenS = new Card("10S", 10, theme);
		Card kingC = new Card("KC", 10, theme);
		Card kingD = new Card("KD", 10, theme);
		Card kingH = new Card("KH", 10, theme);
		Card kingS = new Card("KS", 10, theme);
		Card queenC = new Card("QC", 10, theme);
		Card queenD = new Card("QD", 10, theme);
		Card queenH = new Card("QH", 10, theme);
		Card queenS = new Card("QS", 10, theme);
		Card jackC = new Card("JC", 10, theme);
		Card jackD = new Card("JD", 10, theme);
		Card jackH = new Card("JH", 10, theme);
		Card jackS = new Card("JS", 10, theme);
		cardList.add(aceC);
		cardList.add(aceD);
		cardList.add(aceH);
		cardList.add(aceS);
		cardList.add(twoC);
		cardList.add(twoD);
		cardList.add(twoH);
		cardList.add(twoS);
		cardList.add(threeC);
		cardList.add(threeD);
		cardList.add(threeH);
		cardList.add(threeS);
		cardList.add(fourC);
		cardList.add(fourD);
		cardList.add(fourH);
		cardList.add(fourS);
		cardList.add(fiveC);
		cardList.add(fiveD);
		cardList.add(fiveH);
		cardList.add(fiveS); 
		cardList.add(sixC);
		cardList.add(sixD);
		cardList.add(sixH);
		cardList.add(sixS);
		cardList.add(sevenC);
		cardList.add(sevenD);
		cardList.add(sevenH);
		cardList.add(sevenS);
		cardList.add(eightC);
		cardList.add(eightD);
		cardList.add(eightH);
		cardList.add(eightS);
		cardList.add(nineC);
		cardList.add(nineD);
		cardList.add(nineH);
		cardList.add(nineS);
		cardList.add(tenC);
		cardList.add(tenD);
		cardList.add(tenH);
		cardList.add(tenS);
		cardList.add(kingC);
		cardList.add(kingD);
		cardList.add(kingH);
		cardList.add(kingS);
		cardList.add(queenC);
		cardList.add(queenD);
		cardList.add(queenH);
		cardList.add(queenS);
		cardList.add(jackC);
		cardList.add(jackD);
		cardList.add(jackH);
		cardList.add(jackS);
		
		Collections.shuffle(cardList);
	}
	
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
	
	public int readUserData(String userKey)
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
				int chipAmount = 1000;
				return chipAmount;
			}
			else
			{
				int chipAmount = Integer.parseInt(userData.get(userKey));
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
	
	public void cardPlayed()
	{
		cardList.remove(0);
	}
	
	public String sendName()
	{
		return cardList.get(0).getName();
	}
	
	public int sendValue()
	{
		return cardList.get(0).getValue();
	}
	
	public void originalCardChosen()
	{
		Card defaultCard = new Card("Card", 99, "default");
		fillAndShuffle(defaultCard.getTheme());
	}
	
	public void deadpoolCardChosen()
	{
		DeadpoolCard deadpoolCard = new DeadpoolCard("DeadpoolCard", 200, "deadpool");
		fillAndShuffle(deadpoolCard.getTheme());
	}
	
	public String deadpoolCardPath()
	{
		return "/fin/view/deadpool/";
	}

}
