package Game;

import java.awt.Image;
import java.util.List;
import java.util.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Entity extends Sprite{
	
	
	protected int direction;
	protected boolean moving;
	protected boolean dirchange;
	protected int dx;
	protected int dy;
	protected int dx_temp;
	protected int dy_temp;
	protected boolean collision;
	protected int damage;
	
	protected int health;
	
	protected int EntityID;
	/*EntityID values as follows
	 * 
	 * 0 = PC 
	 * 1 = GiantRat
	 * 2 = GiantSpider
	 * 3 = Skeleton
	 * 4 = Dog
	 * 5 = Child
	 * 
	 * EntityID Values are initialized on the subclass construction 
	
	*/
	public Entity(int x, int y) {
		super(x,y);
		super.setCollidable(true);
	}
	public int getEntityID() {
		return this.EntityID;
	}
	
	public int getdy() {
		return dy;
	}
	public int getdx() {
		return dx;
	}
	
	public void setdy(int dy) {
		this.dy = dy;
	}
	
	public void setdx(int dx) {
		this.dx = dx;
	}
	
	public void move(int frame_count) {
		
		x_pos += dx;
		right = x_pos + width;
		y_pos += dy;
		bottom = y_pos + height;
		
		dx = dx_temp;
		dy  =dy_temp;
		
	}
	
	public void wallCollide(Direction direction) {
		switch(direction) {
			case UP:
				if (this.getdy() < 0) {
					this.y_pos = y_pos + 4;
					
				}
				break;
					
			case DOWN:
				if (this.getdy() > 0) {
					this.y_pos = y_pos - 4;
					
				}
				break;
			case LEFT: 
				if (this.getdx() < 0) {
					this.x_pos = x_pos + 4;
					
				}
				break;
			case RIGHT: 
				if (this.getdx() > 0) {
					this.x_pos = x_pos - 4;
					
				}
				break;
		}
	}
	
public void CollisionProcess(int top,int bottom,int left, int right) {
		
		switch (this.check_collisiondir_Hoz(left, right)) {
		case 1:
			if(dx < 0) {
				dx = 0;
			}
			break;
		case 2:
			if(dx > 0) {
				dx = 0;
			}
			break;
		}
		switch(this.check_collisiondir_Vert( top, bottom)) {
		case 1:
			if(dy < 0) {
				
				dy = 0;
			}
			break;
		case 2:
			if(dy > 0) {
				dy = 0;
			}
			break;
		}

	}

 protected void hitBy(Entity e) {
	 this.health = health - e.getDamage();
	 if(health < 0) {
		 this.visible = false;
		 this.setCollidable(false);
	 }
	 
	 switch (e.getDirection()) {
	 case 0:
		 this.dx = 0;
		 this.dy = 32;
		 this.move(0);
		 break;
	 case 1:
		 this.dx = -32;
		 this.dy = 0;
		 this.move(0);
		 break;
	 case 2:
		 this.dx = 32;
		 this.dy = 0;
		 this.move(0);
		 break;
	 case 3:
		 this.dx = 0;
		 this.dy = -32;
		 this.move(0);
		 break;
	 }
 }
	protected int check_collisiondir_Hoz(int left2,int right2 ) {

		if (this.x_pos == right2 - 4) {
			return 1;
		} else if (this.right == left2 + 4) {
			return 2;
		} else {
			return 0;
		}
	}
	protected int check_collisiondir_Vert(int top2,int bottom2 ) {

		if (this.y_pos == bottom2 -4) {
			return 1;
		} else if (this.bottom == top2 + 4) {
			return 2;
		} else {
			return 0;
		}
	}
	
	public void AiUpdate(Entity target) {
		if (target == null) {
			dx = 0;
			dy = 0;
			
		}else {
		int xdiff;
		int ydiff;
		
		xdiff = target.getx_pos() - this.x_pos;
		ydiff = target.gety_pos() - this.y_pos;
		moving = true;

			
		if(ydiff>0 ) {
			direction = 0;
			dirchange = true;
			dy = 1;
		}else if (ydiff<0 ) {
			direction = 3;
			dirchange = true;
			dy = -1;
		} else {
			dirchange = true;
			dy=0;
		}
		if (xdiff>0) {
			direction = 2;
			dirchange = true;
			dx = 1;
		}else if (xdiff<0) {
			direction = 1;
			dirchange = true;
			dx = -1;
		} else {
			dx = 0;
		}
		
		}
	}
	
	public int getHealth() {
		return health;
	}
	public int getDamage() {
		return damage;
	}
	public int getDirection() {
		return direction;
	}

}
