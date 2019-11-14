package controller;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.AppFrame;
import view.PlayerListJComboBox;

public class DeletePlayerListener implements ActionListener
{
	private GameEngine gameEngine;
	private AppFrame frame;
	private PlayerListJComboBox playerListJComboBox;

	
	public DeletePlayerListener(GameEngine gameEngine, AppFrame frame,PlayerListJComboBox playerListJComboBox)
	{
		this.gameEngine = gameEngine;
		this.frame = frame;
		this.playerListJComboBox = playerListJComboBox;
	}
 
	//If the delete player menu item is selected
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		 
		JComboBox <String> listOfPlayers = new JComboBox <String>();
		
		//Iterate throught everyplayer in the jcombobox and create a new JComboBox
		//which will be placed into a smaller JLabel
		for (int i = 0; i < playerListJComboBox.getItemCount(); i++) 
		{
			listOfPlayers.addItem(playerListJComboBox.getItemAt(i));
		}
		
		JLabel removePlayerText = new JLabel("Select player from list then click OK to delete from game");
		
		JPanel deletePlayerPanelForDialogBox = new JPanel(new GridLayout(2, 1)); 
		deletePlayerPanelForDialogBox.add(removePlayerText);
		deletePlayerPanelForDialogBox.add(listOfPlayers);
		
		//Show an option pane which will allow a user to pick from a JComboBox to pick a player to delete
		int okOrCancel = JOptionPane.showConfirmDialog(frame, deletePlayerPanelForDialogBox,
														"Remove a player", JOptionPane.OK_CANCEL_OPTION);
		
	
		String playerId = (String) listOfPlayers.getSelectedItem();
		SimplePlayer playerToRemove = (SimplePlayer) gameEngine.getPlayer(playerId);
		if(okOrCancel == JOptionPane.CANCEL_OPTION)
		{
			
		}
		//If user clicks on the OK button
		else if(okOrCancel == JOptionPane.OK_OPTION)
		{	
			//The chosen player from the JComboBox will be removed from the game and main frame JComboBox
			gameEngine.removePlayer(playerToRemove);
			System.out.println(playerListJComboBox.getItemCount());
			playerListJComboBox.removeItemAt(listOfPlayers.getSelectedIndex());
		}
	}
}
