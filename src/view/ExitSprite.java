package view;

import model.ExitDoor;

public class ExitSprite extends Sprite{

	private ExitDoor exitDoor;

	public void setExit(ExitDoor exitSprite) {
		this.exitDoor = exitSprite;
	}
	
	public ExitDoor getExit() {
		return this.exitDoor;
	}

}
