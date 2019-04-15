package Game;

public class Wall extends Sprite{

	private Direction direction;
	
	public Wall(int x, int y) {
		super(x,y);
		super.setCollidable(true);
		LoadSprites("src/Image/wall0.png");
		loadImage(0,0);
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
