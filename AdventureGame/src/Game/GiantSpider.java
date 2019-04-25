package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GiantSpider extends Entity {

	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private BufferedImage projectileImage;
	private float projectileSpeed = 4;
	private int[][] walls;

	GiantSpider(int x, int y, List<BufferedImage> images){
		super(x,y);
		this.images = new ArrayList<BufferedImage>();
		this.images.add(images.get(0));
		this.images.add(images.get(0));
		setImage(images.get(0));
		this.getImageDim();
		projectileImage=images.get(1);
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height/2);
		Hitbounds = new Collision((int)this.x_pos,(int)this.y_pos +(this.height/2),this.width,this.height );
		this.direction = Direction.IDLE;
		this.ani.setFrames(this.getImages());
		this.ani.setFrame(0);
		this.ani.setDelay(-1);
		health = 4;
		this.AttackDuration = 80;
	}

	public void setWalls(int [][] walls) {
		this.walls = walls;
	}

	@Override
	public void attack() {
		Projectile projectile = new Projectile(this.x_pos, this.y_pos, this.target.getx_pos() - this.x_pos, this.target.gety_pos() - this.y_pos, projectileImage, this, projectileSpeed);
		projectiles.add(projectile);
	}

	public void update() {
		float xdiff = this.target.getx_pos() - this.x_pos;
		float ydiff = this.target.gety_pos() - this.y_pos;
		float scalar = (float) Math.sqrt((xdiff * xdiff) + (ydiff * ydiff));
		float vx = (float) ((xdiff/scalar));
		float vy = (float) ((ydiff/scalar));
		
		if (lineOfSight(this.getGridXPosition(), this.getGridYPosition(), xdiff, ydiff, vx, vy))
			Attack = true; 
		super.update();

		float highestScalar = 0;
		int optimumx_pos = 0;
		int optimumy_pos = 0;

	/*	for (int i = 0; i < 18; i++)
			for (int j = 0; j < 24; j++) {
				xdiff = target.getGridXPosition()-j;
				ydiff = target.getGridYPosition()-i;
				//System.out.println("diff x = " + xdiff);
				//System.out.println("diff y = " + ydiff);
				scalar = (float) Math.sqrt((xdiff * xdiff) + (ydiff * ydiff));
				vx = (float) ((xdiff/scalar));
				vy = (float) ((ydiff/scalar));
				if (lineOfSight(j ,i ,xdiff ,ydiff ,vx ,vy) && walls[i][j] == -1) {
					//System.out.println("x = " + j);
					//System.out.println("y = " + i);
					if(scalar > highestScalar ) {
						optimumx_pos = j;
						optimumy_pos = i;
					}
				}
			}
		System.out.println("optimum x = " + optimumx_pos);
		System.out.println("optimum y = " + optimumy_pos);*/
	}

	public List<Projectile> getProjectiles(){
		return this.projectiles;
	}

	public boolean lineOfSight(int gridx_pos, int gridy_pos, float xdiff, float ydiff, float vx, float vy) {
		float x, x_end, y, y_end;
		if (xdiff >= 0) {
			y = gridx_pos;
			y_end = this.target.getGridXPosition();
		}
		else {
			y = this.target.getGridXPosition();
			y_end = this.getGridXPosition();
		}
		if (ydiff >= 0) {
			x = gridy_pos;
			x_end = this.target.getGridYPosition();
		}
		else {
			x = this.target.getGridYPosition();
			x_end = gridy_pos;
		}
		while ((x < x_end) && (y < y_end)) {
			x += Math.abs(vy);
			y += Math.abs(vx);
			if (walls[(int)y][(int)x] != -1) {
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
		return true;
	}

	public void clearProjectiles() {
		projectiles.clear();
	}
}
