import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class TitleScreen extends Screen implements ActionListener {

	//private Image titleImg;
	
	private AllScreen as;
	//private int t;
	
	//private Image nyanCat;
	private int xPos, yPos;

	public TitleScreen(AllScreen as) {
		this.as = as;
		//titleImg = (new ImageIcon("FlingTitleScreen.png").getImage());
		//nyanCat = (new ImageIcon("poptart.gif").getImage());
		
		//t = 0;
		//Timer clock = new Timer(30, this);
		//clock.start();
		//xPos = -200;
		//yPos = 75;
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		//g.drawImage(titleImg, 0, 0, 800, 600, this);
		
		//if (xPos > 1000) {
			//xPos = -200;
		//}
		
		//g.drawImage(nyanCat, xPos, yPos, 200, 150, this);

		Font newFont = new Font("Arial", Font.BOLD, 20);
		g.setFont(newFont);
		g.drawString("The Social Distancing Game", 185, 50);
		
		g.setColor(new Color(192,192,19));
		g2.fillRoundRect(180, 330, 100, 50, 30, 30);
		g.setColor(new Color(0,0,0));
		g.drawString("Start!",180, 330);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if(xClick >= 180 && xClick <= 280 && yClick >= 330 && yClick <= 380) {
			as.changeScreen("Results"); // change later
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}


}