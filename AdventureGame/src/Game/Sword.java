package Game;

public class Sword extends Item {

	public Sword(int x, int y) {
		super(x, y);
		super.inventoryImage = loadSpecificImage("src/Image/swrd0.png");
		super.image = loadSpecificImage("src/Image/swrd1.png");
	}
}
