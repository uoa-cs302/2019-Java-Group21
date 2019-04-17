package Game;

public class Wall extends Entity{
	
	public Wall(int x, int y) {
		super(x,y);
		super.setCollidable(true);
		LoadSprites("src/Image/wall0.png");
		loadImage(0,0);
		setBounds( new Collision(this.x_pos,this.y_pos,this.width,this.height));

	}
	
	public void update() {
		
	}
}
