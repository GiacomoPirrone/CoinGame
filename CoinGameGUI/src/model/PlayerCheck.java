package model;

import java.util.Iterator;


import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlayerCheck 
{
	public boolean playerCheck(GameEngine gameEngine, SimplePlayer simplePlayer)
	{
		Iterator <Player> playerCheckIterator = gameEngine.getAllPlayers().iterator();
		
		//If the player has no name or has not player ID then notify them that they cannot 
		//Make a player with no name or no player ID and do not create the player
		if(simplePlayer.getPlayerName().isEmpty() || simplePlayer.getPlayerId().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"Player ID field and Player Name field must not be empty");
			return false;
		} 
		
		while(playerCheckIterator.hasNext())
		{
			SimplePlayer nextPlayer = (SimplePlayer) playerCheckIterator.next();
			/*If the player being created has the same player Id as another player then 
			 * notify them that the player ID already exists
			 * and do not create the player
			*/
			if(nextPlayer.getPlayerId().equals(simplePlayer.getPlayerId()))
			{
				JOptionPane.showMessageDialog(null,"Duplicate Player ID: Player already exists!");
				return false;
			}
			/*
			 * If the player being created has the same player name as another player then
			 * notify the user that there is already another player with this name
			 * and do not create the player
			 */
			else if(nextPlayer.getPlayerName().equals(simplePlayer.getPlayerName()))
			{
				JOptionPane.showMessageDialog(null,"Duplicate Player Name: Player already exists!");
				return false;
			}
			else
			{
				return true;
			}
		}
		return true;
	}
	
}
