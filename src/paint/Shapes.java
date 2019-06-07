package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

import javafx.scene.canvas.GraphicsContext;

public abstract class Shapes {
	
	//coordinates of shape
    private int x1,y1; 
	protected int x2;
	protected int y2;
    private Color color; // color of shape
    private float Thickness; // Thicknes of the outline of the shape 
    
    /**
    * public constructor which takes no variables and
    * sets coordinates to zero and color to white
    */
    public Shapes()
    {
        x1=0;
        y1=0;
        x2=0;
        y2=0;
        color=Color.WHITE;
        Thickness = (float) 1;
    }
    
    /**
    * constructor which takes variables for coordinates and 
    * color assigning them to the instance variables in the class
    */
    public Shapes(int x1, int y1, int x2, int y2, Color color,float Thickness)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        setColor(color);
        this.Thickness = Thickness;
    }
    
    public float getStroke()
    {
        return this.Thickness;
    }   
    public void setStroke(float stroke)
    {
        this.Thickness = stroke;
    }
    

    public void setX1(int x1)
    {
        this.x1=x1;
    }   

    public void setY1(int y1)
    {
        this.y1=y1;
    }   

    public void setX2(int x2)
    {
        this.x2=x2;
    }   

    public void setY2(int y2)
    {
        this.y2=y2;
    }   
    
    public void setColor(Color color)
    {
        this.color=color;
    }

    public int getX1()
    {
        return x1;
    }

    public int getY1()
    {
        return y1;
    }

    public int getX2()
    {
        return x2;
    }

    public int getY2()
    {
        return y2;
    }

    public Color getColor()
    {
        return color;
    }
    
    /*
     Abstract method for drawing the shape
     
     */
    abstract public void draw( GraphicsContext g );


}
