package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GameScreen extends JPanel {
	//sprite can be changed into ArrayList or other later
	private List<Sprite> sprites;
	private ImageIcon ii = new ImageIcon();
	private HeadsUpDisplay hud;
	@SuppressWarnings("unused")
	private KeyAdapter key;
	private FocusListener f;
	private JLabel message = new JLabel();
	private PauseMenu pause = new PauseMenu();
	
	public GameScreen() {
		Color color = new Color(47,47,48);
		setBackground(color);
		setLayout(null);
		this.add(message);
		this.add(pause);
		message.setBackground(Color.BLACK);
		message.setVisible(false);
		message.setBounds(0, 100, 400, 40);
		message.setFont(new Font("Helvetica",Font.BOLD,16));
		message.setForeground(Color.white);



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
				}
				if(sprite instanceof Entity) {
					Entity x = (Entity) sprite;
					g2d.setColor(Color.blue);
					g2d.drawRect(x.getBounds().getX()+ (int) x.getBounds().getxOff(), x.getBounds().getY() + (int) x.getBounds().getyOff(), (int) x.getBounds().getwidth(),(int) x.getBounds().getheight());
				}if(sprite instanceof PC) {
					PC pC = (PC) sprite;
					if(pC.getattacking()) {
						g2d.drawImage(pC.getSlashim(), (int)( pC.getHitBounds().getX() + pC.getHitBounds().getxOff()), (int) (pC.getHitBounds().getY()+pC.getHitBounds().getyOff()),this);
					}
					g2d.setColor(Color.green);
					g2d.drawRect(pC.getHitBounds().getX() + (int) pC.getHitBounds().getxOff(),(int) pC.getHitBounds().getY()+ (int)pC.getHitBounds().getyOff(), (int)pC.getHitBounds().getwidth(),(int) pC.getHitBounds().getheight());
				}if(sprite instanceof GiantRat) {
					GiantRat rat = (GiantRat) sprite;
					g2d.setColor(Color.green);
					g2d.drawRect(rat.getHitBounds().getX() + (int) rat.getHitBounds().getxOff(),(int) rat.getHitBounds().getY()+ (int)rat.getHitBounds().getyOff(), (int)rat.getHitBounds().getwidth(),(int) rat.getHitBounds().getheight());
				}
			}

		}
		if(hud != null) {
			g2d.drawImage(hud.getInventory().getImage(), HeadsUpDisplay.getInventoryxPos(), HeadsUpDisplay.getInventoryyPos(), this);
			for(int i = 0; i < hud.getInventory().inventorySize(); i++) {
				g2d.drawImage(hud.getInventory().seeItem(i).getInventoryImage(), HeadsUpDisplay.getItemxPos0() + (HeadsUpDisplay.getItemxConst()*i), HeadsUpDisplay.getItemyPos(), this);
			}
			for (int i = 0; i < 6; i++) {
				if (i <= hud.getHealth())
					g2d.drawImage(hud.getHealthAssets(0), HeadsUpDisplay.getHeartxPos0() + (HeadsUpDisplay.getHeartxConst()*i), HeadsUpDisplay.getHeartyPos(), this);
				else
					g2d.drawImage(hud.getHealthAssets(2), HeadsUpDisplay.getHeartxPos0() + (HeadsUpDisplay.getHeartxConst()*i), HeadsUpDisplay.getHeartyPos(), this);
			}
			
		}
		if (this.message.isVisible()) {
			g2d.drawString(message.getText(), 0, 0);
		}
		System.out.println("Pause visible is: "+ pause.isVisible());
		
	}

public void setDrawUI(HeadsUpDisplay hud) {
	this.hud = hud;
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
		System.out.println(message.isVisible());
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
