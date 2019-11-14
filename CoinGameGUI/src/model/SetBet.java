package model;

import java.util.Iterator;

import javax.swing.JOptionPane;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AppFrame;

public class SetBet 
{
	private boolean allPlayersHaveBet;
	private SimplePlayer lastPlayer;
	 
	
	public SetBet(AppFrame frame,String betAmount,BetType whichBetType,GameEngine gameEngine)
	{
		//get the current selected player and set their bet
		frame.getCurrentSelectedPlayer().setPlayerBet(whichBetType,Integer.parseInt(betAmount));
		
		Iterator<Player> allPlayersIterator = gameEngine.getAllPlayers().iterator();
		
		//If all the users have placed a bet then set the all playerhaveBet boolean to true
		while(allPlayersIterator.hasNext())
		{
			if(allPlayersIterator.next().getBet()==0) 
			{	
				allPlayersHaveBet = false;
				break;
			}
			allPlayersHaveBet = true;
		} 
		
		//If all players have bet then spin for every player that has not spun
		if(allPlayersHaveBet)
		{
			Iterator<Player> playerIterator = gameEngine.getAllPlayers().iterator();
			JOptionPane.showMessageDialog(null,"All Players have placed a bet spinning for the rest that haven't spun");
			while(playerIterator.hasNext())
			{
				SimplePlayer nextPlayer = (SimplePlayer) playerIterator.next();
				//If this user has not spun the spin for them
				if(nextPlayer.getResult()==null)
				{
					 new Thread()
					 {
						 @Override
						 public void run()
						 {
							 //Spin for player
							 gameEngine.spinPlayer(nextPlayer,100, 1000, 100, 50,500, 50); 
						 }
					 }.start();
				} 
			}
			
			Iterator<Player> findLastPlayerIterator = gameEngine.getAllPlayers().iterator();
			
			//This while loop finds the last player in the allPlayers collection
			while(findLastPlayerIterator.hasNext())
			{
				SimplePlayer nextPlayer = (SimplePlayer) findLastPlayerIterator.next();
				
				if(!findLastPlayerIterator.hasNext())
				{
					lastPlayer = nextPlayer;
				}
			} 
			
			
			//New thread to check if all players have a coin pair
			new Thread()
			{
				public void run()
				{
					//If the last player in the collection of players doesnt have a coin pair
					while(lastPlayer.getResult() == null)
					{
						System.out.print("");
						//Then wait and keep checking until they do have a coin pair
					}
						//Once all players have a coin pair call the spin spinner
						new CallSpinSpinner(gameEngine);
				}
			}.start();

		
		frame.getCurrentSelectedPlayer().setPlayerBet(whichBetType, Integer.parseInt(betAmount));
	}
}
}


