/**
 * 
 */
package model;

import java.util.Observable;

/**
 * @author Carlos Villavicencio
 *
 */
public abstract class LabyrinthElement extends Observable{

	Coord2D position;
	LabyrinthElementType type;
	boolean active;
	
	public LabyrinthElement(int xPosition, int yPosition, LabyrinthElementType type) {
		this.position = new Coord2D(xPosition,yPosition);
		this.type = type;
		this.active = true;
	}
	
	public Coord2D getPosition(){
		return this.position;
	}
	
	public void setPosition(int x, int y){
		this.position = new Coord2D(x,y);
		setChanged();
	    notifyObservers();
	}
	
	public LabyrinthElementType getType(){
		return this.type;
	}

	public boolean isActive(){
		return this.active;
	}
	
	public void setActive(boolean active){
		this.active = active;
	}
}
