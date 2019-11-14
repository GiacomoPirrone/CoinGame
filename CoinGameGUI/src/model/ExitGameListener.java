package model;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import view.AppFrame;

public class ExitGameListener implements ActionListener
{
	private AppFrame frame;
	 
	public ExitGameListener(AppFrame frame)
	{
		this.frame = frame;
	} 
	//If the exit menu item is selected
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//Notify the user that if they press ok then the game will close and all information will be lost
		int okOrCancel = JOptionPane.showConfirmDialog(frame, "Press OK to exit the game and delete all players",
														"Add a Player", JOptionPane.OK_CANCEL_OPTION);
		
		if(okOrCancel == JOptionPane.CANCEL_OPTION)
		{
		}
		//If the user selects the OK option the close the game
		else if(okOrCancel == JOptionPane.OK_OPTION)
		{
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
		}
	

}
