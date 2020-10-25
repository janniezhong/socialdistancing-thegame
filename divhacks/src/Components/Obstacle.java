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

    private String[] noMaskPaths = {"/divhacks/assets/obstacles/nomask/blue_nomask.png", "/divhacks/assets/obstacles/nomask/blue_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/cyan_nomask.png", "/divhacks/assets/obstacles/nomask/cyan_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/green_nomask.png", "/divhacks/assets/obstacles/nomask/green_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/lime_nomask.png", "/divhacks/assets/obstacles/nomask/lime_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/orange_nomask.png", "/divhacks/assets/obstacles/nomask/orange_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/pink_nomask.png", "/divhacks/assets/obstacles/nomask/pink_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/red_nomask.png", "/divhacks/assets/obstacles/nomask/red_nomask_2.png",
        "/divhacks/assets/obstacles/nomask/white_nomask.png", "/divhacks/assets/obstacles/nomask/white_nomask_2.png"
            };

    private String[] maskPaths = {"/divhacks/assets/obstacles/mask/blue_mask.png", "/divhacks/assets/obstacles/mask/blue_mask_2.png",
        "/divhacks/assets/obstacles/mask/cyan_mask.png", "/divhacks/assets/obstacles/mask/cyan_mask_2.png",
        "/divhacks/assets/obstacles/mask/green_mask.png", "/divhacks/assets/obstacles/mask/green_mask_2.png",
        "/divhacks/assets/obstacles/mask/lime_mask.png", "/divhacks/assets/obstacles/mask/lime_mask_2.png",
        "/divhacks/assets/obstacles/mask/orange_mask.png", "/divhacks/assets/obstacles/mask/orange_mask_2.png",
        "/divhacks/assets/obstacles/mask/pink_mask.png", "/divhacks/assets/obstacles/mask/pink_mask_2.png",
        "/divhacks/assets/obstacles/mask/red_mask.png", "/divhacks/assets/obstacles/mask/red_mask_2.png",
        "/divhacks/assets/obstacles/mask/white_mask.png", "/divhacks/assets/obstacles/mask/white_mask_2.png"
            };


    public Obstacle(int x, int y, boolean hasMask){
        xPos = x;
        yPos = y;

        this.hasMask = hasMask;
        if(hasMask){
            img = (new ImageIcon(chooseMaskImg()).getImage());
        } else {
            img = (new ImageIcon(chooseNoMaskImg()).getImage());
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

    public String chooseNoMaskImg(){
        int i = (int)(Math.random()*noMaskPaths.length);
        return noMaskPaths[i];
    }

    public String chooseMaskImg(){
        int i = (int)(Math.random()*maskPaths.length);
        return maskPaths[i];
    }

}
