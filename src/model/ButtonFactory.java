package model;

import java.util.Random;

import view.ButtonSprite;

public class ButtonFactory {

public static ButtonSprite getButton(ButtonType type, Edge edge){
		Random rand = new Random();
		int x = rand.nextInt(Labyrinth.size);
		int y = rand.nextInt(Labyrinth.size);
	
		//Create View
		ButtonSprite buttonView = new ButtonSprite();
		if(type == ButtonType.CLOSER)
			buttonView.setImage("/images/button_close.png");
		else
			buttonView.setImage("/images/button_open.png");
		buttonView.setPosition(x, y);

		//Create Model
		Button button = new Button(x,y, type, edge);
		
		buttonView.setButton(button);
				
		return buttonView;
	}

}
