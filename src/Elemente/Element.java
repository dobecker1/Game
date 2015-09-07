package Elemente;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import TileMap.Tile;
import TileMap.TileMap;

public abstract class Element {

	//position
	protected int x;
	protected int y;
	protected int xdest;
	protected int ydest;
	protected int rowTile;
	protected int colTile;
	
	//movement
	protected boolean moving;
	protected boolean left;
	protected boolean right;
	protected boolean up;
	protected boolean down;
	
	protected int moveSpeed;
	
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
	
	public void setLeft() {
		if(moving) return;
		left = true;
		moving = validateNextPosition();
	}
	
	public void setRight() {
		if(moving) return;
		right = true;
		moving =validateNextPosition();
	}
	
	public void setUp() {
		if(moving) return;
		up = true;
		moving = validateNextPosition();
	}
	
	public void setDown() {
		if(moving) return;
		down = true;
		moving = validateNextPosition();
	}
	public boolean validateNextPosition() {
		if(moving) return true;
		
		rowTile = y / tilesize;
		colTile = x / tilesize;
		
		if(left) {
			if(colTile == 0 || tileMap.getType(rowTile, colTile -1) == Tile.BLOCK) {
				return false;
			}
			else {
				xdest = x - tilesize;
			}
		}
		if(right) {
			if(colTile == tileMap.getNumCols() || tileMap.getType(rowTile, colTile + 1) == Tile.BLOCK) {
				return false;
			}
			else {
				xdest = x + tilesize;
			}
		}
		if(up) {
			if(rowTile == 0 || tileMap.getType(rowTile-1, colTile) == Tile.BLOCK) {
				return false;
			}
			else {
				ydest = y - tilesize;
			}
		}
		if(down) {
			if(rowTile == tileMap.getNumRows() -1 || tileMap.getType(rowTile+1, colTile) == Tile.BLOCK) {
				return false;
			}
			else {
				ydest = y + tilesize;
			}
		}
		return true;
	}
	
	public void getNextPosition() {
		if(left && x > xdest) x -= moveSpeed;
		else left = false;
		if(left && x < xdest) x = xdest;
		
		if(right && x < xdest) x += moveSpeed;
		else right = false;
		if(right && x > xdest) x = xdest;
		
		if(up && y > ydest) y -= moveSpeed;
		else up = false;
		if(up && y < ydest) y = ydest;
		
		if(down && y < ydest) y += moveSpeed;
		else down = false;
		if(down && y > ydest) y = ydest;
	}
	
	public void update() {
		if(moving) getNextPosition();
		
		if(x == xdest && y == ydest) {
			left = right = up = down = moving = false;
			rowTile = y / tilesize;
			colTile = x / tilesize;
		}
		
		animation.update();
	}
	
	public void draw(Graphics g) {
		setMapPosition();
		g.drawImage(animation.getImage(),
				x+ xmap -width / 2,
				y+ ymap- height / 2);
	}
	
	
}
