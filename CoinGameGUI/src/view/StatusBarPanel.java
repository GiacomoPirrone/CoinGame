package view;

import java.awt.Color;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Shows 

@SuppressWarnings("serial")
public class StatusBarPanel extends JPanel implements PropertyChangeListener
{ 
	private JLabel statusLabel1 = new JLabel("No Player Selected", JLabel.LEFT);
	private JLabel statusLabel2 = new JLabel("No Player Selected", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("No Player Selected", JLabel.RIGHT);
	
	JLabel[] statusLabels =  {statusLabel1,statusLabel2,statusLabel3};
	
	public StatusBarPanel()
	{
		setLayout(new GridLayout(1,3));
		
		for(int i =0;i<statusLabels.length;i++)
		{
			statusLabels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			add(statusLabels[i]);
		}
	}  

	//Sets currently selected player from JComboBox in the ToolBar
	public void setCurrentPlayer(String playerId,String playerName,String playerPoints)
	{
		statusLabel1.setText("Player Id: " + playerId);
		statusLabel2.setText("Player Name: " + playerName);
		statusLabel3.setText("Current Points: " + playerPoints);
	}
	
	public void setNoPlayer()
	{
		statusLabel1.setText("No Player Selected");
		statusLabel2.setText("No Player Selected");
		statusLabel3.setText("No Player Selected");
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) 
	{
			
	}
}
