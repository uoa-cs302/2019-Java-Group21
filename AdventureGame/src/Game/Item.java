package Game;

import java.awt.image.BufferedImage;

public class Item extends Entity{

	BufferedImage inventoryImage;
	
	public Item(int x, int y) {
		super(x, y);
		super.setCollidable(true);
	}

	public BufferedImage getInventoryImage() {
		return this.inventoryImage;
	}
	
	public void setInventoryImage(BufferedImage image) {
		this.inventoryImage = image;
	}
}
