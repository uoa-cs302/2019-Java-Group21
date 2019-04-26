package Game;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.lang.Math; 

public class GiantSpider extends Entity {

	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private BufferedImage projectileImage;
	private float projectileSpeed = 4;
	private int[][] walls;
	private int movementCounter;
	private List<Point> movements;

	GiantSpider(int x, int y, List<BufferedImage> images){
		super(x,y);
		this.images = new ArrayList<BufferedImage>();
		setImage(images.get(0));
		this.getImageDim();
		projectileImage=images.get(12);
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
		//Hitbounds = new Collision((int)this.x_pos,(int)this.y_pos +this.height,this.width,this.height );
		this.direction = Direction.IDLE;
		this.ani.setFrames(images.subList(0, 6));
		this.ani.setFrame(0);
		this.ani.setDelay(-1);
		health = 4;
		this.AttackDuration = 80;
		movements = new ArrayList<Point>();
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

		if (lineOfSight(this.getGridXPosition(), this.getGridYPosition(), xdiff, ydiff, vx, vy) && Attack == false)
			Attack = true; 
		super.update();

		if (movements.size() == 0) {
			float highestScalar = 0;
			int optimumx_pos = 0;
			int optimumy_pos = 0;

			for (int i = 0; i < 18; i++)
				for (int j = 0; j < 24; j++) {
					xdiff = target.getx_pos()-(128+(j*32));
					ydiff = target.gety_pos()-(12+(i*32));
					scalar = (float) Math.sqrt((xdiff * xdiff) + (ydiff * ydiff));
					vx = (float) ((xdiff/scalar));
					vy = (float) ((ydiff/scalar));
					if (lineOfSight(j ,i ,xdiff ,ydiff ,vx ,vy) && walls[i][j] == -1) {
						if(scalar > highestScalar ) {
							highestScalar = scalar;
							optimumx_pos = j;
							optimumy_pos = i;
						}
					}
				}
			this.movements = calculatePath(optimumx_pos, optimumy_pos);
		}
		else {
			this.dx = (float) movements.get(0).getX();
			this.dy = (float) movements.get(0).getY();
			movements.remove(0);
		}
		image();
	}
	
	public void animate() {
		switch (this.direction) {
		
		
		case LEFT:
			if (dx != 0 && ani.getDelay()== -1) {
			this.ani.setFrames(images.subList(0, 6));
			} else if (dx == 0) { ani.setDelay(-1);}
			break;
		case RIGHT:
			if (dx != 0 && ani.getDelay()== -1) {
			this.ani.setFrames(images.subList(6, 12));
			}else if (dx == 0) { ani.setDelay(-1);}
			break;
		default:
		}
	}

	public List<Projectile> getProjectiles(){
		return this.projectiles;
	}

	public boolean lineOfSight(int gridx_pos, int gridy_pos, float xdiff, float ydiff, float vx, float vy) {
		float x, x_end, y, y_end;
		x = gridx_pos;
		x_end = this.target.getGridXPosition();
		y = gridy_pos;
		y_end = this.target.getGridYPosition();
		boolean latch = true;
		while (((int)x != x_end) || ((int)y != y_end))  {
			if (walls[(int)y][(int)x] != -1 ) {
				return false;
			}
			if (latch) {
				x += vx;
				latch = false;
			}
			else {
				y += vy;
				latch = true;
			}
		}
		return true;
	}

	public List<Point> calculatePath(int xfinal, int yfinal) {
		boolean[][] visited = new boolean[18][24]; 
		for (int i = 0; i < 18; i++) { 
			for (int j = 0; j < 24; j++) 
			{ 
				if (walls[i][j] != -1) 
					visited[i][j] = true; 
				else
					visited[i][j] = false; 
			} 
		}
		visited[this.target.getGridYPosition()][this.target.getGridXPosition()] = true;
		Queue<gridPoint> path = new LinkedList<>();
		gridPoint start = new gridPoint(this.getGridXPosition(), this.getGridYPosition()); 
		path.add(start);
		visited[start.getY()][start.getX()] = true; 
		while (!path.isEmpty()) { 
			gridPoint point = path.remove();

			// Path found; 
			if (point.getX() == xfinal && point.getY() == yfinal) 
				return point.getPath(); 

			// Up 
			if (point.getY() - 1 >= 0 && visited[point.getY() - 1][point.getX()] == false) {
				point.addPath(0, 2);
				path.add(new gridPoint(point.getX(), point.getY() - 1, point.getPath()));
				visited[point.getY() - 1][point.getX()] = true; 
			} 

			// Down 
			if (point.getY() + 1 < 18 && visited[point.getY() + 1][point.getX()] == false) { 
				point.addPath(0, -2);
				path.add(new gridPoint(point.getX(), point.getY() + 1, point.getPath()));
				visited[point.getY() + 1][point.getX()] = true; 
			} 

			// Left 
			if (point.getX() - 1 >= 0 && visited[point.getY()][point.getX() - 1] == false) {
				point.addPath(-2, 0);
				path.add(new gridPoint(point.getX() - 1, point.getY(), point.getPath()));
				visited[(int) (point.getY())][(int) (point.getX()) - 1] = true; 
			} 

			// Right 
			if (point.getX() + 1 < 24 && visited[point.getY()][point.getX() + 1] == false) {
				point.addPath(2, 0);
				path.add(new gridPoint(point.getX() + 1, point.getY(), point.getPath()));
				visited[point.getY()][point.getX() + 1] = true; 
			}
		}
		List<Point> blank = new ArrayList<Point>();
		blank.add(new Point(0,0));
		return (blank);
	}

	public class gridPoint {
		private int x;
		private int y;
		private List<Point> path;

		public gridPoint(int x, int y) {
			this.x = x;
			this.y = y;
			path = new ArrayList<Point>();
		}

		public gridPoint(int x, int y, List<Point> path) {
			this.x = x;
			this.y = y;
			this.path = new ArrayList<Point>(path);
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public void addPath(int x, int y) {
			path.add(new Point(x,y));
		}

		public List<Point> getPath(){
			return this.path;
		}

		public void setPath(List<Point> path) {
			this.path = path;
		}
	}

	public void clearProjectiles() {
		projectiles.clear();
	}
}
