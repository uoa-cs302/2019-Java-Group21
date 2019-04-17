package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Floor extends Sprite{

	private int x, y;

	enum Texture{
		NORMALTILE0,
		NORMALTILE1,
		BIGTILE0,
		BIGTILE1,
		SMALLTILE0,
		SMALLTILE1,
		NORMALTILE2,
		SMALLTILE2,
		BIGTILE2,
		BIGTILE3,
		WIDETILE0,
		WIDETILE1
	}

	public Floor(int x, int y) {
		super(x,y);
		this.x = x;
		this.y = y;
		LoadSprites("src/Image/dungeon0.png");
	}

	public void setTexture(int texture) {
		switch (texture) {
		case 0:
			loadImage(5, 8);
			break;
		case 1:
			loadImage(5, 9);
			break;
		case 2:
			loadImage(5, 10);
			break;
		case 3:
			loadImage(5, 11);
			break;
		case 4:
			loadImage(5, 12);
			break;
		case 5:
			loadImage(5, 13);
			break;
		case 6:
			loadImage(6, 8);
			break;
		case 7:
			loadImage(6, 9);
			break;
		case 8:
			loadImage(6, 10);
			break;
		case 9:
			loadImage(6, 11);
			break;
		case 10:
			loadImage(6, 12);
			break;
		case 11:
			loadImage(6, 13);
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
