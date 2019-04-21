package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT, IDLE
	};

	protected int x_pos;
	protected int y_pos;
	protected int width;//make sure all these have getters
	protected int height;
	protected int right;
	protected int bottom;
	protected boolean visible;
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	private int ID;
	protected List<BufferedImage> images;
	private BufferedImage image;

	public Sprite(int x, int y) {
		this.x_pos = x;
		this.y_pos = y;
		visible = true;
		ID = ID_GENERATOR.getAndIncrement();
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void setImages(List<BufferedImage> images) {
		this.images = images;
		System.out.println("setting image!" + images.size());
	}
	
	public List<BufferedImage> getImages(){
		return this.images;
	}
	
	public List<BufferedImage> getFromImages(int start, int end){
		if (start >= 0 && end < images.size())
			return this.images.subList(start, end +1);
		else
			return null;
	}

	void getImageDim() {
		width = 32;
		height = 32;
		right = x_pos + width;
		bottom = y_pos + height;
	}

	public int getx_pos() {
		return x_pos;
	}

	public void setx_pos(int x_pos) {
		this.x_pos = x_pos;
	}

	public int gety_pos() {
		return y_pos;
	}

	public void sety_pos(int y_pos) {
		this.y_pos = y_pos;
	}

	public int getright() {
		return right;
	}

	public int getbottom() {
		return bottom;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getID() {
		return ID;
	}
}
