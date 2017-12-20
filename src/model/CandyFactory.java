package model;

import java.util.Random;

import controller.Controller;
import view.CandySprite;

public class CandyFactory {

	public static CandySprite getCandySprite() {

		Random rand = new Random();
		int num_image = rand.nextInt(4 - 1) + 1;
		int x,y; 

		do {
			x = rand.nextInt(Labyrinth.size);
			y = rand.nextInt(Labyrinth.size);
		}while(x==0 && y==0);

		//Create View
		CandySprite candySprite = new CandySprite();
		candySprite.setImage("/images/candy-"+ num_image +".png");
		candySprite.setPosition(x, y);

		//Create Model
		Candy candy = new Candy(x,y);
		
		//Add element to labyrinth
		Controller.getInstance().getLabyrinth().addElement(candy);
		
		//Add element to sprite
		candySprite.setCandy(candy);

		return candySprite;

	}
}
