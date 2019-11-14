package controller;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SetBet;
import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.AppFrame;
import view.SummaryPanel;

public class PlaceBetButtonListener implements ActionListener 
{
	private AppFrame frame;
	private GameEngine gameEngine;

	private String betAmount;
	private BetType whichBetType;
	
	private final JLabel setBetLabel =  new JLabel("Bet Amount:");
	private final JLabel setBetTypeLabel = new JLabel("Bet Type:");
	 
	private JTextField setBetField = new JTextField();
	private JComboBox <BetType> betTypesComboBox = new JComboBox <BetType>(BetType.values());
	
	private JPanel enterBetPanel = new JPanel();
	
	private boolean betIsValid;
	
	
	public PlaceBetButtonListener(AppFrame frame,SummaryPanel summaryPanel,GameEngine gameEngine)
	{
		this.frame = frame;
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		Object[] betPanelElements = {setBetLabel,setBetField,setBetTypeLabel,betTypesComboBox};
			
		enterBetPanel.setLayout(new GridLayout(2,2)); 
		
		//Add all bet panel elements
		for(int i=0;i<betPanelElements.length;i++)
			enterBetPanel.add((Component) betPanelElements[i]);

		
		int okOrCancel = JOptionPane.showConfirmDialog(frame,enterBetPanel,
				"Place a bet", JOptionPane.OK_CANCEL_OPTION);
		
		if(okOrCancel == JOptionPane.CANCEL_OPTION)
		{
			
		}
		if(okOrCancel == JOptionPane.OK_OPTION)
		{
			
			SimplePlayer currentPlayer = frame.getCurrentSelectedPlayer().getCurrentSelectedPlayer();
			int currentBet = Integer.parseInt(setBetField.getText());
			
			//If the no player has been created yet then warn the user
			if(currentPlayer == null)
			{
				JOptionPane.showMessageDialog(null,"Warning!: No player selected, please create a player first!");
				this.betIsValid = false;
			}
			//If the players bet is higher than the players points warn the user
			else if(currentPlayer.getPoints()< currentBet)
			{
				JOptionPane.showMessageDialog(null,"Warning!: Player bet must not be larger than player points amount!");
				this.betIsValid = false;
			}
			//If it passes the two crucial rules above then the bet is valid and can go through to the setBet() method
			else
			{
				this.betIsValid = true;
			}
			//If the bet is valid as determined by the two checks above
			if(betIsValid)
			{
				//Inform the user that the bet has been placed
				JOptionPane.showMessageDialog(null,"Bet has been set successfully!");
				//Retain the bet amount and the type of bet placed by the user for this player and pass through to setBet()
				this.betAmount = setBetField.getText();
				this.whichBetType = (BetType) betTypesComboBox.getSelectedItem();
				new SetBet(frame,betAmount,whichBetType,gameEngine);
			}
		}
	}

}
