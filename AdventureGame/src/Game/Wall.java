package Game;

public class Wall extends Entity{
	
	public Wall(int x, int y) {
		super(x,y);
		super.setCollidable(true);
	}
	
	@Override
	protected void hitBy(Entity e) {
		
	}
	
	public void update() {
		
	}
	
	public void setUpWall(int id) {
		switch(id) {
		case 0:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-10));
			Bounds.setxOff(8);
			Bounds.setyOff(10);
			break;
		case 1:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-10));
			Bounds.setyOff(10);
			break;
		case 2:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-10));
			Bounds.setyOff(10);
			break;
		case 16:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			Bounds.setxOff(8);
			break;
		case 18:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			break;
		case 19:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-4));
			break;
		case 20:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-4));
			break;
		case 21:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-4));
			break;
		case 32:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			Bounds.setxOff(8);
			break;
		case 34:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			break;
		case 35:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			break;
		case 36:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-28));
			Bounds.setyOff(28);
			break;
		case 37:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			Bounds.setxOff(8);
			break;
		case 48:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-4));
			Bounds.setxOff(8);
			break;
		case 49:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-4));
			break;
		case 50:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-4));
			break;
		case 51:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height+4));
			Bounds.setyOff(-4);
			break;
		case 52:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height+4));
			Bounds.setyOff(-4);
			break;
		case 53:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height+4));
			Bounds.setyOff(-4);
			break;
		case 65:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			break;
		case 66:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			Bounds.setxOff(8);
			break;
		case 81:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-4));
			break;
		case 82:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-4));
			Bounds.setxOff(8);
			break;
		case 97:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-28));
			Bounds.setyOff(28);
			break;
		case 98:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height-28));
			Bounds.setyOff(28);
			Bounds.setxOff(8);
			break;
		case 113:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			break;
		case 114:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-8,this.height));
			Bounds.setxOff(8);
			break;
		case 128:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-4));
			break;
		case 129:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height));
			break;
		case 144:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			Bounds.setxOff(24);
			break;
		case 145:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height));
			break;
		case 148:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			break;
		case 160:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height-28));
			Bounds.setxOff(24);
			break;
		case 161:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-28));
			break;
		case 164:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height-28));
			break;
		case 165:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			Bounds.setxOff(24);
			break;
		case 169:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			break;
		case 177:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			Bounds.setxOff(24);
			break;
		case 178:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-28));
			break;
		case 179:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			break;
		case 180:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height-28));
			Bounds.setyOff(28);
			break;
		case 188:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height));
			break;
		case 196:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height));
			break;
		case 217:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height-28));
			Bounds.setyOff(28);
			break;
		case 233:
			setInvisibleToProjectile();
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width-24,this.height));
			break;
		default:
			setBounds( new Collision((int)this.x_pos,(int)this.y_pos,this.width,this.height));
			break;
		}
	}
}
