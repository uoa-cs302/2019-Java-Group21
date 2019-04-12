package Game;

import Game.Sprite.Direction;

public class GameModel {

	private Dungeon dungeon;
	private Room currentRoom;
	
	public GameModel() {
		currentRoom = new Room(0);
		Wall wall = new Wall(240, 200);
		Wall wall1 = new Wall (400,600);
		wall.setDirection(Direction.UP);
		wall1.setDirection(Direction.UP);
		currentRoom.addSpriteList(wall);
		currentRoom.addSpriteList(wall1);
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
