package fin.view;

import java.awt.Color;

import javax.swing.*;

import fin.controller.FinalController;

public class FinalPanel extends JPanel
{
	private FinalController controller;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void setupPanel()
	{
		Color prettyPink = new Color(255, 204, 255);
		this.setBackground(prettyPink);
	}
	
	public void setupListeners()
	{
		
	}
	
	public void setupLayout()
	{
		
	}
}
