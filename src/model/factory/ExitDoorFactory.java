package model.factory;

import controller.LabyrinthController;
import helpers.Coord2D;
import model.ExitDoor;
import view.ExitSprite;

public class ExitDoorFactory extends BaseFactory{

	public static ExitSprite createExitDoor(){
		
		Coord2D coord = generateFreePosition();

		//Create View
		ExitSprite exitSprite = new ExitSprite();
		exitSprite.setImage("/images/door_open.png");
		exitSprite.setPosition(coord.x, coord.y);

		//Create Model
		ExitDoor exit = new ExitDoor(coord.x,coord.y);

		//Add element to labyrinth
		LabyrinthController.getInstance().getLabyrinth().addElement(exit);
		
		//Add elemento to sprite
		exitSprite.setExit(exit);

		return exitSprite;
	}
}
