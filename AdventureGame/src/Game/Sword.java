package Game;

public class Sword extends Item {

	public Sword(int x, int y) {
		super(x, y);
		getImageDim();
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
	}
}
