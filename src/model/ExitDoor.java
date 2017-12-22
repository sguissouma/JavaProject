package model;

/**
 * Model class for ExitDoor. Exit door is the goal of the game.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class ExitDoor extends LabyrinthElement {

	/**
	 * ExitDoor constructor.
	 * @param xPosition bad boy x position.
	 * @param yPosition bad boy y position.
	 */
	public ExitDoor(int xPosition, int yPosition ) {
		super(xPosition, yPosition, LabyrinthElementType.EXIT);
	}

}
