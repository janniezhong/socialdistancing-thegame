package Screens;

import java.awt.*;
import java.awt.event.MouseEvent;

import Components.Player;
import GameManagement.*;


public class ResultScreen extends Screen {

	private int score = 1;
	private int time = 60;
	private Image starImg;
	private Image shelbyFace;
	private AllScreen as;
	private TimeTracker timeTracker;
	private Player player;
	// private boolean isDead;

	public ResultScreen(AllScreen as) {
		this.as = as;

		player = as.panel.getPlayer();
		timeTracker = new TimeTracker(player);

		time = timeTracker.getTime();
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
		System.out.println(as.panel.getHasHitTarget()+ "");

	}

	public void paintComponent(Graphics g) {

//		System.out.println(as.panel.getHasHitTarget()+ "");
//		if (as.panel.getHasHitTarget()) {
//			if (time > 40)
//				score = 1;
//			else if (time > 20 && time <= 40)
//				score = 2;
//			else if (time > 10 && time <= 20)
//				score = 3;
//			else if (time > 5 && time <= 10)
//				score = 4;
//			else // ((time>0 && time<= 30))
//				score = 5;
//		} else {
//			score = 0;
//		}

		as.panel.setHasHitTarget(false);
		as.panel.setHasDied(false);
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 800, 600);

		for (int i = 0; i < score; i++) {
			g.drawImage(starImg, 250 + 60 * i, 200, 50, 50, this);
		}

		g.setColor(Color.BLACK);
		Font newFont = new Font("Arial Narrow", Font.PLAIN, 35);
		g.setFont(newFont);
		g.drawString("Your score is " + score + " out of 5 stars", 180, 300);

		String phrase = "";

		if (score == 0)
			phrase = "You lost! Oh no!";
		else if (score == 1)
			phrase = "Wow you are almost as terrible as Arleen";
		else if (score == 2)
			phrase = "You are a disappointment";
		else if (score == 3)
			phrase = "Okay??? I guess";
		else if (score == 4)
			phrase = "Nice, but could be better";
		else if (score == 5)
			phrase = "Congratulations!! You get a Pusheen! lol jk";

		Font f2 = new Font("Arial Narrow", Font.PLAIN, 26);
		g.setFont(f2);
		g.drawString(phrase, 185, 360);

		Font f3 = new Font("Arial Narrow", Font.PLAIN, 18);
		g.setFont(f3);
		g.drawString("Click on Shelby to continue", 615, 455);
		g.drawImage(shelbyFace, 700, 480, 70, 80, this);
	}

	public void mousePressed(MouseEvent e) {
		int xClick = e.getX();
		int yClick = e.getY();

		if (xClick >= 700 && xClick <= 770 && yClick >= 480 && yClick <= 580)
			as.changeScreen("Level");
	}

	public void reset() {

		this.as = as;

		time = TimeTracker.getTime();
	}
}
