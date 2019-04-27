package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Game.Sprite.Direction;

public class Skeleton extends Entity {

	Skeleton(int x, int y, BufferedImage image){
		super(x,y);
		this.images = new ArrayList<BufferedImage>();
		setImage(image);
		this.images.add(image);
		this.images.add(image);
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
		if (xdiff < 40 && ydiff < 40) {
			Attack = true;
		}
	}
	
}
