package view;

import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import model.enumeration.BetType;
import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;
import view.model.CurrentSelectedPlayer;


public class GameEngineCallbackGUI implements GameEngineCallback
{
	private CoinPanel coinPanel;
	private CurrentSelectedPlayer currentSelectedPlayer;
	
	public GameEngineCallbackGUI(CoinPanel coinPanel,CurrentSelectedPlayer currentSelectedPlayer)
	{
		this.coinPanel = coinPanel;
		this.currentSelectedPlayer = currentSelectedPlayer;	
	}

	@Override
	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) 
	{
		SwingUtilities.invokeLater(new Runnable()
		{ 
			@Override
			public void run()
			{
				coinPanel.setCoinImageIcon(coin.getFace());
				//ImageIconFactory.setScaledImage(coinPanel.getCoinOne().getWidth(),coinPanel.getCoinOne().getHeight());
			}
		});
	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) 
	{

	}

	@Override
	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) 
	{
		
	}  

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) 
	{
		Iterator <Player> playerIterator = engine.getAllPlayers().iterator();
		
		//Change all player bets to no bet after bet results have been assigned
		while(playerIterator.hasNext())
		{
			playerIterator.next().setBetType(BetType.NO_BET);
		}
		
		new Thread()
		{
			public void run()
			{
				JOptionPane.showMessageDialog(null,"All players have been updated!: Updating Summary Panel");
				
				while(coinPair == null)
				{
					System.out.print("");
				}
				
				
				currentSelectedPlayer.setCurrentSelectedPlayer(currentSelectedPlayer.getCurrentSelectedPlayer());
				
			}
		}.start();
	}
}
