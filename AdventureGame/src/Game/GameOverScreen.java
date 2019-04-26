package Game;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverScreen extends JPanel {
	
	private int timercount;
	private int killcount;
	private int score;
	private boolean completed = false;
	private JLabel Kills = new JLabel();
	private JLabel Time = new JLabel();
	private JLabel Score= new JLabel();
	private JLabel Title = new JLabel();
	
	public GameOverScreen() {
		this.setBackground(Color.BLACK);
		
	}

	public int getTimercount() {
		return timercount;
	}

	public void setTimercount(int timercount) {
		this.timercount = timercount;
	}

	public int getKillcount() {
		return killcount;
	}

	public void setKillcount(int killcount) {
		this.killcount = killcount;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
