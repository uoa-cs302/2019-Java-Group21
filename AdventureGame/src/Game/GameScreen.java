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
		
		setBackground(Color.black);
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
		for (Sprite sprite : sprites) {
			if(sprite != null) {
				if(sprite.isVisible()) {
					g2d.drawImage(sprite.getImage(), sprite.getx_pos(), sprite.gety_pos(),this);
				}
			}
		}
		if (sprites.size() != 0) {
			g2d.drawImage(inventory.getImage(), 100, 600, this);
			for(int i = 0; i < inventory.inventorySize(); i++) {
				g2d.drawImage(inventory.seeItem(i).getInventoryImage(), 113 + (96*i), 613, this);
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
