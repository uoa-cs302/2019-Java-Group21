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
	protected float dx;
	protected float dy;
	private boolean collidable = false;
	protected int size;
	private int attackCount = 0;

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
	protected boolean up = false;
	protected boolean down = false;
	protected boolean left = false;
	protected boolean right = false;
	protected double speed = 1;

	protected boolean Attack;
	protected boolean attacking;
	protected int AttackSpeed;
	protected int AttackDuration = 30;
	
	protected boolean slowed = false;
	protected int slowedCounter;
	
	protected int health;

	protected Entity target;
	
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
	public Entity(float x,float y){
		super(x,y);
		setCollidable(true);
		ani = new Animation();
		direction = Direction.DOWN;
		size = 32;
		width = 32;
		height = 32;
	}

	public boolean getattacking() {return this.attacking;}
	public int getEntityID() {return this.EntityID;}
	public float getdy() {return dy;}
	public float getdx() {return dx;}
	public boolean getUP() {return up;}
	public boolean getDown() {return down;}
	public boolean getLeft() {return left;}
	public boolean getRight() {return right;}
	public int getsize() {return size;}
	public void setsize(int s) {this.size = s;}
	public void setdy(float dy) {this.dy = dy;}
	public void setdx(float dx) {this.dx = dx;}	
	public int getHealth() {return health;}
	public int getDamage() {return damage;}
	public Direction getDirection() {return direction;}
	public Animation getAnimation() {return ani;}
	public boolean isCollidable() {return collidable;}
	public void setCollidable(boolean collidable) {this.collidable = collidable;}
	public Collision getBounds() {return Bounds;}
	public Collision getHitBounds() {return Hitbounds;}
	public boolean canAttack() {if (Attack && attackCount == 0) {return true;}else{return false;}}

	//may be obselete
	public Rectangle getBoundary() {return new Rectangle((int)x_pos, (int)y_pos, width, height);}

	public void setAnimation(Direction i,List<BufferedImage> frames, int delay) {
		curAnim = i;
		this.getImageDim();
		ani.setFrames(frames);
		ani.setDelay(delay);
		ani.setFrame(1);
	}

	public void setBounds(Collision c) {this.Bounds = c;}

	public void setHitBounds(Collision c) {this.Bounds = c;}

	public void animate() {
		switch (this.direction) {
		case UP:
			if(attacking) {
				
			}
			if (curAnim != Direction.UP || ani.getDelay() == -1) {
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
		if (slowed) {
			if (slowedCounter == 0)
				speed = 0.25;
			if (slowedCounter < 100)
				slowedCounter++;
			else {
				slowed = false;
				slowedCounter = 0;
				speed = 1;
			}
		}
		if(Attack || attackCount != 0) {
			this.attacking = true;
			runAttack();
		}
		
		x_pos += (int) dx*speed;
		Right = (int)x_pos + width;
		y_pos += (int) dy*speed;
		Bottom = (int)y_pos + height;
		Bounds.setBox((int)this.x_pos, (int)this.y_pos, (int)Bounds.getwidth(), (int)Bounds.getheight());
		Hitbounds.setBox((int)this.x_pos, (int)this.y_pos, (int)Hitbounds.getwidth(), (int)Hitbounds.getheight());
	}

	public void setAttack(boolean b) {Attack = b;}

	public void runAttack() {
		
		if(attackCount == 0) {
			Attack = false;
			attack();
			attackCount ++;
		}
		else if (attackCount < AttackDuration) {
			attackCount ++;}
		else if (attackCount == AttackDuration) {
			attackCount = 0;
		attacking = false;
		}
	}

	public void attack() {

	}

	public void update(Entity target) {
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

	public void CollisionProcess(Collision b) {

		int left = (int) (b.getX()+b.getxOff());
		int right = (int) (left + b.getwidth());
		int top = (int) (b.getY() + b.getyOff());
		int bottom = (int) (top + b.getheight());
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
	 Attack = false;
	 System.out.println("OOOF");
	 if(health <= 0) {
		 System.out.println("blergh");
		 this.visible = false;
		 this.setCollidable(false);
	 }
	 if (e.getDown()) {
		 this.dy = 32;
	 }else
	 if (e.getLeft()) {
		 this.dx = -32;
	 }else
	 if (e.getRight()) {
		 this.dx = 32;
	 }else
	 if(e.getUP()) {
		this.dy = -32;
	 }
	 else {
			 this.dy -= 3*dy;
			 this.dx -= 3*dx;
	 }
 }
	protected int check_collisiondir_Hoz(int left2,int right2 ) {

		if (Bounds.getX()+Bounds.getxOff() == right2) {
			this.x_pos =(int) (right2 - Bounds.getxOff());
			return 1;
		} else if (Bounds.getX()+Bounds.getxOff()+Bounds.getwidth() == left2) {
			this.x_pos =(int) (left2 - Bounds.getxOff()-Bounds.getwidth());
			return 2;
		} else {
			return 0;
		}
	}
	protected int check_collisiondir_Vert(int top2,int bottom2 ) {

		if (Bounds.getY()+Bounds.getyOff() == bottom2) {
			this.y_pos = (int) (bottom2 - Bounds.getyOff());
			return 1;
		} else if (Bounds.getY()+Bounds.getyOff()+Bounds.getheight()== top2) {
			this.y_pos =(int) (top2 - Bounds.getyOff() - Bounds.getheight());
			return 2;
		} else {
			return 0;
		}
	}
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	public Entity getTarget() {
		return this.target;
	}
	
	public void setSlowed() {
		this.slowed = true;
	}
	
	public void resetSlowedCounter() {
		this.slowedCounter = 0;
	}
}
