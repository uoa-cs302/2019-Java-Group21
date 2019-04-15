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
	private List<BufferedImage> images = new ArrayList<BufferedImage>();
	private Item placeholder = new Item(0,0);
	
	public Inventory(){
		File f;
		for (int i = 0; i < 8; i++) {

			f = new File("src/Image/inv" + i + ".png");
			try {
				this.images.add(ImageIO.read(f));
				System.out.println("read inv" + i + ".png");
			} catch (IOException e) {

				System.out.println("inventory failed :(");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
	
	public void addItem(Item item) {
		for (int i = 0; i < items.size(); i++)
			if (items.get(i) == placeholder) {
				items.set(i, item);
				return;
			}
		if (items.size() != 8)
			this.items.add(item);
	}
	
	public void dropItem() {
		if (index == items.size()-1)
			this.items.remove(this.index);
		else if (index < items.size()-1)
			this.items.set(index, placeholder);
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
}
