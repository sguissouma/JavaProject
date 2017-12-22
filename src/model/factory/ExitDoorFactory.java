package model.factory;

import controller.LabyrinthController;
import helpers.Coord2D;
import model.ExitDoor;
import view.ExitSprite;


/**
 * Class that contains all necessary methods to build the objects which represent the ExitDoor in the game.
 * @author Carlos Villavicencio
 * @version 1.0
 *
 */
public class ExitDoorFactory extends BaseFactory{

	/**
	 * Method used to build necessary objects linked to the ExitDoor
	 * @return returns an object of type ExitSprite that represents the view of the exit door.
	 */
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
