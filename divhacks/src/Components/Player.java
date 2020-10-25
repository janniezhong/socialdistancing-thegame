package Components;

import java.awt.Graphics;
import java.awt.Image;
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
		y = 700;
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

	public int getY() {
		return y;
	}

	public int getMaskNum() {
		return maskNumber;
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

	/*
	public void checkHasCollided(LinkedList<Components.Obstacle> obstacles, int screenWidth, int screenHeight) {
	
		for (int i = 0; i < obstacles.size(); i++) {

			Obstacle ob = obstacles.get(i);
			int obX = ob.getX();
			int obY = ob.getY();
			
			//could change all of these to || instead of four ifs

			//player collides with obstacle from the left
			if (obX + charWidth >= x - charWidth && obY + charHeight >= y - charHeight) {
				decrementMasks();
			}
			else if (obX + charWidth >= x - charWidth && obY - charHeight <= y + charHeight) {
				decrementMasks();
			}
			//player collides with obstacle from the right
			else if (obX - charWidth <= x + charWidth && obY + charHeight >= y - charHeight) {
				decrementMasks();
			}
			else if (obX - charWidth <= x + charWidth && obY - charHeight <= y + charHeight) {
				decrementMasks();
			}
		}
	}
	*/

	public void decrementMasks(){
		maskNumber --;
				if (maskNumber == 0){
					hasDied = true;
					as.changeScreen("Results");
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
		maskNumber = 3;
		x = 400;
		y = 700;

	}

	public void draw(Graphics g, int x, int y, int sizeX, int sizeY) {
		g.drawImage(charImg, x, y, sizeX, sizeY, as.panel);

	}

}
