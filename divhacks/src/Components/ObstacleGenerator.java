package Components;

import java.util.LinkedList;
import java.util.ListIterator;

public class ObstacleGenerator {
    private LinkedList<Obstacle> obstacles = new LinkedList<Obstacle>();
    private int size = 10;

    public ObstacleGenerator(){
        int y = 550;
        for (int i = 0; i < size; i++){

            boolean hasMask = false;

            if (Math.random()<0.5){
                hasMask = true;
            }

            int x = (int)(150 + Math.random()*500);

            Obstacle o = new Obstacle(x, y, hasMask);
            obstacles.add(o);
            y -= 100;
        }
    }

    public void updateObstacles(int y){
        ListIterator<Obstacle> listIterator = obstacles.listIterator();
        while (listIterator.hasNext()) {

        }

    }


    public LinkedList<Obstacle> getObstacles(){
        return obstacles;
    }

}
