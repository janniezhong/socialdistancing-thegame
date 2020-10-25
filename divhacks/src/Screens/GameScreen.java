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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//import java.awt.*;

import javax.swing.*;
import java.util.LinkedList;


import Components.*;
import GameManagement.*;



//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

	protected Player player;
	private Image charImg;
	private int charSize;
	private TimeTracker timeTracker;
	public static int score;

	private int objWidth, objHeight;

	private boolean hasHitObject, hasDied;

	private int t;

	private int x, y;

	private AllScreen as;
	//private Second s;

	private ObstacleGenerator obstacleGen;
	private int obstacleSpeed;

	private Image redHeart;
	private Image blackHeart;
	private Image redblackHeart;
	

	public GameScreen(AllScreen as) {

		t = 0;
		Timer clock = new Timer(16, this);
		clock.start();

		this.as = as;
		this.addKeyListener(this);
		//this.addActionListener(this);
		this.setFocusable(true);
		this.requestFocus(); 


		//second s = new second();
		//as.add(s);
		objWidth = 100;
		objHeight = 100;

		charSize = 100;

		hasHitObject = false;
		hasDied = false;
		
		charImg = (new ImageIcon("divhacks/assets/obstacles/nomask/orange_nomask.png").getImage());

		redHeart = (new ImageIcon("divhacks/assets/health/red_heart.png").getImage());
		blackHeart = (new ImageIcon("divhacks/assets/obstacles/black_heart.png").getImage());
		redblackHeart = (new ImageIcon("divhacks/assets/obstacles/red_black_heart.png").getImage());

		obstacleGen = new ObstacleGenerator();
		obstacleSpeed = 1;

		player = new Player(400, charSize, charSize, charImg, as);
		timeTracker = new TimeTracker();
		timeTracker.startTimeTracker();


		Color GROUND = new Color(61, 66, 74);
		setBackground(GROUND);


	}

	public void paint(Graphics g) {
		super.paint(g);
		Toolkit.getDefaultToolkit().sync();

		int width = getWidth();
		int height = getHeight();

		Font font = new Font("SansSerif", Font.BOLD, 20);
		g.setFont(font);

		// platform for character
		//Color PALEGREEN = new Color(160, 255, 100);
		//g.setColor(PALEGREEN);
		//g.fillRect(0, 400, 150, 200);

		//Title
		g.setColor(Color.WHITE);
		g.drawString("Stay 6 feet away!", 325,50);

		// platform for target
		//g.setColor(PALEGREEN);
		//g.fillRect(500, 300, 150, 300);


		// character

		x = player.getX();
		y = player.getY();
		player.draw(g, x, y, charSize, charSize, this);

		// System.out.print("draw x " + x + " y " + y + "\n");


		
		// Road sides
		Color LIGHTGRAY = new Color(139, 145, 148);
		g.setColor(LIGHTGRAY);
		g.fillRect(0, 0, 100, height);
		g.fillRect(700, 0, 100, height);
		g.setColor(Color.GRAY);
		Font newFont = new Font("SansSerif", Font.PLAIN, 15);
		g.setFont(newFont);
		//g.drawString("Click and drop", 660, 25);
		//g.drawString("to use the blocks", 658, 40);
		int padding=130;
		Color LINES = new Color(61, 63, 64);
		g.setColor(LINES);
		for (int i=0; i<5;i++){
			g.fillRect(0,(i+1)*padding,100,9);
		}
		for (int i=0; i<5;i++){
			g.fillRect(700,(i+1)*padding,100,9);
		}

		// Obstacles


		LinkedList<Obstacle> obstacles = obstacleGen.getObstacles();

		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obstacle = obstacles.get(i);
			obstacle.draw(g, 100, 100, as.panel);
		}


		//System.out.println(player.getMaskNum());

		//double maskNum = player.getMaskNum();
		if (player.getMaskNum() > 2.75){ // 3
			g.drawImage(redHeart, 725, 25, 50, 50, this);
			g.drawImage(redHeart, 725, 75, 50, 50, this);
			g.drawImage(redHeart, 725, 125, 50, 50, this);
			
		} else if (player.getMaskNum() < 2.75 && player.getMaskNum() > 2.25) { // 2.5
			g.drawImage(redHeart, 725, 25, 50, 50, this);
			g.drawImage(redHeart, 725, 75, 50, 50, this);
			g.drawImage(redblackHeart, 725, 125, 50, 50, this);
			
		} else if (player.getMaskNum() < 2.25 && player.getMaskNum() > 1.75) { // 2.0
			g.drawImage(redHeart, 725, 25, 50, 50, this);
			g.drawImage(redHeart, 725, 75, 50, 50, this);
			g.drawImage(blackHeart, 725, 125, 50, 50, this);

		} else if (player.getMaskNum() < 1.75 && player.getMaskNum() > 1.25) { // 1.5
			g.drawImage(redHeart, 725, 25, 50, 50, this);
			g.drawImage(redblackHeart, 725, 75, 50, 50, this);
			g.drawImage(blackHeart, 725, 125, 50, 50, this);

		} else if (player.getMaskNum() < 1.25 && player.getMaskNum() > 0.75) { // 1.0
			g.drawImage(redHeart, 725, 25, 50, 50, this);
			g.drawImage(blackHeart, 725, 75, 50, 50, this);
			g.drawImage(blackHeart, 725, 125, 50, 50, this);

		} else if (player.getMaskNum() < 0.75 && player.getMaskNum() > 0.25) { // 0.5
			g.drawImage(redblackHeart, 725, 25, 50, 50, this);
			g.drawImage(blackHeart, 725, 75, 50, 50, this);
			g.drawImage(blackHeart, 725, 125, 50, 50, this);

		} else { //0
			g.drawImage(blackHeart, 725, 25, 50, 50, this);
			g.drawImage(blackHeart, 725, 75, 50, 50, this);
			g.drawImage(blackHeart, 725, 125, 50, 50, this);

		}



