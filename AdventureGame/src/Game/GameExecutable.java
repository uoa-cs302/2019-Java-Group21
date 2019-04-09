package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class GameExecutable {

    public GameExecutable() {

        initGame();
        
       
    }
    
    private void initGame() {
    	
    	//create Gameview Obj
    	GameView view = new GameView();
    	//Creat Game model obj
    	GameModel model = new GameModel();
    	//Create Controller
    	GameController controller = new GameController(model, view);
    }

    public static void main(String[] args) {
        
       // EventQueue.invokeLater(() -> {
        	GameExecutable ex = new GameExecutable();
      //  });
        
        
    }
}