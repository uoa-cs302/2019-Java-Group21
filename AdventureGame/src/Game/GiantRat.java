package Game;

public class GiantRat extends Entity {
	

	
	public GiantRat(int x,int y){
		super(x,y);
			
		initRat();
	}
	private void initRat() {
		LoadSprites("src/Image/rat_0.png");
		loadImage(0,0);
		damage = 1;
	}
	public void move(int frame_count) {
		if (dirchange) {
			frame_count = 0;
			dirchange = false;
		}
		
		if (moving == false) {
			switch (direction) {
			case 0:
				loadImage(0,0);
				break;
			case 1:
				loadImage(0,0);
				break;
			case 2:
				loadImage(0,0);
				break;
			case 3:
				loadImage(0,0);
				break;
				}
			} else {
				switch(direction) {
				case 0:
					switch(frame_count % 28) {
					case 21:
						loadImage(0,0);
					break;
					case 14:
						loadImage(0,0);
						break;
					case 7:
						loadImage(0,0);
						break;
					case 6:
						loadImage(0,0);
						break;
					}
					break;
				case 1:
					switch(frame_count % 28) {
					case 21:
						loadImage(0,0);
					break;
					case 14:
						loadImage(0,0);
						break;
					case 7:
						loadImage(0,0);
						break;
					case 6:
						loadImage(0,0);
						break;
					}
					break;
				case 2:
					switch(frame_count % 28) {
					case 21:
						loadImage(0,0);
					break;
					case 14:
						loadImage(0,0);
						break;
					case 7:
						loadImage(0,0);
						break;
					case 6:
						loadImage(0,0);
						break;
					}
					break;
				case 3:
					switch(frame_count % 28) {
					case 21:
						loadImage(0,0);
					break;
					case 14:
						loadImage(0,0);
						break;
					case 7:
						loadImage(0,0);
						break;
					case 6:
						loadImage(0,0);
						break;
					}
					break;
				}
				
			}
		//else moving
		//collision handling

		x_pos += dx;
		right = x_pos + width;
		y_pos += dy;
		bottom = y_pos + height;
		
		dx = dx_temp;
		dy  =dy_temp;
		
	}

}
