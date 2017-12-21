package model;

import controller.Controller;
import view.ButtonSprite;

public class ButtonFactory extends BaseFactory{

	public static ButtonSprite getButton(ButtonType type, Edge edge){
	
		Coord2D coord = generateFreePosition();
		
		//Create View
		ButtonSprite buttonView = new ButtonSprite();
		if(type == ButtonType.CLOSER)
			buttonView.setImage("/images/button_close.png");
		else
			buttonView.setImage("/images/button_open.png");
		buttonView.setPosition(coord.x, coord.y);

		//Create Model
		Button button = new Button(coord.x,coord.y, type, edge);
		
		//Add element to labyrinth
		Controller.getInstance().getLabyrinth().addElement(button);
		
		//Add element to sprite 
		buttonView.setButton(button);

		return buttonView;
	}

}
