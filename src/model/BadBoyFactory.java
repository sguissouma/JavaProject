package model;

import controller.BadBoyController;
import view.BadBoySprite;

public class BadBoyFactory {

	public static BadBoySprite getBadBoyWithPosition(int x, int y){
		
		//Create View
		BadBoySprite badBoyView = new BadBoySprite();
		
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
