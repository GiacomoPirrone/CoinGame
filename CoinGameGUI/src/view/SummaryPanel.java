package view;

import java.awt.Component;
import java.awt.GridLayout;


import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import controller.PlaceBetButtonListener;
import model.SimplePlayer;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel
{
	private AbstractButton placeBetButton = new JButton("Place Bet");
	private JPanel summaryTextField = new JPanel();
	
	private JLabel playerNameLabel = new JLabel("Player Name:");
	private JLabel pointBalanceLabel = new JLabel("Point Balance:");
	private JLabel currentBetTypeLabel = new JLabel("Bet Type:");
	private JLabel currentBetAmountLabel = new JLabel("Bet Amount:");
	private JLabel recentWinLossLabel = new JLabel("Recent Win/Loss:");
	
	private JTextField playerNameText = new JTextField(" ");
	private JTextField pointBalanceText = new JTextField(" ");
	private JTextField currentBetTypeText = new JTextField(" ");
	private JTextField currentBetAmountText = new JTextField(" ");
	private JTextField recentWinLossText = new JTextField(" ");
	
	private Object[] summaryTextFieldElements = {playerNameLabel,playerNameText,pointBalanceLabel,pointBalanceText,
												currentBetTypeLabel,currentBetTypeText,currentBetAmountLabel,currentBetAmountText,
												recentWinLossLabel,recentWinLossText};
	
	private Object[] textFieldElements = {playerNameText,pointBalanceText,currentBetTypeText,currentBetAmountText,recentWinLossText};
	
	public SummaryPanel(AppFrame frame,GameEngine gameEngine)
	{
		//Text fields cannot be editted by the user
		for(int i=0;i<textFieldElements.length;i++)
			((JTextComponent) textFieldElements[i]).setEditable(false);
		
		setLayout(new GridLayout(2,1));
		
		summaryTextField.setLayout(new GridLayout(5,5));
		
		add(summaryTextField);
		add(placeBetButton);
		
		PlaceBetButtonListener placeBetButtonListener = new PlaceBetButtonListener(frame, this, gameEngine);
		placeBetButton.addActionListener(placeBetButtonListener);
		
		for(int i=0;i<summaryTextFieldElements.length;i++)
			summaryTextField.add((Component) summaryTextFieldElements[i]);
		
		revalidate();
		repaint();
		
	}
	
	public void setPlayer(SimplePlayer currentPlayer)
	{	
		this.playerNameText.setText(currentPlayer.getPlayerName());
		this.pointBalanceText.setText(Integer.toString(currentPlayer.getPoints()));
		
		if(currentPlayer.getBetType()!=null)
		{ 
			this.currentBetTypeText.setText(currentPlayer.getBetType().toString());
		}
		this.currentBetAmountText.setText(Integer.toString(currentPlayer.getBet())); 
	}
	
	public void setWinLossPoints(int winLossPoints)
	{
		recentWinLossText.setText(Integer.toString(winLossPoints));
	}
}
