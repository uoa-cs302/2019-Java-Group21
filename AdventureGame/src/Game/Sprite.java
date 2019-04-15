package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite {

	public enum Direction {
		UP, DOWN, LEFT, RIGHT
	};

	protected int x_pos;
	protected int y_pos;
	protected int width;
	protected int height;
	protected int right;
	protected int bottom;
	protected boolean visible;
	private boolean collidable = false;
	private int sheetW;
	private int sheetH;

	protected BufferedImage SpriteSheet;
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
	protected BufferedImage[][] sprites;
	protected int ID;
	private final int TILE_SIZE = 32;

	protected BufferedImage image;

	public Sprite(int x, int y) {
		this.x_pos = x;
		this.y_pos = y;
		visible = true;
		ID = ID_GENERATOR.getAndIncrement();

	}

	protected void LoadSprites(String sheet) {
		System.out.println("Load Sprites!");
		SpriteSheet = loadSheet(sheet);
		System.out.println("Sheet loaded");
		sheetW = this.SpriteSheet.getWidth() / TILE_SIZE;
		sheetH = this.SpriteSheet.getHeight() / TILE_SIZE;
		System.out.println("WH got");
		loadSprites();
		System.out.println("LoadSprites done");
	}

	private BufferedImage loadSheet(String sheet) {
		BufferedImage sheetIm = null;
		System.out.println("Sprite.loadSheet");
		File f = new File(sheet);
		try {
			System.out.println("Trying to read sprite resource");
			// sheetIm = ImageIO.read(getClass().getResourceAsStream(sheet));
			sheetIm = ImageIO.read(f);
			System.out.println("Read sprite resource ok!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Couldn't read sprite resource :-(");
			e.printStackTrace();
		}
		System.out.println("Sprite.loadSheet resource read");
		return sheetIm;
	}

	public void loadSprites() {
		this.sprites = new BufferedImage[sheetH][sheetW];

		for (int i = 0; i < sheetH; i++) {

			for (int j = 0; j < sheetW; j++) {

				this.sprites[i][j] = ExtractSprites(i, j);
				System.out.println(i + " " + j);
			}
		}

	}

	private BufferedImage ExtractSprites(int x, int y) {
		BufferedImage targ_sprite = SpriteSheet.getSubimage(y * TILE_SIZE, x * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		return targ_sprite;
	}

	protected void loadImage(int x, int y) {

		this.image = sprites[x][y];

		getImageDim();
	}
	
	protected void loadSpecificImage(String address) {
		File f = new File(address);
		try {
			this.image = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void getImageDim() {
		width = image.getWidth(null);
		height = image.getHeight(null);
		right = x_pos + width;
		bottom = y_pos + height;
	}

	public BufferedImage getImage() {
		return image;
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

	protected Rectangle getBoundary() {
		return new Rectangle(x_pos, y_pos, width, height);
	}

	public boolean isCollidable() {
		return collidable;
	}

	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}
	public int getID() {
		return ID;
	}
}
