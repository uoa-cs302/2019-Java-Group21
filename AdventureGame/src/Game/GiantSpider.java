package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GiantSpider extends Entity {
	
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private BufferedImage projectileImage;
	
	GiantSpider(int x, int y){
		super(x,y);
	}
	
	@Override
	public void attack() {
		Projectile projectile = new Projectile(this.x_pos, this.y_pos, this.target.getx_pos() - this.x_pos, this.target.gety_pos() - this.y_pos);
		projectile.setImage(projectileImage);
		projectiles.add(projectile);
	}
	
	public List<Projectile> getProjectiles(){
		return this.projectiles;
	}
	
	public void clearProjectiles() {
		projectiles.clear();
	}
}
