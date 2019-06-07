package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

public class PaintModel extends Observable {

	private ArrayList<Shapes> shapes = new ArrayList<Shapes>();
	private ArrayList<Shapes> feedBack = new ArrayList<Shapes>();

	public void addFeedBack(Shapes c) {
		this.feedBack.add(c);
		this.setChanged();
		this.notifyObservers();
	}
	
	public void addShape(Shapes c) {
		this.shapes.add(c);
		this.setChanged();
		this.notifyObservers();
	}


	//public void update() {
	//	this.setChanged();
	//	this.notifyObservers();
	//}
	public ArrayList<Shapes> getShapes() {
		return shapes;
	}
	public ArrayList<Shapes> getFeedBack() {
		return feedBack;
	}
	
	public void reset() {
		feedBack =  new ArrayList<Shapes>();;
	}
	
}
