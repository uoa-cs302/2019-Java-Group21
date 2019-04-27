package Game;

import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

public class PressurePlate extends Entity {
	
	private boolean enabled = false;
	private int padNumber;
	
	PressurePlate(int x, int y, BufferedImage active, BufferedImage deactive){
		super(x,y);
		super.setCollidable(true);
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width-16,this.height-16);
		Bounds.setxOff(8);
		Bounds.setyOff(8);
		images = new ArrayList<BufferedImage>();
		images.add(deactive);
		images.add(active);
		setImage(images.get(0));
		//add animation/frames
		
	}
	
	public void update() {
		if (enabled) {
			this.setImage(this.images.get(1));
			//setanimation/frame to pressed
		} else {
			this.setImage(this.images.get(0));
			//setanimation/frame to not pressed
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean b) {
		this.enabled = b;
	}

	public int getPadNumber() {
		return padNumber;
	}

	public void setPadNumber(int padNumber) {
		this.padNumber = padNumber;
	}
}
