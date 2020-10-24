// Arleen

public class Slingshot {

	// FIELDS
	// subject to change
	public static final double GRAVITY = 0.1;
	public static final double SCALE = 0.005;
	private int length;
	// velocityI calculation will be figured out later
	private double velocityI, velocityF;
	private double xVelocity, yVelocityI, yVelocityF;
	private int jumpNum;
	private int objectHeight;
	private double angle;
	private int x1, y1, x2, y2;
	private boolean isNegative;

	// CONSTRUCTORS
	// to be deleted later

	public double calculateCurrentXVelocity() {
		return xVelocity;
	}

	public Slingshot() {
		x1 = 95;
		y1 = 340;
		x2 = 95;
		y2 = 340;
		
		length = 0;
		angle = 0;
		jumpNum = 0;
		objectHeight = 0;
		velocityF = 0;
		yVelocityF = 0;
		
		isNegative = false;
	}
	
	private void calculateInitialVelocity(Character c) {
		velocityI = (length * SCALE);
		yVelocityI =  (velocityI * Math.sin(angle));
		xVelocity =  (velocityI * Math.cos(angle));
		
		if (angle < 0) {
			isNegative = true;
		}
		
		c.setXVel(xVelocity);
		c.setYVel(yVelocityI);
	}

	public void setVelocity(Character c) {
		if (Character.getHasHitTop()){
			// 
			c.setYVel(-(c.getYVel()));
			c.setXVel(c.getXVel());
//			velocityF = 0;
//			isNegative = false;
//		}
//		
//		if (Character.getHasHitBottom()){
//			this.angle = -angle;
//			c.setYVel(-(c.getYVel()));
//			// velocityF = 0;
//			velocityF = velocityI;
//			isNegative = true;
		}

	}

	public double getInitialVelocity() {
		return velocityI;
	}

	public double getInitialYVelocity() {
		return yVelocityI;
	}

	public double getXVelocity() {
		return xVelocity;
	}
	
	public void setObjectHeight(int heightI, int heightF) {
		objectHeight = heightF - heightI;
	}

	public int getObjectHeight() {
		return objectHeight;
	}

	/*
	 * public int calculateDistance(double angle) {
	 * 
	 * 
	 * xVelocity = (int) (velocityI * Math.cos(angle));
	 * 
	 * int distance = (int) (timeTaken * xVelocity);
	 * 
	 * setVelocity();
	 * 
	 * return distance; }
	 */

	public void calculateFinalVelocity() {

		yVelocityI =  (velocityI * Math.sin(angle));
		xVelocity =  (velocityI * Math.cos(angle));
		// yVelocityF =  (Math.sqrt(Math.pow(yVelocityI, 2) - 2 * GRAVITY * (-objectHeight)));
		velocityF = - (Math.sqrt(Math.pow(xVelocity, 2) + Math.pow(yVelocityF, 2)));

	}

	public void incrementJumpNum() {
		jumpNum++;
	}

	public int getJumpNum() {
		return jumpNum;
	}
	
	public boolean getIsNegative() {
		return isNegative;
	}
	
	public void setXY(int x, int y, Character c) {
		x2 = x;
		y2 = y;
		
		length = (int) Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
		angle = Math.atan((y1 - y2) / (double) (x1 - x2));
		
		calculateInitialVelocity(c);
	}

	/*
	 * public int calculateMaxHeight(int length, double angle, TimeTracker time)
	 * {
	 * 
	 * this.length = length; int maxHeight = (int) (height + (velocity * time /
	 * 2.0) + (0.5 * GRAVITY * Math.pow(time, 2)));
	 * 
	 * return maxHeight; }
	 */

	// METHODS

}
