package Core;

import java.util.ArrayList;

import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Graphics;

import Elemente.Player;
import GameInfos.Keys;
import TileMap.TileMap;

public class PlayState extends GameState {
	
	
	private TileMap tileMap;
	private Player player;
	
	private boolean eventStart;
	private boolean eventFinish;
	private int eventTick;
	
	private ArrayList<Rectangle> boxes;

	public PlayState(GameCore gc) {
		super(gc);
	}

	@Override
	public void init() {

		tileMap = new TileMap(16);
		tileMap.loadTiles("tiletest.gif");
		tileMap.loadMap("testmap.map");
		
		player = new Player(tileMap);
		player.setTilePosition(17, 17);
		
		eventStart = true;
		eventStart();
	}
	

	private void eventStart() {
		
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				boxes.add(new Rectangle(0, i * 16, WIDTH, 16));
			}
		}
		if(eventTick > 1 && eventTick < 32) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					r.setX(r.getX()-4);
				}
				else {
					r.setX(r.getX()+4);
				}
			}
		}
	}
	
	private void eventFinish() {
		eventTick++;
		if(eventTick == 1) {
			boxes.clear();
			for(int i = 0; i < 9; i++) {
				if(i % 2 == 0) boxes.add(new Rectangle(-128, i * 16, WIDTH, 16));
				else boxes.add(new Rectangle(128, i * 16, WIDTH, 16));
			}
		}
		if(eventTick > 1) {
			for(int i = 0; i < boxes.size(); i++) {
				Rectangle r = boxes.get(i);
				if(i % 2 == 0) {
					if(r.getX() < 0) r.setX(r.getX()+4);
				}
				else {
					if(r.getX() > 0) r.setX(r.getX()-4);
				}
			}
		}
		
	}
	
	@Override
	public void update() {
		handleInput();
		
		if(eventStart) eventStart();
		if(eventFinish) eventFinish();
		if(tileMap.isMoving()) return;
		player.update();
		
	}

	@Override
	public void draw(Graphics g) {
		tileMap.draw(g);
		player.draw(g);
		
	}

	@Override
	public void handleInput() {
		if(Keys.isDown(Keys.LEFT)) player.setLeft();
		if(Keys.isDown(Keys.RIGHT)) player.setRight();
		if(Keys.isDown(Keys.UP)) player.setUp();
		if(Keys.isDown(Keys.DOWN)) player.setDown();
	}

}
