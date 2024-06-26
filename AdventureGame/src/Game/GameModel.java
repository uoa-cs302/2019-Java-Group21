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
		dungeon = new Dungeon(assets);
	}
	
	public void generateDungeon(int difficulty) {
		dungeon.generateDungeon(difficulty);
		currentRoom = dungeon.getDungeonIndex(1);
	}
	
	public Image getAssets(){
		return assets;
	}

	public List<BufferedImage> getPlayerAssets(){
		return assets.getPlayer();
	}
	
	public List<BufferedImage> getHealthAssets(){
		return assets.getHealth();
	}
	
	public List<BufferedImage> getInventoryAssets(){
		return assets.getInventory();
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
