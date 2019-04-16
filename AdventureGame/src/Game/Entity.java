package Game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Game.Sprite.Direction;

public class Entity extends Sprite {
	
	
	protected Direction direction = Direction.IDLE;
	protected int dx;
	protected int dy;
	private boolean collidable = false;
	
	
	protected int dx_temp;
	protected int dy_temp;
	protected boolean collision;
	protected int damage;
	protected Animation ani;
	protected Direction curAnim;
	protected Sprite sprite;
	
	protected boolean Attack;
	protected int AttackSpeed;
	protected int AttackDuration;
	
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
	public Entity(int x,int y){
		super(x,y);
		setCollidable(true);
		ani = new Animation();
		direction = Direction.DOWN;
		
	}
	public int getEntityID() {return this.EntityID;}
	public int getdy() {return dy;}
	public int getdx() {return dx;}
	public void setdy(int dy) {this.dy = dy;}
	public void setdx(int dx) {this.dx = dx;}	
	public int getHealth() {return health;}
	public int getDamage() {return damage;}
	public Direction getDirection() {return direction;}
	public Animation getAnimation() {return ani;}
	public boolean isCollidable() {return collidable;}
	public void setCollidable(boolean collidable) {this.collidable = collidable;}
	public Rectangle getBoundary() {return new Rectangle(x_pos, y_pos, width, height);}
	
	public void setAnimation(Direction i,BufferedImage[] frames, int delay) {
		curAnim = i;
		ani.setFrames(frames);
		ani.setDelay(delay);
		ani.setFrame(1);
	}
	
	public void animate() {
		switch (this.direction) {
		case UP:
			if (curAnim != Direction.UP || ani.getDelay() == -1) {
				setAnimation(Direction.UP,this.getSpriteArray(Direction.UP),15);
			}
			break;
		case DOWN:
			if (curAnim != Direction.DOWN || ani.getDelay() == -1) {
				setAnimation(Direction.DOWN,this.getSpriteArray(Direction.DOWN),15);
			}
			break;
		case LEFT:
			if (curAnim != Direction.LEFT || ani.getDelay() == -1) {
				setAnimation(Direction.LEFT,this.getSpriteArray(Direction.LEFT),15);
			}
			break;
		case RIGHT:
			if (curAnim != Direction.RIGHT || ani.getDelay() == -1) {
				setAnimation(Direction.RIGHT,this.getSpriteArray(Direction.RIGHT),15);
			}
			break;
		case IDLE:
			setAnimation(curAnim,this.getSpriteArray(curAnim),-1);
			break;
		}
	}
	
	public void update() {};
	public void update(Entity target) {};
	public void move() {}
	
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
	 switch (e.getDirection()){
	 case DOWN:
		 this.y_pos += 48;
		 break;
	 case LEFT:
		 this.x_pos += -48;
		 break;
	 case RIGHT:
		 this.x_pos += 48;
		 break;
	 case UP:
		this. y_pos += -48;
		 break;
		 default:
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
}
