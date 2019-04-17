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
		
		//initital base intialisation
		Bounds = new Collision(this.x_pos,this.y_pos,this.width,this.height/2);
		Bounds.setyOff(32);
		Hitbounds = new Collision(this.x_pos,this.y_pos +(this.height/2),this.width,this.height );
		
	}
	public void update(Entity target) {
		
		AiUpdate(target);
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
	
		
		if(ydiff>0 ) {
			direction = Direction.DOWN;
			dy = 1;
		}else if (ydiff<0 ) {
			direction = Direction.UP;
			dy = -1;
		} else {dy =0;}
		
		if (xdiff>0) {
			direction = Direction.RIGHT;
			dx = 1;
		}else if (xdiff<0) {
			direction = Direction.LEFT;
			dx = -1;
		}else {dx=0;}
		if (distance <= 5 && charging == false) {
			charging = true;
			count = 0;
			dx = dx*3;
			dy = dy*3;
			dx_lock = dx;
			dy_lock = dy;
		
		} else if(charging && count <80) {
			count++;
			dx = dx_lock;
			dy = dy_lock;
		}else if (charging && count <600 && count>=80) {
			count++;
		}else if (charging && count == 600) {
		
			charging = false;
			count = 0;
		}
		
			}	
	}
		

	}

