package Game;

import java.util.ArrayList;
import java.util.List;

// Class provides a sprite that when the player collides with it,
// The door then passes the information needed to load the player into the next Room
public class Door extends Entity{

	// Both are integers representing the position on screen the player will spawn
	private int spawnX;
	private int spawnY;
	private List<PressurePlate> plates;
	private boolean open;

	// Provides the index to the next room that should load
	// Index of the List<Room> in the Dungeon class
	private int room;

	public Door (int x, int y) {
		super(x,y);
		super.setCollidable(true);
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
		open = true;
	}

	public Door (int x, int y, PressurePlate p0) {
		super(x,y);
		super.setCollidable(true);
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
		plates = new ArrayList<PressurePlate>();
		plates.add(p0);
		open = false;
	}

	public void update() {
		if (plates != null)
			checkOpen();
	}
	
	public void addPlate(PressurePlate p) {
		plates.add(p);
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

	public boolean isOpen() {
		return this.open;
	}

	public void checkOpen() {
		for (PressurePlate plate : plates)
			if(!plate.isEnabled()) {
				this.open = false;
				return;
			}
		this.open = true;
	}

}
