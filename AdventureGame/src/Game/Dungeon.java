package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dungeon {

	int difficulty;
	private List<Room> rooms = new ArrayList<Room>();
	
	// Difficulty determines the number of rooms in the dungeon
	public Dungeon(int difficulty) {
		this.difficulty = difficulty;
		generateDungeon();
	}
	
	// Allows the accessing of a specific Room in the Dungeon
	public Room getDungeonIndex(int index) {
		return this.rooms.get(index);
	}

	public void generateDungeon() {
		createRoomTutorial();
		createRoomWell();
		createRoomOne();
		createLeftHallway();
		createRoomSkeleton();
		createRightHallway();
		createRoomPuzzle();
		createRoomBoss();
	}

	private void createRoomTutorial(){
		Room tutorial = new Room(0);
		PC player = new PC(500, 600);
		tutorial.addEntityList(player);
		rooms.add(tutorial);
	}

	private void createRoomWell(){
		Room well = new Room(1);
		PC player = new PC(500, 600);
		well.addEntityList(player);
		Door door = new Door(700, 500);
		door.setSpawnX(300);
		door.setSpawnY(400);
		door.setRoom(2);
		well.addSpriteList(door);
		rooms.add(well);
	}

	private void createRoomOne(){
		Room room1 = new Room(2);
		int[][] floor = {
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,6,0,1,1,4,1,0,0,1,1,0,1,7,0,6,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,7,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,6,0,1,0,0,1,1,4,1,0,0,2,3,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,8,9,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,6,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,10,11,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0},
				{0,1,1,7,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,6,1,0},
				{0,1,1,0,1,0,0,1,1,4,1,0,0,1,1,0,1,0,0,1,1,0,1,0}
			};
		int[][] wall = {
				{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2},
				{3,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{6,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,8},
				{9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11}
			};
		room1.createLevel(floor, wall, 128, 12);
		GiantRat rat1 = new GiantRat(240, 300);
		room1.addEntityList(rat1);
		Door door = new Door(700, 500);
		door.setSpawnX(300);
		door.setSpawnY(400);
		door.setRoom(1);
		room1.addSpriteList(door);
		Door door1 = new Door(700, 500);
		door1.setSpawnX(300);
		door1.setSpawnY(400);
		door1.setRoom(3);
		room1.addSpriteList(door1);
		Door door2 = new Door(700, 500);
		door2.setSpawnX(300);
		door2.setSpawnY(400);
		door2.setRoom(7 + difficulty);
		room1.addSpriteList(door2);
		rooms.add(room1);
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
				createRoomLeftOne(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
			}
			else if (n == 1) {
				createRoomLeftTwo(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
			}
			else {
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
			}
			rooms.add(leftRoomOne);
			break;
		case 1:// Medium difficulty
			int m = rand.nextInt(2);
			if (n == 0) {
				createRoomLeftOne(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				if (m == 0) {
					createRoomLeftTwo(leftRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(3);
					leftRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(5);
					leftRoomTwo.addSpriteList(door3);
				}
				else {
					createRoomLeftThree(leftRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(3);
					leftRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(5);
					leftRoomTwo.addSpriteList(door3);
				}
			}
			else if (n == 1){
				createRoomLeftTwo(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				if (m == 0) {
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(3);
					leftRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(5);
					leftRoomTwo.addSpriteList(door3);
				}
				else {
					createRoomLeftThree(leftRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(3);
					leftRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(5);
					leftRoomTwo.addSpriteList(door3);
				}
			}
			else{
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				if (m == 0) {
					createRoomLeftOne(leftRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(3);
					leftRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(5);
					leftRoomTwo.addSpriteList(door3);
				}
				else {
					createRoomLeftTwo(leftRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(3);
					leftRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(5);
					leftRoomTwo.addSpriteList(door3);
				}
			}
			rooms.add(leftRoomOne);
			rooms.add(leftRoomTwo);
			break;
		case 2:// Hard difficulty
			n = rand.nextInt(6);
			if (n == 0) {
				createRoomLeftOne(leftRoomOne);
				createRoomLeftTwo(leftRoomTwo);
				createRoomLeftThree(leftRoomThree);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(3);
				leftRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(5);
				leftRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(4);
				leftRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(6);
				leftRoomTwo.addSpriteList(door5);
			}
			else if (n == 1) {
				createRoomLeftOne(leftRoomOne);
				createRoomLeftTwo(leftRoomThree);
				createRoomLeftThree(leftRoomTwo);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(3);
				leftRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(5);
				leftRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(4);
				leftRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(6);
				leftRoomTwo.addSpriteList(door5);
			}
			else if (n == 2) {
				createRoomLeftOne(leftRoomTwo);
				createRoomLeftTwo(leftRoomOne);
				createRoomLeftThree(leftRoomThree);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(3);
				leftRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(5);
				leftRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(4);
				leftRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(6);
				leftRoomTwo.addSpriteList(door5);
			}
			else if (n == 3) {
				createRoomLeftOne(leftRoomTwo);
				createRoomLeftTwo(leftRoomThree);
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(3);
				leftRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(5);
				leftRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(4);
				leftRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(6);
				leftRoomTwo.addSpriteList(door5);
			}
			else if (n == 4) {
				createRoomLeftOne(leftRoomThree);
				createRoomLeftTwo(leftRoomOne);
				createRoomLeftThree(leftRoomTwo);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(3);
				leftRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(5);
				leftRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(4);
				leftRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(6);
				leftRoomTwo.addSpriteList(door5);
			}
			else {
				createRoomLeftOne(leftRoomThree);
				createRoomLeftTwo(leftRoomTwo);
				createRoomLeftThree(leftRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				leftRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(4);
				leftRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(3);
				leftRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(5);
				leftRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(4);
				leftRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(6);
				leftRoomTwo.addSpriteList(door5);
			}
			rooms.add(leftRoomOne);
			rooms.add(leftRoomTwo);
			rooms.add(leftRoomThree);
			break;
		}
	}

	private void createRoomLeftOne(Room room){
		GiantSpider spider1 = new GiantSpider(300, 400);
		room.addEntityList(spider1);
	}

	private void createRoomLeftTwo(Room room){
		GiantRat rat1 = new GiantRat(240, 300);
		room.addEntityList(rat1);
		GiantSpider spider1 = new GiantSpider(300, 400);
		room.addEntityList(spider1);
	}

	private void createRoomLeftThree(Room room){
		GiantRat rat1 = new GiantRat(240, 300);
		room.addEntityList(rat1);
		GiantRat rat2 = new GiantRat(240, 300);
		room.addEntityList(rat2);
		GiantRat rat3 = new GiantRat(240, 300);
		room.addEntityList(rat3);
	}

	private void createRoomSkeleton(){
		Room roomSkeleton = new Room(4 + difficulty);
		Skeleton skeleton = new Skeleton(300, 300);
		roomSkeleton.addSpriteList(skeleton);
		Door door = new Door(700, 500);
		door.setSpawnX(300);
		door.setSpawnY(400);
		door.setRoom(2);
		roomSkeleton.addSpriteList(door);
		Door door1 = new Door(700, 500);
		door1.setSpawnX(300);
		door1.setSpawnY(400);
		door1.setRoom(4);
		roomSkeleton.addSpriteList(door1);
		rooms.add(roomSkeleton);
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
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(6);
				rightRoomOne.addSpriteList(door1);
			}
			else if (n == 1) {
				createRoomRightTwo(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(6);
				rightRoomOne.addSpriteList(door1);
			}
			else {
				createRoomLeftThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(6);
				rightRoomOne.addSpriteList(door1);
			}
			rooms.add(rightRoomOne);
			break;
		case 1:// Medium difficulty
			int m = rand.nextInt(2);
			if (n == 0) {
				createRoomRightOne(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(7);
				rightRoomOne.addSpriteList(door1);
				if (m == 0) {
					createRoomRightTwo(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addSpriteList(door3);
				}
				else {
					createRoomRightThree(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addSpriteList(door3);
				}
			}
			else if (n == 1){
				createRoomLeftTwo(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(7);
				rightRoomOne.addSpriteList(door1);
				if (m == 0) {
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addSpriteList(door3);
				}
				else {
					createRoomRightThree(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addSpriteList(door3);
				}
			}
			else{
				createRoomLeftThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(7);
				rightRoomOne.addSpriteList(door1);
				if (m == 0) {
					createRoomRightOne(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addSpriteList(door3);
				}
				else {
					createRoomRightTwo(rightRoomTwo);
					Door door2 = new Door(700, 500);
					door2.setSpawnX(300);
					door2.setSpawnY(400);
					door2.setRoom(6);
					rightRoomTwo.addSpriteList(door2);
					Door door3 = new Door(700, 500);
					door3.setSpawnX(300);
					door3.setSpawnY(400);
					door3.setRoom(8);
					rightRoomTwo.addSpriteList(door3);
				}
			}
			rooms.add(rightRoomOne);
			rooms.add(rightRoomTwo);
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
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addSpriteList(door5);
			}
			else if (n == 1) {
				createRoomRightOne(rightRoomOne);
				createRoomRightTwo(rightRoomThree);
				createRoomRightThree(rightRoomTwo);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addSpriteList(door5);
			}
			else if (n == 2) {
				createRoomRightOne(rightRoomTwo);
				createRoomRightTwo(rightRoomOne);
				createRoomRightThree(rightRoomThree);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addSpriteList(door5);
			}
			else if (n == 3) {
				createRoomRightOne(rightRoomTwo);
				createRoomRightTwo(rightRoomThree);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addSpriteList(door5);
			}
			else if (n == 4) {
				createRoomRightOne(rightRoomThree);
				createRoomRightTwo(rightRoomOne);
				createRoomRightThree(rightRoomTwo);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addSpriteList(door5);
			}
			else {
				createRoomRightOne(rightRoomThree);
				createRoomRightTwo(rightRoomTwo);
				createRoomRightThree(rightRoomOne);
				Door door = new Door(700, 500);
				door.setSpawnX(300);
				door.setSpawnY(400);
				door.setRoom(2);
				rightRoomOne.addSpriteList(door);
				Door door1 = new Door(700, 500);
				door1.setSpawnX(300);
				door1.setSpawnY(400);
				door1.setRoom(8);
				rightRoomOne.addSpriteList(door1);
				Door door2 = new Door(700, 500);
				door2.setSpawnX(300);
				door2.setSpawnY(400);
				door2.setRoom(7);
				rightRoomTwo.addSpriteList(door2);
				Door door3 = new Door(700, 500);
				door3.setSpawnX(300);
				door3.setSpawnY(400);
				door3.setRoom(9);
				rightRoomTwo.addSpriteList(door3);
				Door door4 = new Door(700, 500);
				door4.setSpawnX(300);
				door4.setSpawnY(400);
				door4.setRoom(8);
				rightRoomTwo.addSpriteList(door4);
				Door door5 = new Door(700, 500);
				door5.setSpawnX(300);
				door5.setSpawnY(400);
				door5.setRoom(10);
				rightRoomTwo.addSpriteList(door5);
			}
			rooms.add(rightRoomOne);
			rooms.add(rightRoomTwo);
			rooms.add(rightRoomThree);
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
		roomPuzzle.addSpriteList(door);
		Door door1 = new Door(700, 500);
		door1.setSpawnX(300);
		door1.setSpawnY(400);
		door1.setRoom(3);
		roomPuzzle.addSpriteList(door1);
		rooms.add(roomPuzzle);
	}

	private void createRoomBoss(){
		Room roomBoss = new Room(7 + 2*difficulty);
		rooms.add(roomBoss);
	}

	public List<Room> getRoomList() {
		return this.rooms;
	}
}
