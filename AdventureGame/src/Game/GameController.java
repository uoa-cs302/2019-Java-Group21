package Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


public class GameController implements ActionListener {

	private Timer timer;
	private int DELAY = 10;
	private int Start_X = 240;
	private int Start_Y = 300;
	private int AnimCount = 1;
	private PC pC;
	private GameView gameView;
	private GameModel gameModel;
	private Graphics g;

	public GameController(GameModel model, GameView view) {
		//set game model and game view Jframe to Controller variables
		this.gameModel = model;
		this.gameView = view;
		//Sets the button listener on to check for button press on StartScreen
		gameView.getStartScreen().setButtonListener(new ScreenListener() {
			public void actionPerformed() {
				//Initialise Game on button press
				InitGame();
				//draw the gamescreen
				gameView.drawGameMenu();
				//sets a key listener for player movement and intereaction
				gameView.addKeyListener(new KeyAdapter() {

					public void keyReleased(KeyEvent e) {
						pC.keyReleased(e);
					}

					public void keyPressed(KeyEvent e){
						pC.keyPressed(e);
					}
				});
			}
		});

	}

	private void InitGame() {
		//initialise timer with delay value 10ms
		this.timer = new Timer(DELAY,this);
		timer.start();
		// for testing
		pC = new PC(Start_X,Start_Y);
	}


	@Override
	//method runs when timer ticks
	//should include update, and draw.
	public void actionPerformed(ActionEvent e) {
		updateEntity(pC);
		gameView.getGameScreen().setDrawTarget(pC);
	}

	//checks collision of an Entity and a Sprite
	public void checkCollision(Entity sp1,Sprite sp2) {
		Rectangle r1 = sp1.getBoundary();
		Rectangle r2 = sp2.getBoundary();
		if (r1.intersects(r2)) {
			sp1.CollisionProcess(sp2.gety_pos(),sp2.getbottom(),sp2.getx_pos(),sp2.getright());
		} 
	}

	//checks collision of Player with all Obj
	public void checkPlayerCollision() {
		Room currentRoom = gameModel.getCurrentRoom();
		List<Sprite> sprites = currentRoom.getSpriteList();
		Rectangle r1 = pC.getBoundary();
		for (Sprite sprite : sprites) {
			Rectangle r2 = sprite.getBoundary();
			if (r1.intersects(r2)) {
				if (sprite.isCollidable() == true) {
					if (sprite instanceof Door) {
						Door door = (Door) sprite;
						gameModel.loadRoom(gameModel.getDungeonIndex(door.getRoom())); 
						pC.setx_pos(door.getSpawnX());
						pC.sety_pos(door.getSpawnY());
					}
					else if (sprite instanceof Wall) {
						Wall wall = (Wall) sprite;
						switch(wall.getDirection()) {
							case UP:
								if (pC.getdy() > 0)
									pC.setdy(0);
							case DOWN:
								if (pC.getdy() < 0)
									pC.setdy(0);
							case LEFT: 
								if (pC.getdx() > 0)
									pC.setdx(0);
							case RIGHT: 
								if (pC.getdx() < 0)
									pC.setdx(0);
						}
					}
				}
			}
		}
	}


	public void checkEntityCollision() {

	}
	//updateEntity Location
	private void updateEntity(Entity x) {
		if(AnimCount < 21) {
			AnimCount++;
		}else {
			AnimCount = 0;
		}

		x.move(AnimCount);
	}
	//update EntityAi Overridden from Entity in each class
	private void updateEntityAi(Entity x) {
		if(AnimCount < 28) {
			AnimCount++;
		}else {
			AnimCount = 0;
		}

		x.AiUpdate(pC);

		x.move(AnimCount);
	}

}
