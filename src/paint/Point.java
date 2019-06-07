package ca.utoronto.utm.paint;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;

public class Point {
	int x, y;
	//private Color color;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
		//this.color = color;
		
	}
	//public Color getColor() {
	//	return color;
	//}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	public void execute(Graphics2D g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw((Shape) this);
	}

}
