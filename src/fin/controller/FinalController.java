package fin.controller;

import fin.view.*;
import fin.model.*;

import java.util.Collections;
import java.util.ArrayList;

public class FinalController
{
	/**
	 * The GUI frame for the game of Blackjack.
	 */
	private FinalFrame frame;
	
	/**
	 * The ArrayList of Card values that make up Blackjack.
	 */
	private ArrayList<Card> cardList;
	
	/**
	 * Starts the GUI
	 */
	public FinalController()
	{
		this.frame = new FinalFrame(this);
	}
	
	/**
	 * Prepares the game of Blackjack by re-initializing the cardList
	 */
	public void start()
	{
		this.cardList = new ArrayList<Card>();
		fillAndShuffle();
	}
	
	/**
	 * Adds all 52 cards to the Blackjack cardList and shuffles them
	 */
	public void fillAndShuffle()
	{
		Card aceC = new Card("AC", 1);
		Card aceD = new Card("AD", 1);
		Card aceH = new Card("AH", 1);
		Card aceS = new Card("AS", 1);
		Card twoC = new Card("2C", 2);
		Card twoD = new Card("2D", 2);
		Card twoH = new Card("2H", 2);
		Card twoS = new Card("2S", 2);
		Card threeC = new Card("3C", 3);
		Card threeD = new Card("3D", 3);
		Card threeH = new Card("3H", 3);
		Card threeS = new Card("3S", 3);
		Card fourC = new Card("4C", 4);
		Card fourD = new Card("4D", 4);
		Card fourH = new Card("4H", 4);
		Card fourS = new Card("4S", 4);
		Card fiveC = new Card("5C", 5);
		Card fiveD = new Card("5D", 5);
		Card fiveH = new Card("5H", 5);
		Card fiveS = new Card("5S", 5);
		Card sixC = new Card("6C", 6);
		Card sixD = new Card("6D", 6);
		Card sixH = new Card("6H", 6);
		Card sixS = new Card("6S", 6);
		Card sevenC = new Card("7C", 7);
		Card sevenD = new Card("7D", 7);
		Card sevenH = new Card("7H", 7);
		Card sevenS = new Card("7S", 7);
		Card eightC = new Card("8C", 8);
		Card eightD = new Card("8D", 8);
		Card eightH = new Card("8H", 8);
		Card eightS = new Card("8S", 8);
		Card nineC = new Card("9C", 9);
		Card nineD = new Card("9D", 9);
		Card nineH = new Card("9H", 9);
		Card nineS = new Card("9S", 9);
		Card tenC = new Card("10C", 10);
		Card tenD = new Card("10D", 10);
		Card tenH = new Card("10H", 10);
		Card tenS = new Card("10S", 10);
		Card kingC = new Card("KC", 10);
		Card kingD = new Card("KD", 10);
		Card kingH = new Card("KH", 10);
		Card kingS = new Card("KS", 10);
		Card queenC = new Card("QC", 10);
		Card queenD = new Card("QD", 10);
		Card queenH = new Card("QH", 10);
		Card queenS = new Card("QS", 10);
		Card jokerC = new Card("JC", 10);
		Card jokerD = new Card("JD", 10);
		Card jokerH = new Card("JH", 10);
		Card jokerS = new Card("JS", 10);
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
		cardList.add(jokerC);
		cardList.add(jokerD);
		cardList.add(jokerH);
		cardList.add(jokerS);
		Collections.shuffle(cardList);
	}
}
