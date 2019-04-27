package Game;

import java.awt.image.BufferedImage;

public class Item extends Entity{

	BufferedImage inventoryImage;
	
	public Item(int x, int y) {
		super(x, y);
		super.setCollidable(true);
		super.setBounds(new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height));
	}

	public BufferedImage getInventoryImage() {
		return this.inventoryImage;
	}
	
	public void setInventoryImage(BufferedImage image) {
		this.inventoryImage = image;
	}
}
