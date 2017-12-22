package model.factory;

import java.util.Random;

import controller.LabyrinthController;
import helpers.Coord2D;
import model.Candy;
import view.CandySprite;

/**
 * Class that contains all necessary methods to build the objects which represent the Candy in the game.
 * @author Carlos Villavicencio
 * @version 1.0
 *
 */
public class CandyFactory extends BaseFactory{

	/**
	 * Method used to build necessary objects linked to the Candy.
	 * @return returns an object of type CandySprite that represents the view of the candy.
	 */
	public static CandySprite createCandy() {

		Random rand = new Random();
		int num_image = rand.nextInt(4 - 1) + 1;
		
		Coord2D coord = generateFreePosition();

		//Create View
		CandySprite candySprite = new CandySprite();
		candySprite.setImage("/images/candy-"+ num_image +".png");
		candySprite.setPosition(coord.x, coord.y);

		//Create Model
		Candy candy = new Candy(coord.x,coord.y);
		candy.setActive(true);

		//Add element to labyrinth
		LabyrinthController.getInstance().getLabyrinth().addElement(candy);
		
		//Add element to sprite
		candySprite.setCandy(candy);

		return candySprite;

	}
}
