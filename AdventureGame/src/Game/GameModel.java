package Game;

import java.awt.image.BufferedImage;
import java.util.List;

import Game.Sprite.Direction;

public class GameModel {

	private Dungeon dungeon;
	private Room currentRoom;
	private Image assets;
	
	public GameModel() {
		assets = new Image();
		dungeon = new Dungeon(2, assets);
		currentRoom = dungeon.getDungeonIndex(1);
		currentRoom.addToRoom(new GiantRat(280,400,assets.getRat()));
		System.out.println("GameModel constructor complete");
	}

	public List<BufferedImage> getPlayerAssets(){
		return assets.getPlayer();
	}
	
	public List<BufferedImage> getHealthAssets(){
		return assets.getHealth();
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
