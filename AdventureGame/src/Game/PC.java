package Game;

import java.awt.event.KeyEvent;

public class PC extends Entity {

	
	public PC(int x,int y) {
		super(x,y);
		
		initPC();
	}
	
	private void initPC() {
		LoadSprites("src/Image/ExampleCharacter.png");
		loadImage(0,0);
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_W) {
			if(direction != 3) {
				dirchange = true;
			}

			this.moving = true;
			this.direction = 3;
		}
		if (key == KeyEvent.VK_S) {
			if(direction != 0) {
				dirchange = true;
			}
			this.moving = true;
			this.direction = 0;
		}
		if (key == KeyEvent.VK_A) {

			this.moving = true;
			if(direction != 1) {
				dirchange = true;
			}
			this.direction = 1;
		}
		if (key == KeyEvent.VK_D) {
			this.moving = true;
			if(direction != 2) {
				dirchange = true;
			}
			this.direction = 2;
		}
		switch (direction) {
		case 0:
			dy = 2;

			break;
		case 1:
			dx = -2;
			break;
		case 2:
			dx = 2;
			break;
		case 3:
			dy = -2;
			break;
		}
		dy_temp = dy;
		dx_temp = dx;
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			dy = 0;
			dy_temp =0;
		}
		if (key == KeyEvent.VK_S) {
			dy = 0;
			dy_temp =0;
		}
		if (key == KeyEvent.VK_A) {
			dx = 0;
			dx_temp =0;
		}
		if (key == KeyEvent.VK_D) {
			dx = 0;
			dx_temp =0;
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
		collision = a;
	}
	

}
