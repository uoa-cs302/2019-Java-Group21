package Game;

import java.awt.event.KeyEvent;
import java.util.List;

public class PC extends Entity {
	
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private Inventory inventory;
	private boolean itemPickUp = false;
	
	public PC(int x,int y) {
		super(x,y);
		this.health = 6;
		initPC();
		inventory = new Inventory();
		this.ani.setFrames(this.getSpriteArray(Direction.DOWN));
		this.ani.setFrame(1);
		this.ani.setDelay(-1);
	}
	@Override
	public void update() {

		move();
		animate();
		image();
		x_pos +=dx;
		y_pos += dy;
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
	public void image() {
		this.ani.update();
		this.image = this.ani.getImage();
	}
	
	private void initPC() {
		LoadSprites("src/Image/ExampleCharacter.png");
		loadImage(0,0);
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
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {

			up =false;
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
