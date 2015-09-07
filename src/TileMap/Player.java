package TileMap;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Elemente.Element;
import GameInfos.Content;

public class Player extends Element{

	private Image[] down;
	private Image[] left;
	private Image[] right;
	private Image[] up;
	
	public Player(TileMap tm) {
		super(tm);
		
		width = 16;
		height = 16;
		cwidth = 12;
		cheight = 12;
		
		down = Content.PLAYER[0];
		left = Content.PLAYER[1];
		right = Content.PLAYER[2];
		up = Content.PLAYER[3];
		
		animation.setFrames(down);
		animation.setDelay(10);
	}

	Image  image;
	
	public void load(String s) {
		try {
			image = new Image(s);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics g) {
		super.draw(g);
	}
}
