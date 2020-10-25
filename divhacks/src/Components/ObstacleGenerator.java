package Components;

import java.util.LinkedList;

public class ObstacleGenerator {
    private LinkedList<Obstacle> obstacles = new LinkedList<Obstacle>();
    int size = 10;

    public ObstacleGenerator(){

    }


    public LinkedList<Obstacle> getObstacles(){
        return obstacles;
    }

}
