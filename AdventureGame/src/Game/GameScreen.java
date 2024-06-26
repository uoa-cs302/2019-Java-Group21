package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class GameScreen extends JPanel {
	//sprite can be changed into ArrayList or other later
	private List<Sprite> sprites;
	private HeadsUpDisplay hud;
	@SuppressWarnings("unused")
	private KeyAdapter key;
	private JLabel message = new JLabel();
	private PauseMenu pause = new PauseMenu();
	private JLabel Timer = new JLabel();
	private JLabel Score = new JLabel();

	public GameScreen() {
		Color color = new Color(47,47,48);
		setBackground(color);
		setLayout(null);
		this.add(message);
		this.add(pause);
		this.add(Timer);
		this.add(Score);
		message.setBackground(Color.BLACK);
		message.setVisible(false);
		message.setBounds(0, 100, 400, 40);
		message.setFont(new Font("Helvetica",Font.BOLD,16));
		message.setForeground(Color.white);

		Timer.setVisible(true);
		Timer.setBounds(800,15 , 200, 35);
		Timer.setFont(new Font("Helvetica",Font.BOLD,16));
		Timer.setForeground(Color.WHITE);

		Score.setVisible(true);
		Score.setBounds(800,50 , 200, 35);
		Score.setFont(new Font("Helvetica",Font.BOLD,16));
		Score.setForeground(Color.WHITE);



	}
	//paints Sprites
	@Override

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doEntityDrawing(g);
		Toolkit.getDefaultToolkit().sync();

	}
	//draws image
	public void doEntityDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		if (sprites != null) {
			for (Sprite sprite : sprites) {

				if(sprite.isVisible() && sprite.getImage() != null) {
					g2d.drawImage(sprite.getImage(), (int)sprite.getx_pos(), (int)sprite.gety_pos(),this);
				
				}if(sprite instanceof PC) {
					PC pC = (PC) sprite;
					if(pC.getattacking()) {
						g2d.drawImage(pC.getSlashim(), (int)( pC.getHitBounds().getX() + pC.getHitBounds().getxOff()), (int) (pC.getHitBounds().getY()+pC.getHitBounds().getyOff()),this);
					}
					
			}

		}
		if(hud != null) {
			g2d.drawImage(hud.getInventory().getImage(), HeadsUpDisplay.getInventoryxPos(), HeadsUpDisplay.getInventoryyPos(), this);
			for(int i = 0; i < hud.getInventory().inventorySize(); i++) {
				g2d.drawImage(hud.getInventory().seeItem(i).getInventoryImage(), HeadsUpDisplay.getItemxPos0() + (HeadsUpDisplay.getItemxConst()*i), HeadsUpDisplay.getItemyPos(), this);
			}
			for (int i = 0; i < 6; i++) {
				if (i  < hud.getHealth())
					g2d.drawImage(hud.getHealthAssets(0), HeadsUpDisplay.getHeartxPos0() + (HeadsUpDisplay.getHeartxConst()*i), HeadsUpDisplay.getHeartyPos(), this);
				else
					g2d.drawImage(hud.getHealthAssets(2), HeadsUpDisplay.getHeartxPos0() + (HeadsUpDisplay.getHeartxConst()*i), HeadsUpDisplay.getHeartyPos(), this);
			}

		}
		if (this.message.isVisible()) {
			g2d.drawString(message.getText(), 0, 0);
		}
		if (Timer.isVisible()) {
			g2d.drawString(Timer.getText(), 0,0);
		}
		if (Score.isVisible()) {
			g2d.drawString(Score.getText(), 0, 0);
		}
	}
	}

	public void setDrawUI(HeadsUpDisplay hud) {
		this.hud = hud;
	}
	public void updateTimer(int Count) {
		int min10;
		int sec10;
		int min;
		int sec;
		min = Count / 60;
		min10 = Count / 600;
		sec10 = (Count / 10)% 6;
		sec = Count % 10;

		Timer.setText("Timer elapsed: " +min10 + min + " : "+sec10 + sec);
	}
	public void updateScore(int time, int kills) {
		int score = (kills*5);
		Score.setText("Score: " + score +" + time bonus!");
	}

	public void setDrawTarget(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	//may not be used atm
	public void updateScreen() {
		repaint();
	}

	public JLabel getMessage() {
		return this.message;
	}

	public void drawMessage(String s) {
		switch (s) {
		case "block":
			message.setVisible(true);
			message.setText("Looks like you could break this");
			message.repaint();
			break;
		}

	}
	public PauseMenu getpause() {
		return pause;
	}
	public void drawPauseMenu() {
		pause.setVisible(true);
		pause.repaint();
	}


}
