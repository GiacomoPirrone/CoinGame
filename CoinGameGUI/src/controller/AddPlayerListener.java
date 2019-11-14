package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.PlayerCheck;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.AppFrame;
import view.PlayerListJComboBox;

public class AddPlayerListener implements ActionListener
{ 
	private GameEngine gameEngine;
	private AppFrame frame;
	private PlayerListJComboBox playerListJComboBox;
	
	public AddPlayerListener(GameEngine gameEngine, AppFrame frame,PlayerListJComboBox playerListJComboBox)
	{
		this.gameEngine = gameEngine;
		this.frame = frame;
		this.playerListJComboBox = playerListJComboBox;
		
	}
	@Override 
	public void actionPerformed(ActionEvent e)
	{ 
		//Input fields when creating a player
		JTextField playerIDTextField = new JTextField();
		JTextField playerNameTextField = new JTextField();
		JTextField playerPointsTextField = new JTextField();
		
		Object[] playerInformation = {
			"Player ID:",playerIDTextField,
			"Player Name:", playerNameTextField,
			"Player Points:",playerPointsTextField
		}; 
		
		//Option pane which will hold the input text fields when creating a player
		int okOrCancel = JOptionPane.showConfirmDialog(frame, playerInformation, "Add a player", JOptionPane.OK_CANCEL_OPTION);
		
		String newPlayerID = playerIDTextField.getText();
		String newPlayerName = playerNameTextField.getText();
		String playerPoints = playerPointsTextField.getText();
		 
		//If the points are not of integer value then show error and close
		if(!playerPoints.matches("[0-9]+"))
		{
			JOptionPane.showMessageDialog(null,"Type Error: points is not of an integer value");
		} 
		
		int newPlayerPoints = Integer.parseInt(playerPointsTextField.getText());
		
		
		if(okOrCancel == JOptionPane.CANCEL_OPTION)
		{
			
		}
		else if(okOrCancel == JOptionPane.OK_OPTION)
		{	
			//Create Instance of player from values given 
			SimplePlayer player = new SimplePlayer(newPlayerID,newPlayerName,newPlayerPoints);
			
			if(new PlayerCheck().playerCheck(gameEngine, player)) 
			{
				//Add player to game engine
				gameEngine.addPlayer(player);
				//Add player to list of players in the JComboBox
				playerListJComboBox.addItem(player.getPlayerId());
				JOptionPane.showMessageDialog(null, "Added player successfully!");
			}		
		}	
	}
}

