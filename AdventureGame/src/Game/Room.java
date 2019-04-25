package Game;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private int roomNumber;
	private List<Entity> entityList= new ArrayList<Entity>();
	private List<Sprite> spriteList= new ArrayList<Sprite>();
	private Sprite[][] floors;
	private Wall[][] walls;
	private Sprite[][] decor;
	private int[][] floorGrid;
	private int[][] wallGrid;
	private int[][] decorGrid;

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

	public void createLevel(int x, int y, Image assets) {
		int k=0;
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 24; j++) {
				if (floorGrid[i][j] != -1) {
					this.floors[i][j]= new Sprite((32*j)+x, (32*i)+y);
					this.floors[i][j].setImage(assets.getFromList(floorGrid[i][j]));
					addSpriteList(floors[i][j]);
				}
				if (wallGrid[i][j] != -1) {
					this.walls[i][j]= new Wall((32*j)+x, (32*i)+y);
					this.walls[i][j].setUpWall(wallGrid[i][j]);
					this.walls[i][j].setImage(assets.getFromList(wallGrid[i][j]));
					addToRoom(walls[i][j]);
				}
				if (decorGrid[i][j] != -1) {
					this.decor[i][j]= new Sprite((32*j)+x, (32*i)+y);
					this.decor[i][j].setImage(assets.getFromList(decorGrid[i][j]));
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
	
	public void addEntitiesList(List<Entity> entities) {
		this.spriteList.addAll(entities);
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public int[][] getFloorGrid() {
		return floorGrid;
	}

	public void setFloorGrid(int[][] floorGrid) {
		this.floorGrid = floorGrid;
	}

	public int[][] getWallGrid() {
		return wallGrid;
	}

	public void setWallGrid(int[][] wallGrid) {
		this.wallGrid = wallGrid;
	}

	public int[][] getDecorGrid() {
		return decorGrid;
	}

	public void setDecorGrid(int[][] decorGrid) {
		this.decorGrid = decorGrid;
	}
}
