package model;

/**
 * Model class for Button.
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class Button extends LabyrinthElement {

	ButtonType buttonType;
	Edge doorEdge;

	/**
	 * Button constructor.
	 * @param xPosition bad boy x position.
	 * @param yPosition bad boy y position.
	 * @param type CLOSER or OPENER
	 * @param doorEdge An edge that represents a door.
	 */
	public Button(int xPosition, int yPosition, ButtonType type, Edge doorEdge) {
		super(xPosition, yPosition, LabyrinthElementType.BUTTON);
		this.buttonType = type;
		this.doorEdge = doorEdge;
	}
	
	/**
	 * Get the edge associate to Button.
	 * @return An edge that represents a door.
	 */
	public Edge getDoorEdge() {
		return this.doorEdge;
	}

	/**
	 * Get the button type.
	 * @return Returns the ButtonType CLOSER or OPENER
	 */
	public ButtonType getButtonType(){
		return this.buttonType;
	}

	/**
	 * Changes the states of the doors, from open to closed and vice versa
	 */
	public void changeDoorState(){
		if (this.buttonType == ButtonType.CLOSER)
			this.doorEdge.setDoorType(DoorType.CLOSED);
		else
			this.doorEdge.setDoorType(DoorType.OPENED);
	}
}
