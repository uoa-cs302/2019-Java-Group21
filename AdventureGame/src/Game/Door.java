package Game;

public class Door extends Sprite{

	
	private int spawnX;
	private int spawnY;
	private int room;
	
	public Door (int x, int y) {
		super(x,y);
	}
	
	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}
	
	public int getSpawnY() {
		return spawnY;
	}

	public void setSpawnY(int spawnY) {
		this.spawnY = spawnY;
	}

	public int getSpawnX() {
		return spawnX;
	}

	public void setSpawnX(int spawnX) {
		this.spawnX = spawnX;
	}
	
}
