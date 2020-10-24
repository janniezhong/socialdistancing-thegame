import java.awt.Color.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

//graphics of the game screen, background 
//has character, slingshot, target, + the menu w/ the helper blocks

public class GameScreen extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

	protected Character character;
	private Target target;
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
	private LevelZero level0;

	
	private boolean hasHitTarget, hasDied;

	private int t;

	private int x, y;

	private boolean isEditable;
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

		character = new Character(40, 340, charSize, charSize + 10, charImg, as);
		timeTracker = new TimeTracker(character);
		timeTracker.startTimeTracker();

		target = new Target(550, 315, 80);

		slingReleased = false;

		isEditable = true;

		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);
		level0 = new LevelZero();


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

				// Target
				target.drawTarget(g);

		
		// character
				if (slingPressed == true) {
					character.draw(g, dragX - 23, dragY - 23, charSize, charSize + 10);
				} else {
					x = character.getX();
					y = character.getY();
					character.draw(g, x, y, charSize, charSize + 10);

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
//			Obstacle obstacle = obstacles.get(i);
//			obstacle.drawObstacle(g);
//		}

		// button to change editability
		g.setColor(Color.GREEN);
		g.fillRect(700, 400, 60, 30);
		g.setColor(Color.BLACK);
		g.drawString("Editing", 705, 420);

		if (isEditable) {

			// Helper Objects
			if (helperObj) {
				g.setColor(Color.CYAN);
				g.fillRect(700, 150, objWidth, objHeight);

			} else {
				g.setColor(Color.WHITE);
				g.fillRect(700, 150, objWidth, objHeight);

			}

		} else {
			g.setColor(Color.RED);
			g.fillRect(690, 400, 80, 30);
			g.setColor(Color.BLACK);
			g.drawString("No Editing", 695, 420);
		}
//		for (int i = 0; i < helpers.size(); i++) {
//			HelperObject obj = helpers.get(i);
//			obj.draw(g, Color.WHITE);
//
//		}
		
		
		timeTracker.stopTimeTracker();

	}

