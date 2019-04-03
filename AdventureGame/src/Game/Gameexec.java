package Game;

import java.awt.EventQueue;
import javax.swing.JFrame;
//GameUI
public class Gameexec extends JFrame {

    public Gameexec() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new GameUI());
        
        setSize(1400, 768);
        setResizable(false);
        
        setTitle("Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Gameexec ex = new Gameexec();
            ex.setVisible(true);
        });
    }
}