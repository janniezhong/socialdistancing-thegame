package Components;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
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
    private double maskNumber;
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
        maskNumber = 3.0;
        this.as = as;
    }

    // METHODS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getMaskNum() {
        return maskNumber;
    }


    public void move(int xChange) {

        x += xChange;

        //to check if player hits left
        if (x < 100 + charWidth / 2) {
            x = 100 + charWidth / 2;
        }
        //to check if player hits right
        else if (x > 700 - charWidth / 2 ) {
            x = 700 - charWidth / 2;
        }
    }
    public void setX(int x){
        this.x = x;
        //to check if player hits left
        if (this.x < 100 + charWidth / 2) {
            this.x = 100 + charWidth / 2;
        }
        //to check if player hits right
        else if (this.x > 700 - charWidth / 2 ) {
            this.x = 700 - charWidth / 2;
        }
    }

    public void checkHasCollided(LinkedList<Components.Obstacle> obstacles, int screenWidth, int screenHeight) {

        int playerTop = y - charHeight / 2;
        int playerBottom = y + charHeight / 2;
        int playerLeft = x - charWidth / 2;
        int playerRight = x + charWidth / 2;

        //System.out.println("playerLeft: " + playerLeft);
    
        for (int i = 0; i < obstacles.size(); i++) {

            Obstacle ob = obstacles.get(i);
            int obX = ob.getX();
            int obY = ob.getY();

            int obTop = obY - charHeight / 2;
            int obBottom = obY + charHeight / 2;
            int obLeft = obX - charWidth / 2;
            int obRight = obX - charWidth / 2;
            boolean hasMask = ob.hasMask();


            if (obRight >= playerLeft && obLeft <= playerLeft && obBottom >= playerTop && obTop <= playerTop){
                decrementMasks(hasMask);
            }
            else if (obLeft <= playerRight && obRight >= playerRight && obBottom >= playerTop && obTop <= playerTop){
                decrementMasks(hasMask);
            }
            else if (obRight >= playerLeft && obLeft <= playerLeft && obBottom >= playerBottom && obTop <= playerBottom){
                decrementMasks(hasMask);
            }
            else if (obLeft <= playerRight && obRight >= playerRight && obBottom >= playerBottom && obTop <= playerBottom){
                decrementMasks(hasMask);
            }
        }
    }

    public void decrementMasks(boolean hasMask){
        //System.out.println("is anything getting hit?");
        if (hasMask){
            maskNumber -= 1;
        }
        else {
            maskNumber -= 0.5;
        }
        
        if (maskNumber <= 0){
            hasDied = true;
            as.changeScreen("Results");
        }

    }


    public boolean getHasHitObstacle() {
        return hasHitObstacle;
    }

    public boolean getHasDied() {
        return hasDied;
    }
    public double getHealth() {
        return maskNumber;
    }

    public int getIndexOfCurrObj() {
        return indexOfCurrObj;
    }

    public void reset() {
        maskNumber = 3.0;
        hasDied = false;
        hasHitObstacle = false;
        x = 400;
        y = 700;

    }

    public void draw(Graphics g, int x, int y, int sizeX, int sizeY, JPanel observer) {
        g.drawImage(charImg, x-sizeX/2, y-sizeY/2, sizeX, sizeY, observer);

    }

}

