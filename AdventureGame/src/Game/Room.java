package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	
	public void addEntityList(Entity entity) {
		this.entityList.add(entity);
	}
	
	public void addSpriteList(Sprite sprite) {
		this.spriteList.add(sprite);
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
	
}
