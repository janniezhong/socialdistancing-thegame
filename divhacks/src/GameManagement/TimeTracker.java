package GameManagement;

import Components.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimeTracker implements ActionListener {

	private static int elapsedTime;
	//private boolean characterDead; 
	//private Timer clock;
	private static long beginTime, endTime, currTime;
	
	public TimeTracker() {
		beginTime = System.currentTimeMillis();
		endTime = System.currentTimeMillis();
		currTime = 0;
		elapsedTime = 0;
	    //clock = new Timer(1000, this); 
	    //clock.start();
	}

	
	/*public static int getTime() {
		int t1 = (int) ((endTime - beginTime) / 1000);
		
		return t1;
	}*/

	@Override
	public void actionPerformed(ActionEvent arg0) {
		incrementTime();
	}

	public void startTimeTracker(){
		beginTime = System.currentTimeMillis();
		endTime = 0;
		
		//clock = new Timer(1000, this);
		//clock.start();
	}
	public static int stopTimeTracker(){
		endTime = System.currentTimeMillis();
		elapsedTime = (int) ((endTime - beginTime) / 1000);

		return elapsedTime;
	    /*if(c1.getHasDied() == true) {
	    	clock.stop();
	    	time = -1;
	    }*/
	}
	public long getElapsed(){
		currTime = System.currentTimeMillis();
		elapsedTime = (int) ((endTime - beginTime) / 1000);

		return elapsedTime;
	}

	public void incrementTime(){
		endTime = System.currentTimeMillis();
	}

}
