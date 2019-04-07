package Game;

public class Door extends Sprite{

	
	private int spawnX;
	private int spawnY;
	private Room load;
	
	public Door (int x, int y) {
		super(x,y);
	}

	public Room getRoom() {
		return load;
	}

	public void setRoom(Room newRoom) {
		this.load = newRoom;
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
