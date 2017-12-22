package model;

/**
 * Model class for Candy.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class Candy extends LabyrinthElement {

	/**
	 * Candy constructor.
	 * @param xPosition bad boy x position.
	 * @param yPosition bad boy y position.
	 */
	public Candy(int xPosition, int yPosition) {
		super(xPosition, yPosition, LabyrinthElementType.CANDY);
	}

}
