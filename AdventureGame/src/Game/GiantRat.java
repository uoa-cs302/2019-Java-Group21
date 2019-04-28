package Game;

import java.awt.image.BufferedImage;
import java.util.List;

public class GiantRat extends Entity {

	private boolean charging = false;
	private int count = 0;
	private int dy_lock;
	private int dx_lock;

	public GiantRat(int x,int y,List <BufferedImage> images){
		super(x,y);
		setImages(images);
		this.getImageDim();
		initRat();
		this.ani.setFrames(this.getImages());
		this.ani.setFrame(1);
		this.ani.setDelay(-1);
		this.AttackDuration = 90;
	}
	private void initRat() {
		damage = 1;
		health = 4;

		//initital base intialisation
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height/2);
		Bounds.setyOff(16);
		Hitbounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width/2,this.height/2 );
		super.setCollidable(true);

	}
	public void update(Entity target) {
		AiUpdate(target);
	}
	public void animate() {
		switch (this.direction) {
		case UP:
			this.ani.setFrame(2);
			break;
		case DOWN:
			this.ani.setFrame(3);
			break;
		case LEFT:
			this.ani.setFrame(1);
			break;
		case RIGHT:
			this.ani.setFrame(0);
			break;
		case IDLE:
			this.ani.setFrame(0);
			break;
		default:
			this.ani.setFrame(0);
			break;
		}
	}
	public void CollisionProcess(Collision b) {
		dx = 0;
		dy = 0;
		dx_lock = (int)dx;
		dy_lock = (int)dy;
	}
	
	public void setHitboxDirection() {

		switch(this.direction) {
		case UP:
			this.Hitbounds.setxOff(8);
			this.Hitbounds.setyOff(-10);
			break;
		case DOWN:
			this.Hitbounds.setxOff(8);
			this.Hitbounds.setyOff(26);
			break;
		case LEFT:
			this.Hitbounds.setxOff(-10);
			this.Hitbounds.setyOff(8);
			break;
		case RIGHT:
			this.Hitbounds.setxOff(26);
			this.Hitbounds.setyOff(8);
			break;
		}
	}

	public void AiUpdate(Entity target) {
		
		if (!this.knockedBack) {
			if (target == null) {
				dx = 0;
				dy = 0;
			}	
			else {
				float xdiff = target.getx_pos() - this.x_pos;
				float ydiff = target.gety_pos() - this.y_pos;
				float distance = (int) Math.hypot((double) xdiff/32,(double) ydiff/32);
				if(count>=200||count == 0) {
					if(ydiff>0 ) {
						direction = Direction.DOWN;
						dy = 1;
					}
					else if (ydiff<0 ) {
						direction = Direction.UP;
						dy = -1;
					}
					else {dy =0;}
	
					if (xdiff>0) {
						direction = Direction.RIGHT;
						dx = 1;
					}
					else if (xdiff<0) {
						direction = Direction.LEFT;
						dx = -1;
					}
					else {dx=0;}
				}
	
				if (distance <= 5 && charging == false) {
					charging = true;
					count = 0;
					dx = dx*3;
					dy = dy*3;
					dx_lock = (int)dx;
					dy_lock = (int)dy;
	
				}
				else if(charging && count <80) {
					count++;
					dx = dx_lock;
					dy = dy_lock;
				}
				else if (charging && count <600 && count>=80) {
					count++;
				}
				else if (charging && count == 600) {
					charging = false;
					count = 0;
				}
			}
		} else if (knockedBack && this.knockBackCounter == 20) {
			knockBackCounter = 0;
			knockedBack = false;
		} else if (knockedBack && this.knockBackCounter < 20) {
			System.out.println("y");
			if (knockBackCounter > 0) {
			dx = 0;
			dy = 0;
			}
			knockBackCounter++;
		}
	}
}

