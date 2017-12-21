package model;

import java.util.Random;

import controller.Controller;
import view.ExitSprite;

public class ExitDoorFactory extends BaseFactory{

	public static ExitSprite getExitDoorView(){
		
		Coord2D coord = generateFreePosition();

		//Create View
		ExitSprite exitSprite = new ExitSprite();
		exitSprite.setImage("/images/door_open.png");
		exitSprite.setPosition(coord.x, coord.y);

		//Create Model
		ExitDoor exit = new ExitDoor(coord.x,coord.y);

		//Add element to labyrinth
		Controller.getInstance().getLabyrinth().addElement(exit);
		
		//Add elemento to sprite
		exitSprite.setExit(exit);

		return exitSprite;
	}
}
