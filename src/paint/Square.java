package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Rectangle{
	private Point edge;
	private int width;
	private int height;
	private boolean fill;
	
	public Square()
	{
		super();
	}

	public Square(int x1, int y1, int x2, int y2, Color color, boolean fill,float Thickness) {
		
		super(x1, y1, x2, y2, color, fill, Thickness);
		
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
	public void FixWidth(){
		
		if (this.height > this.width ) {
			this.width = this.height;
		}
	}
		
	@Override
	public void draw(GraphicsContext g) {
		/*
		 * The draw method for Square
		 */
		g.setStroke(getColor());
		g.setFill(getColor());
		g.setLineWidth(getStroke());
		this.setWidth();
		this.setHeight();
		this.FixWidth();
		if (fill) {
			g.fillRect(fixEdgeX(), fixEdgeY(),getWidth(),getWidth());			
		}else g.strokeRect(fixEdgeX(), fixEdgeY(),getWidth(),getWidth());
		
	}

}
