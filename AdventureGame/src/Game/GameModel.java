package Game;

import Game.Sprite.Direction;

public class GameModel {

	private Dungeon dungeon;
	private Room currentRoom;
	private Image assets;
	
	public GameModel() {
		assets = new Image();
		dungeon = new Dungeon(0, assets);
		currentRoom = dungeon.getDungeonIndex(2);
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
