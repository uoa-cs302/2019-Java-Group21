package Game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import Game.Sprite.Direction;

public class PC extends Entity {
	
	
	private Inventory inventory;
	private boolean itemPickUp = false;
	private Animation slash;
	private BufferedImage slashim;
	
	
	public PC(int x,int y, List<BufferedImage> images) {
		super(x,y);
		setSlash(new Animation());
		setImages(images);
		this.getImageDim();
		this.health = 6;
		this.damage = 1;
		inventory = new Inventory();
		this.ani.setFrames(this.getImages().subList(0, 3));
		this.slash.setFrames(this.getImages().subList(27, 32));
		this.slash.setDelay(-1);
		this.slash.setFrame(0);
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
	public void animate() {
		switch (this.direction) {
		case UP:
			
			if (curAnim != Direction.UP || ani.getDelay() == -1) {
				System.out.println("loading up animation");
				setAnimation(Direction.UP,this.getFromImages(9, 11),15);
			}
			if (curAnim != Direction.UP ||slash.getDelay() == -1) {
				this.slash.setFrames(this.getImages().subList(22, 27));
			}
				if (attacking && !slash.PlayedOnce()) {slash.setDelay(7);}
			 else {slash.setDelay(-1);}
			break;
		case DOWN:
			
			if (curAnim != Direction.DOWN || ani.getDelay() == -1) {

				setAnimation(Direction.DOWN,this.getFromImages(0, 2),15);
	
			}
			if (curAnim != Direction.DOWN ||slash.getDelay()==-1) {
				this.slash.setFrames(this.getImages().subList(27, 32));
			}

			if (attacking && !slash.PlayedOnce()) {slash.setDelay(7);}	
		else {slash.setDelay(-1);}
			break;
		case LEFT:
			
			
			if (curAnim != Direction.LEFT || ani.getDelay() == -1) {
				setAnimation(Direction.LEFT,this.getFromImages(3, 5),15);

			}
			if (curAnim != Direction.LEFT ||slash.getDelay()==-1) {
				this.slash.setFrames(this.getImages().subList(12, 17));
			}
			if (attacking && !slash.PlayedOnce()) {slash.setDelay(7);}	
			else {slash.setDelay(-1);}
			break;
		case RIGHT:
			
				
			if (curAnim != Direction.RIGHT || ani.getDelay() == -1) {
				setAnimation(Direction.RIGHT,this.getFromImages(6, 8),15);			
			}
			if (curAnim != Direction.RIGHT ||slash.getDelay()==-1) {
				this.slash.setFrames(this.getImages().subList(17,22 ));	
			}
			if (attacking && !slash.PlayedOnce()) {slash.setDelay(7);}	
			else {slash.setDelay(-1);}
			break;
		case IDLE:
			if (curAnim == Direction.IDLE ||slash.getDelay() == -1) {
				switch (this.direction) {
				case UP:
					this.slash.setFrames(this.getImages().subList(22, 27));
					break;
				case LEFT:
					this.slash.setFrames(this.getImages().subList(12, 17));
					break;
				case RIGHT:
					this.slash.setFrames(this.getImages().subList(17,22 ));	
					break;
				case DOWN:
					this.slash.setFrames(this.getImages().subList(27, 32));
					break;
				case IDLE:
					this.slash.setFrames(slash.getframes());
				}
			}
			
			if (attacking && !slash.PlayedOnce()) {slash.setDelay(7);}
			else { slash.setDelay(-1);}
			setAnimation(curAnim,ani.getframes(),-1);

			break;
	
	}
}
	
	
	public void image() {
		this.ani.update();
		this.slash.update();
		this.setImage(this.ani.getImage());
		this.slashim = (this.slash.getImage());
		
	}
	
	public void move() {
		if(up) {
			dy = -2;
			direction = Direction.UP;
		}else {
			if (dy < 0) {dy =0;}
		}if(down) {
			dy = 2;
			direction = Direction.DOWN;
		}else {
			if (dy > 0) { dy =0;}
		}
		if(left) {
			dx = -2;
			direction = Direction.LEFT;
		}else {
			if (dx < 0) {dx =0;}
		}
		
		if(right) {
			dx = 2;
			direction = Direction.RIGHT;
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
	public Animation getSlash() {
		return slash;
	}
	public void setSlash(Animation slash) {
		this.slash = slash;
	}
	public BufferedImage getSlashim() {
		return slashim;
	}
	public void setSlashim(BufferedImage slashim) {
		this.slashim = slashim;
	}
}
