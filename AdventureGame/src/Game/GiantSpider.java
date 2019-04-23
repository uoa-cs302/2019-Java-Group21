package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GiantSpider extends Entity {
	
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private BufferedImage projectileImage;
	
	GiantSpider(int x, int y, List<BufferedImage> images){
		super(x,y);
		this.images = new ArrayList<BufferedImage>();
		this.images.add(images.get(0));
		this.images.add(images.get(0));
		setImage(images.get(0));
		this.getImageDim();
		projectileImage=images.get(1);
		Bounds = new Collision(this.x_pos,this.y_pos,this.width,this.height/2);
		Hitbounds = new Collision(this.x_pos,this.y_pos +(this.height/2),this.width,this.height );
		this.direction = Direction.IDLE;
		this.ani.setFrames(this.getImages());
		this.ani.setFrame(0);
		this.ani.setDelay(-1);
		this.AttackDuration = 90;
		this.Attack = true;
		health = 4;
	}
	
	@Override
	public void attack() {
		Projectile projectile = new Projectile(this.x_pos, this.y_pos, this.target.getx_pos() - this.x_pos, this.target.gety_pos() - this.y_pos, projectileImage, this);
		projectiles.add(projectile);
	}
	
	public void update() {
		int xdiff = this.target.getx_pos() - this.x_pos;
		int ydiff = this.target.gety_pos() - this.y_pos;
		if((int) Math.hypot((double) xdiff/32,(double) ydiff/32) < 6) {
			Attack = true;
			System.out.println("attack true");
		}
		System.out.println("updating spider");
		super.update();
	}
	
	public List<Projectile> getProjectiles(){
		return this.projectiles;
	}
	
	public void clearProjectiles() {
		projectiles.clear();
	}
}
