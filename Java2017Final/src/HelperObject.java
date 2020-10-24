import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

//delete this later prob
public class HelperObject extends Rectangle2D {

	double x, y;
	double width;
	double height;
	
	public HelperObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		setRect(x, y, width, height);
	}
	
	public void draw(Graphics g, Color colour) {
		g.setColor(colour);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}
	
	@Override
	public void setRect(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;
		width = w;
		height = h;
	}

	@Override
	public int outcode(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rectangle2D createIntersection(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D createUnion(Rectangle2D r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
}
