package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	
	public Room(int number) {
		this.roomNumber = number;
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
