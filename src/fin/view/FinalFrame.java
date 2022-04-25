package fin.view;

import javax.swing.*;

import fin.controller.FinalController;

public class FinalFrame extends JFrame
{
	private FinalController controller;
	private FinalPanel panel;
	
	public FinalFrame(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.panel = new FinalPanel(this.controller);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Single Player Blackjack");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
