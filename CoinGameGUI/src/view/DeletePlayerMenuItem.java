package view;

import javax.swing.JMenuItem;
import controller.DeletePlayerListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class DeletePlayerMenuItem extends JMenuItem
{
	public DeletePlayerMenuItem(GameEngine gameEngine,AppFrame frame,PlayerListJComboBox playerListJComboBox)
	{ 
		super("Delete a Player");
		DeletePlayerListener deletePlayerListener = new DeletePlayerListener(gameEngine,frame,playerListJComboBox);
		this.addActionListener(deletePlayerListener);
	}
}
