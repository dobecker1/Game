package Elemente;

import org.newdawn.slick.Image;

public class Animation {

	private Image[] frames;
	private int currentFrame;
	private int delay;
	private int numFrames;
	private int count;
	private int timesPlayed;
	
	public Animation() {
		timesPlayed = 0;
	}
	
	public void setFrames(Image[] frames) {
		this.frames = frames;
		currentFrame = 0;
		count = 0;
		delay = 2;
		timesPlayed = 0;
		numFrames = frames.length;
	}
	
	public void setDelay(int newDelay) {
		delay = newDelay;
	}
	
	public void setFrame(int newFrame) {
		currentFrame = newFrame;
	}
	
	public void setNumFrames(int number) {
		numFrames = number;
	}
	
	public void update() {
		
		if(delay == -1) return;
		
		count++;
		
		if(count == delay) {
			currentFrame++;
			count = 0;
		}
		if(currentFrame == numFrames) {
			currentFrame = 0;
			timesPlayed++;
		}
	}
	
	public int getFrame() {return currentFrame;}
	public int getCount() {return count;}
	public Image getImage() {return frames[currentFrame];}
	public boolean hasPlayedOnce() {
		return timesPlayed > 0;
	}
	
	public boolean hasPlayed(int i) {
		return timesPlayed == i;
	}
}
