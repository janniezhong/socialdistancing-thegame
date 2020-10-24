import java.awt.Color;
import java.util.ArrayList;

public class LevelTwo {
	//FIELDS
	Obstacle ob1, ob2, ob3;
	
	//CONSTRUCTORS
	
	public LevelTwo (){
		
		ob1 = new Obstacle(150, 600, 300, 600, 250, 150, Color.BLACK);
		ob2 = new Obstacle(350, 600, 400, 600, 325, 400, Color.BLACK);
		ob3 = new Obstacle(400, 0, 500, 0, 475, 50, Color.BLACK);
		
	}
	
	public ArrayList<Obstacle> typeOfObstacles(){
		
		ArrayList<Obstacle> x = new ArrayList<Obstacle>();
		x.add(ob1);
		x.add(ob2);
		x.add(ob3);
		
		return x;
	}
	

	
}


