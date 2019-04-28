package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameIntro extends JPanel {
	
	private JLabel Title = new JLabel();
	private JLabel story = new JLabel();
	private Image background;
	
	public GameIntro() {
		this.setBackground(Color.black);
		this.setVisible(false);
		this.setLayout(null);
		
		ImageIcon ii = new ImageIcon("src/Image/INTRO.png");
		background = ii.getImage();
		
		Title.setText("The Story so far...");
		Title.setFont(new Font("Helvetica",Font.BOLD,34));
		Title.setVisible(true);
		Title.setAlignmentX(Label.CENTER);
		Title.setBounds(412, 15, 400, 40);
		Title.setForeground(Color.white);
		
		story.setText("<html><p> You are an adventurer exploring the country side. After wandering about a forest you came across an old"
				+ " run down village. A brief inspection of the village revealed it to be abandoned and as such you decided to keep moving on."
				+ " As you are about to leave the outskirts of the village, you hear a child's cries coming from nearby."
				+ "You find the child next to an old well, accompanied by a friendly dog. The child explains their ball has fallen down the well"
				+ "and you being a kind individual of impeccable social standing and of a good moral compass decided to jump down the well and get the "
				+ "ball for them. How bad could it be?</p></html>" );
		story.setFont(new Font("Helvetica",Font.PLAIN,22));
		story.setVisible(true);
		story.setAlignmentX(Label.CENTER);
		story.setBounds(550,50,450,700);
		story.setForeground(Color.white);
		
		this.add(Title);
		this.add(story);
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0,0, this);
		g2d.drawString(story.getText(),0,0);
		Toolkit.getDefaultToolkit().sync();

	}

}
