package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	Floor[][] level;
	
	public Room(int number) {
		this.roomNumber = number;
		level = new Floor[18][24];
	}

	public Floor[][] getLevel() {
		return level;
	}

	public void setLevel(Floor[][] level) {
		this.level = level;
	}

	public void createLevel(int[][] floor) {
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 24; j++) {
				level[i][j].setTexture(floor[i][j]);
			}
		}
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
