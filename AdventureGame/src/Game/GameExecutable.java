package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class GameExecutable extends JFrame {

    public GameExecutable() {
		super.setTitle("A Well of Opportunity");
		super.setSize(1024,768);
		super.setResizable(false);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGame();
    }
    
    private void initGame() {
    	GameView view = new GameView();
    	super.add(view);
    	GameModel model = new GameModel();
    	GameController controller = new GameController(model, view);
    }

    public static void main(String[] args) {
        
       // EventQueue.invokeLater(() -> {
        	GameExecutable ex = new GameExecutable();
      //  });
        
        
    }
}