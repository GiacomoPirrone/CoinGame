package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import model.enumeration.CoinFace;

@SuppressWarnings("serial")
public class CoinPanel extends JPanel 
{
	private int i = 1;
	
	private JLabel coinOne = new JLabel();
	private JLabel coinTwo = new JLabel();
	
	private CoinFace coinOneFace;
	private CoinFace coinTwoFace;
	
	private ImageIconFactory imageIconFactory = new ImageIconFactory();

	public CoinPanel()
	{
		//this.addComponentListener(new PanelResizeListener(this));
		setLayout(new GridLayout(1,2));
		
		add(coinOne);
		add(coinTwo);
	}
	
	public void setCoinImageIcon(CoinFace coinFace)
	{	
		imageIconFactory.setScaledImage(this.getWidth(), this.getHeight());
		//If the incrementer value is even then change the second coin
		if((i & 1)==0)
		{ 
			
			coinTwo.setIcon(imageIconFactory.getScaledImage(coinFace));
		}
		//if not then it is odd so change the first coin
		else
		{
			coinOne.setIcon(imageIconFactory.getScaledImage(coinFace));
		}
		i++;
	}
	
	public void setCoinOneFace(CoinFace coinFace)
	{
		this.coinOneFace = coinFace;
	}
	
	public void setCoinTwoFace(CoinFace coinFace)
	{
		this.coinTwoFace = coinFace;
	}

	public CoinFace getCoinOneFace()
	{
		return coinOneFace;
	}
	public CoinFace getCoinTwoFace()
	{
		return coinTwoFace;
	}
	public JLabel getCoinOne()
	{
		return coinOne;
	}
	
	public JLabel getCoinTwo()
	{
		return coinTwo;
	}
	
	public void setImageIconFactory(ImageIconFactory imageIconFactory)
	{
		this.imageIconFactory = imageIconFactory;
	}

}
