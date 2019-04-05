package Game;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

	public List<Room> rooms = new ArrayList<Room>();
	
	public void generateDungeon() {
		Room room1 = new Room();
		room1.addEntityList();
	}
	
	public List<Entity> getEntityList() {
		return rooms;
	}
}
