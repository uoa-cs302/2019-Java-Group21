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
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GameScreen extends JPanel {
	//sprite can be changed into ArrayList or other later
	private List<Sprite> sprites;
	private ImageIcon ii = new ImageIcon();
	private Inventory inventory;
	@SuppressWarnings("unused")
	private KeyAdapter key;
	private FocusListener f;
	private JTextField message = new JTextField();
	public GameScreen() {
		Color color = new Color(47,47,48);
		setBackground(color);
		setLayout(null);
		this.add(message);
		message.setBackground(Color.BLACK);
		message.setVisible(false);
		message.setEditable(false);
		message.setBounds(0, 100, 400, 40);
		message.setFont(new Font("Helvetica",Font.BOLD,16));
			
		
		
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
					g2d.drawImage(sprite.getImage(), sprite.getx_pos(), sprite.gety_pos(),this);
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
		if(inventory != null) {
			g2d.drawImage(inventory.getImage(), 128, 600, this);
			for(int i = 0; i < inventory.inventorySize(); i++) {
				g2d.drawImage(inventory.seeItem(i).getInventoryImage(), 138 + (96*i), 613, this);
			}
		}
		if (this.message.isVisible()) {
			g2d.drawString(message.getText(), 0, 0);
		}
	}
	
	public void setDrawUI(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void setDrawTarget(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	//may not be used atm
	public void updateScreen() {
		repaint();
	}
	
	public JTextField getMessage() {
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


}
