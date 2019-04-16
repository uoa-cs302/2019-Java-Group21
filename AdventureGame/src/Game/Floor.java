package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Floor extends Sprite{

	private int x, y;
	private BufferedImage texture;

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
			ExtractSprites(6, 7);
		case 1:
			ExtractSprites(6, 8);
		case 2:
			ExtractSprites(6, 9);
		case 3:
			ExtractSprites(6, 10);
		case 4:
			ExtractSprites(6, 11);
		case 5:
			ExtractSprites(6, 12);
		case 6:
			ExtractSprites(6, 13);
		case 7:
			ExtractSprites(7, 7);
		case 8:
			ExtractSprites(7, 8);
		case 9:
			ExtractSprites(7, 9);
		case 10:
			ExtractSprites(7, 10);
		case 11:
			ExtractSprites(7, 11);
		case 12:
			ExtractSprites(7, 12);
		case 13:
			ExtractSprites(7, 13);
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