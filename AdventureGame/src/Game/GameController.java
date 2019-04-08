package Game;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class GameController implements ActionListener {
	
	private Timer timer;
	private int DELAY = 10;
	private int Start_X = 240;
	private int Start_Y = 300;
	private int AnimCount = 1;
	private PC pC;
	private Dungeon GameInst;
	private GameView gameView;
	private GameModel gameModel;
	
	public GameController(GameModel model, GameView view) {
		this.gameModel = model;
		this.gameView = view;
		InitGame();
		
	}
	
	private void InitGame() {
		
		this.timer = new Timer(DELAY,this);
		timer.start();
		gameView.addKeyListener(new TAdapter());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		updateEntity(pC);
		gameView.repaint();
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

		x.move(AnimCount);
	}
	private void updateEntityAi(Entity x) {
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