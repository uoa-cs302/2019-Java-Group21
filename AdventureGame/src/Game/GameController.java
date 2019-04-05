package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.List;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GameController extends JPanel implements ActionListener {
	
	private Timer timer;
	private int DELAY = 10;
	private int Start_X = 240;
	private int Start_Y = 300;
	private int AnimCount = 1;
	private PC pC;
	private ArrayList<Entity> EntityList = new ArrayList<Entity>();
	private ArrayList<Sprite> SpriteList = new ArrayList<Sprite>();
	private Dungeon GameInst = new Dungeon();
	
	public GameController() {
		GameInst.generateDungeon();

	}
	
	private void initTestmap() {
		
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);
		
		pC = new PC(Start_X,Start_Y);
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doEntityDrawing(g,pC);
		
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doEntityDrawing(Graphics g,Sprite x) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(x.getImage(), x.getx_pos(), x.gety_pos(), this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateEntity(pC);
		repaint();
	}
	
	//need to pass in two objects so we can loop all collision checks or make a separate
	//method for ai etc.
	public void checkCollision(Entity sp1,Sprite sp2) {
		Rectangle r1 = sp1.getBoundary();
		Rectangle r2 = sp2.getBoundary();
		if (r1.intersects(r2)) {
			sp1.CollisionProcess(sp2.gety_pos(),sp2.getbottom(),sp2.getx_pos(),sp2.getright());
		} 
	}
	private void updateEntity(Entity x) {
		if(AnimCount < 21) {
			AnimCount++;
			}else {
				AnimCount = 0;
			}

		checkCollision();
		x.move(AnimCount);
	}
	private void updateEntityAi(Giant_Rat x) {
		if(AnimCount < 21) {
			AnimCount++;
			}else {
				AnimCount = 0;
			}

		x.AiUpdate(pC);
		
		x.move(AnimCount);
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
