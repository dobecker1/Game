package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class TileMap {
	
	//map
	private int[][] map;
	private int tilesize;
	private int numTilesAcross;
	private int numCols;
	private int numRows;
	private int width;
	private int height;
	private int x;
	private int y;
	private boolean moving;
	
	//tileset
	private BufferedImage tileset;
	private Tile[][] tiles;

	public TileMap(int tilesize) {
		this.tilesize = tilesize;
	}
	
	public void loadTiles(String s) {
		try {
			Image image = new Image(s);
			numTilesAcross = image.getWidth() / tilesize;
			tiles = new Tile[2][numTilesAcross];
			
			Image subimage;
			for(int col = 0; col < numTilesAcross; col++) {
				subimage = image.getSubImage(col*tilesize, 0, tilesize, tilesize);
				tiles[0][col] = new Tile(subimage, Tile.NORM);
				subimage = image.getSubImage(col*tilesize, tilesize, tilesize, tilesize);
				tiles[1][col] = new Tile(subimage, Tile.BLOCK);
			} 
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String s) {
		
		try {
			File file = new File(s);
			InputStream in = new FileInputStream(file);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(in));
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			width = numCols * tilesize;
			height = numRows * tilesize;
			
			String leer = "\\s+";
			for(int row = 0; row < numRows; row++) {
				String line = br.readLine(); 
				String[] tokens = line.split(leer);
				for(int col = 0; col < numCols; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public int getType(int row, int col) {
		int rc = map[row][col];
		int r = rc / numTilesAcross;
		int c = rc % numTilesAcross;
		return tiles[r][c].getType();
	}
	
	public void draw(Graphics g) {
		for(int row = 0; row < 8; row++) {
			for(int col = 0; col < 8; col++) {
				
				int rc = map[row][col];
				int r = rc / numTilesAcross;
				int c = rc % numTilesAcross;
				g.drawImage(
					tiles[r][c].getImage(),
					(float)(x + col * tilesize),
					(float)(y + row * tilesize));
			}
		}
	}
	
	public int getNumCols() {return numCols;}
	public int getNumRows() {return numRows;}
	public boolean isMoving() {return moving;}
	public int getTileSize() {
		return tilesize;
	}
	
	public int getx() {
		return x;
	}
	
	public int gety() {
		return y;
	}
	
}
