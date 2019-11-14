package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */ 
public class GameEngineCallbackImpl implements GameEngineCallback
{
   private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

   public GameEngineCallbackImpl()
   {
	   	// NOTE need to also set the console to FINE in %JRE_HOME%\lib\logging.properties
	   	logger.setLevel(Level.FINE);
   } 
 
   public void playerCoinUpdate(Player player, Coin coin, GameEngine engine)
   {
	   	// intermediate results logged at Level.FINE
	   	logger.log(Level.FINE, String.format(player.getPlayerName() + coin.toString()));
   }
 
   public void playerResult(Player player, CoinPair coinPair, GameEngine engine)
   {
	   	// final results logged at Level.INFO
	   	logger.log(Level.INFO, String.format(player.getPlayerName() + " final result=Coin " + Integer.toString(coinPair.getCoin1().getNumber())
	   				+ ": " + coinPair.getCoin1().getFace().toString().substring(0,1).toUpperCase() + coinPair.getCoin1().getFace().toString().substring(1).toLowerCase()
	   				+ ", Coin " + Integer.toString(coinPair.getCoin2().getNumber())
	   				+ ": " + coinPair.getCoin2().getFace().toString().substring(0,1).toUpperCase() + coinPair.getCoin2().getFace().toString().substring(1).toLowerCase()));
   }
   
   @Override
   public void spinnerCoinUpdate(Coin coin, GameEngine engine) 
   {
	   	logger.log(Level.FINE, String.format("Spinner"+ coin.toString()));
   }

   @Override
   public void spinnerResult(CoinPair coinPair, GameEngine engine) 
   {
	   	logger.log(Level.INFO, String.format("Spinner, final result=Coin " + Integer.toString(coinPair.getCoin1().getNumber())
			+ ": " + coinPair.getCoin1().getFace().toString().substring(0,1).toUpperCase() + coinPair.getCoin1().getFace().toString().substring(1).toLowerCase()
			+ ", Coin " + Integer.toString(coinPair.getCoin2().getNumber())
			+ ": " + coinPair.getCoin2().getFace().toString().substring(0,1).toUpperCase() + coinPair.getCoin2().getFace().toString().substring(1).toLowerCase()));
	   	//Log all players results
	   	logger.log(Level.INFO, String.format("Final Player Results \n" + engine.getAllPlayers().toString()));
   }

   // TODO: implement rest of interface
}
