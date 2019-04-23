package Game;

public class Projectile extends Entity{
	
	public Projectile(int x, int y, int dx, int dy) {
		super(x,y);
		this.dx = dx;
		this.dy = dy;
		damage = 1;
	}
}
