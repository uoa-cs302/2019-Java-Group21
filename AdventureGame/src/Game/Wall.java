package Game;

public class Wall extends Sprite{

	private Direction direction;
	
	public Wall(int x, int y) {
		super(x,y);
		super.setCollidable(true);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
}
