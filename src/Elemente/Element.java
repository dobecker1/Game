package Elemente;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import TileMap.TileMap;

public abstract class Element {

	//position
	protected int x;
	protected int y;
	protected int xdest;
	protected int ydest;
	protected int rowTile;
	protected int colTile;
	
	//dimensions
	protected int width;
	protected int height;
	protected int cwidth;
	protected int cheight;
	
	//tilemap
	protected TileMap tileMap;
	protected int tilesize;
	protected int xmap;
	protected int ymap;
	
	//animation
	protected Animation animation;
	protected int currentAnimation;
	
	
	public Element(TileMap tm) {
		tileMap = tm;
		tilesize = tm.getTileSize();
		animation = new Animation();
	}
	
	public int getx() {return x;}
	public int gety() {return y;}
	public int getRow() {return rowTile;}
	public int getCol() {return colTile;}
	
	public void setPosition(int i1, int i2) {
		x = i1;
		y = i2;
		xdest = x;
		ydest = y;
	}
	
	
	
	public void setMapPosition() {
		xmap = tileMap.getx();
		ymap = tileMap.gety();
	}
	
	public void setTilePosition(int i1, int i2) {
		y = i1 * tilesize + tilesize / 2;
		x = i2 * tilesize + tilesize / 2;
		xdest = x;
		ydest = y;
	}
	
	public void draw(Graphics g) {
		setMapPosition();
		g.drawImage(animation.getImage(),
				x+ xmap -width / 2,
				y+ ymap- height / 2);
	}
	
	
}
