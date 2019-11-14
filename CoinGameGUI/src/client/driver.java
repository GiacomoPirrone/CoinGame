package client;

import javax.swing.SwingUtilities;

import view.AppFrame;

public class driver 
{

	public static void main(String args[])
	{	
		SwingUtilities.invokeLater(new Runnable()
		{
		//JUST REPLACE THE CALLBACK WITH CALLBACKGUI!!!
			@Override
			public void run() 
			{
				new AppFrame();	
			}
		});
	}
}
