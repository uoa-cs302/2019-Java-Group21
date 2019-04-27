package Game;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {

	private List<BufferedImage> frames;
	private int count;
	private int DELAY;

	private int curFrame;
	private int numFrame;

	private int timesPlayed;

	public Animation(List<BufferedImage> frames) {
		timesPlayed = 0;
		setFrames(frames);
	}
	public Animation() {
		timesPlayed=0;
	}

	public void setFrames(List<BufferedImage> frames) {
		this.frames = frames;
		this.curFrame = 0;
		this.count = 0;
		this.DELAY = 5;
		this.numFrame = frames.size();
		this.timesPlayed = 0;
	}

	public void setDelay(int delay) {this.DELAY = delay;}
	public void setFrame(int i) {this.curFrame = i;}
	public void setFrameNum(int i) {this.numFrame = i;}

	public void update() {
		if (DELAY == -1)
			return;
		count++;
		if (count == DELAY) {
			curFrame++;
			count = 0;
		}
		if (curFrame == numFrame) {
			curFrame = 0;
			timesPlayed++;
		}


	}

	public int getDelay() {return DELAY;}
	public int getFrame() {return curFrame;}
	public int getCount() {return count;}
	public BufferedImage getImage() {return frames.get(curFrame);}
	public List<BufferedImage> getframes() {return frames;}
	public boolean PlayedOnce() {return timesPlayed > 0;}
	public boolean Played(int i) {return timesPlayed == i;}

}
