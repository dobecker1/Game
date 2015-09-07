package Core;
import java.awt.Graphics2D;

import javax.security.auth.login.AppConfigurationEntry;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import Elemente.Player;
import GameInfos.Keys;
import TileMap.TileMap;

public class Start  extends BasicGame {

	private GameCore gc;
	
	public Start(String title) {
		super(title);
	}

	
	@Override
	public void init(GameContainer container) throws SlickException {
		gc = new GameCore();
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		gc.draw(g);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		gc.update();
		Keys.update();
		
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer ac = new AppGameContainer(new Start("MapTest"));
		ac.setDisplayMode(600, 400, false);
		
		ac.start();
	}
	
	
}
