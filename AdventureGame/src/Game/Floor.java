package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Floor extends Sprite{

	private int x, y;

	public Floor(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		LoadSprites("src/Image/dungeon0.png");
	}

	public void setTexture(int texture) {
		switch (texture) {
		case 23:
			loadImage(1, 7);
			break;
		case 24:
			loadImage(1, 8);
			break;
		case 88:
			loadImage(5, 8);
			break;
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
