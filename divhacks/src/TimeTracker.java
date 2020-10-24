import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimeTracker implements ActionListener {

	private static int time;
	private boolean characterDead; 
	private Timer clock;
	private Character c1;
	private static long beginTime, endTime;
	
	public TimeTracker(Character character) {
		beginTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis();

		time = 0;
	    clock = new Timer(1000, this); 
	    clock.start();
	    c1 = character;
	   
	}

	
	public static int getTime() {
		int t1 = (int) ((endTime - beginTime) / 1000);
		
		return t1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		incrementTime();
	}
	public void startTimeTracker(){
		time = 0;
	    clock = new Timer(1000, this);
		clock.start();
	}
	public void stopTimeTracker(){

	    if(c1.getHasDied() == true) {
	    	clock.stop();
	    	time = -1;
	    }
	}
	
	public void incrementTime() {
		endTime = System.currentTimeMillis();
	}
}
