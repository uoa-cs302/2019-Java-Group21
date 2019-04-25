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
    	System.out.println("GameController exists: " + controller);
    }

    public static void main(String[] args) {
        
       // EventQueue.invokeLater(() -> {
    	System.out.println("Hi I'm the thing that exists first! :-)");
        GameExecutable ex = new GameExecutable();
        System.out.println("Hi I'm the thing that exists second! :-)");
      //  });
        
        
    }
}