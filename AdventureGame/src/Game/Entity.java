package Game;

import java.awt.Image;
import java.util.List;
import java.util.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Entity extends Sprite{
	
	
	protected int direction;
	protected boolean moving;
	protected boolean dirchange;
	protected int dx;
	protected int dy;
	protected int dx_temp;
	protected int dy_temp;
	protected boolean collision;
	protected String down0;
	protected String down1;
	protected String down2;
	protected String left0;
	protected String left1;
	protected String left2;
	protected String right0;
	protected String right1;
	protected String right2;
	protected String up0;
	protected String up1;
	protected String up2;
	
	public Entity(int x, int y) {
	super(x,y);
	
	}
	
	
	public int getdy() {
		return dy;
	}
	public int getdx() {
		return dx;
	}
	
	public void move(int frame_count) {
		if (dirchange) {
			frame_count = 0;
			dirchange = false;
		}
		
		if (moving == false) {
			switch (direction) {
			case 0:
				loadImage(down1);
				break;
			case 1:
				loadImage(left1);
				break;
			case 2:
				loadImage(right1);
				break;
			case 3:
				loadImage(up1);
				break;
				}
			} else {
				switch(direction) {
				case 0:
					switch(frame_count % 21) {
					case 21:
						loadImage(down0);
					break;
					case 14:
						loadImage(down1);
						break;
					case 7:
						loadImage(down2);
						break;
					case 0:
						loadImage(down1);
						break;
					}
					break;
				case 1:
					switch(frame_count % 21) {
					case 21:
						loadImage(left0);
					break;
					case 14:
						loadImage(left1);
						break;
					case 7:
						loadImage(left2);
						break;
					case 0:
						loadImage(left1);
						break;
					}
					break;
				case 2:
					switch(frame_count % 21) {
					case 21:
						loadImage(right0);
					break;
					case 14:
						loadImage(right1);
						break;
					case 7:
						loadImage(right2);
						break;
					case 0:
						loadImage(right1);
						break;
					}
					break;
				case 3:
					switch(frame_count % 21) {
					case 21:
						loadImage(up0);
					break;
					case 14:
						loadImage(up1);
						break;
					case 7:
						loadImage(up2);
						break;
					case 0:
						loadImage(up1);
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
	
public void CollisionProcess(int top,int bottom,int left, int right) {
		
		switch (this.check_collisiondir_Hoz(left, right)) {
		case 1:
			if(dx < 0) {
				dx = 0;
			}
			break;
		case 2:
			if(dx > 0) {
				dx = 0;
			}
			break;
		}
		switch(this.check_collisiondir_Vert( top, bottom)) {
		case 1:
			if(dy < 0) {
				dx_temp = dy;
				dy = 0;
			}
			break;
		case 2:
			if(dy > 0) {
				dx_temp = dy;
				dy = 0;
			}
			break;
		}

	}
	protected int check_collisiondir_Hoz(int left2,int right2 ) {

		if (this.x_pos == right2 - 4) {
			return 1;
		} else if (this.right == left2 + 4) {
			return 2;
		} else {
			return 0;
		}
	}
	protected int check_collisiondir_Vert(int top2,int bottom2 ) {

		if (this.y_pos == bottom2 -4) {
			return 1;
		} else if (this.bottom == top2 + 4) {
			return 2;
		} else {
			return 0;
		}
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
