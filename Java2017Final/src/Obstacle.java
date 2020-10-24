import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Obstacle {

	int x1, x2, x3;
	int y1, y2, y3;
	Color colour;

	public Obstacle(int x1, int y1, int x2, int y2, int x3, int y3, Color colour) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
		this.colour = colour;
	}

	public void drawObstacle(Graphics g) {
		g.setColor(colour);

		Polygon obstacle = new Polygon();
		obstacle.addPoint(x1, y1);
		obstacle.addPoint(x2, y2);
		obstacle.addPoint(x3, y3);

		g.fillPolygon(obstacle);

	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getX3() {
		return x3;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public int getY3() {
		return y3;
	}

	Polygon getPolygon() {
		return new Polygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
	}

}
