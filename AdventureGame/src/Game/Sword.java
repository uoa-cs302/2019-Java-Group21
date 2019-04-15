package Game;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sword extends Item {

	public Sword(int x, int y) {
		super(x, y);
		super.loadSpecificImage("src/Image/swrd0.png");
	}

	
}
