package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.lang.Math;

import Game.Sprite.Direction;

public class Projectile extends Entity{
	
	private float distance_x;
	private float distance_y;
	private Entity parent;
	
	public Projectile(float x, float y, float distance_x, float distance_y, BufferedImage image, Entity parent, float speed) {
		super(x,y);
		this.parent = parent;
		this.distance_x = distance_x;
		this.distance_y = distance_y;
		calculateMovement(speed);
		this.images = new ArrayList<BufferedImage>();
		this.images.add(image);
		this.images.add(image);
		setImage(image);
		this.getImageDim();
		damage = 1;
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width/2,this.height/2);
		Hitbounds = new Collision((int)this.x_pos,(int)this.y_pos +(this.height/2),this.width,this.height );
		Bounds.setxOff(8);
		Bounds.setyOff(8);
		this.direction = Direction.IDLE;
		this.ani.setFrames(this.getImages());
		this.ani.setFrame(0);
		this.ani.setDelay(-1);
		this.AttackDuration = 0;
	}
	
	private void calculateMovement(float speed) {
		float scalar = (float) Math.sqrt((distance_x * distance_x) + (distance_y * distance_y));
		this.dx = (speed * (distance_x/scalar));
		this.dy = (speed * (distance_y/scalar));
	}
	
	public Entity getParent() {
		return this.parent;
	}
	
}
