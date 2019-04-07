package Game;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {

	public Dungeon(int difficulty) {
		this.difficulty = difficulty;
		generateDungeon();
	}
	
	int difficulty;
	public List<Room> rooms = new ArrayList<Room>();
	
	public void generateDungeon() {
		createRoomTutorial();
		createRoomWell();
		

	}
	
	private void createRoomTutorial(){
		Room tutorial = new Room(0);
		PC player = new PC(500, 600);
		tutorial.addEntityList(player);
		rooms.add(tutorial);
	}
	
	private void createRoomWell(){
		Room well = new Room(1);
		PC player = new PC(500, 600);
		well.addEntityList(player);
		Door door = new Door(700, 500);
		door.setSpawnX(300);
		door.setSpawnY(400);
		door.setRoom(2);
		well.addSpriteList(door);
		rooms.add(well);
	}
	
	private void createRoomOne(){
		Room room1 = new Room(2);
		GiantRat rat1 = new GiantRat(240, 300);
		room1.addEntityList(rat1);
		rooms.add(room1);
	}
	
	private void createLeftHallway(){
		switch(difficulty) {
		  case 0:// Easy difficulty
			  Room leftRoomOne = new Room(3);
			  
			  break;
		  case 1:// Medium difficulty
			  
			  break;
		  case 2:// Hard difficulty
			  
			  break;
		}
	}
	
	private void createRightHallway(){
		
	}
	
	public List<Room> getRoomList() {
		return this.rooms;
	}
}
