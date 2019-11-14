package model;

//SEE IF YOU CAN ADD
import java.util.Random;

import model.enumeration.CoinFace;
import model.interfaces.Coin;

public class CoinImpl implements Coin
{
	//Instantiate Coin Variables
	private int number;
	private CoinFace face;
	
	//For initializing the side of the coin
	private CoinFace[] faces = CoinFace.values();
	private Random random = new Random();
	
	//Coin Object constructor
	public CoinImpl(int number)
	{
		//Number used to identify coin
		this.number = number;
		
		//Returns random side of coin to start with
		this.face = faces[random.nextInt(faces.length)];
	}

	@Override
	public int getNumber() 
	{
		return number;
	}

	@Override
	public CoinFace getFace() 
	{
		return face;
	}

	@Override
	public void flip() 
	{
		//If Coins face is showing Heads
		if(face.equals(CoinFace.HEADS))
		{
			//Then change the value of the facing side to Tails
			face = CoinFace.TAILS;
		}
		//If Coins face is showing Tails
		else if(face.equals(CoinFace.TAILS))
		{
			//Then change the value of the facing side to Heads
			face = CoinFace.HEADS;
		}
		//Else if the coins face has no value keep it at the value of null
		else
		{	
			face = null;
		}
		
	}

	@Override
	public boolean equals(Coin coin) 
	{
		if(this == coin)
			return true;
		if(coin == null)
			return false;
		if(this.getClass() != coin.getClass())
			return false;
		CoinImpl other = (CoinImpl) coin;
		if(face == null)
		{
			if(other.face != null)
				return false;
		}
		else if(!face.equals(other.face))
			return false;
		
		if(Integer.valueOf(number) == null)
		{
			if(Integer.valueOf(other.number) != 0)
				return false;
		}
		else if (number != other.number)
			return false;
		return true;
	}
	
	@Override
	public boolean equals(Object Coin)
	{
		return this.equals((CoinImpl)Coin);
	}
	
	//METHOD INCOMPLETE
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == 0) ? 0 : Integer.valueOf(number).hashCode());
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		return result;
	}
	
	//METHOD INCOMPLETE
	@Override
	public String toString()
	{
		return String.format(" Coin " + this.number + " flipped to " +
							face.toString().substring(0,1).toUpperCase()
							+ face.toString().substring(1).toLowerCase());
	}
	
}
