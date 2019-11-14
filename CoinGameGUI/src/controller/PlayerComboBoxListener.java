package controller;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.PlayerListJComboBox;
import view.StatusBarPanel;
import view.model.CurrentSelectedPlayer;

public class PlayerComboBoxListener implements ActionListener
{
	private StatusBarPanel statusBarPanel;
	private GameEngine gameEngine;
	private CurrentSelectedPlayer currentSelectedPlayer;
	


	
	public PlayerComboBoxListener(GameEngine gameEngine, StatusBarPanel statusBarPanel, CurrentSelectedPlayer currentSelectedPlayer)
	{
		this.gameEngine = gameEngine;
		this.statusBarPanel = statusBarPanel;
		this.currentSelectedPlayer = currentSelectedPlayer; 
	}
	 
	
	public void actionPerformed(ActionEvent e) 
	{	
		//create a new combo box the same as the combobox from the main frame up in the toolbar
		PlayerListJComboBox comboBox = ((PlayerListJComboBox) e.getSource());
		//The selected player in the JComboBox has its player ID retained for referencing
		String playerId = (String)comboBox.getSelectedItem();
		//Get the selected player from the retain player ID
		SimplePlayer currentPlayer = (SimplePlayer) gameEngine.getPlayer(playerId);
		
		//Attain selected players information
		String playerName = currentPlayer.getPlayerName();
		String playerPoints = Integer.toString(currentPlayer.getPoints());
		
		//Set the status bar to the current selected player
		statusBarPanel.setCurrentPlayer(playerId, playerName, playerPoints);
		
		//Set the current selected player in the current selected player method for future referencing
		//And to allow the program to always know which player is currently selected in the JComboBox in the toolbar
		currentSelectedPlayer.setCurrentSelectedPlayer(currentPlayer);
	} 


}
