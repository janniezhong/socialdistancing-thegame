package Screens;

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import Components.Player;
import GameManagement.*;


public class ResultScreen extends Screen {

	private Image deadBody;
	private Image background;
	//private int score = 1;
	//private int time = 60;
	//private Image starImg;
	//private Image shelbyFace;
	private AllScreen as;
	private GameScreen gs;
	//private TimeTracker timeTracker;
	//private Player player;
	// private boolean isDead;

	public ResultScreen(AllScreen as) {
		this.as = as;

		deadBody = (new ImageIcon("divhacks/assets/dead.png").getImage());
		background = (new ImageIcon("divhacks/assets/warning.png").getImage());
		gs = as.panel;
		
		//player = as.panel.getPlayer();
		//timeTracker = new TimeTracker();

		//time = timeTracker.getTime();
		// isDead = character.getHasDied();

		// if ((character.getHasHitTarget())) {
		// score = 5;
		// }
		//
		// if(character.getHasDied())
		// score = 0;
		// else if(time > 180)
		// score = 1;
		// else if(time>90 && time<=180)
		// score = 2;
		// else if(time>60 && time<=90)
		// score = 3;
		// else if(time>30 && time <= 60)
		// score = 4;
		// else // ((time>0 && time<= 30))
		// score = 5;
//		System.out.println(as.panel.getHasHitTarget()+ "");

	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g.setColor(new Color(7, 1, 43));
		g2.fillRect(0,0,800,800);

		g.drawImage(background, 0, -100, 800, 800, this);
		g.drawImage(deadBody, 265, 150, 289, 277, this);

		Font newFont = new Font("Arial Narrow", Font.BOLD, 35);
		g.setFont(newFont);
		g.setColor(Color.RED);
		g.drawString("YOU DIED!", 350, 100);

		g.setColor(Color.WHITE);
		g.drawString("Your score is " + GameScreen.score, 250, 550);

		g.setColor(new Color(192,192,192));
		g2.fillRoundRect(325, 600, 150, 50, 30, 30);
		g2.fillRoundRect(350, 660, 100, 50, 30, 30);

		g.setColor(new Color(192,192,192));
		Font font2 = new Font("Arial Narrow", Font.PLAIN, 25);
		g.setFont(font2);
		g.drawString("Play again!", 345, 632);
		g.drawString("Home", 373, 692);
	}

	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if (xClick >= 325 && xClick <= 475 && yClick >= 600 && yClick <= 650)
			as.changeScreen("Game");
		else if (xClick >= 350 && xClick <= 450 && yClick >= 660 && yClick <= 710)
			as.changeScreen("Title");
	}

	public void reset() {
		GameScreen.score = 0;
		this.as = as;

		//time = TimeTracker.getTime();
	}
}
