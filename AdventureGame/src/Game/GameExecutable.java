package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class GameExecutable {

    public GameExecutable() {

        initGame();
        
       
    }
    
    private void initGame() {
    	GameView view = new GameView();
    	
    	GameModel model = new GameModel();
    	GameController controller = new GameController(model, view);
    }

    public static void main(String[] args) {
        
       // EventQueue.invokeLater(() -> {
        	GameExecutable ex = new GameExecutable();
      //  });
        
        
    }
}