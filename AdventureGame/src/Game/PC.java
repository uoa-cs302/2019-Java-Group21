package Game;

import java.awt.event.KeyEvent;

public class PC extends Entity {

	private boolean collided;

	
	public PC(int x,int y) {
		super(x,y);
		
		initPC();
	}
	
	private void initPC() {
		loadImage("src/Image/tile001.png");
		getImageDim();
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			dy = -2;
			this.moving = true;
			if(direction != 3) {
				dirchange = true;
			}
			this.direction = 3;
		}
		if (key == KeyEvent.VK_S) {
			dy = 2;
			this.moving = true;
			if(direction != 0) {
				dirchange = true;
			}
			this.direction = 0;
		}
		if (key == KeyEvent.VK_A) {
			dx = -2;
			this.moving = true;
			if(direction != 1) {
				dirchange = true;
			}
			this.direction = 1;
		}
		if (key == KeyEvent.VK_D) {
			dx = 2;
			this.moving = true;
			if(direction != 2) {
				dirchange = true;
			}
			this.direction = 2;
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			dy = 0;

		}
		if (key == KeyEvent.VK_S) {
			dy = 0;

		}
		if (key == KeyEvent.VK_A) {
			dx = 0;

		}
		if (key == KeyEvent.VK_D) {
			dx = 0;

		}
		if (dx == 0 && dy == 0 ) {
			this.moving = false;
		} 
		if(dx < 0) {
			this.direction = 1;
		}
		if (dy < 0) {
			this.direction = 3;
		}
		if (dx > 0) {
			this.direction = 2;
		}
		if (dy > 0) {
			this.direction = 0;
		}
	}
	public void setCollided(boolean a) {
		collided = a;
	}
	protected void CollisionBlock() {
		
		if (direction == 0 || direction == 3) {
			y_pos -= dy;
		} else if (direction == 1 ||direction == 2) {
			x_pos -= dx;
		}

	}

}
