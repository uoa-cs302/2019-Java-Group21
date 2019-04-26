package Game;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class GameView extends JFrame {
	
	private GameScreen gameScreen;
	private StartScreen startScreen;
	private CardLayout cardLayout;
	protected Graphics g;
	
	public GameView() {
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
		setLayout(cardLayout);
		
		add(startScreen, "start");
		add(gameScreen,"gamescr");
		
			cardLayout.show(this.getContentPane(),"start");
	}
		
	public void drawGameMenu() {
		cardLayout.show(this.getContentPane(), "gamescr");
	}
	public void HideMessage() {
		gameScreen.getMessage().setVisible(false);
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


	
}
