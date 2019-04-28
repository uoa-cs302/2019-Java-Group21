package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreScreen extends JPanel {
	
	private String HighScores = "src/HighScores";
	private JLabel Title = new JLabel();
	private JLabel HighScore = new JLabel();
	
	public ScoreScreen() {
		this.setBackground(Color.DARK_GRAY);
		this.setVisible(false);
		this.setLayout(null);
		
		Title.setText("HighScores");
		Title.setFont(new Font("Helvetica",Font.BOLD,34));
		Title.setVisible(true);
		Title.setAlignmentX(Label.CENTER);
		Title.setBounds(412, 15, 400, 40);
		Title.setForeground(Color.white);
		
		HighScore.setText("HighScore: ");
		HighScore.setFont(new Font("Helvetica",Font.BOLD,34));
		HighScore.setVisible(true);
		HighScore.setAlignmentX(Label.CENTER);
		HighScore.setBounds(412, 15, 400, 40);
		HighScore.setForeground(Color.white);
		add(Title);
		add(HighScore);
	}
	@SuppressWarnings("unused")
	public void saveScore(int score) throws IOException {
		
	PrintWriter writer = new PrintWriter("src/HighScores"); 
	writer.write(Integer.toString(score));
		
	}
	
	@SuppressWarnings("unused")
	public void getScore() throws Exception {
		File f = new File("src/HighScores.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String st;
		st = br.readLine();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(Title.getText(),0,0);
		g.drawString(HighScore.getText(),0,0);
		Toolkit.getDefaultToolkit().sync();

	}
}
