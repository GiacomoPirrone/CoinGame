package model;


//THIS HANDLES MULTIPLE CALLBACKS BECAUSE IT HAS TO HANDLE THE CALLBACKGUI AND THE CALLBACK FOR CONSOLE!
import java.util.ArrayList;

import java.util.Collection;
//SEE IF YOU CAN ADD THIS!
import java.util.Collections;
import java.util.Iterator;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
//import view.GameEngineCallbackImpl;
import view.interfaces.GameEngineCallback;
import view.*;

public class GameEngineImpl implements GameEngine
{
	//Collection of gameEngineCallbacks
	private ArrayList<GameEngineCallback> callBackList = new ArrayList<GameEngineCallback>();
	
	//Collection of players
	 private ArrayList<Player> playerList = new ArrayList<Player>();
	
	
	
	@Override
	public void spinPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) throws IllegalArgumentException
	{
		CoinPair coinPair = new CoinPairImpl();
		
		//Keep spinning both coins until they both reach their final delay value
		while((initialDelay1<finalDelay1) && (initialDelay2 < finalDelay2))
		{
			
			if(initialDelay1<finalDelay1)
			{
				//Delay wait time for coin increases, waits for coin to spin
				try 
				{
					Thread.sleep(initialDelay1);
				}	 	
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			
			
				//Flip Coin
				coinPair.getCoin1().flip();
				//Get player update for every callBack engine stored
				for(int i =0 ; i < callBackList.size(); i++)
				{
					
					callBackList.get(i).playerCoinUpdate(player,coinPair.getCoin1(),this);
					//all the callbacks get told coin flipped
					
					//Increase delay by delay increment
					initialDelay1+=delayIncrement1;
				}
				
			}
			if(initialDelay2<finalDelay2)
			{
				//Delay wait time for coin increases, waits for coin to spin
				try 
				{
					Thread.sleep(initialDelay2);
				}	 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			
				//Flip coin
				coinPair.getCoin2().flip();
				//Get player update for for every callBack engine stored
				for(int i =0 ; i < callBackList.size(); i++)
				{
					callBackList.get(i).playerCoinUpdate(player,coinPair.getCoin2(),this);
					//all the callbacks get told coin flipped
				
					//Increase delay by delay increment
					initialDelay2+=delayIncrement2;
				}
			
			}
		}
		//Show player results for every callBack engine stored
		for(int i=0;i<callBackList.size();i++)
		{
			callBackList.get(i).playerResult(player, coinPair, this);
		}
		
		player.setResult(coinPair);
		
	}

	@Override
	public void spinSpinner(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) throws IllegalArgumentException 
	{
		CoinPair coinPair = new CoinPairImpl();
		
		//Keep spinning both coins until they both reach their final delay value
		while((initialDelay1<finalDelay1))
		{	

			//Delay wait time for coin increases, waits for coin to spin
			try 
			{ 
				Thread.sleep(initialDelay1);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			//Flip Coin
			coinPair.getCoin1().flip();
			//Get player update for every callBack engine stored
			for(int i =0 ; i < callBackList.size(); i++)
			{
				
				callBackList.get(i).spinnerCoinUpdate(coinPair.getCoin1(),this);
				//all the callbacks get told coin flipped
			}
			//Delay wait time for coin increases, waits for coin to spin
			try 
			{
				Thread.sleep(initialDelay1);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			 
			//Flip coin
			coinPair.getCoin2().flip();
			//Get player update for for every callBack engine stored
			for(int i =0 ; i < callBackList.size(); i++)
			{
				callBackList.get(i).spinnerCoinUpdate(coinPair.getCoin2(),this);
				//all the callbacks get told coin flipped
			}
		
			
			//Increase delay both coins by their respe delayIncrements
			initialDelay1+=delayIncrement1;		
		}	
		this.applyBetResults(coinPair);
		//Show spinner results for every callBack engine stored
		for(int i=0;i<callBackList.size();i++)
		{
			callBackList.get(i).spinnerResult(coinPair, this); 
		}
	}
	
	

	@Override
	public void applyBetResults(CoinPair spinnerResult) 
	{
		/*
		Iterator <Player> playerIterator = playerList.iterator();
		while(playerList.iterator().hasNext())
		{
			SimplePlayer nextPlayer = (SimplePlayer) playerIterator.next();
			
			//System.out.println(nextPlayer + "    " + nextPlayer.getResult());
			
			nextPlayer.getBetType().applyWinLoss(nextPlayer, spinnerResult);;
		}
		*/
		
		for(int playerListIndex = 0; playerListIndex < playerList.size(); playerListIndex++)
		{
			playerList.get(playerListIndex).getBetType().applyWinLoss(playerList.get(playerListIndex), spinnerResult); 
			
		}
	}

	@Override
	public void addPlayer(Player player) 
	{
		//Add player
		playerList.add(player);
	}

	@Override
	public Player getPlayer(String id) 
	{
		//iterate through every element in the player list
		for(int i = 0; i < playerList.size(); i++)
		{
			//If the player ID matches a player ID in the player List
			if(playerList.get(i).getPlayerId().toString().equals(id))
			{
				//Return the matching player
				return playerList.get(i);
			}
		}
		//if not found return null
		return null;
	}

	@Override
	public boolean removePlayer(Player player) 
	{
		return playerList.remove(player);
	}

	
	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		//Add gameEngineCallback to listv
		callBackList.add(gameEngineCallback);
		//new GameEngineCallbackGUI(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		//Remove gameEngineCallback from list
		return callBackList.remove(gameEngineCallback);
	}
 
	@Override
	public Collection<Player> getAllPlayers() 
	{
		//Create unmodifiable collection version of playerList
		Collection<Player> immutablePlayerList = Collections.unmodifiableCollection(playerList);
		//return immutablePlayerList;
		
		return playerList;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) 
	{
		//If the bet is larger than zero and is less than or equal to the amount of points the player has
		if(player.setBet(bet))
		{
			player.setBetType(betType);
			return true;
		}
		
		
		return false;
	}

}
