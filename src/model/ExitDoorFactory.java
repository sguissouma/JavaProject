package model;

import java.util.Random;

import controller.Controller;
import view.ExitSprite;

public class ExitDoorFactory {

	public static ExitSprite getExitDoorView(){
		Random rand = new Random();
		int x,y; 

		do {
			x = rand.nextInt(Labyrinth.size);
			y = rand.nextInt(Labyrinth.size);
		}while(x==0 && y==0);

		//Create View
		ExitSprite exitSprite = new ExitSprite();
		exitSprite.setImage("/images/door_open.png");
		exitSprite.setPosition(x, y);

		//Create Model
		ExitDoor exit = new ExitDoor(x,y);

		//Add element to labyrinth
		Controller.getInstance().getLabyrinth().addElement(exit);
		
		//Add elemento to sprite
		exitSprite.setExit(exit);

		return exitSprite;
	}
}
