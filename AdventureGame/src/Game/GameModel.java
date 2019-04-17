package Game;

import Game.Sprite.Direction;

public class GameModel {

	private Dungeon dungeon;
	private Room currentRoom;
	
	public GameModel() {

		System.out.println("GameModel constructor init");
		currentRoom = new Room(0);
		int[][] floor = {
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{1,1,1,1,0,0,0,1,7,7,1,4,0,1,5,5,0,1,0,1,1,2,3,1},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,8,9,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,6,0,1,1,4,1,0,0,1,1,0,1,7,0,6,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,2,1,0,0,1,1,0,1,7,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,6,0,1,0,0,1,1,2,1,0,0,2,3,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,8,9,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,10,11,0,0,1,1,0,1,0,0,1,1,0,6,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,10,11,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,7,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,6,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0}
			};
		currentRoom.createFloor(floor, 128, 12);
		System.out.println("GameModel constructor 1");
		Wall wall = new Wall(240, 200);
		System.out.println("GameModel constructor 2");
		Wall wall1 = new Wall (400,400);
		System.out.println("GameModel constructor 3");
		GiantRat rat1 = new GiantRat(700,400);
		currentRoom.addSpriteList(rat1);
		currentRoom.addEntityList(rat1);
		currentRoom.addSpriteList(wall);
		currentRoom.addEntityList(wall);
		System.out.println("GameModel constructor 6");
		currentRoom.addSpriteList(wall1);
		currentRoom.addEntityList(wall1);
		System.out.println("GameModel constructor complete");
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void loadRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public Dungeon getDungeon() {
		return dungeon;
	}

	public void setDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}
	
	public Room getDungeonIndex(int index) {
		return this.dungeon.getDungeonIndex(index);
	}
	
}
