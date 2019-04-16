package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	Tile[][] level;
	
	public Room(int number) {
		this.roomNumber = number;
		level = new Tile[18][24];
	}
	
	public Tile[][] getLevel() {
		return level;
	}

	public void setLevel(Tile[][] level) {
		this.level = level;
	}

	public List<Sprite> getSpriteList(){
		return this.spriteList;
	}
	
	public List<Entity> getEntityList(){
		return this.entityList;
	}
	
	public void addEntityList(Entity entity) {
		this.entityList.add(entity);
	}
	
	public void addSpriteList(Sprite sprite) {
		this.spriteList.add(sprite);
	}
	
	public void addSpritesList(List<Sprite> sprites) {
		this.spriteList.addAll(sprites);
	}

	public int getRoomNumber() {
		return roomNumber;
	}
	
}
