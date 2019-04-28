package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import Game.Sprite.Direction;

public class Skeleton extends Entity {

	Skeleton(int x, int y, List<BufferedImage> image){
		super(x,y);
		this.images = new ArrayList<BufferedImage>();
		setImages(image);
		this.images.addAll(image);
		this.getImageDim();
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
		Hitbounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height );
		super.setCollidable(true);
		this.direction = Direction.IDLE;
		this.ani.setFrames(this.getImages());
		this.ani.setFrame(0); ani.setDelay(-1);
		health = 4;
		damage = 1;
		this.AttackDuration = 80;
	}
	
	public void attack() {
		
	}
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
		}
	}
	
	public void CollisionProcess(Collision b) {
		dx = 0;
		dy = 0;
	}
	
	public void update() {
		float xdiff = this.target.getx_pos() - this.x_pos;
		float ydiff = this.target.gety_pos() - this.y_pos;
		float scalar = (float) Math.sqrt((xdiff * xdiff) + (ydiff * ydiff));
		float vx = (float) ((xdiff/scalar));
		float vy = (float) ((ydiff/scalar));
		super.update();
		dx = (vx*2);
		dy = (vy*2);
		
	if(dx > 0) {this.direction = Direction.RIGHT;}
	if(dx < 0) {this.direction = Direction.LEFT;}
	if(dy > 0) {this.direction = Direction.DOWN;}
	if(dy < 0) {this.direction = Direction.UP;}
		if (xdiff < 40 && ydiff < 40) {
			Attack = true;
		}
	}
	
}
