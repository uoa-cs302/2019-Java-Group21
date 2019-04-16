package Game;


// Class provides a sprite that when the player collides with it,
// The door then passes the information needed to load the player into the next Room
public class Door extends Entity{

	// Both are integers representing the position on screen the player will spawn
	private int spawnX;
	private int spawnY;
	
	// Provides the index to the next room that should load
	// Index of the List<Room> in the Dungeon class
	private int room;
	
	public Door (int x, int y) {
		super(x,y);
		super.setCollidable(true);
	}
	
	// Getter and setter for the room variable
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}

	// Getter and setter for the spawn values
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
