package Game;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Light extends Entity {
	
	PressurePlate plate;
	
	public Light(int x, int y, PressurePlate plate, BufferedImage active, BufferedImage deactive) {
		super(x,y);
		images = new ArrayList<BufferedImage>();
		images.add(active);
		images.add(deactive);
		setImage(images.get(1));
		this.plate = plate;
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height/2);
	}

	public void update() {
		if (plate.isEnabled())
			this.setImage(images.get(0));
		else
			this.setImage(images.get(1));
	}
}
