package fin.view;

import javax.swing.*;

import fin.controller.FinalController;

/**
 * GUI Frame class for the game of Blackjack.
 * @author Carter Ma
 *
 */
public class FinalFrame extends JFrame
{	
	//Data members for the JFrame subclass instance
	
	/**
	 * A reference to the FinalController instance.
	 */
	private FinalController controller;
	
	/**
	 * The instance of the panel used for playing the game.
	 */
	private FinalPanel panel;
	
	/**
	 * Builds an instance of the FinalFrame with a reference to the FinalController instance.
	 * @param controller A reference to a FinalController to share with the FinalPanel instance.
	 */
	public FinalFrame(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.panel = new FinalPanel(this.controller);
		
		setupFrame();
	}
	
	/*
	 * Configures the JFrame window subclass to add the panel, have a title, set the size, close when exited, and be visible to the user.
	 */
	public void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Single Player Blackjack");
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
