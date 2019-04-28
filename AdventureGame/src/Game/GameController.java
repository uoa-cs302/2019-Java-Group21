package Game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;

import Game.AudioObject.Sound;
import javafx.scene.input.KeyCode;


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
	private boolean restart = false;
	private KeyAdapter v;

	private List<Sprite> sprites;
	private List<Entity> deletedEntities = new ArrayList<Entity>();
	private List<Entity> newEntities = new ArrayList<Entity>();
	private List<Entity> entities;
	boolean loadingRoom = false;

	private Sound Intro;
	private Sound Rat;
	private Sound Attck;

	public GameController(GameModel model, GameView view, GameExecutable ex) {

		//set game model and game view Jframe to Controller variables
		this.gameModel = model;
		this.gameView = view;
		this.ex = ex;
		InitDifficulty();
		Image assets = gameModel.getAssets();
		gameView.getCharacterScreen().setImages(assets.getHair(), assets.getHead(), assets.getBody(), assets.getArms(), assets.getLegs(), assets.getFeet());
	}

	public void InitDifficulty() {
		KeyAdapter k = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (gameView.getDifficultyScreen().isVisible()) {
					if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A)
					{
						gameView.getDifficultyScreen().changeSel(e);}
					if(e.getKeyCode() == KeyEvent.VK_S  || e.getKeyCode() == KeyEvent.VK_D) {
						gameView.getDifficultyScreen().changeSel(e);
					}
					if(e.getKeyCode()== KeyEvent.VK_ENTER) {
						switch (gameView.getDifficultyScreen().getSel()) {
						case 0:
							gameModel.generateDungeon(0);
							InitControl();
							gameView.drawStartMenu();
							break;

						case 1:
							gameModel.generateDungeon(1);
							InitControl();
							gameView.drawStartMenu();
							break;
						case 2:
							gameModel.generateDungeon(2);
							InitControl();
							gameView.drawStartMenu();
							break;
						}
					}
				}
			}
		};
		gameView.addKeyListener(k);
	}

	public void InitControl() {

		//Sets the button listener on to check for button press on StartScreen
		KeyAdapter k = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//Initialise Game on button press
				if (gameView.getStartScreen().isVisible()) {
					if (e.getKeyCode() == KeyEvent.VK_W)
					{
						gameView.getStartScreen().changeSel(e);}
					if(e.getKeyCode() == KeyEvent.VK_S) {
						gameView.getStartScreen().changeSel(e);
					}
					if(e.getKeyCode()== KeyEvent.VK_ENTER) {
						switch (gameView.getStartScreen().getSel()) {
						case 0:
							if (gameView.getCharacterScreen().isFinished() == false) {
								gameView.getCharacterScreen().randomise();
								gameView.getCharacterScreen().createCharacter();
								gameModel.getAssets().loadCharacter();
							}
							sprites = gameModel.getCurrentRoom().getSpriteList();
							entities = gameModel.getCurrentRoom().getEntityList();
							gameView.DrawIntro();
							addKeyListen();
							gameView.removeKeyListener(this);
							break;

						case 1:
							gameView.drawCharacterScreen();
							break;
						case 3:
							gameView.dispose();
							break;
						}
					}
				}
				if(gameView.getCharacterScreen().isVisible()) {
					if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D ||e.getKeyCode() == KeyEvent.VK_ENTER) 
						gameView.getCharacterScreen().changeSel(e);
					if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
						if (gameView.getCharacterScreen().getSelect() == 6)
							gameView.getCharacterScreen().randomise();
						else if (gameView.getCharacterScreen().getSelect() == 7) {
							gameView.getCharacterScreen().setFinished(true);
							gameView.getCharacterScreen().createCharacter();
							gameModel.getAssets().loadCharacter();
							gameView.drawStartMenu();
						}
					}
				}
			}
		};
		gameView.addKeyListener(k);
	}

	public void restart() {
		gameView.removeKeyListener(v);
		gameView.drawMainMenu();
		this.gameModel = new GameModel();
		InitControl();
	}

	private void addKeyListen() {
		//sets a key listener for player movement and interaction

		gameView.addKeyListener(v = new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				if (gameView.getIntro().isVisible()) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						gameView.drawGameMenu();
						InitGame();
						gameView.getIntro().setVisible(false);
					}
				}
				//-------------------------------------------------------------------					
				if(e.getKeyCode() == KeyEvent.VK_T) {
					timer.stop();
					gameView.getGameScreen().drawMessage("block");
				} else 
					if (!gameView.getMessage().isVisible()) {
						if(pC != null) {
							pC.keyReleased(e);
						}
					} else {
						timer.restart();
						gameView.HideMessage();
					}
				//------------------------------------------------------------				
				if ((e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_ESCAPE)&& !gameView.getGameScreen().getpause().isVisible() ) {
					timer.stop();
					gameView.getGameScreen().drawPauseMenu();
				} else if ((e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_ESCAPE) && gameView.getGameScreen().getpause().isVisible()) {
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
						}else if (gameView.getGameover().isVisible()||pC.isDead()) {
							System.out.println("Restarting");
							if (e.getKeyCode() == KeyEvent.VK_ENTER) {
								System.out.println("Restarting");
								//	try {
								//gameView.getGameover().saveScore();
								//} catch (IOException e1) {
								// TODO Auto-generated catch block

								//}
								restart();
							}
						}else {
							gameView.getGameover().calculateScore(enemykillcount, game_time);
							gameView.drawGameOver();
						}
					}

				} else if (pC != null) {
				if(gameView.getGameover().isVisible()||pC.isDead()) {
					System.out.println("Restarting");
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						System.out.println("Restarting");
						//	try {
						//gameView.getGameover().saveScore();
						//} catch (IOException e1) {
						// TODO Auto-generated catch block

						//}
						restart();
					}
				}
				}

			}

			public void keyPressed(KeyEvent e){
				if (!gameView.getMessage().isVisible()) {
					if (pC != null) {
						pC.keyPressed(e);
					}
				}
			}
		});
	}

	private void InitGame() {
		//initialise timer with delay value 10ms
		this.timer = new Timer(DELAY,this);
		hud = new HeadsUpDisplay();
		pC = new PC(Start_X,Start_Y,gameModel.getPlayerAssets(), gameModel.getInventoryAssets());
		Dog dog = new Dog(0,0);
		pC.getInventory().addItem(dog);
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
		if (gamecount == 100) { gamecount = 0; this.game_time ++;}
		gamecount++;
		gameView.getGameScreen().updateTimer(game_time);
		gameView.getGameScreen().updateScore(game_time, enemykillcount);
		hud.setHealth(pC.getHealth());
		sprites.remove(pC);
		sprites.add(pC);
		if (deletedEntities.size() != 0)
			deleteEntities();
		if (newEntities.size() != 0)
			addEntities();
		if (pC.getInventory().droppedItemsSize() != 0) {
			for (Item item : pC.getInventory().getDroppedItems()) {
				item.setx_pos((int)pC.getx_pos());
				item.sety_pos((int)pC.gety_pos());
				item.getImageDim();
				item.setBounds(new Collision((int)item.getx_pos(),(int)item.gety_pos(),item.width/2,item.height/2));
				item.getBounds().setyOff(item.height/2);
				item.getBounds().setxOff(item.width/4);
				item.setHitBounds(new Collision((int)item.getx_pos(),(int)item.gety_pos(),item.width,item.height));
				if (item instanceof Dog) {
					Dog dog = (Dog) item;
					dog.setDropped(false);
					for (Entity entity : entities) {
						if (entity instanceof Skeleton) {
							System.out.println("hi");
							dog.setTarget(entity);
							dog.setDropped(true);
							newEntities.add(dog);
						}
					}
					if (dog.isDropped() == false)
						pC.getInventory().addItem(dog);
				}
				else
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
			else if (entity instanceof Dog) {
				checkEntityCollision(entity);
				entity.update();
			}
			else if (entity instanceof PressurePlate) {
				checkEntityCollision(entity);
				entity.update();
			}
			else if (entity instanceof Chest) {
				checkEntityCollision(entity);
				entity.update();
			}
			else if (entity instanceof Door) {
				entity.update();
			}
			else if (entity instanceof Light) {
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
					if (sp2.isInvisibleToProjectile() == false)
						deletedEntities.add(sp1);
					if(!(sp2 instanceof Door)) {
						sp2.hitBy(sp1);
					}
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
							if (door.isEndDoor()) {
								timer.stop();
								gameView.getGameover().calculateScore(enemykillcount, game_time);
								gameView.drawGameOver();
							}
							else {
								gameModel.loadRoom(gameModel.getDungeonIndex(door.getRoom())); 
								pC.setx_pos(door.getSpawnX());
								pC.sety_pos(door.getSpawnY());
								loadingTrue();
							}
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
							if (pC.canAttack() && pC.getAttack()) {
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
								rat.setAttack(true);
							}
						}
					}
					else if (e1 instanceof GiantSpider) {
						GiantSpider spider = (GiantSpider) e1;
						if (pC.getHitBounds().collisionWith(spider.getBounds())) {
							if (pC.canAttack() && pC.getAttack()) {
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
							if (pC.isItemPickUp()) {
								if (pC.getInventory().addItem(item)) {
									deletedEntities.add(e1);
								}
							}
						}
					}
					else if (e1 instanceof Projectile) {
						Projectile projectile = (Projectile) e1;
						if (pC.getHitBounds().collisionWith(projectile.getBounds()) && pC.canAttack() && pC.getAttack())
							deletedEntities.add(projectile);
					}
					else if (e1 instanceof Skeleton) {
						Skeleton skeleton = (Skeleton) e1;
						if(pC.getBounds().collisionWith(skeleton.getHitBounds())) {
							if(skeleton.canAttack()) {
								pC.hitBy(skeleton);
								skeleton.setAttack(true);
							}
						}
					}
					else if (e1 instanceof Chest) {
						Chest chest = (Chest) e1;
						if(pC.getBounds().collisionWith(chest.getBounds(),(int)pC.getdx(),(int)pC.getdy())) {
							pC.CollisionProcess(chest.getBounds());
						}
						else if (pC.getBounds().collisionWith(chest.getHitBounds())) {
							chest.setOpen(true);
							if (pC.isInteract()) {
								pC.getInventory().addItem(chest.getItem());
							}
						}
						else
							chest.setOpen(false);
					}
				}
			}
		}
		if (pC.getHealth() <= 0 && pC.isDead() == false) {
			pC.setDead(true);
			timer.stop();
			gameView.getGameover().calculateScore(enemykillcount, game_time);
			gameView.drawGameOver();
		}
	}

	public void checkEntityCollision(Entity x) {
		if (x instanceof PressurePlate) {
			PressurePlate pp = (PressurePlate) x;
			pp.setEnabled(false);
		}
		for (Entity e1 : entities) {
			if (x.getID() != e1.getID()) {
				if (!(x instanceof Item)) {
					checkCollision(x,e1);
					if (x instanceof PressurePlate) {
						PressurePlate pp = (PressurePlate) x;
						if (pp.getBounds().collisionWith(e1.getBounds())) {
							pp.setEnabled(true);
						}
					}
					else if (x instanceof Skeleton && e1 instanceof Dog) {
						if (x.getHitBounds().collisionWith(e1.getHitBounds())) {
							if (e1.canAttack()) {
								x.hitBy(e1);
								e1.setAttack(true);
								if (x.getHealth()<= 0) {
									deletedEntities.add(x);
								}

							}
						}
					}
				}
			}
		}
	}

	private void updatePlayer(Entity entity) {
		pC.move();
		checkPlayerCollision();
		entity.update();

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
