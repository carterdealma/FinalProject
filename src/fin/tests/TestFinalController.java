package fin.tests; //Change me


/**
 * Project imports
 */
import fin.controller.FinalController; //Change me
import fin.view.FinalPanel; //Change me
import javax.swing.*;

import java.awt.*;
/**
 * Reflection imports
 */
import java.lang.reflect.*;
/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFinalController
{
	private FinalController testedController; //Change me
	private FinalPanel testedPanel; //Change me

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new FinalController(); //Change me
		this.testedPanel = new FinalPanel(testedController); //Change me
	} 

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedPanel = null;
	}
	
	@Test
	void testControllerMethods()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();
		boolean hasCreateDeck = false;
		boolean hasShuffleCards = false;
		boolean hasAuthenticateUser = false;
		
		for(Method method : methods)
		{
			if (method.getName().equals("createDeck"))
			{
				hasCreateDeck = true;
			}
			else if (method.getName().equals("shuffleCards"))
			{
				hasShuffleCards = true;
			}
			else if (method.getName().equals("authenticateUser"))
			{
				hasAuthenticateUser = true;
			}
		}
		
		assertTrue(hasCreateDeck, "You need a method named createDeck");
		assertTrue(hasShuffleCards, "You need a method named shuffleCards");
		assertTrue(hasAuthenticateUser, "You need a method named authenticateUser");
	}

	@Test
	void testPanelMethods()
	{
		Method [] methods = testedPanel.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 4, "You need at least 3 methods in the controller");
		boolean hasSetupPanel = false;
		boolean hasSetupListeners = false;
		boolean hasSetupLayout = false;
		
		for (Method method : methods)
		{
			if (method.getName().equals("setupPanel"))
			{
				hasSetupPanel = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupPanel method must be private");
			}
			else if (method.getName().equals("setupListeners"))
			{
				hasSetupListeners = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupListeners method must be private");
			}
			else if (method.getName().equals("setupLayout"))
			{
				hasSetupLayout = true;
				assertTrue(Modifier.isPrivate(method.getModifiers()), "The setupLayout method must be private");
			}
		}
		assertTrue(hasSetupPanel, "You need a method named setupPanel");
		assertTrue(hasSetupListeners, "You need a method named setupListeners");
		assertTrue(hasSetupLayout, "You need a method named setupLayout");
	}
	
	@Test
	void testPanelComponents()
	{
		Field [] fields = testedPanel.getClass().getDeclaredFields();
		assertTrue(fields.length > 2, "You need at least 3 data members in your ChatPanel");
		
		int buttonCount = 0;
		
		boolean hasCorrectLayout = false;
		
		if(testedPanel.getLayout() instanceof SpringLayout)
		{
			hasCorrectLayout = true;
		}
		
		Component [] components = testedPanel.getComponents();
		
		
		for(Component component : components)
		{
			if (component instanceof JButton)
			{
				buttonCount++;
				JButton tested = (JButton)component;
				assertTrue(tested.getActionListeners().length == 1, "Each button needs a listener");
			}			
			
		}

		assertTrue(hasCorrectLayout, "The layout needs to be a SpringLayout");

	}

}
