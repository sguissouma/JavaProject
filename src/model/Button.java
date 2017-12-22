package model;

public class Button extends LabyrinthElement {

	ButtonType buttonType;
	Edge doorEdge;

	public Button(int xPosition, int yPosition, ButtonType type, Edge doorEdge) {
		super(xPosition, yPosition, LabyrinthElementType.BUTTON);
		this.buttonType = type;
		this.doorEdge = doorEdge;
	}
	
	public Edge getDoorEdge() {
		return this.doorEdge;
	}

	public ButtonType getButtonType(){
		return this.buttonType;
	}

	public void changeDoorState(){
		if (this.buttonType == ButtonType.CLOSER)
			this.doorEdge.setDoorType(DoorType.CLOSED);
		else
			this.doorEdge.setDoorType(DoorType.OPENED);
	}
}
