package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	Sprite[][] floors;
	Wall[][] walls;
	Sprite[][] decor;

	public Room(int number) {
		this.roomNumber = number;
		floors = new Sprite[18][24];
		walls = new Wall[18][24];
		decor = new Sprite[18][24];
	}

	public Sprite[][] getFloor() {
		return floors;
	}

	public void setFloor(Sprite[][] floor) {
		this.floors = floor;
	}

	public void createLevel(int[][] floor, int[][] wall, int[][] decor, int x, int y, Image assets) {
		int k=0;
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 24; j++) {
				if (floor[i][j] != -1) {
					this.floors[i][j]= new Sprite((32*j)+x, (32*i)+y);
					this.floors[i][j].setImage(assets.getFromList(floor[i][j]));
					addSpriteList(floors[i][j]);
				}
				if (wall[i][j] != -1) {
					this.walls[i][j]= new Wall((32*j)+x, (32*i)+y);
					this.walls[i][j].setImage(assets.getFromList(wall[i][j]));
					addToRoom(walls[i][j]);
				}
				if (decor[i][j] != -1) {
					this.decor[i][j]= new Sprite((32*j)+x, (32*i)+y);
					this.decor[i][j].setImage(assets.getFromList(decor[i][j]));
					addSpriteList(this.decor[i][j]);
				}
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
