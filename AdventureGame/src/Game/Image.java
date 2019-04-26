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
	private BufferedImage skeleton;

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
		//adds rat sprites
		rat.add(loadSpecificImage("src/Image/rat_0.png"));
		rat.add(loadSpecificImage("src/Image/rat_1.png"));
		rat.add(loadSpecificImage("src/Image/rat_2.png"));
		rat.add(loadSpecificImage("src/Image/rat_3.png"));
		spider.add(loadSpecificImage("src/Image/spider0.png"));
		spider.add(loadSpecificImage("src/Image/projectile0.png"));
		sword0 = loadSpecificImage("src/Image/swrd0.png");
		sword1 = loadSpecificImage("src/Image/swrd1.png");
		setPlayer(getSprites("src/Image/ExampleCharacter.png",4,3));
		player.addAll(getSprites("src/Image/SLASHLEFT.png",1,5));
		player.addAll(getSprites("src/Image/SLASHRIGHT.png",1,5));
		player.addAll(getSprites("src/Image/SLASHUP.png",5,1));
		player.addAll(getSprites("src/Image/SLASHDOWN.png",5,1));
		System.out.println("trying to load character");
		LoadSprites("src/Image/dungeon0.png");
		System.out.println("read all sprites success!");
		health.add(loadSpecificImage("src/Image/heart0.png"));
		health.add(loadSpecificImage("src/Image/heart1.png"));
		health.add(loadSpecificImage("src/Image/heart2.png"));
		skeleton = loadSpecificImage("src/Image/skeleton0.png");
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

	protected List<BufferedImage> getSprites(String sheet,int h,int w) {
		BufferedImage image = loadSpecificImage(sheet);
		return loadSpecificSprites(h,w, image);
	}

	public List<BufferedImage> loadSpecificSprites(int sheetH, int sheetW, BufferedImage image) {
		List<BufferedImage> sprites = new ArrayList<BufferedImage>();
		for (int i = 0; i < sheetH; i++) {
			for (int j = 0; j < sheetW; j++) {
				sprites.add(extractSpecificSprites(i, j, image));
			}
		}
		return sprites;
	}

	protected BufferedImage extractSpecificSprites(int x, int y, BufferedImage image) {
		BufferedImage targ_sprite = image.getSubimage(y * TILE_SIZE, x * TILE_SIZE, TILE_SIZE, TILE_SIZE);
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

		System.out.println("file equals success!");
		try {
			// sheetIm = ImageIO.read(getClass().getResourceAsStream(sheet));
			sheetIm = ImageIO.read(f);
			System.out.println("5!");
		} catch (IOException e) {
			System.out.println("6!");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheetIm;
	}

	public void loadSprites() {
		for (int i = 0; i < sheetH; i++) {
			for (int j = 0; j < sheetW; j++) {
				System.out.println(i + "   " +  j);
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
