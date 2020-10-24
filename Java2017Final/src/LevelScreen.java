import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class LevelScreen extends Screen {

	private Image level0, level1, level2, level3, level4, level5;
	private AllScreen as;

	public LevelScreen(AllScreen as) {
		this.as = as;
		
		level0 = (new ImageIcon("Nyan-cat.png").getImage());
		level1 = (new ImageIcon("pusheen1.png").getImage());
		level2 = (new ImageIcon("pusheen2.png").getImage());
		level3 = (new ImageIcon("pusheen3.png").getImage());
		level4 = (new ImageIcon("pusheen4.png").getImage());
		level5 = (new ImageIcon("cheesecakeImg.png").getImage());		
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.BLACK);
		
		Font newFont = new Font("Arial", Font.PLAIN, 20);
		g.setFont(newFont);
		g.drawImage(level0, 25, 400, 110, 80, this);
		g.drawString("Level 0", 35, 500);
		g.drawImage(level1, 50, 200, 200, 150, this);
		g.drawString("Level 1", 100, 300);
		g.drawImage(level2, 180, 55, 200, 210, this);
		g.drawString("Level 2", 228, 180);
		g.drawImage(level3, 250, 400, 200, 150, this);
		g.drawString("Level 3", 320, 475);
		g.drawImage(level4, 390, 230, 200, 180, this);
		g.drawString("Level 4", 440, 355); 
		g.drawImage(level5, 550, 120, 200, 150, this);
		g.drawString("Level 5", 630, 225);

	}
	
	

	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();
		boolean isSelected = false;

		if(xClick>=50 && xClick<=250 && yClick>=200 && yClick<=350){
			AllScreen.LEVEL = 1;		
			isSelected = true;
		}
		else if(xClick>=180 && xClick<=380 && yClick>=100 && yClick<=220){
			AllScreen.LEVEL = 2;
			isSelected = true;
		}
		else if(xClick>=250 && xClick<=450 && yClick>=415 && yClick<=650){
			AllScreen.LEVEL = 3;
			isSelected = true;
		}
		else if(xClick>=400 && xClick<=580 && yClick>=240 && yClick<= 390){
			AllScreen.LEVEL = 4;		
			isSelected = true;

		}
		else if(xClick>=565 && xClick<= 750 && yClick>=130 && yClick<=270){
			AllScreen.LEVEL = 5;
			isSelected = true;
		}
		else if(xClick>=25 && xClick<=135 && yClick>=400 && yClick<=480) {
			AllScreen.LEVEL = 0;
			isSelected = true;
		}

		as.panel.setLevel(AllScreen.LEVEL);
		
		if (isSelected){
			as.changeScreen("Game");
			
			// System.out.println(AllScreen.LEVEL + "");
		}
		
		
	}
}