package Game;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

	public Dungeon() {
		
	}
	
	public List<Room> rooms = new ArrayList<Room>();
	
	public void generateDungeon() {
		Room room1 = new Room(1);
		GiantRat rat1 = new GiantRat(240, 300);
		PC player = new PC(500, 600);
		room1.addEntityList(rat1);
		room1.addEntityList(player);
	}
	
	
	
	
	
	public List<Room> getRoomList() {
		return this.rooms;
	}
}
