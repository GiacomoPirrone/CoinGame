package view;

 
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import model.enumeration.CoinFace;

public class ImageIconFactory 
{
	//Set the image directory of the heads and tails image
	private final static String headsDir = "img\\heads.png";
	private final static String tailsDir = "img\\tails.png";
	
	private ImageIcon headsImage = new ImageIcon(headsDir);
	private ImageIcon tailsImage = new ImageIcon(tailsDir);
	
	 
	public static String getImageDirectory(CoinFace coinFace)
	{
		if(coinFace == CoinFace.HEADS)
		{
			return headsDir;
		}
		else if(coinFace == CoinFace.TAILS)
		{
			return tailsDir;
		}
		return null;
	}
	
	
	public ImageIcon getScaledImage(CoinFace coinFace)
	{
		if(coinFace == CoinFace.HEADS)
		{
			return headsImage;
		}
		return tailsImage;
		
	}
	
	public void setScaledImage(int w, int h)
	{ 
		/*
		 * Because the images of the coins have to be square to retain they're
		 * natural look and resolution all sides have to be equal therefore
		 * compare the received width and height measurements
		 * and whichever one is bigger becomes the assigned measurement
		 */
		int squareLength = 0;
		
		if(w>h)
		{
			squareLength = h;
		}
		else if(w<h)
		{
			squareLength = w;
		}
		
		for(CoinFace coinFace : CoinFace.values())
		{
			BufferedImage coinImg = null;
			try {
				coinImg = ImageIO.read(new File(getImageDirectory(coinFace)));
			}catch (IOException e) {
			e.printStackTrace();
			}
		
			Image resizeTailImage = coinImg.getScaledInstance(squareLength, squareLength,Image.SCALE_SMOOTH);
		
			ImageIcon coinImageIcon = new ImageIcon(resizeTailImage);
			
			 if(coinFace == CoinFace.HEADS)
			 {
				 headsImage = coinImageIcon;
			 }
			 else
			 {
				 tailsImage = coinImageIcon;
			 }
		}
		
	}
}
