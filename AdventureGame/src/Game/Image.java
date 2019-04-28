package Game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Image {

	// TEMPORARY UNTIL WE PUT EVERYTHING INTO ONE SPRITESHEET
	private List<BufferedImage> player;
	private List<BufferedImage> rat;
	private BufferedImage sword0;
	private BufferedImage sword1;
	private List<BufferedImage> spider;
	private List<BufferedImage> health;
	private List<BufferedImage> chest;
	private BufferedImage skeleton;
	private List<BufferedImage> inventory;
	private List<BufferedImage> hair;
	private List<BufferedImage> head;
	private List<BufferedImage> body;
	private List<BufferedImage> arms;
	private List<BufferedImage> legs;
	private List<BufferedImage> feet;

	public List<BufferedImage> getPlayer() {
		return player;
	}

	public void setPlayer(List<BufferedImage> player) {
		this.player = player;
	}
	public void setRat(List<BufferedImage> rat) {
		this.rat = rat;
	}

	public List<BufferedImage> getRat() {
		return rat;
	}

	public List<BufferedImage> getSpider() {
		return spider;
	}
	
	public BufferedImage getSword0() {
		return sword0;
	}

	public BufferedImage getSword1() {
		return sword1;
	}
	
	public BufferedImage getSkeleton() {
		return skeleton;
	}
	
	public List<BufferedImage> getHealth(){
		return health;
	}

	public List<BufferedImage> getChest(){
		return chest;
	}
	
	public List<BufferedImage> getInventory(){
		return inventory;
	}
	
	public void loadInventory() {
		File f;
		for (int i = 0; i < 8; i++) {
			f = new File("src/Image/inv" + i + ".png");
			try {
				inventory.add(ImageIO.read(f));
			} catch (IOException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		inventory.add(sword0);
		inventory.add(sword1);
		inventory.add(loadSpecificImage("src/Image/dog0.png"));
		inventory.add(loadSpecificImage("src/Image/dog1.png"));
	}

	public List<BufferedImage> getHair() {
		return hair;
	}

	public List<BufferedImage> getHead() {
		return head;
	}

	public List<BufferedImage> getBody() {
		return body;
	}
	
	public List<BufferedImage> getArms() {
		return arms;
	}

	public List<BufferedImage> getLegs() {
		return legs;
	}


	public List<BufferedImage> getFeet() {
		return feet;
	}

	
	// FINAL VARIABLES
	List<BufferedImage> assetList;


	private int TILE_SIZE = 32;
	private BufferedImage fullSheet;
	private int sheetW;
	private int sheetH;

	public Image() {
		assetList = new ArrayList<BufferedImage>();
		rat = new ArrayList<BufferedImage>();
		spider = new ArrayList<BufferedImage>();
		health = new ArrayList<BufferedImage>();
		chest = new ArrayList<BufferedImage>();
		inventory = new ArrayList<BufferedImage>();
		hair = new ArrayList<BufferedImage>();
		head = new ArrayList<BufferedImage>();
		body = new ArrayList<BufferedImage>();
		arms = new ArrayList<BufferedImage>();
		legs = new ArrayList<BufferedImage>();
		feet = new ArrayList<BufferedImage>();
		
		//adds rat sprites
		rat.add(loadSpecificImage("src/Image/rat_0.png"));
		rat.add(loadSpecificImage("src/Image/rat_1.png"));
		rat.add(loadSpecificImage("src/Image/rat_2.png"));
		rat.add(loadSpecificImage("src/Image/rat_3.png"));
		spider.addAll(getSprites("src/Image/spidersheet.png",1,12,32));
		spider.add(loadSpecificImage("src/Image/projectile0.png"));
		sword0 = loadSpecificImage("src/Image/swrd0.png");
		sword1 = loadSpecificImage("src/Image/swrd1.png");
		System.out.println("trying to load character");
		LoadSprites("src/Image/dungeon0.png");
		System.out.println("read all sprites success!");
		health.add(loadSpecificImage("src/Image/heart0.png"));
		health.add(loadSpecificImage("src/Image/heart1.png"));
		health.add(loadSpecificImage("src/Image/heart2.png"));
		skeleton = loadSpecificImage("src/Image/skeleton0.png");
		chest.addAll(getSprites("src/Image/chest0.png",1,2,32));
		hair.addAll(getSprites("src/Image/hair0.png",1,240,40));
		head.addAll(getSprites("src/Image/head0.png",1,15,40));
		body.addAll(getSprites("src/Image/body0.png",1,18,40));
		arms.addAll(getSprites("src/Image/arms0.png",1,30,40));
		legs.addAll(getSprites("src/Image/legs0.png",1,54,40));
		feet.addAll(getSprites("src/Image/feet0.png",1,54,40));
		loadInventory();
	}
	
	public void loadCharacter() {
		setPlayer(getSprites("src/Image/player.png",4,3,40));
		player.addAll(getSprites("src/Image/SLASHLEFT.png",1,5,32));
		player.addAll(getSprites("src/Image/SLASHRIGHT.png",1,5,32));
		player.addAll(getSprites("src/Image/SLASHUP.png",5,1,32));
		player.addAll(getSprites("src/Image/SLASHDOWN.png",5,1,32));
	}

	protected BufferedImage loadSpecificImage(String address) {
		System.out.println(address);
		File f = new File(address);
		try {
			return ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected List<BufferedImage> getSprites(String sheet,int h,int w, int tileSize) {
		BufferedImage image = loadSpecificImage(sheet);
		return loadSpecificSprites(h,w, image, tileSize);
	}

	public List<BufferedImage> loadSpecificSprites(int sheetH, int sheetW, BufferedImage image, int tileSize) {
		List<BufferedImage> sprites = new ArrayList<BufferedImage>();
		for (int i = 0; i < sheetH; i++) {
			for (int j = 0; j < sheetW; j++) {
				sprites.add(extractSpecificSprites(i, j, image, tileSize));
			}
		}
		return sprites;
	}

	protected BufferedImage extractSpecificSprites(int x, int y, BufferedImage image, int tileSize) {
		BufferedImage targ_sprite = image.getSubimage(y * tileSize, x * tileSize, tileSize, tileSize);
		return targ_sprite;
	}

	protected void LoadSprites(String sheet) {
		fullSheet = loadSheet(sheet);
		System.out.println("1!");
		sheetW = this.fullSheet.getWidth() / TILE_SIZE;
		sheetH = this.fullSheet.getHeight() / TILE_SIZE;
		System.out.println("2!");
		loadSprites();
	}

	private BufferedImage loadSheet(String sheet) {
		System.out.println("3!");
		BufferedImage sheetIm = null;
		System.out.println("4!");
		File f = new File(sheet);
		try {
			// sheetIm = ImageIO.read(getClass().getResourceAsStream(sheet));
			sheetIm = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheetIm;
	}

	public void loadSprites() {
		for (int i = 0; i < sheetH; i++) {
			for (int j = 0; j < sheetW; j++) {
				addAssetList(extractSprites(i, j));
			}
		}
	}

	protected BufferedImage extractSprites(int x, int y) {
		BufferedImage targ_sprite = fullSheet.getSubimage(y * TILE_SIZE, x * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		return targ_sprite;
	}

	public void addAssetList(BufferedImage image) {
		assetList.add(image);
	}
	
	public List<BufferedImage> getList(){
		return assetList;
	}

	public BufferedImage getFromList(int index) {
		return this.assetList.get(index);
	}

	public List<BufferedImage> getListFromList(int start, int end){
		if (start > 0 && end < assetList.size())
			return this.assetList.subList(start, end);
		else
			return null;
	}
}
