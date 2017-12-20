package model;

import java.util.Random;

import controller.Controller;
import view.ButtonSprite;

public class ButtonFactory {

	public static ButtonSprite getButton(ButtonType type, Edge edge){
		Random rand = new Random();
		int x,y; 
		//we recalculate if the position is 0,0 (start position of player)
		do {
			x = rand.nextInt(Labyrinth.size);
			y = rand.nextInt(Labyrinth.size);
		}while(x==0 && y==0);

		//Create View
		ButtonSprite buttonView = new ButtonSprite();
		if(type == ButtonType.CLOSER)
			buttonView.setImage("/images/button_close.png");
		else
			buttonView.setImage("/images/button_open.png");
		buttonView.setPosition(x, y);

		//Create Model
		Button button = new Button(x,y, type, edge);
		
		//Add element to labyrinth
		Controller.getInstance().getLabyrinth().addElement(button);
		
		//Add element to sprite 
		buttonView.setButton(button);

		return buttonView;
	}

}
