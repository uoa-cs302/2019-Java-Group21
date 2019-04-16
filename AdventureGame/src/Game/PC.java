package Game;

import java.awt.event.KeyEvent;
import java.util.List;

public class PC extends Entity {
	

	private boolean UP = false;
	private boolean DOWN = false;
	private boolean LEFT = false;
	private boolean RIGHT = false;
	private Inventory inventory;

	
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
			UP = true;
			this.direction = Direction.UP;
		}
		if (key == KeyEvent.VK_S) {
			
			DOWN = true;
			this.direction = Direction.DOWN;
		}
		if (key == KeyEvent.VK_A) {

			LEFT =true;
			this.direction = Direction.LEFT;
		}
		if (key == KeyEvent.VK_D) {
			
			RIGHT = true;
			this.direction = Direction.RIGHT;
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			UP =false;
		}
		if (key == KeyEvent.VK_S) {
			DOWN = false;
		}
		if (key == KeyEvent.VK_A) {
			LEFT = false;
		}
		if (key == KeyEvent.VK_D) {
			RIGHT = false;
		}
	}
	public void setCollided(boolean a) {
		collision = a;
	}
	
	public void move() {
		if(UP) {
			dy = -2;
		}else {
			if (dy < 0) {dy =0;}
		}if(LEFT) {
			dx = -2;
		}else {
			if (dx < 0) {dx =0;}
		}if(DOWN) {
			dy = 2;
		}else {
			if (dy > 0) { dy =0;}
		}if(RIGHT) {
			dx = 2;
		}else {
			if (dx > 0) {dx =0;}
		}
		
		if (dx ==0 && dy ==0) {
			this.direction = Direction.IDLE;
		}
	}
	

	public Inventory getInventory(){
		return this.inventory;
	}
}
