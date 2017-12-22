/**
 * 
 */
package model;

import java.util.Observable;

import helpers.Coord2D;

/**
 * All the elements belonging to the labyrinth will inherit from this class. It contains the necessary methods and elements common to each one.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public abstract class LabyrinthElement extends Observable{

	/**
	 * Represents the element position 
	 */
	Coord2D position;

	/**
	 * Represents the assigned element type 
	 */
	LabyrinthElementType type;

	/**
	 * Tells us if the item is active or not.
	 * Useful to know if we should remove it from the game.
	 */
	boolean active;

	/**
	 * Labyrinth's constructor
	 * @param xPosition initial position in x
	 * @param yPosition initial position in y
	 * @param type element type to be assigned
	 */
	public LabyrinthElement(int xPosition, int yPosition, LabyrinthElementType type) {
		this.position = new Coord2D(xPosition,yPosition);
		this.type = type;
		this.active = true;
	}
	
	/**
	 * Returns the Coord2D of the Labyrinth's element.
	 * @return A coordinate point
	 */
	public Coord2D getPosition(){
		return this.position;
	}

	/**
	 * Sets the element position
	 * @param x coordinate in x
	 * @param y coordinate in y
	 */
	public void setPosition(int x, int y){
		this.position = new Coord2D(x,y);
		setChanged();
		notifyObservers();
	}

	/**
	 * Returns the Coord2D of the Labyrinth's element.
	 * @return the element's type assigned 
	 */
	public LabyrinthElementType getType(){
		return this.type;
	}

	/**
	 * Returns if the item is active or not.
	 * @return A boolean indicating if the element is active or not.
	 */
	public boolean isActive(){
		return this.active;
	}

	/**
	 * Sets the item active/not active
	 * @param active A boolean which saying if the item is active or not.
	 */
	public void setActive(boolean active){
		this.active = active;
	}
}
