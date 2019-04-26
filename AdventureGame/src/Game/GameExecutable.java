package Game;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class GameExecutable {
	
	private GameView view;
	private GameModel model;

    public GameExecutable() {

        initGame();
        
       
    }
    
    private void initGame() {
    	
    	//create Gameview Obj
    	view = new GameView();
    	//Creat Game model obj
    	 model = new GameModel();
    	//Create Controller
    	GameController controller = new GameController(model, view,this);
    	System.out.println("GameController exists: " + controller);
    }
    public void newGame() {
    	initGame();
    }

    public static void main(String[] args) {
        
       // EventQueue.invokeLater(() -> {
    	System.out.println("Hi I'm the thing that exists first! :-)");
        GameExecutable ex = new GameExecutable();
        System.out.println("Hi I'm the thing that exists second! :-)");
      //  });
        
        
    }
}