package view;

import javafx.scene.shape.Rectangle;
import model.Edge;

public class RectangleShape extends Rectangle{
	
	Edge edge;
	
	public RectangleShape(int x, int y, int xspan, int yspan) {
		super(x,y,xspan,yspan);
	}

	public void setEdge(Edge edge){
		this.edge = edge;
	}
	
	public Edge getEdge(){
		return this.edge;
	}
	
}
