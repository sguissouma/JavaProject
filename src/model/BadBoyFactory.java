package model;

import java.util.Random;

import controller.BadBoyController;
import controller.Controller;
import view.BadBoySprite;

public class BadBoyFactory {

	public static BadBoySprite getBadBoyWithPosition(){
		Random rand = new Random();

		//we recalculate if the position is 0,0 (start position of player)
		int x, y;
		do {
			x = rand.nextInt(Labyrinth.size);
			y = rand.nextInt(Labyrinth.size);
		}while(x==0 && y==0);

		//Create View
		BadBoySprite badBoyView = new BadBoySprite();
		badBoyView.setImage("/images/bad.png");
		badBoyView.setPosition(x, y);

		//Create Model
		BadBoy badboy = new BadBoy(x,y);
		badboy.addObserver(badBoyView);
		
		//Add element to labyrinth
		Controller.getInstance().getLabyrinth().addElement(badboy);
		
		//Add element to sprite
		badBoyView.setPlayer(badboy);

		//Create Controller
		BadBoyController bbController = new BadBoyController();
		bbController.setBadBoy(badboy);

		badBoyView.setController(bbController);

		return badBoyView;
	}
}
