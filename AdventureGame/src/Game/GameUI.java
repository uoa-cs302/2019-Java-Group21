package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GameUI extends JPanel implements ActionListener {
	
	private Timer timer;
	private int DELAY = 10;
	private int Start_X = 40;
	private int Start_Y = 60;
	private int AnimCount = 1;
	private PC pC;
	private Collision_Obj ob;
	
	public GameUI() {
		initTestmap();
	}
	
	private void initTestmap() {
		
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);
		
		pC = new PC(Start_X,Start_Y);
		ob = new Collision_Obj(300,300,"src/Image/tile001.png");
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doObjDrawing(g);
		dopCDrawing(g);
		
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void dopCDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(pC.getImage(), pC.getx_pos(), pC.gety_pos(), this);
	}
	
	private void doObjDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
	
		g2d.drawImage(ob.getImage(), ob.getx_pos(), ob.gety_pos(), this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		updatepC();
		repaint();
	}
	public boolean checkCollision() {
		Rectangle r1 = pC.getBoundary();
		Rectangle r2 = ob.getBoundary();
		if (r1.intersects(r2)) {
			return true;
		} else {
			return false;
		}
	}
	private void updatepC() {
		if(AnimCount < 21) {
			AnimCount++;
			}else {
				AnimCount = 0;
			}
		pC.move(AnimCount);
		if (checkCollision()) {
			pC.CollisionBlock();
		}
		
	}
	private class TAdapter extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			pC.keyReleased(e);
		}
		@Override
		public void keyPressed(KeyEvent e) {
			pC.keyPressed(e);
		}
	}

}
