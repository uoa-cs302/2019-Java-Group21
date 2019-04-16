package Game;

public class Wall extends Entity{
	
	public Wall(int x, int y) {
		super(x,y);
		super.setCollidable(true);
		LoadSprites("src/Image/wall0.png");
		loadImage(0,0);
	}
}
