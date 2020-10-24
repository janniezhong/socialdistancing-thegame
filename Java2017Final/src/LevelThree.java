import java.awt.Color;
import java.util.ArrayList;

public class LevelThree {
	//FIELDS
	Obstacle ob1, ob2;
	
	//CONSTRUCTORS
	
	public LevelThree (){
		
		ob1 = new Obstacle (200, 600, 250, 600, 225, 150, Color.BLACK);
		ob2 = new Obstacle (400, 600, 450, 600, 425, 150, Color.BLACK);
		
	}
	
	public ArrayList<Obstacle> typeOfObstacles(){
		
		ArrayList<Obstacle> x = new ArrayList<Obstacle>();
		x.add(ob1);
		x.add(ob2);

		
		return x;
	}

	
}
