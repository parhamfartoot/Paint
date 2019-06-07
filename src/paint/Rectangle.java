package ca.utoronto.utm.paint;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shapes {

	private Point edge;
	private int width;
	private int height;
	private boolean fill;
	
	public Rectangle()
	{
		super();
	}

	public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean fill,float Thickness) {
		
		super(x1, y1, x2, y2, color, Thickness);
		this.fill = fill;
		this.setEdge(new Point(getX1(),getY1()));
		
	}
	public Point getEdge(){
		
		return edge;
	}
	public void setEdge(Point x){

		this.edge = x;
	}
	public int fixEdgeX(){
		if(getEdge().getX() > this.getX2()) {
			return getX2();
        }else return getEdge().getX();
	}
	public int fixEdgeY(){
		
		if(getEdge().getY() > this.getY2()) {
			return getY2();
        }else return getEdge().getY();
	}
	public int getWidth(){
		return width;
	}
	public void setWidth(){
		
		this.width= (int) Math.abs(this.getEdge().getX() - getX2());
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(){
		this.height = (int) Math.abs(this.getEdge().getY() - getY2());
	}


	@Override
	public void draw(GraphicsContext g) {
		/*
		 * The draw method for Rectangle
		 */
		g.setStroke(getColor());
		g.setFill(getColor());
		g.setLineWidth(getStroke());
		this.setWidth();
		this.setHeight();
		if (fill) {
			g.fillRect(fixEdgeX(), fixEdgeY(),getWidth(),getHeight());
		}else g.strokeRect(fixEdgeX(), fixEdgeY(),getWidth(),getHeight());
	}


	}
