package controller;


import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import view.CoinPanel;
import view.ImageIconFactory;
import view.model.CurrentSelectedPlayer;

public class ResizeListener extends ComponentAdapter
{	
	private CoinPanel coinPanel;
	private CurrentSelectedPlayer currentSelectedPlayer;
	
	public ResizeListener(CoinPanel coinPanel,CurrentSelectedPlayer currentSelectedPlayer)
	{
		this.coinPanel = coinPanel;
		this.currentSelectedPlayer = currentSelectedPlayer;
	}
	public void componentResized(ComponentEvent e)
	{ 
		//Only resize the coins if there is a currently selected player in the JComboBox and the current selected player has spun their coins
		if(currentSelectedPlayer.getCurrentSelectedPlayer() != null && currentSelectedPlayer.getCurrentSelectedPlayer().getResult()!=null)
		{
			ImageIconFactory imageIconFactory = new ImageIconFactory();
			
			//Set the heads and tail coin images to the correct scaling which will come from the current coinpanel size dimensions
			imageIconFactory.setScaledImage(e.getComponent().getWidth(),e.getComponent().getHeight());
		
			/*
			 * set the coinPanels coins to the current selected players coin results and display the image to the recently
			 * resized images of heads and tails
			 */
			coinPanel.getCoinOne().setIcon(imageIconFactory.getScaledImage(currentSelectedPlayer.getCurrentSelectedPlayer().getResult().getCoin1().getFace()));
		
			coinPanel.getCoinTwo().setIcon(imageIconFactory.getScaledImage(currentSelectedPlayer.getCurrentSelectedPlayer().getResult().getCoin2().getFace()));
			
			coinPanel.setImageIconFactory(imageIconFactory);
		}
		
	}	
}
