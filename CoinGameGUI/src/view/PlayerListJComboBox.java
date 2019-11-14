package view;

import javax.swing.JComboBox;

import controller.PlayerComboBoxListener;
import model.interfaces.GameEngine;
import view.model.CurrentSelectedPlayer;

@SuppressWarnings("serial")
public class PlayerListJComboBox extends JComboBox <String>
{
	 
	public PlayerListJComboBox(GameEngine gameEngine, StatusBarPanel statusBarPanel,CurrentSelectedPlayer currentSelectedPlayer)
	{
		PlayerComboBoxListener playerComboBoxListener = new PlayerComboBoxListener(gameEngine, statusBarPanel,currentSelectedPlayer);
		this.addActionListener(playerComboBoxListener); 
	}
}
