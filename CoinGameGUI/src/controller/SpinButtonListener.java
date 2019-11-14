package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.model.CurrentSelectedPlayer;

public class SpinButtonListener implements ActionListener
{
	private GameEngine gameEngine;
	private CurrentSelectedPlayer currentSelectedPlayer;

	public SpinButtonListener(GameEngine gameEngine,CurrentSelectedPlayer currentSelectedPlayer)
	{
		this.gameEngine = gameEngine;
		this.currentSelectedPlayer = currentSelectedPlayer;;
	} 
	//When the spin button is pressed
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		//If the currently selected player in the JComboBox has a bet
		if(currentSelectedPlayer.getCurrentSelectedPlayer().getBet()!=0)
		{
			//Then spin for the player in a seperate thread
			new Thread()
			{
				@Override
				public void run()
				{
					//Spins player
					gameEngine.spinPlayer(currentSelectedPlayer.getCurrentSelectedPlayer(), 100, 1000, 100, 50, 500, 50);
				}
			}.start(); 
		}
		//If they don't have a bet then don't spin for player and notify them that they must bet before they spin
		else
		{
			JOptionPane.showMessageDialog(null,"This player must bet before they spin!");
		}
	}
}
