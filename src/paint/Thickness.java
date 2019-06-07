package ca.utoronto.utm.paint;

import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;

public class Thickness extends GridPane {
	private View view; // So we can talk to our parent or other components of the view
	private Slider slider = new Slider(0, 100,5);
	float stroke;
	
	public Thickness(View view) {
		
		this.stroke=(float)0;
		slider.setMaxWidth(100);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        slider.valueProperty().addListener(e->{
        	if (slider.isValueChanging()) {
                this.stroke = (float) slider.getValue();          
        	}
            });
        
       this.add(slider, 0, 0);     
	}
	public float getStroke() {
		if (this.stroke > 0.0) {
		return this.stroke;
	}else return (float) 0.1;
	}

}
