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
		case 3:
			loadImage(0, 3);
			break;
		case 4:
			loadImage(0, 4);
			break;
		case 5:
			loadImage(0, 5);
			break;
		case 16:
			loadImage(1, 0);
			break;
		case 18:
			loadImage(1, 2);
			break;
		case 19:
			loadImage(1, 3);
			break;
		case 20:
			loadImage(1, 4);
			break;
		case 21:
			loadImage(1, 5);
			break;
		case 51:
			loadImage(3, 3);
			break;
		case 52:
			loadImage(3, 4);
			break;
		case 53:
			loadImage(3, 5);
			break;
		case 64:
			loadImage(4, 0);
			break;
		case 65:
			loadImage(4, 1);
			break;
		case 66:
			loadImage(4, 2);
			break;
		case 67:
			loadImage(4, 3);
			break;
		case 81:
			loadImage(5, 1);
			break;
		case 82:
			loadImage(5, 2);
			break;
		}
	}
	
	public void update() {
		
	}
}
