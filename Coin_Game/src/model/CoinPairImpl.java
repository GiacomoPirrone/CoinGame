package model;

import model.interfaces.Coin;
import model.interfaces.CoinPair;

public final class CoinPairImpl implements CoinPair 
{
	//Instatiate the variables for the two coins to be constructed
	private CoinImpl coin1;
	private CoinImpl coin2;
	
	//Construct which creates two new coin objects
	public CoinPairImpl()
	{
		coin1 = new CoinImpl(1);
		coin2 = new CoinImpl(2);
	}

	@Override
	public Coin getCoin1() 
	{
		return coin1;
	}

	@Override
	public Coin getCoin2() 
	{
		return coin2;
	}

	@Override
	public boolean equals(CoinPair coinPair) 
	{
		//If these pair of coins are the same as the coinpair passed through the parameter
		if(coin1 == null)
		{
			if(coinPair.getCoin1() != null)
				return false;
		}
		else if(!coin1.equals(coinPair.getCoin1()))
			return false;
		if(coin2 == null)
		{
			if(coinPair.getCoin2() != null)
				return false;
		}
		else if(coin2 != coinPair.getCoin2())
			return false;
		return true;
	}
	
	@Override
	public boolean equals(Object coinPair)
	{
		if(this == coinPair)
			return true;
		if(coinPair == null)
			return false;
		if(!(coinPair instanceof CoinPair))
			return false;
		return this.equals((CoinPair)coinPair);
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coin1 == null) ? 0 : coin1.hashCode());
		result = prime * result + ((coin2 == null) ? 0 : coin2.hashCode());
		return result;
	}
	
	@Override
	public String toString()
	{
		return String.format("Coin " + Integer.toString(this.coin1.getNumber()) + ": " +
				this.coin1.getFace().toString().substring(0,1).toUpperCase()
				+ this.coin1.getFace().toString().substring(1) +
				", " +
				"Coin " + Integer.toString(this.coin2.getNumber()) + ": " +
				this.coin2.getFace().toString().substring(0,1).toUpperCase()
				+ this.coin2.getFace().toString().substring(1));
	}

}
