package Game;

public class Wall extends Entity{
	
	public Wall(int x, int y) {
		super(x,y);
		super.setCollidable(true);
		LoadSprites("src/Image/dungeon0.png");
		loadImage(0,0);
		setBounds( new Collision(this.x_pos,this.y_pos,this.width,this.height));
	}
	
	public void setTexture(int texture) {
		switch (texture) {
		case 0:
			
			break;
		case 1:
			loadImage(0, 4);
			break;
		case 2:
			loadImage(0, 5);
			break;
		case 3:
			loadImage(1, 3);
			break;
		case 4:
			loadImage(1, 4);
			break;
		case 5:
			loadImage(1, 5);
			break;
		case 6:
			loadImage(1, 2);
			break;
		case 7:
			loadImage(2, 4);
			break;
		case 8:
			loadImage(0, 3);
			break;
		case 9:
			loadImage(3, 3);
			break;
		case 10:
			loadImage(3, 4);
			break;
		case 11:
			loadImage(3, 5);
			break;
		}
	}
	
	public void update() {
		
	}
}
