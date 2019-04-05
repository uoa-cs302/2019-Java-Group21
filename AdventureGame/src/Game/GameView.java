package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GameView extends JPanel implements ActionListener {
	
	public GameView() {
		

		setFocusable(true);
		initStartMenu();
	}
	
	private void initStartMenu() {
		JButton Start = new JButton("Start");
		JLabel Title = new JLabel("Well of Opportunity");
		
		add(Title);
		add(Start);
		
	}
	
	public void paintComponent(Graphics g,Sprite x) {
		super.paintComponent(g);
		doEntityDrawing(g,x);
		
		
		Toolkit.getDefaultToolkit().sync();
	}
	public void doEntityDrawing(Graphics g,Sprite x) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(x.getImage(), x.getx_pos(), x.gety_pos(), this);
	}

	@Override
	public void actionPerformed(ActionEvent st) {
		
	}
}
