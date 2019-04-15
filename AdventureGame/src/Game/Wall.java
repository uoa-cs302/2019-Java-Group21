package Game;

public class Wall extends Sprite{

	private Direction direction;
	
	public Wall(int x, int y) {
		super(x,y);
		System.out.println("Wall constructor");
		super.setCollidable(true);
		System.out.println("Wall 1");
		LoadSprites("src/Image/wall0.png");
		System.out.println("Wall 2");
		loadImage(0,0);
		System.out.println("Wall constructor end");
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
