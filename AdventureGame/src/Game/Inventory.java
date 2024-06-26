package Game;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Inventory {

	private List<Item> items = new ArrayList<Item>();
	private int index = 0;
	private List<Item> droppedItems = new ArrayList<Item>();
	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	private Item placeholder = new Item(0,0);
	private List<BufferedImage> itemImages = new ArrayList<BufferedImage>();

	public Inventory(List<BufferedImage> inventoryImages){
		 for (int i = 0; i < 8; i++) {
			 images.add(inventoryImages.get(0));
			 inventoryImages.remove(0);
		 }
		 this.itemImages = inventoryImages;
	}

	public BufferedImage getImage() {
		return this.images.get(index);
	}

	public int inventorySize() {
		return items.size();
	}

	public Item seeItem(int i) {
		return this.items.get(i);
	}

	public Item getItem() {
		return this.items.get(this.index);
	}
	
	public void addItemImage(BufferedImage image) {
		this.itemImages.add(image);
	}
	
	public BufferedImage getItemImage(int index) {
		return this.itemImages.get(index);
	}

	public boolean addItem(Item item) {
		if (item == null)
			return false;
		if (item instanceof Sword) {
			item.setInventoryImage(getItemImage(0));
			item.setImage(getItemImage(1));
		}
		else if (item instanceof Dog) {
			Dog dog = (Dog) item;
			dog.setDropped(false);
			item.setInventoryImage(getItemImage(3));
			item.setImage(getItemImage(2));
			item.images.add(getItemImage(2));
			item.images.add(getItemImage(2));
		}
		else if (item instanceof Ball) {
			item.setInventoryImage(getItemImage(5));
			item.setImage(getItemImage(4));
			item.images.add(getItemImage(4));
			item.images.add(getItemImage(4));
		}
		else if (item instanceof HeavyStone) {
			item.setInventoryImage(getItemImage(7));
			item.setImage(getItemImage(6));
			item.images.add(getItemImage(6));
			item.images.add(getItemImage(6));
		}
		for (int i = 0; i < inventorySize(); i++)
			if (items.get(i) == placeholder) {
				items.set(i, item);
				return true;
			}
		if (inventorySize() != 8)
			this.items.add(item);
		else
			return false;
		return true;

	}

	public void dropItem() {
		if (index < inventorySize()) {
			//if (items.get(index) instanceof Dog)
				//return;
			if (items.get(index) != placeholder) {
				if (index == inventorySize()-1) {
					droppedItems.add(getItem());
					this.items.remove(this.index);
				}
				else if (index < inventorySize()-1) {
					droppedItems.add(getItem());
					this.items.set(index, placeholder);
				}
			}
		}
	}

	public void incrementIndex() {
		if (index == 7)
			this.index = 0;
		else
			this.index++;
	}

	public void decrementIndex() {
		if (index == 0)
			this.index = 7;
		else
			this.index--;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int droppedItemsSize() {
		return droppedItems.size();
	}

	public List<Item> getDroppedItems() {
		return droppedItems;
	}

	public void clearDroppedItems() {
		droppedItems.clear();
	}
	
	public boolean inventoryContainsBall() {
		for (Item item : items)
			if (item instanceof Ball)
				return true;
		return false;
	}
}