//		for (int i = 0; i < helpers.size(); i++) {
//			HelperObject obj = helpers.get(i);
//			obj.draw(g, Color.WHITE);
//
//		}
		
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

	 
	

	public void died(){
		score = timeTracker.stopTimeTracker();
		//System.out.println(score);
		if((score > 10 || (player!= null && player.getHasDied())) && AllScreen.gameInProgress){
			as.changeScreen("Results");
		}
	}

	public void reset() {
		hasDied = false;
		hasHitObject = false;
		x = 400;
		y = 700;
	}



	//move character right and left with keyboard 

	//double horiz=0, velx=0;
	
	//Timer time = new Timer(5,this);

	// public void paintComponent(Graphics g){
	// 	super.paintComponent(g);
	// 	Graphics2D g2 = (Graphics2D) g;
	// 	player.draw(g, player.getX(), 650, 100, 100, this);
	// 	//g2.fill(new Ellipse2D.Double(350,650,100,100));
	// }

	@Override
	public void actionPerformed(ActionEvent e){
		t++;
		repaint();
		died();
		if (obstacleGen != null && AllScreen.gameInProgress){
			obstacleGen.updateObstacles(obstacleSpeed);
		}
		if (player!= null && AllScreen.gameInProgress) {
			//System.out.println("checking for obstacles");
			LinkedList<Obstacle> obstacles = obstacleGen.getObstacles();
			player.checkHasCollided(obstacles, 800, 800);
		}

	}

	@Override
	public void keyPressed(KeyEvent e){
		System.out.println("is this happening?");
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_LEFT){
			//velx=-3;
			player.move(-3);
		}
		if(code == KeyEvent.VK_RIGHT){
			//velx=3;
			player.move(+3);
		}
	}
	@Override
	public void keyTyped(KeyEvent e){}

	@Override
	public void keyReleased(KeyEvent e){}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("rawr");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//System.out.println("x: " + e.getX() + " y: " + e.getY());
		player.setX(e.getX());

	}


	
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
