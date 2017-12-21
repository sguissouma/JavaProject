package model;

import controller.BadBoyController;
import controller.Controller;
import view.BadBoySprite;

public class BadBoyFactory extends BaseFactory{

	public static BadBoySprite getBadBoyWithPosition(){
		
		Coord2D coord = generateFreePosition();

		//Create View
		BadBoySprite badBoyView = new BadBoySprite();
		badBoyView.setImage("/images/bad.png");
		badBoyView.setPosition(coord.x, coord.y);

		//Create Model
		BadBoy badboy = new BadBoy(coord.x,coord.y);
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
