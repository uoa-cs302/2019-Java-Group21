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
	private int Start_X = 240;
	private int Start_Y = 300;
	private int AnimCount = 1;
	private PC pC;
	private Collision_Obj ob;
	private Giant_Rat rat1;
	private Giant_Rat rat2;
	private Giant_Rat rat3;
	
	public GameUI() {
		initTestmap();
	}
	
	private void initTestmap() {
		
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);
		
		pC = new PC(Start_X,Start_Y);
		ob = new Collision_Obj(300,300,"src/Image/tile001.png");
		rat1 = new Giant_Rat(1000,800);
		rat2 = new Giant_Rat(1000,50);
		rat3 = new Giant_Rat(1000,200);
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doEntityDrawing(g,pC);
		doEntityDrawing(g,rat1);
		doEntityDrawing(g,rat2);
		doEntityDrawing(g,rat3);
		
		
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doEntityDrawing(Graphics g,Entity x) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(x.getImage(), x.getx_pos(), x.gety_pos(), this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		updateEntity(pC);
		updateEntityAi(rat1);
		updateEntityAi(rat2);
		updateEntityAi(rat3);
		repaint();
	}
	
	//need to pass in two objects so we can loop all collision checks or make a separate
	//method for ai etc.
	public void checkCollision() {
		Rectangle r1 = pC.getBoundary();
		Rectangle r2 = ob.getBoundary();
		if (r1.intersects(r2)) {
			pC.CollisionProcess(ob.gety_pos(),ob.getbottom(),ob.getx_pos(),ob.getright());
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
