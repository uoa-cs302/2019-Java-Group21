package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

public class GameOverScreen extends JPanel {
	
	private int timercount=0;
	private int killcount=0;
	private int score = 0;
	private boolean completed = false;
	private JLabel Kills = new JLabel();
	private JLabel Time = new JLabel();
	private JLabel Score= new JLabel();
	private JLabel Title = new JLabel();
	private JLabel Exit = new JLabel();
	private JTextField name = new JTextField();
	private java.awt.Image background;
	
	public GameOverScreen() {
		this.setBackground(Color.BLACK);
		this.setVisible(false);
		this.setLayout(null);
		
		ImageIcon ii = new ImageIcon("src/Image/INTRO.png");
		background = ii.getImage();
		
		
		Kills.setForeground(Color.white);
		Kills.setFont(new Font("Helvetica",Font.BOLD,22));
		Kills.setBounds(512,100,512,75);
		Kills.setVisible(true);
		Kills.setAlignmentX(Label.CENTER);
		
		Time.setForeground(Color.white);
		Time.setFont(new Font("Helvetica",Font.BOLD,22));
		Time.setBounds(512,175,512,75);
		Time.setVisible(true);
		Time.setAlignmentX(Label.CENTER);
		
		
		Score.setForeground(Color.white);
		Score.setFont(new Font("Helvetica",Font.BOLD,22));
		Score.setBounds(512,250,512,75);
		Score.setVisible(true);
		Score.setAlignmentX(Label.CENTER);
		
		Title.setText("Game Over");
		Title.setForeground(Color.white);
		Title.setFont(new Font("Helvetica",Font.BOLD,32));
		Title.setBounds(512,25,512,75);
		Title.setVisible(true);
		Title.setAlignmentX(Label.CENTER);
		
		Exit.setText("Press Enter to return to Main Menu");
		Exit.setForeground(Color.white);
		Exit.setFont(new Font("Helvetica",Font.BOLD,32));
		Exit.setBounds(0,650,1024,68);
		Exit.setVisible(true);
		Exit.setAlignmentX(Label.CENTER);
		
		this.add(Title);
		this.add(Kills);
		this.add(Time);
		this.add(Score);
		this.add(Exit);
		this.add(name);
		
		
		
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0 ,0, this);
		g2d.drawString(Title.getText(), 0, 0);
		g2d.drawString(Kills.getText(), 0, 0);
		g2d.drawString(Time.getText(), 0, 0);
		g2d.drawString(Score.getText(), 0, 0);
		g2d.drawString(Exit.getText(), 0, 0);
		g2d.drawString(name.getText(), 0, 0);
		Toolkit.getDefaultToolkit().sync();

	}
	public void calculateScore(int kill,int time) {
		killcount = kill * 5;
		timercount = (300 - time)*10;
		score = killcount + timercount;
		if (completed) { score += 250;}
		Kills.setText("You defeated "+kill+" enemies!");
		Time.setText("This time took you only "+ time +" seconds");
		Score.setText("Your score is " + score + " Congratulations!");
		
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public int getScore() {
		return this.score;
	}

}
