package model;

import java.util.Random;

import view.CandySprite;

public class CandyFactory {

	public static CandySprite getCandySprite() {
		Random rand = new Random();
		int x = rand.nextInt(Labyrinth.size);
		int y = rand.nextInt(Labyrinth.size);
		int num_image = rand.nextInt(4 - 1) + 1;
		
		//Create View
		CandySprite candySprite = new CandySprite();
		candySprite.setImage("/images/candy-"+ num_image +".png");
		
		candySprite.setPosition(x, y);

		//Create Model
		Candy candy = new Candy(x,y);
		
		candySprite.setCandy(candy);
		
		return candySprite;
		
		}
}
