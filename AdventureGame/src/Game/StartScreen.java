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

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel {
	
	private ScreenListener ButtonListener;
	private java.awt.Image background;
	private Label Title;
	
	public StartScreen() {
		ImageIcon ii = new ImageIcon("src/Image/well_2.png");
		setBackground(ii.getImage());

		
		this.setLayout(null);
		
	
		JButton start;
		start = new JButton("Start");
		start.setBounds(800, 384,200 , 40);
		
		Title = new Label("A Well of Opportunity");
		Title.setFont(new Font("Helvetica",Font.BOLD,48));
		Title.setBounds(250, 50, 500, 60);
		Title.setAlignment(Label.CENTER);
		
		
		ActionListener startButtonActionListener = new ActionListener() {
			@Override 
			public void actionPerformed(ActionEvent e) {
				//if(ButtonListener != null) {
					ButtonListener.actionPerformed();
				//}
			}
		};
		start.addActionListener(startButtonActionListener);
		System.out.println("StartScreen action listener exists: " + startButtonActionListener);
		this.add(Title);
		this.add(start);
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
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 512-400 , 400 - 300, this);
		g2d.drawString(Title.getText(), 0, 0);
		Toolkit.getDefaultToolkit().sync();

	}
}
