package model;

import java.util.Random;

import controller.Controller;
import view.CandySprite;

public class CandyFactory extends BaseFactory{

	public static CandySprite getCandySprite() {

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
		Controller.getInstance().getLabyrinth().addElement(candy);
		
		//Add element to sprite
		candySprite.setCandy(candy);

		return candySprite;

	}
}
