package Game;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Collision_Obj extends Sprite {
	
	
	public Collision_Obj(int x,int y,String address) {
		super(x,y);
		
		initObj(address);
	}
	protected void initObj(String address) {
		loadImage(address);
		getImageDim();
	}

}
