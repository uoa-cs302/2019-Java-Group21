package Game;

import java.awt.image.BufferedImage;

public class Item extends Entity{

	BufferedImage inventoryImage;
	
	public Item(int x, int y) {
		super(x, y);
		super.setCollidable(true);
		this.inventoryImage = loadSpecificImage("src/Image/blank.png");
	}

	public BufferedImage getInventoryImage() {
		return this.inventoryImage;
	}
	
	
}
