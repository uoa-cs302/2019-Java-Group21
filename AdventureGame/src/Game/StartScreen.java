package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StartScreen extends JPanel implements ActionListener {
	
	private ScreenListener ButtonListener;
	private java.awt.Image background;
	private JLabel Title;
	private JLabel start;
	private JLabel options;
	private JLabel credit;
	private JLabel Exit;
	private JLabel Control;
	
	private	 int sel = 0;
	private Timer timer = new Timer(15,this);
	
	public StartScreen() {
		ImageIcon ii = new ImageIcon("src/Image/well_2.png");
		setBackground(ii.getImage());

		
		this.setLayout(null);
		
	
		Control = new JLabel();
		Control.setFont(new Font("Helvetica",Font.BOLD,18));
		Control.setBounds(600, 700 ,400 , 40);
		Control.setAlignmentX(Label.CENTER);
		Control.setText("W/S = UP/DOWN | ENTER = ACCEPT");
		
		start = new JLabel();
		start.setFont(new Font("Helvetica",Font.BOLD,22));
		start.setBounds(800, 360,200 , 40);
		start.setAlignmentX(Label.CENTER);
		start.setText("Start");
		
		options = new JLabel();
		options.setFont(new Font("Helvetica",Font.PLAIN,22));
		options.setBounds(800, 420,200 , 40);
		options.setAlignmentX(Label.CENTER);
		options.setText("Options");
		
		credit = new JLabel();
		credit.setFont(new Font("Helvetica",Font.PLAIN,22));
		credit.setBounds(800, 480,200 , 40);
		credit.setAlignmentX(Label.CENTER);
		credit.setText("Credits");
		
		Exit = new JLabel();
		Exit.setFont(new Font("Helvetica",Font.PLAIN,22));
		Exit.setBounds(800, 540,200 , 40);
		Exit.setAlignmentX(Label.CENTER);
		Exit.setText("Exit");
		
		Title = new JLabel("A Well of Opportunity");
		Title.setFont(new Font("Helvetica",Font.BOLD,48));
		Title.setBounds(250, 50, 500, 60);
		Title.setAlignmentX(Label.CENTER);
		
		this.add(Title);
		this.add(start);
		this.add(Control);
		this.add(options);
		this.add(credit);
		this.add(Exit);
		}
	public void setButtonListener(ScreenListener sl) {
		this.ButtonListener = sl;
	}
	public java.awt.Image getbackground() {
		return background;
	}
	public void setBackground(java.awt.Image background) {
		this.background = background;
	}
	public void changeSel(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {sel --;}
		if(e.getKeyCode() == KeyEvent.VK_S)	{sel ++;}
		
		if(sel < 0) {sel = 3;}
		if(sel > 3)	{sel = 0;}
		
		switch (sel) {
		case 0:
			start.setFont(new Font("Helvetica",Font.BOLD,22));
			options.setFont(new Font("Helvetica",Font.PLAIN,22));
			credit.setFont(new Font("Helvetica",Font.PLAIN,22));
			Exit.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 1:
			start.setFont(new Font("Helvetica",Font.PLAIN,22));
			options.setFont(new Font("Helvetica",Font.BOLD,22));
			credit.setFont(new Font("Helvetica",Font.PLAIN,22));
			Exit.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 2:
			start.setFont(new Font("Helvetica",Font.PLAIN,22));
			options.setFont(new Font("Helvetica",Font.PLAIN,22));
			credit.setFont(new Font("Helvetica",Font.BOLD,22));
			Exit.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 3:
			start.setFont(new Font("Helvetica",Font.PLAIN,22));
			options.setFont(new Font("Helvetica",Font.PLAIN,22));
			credit.setFont(new Font("Helvetica",Font.PLAIN,22));
			Exit.setFont(new Font("Helvetica",Font.BOLD,22));
			break;
		default:
			System.out.println("big oof");
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
		g2d.drawImage(background, 512-400 , 400 - 300, this);
		g2d.drawString(Title.getText(), 0, 0);
		g2d.drawString(start.getText(), 0, 0);
		g2d.drawString(options.getText(), 0, 0);
		g2d.drawString(credit.getText(), 0, 0);
		g2d.drawString(Exit.getText(), 0, 0);
		g2d.drawString(Title.getText(), 0, 0);
		Toolkit.getDefaultToolkit().sync();
		timer.stop();
		}

	}
	public int getSel() {return sel;}
}
