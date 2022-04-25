package fin.tests; //Change!

/**
 * Project imports
 */
import fin.controller.FinalController; //Change!
import fin.view.FinalPanel; //Change!
import fin.view.FinalFrame; //Change!
import javax.swing.*;

import java.awt.Component;
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

class FrameTest
{
	private FinalController testedController; //Change!
	private FinalFrame testedFrame; //Change!

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new FinalController();
		this.testedFrame = new FinalFrame(testedController);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		assertTrue(testedFrame instanceof JFrame, "... needs to extend JFrame");
		Method [] methods = testedFrame.getClass().getDeclaredMethods();
		assertTrue(methods.length == 1, "You need 1 method in the ChatFrame");
		assertTrue(testedFrame.getTitle().length() > 5, "Your title needs at least 6 letters");
		assertTrue(testedFrame.getContentPane() instanceof FinalPanel, "Your ChatFrame needs to have a ChatPanel inside");  //Change!
	}

}