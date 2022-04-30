package fin.controller;

import fin.view.FinalFrame;
import fin.view.FinalPanel;

import java.util.*;

public class IOController 
{
	private FinalPanel panel;
	private Hashtable<String, Integer> userData = new Hashtable<String, Integer>();
	
	public void updateUserData(String user, int chips)
	{
		userData.put(user, chips);
		System.out.println("UserData:" + userData);
	}
	
	public void sayGoodbye()
	{
		System.out.println("Goodbye!");
	}
	
	public static void saveData(String userid, String userChips)
	{
		
	}
}
