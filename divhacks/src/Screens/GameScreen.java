package Screens;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


import javax.swing.*;
import java.awt.geom.*;

import Components.Player;
import GameManagement.*;



//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel implements KeyListener, ActionListener {

	protected Player player;
	private Image charImg;
	private int charSize;
	private TimeTracker timeTracker;

	private int objWidth, objHeight;

	private boolean hasHitObject, hasDied;

	private int t;

	private int x, y;

	private AllScreen as;

	public GameScreen(AllScreen as) {

		t = 0;
		Timer clock = new Timer(16, this);
		clock.start();

		this.as = as;
		objWidth = 100;
		objHeight = 100;

		charSize = 100;

		hasHitObject = false;
		hasDied = false;
		
		charImg = (new ImageIcon("shelbyface.png").getImage());

		player = new Player(700, charSize, charSize, charImg, as);
		timeTracker = new TimeTracker(player);
		timeTracker.startTimeTracker();


		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);


	}

	public void paint(Graphics g) {
		super.paint(g);
		Toolkit.getDefaultToolkit().sync();

		int width = getWidth();
		int height = getHeight();

		int t = TimeTracker.getTime();
		String time = "";

		Font timeFont = new Font("SansSerif", Font.BOLD, 20);
		g.setFont(timeFont);

		if (t < 60) {
			if (t <= 9)
				time = "0:0" + t;
			else if (t > 9 && t < 60)
				time = "0:" + t;
			else if (t > 60)
				time = t / 60 + ":" + t % 60;
		} else {
			int sec = t % 60;
			int min = t / 60;

			if (sec <= 9)
				time = min + ":0" + sec;
			else
				time = min + ":" + sec;
		}

		g.setColor(Color.GRAY);
		g.drawString(time, 575, 30);

		// platform for character
		Color PALEGREEN = new Color(160, 255, 100);
		g.setColor(PALEGREEN);
		g.fillRect(0, 400, 150, 200);


		// platform for target
		g.setColor(PALEGREEN);
		g.fillRect(500, 300, 150, 300);


		
		// character

		x = player.getX();
		//y = player.getY();
		player.draw(g, x, 400, charSize, charSize);

		// System.out.print("draw x " + x + " y " + y + "\n");

		
		// slingshot
		// g.drawImage(slingImg, 60, 300, 70, 100, this);
		Color NEWYELLOW = new Color(241, 221, 56);
		g.setColor(NEWYELLOW);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));

		// slingshot body
		Color BROWN = new Color(185, 155, 75);
		g.setColor(BROWN);
		g.fillRect(90, 330, 10, 70);

		
		// screen w/ all the thing
		Color LIGHTGRAY = new Color(211, 211, 211);
		g.setColor(LIGHTGRAY);
		g.fillRect(650, 0, 150, height);
		g.setColor(Color.GRAY);
		Font newFont = new Font("SansSerif", Font.PLAIN, 15);
		g.setFont(newFont);
		g.drawString("Click and drop", 660, 25);
		g.drawString("to use the blocks", 658, 40);

//		// Obstacles
//
//		for (int i = 0; i < obstacles.size(); i++) {
//			Components.Obstacle obstacle = obstacles.get(i);
//			obstacle.drawObstacle(g);
//		}



//		for (int i = 0; i < helpers.size(); i++) {
//			HelperObject obj = helpers.get(i);
//			obj.draw(g, Color.WHITE);
//
//		}
		
		timeTracker.stopTimeTracker();
	}


	/*
	 * public void run() {
	 * 
	 * while(true){
	 * 
	 * // CHANGE if (GameManagement.AllScreen.panel.getSlingReleased()) {
	 * 
	 * if (!slingInitTimeSet) { // set start time of fling, so that we can
	 * compute diff correctly
	 * GameManagement.AllScreen.panel.character.setInitialTime(GameManagement.TimeTracker.getTime());
	 * slingInitTimeSet = true; }
	 * 
	 * System.out.println("launch....");
	 * 
	 * GameManagement.AllScreen.panel.character.launch(GameManagement.TimeTracker.getTime());
	 * GameManagement.AllScreen.panel.character.checkHasCollided(GameManagement.AllScreen.panel.helpers,
	 * GameManagement.AllScreen.panel.obstacles, 800, 600);
	 * 
	 * if(character.getHasDied() == true) {
	 * GameManagement.AllScreen.panel.setSlingReleased(false); // only release once
	 * as.changeScreen("Results"); } }
	 * 
	 * repaint(); // System.out.println("repainting....");
	 * 
	 * try { Thread.sleep(160); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 */

	public void reset() {
		hasDied = false;
		hasHitObstacle = false;

		x = 400;
		y = 0;

	}

	 //move character right and left with keyboard 

	double horiz=0, velx=0;
	
	Timer time = new Timer(5,this);

	public void second(){
		time.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(new Ellipse2D.Double(horiz,0,40,40));
	}

	public void actionPerformed(ActionEvent e){
		repaint();
		horiz+=velx;
	}
	
	public void left(){
		velx=-1.5;
	}

	public void right(){
		velx=1.5;
	}

	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT){
			left();
		}
		if(code == KeyEvent.VK_RIGHT){
			right();
		}
	}

	public void keyTyped(KeyEvent e){}
	public void keyReleased(KeyEvent e){}

	
	public Player getPlayer(){
		
		return player;
	}
	
	public boolean getHasHitObject() {
		return hasHitObject;
	}
	
	public boolean getHasDied() {
		return hasDied;
	}
	
	public void setHasHitObject(boolean b) {
		hasHitObject = b;
	}
	
	public void setHasDied(boolean b) {
		hasDied = b;
	}
	
	// }

}
