package model.factory;

import model.Button;
import model.ButtonType;
import model.Coord2D;
import model.Edge;
import view.ButtonSprite;

public class ButtonFactory extends BaseFactory{

	public static ButtonSprite createButton(ButtonType type, Edge edge){
	
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
		
		//Add element to sprite 
		buttonView.setButton(button);

		return buttonView;
	}

}
