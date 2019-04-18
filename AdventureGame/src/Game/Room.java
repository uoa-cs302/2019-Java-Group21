package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	Floor[][] floors;
	Wall[][] walls;

	public Room(int number) {
		this.roomNumber = number;
		floors = new Floor[18][24];
		walls = new Wall[18][24];
	}

	public Floor[][] getFloor() {
		return floors;
	}

	public void setFloor(Floor[][] floor) {
		this.floors = floor;
	}

	public void createLevel(int[][] floor, int[][] wall, int x, int y) {
		int k=0;
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 24; j++) {
				if (floor[i][j] != -1) {
					floors[i][j]= new Floor((32*j)+x, (32*i)+y);
					floors[i][j].setTexture(floor[i][j]);
					spriteList.add(floors[i][j]);
				}
				if (wall[i][j] != -1) {
					walls[i][j]= new Wall((32*j)+x, (32*i)+y);
					walls[i][j].setTexture(wall[i][j]);
					spriteList.add(walls[i][j]);
					entityList.add(walls[i][j]);
				}
				k++;
			}
		}
	}

	public List<Sprite> getSpriteList(){
		return this.spriteList;
	}

	public List<Entity> getEntityList(){
		return this.entityList;
	}
	
	public void addToRoom(Entity entity) {
		this.addSpriteList(entity);
		this.addEntityList(entity);
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
