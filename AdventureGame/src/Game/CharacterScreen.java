package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CharacterScreen extends JPanel implements ActionListener {

	private List<BufferedImage> hat;
	private List<BufferedImage> hair;
	private List<BufferedImage> head;
	private List<BufferedImage> body;
	private List<BufferedImage> arms;
	private List<BufferedImage> legs;
	private List<BufferedImage> feet;

	private int action;

	private int hatIndex = 0;
	private int hairIndex = 0;
	private int headIndex = 0;
	private int bodyIndex = 0;
	private int armsIndex = 0;
	private int legsIndex = 0;
	private int feetIndex = 0;

	private int select;
	
	private Timer timer = new Timer(15,this);

	public CharacterScreen() {
		this.setBackground(Color.black);
		this.setVisible(false);
		this.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.repaint();

	}

	public void changeSel(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {select--;}
		if(e.getKeyCode() == KeyEvent.VK_S)	{select++;}
		if(e.getKeyCode() == KeyEvent.VK_D) {action = 1;}
		if(e.getKeyCode() == KeyEvent.VK_A)	{action = -1;}

		if(select < 0)
			select = 6;
		else if (select > 6)
			select = 0;

		switch (select) {
		case 0:
			hatIndex += action;
			if(hatIndex < 6)
				hatIndex = 15;
			else if (hatIndex > 15)
				hatIndex = 6;
			break;
		case 1:
			hairIndex += action;
			if(hairIndex < 80)
				hairIndex = 159;
			else if (hairIndex > 159)
				hairIndex = 80;
			break;
		case 2:
			headIndex += action;
			if(headIndex < 5)
				headIndex = 9;
			else if (headIndex > 9)
				headIndex = 5;
			break;
		case 3:
			bodyIndex += action;
			if(bodyIndex < 6)
				bodyIndex = 11;
			else if (bodyIndex > 11)
				bodyIndex = 6;
			break;
		case 4:
			armsIndex += action;
			if(armsIndex < 10)
				armsIndex = 19;
			else if (armsIndex > 19)
				armsIndex = 10;
			break;
		case 5:
			legsIndex += action;
			if(legsIndex < 26)
				legsIndex = 30;
			else if (legsIndex > 30)
				legsIndex = 26;
			break;
		case 6:
			feetIndex += action;
			if(feetIndex < 26)
				feetIndex = 30;
			else if (feetIndex > 30)
				feetIndex = 26;
			break;
		default:
			System.out.println("big oof");
		}	
	}

	@Override
	public void paintComponent(Graphics g) {
		if (this.isVisible()) {
			timer.restart();
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			//g2d.drawImage(background, 512-400 , 400 - 300, this);
			g2d.drawImage(feet.get(feetIndex), 512, 300, this);
			g2d.drawImage(legs.get(legsIndex), 512, 300, this);
			g2d.drawImage(arms.get(armsIndex), 512, 300, this);
			g2d.drawImage(body.get(bodyIndex), 512, 300, this);
			g2d.drawImage(head.get(headIndex), 512, 300, this);
			g2d.drawImage(hair.get(hairIndex), 512, 300, this);
			g2d.drawImage(hat.get(hatIndex), 512, 300, this);
			Toolkit.getDefaultToolkit().sync();
			timer.stop();
		}
	}
	
	public void setImages(List<BufferedImage> hat, List<BufferedImage> hair, List<BufferedImage> head, List<BufferedImage> body, List<BufferedImage> arms, List<BufferedImage> legs, List<BufferedImage> feet) {
		this.hat = hat;
		this.hair = hair;
		this.head = head;
		this.body = body;
		this.arms = arms;
		this.legs = legs;
		this.feet = feet;
	}
}
