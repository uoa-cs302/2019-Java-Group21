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
	private GameExecutable ex;
	private Graphics g;
	private int game_time = 0;
	private int gamecount = 0;
	private int enemykillcount = 0;
	private HeadsUpDisplay hud;

	private List<Sprite> sprites;
	private List<Entity> deletedEntities = new ArrayList<Entity>();
	private List<Entity> newEntities = new ArrayList<Entity>();
	private List<Entity> entities;
	boolean loadingRoom = false;

	public GameController(GameModel model, GameView view, GameExecutable ex) {
		//set game model and game view Jframe to Controller variables
		this.gameModel = model;
		this.gameView = view;
		this.ex = ex;

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
				if(e.getKeyCode() == KeyEvent.VK_T) {
					timer.stop();
					gameView.getGameScreen().drawMessage("block");
				} else 
					if (!gameView.getMessage().isVisible()) {
						pC.keyReleased(e);
					} else {
						timer.restart();
						gameView.HideMessage();
					}
				 if (e.getKeyCode() == KeyEvent.VK_P && !gameView.getGameScreen().getpause().isVisible() ) {
					timer.stop();
					gameView.getGameScreen().drawPauseMenu();
				} else if (e.getKeyCode() == KeyEvent.VK_P && gameView.getGameScreen().getpause().isVisible()) {
				gameView.HidePause();
				timer.restart();
				} else if (gameView.getGameScreen().getpause().isVisible()) {
					if (e.getKeyCode() == KeyEvent.VK_W) {
						gameView.getGameScreen().getpause().setSel(0);
					} else if (e.getKeyCode() == KeyEvent.VK_S) {
						gameView.getGameScreen().getpause().setSel(1);
					} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (gameView.getGameScreen().getpause().getSel()==0) {
							gameView.HidePause();
							timer.restart();
						}else {}
						//need to incorporate gameover screen yet
							
					}
					
				}
			}

			public void keyPressed(KeyEvent e){
				if (!gameView.getMessage().isVisible()) {
					pC.keyPressed(e);
				}
			}
		});
	}

	private void InitGame() {
		//initialise timer with delay value 10ms
		this.timer = new Timer(DELAY,this);
		hud = new HeadsUpDisplay();
		pC = new PC(Start_X,Start_Y,gameModel.getPlayerAssets());
		hud.setHealthAssets(gameModel.getHealthAssets());
		hud.setInventory(pC.getInventory());
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
		if (gamecount == 100) { gamecount = 0; this.game_time ++; System.out.println(game_time); }
		hud.setHealth(pC.getHealth());
		if (deletedEntities.size() != 0)
			deleteEntities();
		if (newEntities.size() != 0)
			addEntities();
		if (pC.getInventory().droppedItemsSize() != 0) {
			for (Item item : pC.getInventory().getDroppedItems()) {
				item.setx_pos((int)pC.getx_pos());
				item.sety_pos((int)pC.gety_pos());
				item.getImageDim();
				newEntities.add(item);
			}
			pC.getInventory().clearDroppedItems();
		}
		for (Entity entity : entities) {
			if(entity instanceof PC) {
				updatePlayer(entity);
			}
			else if (entity instanceof GiantRat) {
				entity.update(pC);
				checkEntityCollision(entity);
				//checkEntityCollision(entity);
				entity.update();
			}
			else if (entity instanceof GiantSpider) {
				entity.setTarget(pC);
				checkEntityCollision(entity);
				entity.update();
				for (Projectile projectile : ((GiantSpider) entity).getProjectiles()) {
					newEntities.add(projectile);
				}
				((GiantSpider) entity).clearProjectiles();
			}
			else if (entity instanceof Projectile) {
				checkEntityCollision(entity);
				entity.update();
			}
			else if (entity instanceof Skeleton) {
				entity.setTarget(pC);
				checkEntityCollision(entity);
				entity.update();
			}
		}
		if (getLoadingRoom())
			RoomLoad();
		gameView.getGameScreen().setDrawTarget(sprites);
		gameView.getGameScreen().setDrawUI(getHUD());
		gameView.getGameScreen().repaint();
		loadingFalse();
	}

	//checks collision of an Entity and a Sprite
	public void checkCollision(Entity sp1,Entity sp2) {
		if (sp1.getBounds().collisionWith(sp2.getBounds(),(int)sp1.getdx(),(int)sp1.getdy())) {
			if (sp1 instanceof Projectile) {
				if (sp2 != ((Projectile) sp1).getParent() && !(sp2 instanceof Projectile)) {
					deletedEntities.add(sp1);
					if(!(sp2 instanceof Door)) {
					sp2.hitBy(sp1);
					}
					sp2.resetSlowedCounter();
					sp2.setSlowed();
				}
			}
			else
				sp1.CollisionProcess(sp2.getBounds());
		}
	}

	//checks collision of Player with all Obj
	public void checkPlayerCollision() {
		for (Entity e1 : entities) {
			if(pC.getID() != e1.getID()) {
				if (e1.isCollidable() == true) {
					if (e1 instanceof Door) {
						Door door = (Door) e1;
						if(pC.getBounds().collisionWith(door.getBounds()) && door.isOpen()) {
							gameModel.loadRoom(gameModel.getDungeonIndex(door.getRoom())); 
							pC.setx_pos(door.getSpawnX());
							pC.sety_pos(door.getSpawnY());
							loadingTrue();
						}
					}
					else if (e1 instanceof Wall) {
						Wall wall = (Wall) e1;
						if(pC.getBounds().collisionWith(wall.getBounds(),(int)pC.getdx(),(int)pC.getdy()))
							pC.CollisionProcess(wall.getBounds());
					}
					else if (e1 instanceof GiantRat) {
						GiantRat rat = (GiantRat) e1;
						if (pC.getHitBounds().collisionWith(rat.getBounds())) {
							if (pC.canAttack()) {
								rat.hitBy(pC);
								if (rat.getHealth()<= 0) {
									deletedEntities.add(rat);
									enemykillcount++;
								}
							}
						}
						if(pC.getBounds().collisionWith(rat.getHitBounds())) {
							if(rat.canAttack()) {
								pC.hitBy(rat);
							}
						}
					}
					else if (e1 instanceof GiantSpider) {
						GiantSpider spider = (GiantSpider) e1;
						if (pC.getHitBounds().collisionWith(spider.getBounds())) {
							if (pC.canAttack()) {
								spider.hitBy(pC);
								if (spider.getHealth()<= 0) {
									deletedEntities.add(spider);
									enemykillcount++;
								}
							}
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
					else if (e1 instanceof Projectile) {
						Projectile projectile = (Projectile) e1;
						if (pC.getHitBounds().collisionWith(projectile.getBounds()) && pC.canAttack())
							deletedEntities.add(projectile);
					}
					else if (e1 instanceof Skeleton) {
						Skeleton skeleton = (Skeleton) e1;
						if (pC.getHitBounds().collisionWith(skeleton.getBounds())) {
							pC.CollisionProcess(skeleton.getBounds());
							if (pC.canAttack()) {
								skeleton.hitBy(pC);
								if (skeleton.getHealth()<= 0) {
									deletedEntities.add(skeleton);
								}
							}
						}
						if(pC.getBounds().collisionWith(skeleton.getHitBounds())) {
							if(skeleton.canAttack()) {
								pC.hitBy(skeleton);
							}
						}
					}
				}
			}
		}
	}

	public void checkEntityCollision(Entity x) {
		boolean steppedon = false;
		for (Entity e1 : entities) {
			if (x.getID() != e1.getID()) {
				if (x instanceof PressurePlate) {

					PressurePlate pp = (PressurePlate) x;
					if (pp.getBounds().collisionWith(e1.getBounds())) {
						pp.CollisionProcess(e1.getBounds());
						steppedon = true;
					}
				}
				checkCollision(x,e1);
			}
		}
		if (!steppedon && x instanceof PressurePlate) {
			PressurePlate pp = (PressurePlate) x;
			pp.setEnabled(false);
		}
	}

	private void updatePlayer(Entity entity) {
		pC.move();
		checkPlayerCollision();
		entity.update();

	}

	//updateEntity Location
	private void updateEntity(Entity x) {

		checkEntityCollision(x);
		x.update(pC);
	}
	//update EntityAi Overridden from Entity in each class

	public void addEntities() {
		for (Entity add : this.newEntities){
			entities.add(add);
			sprites.add(add);
		}
		newEntities.clear();
	}

	public void deleteEntities() {
		for (Entity delete : this.deletedEntities){
			entities.remove(delete);
			sprites.remove(delete);
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

	public HeadsUpDisplay getHUD() {
		return this.hud;
	}
}
