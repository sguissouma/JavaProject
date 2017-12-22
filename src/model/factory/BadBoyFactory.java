package model.factory;

import controller.BadBoyController;
import helpers.Coord2D;
import model.BadBoy;
import view.BadBoySprite;

/**
 * Class that contains all necessary methods to build the objects which represent the Bad Boy in the game.
 * @author Carlos Villavicencio
 * @version 1.0
 *
 */
public class BadBoyFactory extends BaseFactory{

	/**
	 * Method used to build necessary objects linked to the bad boy.
	 * @return returns an object of type BadBoySprite that represents the view of the bad boy.
	 */
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
