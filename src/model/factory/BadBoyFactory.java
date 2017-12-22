package model.factory;

import controller.BadBoyController;
import helpers.Coord2D;
import model.BadBoy;
import view.BadBoySprite;

public class BadBoyFactory extends BaseFactory{

	public static BadBoySprite createBadBoy(){
		
		Coord2D coord = generateFreePosition();

		//Create View
		BadBoySprite badBoyView = new BadBoySprite();
		badBoyView.setImage("/images/bad.png");
		badBoyView.setPosition(coord.x, coord.y);

		//Create Model
		BadBoy badboy = new BadBoy(coord.x,coord.y);
		badboy.addObserver(badBoyView);
		
		//Add element to sprite
		badBoyView.setBadBoy(badboy);

		//Create Controller
		BadBoyController bbController = new BadBoyController();
		bbController.setBadBoy(badboy);

		badBoyView.setController(bbController);

		return badBoyView;
	}
}
