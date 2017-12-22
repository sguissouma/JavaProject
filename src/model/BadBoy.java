package model;

/**
 * Model class for BadBoy.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class BadBoy extends LabyrinthElement{

	/**
	 * BadBoy constructor.
	 * @param xPosition bad boy x position.
	 * @param yPosition bad boy y position.
	 */
	public BadBoy(int xPosition, int yPosition) {
		super(xPosition, yPosition, LabyrinthElementType.BADBOY);
	}

}
