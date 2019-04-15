package Game;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartScreen extends JPanel {
	
	private ScreenListener ButtonListener;
	
	public StartScreen() {

		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWeights = new double[] {0.0};
		gbl.rowWeights = new double[] {0.0,0.0};
		this.setLayout(gbl);
	
		JButton start;
		start = new JButton("Start");
		
		
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
		this.add(start);
		}
	public void setButtonListener(ScreenListener sl) {
		this.ButtonListener = sl;
	}
}
