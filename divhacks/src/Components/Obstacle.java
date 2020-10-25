package Components;

import javax.swing.*;
import java.awt.Image;

public class Obstacle {
    // center values
    private int xPos;
    private int yPos;


    private Image img;
    private boolean hasMask;
    private int size = 100;

    private String[] imagePaths = {"/assets/obstacles/black_nomask.png"};




    public Obstacle(int x, int y, boolean hasMask){
        xPos = x;
        yPos = y;

        this.hasMask = hasMask;
        if(hasMask){
            img = (new ImageIcon("shelbyface.png").getImage());
        } else {
            img = (new ImageIcon("shelbyface.png").getImage());
        }

    }
    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }


    public void moveY (int y){
        yPos += y;
    }


    public boolean hasMask(){
        return hasMask;
    }

    public String chooseImg(){
        int i = (int)(Math.random()*imagePaths.length);
        return imagePaths[i];
    }


}
