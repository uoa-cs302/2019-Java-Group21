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
	private BufferedImage img;
	
	public Inventory(){
		File f = new File("src/Image/Untitled.png");
		try {
			this.img = ImageIO.read(f);
			System.out.println("inventory loaded!");
		} catch (IOException e) {

			System.out.println("inventory failed :(");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage getImage() {
		return this.img;
	}
	
	public Item getItem() {
		return this.items.get(index);
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public void incrementIndex() {
		this.index++;
	}
	
	public void decrementIndex() {
		this.index++;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}
