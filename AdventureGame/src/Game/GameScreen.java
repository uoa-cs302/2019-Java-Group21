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
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doEntityDrawing(g);
		
		
		Toolkit.getDefaultToolkit().sync();

	}
	//draws image
	public void doEntityDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		for (Sprite sprite : sprites) {
			if(sprite.isVisible()) {
			g2d.drawImage(sprite.getImage(), sprite.getx_pos(), sprite.gety_pos(),this);
			}
		}
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
