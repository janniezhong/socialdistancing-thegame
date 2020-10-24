import java.awt.Color;
import java.util.ArrayList;

public class LevelOne {
	//FIELDS
	Obstacle ob1;
	ArrayList<Obstacle> x;
	
	//CONSTRUCTORS
	
	public LevelOne (){
		
		ob1 = new Obstacle (60, 0, 270, 0, 300, 350, Color.BLACK);
		x = new ArrayList<Obstacle>();
	}
	
	public ArrayList<Obstacle> typeOfObstacles(){
		
		x.add(ob1);
		
		return x;
	}

	
}
