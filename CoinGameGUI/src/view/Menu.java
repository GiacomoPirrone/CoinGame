package view;


import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.ExitGameListener;
import model.interfaces.GameEngine;




@SuppressWarnings("serial")
public class Menu extends JMenuBar implements ActionListener
{ 
	//Creating Menus
	private JMenu fileMenu = new JMenu("File");
	private JMenu addPlayerMenu = new JMenu("Add Player");
	private JMenu deletePlayerMenu = new JMenu("Delete player");

	//Creating menu items
	private JMenuItem exitMenuItem =  new JMenuItem("Exit Game");
	
	private Object[] menuElements = {fileMenu,addPlayerMenu,deletePlayerMenu};
	
	public Menu(GameEngine gameEngine,AppFrame frame,PlayerListJComboBox playerListJComboBox)
	{	
		//Add all menu elements
		for(int i=0;i<menuElements.length;i++)
			add((JMenu)menuElements[i]);
		
		
		fileMenu.add(exitMenuItem);
		exitMenuItem.addActionListener(new ExitGameListener(frame));
		addPlayerMenu.add(new AddPlayerMenuItem(gameEngine,frame,playerListJComboBox));
		deletePlayerMenu.add(new DeletePlayerMenuItem(gameEngine,frame,playerListJComboBox));
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		 
	}
}
