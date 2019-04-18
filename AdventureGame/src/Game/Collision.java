package Game;



//This class will use AABB collision 

public class Collision {

	private int x_pos = 0;
	private int y_pos = 0;
	private float width= 0;
	private float height = 0;
	private int size;
	private float radius;
	private float xOff = 0;
	private float yOff = 0;
	private Entity e;
	
	public Collision(int x,int y, int width, int height) {
		this.x_pos =  x;
		this.y_pos = (int) y;
		this.width = (float) width;
		this.height = (float) height;
		
		size = Math.max(width, height);
	}
	public Collision(int x, int y, int r, Entity e) {
		this.x_pos = x;
		this.y_pos = y;
		this.radius = r;
		this.e = e;
		
		size = r;
	}
	
	public int getX() {return x_pos;}
	public int getY() {return y_pos;}
	public float getwidth() {return width;}
	public float getheight() {return height;}
	public float getR() {return radius;}
	public float getxOff() {return xOff;}
	public float getyOff() {return yOff;}
	
	public void setBox(int x,int y,int w, int h) {
		this.x_pos =x;
		this.y_pos =y;
		this.width = w;
		this.height = h;
		
		size = Math.max(w,h);
	}
	
	public void setCircle(int x,int y, int r) {
		this.x_pos = x;
		this.y_pos =y;
		this.radius = r;
		
		size =r;
	}
	
	public void setxOff(float f) {this.xOff = f;}
	public void setyOff(float f) {this.yOff = f;}
	
	public boolean collisionWith(Collision b) {
		
		float ax_pos =	 this.x_pos + this.xOff + (this.width/2);
		float ay_pos =  this.y_pos + this.yOff + (this.height/2);
		float bx_pos =  b.getX() + b.getxOff() + (b.getwidth()/2);
		float by_pos =  b.getY() + b.getyOff() + (b.getheight()/2);
		if(Math.abs(ax_pos-bx_pos)< (this.width/2) + (b.getwidth()/2)) {
			if(Math.abs(ay_pos-by_pos)< (this.height/2) + (b.getheight()/2)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean collisionCirBox(Collision b) {
		
		float cirx = (float) (this.x_pos + radius/Math.sqrt(2) - e.getsize()/Math.sqrt(2));
		float ciry = (float) (this.y_pos + radius/Math.sqrt(2) - e.getsize()/Math.sqrt(2));
		
		float dx = cirx - Math.max(this.x_pos+(this.width/2),Math.min(cirx, this.x_pos));
		float dy = ciry - Math.max(this.y_pos+(this.height/2),Math.min(ciry, this.y_pos));
		
		if((dx*dx+dy*dy)< ((this.radius/Math.sqrt(2) * (this.radius/Math.sqrt(2))))) {
			return true;
		}
		return false;
	}
	
}
