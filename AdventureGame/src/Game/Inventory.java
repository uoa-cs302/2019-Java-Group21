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
	
	public Item getItem() {
		return this.items.get(index);
	}
	
	public void addItem(Item item) {
		this.items.add(item);
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
