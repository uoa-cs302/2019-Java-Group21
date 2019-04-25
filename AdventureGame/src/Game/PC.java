package Game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

public class PC extends Entity {
	
	
	private Inventory inventory;
	private boolean itemPickUp = false;
	
	
	public PC(int x,int y, List<BufferedImage> images) {
		super(x,y);
		setImages(images);
		this.getImageDim();
		this.health = 6;
		this.damage = 1;
		inventory = new Inventory();
		System.out.println("setting frames in player class");
		this.ani.setFrames(this.getImages().subList(0, 3));
		System.out.println("setting frame in player class");
		this.ani.setFrame(1);
		this.ani.setDelay(-1);
		
		//initital base intialisation
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width-12,this.height/2);
		Bounds.setxOff(6);
		Bounds.setyOff(16);
		Hitbounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height );
		Hitbounds.setyOff(16);
		
	}
	public void update() {
		super.update();
	}
	
	public void move() {
		if(up) {
			dy = -2;
		}else {
			if (dy < 0) {dy =0;}
		}if(left) {
			dx = -2;
		}else {
			if (dx < 0) {dx =0;}
		}if(down) {
			dy = 2;
		}else {
			if (dy > 0) { dy =0;}
		}if(right) {
			dx = 2;
		}else {
			if (dx > 0) {dx =0;}
		}
		if (dx ==0 && dy ==0) {
			this.direction = Direction.IDLE;
		}
	}
	

	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {

			up = true;
			this.direction = Direction.UP;

		}
		if (key == KeyEvent.VK_S) {
			
			down = true;
			this.direction = Direction.DOWN;

		}
		if (key == KeyEvent.VK_A) {


			left =true;
			this.direction = Direction.LEFT;

		}
		if (key == KeyEvent.VK_D) {

			
			right = true;
			this.direction = Direction.RIGHT;

		}
		if (key == KeyEvent.VK_LEFT) {
			inventory.decrementIndex();
		}
		if (key == KeyEvent.VK_RIGHT) {
			inventory.incrementIndex();
		}
		if (key == KeyEvent.VK_UP) {
			setItemPickUp(true);
		}
		if (key == KeyEvent.VK_DOWN) {
			inventory.dropItem();
		}
		// Temporary
		// Used to add sword to inventory for testing
		if (key == KeyEvent.VK_L) {
			Sword sword = new Sword(0,0);
			inventory.addItem(sword);
		}
		if(key == KeyEvent.VK_SPACE) {
			this.Attack = true;

		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			up = false;
		}
		if (key == KeyEvent.VK_S) {
			down = false;
		}
		if (key == KeyEvent.VK_A) {
			left = false;
		}
		if (key == KeyEvent.VK_D) {
			right = false;
		}

		if (key == KeyEvent.VK_UP) {
			setItemPickUp(false);
		}
		
	}
	public void setCollided(boolean a) {
		collision = a;
	}

	public Inventory getInventory(){
		return this.inventory;
	}

	public boolean isItemPickUp() {
		return itemPickUp;
	}

	public void setItemPickUp(boolean itemPickUp) {
		this.itemPickUp = itemPickUp;
	}
}
