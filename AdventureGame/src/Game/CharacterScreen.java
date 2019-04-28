package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CharacterScreen extends JPanel implements ActionListener {

	private List<BufferedImage> hair;
	private List<BufferedImage> head;
	private List<BufferedImage> body;
	private List<BufferedImage> arms;
	private List<BufferedImage> legs;
	private List<BufferedImage> feet;

	private int action;

	private int hairIndex = 80;
	private int headIndex = 5;
	private int bodyIndex = 6;
	private int armsIndex = 10;
	private int legsIndex = 24;
	private int feetIndex = 24;
	
	private boolean finished;

	private int select=0;	
	
	private JLabel hairLabel;
	private JLabel headLabel;
	private JLabel armsLabel;
	private JLabel bodyLabel;
	private JLabel legsLabel;
	private JLabel feetLabel;
	private JLabel random;
	private JLabel done;

	private Timer timer = new Timer(15,this);

	public CharacterScreen() {
		this.setVisible(false);
		this.setLayout(null);
	
		finished = false;
		
		hairLabel = new JLabel();
		hairLabel.setFont(new Font("Helvetica",Font.BOLD,22));
		hairLabel.setBounds(450, 240, 200, 40);
		hairLabel.setAlignmentX(Label.CENTER);
		hairLabel.setText("Hair");
		
		headLabel = new JLabel();
		headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
		headLabel.setBounds(450, 270, 200, 40);
		headLabel.setAlignmentX(Label.CENTER);
		headLabel.setText("Head");
		
		bodyLabel = new JLabel();
		bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
		bodyLabel.setBounds(450, 300, 200, 40);
		bodyLabel.setAlignmentX(Label.CENTER);
		bodyLabel.setText("Body");
		
		armsLabel = new JLabel();
		armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
		armsLabel.setBounds(450, 330, 200, 40);
		armsLabel.setAlignmentX(Label.CENTER);
		armsLabel.setText("Arms");
		
		legsLabel = new JLabel();
		legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
		legsLabel.setBounds(450, 360, 200, 40);
		legsLabel.setAlignmentX(Label.CENTER);
		legsLabel.setText("Legs");
		
		feetLabel = new JLabel();
		feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
		feetLabel.setBounds(450, 390, 200, 40);
		feetLabel.setAlignmentX(Label.CENTER);
		feetLabel.setText("Feet");
		
		random = new JLabel();
		random.setFont(new Font("Helvetica",Font.PLAIN,22));
		random.setBounds(490, 450, 200, 40);
		random.setAlignmentX(Label.CENTER);
		random.setText("Randomise");
		
		done = new JLabel();
		done.setFont(new Font("Helvetica",Font.PLAIN,22));
		done.setBounds(490, 510, 200, 40);
		done.setAlignmentX(Label.CENTER);
		done.setText("Done");
		
		this.add(hairLabel);
		this.add(headLabel);
		this.add(bodyLabel);
		this.add(armsLabel);
		this.add(legsLabel);
		this.add(feetLabel);
		this.add(random);
		this.add(done);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.repaint();

	}

	public void changeSel(KeyEvent e) {
		System.out.println("index = " + select);
		System.out.println(legs.size());
		System.out.println(feet.size());
		if(e.getKeyCode() == KeyEvent.VK_W) {select--;}
		if(e.getKeyCode() == KeyEvent.VK_S)	{select++;}
		if(e.getKeyCode() == KeyEvent.VK_D) {action = 1;}
		if(e.getKeyCode() == KeyEvent.VK_A)	{action = -1;}

		if(select < 0)
			select = 7;
		else if (select > 7)
			select = 0;

		switch (select) {
		case 0:
			hairIndex += action;
			if(hairIndex < 80)
				hairIndex = 159;
			else if (hairIndex > 159)
				hairIndex = 80;
			hairLabel.setFont(new Font("Helvetica",Font.BOLD,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 1:
			headIndex += action;
			if(headIndex < 5)
				headIndex = 9;
			else if (headIndex > 9)
				headIndex = 5;
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.BOLD,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 2:
			bodyIndex += action;
			if(bodyIndex < 6)
				bodyIndex = 11;
			else if (bodyIndex > 11)
				bodyIndex = 6;
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.BOLD,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 3:
			armsIndex += action;
			if(armsIndex < 10)
				armsIndex = 19;
			else if (armsIndex > 19)
				armsIndex = 10;
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.BOLD,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 4:
			legsIndex += action;
			if(legsIndex < 24)
				legsIndex = 29;
			else if (legsIndex > 29)
				legsIndex = 24;
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.BOLD,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 5:
			feetIndex += action;
			if(feetIndex < 24)
				feetIndex = 29;
			else if (feetIndex > 29)
				feetIndex = 24;
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.BOLD,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 6:
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.BOLD,22));
			done.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 7:
			hairLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			headLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			bodyLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			armsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			legsLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			feetLabel.setFont(new Font("Helvetica",Font.PLAIN,22));
			random.setFont(new Font("Helvetica",Font.PLAIN,22));
			done.setFont(new Font("Helvetica",Font.BOLD,22));
			break;
		default:
			System.out.println("big oof");
		}	
		action = 0;
	}

	@Override
	public void paintComponent(Graphics g) {
		this.timer.restart();
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
			Toolkit.getDefaultToolkit().sync();
			System.out.println("repainting");
		}else {
			this.timer.stop();
		}
	}

	public void setImages(List<BufferedImage> hair, List<BufferedImage> head, List<BufferedImage> body, List<BufferedImage> arms, List<BufferedImage> legs, List<BufferedImage> feet) {
		this.hair = hair;
		this.head = head;
		this.body = body;
		this.arms = arms;
		this.legs = legs;
		this.feet = feet;
	}

	public int getSelect() {
		return this.select;
	}

	public void createCharacter() {
		BufferedImage player = new BufferedImage(120, 160, BufferedImage.TYPE_INT_ARGB);
		Graphics g = player.getGraphics();
		if (feet == null)
			System.out.println("null");
		g.drawImage(feet.get(feetIndex + 6), 0, 0, null);
		g.drawImage(legs.get(legsIndex + 6), 0, 0, null);
		g.drawImage(arms.get(armsIndex), 0, 0, null);
		g.drawImage(body.get(bodyIndex), 0, 0, null);
		g.drawImage(head.get(headIndex), 0, 0, null);
		g.drawImage(hair.get(hairIndex), 0, 0, null);
		g.drawImage(feet.get(feetIndex), 40, 0, null);
		g.drawImage(legs.get(legsIndex), 40, 0, null);
		g.drawImage(arms.get(armsIndex), 40, 0, null);
		g.drawImage(body.get(bodyIndex), 40, 0, null);
		g.drawImage(head.get(headIndex), 40, 0, null);
		g.drawImage(hair.get(hairIndex), 40, 0, null);
		g.drawImage(feet.get(feetIndex - 6), 80, 0, null);
		g.drawImage(legs.get(legsIndex - 6), 80, 0, null);
		g.drawImage(arms.get(armsIndex), 80, 0, null);
		g.drawImage(body.get(bodyIndex), 80, 0, null);
		g.drawImage(head.get(headIndex), 80, 0, null);
		g.drawImage(hair.get(hairIndex), 80, 0, null);

		g.drawImage(flipImage(feet.get(feetIndex + 12)), 0, 40, null);
		g.drawImage(flipImage(legs.get(legsIndex + 12)), 0, 40, null);
		g.drawImage(flipImage(arms.get(armsIndex + 10)), 0, 40, null);
		g.drawImage(flipImage(body.get(bodyIndex + 6)), 0, 40, null);
		g.drawImage(flipImage(head.get(headIndex + 5)), 0, 40, null);
		g.drawImage(flipImage(hair.get(hairIndex + 80)), 0, 40, null);
		g.drawImage(flipImage(feet.get(feetIndex + 18)), 40, 40, null);
		g.drawImage(flipImage(legs.get(legsIndex + 18)), 40, 40, null);
		g.drawImage(flipImage(arms.get(armsIndex + 10)), 40, 40, null);
		g.drawImage(flipImage(body.get(bodyIndex + 6)), 40, 40, null);
		g.drawImage(flipImage(head.get(headIndex + 5)), 40, 40, null);
		g.drawImage(flipImage(hair.get(hairIndex + 80)), 40, 40, null);
		g.drawImage(flipImage(feet.get(feetIndex + 24)), 80, 40, null);
		g.drawImage(flipImage(legs.get(legsIndex + 24)), 80, 40, null);
		g.drawImage(flipImage(arms.get(armsIndex + 10)), 80, 40, null);
		g.drawImage(flipImage(body.get(bodyIndex + 6)), 80, 40, null);
		g.drawImage(flipImage(head.get(headIndex + 5)), 80, 40, null);
		g.drawImage(flipImage(hair.get(hairIndex + 80)), 80, 40, null);

		g.drawImage(feet.get(feetIndex + 12), 0, 80, null);
		g.drawImage(legs.get(legsIndex + 12), 0, 80, null);
		g.drawImage(arms.get(armsIndex + 10), 0, 80, null);
		g.drawImage(body.get(bodyIndex + 6), 0, 80, null);
		g.drawImage(head.get(headIndex + 5), 0, 80, null);
		g.drawImage(hair.get(hairIndex + 80), 0, 80, null);
		g.drawImage(feet.get(feetIndex + 18), 40, 80, null);
		g.drawImage(legs.get(legsIndex + 18), 40, 80, null);
		g.drawImage(arms.get(armsIndex + 10), 40, 80, null);
		g.drawImage(body.get(bodyIndex + 6), 40, 80, null);
		g.drawImage(head.get(headIndex + 5), 40, 80, null);
		g.drawImage(hair.get(hairIndex + 80), 40, 80, null);
		g.drawImage(feet.get(feetIndex + 24), 80, 80, null);
		g.drawImage(legs.get(legsIndex + 24), 80, 80, null);
		g.drawImage(arms.get(armsIndex + 10), 80, 80, null);
		g.drawImage(body.get(bodyIndex + 6), 80, 80, null);
		g.drawImage(head.get(headIndex + 5), 80, 80, null);
		g.drawImage(hair.get(hairIndex + 80), 80, 80, null);

		g.drawImage(feet.get(feetIndex - 12), 0, 120, null);
		g.drawImage(legs.get(legsIndex - 12), 0, 120, null);
		g.drawImage(arms.get(armsIndex - 10), 0, 120, null);
		g.drawImage(body.get(bodyIndex - 6), 0, 120, null);
		g.drawImage(head.get(headIndex - 5), 0, 120, null);
		g.drawImage(hair.get(hairIndex - 80), 0, 120, null);
		g.drawImage(feet.get(feetIndex - 18), 40, 120, null);
		g.drawImage(legs.get(legsIndex - 18), 40, 120, null);
		g.drawImage(arms.get(armsIndex - 10), 40, 120, null);
		g.drawImage(body.get(bodyIndex - 6), 40, 120, null);
		g.drawImage(head.get(headIndex - 5), 40, 120, null);
		g.drawImage(hair.get(hairIndex - 80), 40, 120, null);
		g.drawImage(feet.get(feetIndex - 24), 80, 120, null);
		g.drawImage(legs.get(legsIndex - 24), 80, 120, null);
		g.drawImage(arms.get(armsIndex - 10), 80, 120, null);
		g.drawImage(body.get(bodyIndex - 6), 80, 120, null);
		g.drawImage(head.get(headIndex - 5), 80, 120, null);
		g.drawImage(hair.get(hairIndex - 80), 80, 120, null);
		try {
			ImageIO.write(player, "PNG", new File("src/Image/", "player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		select = 0;
	}
	
	public void randomise() {
		Random rand = new Random();
		int n = rand.nextInt(79) + 80;
		hairIndex = n;
		n = rand.nextInt(4) + 5;
		headIndex = n;
		n = rand.nextInt(5) + 6;
		bodyIndex = n;
		n = rand.nextInt(9) + 10;
		armsIndex = n;
		n = rand.nextInt(5) + 24;
		legsIndex = n;
		n = rand.nextInt(5) + 24;
		feetIndex = n;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public BufferedImage flipImage(BufferedImage image) {
		BufferedImage flip = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		flip = op.filter(image, null);
		return flip;
	}
}
