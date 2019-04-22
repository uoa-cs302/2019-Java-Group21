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
	private int Start_X = 496;
	private int Start_Y = 304;
	private int AnimCount = 1;
	private PC pC;
	private GameView gameView;
	private GameModel gameModel;
	private Graphics g;

	private List<Sprite> sprites;
	private List<Entity> deletedEntities = new ArrayList<Entity>();
	private List<Entity> entities;
	boolean loadingRoom = false;

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
				//draw the gamescreen
				gameView.drawGameMenu();
				InitGame();
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
		pC = new PC(Start_X,Start_Y,gameModel.getPlayerAssets());
		sprites.add(pC);
		entities.add(pC);
		timer.start();
		// for testing

	}

	public void RoomLoad() {
		deletedEntities.add(pC);
		deleteEntities();
		sprites = gameModel.getCurrentRoom().getSpriteList();
		sprites.add(pC);
		entities = gameModel.getCurrentRoom().getEntityList();
		entities.add(pC);
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
				gameModel.getCurrentRoom().addEntityList(item);
				gameModel.getCurrentRoom().addSpriteList(item);
			}
			pC.getInventory().clearDroppedItems();
		}

		for (Entity entity : entities) {
			if(entity instanceof PC) {
				updatePlayer(entity);
			}else if (entity instanceof GiantRat) {
				checkEntityCollision(entity);
				entity.update(pC);
				//checkEntityCollision(entity);
				//entity.update();
			}
		}
		if (getLoadingRoom())
			RoomLoad();
		gameView.getGameScreen().setDrawTarget(sprites);
		gameView.getGameScreen().setDrawUI(pC.getInventory());
		gameView.getGameScreen().repaint();
		loadingFalse();
	}

	//checks collision of an Entity and a Sprite
	public void checkCollision(Entity sp1,Entity sp2) {
		if (sp1.getBounds().collisionWith(sp2.getBounds())) {
			sp1.CollisionProcess(sp2.gety_pos(),sp2.getbottom(),sp2.getx_pos(),sp2.getright());
		} 
	}

	//checks collision of Player with all Obj
	public void checkPlayerCollision() {
		Rectangle r1 = pC.getBoundary();
		for (Entity e1 : entities) {
			if(pC.getID() != e1.getID()) {
				if (e1.isCollidable() == true) {
					if (e1 instanceof Door) {
						Door door = (Door) e1;
						if(pC.getBounds().collisionWith(door.getBounds())) {
							System.out.println("index is = " + door.getRoom());
							gameModel.loadRoom(gameModel.getDungeonIndex(door.getRoom())); 
							pC.setx_pos(door.getSpawnX());
							pC.sety_pos(door.getSpawnY());
							loadingTrue();
						}
					}
					else if (e1 instanceof Wall) {
						Wall wall = (Wall) e1;
						if(pC.getBounds().collisionWith(wall.getBounds())) {
							pC.CollisionProcess(wall.gety_pos(), wall.getbottom(), wall.getx_pos(), wall.getright());
						}
					}
					else if (e1 instanceof GiantRat) {
						GiantRat rat = (GiantRat) e1;
						if(pC.getBounds().collisionWith(rat.getHitBounds())) {
							pC.hitBy(rat);
						}
					}
					else if (e1 instanceof Item) {
						Item item = (Item) e1;
						System.out.println("item size " + item.getBounds().getheight());
						if(pC.getBounds().collisionWith(item.getBounds())) {
							System.out.println("is colliding with an item");
							if (pC.isItemPickUp()) {
								System.out.println("detected item pickup");
								if (pC.getInventory().addItem(item)) {
									deletedEntities.add(e1);
									System.out.println("item pick up successful!");
								}
							}
						}
					}

				}
			}
		}
		if (deletedEntities.size() != 0)
			deleteEntities();
	}

	public void checkEntityCollision(Entity x) {
		for (Entity e1 : entities) {
			if (x.getID() != e1.getID()) {
				checkCollision(x,e1);
			}
		}
	}
	
	private void updatePlayer(Entity entity) {
		checkPlayerCollision();
		entity.update();
	}
	
	//updateEntity Location
	private void updateEntity(Entity x) {
			checkEntityCollision(x);
			x.update(pC);
	}
	//update EntityAi Overridden from Entity in each class
	public void deleteEntities() {
		for (int i = 0; i < entities.size(); i++) {
			for (Entity delete : this.deletedEntities)
				if (entities.get(i) == delete) {
					entities.remove(i);
					sprites.remove(delete);
					i--;
				}
		}
		deletedEntities.clear();
	}
	
	private boolean getLoadingRoom() {
		return this.loadingRoom;
	}
	
	private void loadingTrue() {
		this.loadingRoom = true;
	}
	
	private void loadingFalse() {
		this.loadingRoom = false;
	}
}
