import java.awt.Color;
import java.util.ArrayList;

public class LevelFive {
	//FIELDS
	Obstacle ob1, ob2, ob3;
	
	//CONSTRUCTORS
	
	public LevelFive (){
		
		ob1 = new Obstacle (200, 600, 250, 600, 225, 145, Color.BLACK);
		ob2 = new Obstacle (400, 600, 450, 600, 425, 125, Color.BLACK);
		ob3 = new Obstacle (250, 0, 400, 0, 325, 65, Color.BLACK);

		
		
	}
	
	public ArrayList<Obstacle> typeOfObstacles(){
		
		ArrayList<Obstacle> x = new ArrayList<Obstacle>();
		x.add(ob1);
		x.add(ob2);
		x.add(ob3);
		
		return x;
	}

	
}
