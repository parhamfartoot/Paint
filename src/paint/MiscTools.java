package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MiscTools extends GridPane{
	private Thickness thick;
	private boolean fill;
	private Color color;
	//private View view;
	
	public MiscTools(View view) {
		this.color = Color.GRAY;
		this.thick = new Thickness(view);
		this.add(thick, 0, 0);
		
		ToggleButton fillButton = new ToggleButton();
		// Creates a new toggle button for the fill feature
		fillButton.setMaxHeight(20);
		fillButton.setMaxWidth(20);
		fillButton.setOnMouseClicked(e ->{
			if (fillButton.isSelected()) {
				this.fill = true;		
			}
			else this.fill = false;
		});
		setImage("/images/fill-icon-2.png",fillButton);
		this.add(fillButton, 0, 1);
		
		// Creates a color picker feature 
		final ColorPicker colorPicker = new ColorPicker();
		colorPicker.setMaxHeight(20);
		colorPicker.setMaxWidth(50);
	    colorPicker.setValue(Color.GRAY);
	    
	    colorPicker.setOnAction((ActionEvent t) -> {
	      this.color = colorPicker.getValue();
	    });
	    
	    this.add(colorPicker, 0, 2);

	}
	
	
	public void setImage(String path,ToggleButton fillButton) {
		Image image1 = new Image(getClass().getResourceAsStream(path));
		ImageView imageView1 = new ImageView(image1);
			imageView1.setFitWidth(25);
			imageView1.setFitHeight(20);
			fillButton.setGraphic(imageView1);
		
	}
	public Thickness getThick() {
		return this.thick;
	}
	public Boolean getFill() {
		return this.fill;
	} 
	public Color getColor() {
		return this.color;
	}

}
