package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Sprite {
	
	public enum Direction {UP, DOWN, LEFT, RIGHT};
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
	protected BufferedImage[][] sprites;
	
	private final int TILE_SIZE = 32;
	
	protected BufferedImage image;
	
	public Sprite(int x, int y) {
		this.x_pos = x;
		this.y_pos = y;
		visible = true;

	}
	
	protected void LoadSprites(String sheet) {

		SpriteSheet = loadSheet(sheet);
		
		sheetW = this.SpriteSheet.getWidth() / TILE_SIZE;
		sheetH = this.SpriteSheet.getHeight() / TILE_SIZE;
		
		loadSprites();
	
	}
	
	
	private BufferedImage loadSheet(String sheet) {
		BufferedImage sheetIm = null;
		
		try {
			sheetIm = ImageIO.read(getClass().getResourceAsStream(sheet));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sheetIm;
	}
	

	public void loadSprites() {
		this.sprites = new BufferedImage[sheetH][sheetW];	
		
		for(int i = 0;i<sheetH;i++) {
		
			for (int j = 0; j<sheetW;j++ ) {
				
				this.sprites[i][j] = ExtractSprites(i,j);
				System.out.println(i +" "+j);
			}
		}
		
		
	}
	private BufferedImage ExtractSprites(int x,int y) {
		BufferedImage targ_sprite = SpriteSheet.getSubimage(y*TILE_SIZE, x*TILE_SIZE, TILE_SIZE, TILE_SIZE);
		return targ_sprite;
	}

protected void loadImage(int x,int y) {
	
	this.image = sprites[x][y];

	getImageDim();
}
	
	protected void getImageDim() {
		width = image.getWidth(null);
		height = image.getHeight(null);
		right = x_pos + width ;
		bottom = y_pos + height ;
	}
	public Image getImage() {
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
		return new Rectangle(x_pos,y_pos,width,height);
		}

	public boolean isCollidable() {
		return collidable;
	}

	public void setCollidable(boolean collidable) {
		this.collidable = collidable;
	}
}
