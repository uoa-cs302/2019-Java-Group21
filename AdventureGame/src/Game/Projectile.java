package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.lang.Math;

import Game.Sprite.Direction;

public class Projectile extends Entity{
	
	private float distance_x;
	private float distance_y;
	private Entity parent;
	
	public Projectile(int x, int y, int distance_x, int distance_y, BufferedImage image, Entity parent) {
		super(x,y);
		this.parent = parent;
		this.distance_x = distance_x;
		this.distance_y = distance_y;
		calculateMovement(4);
		this.images = new ArrayList<BufferedImage>();
		this.images.add(image);
		this.images.add(image);
		setImage(image);
		this.getImageDim();
		damage = 1;
		Bounds = new Collision(this.x_pos,this.y_pos,this.width,this.height/2);
		Hitbounds = new Collision(this.x_pos,this.y_pos +(this.height/2),this.width,this.height );
		this.direction = Direction.IDLE;
		this.ani.setFrames(this.getImages());
		this.ani.setFrame(0);
		this.ani.setDelay(-1);
	}
	
	private void calculateMovement(float speed) {
		float scalar = (float) Math.sqrt((distance_x * distance_x) + (distance_y * distance_y));
		this.dx = (int) (speed * (distance_x/scalar));
		this.dy = (int) (speed * (distance_y/scalar));
	}
	
	public Entity getParent() {
		return this.parent;
	}
	
}
