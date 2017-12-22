/**
 * 
 */
package model;

/**
 * Class that will be used to create the player's instance. Like all other kinds of the maze, it inherits from LabyrinthElement.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class Player extends LabyrinthElement{

	/**
	 * Player's constructor
	 * @param xPosition Player's initial position in x
	 * @param yPosition Player's initial position in y
	 */
	public Player(int xPosition, int yPosition) {
		super(xPosition, yPosition, LabyrinthElementType.PLAYER);
	}

}
