package fin.view;

import fin.controller.FinalController;

import java.awt.*;
import javax.swing.*;

public class FinalPanel extends JPanel
{
	private FinalController controller;
	
	private JPanel cardPanel;
	private SpringLayout layout;
	private JLabel houseImageLabel;
	private JLabel playerImageLabel;
	private ImageIcon playerFirstCard;
	private Image playerFirstCardImage;
	private Image playerFirstCardImageScaled;
	private ImageIcon playerFirstCardIcon;
	private ImageIcon houseFirstCard;
	private Image houseFirstCardImage;
	private Image houseFirstCardImageScaled;
	private ImageIcon houseFirstCardIcon;
	private JButton hitButton;
	
	public FinalPanel(FinalController controller)
	{
		super();
		
		this.controller = controller;
		this.layout = new SpringLayout();
		this.cardPanel = new JPanel(new GridLayout (0,1));
		layout.putConstraint(SpringLayout.WEST, cardPanel, 30, SpringLayout.WEST, this);
		this.hitButton = new JButton("Hit");
		this.playerFirstCard = new ImageIcon(getClass().getResource("/fin/view/images/" + "8H" + ".png"));
		this.playerFirstCardImage = playerFirstCard.getImage();
		this.playerFirstCardImageScaled = playerFirstCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
		this.playerFirstCardIcon = new ImageIcon(playerFirstCardImageScaled);
		this.houseFirstCard = new ImageIcon(getClass().getResource("/fin/view/images/" + "7S" + ".png"));
		this.houseFirstCardImage = houseFirstCard.getImage();
		this.houseFirstCardImageScaled = houseFirstCardImage.getScaledInstance(120, 180, Image.SCALE_SMOOTH);
		this.houseFirstCardIcon = new ImageIcon(houseFirstCardImageScaled);
		this.houseImageLabel = new JLabel();
		this.playerImageLabel = new JLabel();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	public void setupPanel()
	{
		this.setLayout(layout);
		Color prettyPink = new Color(255, 204, 255);
		this.setBackground(prettyPink);
		
		this.add(cardPanel);
		cardPanel.add(houseImageLabel);
		cardPanel.add(playerImageLabel);
		houseImageLabel.setIcon(houseFirstCardIcon);
		playerImageLabel.setIcon(playerFirstCardIcon);
		houseImageLabel.setPreferredSize(new Dimension(70, 70));
		playerImageLabel.setPreferredSize(new Dimension(20, 30));
	}
	
	public void setupListeners()
	{
		
	}
	
	public void setupLayout()
	{
		layout.putConstraint(SpringLayout.NORTH, cardPanel, 30, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, cardPanel, -30, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.EAST, cardPanel, -30, SpringLayout.EAST, this);
	}
}
