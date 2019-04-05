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
	
	public void addEntityList(Entity entity) {
		this.entityList.add(entity);
	}
	
	public void addSpriteList(Sprite sprite) {
		this.spriteList.add(sprite);
	}
	
}
