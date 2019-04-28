package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CharacterScreen extends JPanel implements ActionListener {
	
	private JLabel Title;
	private List<BufferedImage> hat;
	private List<BufferedImage> hair;
	private List<BufferedImage> head;
	private List<BufferedImage> body;
	private List<BufferedImage> arms;
	private List<BufferedImage> legs;
	private List<BufferedImage> feet;
	
	private int action;
	
	private int hatIndex;
	private int hairIndex;
	private int headIndex;
	private int bodyIndex;
	private int armsIndex;
	private int legsIndex;
	private int feetIndex;
	
	private int select;
	
	public CharacterScreen() {
		this.setBackground(Color.black);
		this.setVisible(false);
		this.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeSel(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) {select--;}
		if(e.getKeyCode() == KeyEvent.VK_S)	{select++;}
		if(e.getKeyCode() == KeyEvent.VK_W) {action = 1;}
		if(e.getKeyCode() == KeyEvent.VK_S)	{action = -1;}
		
		if(select < 0)
			select = 7;
		else if (select > 7)
			select = 0;
		
		switch (select) {
		case 0:
			hatIndex++;
			break;
		case 1:
			start.setFont(new Font("Helvetica",Font.PLAIN,22));
			character.setFont(new Font("Helvetica",Font.BOLD,22));
			credit.setFont(new Font("Helvetica",Font.PLAIN,22));
			Exit.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 2:
			start.setFont(new Font("Helvetica",Font.PLAIN,22));
			character.setFont(new Font("Helvetica",Font.PLAIN,22));
			credit.setFont(new Font("Helvetica",Font.BOLD,22));
			Exit.setFont(new Font("Helvetica",Font.PLAIN,22));
			break;
		case 3:
			start.setFont(new Font("Helvetica",Font.PLAIN,22));
			character.setFont(new Font("Helvetica",Font.PLAIN,22));
			credit.setFont(new Font("Helvetica",Font.PLAIN,22));
			Exit.setFont(new Font("Helvetica",Font.BOLD,22));
			break;
		default:
			System.out.println("big oof");
		}
	}

}
