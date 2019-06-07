package ca.utoronto.utm.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

class PaintPanel extends StackPane implements Observer{

	private int i = 0;
	PaintModel model; // slight departure from MVC, because of the way painting works
	View view; // So we can talk to our parent or other components of the view
	
	Polyline polyline;
	Shapes feedBackShape;
	private Canvas canvas;
	int selectedButtonNum;

	public PaintPanel(PaintModel model, View view) {

		this.feedBackShape = null;
		
		this.canvas = new Canvas(300, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: white");
		//this.getStylesheets().add("/Style/StyleSheet.css");
		this.model = model;
		this.model.addObserver(this);

		this.view = view;
	}


	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		
		// Clear the canvas
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		g.setStroke(Color.WHITE);
		g.setLineWidth(1);
		g.strokeText("i=" + i, 50, 75);
		i = i + 1;
		
		/*
		//Feed Back
		ArrayList<Shapes> feedBackarray = this.model.getFeedBack();
		for(Shapes feed : feedBackarray) {     
        //draws the current Shape Object
		feed.draw(g);
		}
		this.model.reset();
*/
		ArrayList<Shapes> shapes = this.model.getShapes();
		for(Shapes shape : shapes) {     
        //draws the current Shape Object
			if (shape !=null) {
		shape.draw(g);
			}
			
		}	
		
	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.
		//this.repaint();
	}

}
