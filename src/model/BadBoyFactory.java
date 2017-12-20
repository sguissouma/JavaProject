package model;

import java.util.Random;

import controller.BadBoyController;
import view.BadBoySprite;

public class BadBoyFactory {

	public static BadBoySprite getBadBoyWithPosition(){
		Random rand = new Random();
		int x = rand.nextInt(Labyrinth.size);
		int y = rand.nextInt(Labyrinth.size);
		//Create View
		BadBoySprite badBoyView = new BadBoySprite();
		badBoyView.setImage("/images/bad.png");
		badBoyView.setPosition(x, y);

		//Create Model
		BadBoy badboy = new BadBoy(x,y);
		badboy.addObserver(badBoyView);
		
		badBoyView.setPlayer(badboy);
		
		//Create Controller
		BadBoyController bbController = new BadBoyController();
		bbController.setBadBoy(badboy);
		
		badBoyView.setController(bbController);
		
		return badBoyView;
	}
}
