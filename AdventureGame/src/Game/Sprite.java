package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {
	
	protected int x_pos;
	protected int y_pos;
	protected int width;
	protected int height;
	protected int right;
	protected int bottom;
	protected boolean visible;
	private int id;
	private boolean collidable = false;
	
	protected Image image;
	
	public Sprite(int x, int y) {
		
		this.x_pos = x;
		this.y_pos = y;
		visible = true;
	}

protected void loadImage(String imageName) {
		
		ImageIcon ii = new ImageIcon(imageName) ;
		image = ii.getImage();
	}
protected void loadImage(Image imageName) {
	
	image = imageName;
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