//	public int setLevel(int lvl) {
//
//		level = lvl;
//
//		if (level == 0){
//
//			obstacles = level0.typeOfObstacles();
//
//		} else if (level == 1) {
//
//			obstacles = level1.typeOfObstacles();
//
//		} else if (level == 2) {
//
//			obstacles = level2.typeOfObstacles();
//
//		} else if (level == 3) {
//
//			obstacles = level3.typeOfObstacles();
//
//		} else if (level == 4) {
//
//			obstacles = level4.typeOfObstacles();
//
//		} else {
//
//			obstacles = level5.typeOfObstacles();
//
//		}
//		return level;
//
//	}

	/*
	 * public void run() {
	 * 
	 * while(true){
	 * 
	 * // CHANGE if (AllScreen.panel.getSlingReleased()) {
	 * 
	 * if (!slingInitTimeSet) { // set start time of fling, so that we can
	 * compute diff correctly
	 * AllScreen.panel.character.setInitialTime(TimeTracker.getTime());
	 * slingInitTimeSet = true; }
	 * 
	 * System.out.println("launch....");
	 * 
	 * AllScreen.panel.character.launch(TimeTracker.getTime());
	 * AllScreen.panel.character.checkHasCollided(AllScreen.panel.helpers,
	 * AllScreen.panel.obstacles, 800, 600);
	 * 
	 * if(character.getHasDied() == true) {
	 * AllScreen.panel.setSlingReleased(false); // only release once
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

	@Override
	public void mouseClicked(MouseEvent arg0) {

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
	// right click to rotate? or have different helper obj? ignore rotation for
	// now
	public void mousePressed(MouseEvent e) {

		xClick = e.getX();
		yClick = e.getY();
		int button = e.getButton();

		if (button == MouseEvent.BUTTON1) {
			if (helperObj == false) {

				if (xClick >= 700 && xClick <= 700 + objWidth && yClick >= 150 - 10 && yClick <= 150 + objHeight + 10) {

					helperObj = true;
				}

			}
			// if true, which means have already clicked on a block
			else {
				if (xClick < 590) {
//					if (helpers.size() < 10) {
//						helpers.add(new HelperObject(xClick, yClick, objWidth, objHeight));
//						helperObj = false;
//					}

				}

			}

			if (isEditable == false) {
				if (slingPressed == false) {
					// if it's approximately near the slingshot bc too lazy for
					// precise coordinates lol
					if (xClick >= 50 && xClick <= 120 && yClick >= 300 && yClick <= 400) {
						slingPressed = true;
						dragX = xClick;
						dragY = yClick;
					} else {

					}
				}
			}

		}

		if (xClick >= 670 && xClick <= 700 + 60 && yClick >= 400 && yClick <= 400 + 30) {
			isEditable = false;

			repaint();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		if (slingPressed) {
//			slingPressed = false;
//			slingInitTimeSet = false; // mark if we have set initial time yet
//			int x = e.getX() - 23;
//			int y = e.getY() - 23;
//			slingshot.setXY(x, y, character);
//			character.setXY(x, y);
//
//			slingReleased = true;
//
//			isEditable = false;
//
//			// int heightI = e.getY();
//			// int heightF = helpers.get(character.getIndexOfCurrObj()).getY();
//			//
//			// slingshot.setObjectHeight(heightI, heightF);
//			//
//			//
//			//
//			//
//			// character.launch(time.getTime());
//
//			slingReleased = true;
//
//			isEditable = false;
//
//			// int heightI = e.getY();
//			// int heightF = helpers.get(character.getIndexOfCurrObj()).getY();
//			//
//			// slingshot.setObjectHeight(heightI, heightF);
//			//
//			//
//			//
//			//
//			// character.launch(time.getTime());
//
//		}

		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if (isEditable == false) {
			if (slingPressed == true) {
				if (e.getX() < 90) {
					dragX = e.getX();
					dragY = e.getY();
					repaint();
				}
			}
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public static boolean getSlingReleased() {
		return slingReleased;
	}

	public static void setSlingReleased(Boolean b) {
		slingReleased = b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// t++;
		// while(true){
		
		repaint();

		// CHANGE
		if (getSlingReleased()) {

			if (!slingInitTimeSet) {
				// set start time of fling, so that we can compute diff
				// correctly
				as.panel.character.setInitialTime(timeTracker.getTime());
				// slingshot.setXY(dragX, dragY);
				// character.setXY(dragX, dragY);
				slingInitTimeSet = true;
			}

			// System.out.println("launch....");

//			character.launch();
//			character.checkHasCollided(helpers, obstacles, target, 800, 600);
//
//			slingshot.setVelocity(character);

			repaint();

			if (character.getHasHitTarget() == true) {
				setSlingReleased(false);
				hasHitTarget = true;
				character.reset();
				as.changeScreen("Results");
			} else if (character.getHasDied() == true) {
				setSlingReleased(false); // only release once
				hasDied = true;
				character.reset();
				as.changeScreen("Results");
			}

			// repaint();

			// CHANGE
			/*
			 * if (getSlingReleased()) {

				if (!slingInitTimeSet) {
					// set start time of fling, so that we can compute diff
					// correctly
					AllScreen.panel.character.setInitialTime(time.getTime());
					// slingshot.setXY(dragX, dragY);
					// character.setXY(dragX, dragY);
					slingInitTimeSet = true;
				}

				// System.out.println("launch....");

				character.launch();
				character.checkHasCollided(helpers, obstacles, 800, 600);

				slingshot.setVelocity(character);

				repaint();

				if (character.getHasDied() == true) {
					setSlingReleased(false); // only release once
					character.reset();
					as.changeScreen("Results");
				}

			}
			*/
		}

		// System.out.println("repainting....");

	}

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
		// character = new Character(40, 340, charSize, charSize + 10, charImg,
		// slingshot);
		timeTracker = new TimeTracker(character);

		slingReleased = false;

		isEditable = true;

		Color SKYBLUE = new Color(175, 238, 238);
		setBackground(SKYBLUE);

//		helpers = new ArrayList<>();
	}
	
	public Character getCharacter (){
		
		return character;
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
