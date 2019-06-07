package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Polyline extends Shapes{
	private Color color;
	private float thickness;
	
	public Polyline() {
		super();
	}
	public Polyline( int x1, int y1, int x2, int y2, Color color,float Thickness){
		setX1(x1);
		setY1(y1);
	}
	public void setColor(Color color) {
	   this.color = color;
	}
	public Color getColor() {
		return color;
	}
	public float getThickness() {
		return thickness;
	}
	
	public void draw(GraphicsContext g) {
		/*
		 * The draw method for PolyLine
		 */
		g.setStroke(getColor());
		g.setLineWidth(getStroke());
		g.strokeLine(getX1(), getY1(), getX2(), getY2());
		
	}



}
