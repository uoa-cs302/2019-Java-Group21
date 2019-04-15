package Game;

import java.awt.event.KeyEvent;

public class PC extends Entity {
	
	private boolean UP = false;
	private boolean DOWN = false;
	private boolean LEFT = false;
	private boolean RIGHT = false;

	
	public PC(int x,int y) {
		super(x,y);
		this.health = 6;
		
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
			UP = true;

			this.moving = true;
			this.direction = 3;
		}
		if (key == KeyEvent.VK_S) {
			if(direction != 0) {
				dirchange = true;
			}
			DOWN = true;
			this.moving = true;
			this.direction = 0;
		}
		if (key == KeyEvent.VK_A) {

			this.moving = true;
			if(direction != 1) {
				dirchange = true;
			}
			LEFT =true;
			this.direction = 1;
		}
		if (key == KeyEvent.VK_D) {
			this.moving = true;
			if(direction != 2) {
				dirchange = true;
			}
			RIGHT = true;
			this.direction = 2;
		}
		if(moving) {
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
		
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_W) {
			dy = 0;
			dy_temp =0;
			UP =false;
			if (DOWN) {dy_temp = 2;direction = 0;}
		}
		if (key == KeyEvent.VK_S) {
			dy = 0;
			dy_temp =0;
			DOWN = false;
			if (UP) {dy_temp = -2;direction = 3;}
		}
		if (key == KeyEvent.VK_A) {
			dx = 0;
			dx_temp =0;
			LEFT = false;
			if (RIGHT) {dx_temp = 2; direction = 2;}
		}
		if (key == KeyEvent.VK_D) {
			dx = 0;
			dx_temp =0;
			RIGHT = false;
			if (LEFT) {dx_temp = -2; direction = 1;}
		}
		if (!(RIGHT || LEFT || UP || DOWN) ) {
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
	
	public void move(int frame_count) {
		if (dirchange) {
			frame_count = 0;
			dirchange = false;
		}
		
		if (moving == false) {
			switch (direction) {
			case 0:
				loadImage(0,1);
				break;
			case 1:
				loadImage(1,1);
				break;
			case 2:
				loadImage(2,1);
				break;
			case 3:
				loadImage(3,1);
				break;
				}
			} else {
				switch(direction) {
				case 0:
					switch(frame_count % 28) {
					case 21:
						loadImage(0,0);
					break;
					case 14:
						loadImage(0,1);
						break;
					case 7:
						loadImage(0,2);
						break;
					case 6:
						loadImage(0,1);
						break;
					}
					break;
				case 1:
					switch(frame_count % 28) {
					case 21:
						loadImage(1,0);
					break;
					case 14:
						loadImage(1,1);
						break;
					case 7:
						loadImage(1,2);
						break;
					case 6:
						loadImage(1,1);
						break;
					}
					break;
				case 2:
					switch(frame_count % 28) {
					case 21:
						loadImage(2,0);
					break;
					case 14:
						loadImage(2,1);
						break;
					case 7:
						loadImage(2,2);
						break;
					case 6:
						loadImage(2,1);
						break;
					}
					break;
				case 3:
					switch(frame_count % 28) {
					case 21:
						loadImage(3,0);
					break;
					case 14:
						loadImage(3,1);
						break;
					case 7:
						loadImage(3,2);
						break;
					case 6:
						loadImage(3,1);
						break;
					}
					break;
				}
				
			}
		//else moving
		//collision handling


		x_pos += dx;
		right = x_pos + width;
		y_pos += dy;
		bottom = y_pos + height;
		
		dx = dx_temp;
		dy  =dy_temp;
		
	}
	

}
