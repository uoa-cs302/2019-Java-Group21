package Game;

import java.util.ArrayList;
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
	private static final int RoomTwoBottomDoorSpawnY = 514;

	private static final int RoomTwoLeftDoorX = 208;
	private static final int RoomTwoLeftDoorY = 42;

	private static final int RoomTwoLeftDoorSpawnX = 208;
	private static final int RoomTwoLeftDoorSpawnY = 76;

	private static final int RoomTwoRightDoorX = 862;
	private static final int RoomTwoRightDoorY = 244;

	private static final int RoomTwoRightDoorSpawnX = 828;
	private static final int RoomTwoRightDoorSpawnY = 244;

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

	// Right Room One
	private static final int RightRoomOneLeftDoorX = 162;
	private static final int RightRoomOneLeftDoorY = 444;

	private static final int RightRoomOneLeftDoorSpawnX = 196;
	private static final int RightRoomOneLeftDoorSpawnY = 444;

	private static final int RightRoomOneRightDoorX = 702;
	private static final int RightRoomOneRightDoorY = 444;

	private static final int RightRoomOneRightDoorSpawnX = 668;
	private static final int RightRoomOneRightDoorSpawnY = 444;

	// Right Room Two
	private static final int RightRoomTwoLeftDoorX = 130;
	private static final int RightRoomTwoLeftDoorY = 156;

	private static final int RightRoomTwoLeftDoorSpawnX = 164;
	private static final int RightRoomTwoLeftDoorSpawnY = 156;

	private static final int RightRoomTwoRightDoorX = 862;
	private static final int RightRoomTwoRightDoorY = 444;

	private static final int RightRoomTwoRightDoorSpawnX = 828;
	private static final int RightRoomTwoRightDoorSpawnY = 444;

	// Right Room Three
	private static final int RightRoomThreeLeftDoorX = 130;
	private static final int RightRoomThreeLeftDoorY = 276;

	private static final int RightRoomThreeLeftDoorSpawnX = 164;
	private static final int RightRoomThreeLeftDoorSpawnY = 276;

	private static final int RightRoomThreeRightDoorX = 862;
	private static final int RightRoomThreeRightDoorY = 276;

	private static final int RightRoomThreeRightDoorSpawnX = 828;
	private static final int RightRoomThreeRightDoorSpawnY = 276;

	// Puzzle Room
	private static final int RoomPuzzleDoorX = 222;
	private static final int RoomPuzzleDoorY = 444;

	private static final int RoomPuzzleDoorSpawnX = 256;
	private static final int RoomPuzzleDoorSpawnY = 444;

	private static final int RoomPuzzleDoorTwoX = 592;
	private static final int RoomPuzzleDoorTwoY = 44;

	private static final int RoomPuzzleDoorTwoSpawnX = 592;
	private static final int RoomPuzzleDoorTwoSpawnY = 68;
	
	// Boss Room
	private static final int RoomBossDoorX = 496;
	private static final int RoomBossDoorY = 486;

	private static final int RoomBossDoorSpawnX = 496;
	private static final int RoomBossDoorSpawnY = 452;
	
	// Difficulty determines the number of rooms in the dungeon
	public Dungeon(Image assets) {
		this.difficulty = difficulty;
		this.assets = assets;
	}

	// Allows the accessing of a specific Room in the Dungeon
	public Room getDungeonIndex(int index) {
		return this.rooms.get(index);
	}

	public void generateDungeon(int difficulty) {
		this.difficulty = difficulty;
		for (int i = 0; i < 8 + (2*difficulty); i++) {
			rooms.add(null);
		}
		createRoomWell();
		createRoomOne();
		createRoomSkeleton();
		createLeftHallway();
		createRoomPuzzle();
		createRightHallway();
		createRoomBoss();
	}
	
	private void createRoomWell(){
		Room well = new Room(1);
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,72,72,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,64, 4, 4,67,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,19,-1,-1,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1, 3, 4, 4, 4,65,-1,-1,66, 4, 4, 4, 5,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,19,20,20,20,81,-1,-1,82,20,20,20,21,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,35,36,36,36,36,36,36,36,36,36,36,37,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,51,52,52,52,52,52,52,52,52,52,52,53,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
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
		well.setFloorGrid(floor);
		well.setWallGrid(wall);
		well.setDecorGrid(decor);
		well.createLevel(128, 12, assets);
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
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1,-1},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,-1,-1},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{64, 4, 4, 4, 4,67,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{19,20,-1,-1,20,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 5,-1,-1},
				{35,97,-1,-1,98,37,-1,-1,-1,-1,-1,-1,-1,-1,19,20,20,20,20,20,20,21,-1,-1},
				{51,113,-1,-1,114,53,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,32, 4, 5},
				{-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,48,20,21},
				{-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,18,-1,-1,32, 4, 4, 4, 4, 4, 4, 4, 4, 4,34,-1,-1,-1,-1,-1,-1,98,36,37},
				{-1,18,-1,-1,48,20,20,20,20,20,20,20,20,20,50,-1,-1,-1,-1,-1,-1,114,52,53},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,35,36,36,36,36,36,36,36,36,97,-1,-1,98,36,36,36,36,36,36,36,37,-1,-1},
				{-1,51,52,52,52,52,52,52,52,52,113,-1,-1,114,52,52,52,52,52,52,52,53,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,35,-1,-1,37,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,51,52,52,53,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
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
		room1.setFloorGrid(floor);
		room1.setWallGrid(wall);
		room1.setDecorGrid(decor);
		room1.createLevel(128, 12, assets);
		GiantRat rat1 = new GiantRat(240, 400, assets.getRat());
		room1.addToRoom(rat1);
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
		room.setFloorGrid(floor);
		room.setWallGrid(wall);
		room.setDecorGrid(decor);
		room.createLevel(128, 12, assets);
		GiantSpider spider = new GiantSpider(528, 172, assets.getSpider());
		spider.setWalls(wall);
		room.addToRoom(spider);
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
		room.setFloorGrid(floor);
		room.setWallGrid(wall);
		room.setDecorGrid(decor);
		room.createLevel(128, 12, assets);
		GiantRat rat1 = new GiantRat(250, 300, assets.getRat());
		GiantRat rat3 = new GiantRat(600, 300, assets.getRat());
		room.addToRoom(rat3);
		room.addToRoom(rat1);
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
		room.setFloorGrid(floor);
		room.setWallGrid(wall);
		room.setDecorGrid(decor);
		room.createLevel(128, 12, assets);
		GiantRat rat1 = new GiantRat(736, 428, assets.getRat());
		room.addToRoom(rat1);
		GiantSpider spider = new GiantSpider(328, 172, assets.getSpider());
		spider.setWalls(wall);
		room.addToRoom(spider);
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
		roomSkeleton.setFloorGrid(floor);
		roomSkeleton.setWallGrid(wall);
		roomSkeleton.setDecorGrid(decor);
		roomSkeleton.createLevel(128, 12, assets);
		Skeleton skeleton = new Skeleton(496, 172, assets.getSkeleton());
		roomSkeleton.addToRoom(skeleton);
		Chest chest = new Chest(496, 102, assets.getChest());
		Sword sword = new Sword(0,0);
		chest.addItem(sword);
		roomSkeleton.addToRoom(chest);
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
				setDoorRoomTwo(2, RightRoomOneLeftDoorSpawnX, RightRoomOneLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomOneRightDoorSpawnX, RightRoomOneRightDoorSpawnY);
				createRoomRightOne(rightRoomOne);
				Door door = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door1.setSpawnX(RoomPuzzleDoorSpawnX);
				door1.setSpawnY(RoomPuzzleDoorSpawnY);
				door1.setRoom(6);
				rightRoomOne.addToRoom(door1);
			}
			else if (n == 1) {
				setDoorRoomTwo(2, RightRoomTwoLeftDoorSpawnX, RightRoomTwoLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomTwoRightDoorSpawnX, RightRoomTwoRightDoorSpawnY);
				createRoomRightTwo(rightRoomOne);
				Door door = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door1.setSpawnX(RoomPuzzleDoorSpawnX);
				door1.setSpawnY(RoomPuzzleDoorSpawnY);
				door1.setRoom(6);
				rightRoomOne.addToRoom(door1);
			}
			else {
				setDoorRoomTwo(2, RightRoomThreeLeftDoorSpawnX, RightRoomThreeLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomThreeRightDoorSpawnX, RightRoomThreeRightDoorSpawnY);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door1.setSpawnX(RoomPuzzleDoorSpawnX);
				door1.setSpawnY(RoomPuzzleDoorSpawnY);
				door1.setRoom(6);
				rightRoomOne.addToRoom(door1);
			}
			rooms.set(5, rightRoomOne);
			break;
		case 1:// Medium difficulty
			int m = rand.nextInt(2);
			if (n == 0) {
				setDoorRoomTwo(2, RightRoomOneLeftDoorSpawnX, RightRoomOneLeftDoorSpawnY);
				createRoomRightOne(rightRoomOne);
				Door door = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door1.setRoom(7);
				rightRoomOne.addToRoom(door1);
				if (m == 0) {
					setDoorRoomPuzzle(RightRoomTwoRightDoorSpawnX, RightRoomTwoRightDoorSpawnY);
					door1.setSpawnX(RightRoomTwoLeftDoorSpawnX);
					door1.setSpawnY(RightRoomTwoLeftDoorSpawnY);
					createRoomRightTwo(rightRoomTwo);
					Door door2 = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
					door2.setSpawnX(RightRoomOneRightDoorSpawnX);
					door2.setSpawnY(RightRoomOneRightDoorSpawnY);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
					door3.setSpawnX(RoomPuzzleDoorSpawnX);
					door3.setSpawnY(RoomPuzzleDoorSpawnY);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
				else {
					setDoorRoomPuzzle(RightRoomThreeRightDoorSpawnX, RightRoomThreeRightDoorSpawnY);
					door1.setSpawnX(RightRoomThreeLeftDoorSpawnX);
					door1.setSpawnY(RightRoomThreeLeftDoorSpawnY);
					createRoomRightThree(rightRoomTwo);
					Door door2 = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
					door2.setSpawnX(RightRoomOneRightDoorSpawnX);
					door2.setSpawnY(RightRoomOneRightDoorSpawnY);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
					door3.setSpawnX(RoomPuzzleDoorSpawnX);
					door3.setSpawnY(RoomPuzzleDoorSpawnY);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
			}
			else if (n == 1){
				setDoorRoomTwo(2, RightRoomTwoLeftDoorSpawnX, RightRoomTwoLeftDoorSpawnY);
				createRoomRightTwo(rightRoomOne);
				Door door = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door1.setRoom(7);
				rightRoomOne.addToRoom(door1);
				if (m == 0) {
					setDoorRoomPuzzle(RightRoomOneRightDoorSpawnX, RightRoomOneRightDoorSpawnY);
					door1.setSpawnX(RightRoomOneLeftDoorSpawnX);
					door1.setSpawnY(RightRoomOneLeftDoorSpawnY);
					createRoomRightOne(rightRoomTwo);
					Door door2 = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
					door2.setSpawnX(RightRoomTwoRightDoorSpawnX);
					door2.setSpawnY(RightRoomTwoRightDoorSpawnY);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
					door3.setSpawnX(RoomPuzzleDoorSpawnX);
					door3.setSpawnY(RoomPuzzleDoorSpawnY);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
				else {
					setDoorRoomPuzzle(RightRoomThreeRightDoorSpawnX, RightRoomThreeRightDoorSpawnY);
					door1.setSpawnX(RightRoomThreeLeftDoorSpawnX);
					door1.setSpawnY(RightRoomThreeLeftDoorSpawnY);
					createRoomRightThree(rightRoomTwo);
					Door door2 = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
					door2.setSpawnX(RightRoomTwoRightDoorSpawnX);
					door2.setSpawnY(RightRoomTwoRightDoorSpawnY);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
					door3.setSpawnX(RoomPuzzleDoorSpawnX);
					door3.setSpawnY(RoomPuzzleDoorSpawnY);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
			}
			else{
				setDoorRoomTwo(2, RightRoomThreeLeftDoorSpawnX, RightRoomThreeLeftDoorSpawnY);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door1.setRoom(7);
				rightRoomOne.addToRoom(door1);
				if (m == 0) {
					setDoorRoomPuzzle(RightRoomOneRightDoorSpawnX, RightRoomOneRightDoorSpawnY);
					createRoomRightOne(rightRoomTwo);
					door1.setSpawnX(RightRoomThreeLeftDoorSpawnX);
					door1.setSpawnY(RightRoomThreeLeftDoorSpawnY);
					Door door2 = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
					door2.setSpawnX(RightRoomOneLeftDoorSpawnX);
					door2.setSpawnY(RightRoomOneLeftDoorSpawnY);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
					door3.setSpawnX(RoomPuzzleDoorSpawnX);
					door3.setSpawnY(RoomPuzzleDoorSpawnY);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
				else {
					setDoorRoomPuzzle(RightRoomTwoRightDoorSpawnX, RightRoomTwoRightDoorSpawnY);
					createRoomRightTwo(rightRoomTwo);
					door1.setSpawnX(RightRoomTwoLeftDoorSpawnX);
					door1.setSpawnY(RightRoomTwoLeftDoorSpawnY);
					Door door2 = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
					door2.setSpawnX(RightRoomThreeLeftDoorSpawnX);
					door2.setSpawnY(RightRoomThreeLeftDoorSpawnY);
					door2.setRoom(6);
					rightRoomTwo.addToRoom(door2);
					Door door3 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
					door3.setSpawnX(RoomPuzzleDoorSpawnX);
					door3.setSpawnY(RoomPuzzleDoorSpawnY);
					door3.setRoom(8);
					rightRoomTwo.addToRoom(door3);
				}
			}
			rooms.set(6, rightRoomOne);
			rooms.set(7, rightRoomTwo);
			break;
		case 2:// Hard difficulty
			n = rand.nextInt(6);
			if (n == 0) {
				setDoorRoomTwo(2, RightRoomOneLeftDoorSpawnX, RightRoomOneLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomThreeRightDoorSpawnX, RightRoomThreeRightDoorSpawnY);
				createRoomRightOne(rightRoomOne);
				createRoomRightTwo(rightRoomTwo);
				createRoomRightThree(rightRoomThree);
				Door door = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door1.setSpawnX(RightRoomTwoLeftDoorSpawnX);
				door1.setSpawnY(RightRoomTwoLeftDoorSpawnY);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door2.setSpawnX(RightRoomOneRightDoorSpawnX);
				door2.setSpawnY(RightRoomOneRightDoorSpawnY);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door3.setSpawnX(RightRoomThreeLeftDoorSpawnX);
				door3.setSpawnY(RightRoomThreeLeftDoorSpawnY);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door4.setSpawnX(RightRoomTwoRightDoorSpawnX);
				door4.setSpawnY(RightRoomTwoRightDoorSpawnY);
				door4.setRoom(8);
				rightRoomThree.addToRoom(door4);
				Door door5 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door5.setSpawnX(RoomPuzzleDoorSpawnX);
				door5.setSpawnY(RoomPuzzleDoorSpawnY);
				door5.setRoom(10);
				rightRoomThree.addToRoom(door5);
			}
			else if (n == 1) {
				setDoorRoomTwo(2, RightRoomOneLeftDoorSpawnX, RightRoomOneLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomTwoRightDoorSpawnX, RightRoomTwoRightDoorSpawnY);
				createRoomRightOne(rightRoomOne);
				createRoomRightTwo(rightRoomThree);
				createRoomRightThree(rightRoomTwo);
				Door door = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door1.setSpawnX(RightRoomThreeLeftDoorSpawnX);
				door1.setSpawnY(RightRoomThreeLeftDoorSpawnY);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door2.setSpawnX(RightRoomOneRightDoorSpawnX);
				door2.setSpawnY(RightRoomOneRightDoorSpawnY);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door3.setSpawnX(RightRoomTwoLeftDoorSpawnX);
				door3.setSpawnY(RightRoomTwoLeftDoorSpawnY);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door4.setSpawnX(RightRoomThreeRightDoorSpawnX);
				door4.setSpawnY(RightRoomThreeRightDoorSpawnY);
				door4.setRoom(8);
				rightRoomThree.addToRoom(door4);
				Door door5 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door5.setSpawnX(RoomPuzzleDoorSpawnX);
				door5.setSpawnY(RoomPuzzleDoorSpawnY);
				door5.setRoom(10);
				rightRoomThree.addToRoom(door5);
			}
			else if (n == 2) {
				setDoorRoomTwo(2, RightRoomTwoLeftDoorSpawnX, RightRoomTwoLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomThreeRightDoorSpawnX, RightRoomThreeRightDoorSpawnY);
				createRoomRightOne(rightRoomTwo);
				createRoomRightTwo(rightRoomOne);
				createRoomRightThree(rightRoomThree);
				Door door = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door1.setSpawnX(RightRoomOneLeftDoorSpawnX);
				door1.setSpawnY(RightRoomOneLeftDoorSpawnY);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door2.setSpawnX(RightRoomTwoRightDoorSpawnX);
				door2.setSpawnY(RightRoomTwoRightDoorSpawnY);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door3.setSpawnX(RightRoomThreeLeftDoorSpawnX);
				door3.setSpawnY(RightRoomThreeLeftDoorSpawnY);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door4.setSpawnX(RightRoomOneRightDoorSpawnX);
				door4.setSpawnY(RightRoomOneRightDoorSpawnY);
				door4.setRoom(8);
				rightRoomThree.addToRoom(door4);
				Door door5 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door5.setSpawnX(RoomPuzzleDoorSpawnX);
				door5.setSpawnY(RoomPuzzleDoorSpawnY);
				door5.setRoom(10);
				rightRoomThree.addToRoom(door5);
			}
			else if (n == 3) {
				setDoorRoomTwo(2, RightRoomThreeLeftDoorSpawnX, RightRoomThreeLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomTwoRightDoorSpawnX, RightRoomTwoRightDoorSpawnY);
				createRoomRightOne(rightRoomTwo);
				createRoomRightTwo(rightRoomThree);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door1.setSpawnX(RightRoomOneLeftDoorSpawnX);
				door1.setSpawnY(RightRoomOneLeftDoorSpawnY);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door2.setSpawnX(RightRoomThreeRightDoorSpawnX);
				door2.setSpawnY(RightRoomThreeRightDoorSpawnY);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door3.setSpawnX(RightRoomTwoLeftDoorSpawnX);
				door3.setSpawnY(RightRoomTwoLeftDoorSpawnY);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door4.setSpawnX(RightRoomOneRightDoorSpawnX);
				door4.setSpawnY(RightRoomOneRightDoorSpawnY);
				door4.setRoom(8);
				rightRoomThree.addToRoom(door4);
				Door door5 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door5.setSpawnX(RoomPuzzleDoorSpawnX);
				door5.setSpawnY(RoomPuzzleDoorSpawnY);
				door5.setRoom(10);
				rightRoomThree.addToRoom(door5);
			}
			else if (n == 4) {
				setDoorRoomTwo(2, RightRoomTwoLeftDoorSpawnX, RightRoomTwoLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomOneRightDoorSpawnX, RightRoomOneRightDoorSpawnY);
				createRoomRightOne(rightRoomThree);
				createRoomRightTwo(rightRoomOne);
				createRoomRightThree(rightRoomTwo);
				Door door = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door1.setSpawnX(RightRoomThreeLeftDoorSpawnX);
				door1.setSpawnY(RightRoomThreeLeftDoorSpawnY);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door2.setSpawnX(RightRoomThreeRightDoorSpawnX);
				door2.setSpawnY(RightRoomThreeRightDoorSpawnY);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);;
				door3.setSpawnX(RightRoomOneLeftDoorSpawnX);
				door3.setSpawnY(RightRoomOneLeftDoorSpawnY);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door4.setSpawnX(RightRoomThreeRightDoorSpawnX);
				door4.setSpawnY(RightRoomThreeRightDoorSpawnY);
				door4.setRoom(8);
				rightRoomThree.addToRoom(door4);
				Door door5 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door5.setSpawnX(RoomPuzzleDoorSpawnX);
				door5.setSpawnY(RoomPuzzleDoorSpawnY);
				door5.setRoom(10);
				rightRoomThree.addToRoom(door5);
			}
			else {
				setDoorRoomTwo(2, RightRoomThreeLeftDoorSpawnX, RightRoomThreeLeftDoorSpawnY);
				setDoorRoomPuzzle(RightRoomOneRightDoorSpawnX, RightRoomOneRightDoorSpawnY);
				createRoomRightOne(rightRoomThree);
				createRoomRightTwo(rightRoomTwo);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(RightRoomThreeLeftDoorX, RightRoomThreeLeftDoorY);
				door.setSpawnX(RoomTwoRightDoorSpawnX);
				door.setSpawnY(RoomTwoRightDoorSpawnY);
				door.setRoom(2);
				rightRoomOne.addToRoom(door);
				Door door1 = new Door(RightRoomThreeRightDoorX, RightRoomThreeRightDoorY);
				door1.setSpawnX(RightRoomTwoLeftDoorSpawnX);
				door1.setSpawnY(RightRoomTwoLeftDoorSpawnY);
				door1.setRoom(8);
				rightRoomOne.addToRoom(door1);
				Door door2 = new Door(RightRoomTwoLeftDoorX, RightRoomTwoLeftDoorY);
				door2.setSpawnX(RightRoomThreeRightDoorSpawnX);
				door2.setSpawnY(RightRoomThreeRightDoorSpawnY);
				door2.setRoom(7);
				rightRoomTwo.addToRoom(door2);
				Door door3 = new Door(RightRoomTwoRightDoorX, RightRoomTwoRightDoorY);
				door3.setSpawnX(RightRoomOneLeftDoorSpawnX);
				door3.setSpawnY(RightRoomOneLeftDoorSpawnY);
				door3.setRoom(9);
				rightRoomTwo.addToRoom(door3);
				Door door4 = new Door(RightRoomOneLeftDoorX, RightRoomOneLeftDoorY);
				door4.setSpawnX(RightRoomTwoRightDoorSpawnX);
				door4.setSpawnY(RightRoomTwoRightDoorSpawnY);
				door4.setRoom(8);
				rightRoomThree.addToRoom(door4);
				Door door5 = new Door(RightRoomOneRightDoorX, RightRoomOneRightDoorY);
				door5.setSpawnX(RoomPuzzleDoorSpawnX);
				door5.setSpawnY(RoomPuzzleDoorSpawnY);
				door5.setRoom(10);
				rightRoomThree.addToRoom(door5);
			}
			rooms.set(7, rightRoomOne);
			rooms.set(8, rightRoomTwo);
			rooms.set(9, rightRoomThree);
			break;
		}
	}

	private void createRoomRightOne(Room room){
		int[][] floor = {{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,88,88,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,88,88,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,-1,-1,-1,-1,88,88,88,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,19,20,20,20,20,20,20,128,129,129,132,20,20,21,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,144,145,145,148,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,160,161,161,164,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,177,178,178,179,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,16,-1,-1,-1,-1,-1,-1,-1},
				{-1, 3, 4,34,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,32, 4, 5,-1,-1,-1,-1,-1},
				{-1,19,20,50,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,48,20,21,-1,-1,-1,-1,-1},
				{-1,18,-1,-1,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,-1,-1,16,-1,-1,-1,-1,-1},
				{-1,35,36,97,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,98,36,37,-1,-1,-1,-1,-1},
				{-1,51,52,113,-1,-1,-1,-1,-1,-1,165,-1,-1,169,-1,-1,114,52,53,-1,-1,-1,-1,-1},
				{-1,-1,-1,35,36,36,36,36,36,36,165,-1,-1,169,36,36,37,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,51,52,52,52,52,52,52,52,52,52,52,52,52,53,-1,-1,-1,-1,-1,-1,-1}
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
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,36,36,36,36,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room.setFloorGrid(floor);
		room.setWallGrid(wall);
		room.setDecorGrid(decor);
		room.createLevel(128, 12, assets);
		//GiantRat rat1 = new GiantRat(240, 300);
		//room.addEntityList(rat1);
		//GiantRat rat2 = new GiantRat(240, 300);
		//room.addEntityList(rat2);
		GiantSpider spider1 = new GiantSpider(300, 400, assets.getSpider());
		spider1.setWalls(wall);
		room.addToRoom(spider1);
	}

	private void createRoomRightTwo(Room room){
		int[][] floor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{88,88,213,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,229,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,161,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,19,128,129,129,129,129,129,129,129,132,20,21,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{ 3, 4,34,144,145,145,145,145,145,145,145,148,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{19,20,50,165,-1,-1,-1,-1,-1,-1,-1,169,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{18,-1,-1,160,161,161,161,161,161,161,161,164,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{35,36,97,180,180,180,180,180,180,180,180,217,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{51,52,113,196,196,196,196,196,196,196,196,233,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,169,-1,32, 4, 4, 4, 4, 4, 4, 4, 5,-1,-1},
				{-1,-1,18,161,161,161,161,161,161,161,161,164,-1,48,20,20,20,20,20,20,20,21,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,32, 4, 5},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,48,20,21},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,98,36,37},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,114,52,53},
				{-1,-1,35,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,37,-1,-1},
				{-1,-1,51,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,53,-1,-1}
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
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room.setFloorGrid(floor);
		room.setWallGrid(wall);
		room.setDecorGrid(decor);
		room.createLevel(128, 12, assets);
		GiantSpider spider1 = new GiantSpider(300, 400, assets.getSpider());
		spider1.setWalls(wall);
		room.addToRoom(spider1);
		//GiantSpider spider2 = new GiantSpider(300, 400);
		//room.addEntityList(spider2);
		//GiantSpider spider3 = new GiantSpider(300, 400);
		//room.addEntityList(spider3);
	}

	private void createRoomRightThree(Room room){
		int[][] floor = {
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88},
				{88,88,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,88,88},
				{-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1},
				{-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1}
		};
		int[][] wall = {
				{-1,-1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5,-1,-1},
				{-1,-1,19,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,20,21,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,16,-1,-1},
				{ 3, 4,34,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,32, 4, 5},
				{19,20,50,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,48,20,21},
				{18,-1,-1,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,-1,-1,16},
				{35,36,97,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,98,36,37},
				{51,52,113,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,114,52,53},
				{-1,-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,18,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,32,33,33,33,33,33,33,33,33,33,33,33,33,34,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,48,49,49,49,49,49,49,49,49,49,49,49,49,50,-1,-1,16,-1,-1},
				{-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1},
				{-1,-1,35,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,36,37,-1,-1},
				{-1,-1,51,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,53,-1,-1}
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
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
		};
		room.setFloorGrid(floor);
		room.setWallGrid(wall);
		room.setDecorGrid(decor);
		room.createLevel(128, 12, assets);
		GiantRat rat1 = new GiantRat(384, 108,assets.getRat());
		room.addToRoom(rat1);
		GiantRat rat2 = new GiantRat(500, 108,assets.getRat());
		room.addToRoom(rat2);
		GiantRat rat3 = new GiantRat(736,300 ,assets.getRat());
		room.addToRoom(rat3);
	}

	private void createRoomPuzzle(){
		Room roomPuzzle = new Room(6 + 2*difficulty);
		int[][] floor = {
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,72,72,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1},
				{-1,-1,-1,-1,-1,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,-1,-1,-1}
		};
		int[][] wall = {
				{-1,-1,-1,-1,-1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5,-1,-1,-1},
				{-1,-1,-1,-1,-1,19,20,20,20,20,20,20,20,20,-1,-1,20,20,20,20,21,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1, 3, 4, 34,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,19,20,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,18,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,35,36,97,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,51,52,113,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,16,-1,-1,-1},
				{-1,-1,-1,-1,-1,35,36,36,36,36,36,36,36,36,36,36,36,36,36,36,37,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,51,52,52,52,52,52,52,52,52,52,52,52,52,52,52,53,-1,-1,-1}
		};
		int[][] decor = {
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
				{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,23,24,-1,-1,-1,-1,-1,-1,-1,-1},
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
		roomPuzzle.setFloorGrid(floor);
		roomPuzzle.setWallGrid(wall);
		roomPuzzle.setDecorGrid(decor);
		roomPuzzle.createLevel(128, 12, assets);
		PressurePlate plate = new PressurePlate(416,332,assets.getFromList(22),assets.getFromList(6));
		PressurePlate plate1 = new PressurePlate(544,332,assets.getFromList(22),assets.getFromList(6));
		PressurePlate plate2 = new PressurePlate(672,332,assets.getFromList(22),assets.getFromList(6));
		Light light = new Light(416, 44, plate, assets.getFromList(38), assets.getFromList(54));
		Light light1 = new Light(480, 44, plate1, assets.getFromList(38), assets.getFromList(54));
		Light light2 = new Light(544, 44, plate2, assets.getFromList(38), assets.getFromList(54));
		HeavyStone stone = new HeavyStone(320, 150);
		stone.setImage(assets.getStone0());
		HeavyStone stone1 = new HeavyStone(400, 180);
		stone1.setImage(assets.getStone0());
		HeavyStone stone2 = new HeavyStone(450, 400);
		stone2.setImage(assets.getStone0());
		roomPuzzle.addToRoom(stone);
		roomPuzzle.addToRoom(stone1);
		roomPuzzle.addToRoom(stone2);
		Door door = new Door(RoomPuzzleDoorTwoX, RoomPuzzleDoorTwoY, plate);
		door.setRoom(7 + 2*difficulty);
		door.setSpawnX(RoomBossDoorSpawnX);
		door.setSpawnY(RoomBossDoorSpawnY);
		door.addPlate(plate1);
		door.addPlate(plate2);
		roomPuzzle.addToRoom(plate);
		roomPuzzle.addToRoom(plate1);
		roomPuzzle.addToRoom(plate2);
		roomPuzzle.addToRoom(door);
		roomPuzzle.addToRoom(light);
		roomPuzzle.addToRoom(light1);
		roomPuzzle.addToRoom(light2);
		rooms.set(6 + (2*difficulty), roomPuzzle);
	}

	private void createRoomBoss(){
		Room roomBoss = new Room(7 + 2*difficulty);
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
		roomBoss.setFloorGrid(floor);
		roomBoss.setWallGrid(wall);
		roomBoss.setDecorGrid(decor);
		roomBoss.createLevel(128, 12, assets);
		Chest chest = new Chest(496, 102, assets.getChest());
		Ball ball = new Ball(0,0);
		chest.addItem(ball);
		roomBoss.addToRoom(chest);
		Door door = new Door(RoomBossDoorX, RoomBossDoorY);
		door.setRoom(6 + (2*difficulty));
		door.setSpawnX(RoomPuzzleDoorTwoSpawnX);
		door.setSpawnY(RoomPuzzleDoorTwoSpawnY);
		door.setEndDoor(true);
		roomBoss.addToRoom(door);
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
			door2.setRoom(5 + difficulty);
			rooms.get(2).addToRoom(door2);
			break;
		}
	}

	public void setDoorRoomSkeleton(int x_pos, int y_pos) {
		Door door1 = new Door(RoomSkeletonDoorX, RoomSkeletonDoorY);
		door1.setSpawnX(x_pos);
		door1.setSpawnY(y_pos);
		door1.setRoom(3 + difficulty);
		rooms.get(4 + difficulty).addToRoom(door1);
	}
	
	public void setDoorRoomPuzzle(int x_pos, int y_pos) {
		Door door1 = new Door(RoomPuzzleDoorX, RoomPuzzleDoorY);
		door1.setSpawnX(x_pos);
		door1.setSpawnY(y_pos);
		door1.setRoom(5 + (2*difficulty));
		rooms.get(6 + (2*difficulty)).addToRoom(door1);
	}
}
