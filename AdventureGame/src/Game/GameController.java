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
	
	private List<Sprite> sprites;
	private List<Sprite> deletedSprites = new ArrayList();
	private List<Entity> entities;

	public GameController(GameModel model, GameView view) {
		//set game model and game view Jframe to Controller variables
		this.gameModel = model;
		this.gameView = view;
		//Sets the button listener on to check for button press on StartScreen
		ScreenListener gameControllerScreenListener = new ScreenListener() {
			@Override
			public void actionPerformed() {
				//Initialise Game on button press
				sprites = gameModel.getCurrentRoom().getSpriteList();
				entities = gameModel.getCurrentRoom().getEntityList();

				InitGame();
				
				//draw the gamescreen
				gameView.drawGameMenu();
				addKeyListen();
			}
		};
		gameView.getStartScreen().setButtonListener(gameControllerScreenListener);
}
			
	private void addKeyListen() {
		//sets a key listener for player movement and interaction
		gameView.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				pC.keyReleased(e);
			}

			public void keyPressed(KeyEvent e){
				pC.keyPressed(e);
			}
		});
	}
				
	private void InitGame() {
		//initialise timer with delay value 10ms
		this.timer = new Timer(DELAY,this);
		pC = new PC(Start_X,Start_Y);
		sprites.add(pC);
		entities.add(pC);
		timer.start();
		// for testing
		
	}
	
	public void RoomLoad() {
		if (sprites.isEmpty()==false || sprites != null) {
	sprites.clear();
		}
	sprites = gameModel.getCurrentRoom().getSpriteList();
	sprites.add(pC);
	}

	@Override
	//method runs when timer ticks
	//should include update, and draw.
	public void actionPerformed(ActionEvent e) {
		if (pC.getInventory().droppedItemsSize() != 0) {
			for (Item item : pC.getInventory().getDroppedItems()) {
				item.setx_pos(pC.getx_pos());
				item.sety_pos(pC.gety_pos());
				item.getImageDim();
				gameModel.getCurrentRoom().addSpriteList(item);
			}
			pC.getInventory().clearDroppedItems();
		}
		
		for (Entity entity : entities) {
			if(entity instanceof PC) {
				updateEntity(entity);
			}else if (entity instanceof GiantRat) {
				updateEntityAi(entity);
			}
		}
		gameView.getGameScreen().setDrawTarget(sprites);
		gameView.getGameScreen().setDrawUI(pC.getInventory());
		gameView.getGameScreen().repaint();
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
						RoomLoad();
					}
					else if (sprite instanceof Wall) {
						Wall wall = (Wall) sprite;
						pC.CollisionProcess(wall.gety_pos(), wall.getbottom(), wall.getx_pos(), wall.getright());
					}
					else if (sprite instanceof GiantRat) {
						GiantRat rat = (GiantRat) sprite;
						pC.hitBy(rat);
					}
					else if (sprite instanceof Item) {
						Item item = (Item) sprite;
						if (pC.isItemPickUp()) {
							if (pC.getInventory().addItem(item))
								deletedSprites.add(sprite);
						}
					}
				}
			}
		}
		if (deletedSprites.size() != 0)
			deleteSprites();
	}
	
	public void checkEntityCollision(Entity x) {
			for (Sprite sprite : sprites) {
				if (x.getID() != sprite.getID()) {
					checkCollision(x,sprite);
				}
			}
	}
	//updateEntity Location
	private void updateEntity(Entity x) {
	x.update();
	}
	//update EntityAi Overridden from Entity in each class
	private void updateEntityAi(Entity x) {

		
	}
	public void deleteSprites() {
		for (int i = 0; i < sprites.size(); i++)
			for (Sprite delete : this.deletedSprites)
				if (sprites.get(i) == delete) {
					sprites.remove(i);
					i--;
				}
		deletedSprites.clear();
	}
}
