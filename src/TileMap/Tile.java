package TileMap;

import org.newdawn.slick.Image;

public class Tile {

	private Image image;
	private int type;
	
	public static final int NORM = 0;
	public static final int BLOCK = 1;
	
	public Tile(Image image, int type) {
		this.image = image;
		this.type = type;
	}
	
	public Image getImage() { 
		return this.image;
	}
	
	public int getType() {
		return type;
	}
	
}
