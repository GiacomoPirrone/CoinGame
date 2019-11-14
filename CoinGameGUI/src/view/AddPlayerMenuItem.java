package view;

import javax.swing.JMenuItem;
import controller.AddPlayerListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class AddPlayerMenuItem extends JMenuItem
{
	
	public AddPlayerMenuItem(GameEngine gameEngine,AppFrame frame, PlayerListJComboBox playerListJComboBox)
	{
		super("Add Player");
		
		AddPlayerListener newPlayerListener = new AddPlayerListener(gameEngine,frame,playerListJComboBox);
		this.addActionListener(newPlayerListener);
		
		
		
		
	}
}
