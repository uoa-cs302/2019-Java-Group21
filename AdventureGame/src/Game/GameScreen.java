package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	private Sprite sprites;
	@SuppressWarnings("unused")
	private KeypressListener key;
	
	public GameScreen() {
		setBackground(Color.black);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				key.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				key.keyReleased(e);
			}
		});
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doEntityDrawing(g);
		
		
		Toolkit.getDefaultToolkit().sync();
		repaint();
	}
	public void doEntityDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(sprites.getImage(), sprites.getx_pos(), sprites.gety_pos(), this);
	}
	public void setDrawTarget(Sprite sprites) {
		
		this.sprites = sprites;
	}
	public void setKeyListener(KeypressListener key) {
		this.key = key;
	}


}
