package model;

import java.util.Random;
import view.ExitSprite;

public class ExitDoorFactory {
	
	public static ExitSprite getExitDoorView(){
	Random rand = new Random();
	int x = rand.nextInt(Labyrinth.size);
	int y = rand.nextInt(Labyrinth.size);
	
	//Create View
	ExitSprite exitSprite = new ExitSprite();
	exitSprite.setImage("/images/door_open.png");
	exitSprite.setPosition(x, y);

	//Create Model
	ExitDoor exit = new ExitDoor(x,y);
	
	exitSprite.setExit(exit);
	
	return exitSprite;
	}
}
