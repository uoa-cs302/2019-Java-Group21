package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	//sprite can be changed into ArrayList or other later
	private List<Sprite> sprites;
	private Inventory inventory;
	@SuppressWarnings("unused")
	private KeypressListener key;
	
	public GameScreen() {
		Color color = new Color(47,47,48);
		setBackground(color);
		//sets KeyListner which calls interface methods described in Controller
		//Not used currently
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				key.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				key.keyReleased(e);
			}
		});
		
	}
	//paints Sprites
	@Override

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doEntityDrawing(g);
		Toolkit.getDefaultToolkit().sync();

	}
	//draws image
	public void doEntityDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (sprites != null) {
		for (Sprite sprite : sprites) {
			
				if(sprite.isVisible() && sprite.getImage() != null) {
					g2d.drawImage(sprite.getImage(), sprite.getx_pos(), sprite.gety_pos(),this);
				}
				if(sprite instanceof Entity) {
					Entity x = (Entity) sprite;
					g2d.setColor(Color.blue);
					g2d.drawRect(x.getBounds().getX()+ (int) x.getBounds().getxOff(), x.getBounds().getY() + (int) x.getBounds().getyOff(), (int) x.getBounds().getwidth(),(int) x.getBounds().getheight());
				}if(sprite instanceof PC) {
					PC pC = (PC) sprite;
					g2d.setColor(Color.green);
					g2d.drawRect(pC.getHitBounds().getX() + (int) pC.getHitBounds().getxOff(),(int) pC.getHitBounds().getY()+ (int)pC.getHitBounds().getyOff(), (int)pC.getHitBounds().getwidth(),(int) pC.getHitBounds().getheight());
				}if(sprite instanceof GiantRat) {
					GiantRat rat = (GiantRat) sprite;
					g2d.setColor(Color.green);
					g2d.drawRect(rat.getHitBounds().getX() + (int) rat.getHitBounds().getxOff(),(int) rat.getHitBounds().getY()+ (int)rat.getHitBounds().getyOff(), (int)rat.getHitBounds().getwidth(),(int) rat.getHitBounds().getheight());
				}
			}
		}
		if(inventory != null) {
			g2d.drawImage(inventory.getImage(), 128, 600, this);
			for(int i = 0; i < inventory.inventorySize(); i++) {
				g2d.drawImage(inventory.seeItem(i).getInventoryImage(), 138 + (96*i), 613, this);
			}
		}	
	}
	
	public void setDrawUI(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void setDrawTarget(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	//may not be used atm
	public void setKeyListener(KeypressListener key) {
		this.key = key;
	}
	public void updateScreen() {
		repaint();
	}


}
