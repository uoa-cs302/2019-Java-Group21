package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ball extends Item {

	public Ball(int x, int y) {
		super(x, y);
		getImageDim();
		this.images = new ArrayList<BufferedImage>();
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
	}
}
