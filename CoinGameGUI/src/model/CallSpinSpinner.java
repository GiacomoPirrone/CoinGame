package model;

import javax.swing.JOptionPane;
import model.interfaces.GameEngine;

public class CallSpinSpinner 
{
	public CallSpinSpinner(GameEngine gameEngine)
	{
		new Thread()
		{ 
			@Override
			public void run()
			{
				JOptionPane.showMessageDialog(null,"Spinning Spinners coins. Please wait a moment");
				gameEngine.spinSpinner(100, 1000, 100, 50, 500, 50);  
			}
		}.start();
	}
}
