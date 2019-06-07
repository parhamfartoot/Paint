package ca.utoronto.utm.paint;


import java.util.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Squiggle extends Shapes{
	private ArrayList<Integer> List_of_x;
	private ArrayList<Integer> List_of_y; 
	private Color color;
	private float thickness;
	
	public Squiggle() {
		super();
	}
	/*
	 * Constructor takes a color and thickness to create a new Squiggle
	 * Creates two new array lists for all the Xs and all the Ys
	 */
	public Squiggle(Color color, float Thickness) {
		this.List_of_x = new ArrayList<Integer>();
		this.List_of_y = new ArrayList<Integer>();
		this.color = color;
		this.thickness = Thickness;
	}
	public float getStroke()
    {
        return this.thickness;
    }
	public void setStroke(float stroke)
    {
        this.thickness = stroke;;
    }
	
	public void setX2(int x2)
	//sets the X2 for the object and adds it to the Xs array
    {
        this.x2=x2;
        this.List_of_x.add(x2);
    }   

    public void setY2(int y2)
  //sets the Y2 for the object and adds it to the Ys array
    {
        this.y2=y2;
        this.List_of_y.add(y2);
    }   
    
    
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
	   this.color = color;
	}
	public float getThickness() {
		return thickness;
	}

	public void draw(GraphicsContext g) {
		/*
		 * The draw method for Squiggle
		 */
		
		g.setStroke(getColor());
		g.setLineWidth(getStroke());
		for (int i = 0; i < List_of_x.size() - 1; ++i) {
    	  g.strokeLine((int)List_of_x.get(i), (int)List_of_y.get(i), (int)List_of_x.get(i + 1),
               (int)List_of_y.get(i + 1));
		}
	}
	

}
