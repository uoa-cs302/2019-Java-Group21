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
	protected int size;
	
	protected int dx_temp;
	protected int dy_temp;
	protected boolean collision;
	protected int damage;
	protected Animation ani;
	protected Direction curAnim;
	protected Sprite sprite;
	protected Collision Bounds;
	protected Collision Hitbounds;
	protected List<BufferedImage> idlesprites;
	
	protected boolean Attack;
	protected int AttackSpeed;
	protected int AttackDuration = 30;
	
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
		size = 32;
		width = 32;
		height = 32;
	}
	
	public int getEntityID() {return this.EntityID;}
	public int getdy() {return dy;}
	public int getdx() {return dx;}
	public int getsize() {return size;}
	public void setsize(int s) {this.size = s;}
	public void setdy(int dy) {this.dy = dy;}
	public void setdx(int dx) {this.dx = dx;}	
	public int getHealth() {return health;}
	public int getDamage() {return damage;}
	public Direction getDirection() {return direction;}
	public Animation getAnimation() {return ani;}
	public boolean isCollidable() {return collidable;}
	public void setCollidable(boolean collidable) {this.collidable = collidable;}
	public Collision getBounds() {return Bounds;}
	public Collision getHitBounds() {return Hitbounds;}
	
	//may be obselete
	public Rectangle getBoundary() {return new Rectangle(x_pos, y_pos, width, height);}
	
	public void setAnimation(Direction i,List<BufferedImage> frames, int delay) {
		curAnim = i;
		System.out.println("setting up frames");
		System.out.println(frames.size());
		this.getImageDim();
		ani.setFrames(frames);
		System.out.println("setting up delay");
		ani.setDelay(delay);
		ani.setFrame(1);
	}
	
	public void setBounds(Collision c) {this.Bounds = c;}
	
	public void setHitBounds(Collision c) {this.Bounds = c;}
	
	public void animate() {
		switch (this.direction) {
		case UP:
			if (curAnim != Direction.UP || ani.getDelay() == -1) {
				System.out.println("loading up animation");
				setAnimation(Direction.UP,this.getFromImages(9, 11),15);
			}
			break;
		case DOWN:
			if (curAnim != Direction.DOWN || ani.getDelay() == -1) {
				
				setAnimation(Direction.DOWN,this.getFromImages(0, 2),15);
			}
			break;
		case LEFT:
			if (curAnim != Direction.LEFT || ani.getDelay() == -1) {
				setAnimation(Direction.LEFT,this.getFromImages(3, 5),15);
			}
			break;
		case RIGHT:
			if (curAnim != Direction.RIGHT || ani.getDelay() == -1) {
				setAnimation(Direction.RIGHT,this.getFromImages(6, 8),15);
			}
			break;
		case IDLE:
			
			setAnimation(curAnim,ani.getframes(),-1);
			
			break;
		}
	}
	
	public void update() {
	
		animate();
		image();
		setHitboxDirection();
		Bounds.setBox(this.x_pos, this.y_pos, (int)Bounds.getwidth(),(int) Bounds.getheight());
		Hitbounds.setBox(this.x_pos, this.y_pos, (int) Hitbounds.getwidth(),(int) Hitbounds.getheight());
		x_pos += dx;
		right = x_pos + width;
		y_pos += dy;
		bottom = y_pos + height;
		move();

		}
	
	public void update(Entity target) {
		update();
	};
	public void move() {}
	public void image() {
		this.ani.update();
		this.setImage(this.ani.getImage());
	}
	
	public void setHitboxDirection() {
	
		switch(this.direction) {
		case UP:
			this.Hitbounds.setxOff(0);
			this.Hitbounds.setyOff(-16);
			break;
		case DOWN:
			this.Hitbounds.setxOff(0);
			this.Hitbounds.setyOff(16);
			break;
		case LEFT:
			this.Hitbounds.setxOff(-16);
			this.Hitbounds.setyOff(0);
			break;
		case RIGHT:
			this.Hitbounds.setxOff(16);
			this.Hitbounds.setyOff(0);
			break;
		}
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
		System.out.println("collision attempting");
		switch (this.check_collisiondir_Hoz(left, right)) {
		case 1:
			if(dx < 0) {
				this.setx_pos(this.x_pos - dx);
			}
			break;
		case 2:
			if(dx > 0) {
				this.setx_pos(this.x_pos - dx);
			}
			break;
		}
		switch(this.check_collisiondir_Vert( top, bottom)) {
		case 1:
			if(dy < 0) {
				
				this.sety_pos(this.y_pos - dy);
			}
			break;
		case 2:
			if(dy > 0) {
				this.sety_pos(this.y_pos - dy);
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

		if (this.x_pos == right2 - 2) {
			return 1;
		} else if (this.right == left2 + 2) {
			return 2;
		} else {
			return 0;
		}
	}
	protected int check_collisiondir_Vert(int top2,int bottom2 ) {

		if (this.y_pos == bottom2 -2) {
			return 1;
		} else if (this.bottom == top2 + 2) {
			return 2;
		} else {
			return 0;
		}
	}
}
