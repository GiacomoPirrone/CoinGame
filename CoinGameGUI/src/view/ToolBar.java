package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JToolBar;
import controller.SpinButtonListener;
import model.interfaces.GameEngine;
import view.model.CurrentSelectedPlayer;

@SuppressWarnings("serial")
public class ToolBar extends JToolBar implements ActionListener
{
	private AbstractButton spinButton = new JButton("Spin");
	
	
	public ToolBar(GameEngine gameEngine,CurrentSelectedPlayer currentSelectedPlayer)
	{
		add(spinButton);
		spinButton.addActionListener(new SpinButtonListener(gameEngine,currentSelectedPlayer));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
	}



	
	
}
