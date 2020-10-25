package Components;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;
import GameManagement.*;

public class Player {
	// FIELDS
	private int x; // location of character
	private int y;
	private int charWidth;
	private int charHeight;
	// private int xChange, yChange;
	private Image charImg;
	private boolean hasDied;
	private boolean hasHitObstacle;
	private int indexOfCurrObj;
	private int maskNumber;
	private AllScreen as;

	// CONSTRUCTORS
	public Player(int xCoor, int w, int h, Image character, AllScreen as) {
		x = xCoor;
		y = 0;
		charImg = character;
		hasDied = false;
		charWidth = w;
		charHeight = h;
		indexOfCurrObj = -1;
		maskNumber = 3;
		this.as = as;
	}

	// METHODS
	public int getX() {
		return x;
	}


	public void move(int xChange) {
		//to check if player hits left
		if (x < 100 + charWidth / 2) {
			x = 100 + charWidth / 2;
		}
		//to check if player hits right
		else if (x > 700 - charWidth / 2 ) {
			x = 700 - charWidth / 2;
		}
		else{
			x += xChange;
		}
	}

	public void checkHasCollided(ArrayList<Components.Obstacle> obstacles, int screenWidth, int screenHeight) {
		
		for (int i = 0; i < obstacles.size(); i++) {

			Polygon obstacle = obstacles.get(i).getPolygon();

			// obstacle.addPoint(obstacles.get(i).getX1(),
			// obstacles.get(i).getY1());
			// obstacle.addPoint(obstacles.get(i).getX2(),
			// obstacles.get(i).getY2());
			// obstacle.addPoint(obstacles.get(i).getX3(),
			// obstacles.get(i).getY3());

			if (obstacle.intersects(x, y, charWidth, charHeight)) {
				maskNumber --;
				if (maskNumber == 0){
					hasDied = true;
					break;
				}
			}
		}
	}

	public boolean getHasHitObstacle() {
		boolean b = hasHitObstacle;
		return b;
	}

	public boolean getHasDied() {
		boolean b = hasDied;
		return b;
	}

	public int getIndexOfCurrObj() {
		return indexOfCurrObj;
	}

	public void reset() {
		hasDied = false;
		hasHitObstacle = false;

		x = 400;
		y = 0;

	}

	public void draw(Graphics g, int x, int y, int sizeX, int sizeY) {
		g.drawImage(charImg, x, y, sizeX, sizeY, as.panel);

	}

}
