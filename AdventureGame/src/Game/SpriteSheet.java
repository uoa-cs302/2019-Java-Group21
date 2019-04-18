package Game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	
	List <BufferedImage> TheList;
	private int TILE_SIZE = 32;
	private BufferedImage fullSheet;
	private int sheetW;
	private int sheetH;

	
	public SpriteSheet(string s) {
	//Not sure how to implement in a global sense
		
	}
	
	protected void LoadSprites(String sheet) {
		System.out.println("Load Sprites!");
		fullSheet = loadSheet(sheet);
		System.out.println("Sheet loaded");
		sheetW = this.fullSheet.getWidth() / TILE_SIZE;
		sheetH = this.fullSheet.getHeight() / TILE_SIZE;
		System.out.println("WH got");
		loadSprites();
		System.out.println("LoadSprites done");
	}

	private BufferedImage loadSheet(String sheet) {
		BufferedImage sheetIm = null;
		System.out.println("Sprite.loadSheet");
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

				 TheList.add( ExtractSprites(i, j));
			}
		}

	}
	
	protected BufferedImage ExtractSprites(int x, int y) {
		BufferedImage targ_sprite = fullSheet.getSubimage(y * TILE_SIZE, x * TILE_SIZE, TILE_SIZE, TILE_SIZE);
		return targ_sprite;
	}
	
	public List<BufferedImage> getList(){
		return TheList;
	}
}
