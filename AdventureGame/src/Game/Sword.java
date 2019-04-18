package Game;

public class Sword extends Item {

	public Sword(int x, int y) {
		super(x, y);
		super.inventoryImage = loadSpecificImage("src/Image/swrd0.png");
		this.image = loadSpecificImage("src/Image/swrd1.png");
		getImageDim();
		Bounds = new Collision(this.x_pos,this.y_pos,this.width,this.height);
	}
}
