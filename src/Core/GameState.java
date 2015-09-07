package Core;

import org.newdawn.slick.Graphics;

public abstract class GameState {
	
	public static final int WIDTH = 128;
	public static final int HEIGHT = 128;

	protected GameCore gc;
	
	public GameState(GameCore gc) {
		this.gc = gc;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void handleInput();
}
