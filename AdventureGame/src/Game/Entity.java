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
	private List<String> sprite;
	
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
				loadImage("src/Image/tile001.png");
				break;
			case 1:
				loadImage("src/Image/tile004.png");
				break;
			case 2:
				loadImage("src/Image/tile007.png");
				break;
			case 3:
				loadImage("src/Image/tile010.png");
				break;
				}
			} else {
				switch(direction) {
				case 0:
					switch(frame_count % 21) {
					case 21:
						loadImage("src/Image/tile000.png");
					break;
					case 14:
						loadImage("src/Image/tile001.png");
						break;
					case 7:
						loadImage("src/Image/tile002.png");
						break;
					case 0:
						loadImage("src/Image/tile001.png");
						break;
					}
					break;
				case 1:
					switch(frame_count % 21) {
					case 21:
						loadImage("src/Image/tile003.png");
					break;
					case 14:
						loadImage("src/Image/tile004.png");
						break;
					case 7:
						loadImage("src/Image/tile005.png");
						break;
					case 0:
						loadImage("src/Image/tile004.png");
						break;
					}
					break;
				case 2:
					switch(frame_count % 21) {
					case 21:
						loadImage("src/Image/tile006.png");
					break;
					case 14:
						loadImage("src/Image/tile007.png");
						break;
					case 7:
						loadImage("src/Image/tile008.png");
						break;
					case 0:
						loadImage("src/Image/tile007.png");
						break;
					}
					break;
				case 3:
					switch(frame_count % 21) {
					case 21:
						loadImage("src/Image/tile009.png");
					break;
					case 14:
						loadImage("src/Image/tile010.png");
						break;
					case 7:
						loadImage("src/Image/tile011.png");
						break;
					case 0:
						loadImage("src/Image/tile010.png");
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
	

}
