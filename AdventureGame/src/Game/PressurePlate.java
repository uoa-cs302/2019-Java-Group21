package Game;

public class PressurePlate extends Entity {
	
	private boolean enabled = false;
	private int padNumber;
	
	PressurePlate(int x, int y){
		super(x,y);
		super.setCollidable(true);
		Bounds = new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height);
		//add animation/frames
		
	}
	
	public void update() {
		if (enabled) {
			//setanimation/frame to pressed
		} else {
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
