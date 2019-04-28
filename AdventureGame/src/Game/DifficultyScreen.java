package Game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DifficultyScreen extends JPanel implements ActionListener {
	
	
	private ScreenListener ButtonListener;
	private JLabel easy;
	private JLabel medium;
	private JLabel hard;
	
	private int sel = 0;
	
	private Timer timer = new Timer(15,this);
	
	public DifficultyScreen() {
		this.setLayout(null);

		easy = new JLabel();
		easy.setFont(new Font("Helvetica",Font.BOLD,22));
		easy.setBounds(205, 360, 200, 40);
		easy.setAlignmentX(Label.CENTER);
		easy.setText("Easy");

		medium = new JLabel();
		medium.setFont(new Font("Helvetica",Font.PLAIN,22));
		medium.setBounds(500, 360, 200, 40);
		medium.setAlignmentX(Label.CENTER);
		medium.setText("Medium");

		hard = new JLabel();
		hard.setFont(new Font("Helvetica",Font.PLAIN,22));
		hard.setBounds(750, 360, 200, 40);
		hard.setAlignmentX(Label.CENTER);
		hard.setText("Hard");

		this.add(easy);
		this.add(medium);
		this.add(hard);
	}
	
	public void setButtonListener(ScreenListener sl) {
		this.ButtonListener = sl;
	}
	
	public void changeSel(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_A) {sel --;}
		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_D)	{sel ++;}
		
		if(sel < 0) {sel = 2;}
		if(sel > 2)	{sel = 0;}
		
		switch (sel) {
		case 0:
			easy.setFont(new Font("Helvetica",Font.BOLD,22));
			medium.setFont(new Font("Helvetica",Font.PLAIN,22));
			hard.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 1:
			easy.setFont(new Font("Helvetica",Font.PLAIN,22));
			medium.setFont(new Font("Helvetica",Font.BOLD,22));
			hard.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 2:
			easy.setFont(new Font("Helvetica",Font.PLAIN,22));
			medium.setFont(new Font("Helvetica",Font.PLAIN,22));
			hard.setFont(new Font("Helvetica",Font.BOLD,22));
			break;
		default:
		}
	}
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		if (this.isVisible()) {
			timer.restart();
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawString(easy.getText(), 0, 0);
		g2d.drawString(medium.getText(), 0, 0);
		g2d.drawString(hard.getText(), 0, 0);
		Toolkit.getDefaultToolkit().sync();
		timer.stop();
		}
	}
	public int getSel() {return sel;}
}
