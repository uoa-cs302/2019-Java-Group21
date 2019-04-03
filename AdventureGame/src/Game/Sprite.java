package Game;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {
	
	protected int x_pos;
	protected int y_pos;
	protected int width;
	protected int height;
	protected boolean visible;
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
	
	protected void getImageDim() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	public Image getImage() {
		return image;
	}
	
	public int getx_pos() {
		return x_pos;
	}
	public int gety_pos() {
		return y_pos;
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
}
