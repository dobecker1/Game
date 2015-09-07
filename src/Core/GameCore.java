package Core;

import org.newdawn.slick.Graphics;

public class GameCore {
	
	private GameState[] gameStates;
	private int previousState;
	private int currentState;
	
	public static final int PLAY = 0;

	public GameCore() {
		gameStates = new GameState[3];
		setState(PLAY);
	}
	
	public void setState(int i) {
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == PLAY) {
			gameStates[i] = new PlayState(this);
			gameStates[i].init();
		}
	}
	
	public void unloadState(int i) {
		 gameStates[i] = null;
	}
	
	public void update() {
		if(gameStates[currentState] != null) {
			gameStates[currentState].update();
		}
	}
	
	public void draw(Graphics g) {
		if(gameStates[currentState] != null) {
			gameStates[currentState].draw(g);
		}
	}
}
