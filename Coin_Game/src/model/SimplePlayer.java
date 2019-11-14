package model;

import model.enumeration.BetType;
import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SimplePlayer implements Player 
{
	String playerId;
	String playerName;
	int initialPoints;
	
	int bet;
	BetType betType;
	CoinPair coinPair;


	public SimplePlayer(String playerId, String playerName, int initialPoints) 
	{
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}


	@Override
	public String getPlayerName() 
	{
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}

	@Override
	public int getPoints() 
	{
		return initialPoints;
	}

	@Override
	public void setPoints(int points) 
	{
		this.initialPoints = points; 
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean setBet(int bet) 
	{
		//If the player has sufficient points and the bet 
		//value is larger than 0 then bet is applicable (true)
		if(bet>0 && bet<=this.getPoints())
		{
			this.bet = bet;
			return true;
		}
		
		return false;
	}

	@Override
	public int getBet() 
	{
		//Return the bet as set with setBet()
		return bet;
	}

	@Override
	public void setBetType(BetType betType) 
	{
		this.betType = betType;
	}

	@Override
	public BetType getBetType() 
	{
		return betType;
	}

	@Override
	public void resetBet() 
	{
		bet = 0;
		betType = BetType.NO_BET;
	}

	@Override
	public CoinPair getResult() 
	{
		return coinPair;
	} 

	@Override
	public void setResult(CoinPair coinPair) 
	{
		this.coinPair = coinPair;
	}
	
	//Summarises all information belonging to this player
	@Override
	public String toString()
	{
		return String.format("Player: id =" +  this.getPlayerId() 
							+", name=" + this.getPlayerName() 
							+", bet=" + Integer.toString(this.getBet())
							//+", betType=" + this.getBetType().toString() 
							+", points=" + Integer.toString(this.getPoints())
							//+",\n Result .." + this.getResult().toString()
							+"\n");
	}

}
