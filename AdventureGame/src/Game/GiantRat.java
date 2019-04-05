package Game;

public class GiantRat extends Entity {
	

	
	public GiantRat(int x,int y){
		super(x,y);
			
		initRat();
	}
	private void initRat() {
		loadImage("src/Image/rat_3.png");
		getImageDim();
		
		down0 = "src/Image/rat_3.png";
		down1 = "src/Image/rat_3.png";
		down2 = "src/Image/rat_3.png";
		left0 = "src/Image/rat_1.png";
		left1 = "src/Image/rat_1.png";
		left2 = "src/Image/rat_1.png";
		right0 = "src/Image/rat_0.png";
		right1 = "src/Image/rat_0.png";
		right2 = "src/Image/rat_0.png";
		up0 = "src/Image/rat_2.png";
		up1 = "src/Image/rat_2.png";
		up2 = "src/Image/rat_2.png";
		
	}
	public void AiUpdate(Entity target) {
		int xdiff;
		int ydiff;
		
		xdiff = target.getx_pos() - this.x_pos;
		ydiff = target.gety_pos() - this.y_pos;
		moving = true;

			
		if(ydiff>0) {
			direction = 0;
			dirchange = true;
			dy = 1;
		}else {
			direction = 3;
			dirchange = true;
			dy = -1;
		}
		if (xdiff>0) {
			direction = 2;
			dirchange = true;
			dx = 1;
		}else {
			direction = 1;
			dirchange = true;
			dx = -1;
		}
	}

}
