package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dungeon {

	private int difficulty;
	private List<Room> rooms = new ArrayList<Room>(7 + (2*difficulty));
	private Image assets;


	// Room Well
	private static final int RoomWellTopDoorX = 496;
	private static final int RoomWellTopDoorY = 36;

	private static final int RoomWellTopDoorSpawnX = 496;
	private static final int RoomWellTopDoorSpawnY = 70;

	// Room Two
	private static final int RoomTwoBottomDoorX = 496;
	private static final int RoomTwoBottomDoorY = 550;

	private static final int RoomTwoBottomDoorSpawnX = 496;
	private static final int RoomTwoBottomDoorSpawnY = 516;

	private static final int RoomTwoLeftDoorX = 208;
	private static final int RoomTwoLeftDoorY = 42;

	private static final int RoomTwoLeftDoorSpawnX = 208;
	private static final int RoomTwoLeftDoorSpawnY = 76;

	private static final int RoomTwoRightDoorX = 720;
	private static final int RoomTwoRightDoorY = 138;

	private static final int RoomTwoRightDoorSpawnX = 720;
	private static final int RoomTwoRightDoorSpawnY = 172;

	// Left Room One
	private static final int LeftRoomOneBottomDoorX = 496;
	private static final int LeftRoomOneBottomDoorY = 550;

	private static final int LeftRoomOneBottomDoorSpawnX = 496;
	private static final int LeftRoomOneBottomDoorSpawnY = 516;

	private static final int LeftRoomOneTopDoorX = 496;
	private static final int LeftRoomOneTopDoorY = 34;

	private static final int LeftRoomOneTopDoorSpawnX = 496;
	private static final int LeftRoomOneTopDoorSpawnY = 66;

	// Left Room Two
	private static final int LeftRoomTwoBottomDoorX = 240;
	private static final int LeftRoomTwoBottomDoorY = 550;

	private static final int LeftRoomTwoBottomDoorSpawnX = 240;
	private static final int LeftRoomTwoBottomDoorSpawnY = 516;

	private static final int LeftRoomTwoTopDoorX = 656;
	private static final int LeftRoomTwoTopDoorY = 66;

	private static final int LeftRoomTwoTopDoorSpawnX = 656;
	private static final int LeftRoomTwoTopDoorSpawnY = 100;

	// Left Room Three
	private static final int LeftRoomThreeBottomDoorX = 720;
	private static final int LeftRoomThreeBottomDoorY = 550;

	private static final int LeftRoomThreeBottomDoorSpawnX = 720;
	private static final int LeftRoomThreeBottomDoorSpawnY = 516;

	private static final int LeftRoomThreeTopDoorX = 240;
	private static final int LeftRoomThreeTopDoorY = 36;

	private static final int LeftRoomThreeTopDoorSpawnX = 240;
	private static final int LeftRoomThreeTopDoorSpawnY = 70;

	// Skeleton Room
	private static final int RoomSkeletonDoorX = 496;
	private static final int RoomSkeletonDoorY = 486;

	private static final int RoomSkeletonDoorSpawnX = 496;
	private static final int RoomSkeletonDoorSpawnY = 452;

	
	// Difficulty determines the number of rooms in the dungeon
	public Dungeon(int difficulty, Image assets) {
		this.difficulty = difficulty;
		this.assets = assets;
		generateDungeon();
	}

	// Allows the accessing of a specific Room in the Dungeon
	public Room getDungeonIndex(int index) {
		return this.rooms.get(index);
	}

	public void generateDungeon() {
		for (int i = 0; i < 7 + (2*difficulty); i++) {
			rooms.add(null);
		}
		createRoomTutorial();
		createRoomWell();
		createRoomOne();
		createRoomSkeleton();
		createLeftHallway();
		//createRightHallway();
		//createRoomPuzzle();
		//createRoomBoss();
	}

	private void createRoomTutorial(){
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,19,20,20,20,20,20,20,21,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1, 3, 4,34,-1,-1,-1,-1,-1,-1,32, 4, 5,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,19,20,50,-1,-1,-1,-1,-1,-1,48,20,21,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1,-1,-1},
				{-1,-1,-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1,-1,-1},
				{-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1},
				{-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1},
				{-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1},
				{-1,-1,-1,-1,35,36,36,36,36,36,97,-1,-1,98,36,36,36,36,36,37,-1,-1,-1,-1},
				{-1,-1,-1,-1,51,52,52,52,52,52,113,-1,-1,114,52,52,52,52,52,53,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,35,-1,-1,37,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,52,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,36,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		Room tutorial = new Room(0);
		Door door = new Door(240, 36);
		door.setSpawnX(496);
		door.setSpawnY(516);
		door.setRoom(2);
		tutorial.addToRoom(door);
		Door door1 = new Door(496,486);
		door1.setSpawnX(496);
		door1.setSpawnY(66);
		door1.setRoom(1);
		tutorial.addToRoom(door1);
		tutorial.createLevel(floor, wall, decor, 128, 12, assets);
		rooms.set(0, tutorial);
	}

	private void createRoomWell(){
		Room well = new Room(1);
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,72,72,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,64, 4, 4,67,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{ 3, 4, 4, 4, 4, 4, 4, 4, 4, 4,65,-1,-1,66, 4, 4, 4, 4, 4, 4, 4, 4, 4,5},
				{19,20,20,20,20,20,20,20,20,20,81,-1,-1,82,20,20,20,20,20,20,20,20,20,21},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{35,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,37},
				{51,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,53}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		well.createLevel(floor, wall, decor, 128, 12, assets);
		Door door = new Door(RoomWellTopDoorX, RoomWellTopDoorY);
		door.setSpawnX(RoomTwoBottomDoorSpawnX);
		door.setSpawnY(RoomTwoBottomDoorSpawnY);
		door.setRoom(2);
		well.addToRoom(door);
		rooms.set(1, well);
	}

	private void createRoomOne(){
		Room room1 = new Room(2);
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,72,72,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,88,88,88,88},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,72,72,88,88,88,88},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{64, 4, 4, 4, 4,67,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{19,20,-1,-1,20,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5},
				{35,97,-1,-1,98,37,-1,-1,-1,-1,-1,-1,-1,-1,19,20,20,20,23,24,20,20,20,21},
				{51,113,-1,-1,114,53,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,32, 4, 4, 4, 4, 4, 4, 4, 4, 4,34,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,48,20,20,20,20,20,20,20,20,20,50,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,35,36,36,36,36,36,36,36,36,97,-1,-1,98,36,36,36,36,36,36,36,36,36,37},
				{-1,51,52,52,52,52,52,52,52,52,113,-1,-1,114,52,52,52,52,52,52,52,52,52,53},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,35,-1,-1,37,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,52,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,288,289,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,36,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room1.createLevel(floor, wall, decor, 128, 12, assets);
		//GiantRat rat1 = new GiantRat(240, 300);
		//room1.addToRoom(rat1);
		Door door = new Door(RoomTwoBottomDoorX, RoomTwoBottomDoorY);
		door.setSpawnX(RoomWellTopDoorSpawnX);
		door.setSpawnY(RoomWellTopDoorSpawnY);
		door.setRoom(1);
		room1.addToRoom(door);
		rooms.set(2, room1);
	}

	private void createLeftHallway(){
		Room leftRoomOne = new Room(3);
		Room leftRoomTwo = new Room(4);
		Room leftRoomThree = new Room(5);
		Random rand = new Random();
		int n = rand.nextInt(3);
		System.out.println("random int = " + n);
		System.out.println("difficulty = " + difficulty);
		switch(difficulty) {
		case 0:// Easy difficulty
			if (n == 0) {
				setDoorRoomTwo(1, LeftRoomOneBottomDoorSpawnX, LeftRoomOneBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomOneTopDoorSpawnX, LeftRoomOneTopDoorSpawnY);
				createRoomLeftOne(leftRoomOne);
				Door door = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door1.setSpawnX(RoomSkeletonDoorSpawnX);
				door1.setSpawnY(RoomSkeletonDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
			}
			else if (n == 1) {
				setDoorRoomTwo(1, LeftRoomTwoBottomDoorSpawnX, LeftRoomTwoBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomTwoTopDoorSpawnX, LeftRoomTwoTopDoorSpawnY);
				createRoomLeftTwo(leftRoomOne);
				Door door = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door1.setSpawnX(RoomSkeletonDoorSpawnX);
				door1.setSpawnY(RoomSkeletonDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
			}
			else {
				setDoorRoomTwo(1, LeftRoomThreeBottomDoorSpawnX, LeftRoomThreeBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomThreeTopDoorSpawnX, LeftRoomThreeTopDoorSpawnY);
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door.setSpawnX(RoomTwoBottomDoorSpawnX);
				door.setSpawnY(RoomTwoBottomDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door1.setSpawnX(RoomSkeletonDoorSpawnX);
				door1.setSpawnY(RoomSkeletonDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
			}
			rooms.set(3, leftRoomOne);
			break;
		case 1:// Medium difficulty
			int m = rand.nextInt(2);
			if (n == 0) {
				setDoorRoomTwo(1, LeftRoomOneBottomDoorSpawnX, LeftRoomOneBottomDoorSpawnY);
				createRoomLeftOne(leftRoomOne);
				Door door = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				if (m == 0) {
					setDoorRoomSkeleton(LeftRoomTwoTopDoorSpawnX, LeftRoomTwoTopDoorSpawnY);
					door1.setSpawnX(LeftRoomTwoBottomDoorSpawnX);
					door1.setSpawnY(LeftRoomTwoBottomDoorSpawnY);
					createRoomLeftTwo(leftRoomTwo);
					Door door2 = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
					door2.setSpawnX(LeftRoomOneTopDoorSpawnX);
					door2.setSpawnY(LeftRoomOneTopDoorSpawnY);
					door2.setRoom(3);
					leftRoomTwo.addToRoom(door2);
					Door door3 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
					door3.setSpawnX(RoomSkeletonDoorSpawnX);
					door3.setSpawnY(RoomSkeletonDoorSpawnY);
					door3.setRoom(5);
					leftRoomTwo.addToRoom(door3);
				}
				else {
					setDoorRoomSkeleton(LeftRoomThreeTopDoorSpawnX, LeftRoomThreeTopDoorSpawnY);
					door1.setSpawnX(LeftRoomThreeBottomDoorSpawnX);
					door1.setSpawnY(LeftRoomThreeBottomDoorSpawnY);
					createRoomLeftThree(leftRoomTwo);
					Door door2 = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
					door2.setSpawnX(LeftRoomOneTopDoorSpawnX);
					door2.setSpawnY(LeftRoomOneTopDoorSpawnY);
					door2.setRoom(3);
					leftRoomTwo.addToRoom(door2);
					Door door3 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
					door3.setSpawnX(RoomSkeletonDoorSpawnX);
					door3.setSpawnY(RoomSkeletonDoorSpawnY);
					door3.setRoom(5);
					leftRoomTwo.addToRoom(door3);
				}
			}
			else if (n == 1){
				setDoorRoomTwo(1, LeftRoomTwoBottomDoorSpawnX, LeftRoomTwoBottomDoorSpawnY);
				createRoomLeftTwo(leftRoomOne);
				Door door = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				if (m == 0) {
					setDoorRoomSkeleton(LeftRoomOneTopDoorSpawnX, LeftRoomOneTopDoorSpawnY);
					door1.setSpawnX(LeftRoomOneBottomDoorSpawnX);
					door1.setSpawnY(LeftRoomOneBottomDoorSpawnY);
					createRoomLeftOne(leftRoomTwo);
					Door door2 = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
					door2.setSpawnX(LeftRoomTwoTopDoorSpawnX);
					door2.setSpawnY(LeftRoomTwoTopDoorSpawnY);
					door2.setRoom(3);
					leftRoomTwo.addToRoom(door2);
					Door door3 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
					door3.setSpawnX(RoomSkeletonDoorSpawnX);
					door3.setSpawnY(RoomSkeletonDoorSpawnY);
					door3.setRoom(5);
					leftRoomTwo.addToRoom(door3);
				}
				else {
					setDoorRoomSkeleton(LeftRoomThreeTopDoorSpawnX, LeftRoomThreeTopDoorSpawnY);
					door1.setSpawnX(LeftRoomThreeBottomDoorSpawnX);
					door1.setSpawnY(LeftRoomThreeBottomDoorSpawnY);
					createRoomLeftThree(leftRoomTwo);
					Door door2 = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
					door2.setSpawnX(LeftRoomTwoTopDoorSpawnX);
					door2.setSpawnY(LeftRoomTwoTopDoorSpawnY);
					door2.setRoom(3);
					leftRoomTwo.addToRoom(door2);
					Door door3 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
					door3.setSpawnX(RoomSkeletonDoorSpawnX);
					door3.setSpawnY(RoomSkeletonDoorSpawnY);
					door3.setRoom(5);
					leftRoomTwo.addToRoom(door3);
				}
			}
			else{
				setDoorRoomTwo(1, LeftRoomThreeBottomDoorSpawnX, LeftRoomThreeBottomDoorSpawnY);
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				if (m == 0) {
					setDoorRoomSkeleton(LeftRoomOneTopDoorSpawnX, LeftRoomOneTopDoorSpawnY);
					door1.setSpawnX(LeftRoomOneBottomDoorSpawnX);
					door1.setSpawnY(LeftRoomOneBottomDoorSpawnY);
					createRoomLeftOne(leftRoomTwo);
					Door door2 = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
					door2.setSpawnX(LeftRoomThreeTopDoorSpawnX);
					door2.setSpawnY(LeftRoomThreeTopDoorSpawnY);
					door2.setRoom(3);
					leftRoomTwo.addToRoom(door2);
					Door door3 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
					door3.setSpawnX(RoomSkeletonDoorSpawnX);
					door3.setSpawnY(RoomSkeletonDoorSpawnY);
					door3.setRoom(5);
					leftRoomTwo.addToRoom(door3);
				}
				else {
					setDoorRoomSkeleton(LeftRoomTwoTopDoorSpawnX, LeftRoomTwoTopDoorSpawnY);
					door1.setSpawnX(LeftRoomOneBottomDoorSpawnX);
					door1.setSpawnY(LeftRoomOneBottomDoorSpawnY);
					createRoomLeftTwo(leftRoomTwo);
					Door door2 = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
					door2.setSpawnX(LeftRoomThreeTopDoorSpawnX);
					door2.setSpawnY(LeftRoomThreeTopDoorSpawnY);
					door2.setRoom(3);
					leftRoomTwo.addToRoom(door2);
					Door door3 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
					door3.setSpawnX(RoomSkeletonDoorSpawnX);
					door3.setSpawnY(RoomSkeletonDoorSpawnY);
					door3.setRoom(5);
					leftRoomTwo.addToRoom(door3);
				}
			}
			rooms.set(3, leftRoomOne);
			rooms.set(4, leftRoomTwo);
			break;
		case 2:// Hard difficulty
			n = rand.nextInt(6);
			if (n == 0) {
				setDoorRoomTwo(1, LeftRoomOneBottomDoorSpawnX, LeftRoomOneBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomThreeTopDoorSpawnX, LeftRoomThreeTopDoorSpawnY);
				createRoomLeftOne(leftRoomOne);
				createRoomLeftTwo(leftRoomTwo);
				createRoomLeftThree(leftRoomThree);
				Door door = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door1.setSpawnX(LeftRoomTwoBottomDoorSpawnX);
				door1.setSpawnY(LeftRoomTwoBottomDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				Door door2 = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door2.setSpawnX(LeftRoomOneTopDoorSpawnX);
				door2.setSpawnY(LeftRoomOneTopDoorSpawnY);
				door2.setRoom(3);
				leftRoomTwo.addToRoom(door2);
				Door door3 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door3.setSpawnX(LeftRoomThreeBottomDoorSpawnX);
				door3.setSpawnY(LeftRoomThreeBottomDoorSpawnY);
				door3.setRoom(5);
				leftRoomTwo.addToRoom(door3);
				Door door4 = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door4.setSpawnX(LeftRoomTwoTopDoorSpawnX);
				door4.setSpawnY(LeftRoomTwoTopDoorSpawnY);
				door4.setRoom(4);
				leftRoomThree.addToRoom(door4);
				Door door5 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door5.setSpawnX(RoomSkeletonDoorSpawnX);
				door5.setSpawnY(RoomSkeletonDoorSpawnY);
				door5.setRoom(6);
				leftRoomThree.addToRoom(door5);
			}
			else if (n == 1) {
				setDoorRoomTwo(1, LeftRoomOneBottomDoorSpawnX, LeftRoomOneBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomTwoTopDoorSpawnX, LeftRoomTwoTopDoorSpawnY);
				createRoomLeftOne(leftRoomOne);
				createRoomLeftTwo(leftRoomThree);
				createRoomLeftThree(leftRoomTwo);
				Door door = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door1.setSpawnX(LeftRoomThreeBottomDoorSpawnX);
				door1.setSpawnY(LeftRoomThreeBottomDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				Door door2 = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door2.setSpawnX(LeftRoomOneTopDoorSpawnX);
				door2.setSpawnY(LeftRoomOneTopDoorSpawnY);
				door2.setRoom(3);
				leftRoomTwo.addToRoom(door2);
				Door door3 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door3.setSpawnX(LeftRoomTwoBottomDoorSpawnX);
				door3.setSpawnY(LeftRoomTwoBottomDoorSpawnY);
				door3.setRoom(5);
				leftRoomTwo.addToRoom(door3);
				Door door4 = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door4.setSpawnX(LeftRoomThreeTopDoorSpawnX);
				door4.setSpawnY(LeftRoomThreeTopDoorSpawnY);
				door4.setRoom(4);
				leftRoomThree.addToRoom(door4);
				Door door5 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door5.setSpawnX(RoomSkeletonDoorSpawnX);
				door5.setSpawnY(RoomSkeletonDoorSpawnY);
				door5.setRoom(6);
				leftRoomThree.addToRoom(door5);
			}
			else if (n == 2) {
				setDoorRoomTwo(1, LeftRoomTwoBottomDoorSpawnX, LeftRoomTwoBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomThreeTopDoorSpawnX, LeftRoomThreeTopDoorSpawnY);
				createRoomLeftOne(leftRoomTwo);
				createRoomLeftTwo(leftRoomOne);
				createRoomLeftThree(leftRoomThree);
				Door door = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door1.setSpawnX(LeftRoomOneBottomDoorSpawnX);
				door1.setSpawnY(LeftRoomOneBottomDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				Door door2 = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);;
				door2.setSpawnX(LeftRoomTwoTopDoorSpawnX);
				door2.setSpawnY(LeftRoomTwoTopDoorSpawnY);
				door2.setRoom(3);
				leftRoomTwo.addToRoom(door2);
				Door door3 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door3.setSpawnX(LeftRoomThreeBottomDoorSpawnX);
				door3.setSpawnY(LeftRoomThreeBottomDoorSpawnY);
				door3.setRoom(5);
				leftRoomTwo.addToRoom(door3);
				Door door4 = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door4.setSpawnX(LeftRoomOneTopDoorSpawnX);
				door4.setSpawnY(LeftRoomOneTopDoorSpawnY);
				door4.setRoom(4);
				leftRoomThree.addToRoom(door4);
				Door door5 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door5.setSpawnX(RoomSkeletonDoorSpawnX);
				door5.setSpawnY(RoomSkeletonDoorSpawnY);
				door5.setRoom(6);
				leftRoomThree.addToRoom(door5);
			}
			else if (n == 3) {
				setDoorRoomTwo(1, LeftRoomThreeBottomDoorSpawnX, LeftRoomThreeBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomTwoTopDoorSpawnX, LeftRoomTwoTopDoorSpawnY);
				createRoomLeftOne(leftRoomTwo);
				createRoomLeftTwo(leftRoomThree);
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door1.setSpawnX(LeftRoomOneBottomDoorSpawnX);
				door1.setSpawnY(LeftRoomOneBottomDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				Door door2 = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door2.setSpawnX(LeftRoomThreeTopDoorSpawnX);
				door2.setSpawnY(LeftRoomThreeTopDoorSpawnY);
				door2.setRoom(3);
				leftRoomTwo.addToRoom(door2);
				Door door3 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door3.setSpawnX(LeftRoomTwoBottomDoorSpawnX);
				door3.setSpawnY(LeftRoomTwoBottomDoorSpawnY);
				door3.setRoom(5);
				leftRoomTwo.addToRoom(door3);
				Door door4 = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door4.setSpawnX(LeftRoomOneTopDoorSpawnX);
				door4.setSpawnY(LeftRoomOneTopDoorSpawnY);
				door4.setRoom(4);
				leftRoomThree.addToRoom(door4);
				Door door5 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door5.setSpawnX(RoomSkeletonDoorSpawnX);
				door5.setSpawnY(RoomSkeletonDoorSpawnY);
				door5.setRoom(6);
				leftRoomThree.addToRoom(door5);
			}
			else if (n == 4) {
				setDoorRoomTwo(1, LeftRoomTwoBottomDoorSpawnX, LeftRoomTwoBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomOneTopDoorSpawnX, LeftRoomOneTopDoorSpawnY);
				createRoomLeftOne(leftRoomThree);
				createRoomLeftTwo(leftRoomOne);
				createRoomLeftThree(leftRoomTwo);
				Door door = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door1.setSpawnX(LeftRoomThreeBottomDoorSpawnX);
				door1.setSpawnY(LeftRoomThreeBottomDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				Door door2 = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door2.setSpawnX(LeftRoomTwoTopDoorSpawnX);
				door2.setSpawnY(LeftRoomTwoTopDoorSpawnY);
				door2.setRoom(3);
				leftRoomTwo.addToRoom(door2);
				Door door3 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door3.setSpawnX(LeftRoomOneBottomDoorSpawnX);
				door3.setSpawnY(LeftRoomOneBottomDoorSpawnY);
				door3.setRoom(5);
				leftRoomTwo.addToRoom(door3);
				Door door4 = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door4.setSpawnX(LeftRoomThreeTopDoorSpawnX);
				door4.setSpawnY(LeftRoomThreeTopDoorSpawnY);
				door4.setRoom(4);
				leftRoomThree.addToRoom(door4);
				Door door5 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door5.setSpawnX(RoomSkeletonDoorSpawnX);
				door5.setSpawnY(RoomSkeletonDoorSpawnY);
				door5.setRoom(6);
				leftRoomThree.addToRoom(door5);
			}
			else {
				setDoorRoomTwo(1, LeftRoomThreeBottomDoorSpawnX, LeftRoomThreeBottomDoorSpawnY);
				setDoorRoomSkeleton(LeftRoomOneTopDoorSpawnX, LeftRoomOneTopDoorSpawnY);
				createRoomLeftOne(leftRoomThree);
				createRoomLeftTwo(leftRoomTwo);
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(LeftRoomThreeBottomDoorX, LeftRoomThreeBottomDoorY);
				door.setSpawnX(RoomTwoLeftDoorSpawnX);
				door.setSpawnY(RoomTwoLeftDoorSpawnY);
				door.setRoom(2);
				leftRoomOne.addToRoom(door);
				Door door1 = new Door(LeftRoomThreeTopDoorX, LeftRoomThreeTopDoorY);
				door1.setSpawnX(LeftRoomTwoBottomDoorSpawnX);
				door1.setSpawnY(LeftRoomTwoBottomDoorSpawnY);
				door1.setRoom(4);
				leftRoomOne.addToRoom(door1);
				Door door2 = new Door(LeftRoomTwoBottomDoorX, LeftRoomTwoBottomDoorY);
				door2.setSpawnX(LeftRoomThreeTopDoorSpawnX);
				door2.setSpawnY(LeftRoomThreeTopDoorSpawnY);
				door2.setRoom(3);
				leftRoomTwo.addToRoom(door2);
				Door door3 = new Door(LeftRoomTwoTopDoorX, LeftRoomTwoTopDoorY);
				door3.setSpawnX(LeftRoomOneBottomDoorSpawnX);
				door3.setSpawnY(LeftRoomOneBottomDoorSpawnY);
				door3.setRoom(5);
				leftRoomTwo.addToRoom(door3);
				Door door4 = new Door(LeftRoomOneBottomDoorX, LeftRoomOneBottomDoorY);
				door4.setSpawnX(LeftRoomTwoTopDoorSpawnX);
				door4.setSpawnY(LeftRoomTwoTopDoorSpawnY);
				door4.setRoom(4);
				leftRoomThree.addToRoom(door4);
				Door door5 = new Door(LeftRoomOneTopDoorX, LeftRoomOneTopDoorY);
				door5.setSpawnX(RoomSkeletonDoorSpawnX);
				door5.setSpawnY(RoomSkeletonDoorSpawnY);
				door5.setRoom(6);
				leftRoomThree.addToRoom(door5);
			}
			rooms.set(3, leftRoomOne);
			rooms.set(4 ,leftRoomTwo);
			rooms.set(5, leftRoomThree);
			break;
		}
	}

	private void createRoomLeftOne(Room room){
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,72,72,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1, 3,34,-1,-1,32, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,19,50,-1,-1,48,21,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1, 3, 4,34,-1,-1,-1,-1,32, 4, 5,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,19,20,50,-1,-1,-1,-1,48,20,21,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1, 3, 4,34,-1,-1,-1,-1,-1,-1,-1,-1,32, 4, 5,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,19,20,50,-1,-1,-1,-1,-1,-1,-1,-1,48,20,21,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,35,36,97,-1,-1,-1,-1,-1,-1,-1,-1,98,36,37,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,51,52,113,-1,-1,-1,-1,-1,-1,-1,-1,114,52,53,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,35,36,97,-1,-1,-1,-1,98,36,37,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,51,52,113,-1,-1,-1,-1,114,52,53,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,35,97,-1,-1,98,37,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,51,113,-1,-1,114,53,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,35,-1,-1,37,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,52,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,36,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room.createLevel(floor, wall, decor, 128, 12, assets);
		//GiantSpider spider1 = new GiantSpider(300, 400);
		//room.addEntityList(spider1);
	}

	private void createRoomLeftTwo(Room room){
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,72,72,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 5,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,21,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4,34,-1,-1,16,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,19,20,20,20,20,20,20,20,20,20,50,-1,-1,16,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1,-1,-1},
				{-1,-1,-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1,-1,-1},
				{-1,-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1,-1},
				{-1,-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1,-1},
				{-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1},
				{-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,98,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,37,-1,-1},
				{-1,-1,18,-1,-1,114,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,53,-1,-1},
				{-1,-1,35,-1,-1,37,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,51,52,52,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,23,24,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,36,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room.createLevel(floor, wall, decor, 128, 12, assets);
		//GiantRat rat1 = new GiantRat(240, 300);
		//room.addEntityList(rat1);
		//GiantSpider spider1 = new GiantSpider(300, 400);
		//room.addEntityList(spider1);
	}

	private void createRoomLeftThree(Room room){
		int[][] floor = {
				{-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,88,72,72,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1},
				{88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1, 3, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,19,-1,-1,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{ 3, 4,34,-1,-1,32, 4, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{19,20,50,-1,-1,48,20,20,20,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 5,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,19,20,20,20,20,20,20,21,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,32, 4, 4, 4, 4, 4,34,-1,-1,-1,-1,-1,-1,16,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,48,20,20,20,20,20,50,-1,-1,-1,-1,-1,-1,16,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,98,36,36,36,36,36,97,-1,-1,-1,-1,-1,-1,16,-1},
				{18,-1,-1,-1,-1,-1,-1,-1,-1,114,52,52,52,52,52,113,-1,-1,-1,-1,-1,-1,16,-1},
				{35,36,36,36,36,36,36,36,36,37,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,16,-1},
				{51,52,52,52,52,52,52,52,52,53,-1,-1,-1,-1,-1,35,36,97,-1,-1,98,36,37,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,113,-1,-1,114,52,53,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,35,-1,-1,37,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,52,53,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,36,36,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room.createLevel(floor, wall, decor, 128, 12, assets);
		//GiantRat rat1 = new GiantRat(240, 300);
		//room.addEntityList(rat1);
		//GiantRat rat2 = new GiantRat(240, 300);
		//room.addEntityList(rat2);
		//GiantRat rat3 = new GiantRat(240, 300);
		//room.addEntityList(rat3);
	}

	private void createRoomSkeleton(){
		Room roomSkeleton = new Room(4 + difficulty);
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,19,20,20,20,20,20,20,21,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1, 3, 4,34,-1,-1,-1,-1,-1,-1,32, 4, 5,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,19,20,50,-1,-1,-1,-1,-1,-1,48,20,21,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1, 3,34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 5,-1,-1,-1,-1},
				{-1,-1,-1,-1,19,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,21,-1,-1,-1,-1},
				{-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1},
				{-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1},
				{-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1},
				{-1,-1,-1,-1,35,36,36,36,36,36,97,-1,-1,98,36,36,36,36,36,37,-1,-1,-1,-1},
				{-1,-1,-1,-1,51,52,52,52,52,52,113,-1,-1,114,52,52,52,52,52,53,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,35,-1,-1,37,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,52,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,36,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		roomSkeleton.createLevel(floor, wall, decor, 128, 12, assets);
		//Skeleton skeleton = new Skeleton(300, 300);
		//roomSkeleton.addToRoom(skeleton);
		rooms.set(4 + difficulty, roomSkeleton);
	}
	private void createRightHallway(){
		Room rightRoomOne = new Room(5+difficulty);
		Room rightRoomTwo = new Room(6+difficulty);
		Room rightRoomThree = new Room(7+difficulty);
		Random rand = new Random();
		int n = rand.nextInt(3);
		switch(difficulty) {
		case 0:// Easy difficulty
			if (n == 0) {
				createRoomRightOne(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(6);
				rightRoomOne.addToRoom(door1);
			}
			else if (n == 1) {
				createRoomRightTwo(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(6);
				rightRoomOne.addToRoom(door1);
			}
			else {
				createRoomRightThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(6);
				rightRoomOne.addToRoom(door1);
			}
			rooms.set(5+difficulty, rightRoomOne);
			break;
		case 1:// Medium difficulty
			int m = rand.nextInt(2);
			if (n == 0) {
				createRoomRightOne(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(7);
				rightRoomOne.addToRoom(door1);
				if (m == 0) {
					createRoomRightTwo(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
				else {
					createRoomRightThree(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
			}
			else if (n == 1){
				createRoomLeftTwo(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(7);
				rightRoomOne.addToRoom(door1);
				if (m == 0) {
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
				else {
					createRoomRightThree(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
			}
			else{
				createRoomLeftThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(7);
				rightRoomOne.addToRoom(door1);
				if (m == 0) {
					createRoomRightOne(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
				else {
					createRoomRightTwo(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
			}
			rooms.set(5+difficulty, rightRoomOne);
			rooms.set(6+difficulty, rightRoomTwo);
			break;
		case 2:// Hard difficulty
			n = rand.nextInt(6);
			if (n == 0) {
				createRoomRightOne(rightRoomOne);
				createRoomRightTwo(rightRoomTwo);
				createRoomRightThree(rightRoomThree);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addToRoom(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addToRoom(door5);
			}
			else if (n == 1) {
				createRoomRightOne(rightRoomOne);
				createRoomRightTwo(rightRoomThree);
				createRoomRightThree(rightRoomTwo);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addToRoom(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addToRoom(door5);
			}
			else if (n == 2) {
				createRoomRightOne(rightRoomTwo);
				createRoomRightTwo(rightRoomOne);
				createRoomRightThree(rightRoomThree);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addToRoom(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addToRoom(door5);
			}
			else if (n == 3) {
				createRoomRightOne(rightRoomTwo);
				createRoomRightTwo(rightRoomThree);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addToRoom(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addToRoom(door5);
			}
			else if (n == 4) {
				createRoomRightOne(rightRoomThree);
				createRoomRightTwo(rightRoomOne);
				createRoomRightThree(rightRoomTwo);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addToRoom(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addToRoom(door5);
			}
			else {
				createRoomRightOne(rightRoomThree);
				createRoomRightTwo(rightRoomTwo);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addToRoom(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addToRoom(door5);
			}
			rooms.set(5+difficulty, rightRoomOne);
			rooms.set(6+difficulty, rightRoomTwo);
			rooms.set(7+difficulty, rightRoomThree);
			break;
		}
	}

	private void createRoomRightOne(Room room){
		GiantRat rat1 = new GiantRat(240, 300);
		room.addEntityList(rat1);
		GiantRat rat2 = new GiantRat(240, 300);
		room.addEntityList(rat2);
		GiantSpider spider1 = new GiantSpider(300, 400);
		room.addEntityList(spider1);
	}

	private void createRoomRightTwo(Room room){
		GiantSpider spider1 = new GiantSpider(300, 400);
		room.addEntityList(spider1);
		GiantSpider spider2 = new GiantSpider(300, 400);
		room.addEntityList(spider2);
		GiantSpider spider3 = new GiantSpider(300, 400);
		room.addEntityList(spider3);
	}

	private void createRoomRightThree(Room room){
		GiantRat rat1 = new GiantRat(240, 300);
		room.addEntityList(rat1);
		GiantRat rat2 = new GiantRat(240, 300);
		room.addEntityList(rat2);
		GiantRat rat3 = new GiantRat(240, 300);
		room.addEntityList(rat3);
	}

	private void createRoomPuzzle(){
		Room roomPuzzle = new Room(6 + 2*difficulty);
		Door door = new Door(700, 500);
		door.setSpawnX(300);
		door.setSpawnY(400);
		door.setRoom(1);
		roomPuzzle.addToRoom(door);
		Door door1 = new Door(700, 500);
		door1.setSpawnX(300);
		door1.setSpawnY(400);
		door1.setRoom(3);
		roomPuzzle.addToRoom(door1);
		rooms.set(6 + (2*difficulty), roomPuzzle);
	}

	private void createRoomBoss(){
		Room roomBoss = new Room(7 + 2*difficulty);
		rooms.set(7 + (2*difficulty), roomBoss);
	}

	public List<Room> getRoomList() {
		return this.rooms;
	}

	public void setDoorRoomTwo(int doorNumber, int x_pos, int y_pos) {
		switch(doorNumber) {
		case 1:
			Door door1 = new Door(RoomTwoLeftDoorX, RoomTwoLeftDoorY);
			door1.setSpawnX(x_pos);
			door1.setSpawnY(y_pos);
			door1.setRoom(3);
			rooms.get(2).addToRoom(door1);
			break;
		case 2:
			Door door2 = new Door(RoomTwoRightDoorX, RoomTwoRightDoorY);
			door2.setSpawnX(x_pos);
			door2.setSpawnY(y_pos);
			door2.setRoom(7 + difficulty);
			rooms.get(2).addToRoom(door2);
			break;
		}
	}

	public void setDoorRoomSkeleton(int x_pos, int y_pos) {
		Door door1 = new Door(RoomSkeletonDoorX, RoomSkeletonDoorY);
		door1.setSpawnX(x_pos);
		door1.setSpawnY(y_pos);
		door1.setRoom(3+difficulty);
		rooms.get(4 + difficulty).addToRoom(door1);
	}
}
