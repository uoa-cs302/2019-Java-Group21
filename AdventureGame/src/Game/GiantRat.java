package Game;

public class GiantRat extends Entity {
	
private boolean charging = false;
	private int count = 0;
	private int dy_lock;
	private int dx_lock;

	
	public GiantRat(int x,int y){
		super(x,y);
			
		initRat();
	}
	private void initRat() {
		LoadSprites("src/Image/rat_0.png");
		loadImage(0,0);
		damage = 1;
		
	}


	
	public void AiUpdate(Entity target) {
		if (target == null) {
			dx = 0;
			dy = 0;
			
		}else {
		int xdiff;
		int ydiff;
		
		xdiff = target.getx_pos() - this.x_pos;
		ydiff = target.gety_pos() - this.y_pos;
		int distance = (int) Math.hypot((double) xdiff/32,(double) ydiff/32);
	
		
		moving = true;
		if(ydiff>0 ) {
			direction = 0;
			dirchange = true;
			dy = 1;
		}else if (ydiff<0 ) {
			direction = 3;
			dirchange = true;
			dy = -1;
		} 
		
		if (xdiff>0) {
			direction = 2;
			dirchange = true;
			dx = 1;
		}else if (xdiff<0) {
			direction = 1;
			dirchange = true;
			dx = -1;
		}
		if (distance <= 8 && charging == false) {
			charging = true;
			count = 0;
			dx = dx*4;
			dy = dy*4;
			dx_lock = dx;
			dy_lock = dy;
		
		} else if(charging && count <100) {
			count++;
			dx = dx_lock;
			dy = dy_lock;
		}else if (charging && count <600 && count>=100) {
			count++;
		}else if (charging && count == 600) {
		
			charging = false;
			count = 0;
		}
		System.out.println(dx);
		System.out.println(dy);
		
			}	
	}
		
	
	public void move() {
		
		x_pos += dx;
		right = x_pos + width;
		y_pos += dy;
		bottom = y_pos + height;
		
		dx_temp = dx;
		dy_temp = dy;
		
	}

	}

