package ca.utoronto.utm.paint;

import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ShapeChooserPanel extends GridPane{
	
	private PaintPanel panel;
	private View view; // So we can talk to our parent or other components of the view
	private DrawingHandler Handler;
	private int row;
	public ShapeChooserPanel(View view) {
		
		panel = view.getPaintPanel();
		Handler = new DrawingHandler(view);
		row = 0;
		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };

		
		for (String label : buttonLabels) {
			ToggleButton button = new ToggleButton();
			//System.out.println(getClass().getResourceAsStream(("/Style/StyleSheet.css")));
			//button.getStyleClass().add("toggle-button");
			button.setMinWidth(100);
			button.setMinHeight(20);
			
			// Set the button to call the handler on mouse click 
			button.setOnMouseClicked(e -> {	 
				  select(button);
				  panel.selectedButtonNum =  Integer.parseInt(button.getAccessibleText());
				  panel.polyline = new Polyline();
				      panel.setOnMousePressed(Handler);
					  panel.setOnMouseDragged(Handler);
					  panel.setOnMouseReleased(Handler);
			  });  
			
			
			/// Set an image and text for each button
			
			switch (row) {
			  case 0: 
				  button.setAccessibleText("0");
				  setImage("/images/Circle.png",button);
			    break;
			  case 1: 
				  button.setAccessibleText("1");
				  setImage("/images/Rectangle.png",button);
			    break;
			  case 2: 	
				  button.setAccessibleText("2");
				  Image image1 = new Image(getClass().getResourceAsStream("/images/Rectangle.png"));
					ImageView imageView1 = new ImageView(image1);
					imageView1.setFitWidth(20);
					imageView1.setFitHeight(20);
				button.setGraphic(imageView1);
				  break;	
				  
			  case 3: 
				  button.setAccessibleText("3");
				  setImage("/images/Squiggle.png",button);
			    break;
			    
			  case 4: 
				  button.setAccessibleText("4");
				setImage("/images/Polyline.png",button);
			    break;
			}
			
			this.add(button, 0, row);
			row++;
		}
	}

	public void setImage(String path,ToggleButton button) {
		// Get the path to an image and a button the set the image on the button
		
		Image image1 = new Image(getClass().getResourceAsStream(path));
		ImageView imageView1 = new ImageView(image1);
		if (path == "/images/Circle.png") {
			imageView1.setFitWidth(20);
			imageView1.setFitHeight(20);
		}
		else {
		imageView1.setFitWidth(50);
		imageView1.setFitHeight(20);
		}
	button.setGraphic(imageView1);
		
	}
	public int getRow() {
		return row;
	}
	public void select(ToggleButton button) {
		// Make sure all the other buttons are unselected if one button is chosen 
		
		for (Node node : this.getChildren()) {
			ToggleButton b = (ToggleButton)node;
			if (b != button){b.setSelected(false);}			
			}
	}
}
	
