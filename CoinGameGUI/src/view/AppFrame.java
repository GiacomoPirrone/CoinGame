package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ResizeListener;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.model.CurrentSelectedPlayer;


@SuppressWarnings("serial")
public class AppFrame extends JFrame
{
	
	private GameEngine gameEngine = new GameEngineImpl();
	private CurrentSelectedPlayer currentSelectedPlayer;
	
	 
	public AppFrame()
	{	
		super("Coin Game");
		setBounds(0, 0, 820, 580);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BorderLayout());
	
		
		JPanel topPanel = new JPanel(new GridLayout(2, 1));
		StatusBarPanel statusBarPanel = new StatusBarPanel(); 
		SummaryPanel summaryPanel = new SummaryPanel(this, gameEngine);
		CoinPanel coinPanel = new CoinPanel(); 
		JPanel middlePanel = new JPanel(new GridLayout(2,1));
		
		//Lets the game know which player is currently selected in the JComboBox located in the toolbar
		this.currentSelectedPlayer = new CurrentSelectedPlayer(summaryPanel,coinPanel,gameEngine);
		//Holds all the players created and user can choose which player from this JComboBox
		PlayerListJComboBox playerChoiceBox = new PlayerListJComboBox(gameEngine, statusBarPanel,currentSelectedPlayer);
		//Menu for Quitting game, adding player or deleting player
		Menu menu = new Menu(gameEngine,this,playerChoiceBox);
		//Toolbar holds the spin button and the JComboBox of players
		ToolBar toolBar = new ToolBar(gameEngine,currentSelectedPlayer);
		//Add a listener to the coin panel which checks if it is being resized
		coinPanel.addComponentListener(new ResizeListener(coinPanel,currentSelectedPlayer));
		
		
		toolBar.add(playerChoiceBox);
		
		middlePanel.add(coinPanel);
		middlePanel.add(summaryPanel);
		
		topPanel.add(menu);
		topPanel.add(toolBar);
		
		add(topPanel,BorderLayout.NORTH);
		add(statusBarPanel,BorderLayout.SOUTH);
		add(middlePanel,BorderLayout.CENTER);
		
		revalidate();
		repaint();
		
		//Add both the gameEnginecallbacks one for the GUI and one for the Console
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(coinPanel,currentSelectedPlayer));
	} 
	
	//returns the currently selected player in the JComboBox
	public CurrentSelectedPlayer getCurrentSelectedPlayer()
	{
		return currentSelectedPlayer;
	}
}

