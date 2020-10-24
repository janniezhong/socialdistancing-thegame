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

	private boolean helperObj;
	private int xClick, yClick;
	private int objWidth, objHeight;
	private int slingX, slingY, dragX, dragY;
	private static boolean slingPressed, slingReleased, slingInitTimeSet; // slingReleased
																			// =
																			// sling
																			// clicked,
																			// then
																			// released


	private int level;

	private boolean hasHitTarget, hasDied;

	private int t;

	private int x, y;

	private AllScreen as;
	// still need to call as.changeScreen("Results") somewhere

	public GameScreen(AllScreen as) {

		t = 0;
		Timer clock = new Timer(16, this);
		clock.start();

		this.as = as;
		helperObj = false;
		objWidth = 60;
		objHeight = 5;

		slingPressed = false;
		slingX = 65;
		slingY = 370;
		dragX = slingX;
		dragY = slingY;
		charSize = 50;

		hasHitTarget = false;
		hasDied = false;
		
		charImg = (new ImageIcon("shelbyface.png").getImage());

		player = new Player(40, 340, charSize, charSize + 10, charImg, as);
		timeTracker = new TimeTracker(player);
		timeTracker.startTimeTracker();


		slingReleased = false;


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

		// System.out.print("pai....xxted\n");

		// platform for target
				g.setColor(PALEGREEN);
				g.fillRect(500, 300, 150, 300);


		
		// character
				if (slingPressed == true) {
					player.draw(g, dragX - 23, dragY - 23, charSize, charSize + 10);
				} else {
					x = player.getX();
					y = player.getY();
					player.draw(g, x, y, charSize, charSize + 10);

			// System.out.print("draw x " + x + " y " + y + "\n");

		}
		// slingshot
		// g.drawImage(slingImg, 60, 300, 70, 100, this);
		Color NEWYELLOW = new Color(241, 221, 56);
		g.setColor(NEWYELLOW);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(5));
		if (slingPressed == true) {
			g2.drawLine(95, 340, dragX, dragY);
		} else
			g2.drawLine(95, 340, slingX, slingY);
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


	public void reset() {

		helperObj = false;

		slingPressed = false;
		slingX = 65;
		slingY = 370;
		dragX = slingX;
		dragY = slingY;
		charSize = 50;

		// charImg = (new ImageIcon("shelbyface.png").getImage());
		// slingshot = new Slingshot();
		// character = new Components.Character(40, 340, charSize, charSize + 10, charImg,
		// slingshot);
		timeTracker = new TimeTracker(player);

		slingReleased = false;

		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);

//		helpers = new ArrayList<>();
	}
	
	public Player getPlayer(){
		
		return player;
	}
	
	public boolean getHasHitTarget() {
		return hasHitTarget;
	}
	
	public boolean getHasDied() {
		return hasHitTarget;
	}
	
	public void setHasHitTarget(boolean b) {
		hasHitTarget = b;
	}
	
	public void setHasDied(boolean b) {
		hasDied = b;
	}
	
	// }

}
