package Game;

import java.awt.CardLayout;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GameView extends JFrame {
	
	private GameScreen gameScreen;
	private StartScreen startScreen;
	private GameOverScreen gameover;
	private GameIntro gameIntro;
	private CharacterScreen characterScreen;
	private DifficultyScreen difficultyScreen;
	private ScoreScreen HighScores;
	
	private CardLayout cardLayout;
	protected Graphics g;
	
	public GameView() {
		InitGameView();
	}
	public void InitGameView() {
		super.setTitle("A Well of Opportunity");
		super.setSize(1024,768);
		super.setResizable(false);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		
		//sets up the cardLayout which will hold the Game Panels/States
		cardLayout = new CardLayout();
		gameScreen = new GameScreen();
		startScreen = new StartScreen();
		gameover = new GameOverScreen();
		gameIntro = new GameIntro();
		characterScreen = new CharacterScreen();
		difficultyScreen = new DifficultyScreen();
		HighScores = new ScoreScreen();
		
		setLayout(cardLayout);
		
		add(startScreen, "start");
		add(gameScreen,"gamescr");
		add(gameover,"over");
		add(gameIntro,"Intro");
		add(characterScreen, "Character");
		add(difficultyScreen, "Difficulty");
		add(HighScores,"Score");
		
		cardLayout.show(this.getContentPane(),"Difficulty");
	}
		
	public void drawGameMenu() {
		cardLayout.show(this.getContentPane(), "gamescr");
	}
	
	public void drawStartMenu() {
		cardLayout.show(this.getContentPane(),"start");
	}
	
	public void drawMainMenu() {
		remove(difficultyScreen);
		remove(startScreen);
		remove(gameScreen);
		remove(gameover);
		remove(gameIntro);
		remove(characterScreen);
		remove(HighScores);
		InitGameView();
	}
	
	public void drawCharacterScreen() {
		cardLayout.show(this.getContentPane(), "Character");
	}
	
	public DifficultyScreen getDifficultyScreen() {
		return this.difficultyScreen;
	}
	
	public CharacterScreen getCharacterScreen() {
		return this.characterScreen;
	}
	
	public void HideMessage() {
		gameScreen.getMessage().setVisible(false);
	}
	public void HidePause() {
		gameScreen.getpause().setVisible(false);
		gameScreen.getpause().setSel(0);
	}
	public void DrawIntro() {
		cardLayout.show(this.getContentPane(), "Intro");
	}
	
	public JLabel getMessage() {
		return gameScreen.getMessage();
	}

	public StartScreen getStartScreen() {
		return startScreen;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}
	
	public CardLayout getcardLayout() {
		return cardLayout;
	}
	public GameOverScreen getGameover() {
		return gameover;
	}
	public void drawGameOver() {
		cardLayout.show(this.getContentPane(), "over");
	}
	public GameIntro getIntro() {
		return gameIntro;
	}
	public ScoreScreen getHighScores() {
		return HighScores;
	}
	public void drawScores() {
		cardLayout.show(this.getContentPane(),"Score");
	}


	
}
