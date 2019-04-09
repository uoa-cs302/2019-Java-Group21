package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	//sprite can be changed into ArrayList or other later
	private Sprite sprites;
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
		repaint();
	}
	//draws image
	public void doEntityDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(sprites.getImage(), sprites.getx_pos(), sprites.gety_pos(), this);
	}
	public void setDrawTarget(Sprite sprites) {
		
		this.sprites = sprites;
	}
	//may not be used atm
	public void setKeyListener(KeypressListener key) {
		this.key = key;
	}


}
