package Game;

public class PressurePlate extends Entity {
	
	private boolean enabled = false;
	private int padNumber;
	
	PressurePlate(int x, int y){
		super(x,y);
		//add animation/frames
		
	}
	
	public void update() {
		if (enabled) {
			//setanimation/frame to pressed
		} else {
			//setanimation/frame to not pressed
		}
	}
	public void CollisionProcess(Collision b) {
		if (enabled == false) {
			Toggle();
		}
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void Toggle() {
		this.enabled = !enabled;
	}

	public int getPadNumber() {
		return padNumber;
	}

	public void setPadNumber(int padNumber) {
		this.padNumber = padNumber;
	}
}
