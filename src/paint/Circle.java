package ca.utoronto.utm.paint;


import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class Circle extends Shapes{
	
	private Point centre;
	private int radius;
	private Color color;
	private boolean fill;
	public Circle()
    {
        super();
    }
	
	public Circle( int x1, int y1, int x2, int y2, Color color, boolean fill ,float Thickness) {
		super(x1, y1, x2, y2, color,Thickness);
		this.fill = fill;
		this.setCentre(new Point(getX1(),getY1()));
	}

	public Point getCentre() {
		return centre;
	}

	public void setCentre(Point centre) {
		this.centre = centre;
	}

	public int getRadius() {
		
		
		return radius;
	}

	public void setRadius() {
		int X = (int) Math.abs(this.getCentre().getX()-getX2());
		int Y = (int) Math.abs(this.getCentre().getY()-getY2());
		this.radius = (int) Math.sqrt((X*X)+(Y*Y));
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color ;
	}

	@Override
	public void draw(GraphicsContext g) {
		// draw a circle

		g.setStroke(getColor());
		g.setFill(getColor());
		g.setLineWidth(getStroke());
		this.setRadius();
		int x = getCentre().getX();
		int y = getCentre().getY();
		int radius = getRadius();
		x = x-(radius);
		y = y-(radius);
		if (fill){
			g.fillOval(x, y, radius*2, radius*2);		
		}else g.strokeOval(x, y, radius*2, radius*2);
	}


}
