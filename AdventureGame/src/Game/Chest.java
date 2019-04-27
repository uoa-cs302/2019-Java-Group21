package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Chest extends Entity{

	public Stack<Item> contents;
	public boolean open;

	public Chest(int x, int y, List<BufferedImage> images) {
		super(x,y);
		this.setImages(images);
		this.setImage(images.get(0));
		super.setCollidable(true);
		open = false;
		contents = new Stack<Item>();
		setBounds(new Collision((int)this.x_pos,(int)this.y_pos,this.width-2,this.height));
		//Bounds.setxOff(1);
		setHitBounds(new Collision((int)this.x_pos,(int)this.y_pos,this.width-2,this.height-24));
		//Hitbounds.setxOff(1);
		this.Hitbounds.setyOff(32);
	}
	
	public void update() {
		if(isOpen())
			this.setImage(this.images.get(1));
		else
			this.setImage(this.images.get(0));
	}
	
	public void addItem(Item item) {
		contents.push(item);
	}
	
	public Item getItem() {
		if (contents.empty())
			return null;
		else
			return contents.pop();
	}

	
	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
}
