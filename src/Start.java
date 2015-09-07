import java.awt.Graphics2D;

import javax.security.auth.login.AppConfigurationEntry;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import TileMap.Player;
import TileMap.TileMap;

public class Start  extends BasicGame {

	private TileMap map;
	private Player player;
	
	public Start(String title) {
		super(title);
	}

	
	@Override
	public void init(GameContainer container) throws SlickException {
		map = new TileMap(16);
		map.loadTiles("tiletest.gif");
		map.loadMap("testmap.map");
		player = new Player(map);
		player.load("player.gif");
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		map.draw(g);
		player.draw(g);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer ac = new AppGameContainer(new Start("MapTest"));
		ac.setDisplayMode(600, 400, false);
		
		ac.start();
	}
	
	
}
