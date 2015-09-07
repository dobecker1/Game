package GameInfos;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Content {

	public static Image[][] PLAYER = load("player.gif", 16, 16);
	
	public static Image[][] load(String s,int width, int height) {
		Image[][] content;
		try {
			Image data = new Image(s);
			int w = data.getWidth() / width;
			int h = data.getHeight() / height;
			content = new Image[h][w];
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					content[i][j] = data.getSubImage(
							j*w, i*h, w, h);
				}
			}
			return content;
		} catch (SlickException e) {
			e.printStackTrace();
			System.out.println("Error loading graphics");
		}
		return null;
	}
	
}
