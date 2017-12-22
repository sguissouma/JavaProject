package view;

import javafx.scene.shape.Rectangle;
import model.Edge;

/**
 * Class that represents the view of a Rectangle used to draw a Wall or a Door.
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class RectangleShape extends Rectangle{
	
	Edge edge;
	
	/**
	 * RectangleShape constructor 
	 * 
	 * @param x rectangle's position in x
	 * @param y rectangle's position in y
	 * @param xspan rectangle's width
	 * @param yspan rectangle's height
	 */
	public RectangleShape(int x, int y, int xspan, int yspan) {
		super(x,y,xspan,yspan);
	}

	/**
	 * Set a edge which represents a door or a wall
	 * @param edge An edge that represents a door or a wall
	 */
	public void setEdge(Edge edge){
		this.edge = edge;
	}
	
	/**
	 * Get the edge associate to RectangleShape.
	 * @return An edge that represents a door or a wall.
	 */
	public Edge getEdge(){
		return this.edge;
	}
	
}
