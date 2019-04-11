package Game;

public class PressurePlate extends Sprite {
	
	private boolean enabled = false;
	private int padNumber;
	
	PressurePlate(int x, int y){
		super(x,y);
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void Enable() {
		this.enabled = true;
	}

	public int getPadNumber() {
		return padNumber;
	}

	public void setPadNumber(int padNumber) {
		this.padNumber = padNumber;
	}
}
