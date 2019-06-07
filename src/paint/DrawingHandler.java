package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DrawingHandler implements EventHandler<MouseEvent> {
	private View view;
	private PaintPanel panel;
	
	public DrawingHandler(View view){
		this.view = view;
		this.panel = view.getPaintPanel();
	}

	@Override
	public void handle(MouseEvent e) {
		int num = panel.selectedButtonNum;
		
		if(e.getEventType() == MouseEvent.MOUSE_DRAGGED){	
			// Changes the X2 & Y2 of the created shape with drag , add the new shape to feedback and cqll repaint.
			
				panel.feedBackShape.setX2((int)e.getX());
				panel.feedBackShape.setY2((int)e.getY());
				//panel.model.addFeedBack(panel.feedBackShape);
				panel.model.addShape(panel.feedBackShape);
				
			panel.repaint();
			
	}else if (e.getEventType() == MouseEvent.MOUSE_PRESSED){
		//based on the string attached to the button, choose the correct new type of shape to create
		
		switch (num) {
		case 0:
			panel.feedBackShape = new Circle((int)e.getX(), (int)e.getY(),0,0 , panel.view.color(), panel.view.Fill(),panel.view.Thickness());
			break;
		case 1:
			panel.feedBackShape = new Rectangle((int)e.getX(), (int)e.getY(),0,0 , panel.view.color(), panel.view.Fill(),panel.view.Thickness());
			break;
		case 2:
			panel.feedBackShape = new Square((int)e.getX(), (int)e.getY(),0,0 , panel.view.color(),  panel.view.Fill(),panel.view.Thickness());
			break;
		case 3:
			panel.feedBackShape = new Squiggle(panel.view.color(),panel.view.Thickness());
			break;
		case 4:
			panel.feedBackShape = panel.polyline;
        	if (panel.feedBackShape.getX1() == 0 && panel.feedBackShape.getY1() == 0) { panel.feedBackShape.setX1((int)e.getX());panel.feedBackShape.setY1( (int)e.getY()); }
        	panel.feedBackShape.setColor(panel.view.color());panel.feedBackShape.setStroke(panel.view.Thickness()); 
        	break;
		}
		
			
    }else if(e.getEventType() == MouseEvent.MOUSE_RELEASED){
    	// On mouse release add the latest shape to the Shapes 
				panel.feedBackShape.setX2((int)e.getX());
	            panel.feedBackShape.setY2((int)e.getY());
	            panel.model.addShape(panel.feedBackShape);
	            
		if (panel.feedBackShape instanceof Polyline) {
			//if our current feedback shape is  a Polyline, a new Polyline object is created if the X1 & Y1 set as the point of release
			panel.polyline = new Polyline((int)e.getX(),(int)e.getY(), 0, 0, null, 0);
			panel.feedBackShape = null;
			}
		
	
	
}
		
}}
		


