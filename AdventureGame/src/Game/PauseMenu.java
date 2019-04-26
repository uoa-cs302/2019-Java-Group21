package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PauseMenu extends JPanel implements ActionListener {
	
	private	 int sel = 0;
	private JLabel Resume;
	public JLabel getResume() {return Resume;}
	public void setResume(JLabel resume) {Resume = resume;	}
	public JLabel getQuit() {return Quit;}
	public void setQuit(JLabel quit) {Quit = quit;}
	private JLabel Quit;
	private Timer timer = new Timer(15,this);
		
	public PauseMenu() {
		this.setBackground(Color.BLACK);
		this.setVisible(false);
		this.setLayout(null);
		this.setBounds(412, 284,200, 200);
		
		Resume = new JLabel();
		Quit = new JLabel();
		Resume.setVisible(true);
		Quit.setVisible(true);
		
		Resume.setText("Resume");
		Resume.setForeground(Color.white);
		Resume.setBounds(0, 0, 200, 100);
		Resume.setAlignmentX(Label.CENTER);
		Quit.setText("Quit");
		Quit.setForeground(Color.white);
		Quit.setAlignmentX(Label.CENTER);
		Quit.setBounds(0, 50, 200, 100);
		Resume.setFont(new Font("Helvetica",Font.BOLD,36));
		Quit.setFont(new Font("Helvetica",Font.PLAIN,36));
		
		this.add(Resume);
		this.add(Quit);
		
	}
	public int getSel() {
		return sel;
	}
	public void setSel(int sel) {
		this.sel = sel;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.isVisible()) {
			timer.restart();
			if(sel == 0) {Resume.setFont(new Font("Helvetica",Font.BOLD,36)); Quit.setFont(new Font("Helvetica",Font.PLAIN,36));}
			else {Resume.setFont(new Font("Helvetica",Font.PLAIN,36)); Quit.setFont(new Font("Helvetica",Font.BOLD,36));}
			g.drawString(Resume.getText(), 0, 0);
			g.drawString(Quit.getText(),0,0);
		}else {timer.stop();}
		Toolkit.getDefaultToolkit().sync();

	}
	public void actionPerformed(ActionEvent e) {
		this.repaint();
	}
}
