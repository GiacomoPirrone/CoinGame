package view.model;


import model.SimplePlayer;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.CoinPanel;
import view.SummaryPanel;

public class CurrentSelectedPlayer 
{
	private SimplePlayer currentPlayer;
	private SummaryPanel summaryPanel;
	private CoinPanel coinPanel;
	private GameEngine gameEngine;
	
	public CurrentSelectedPlayer(SummaryPanel summaryPanel, CoinPanel coinPanel,GameEngine gameEngine)
	{
		this.summaryPanel = summaryPanel;
		this.coinPanel = coinPanel;
		this.gameEngine = gameEngine;
		
	}
	 
	public SimplePlayer getCurrentSelectedPlayer()
	{
		return currentPlayer;
	}
	
	public void setCurrentSelectedPlayer(SimplePlayer currentPlayer)
	{
		
		this.currentPlayer = currentPlayer;
		summaryPanel.setPlayer(currentPlayer);
		 
		if(currentPlayer.getResult()!=null)
		{
			coinPanel.setCoinImageIcon(currentPlayer.getResult().getCoin1().getFace());
			coinPanel.setCoinImageIcon(currentPlayer.getResult().getCoin2().getFace());
		}
		else
		{
			coinPanel.setCoinOneFace(null);
			coinPanel.setCoinTwoFace(null);
		}
	
		coinPanel.revalidate();
		coinPanel.repaint();
	}
	
	
	public void setPlayerBet(BetType betType, int bet)
	{
		gameEngine.placeBet(currentPlayer, bet, betType);
		summaryPanel.setPlayer(currentPlayer);
	}

	

	
	

	
	
}
