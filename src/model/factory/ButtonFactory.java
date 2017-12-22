package model.factory;

import helpers.Coord2D;
import model.Button;
import model.ButtonType;
import model.Edge;
import view.ButtonSprite;

/**
 * Class that contains all necessary methods to build the objects which represent the Button in the game.
 * @author Carlos Villavicencio
 * @version 1.0
 *
 */
public class ButtonFactory extends BaseFactory{

	/**
	 * Method used to build necessary objects linked to a Button
	 * @return returns an object of type ButtonSprite that represents the view of a button.
	 */
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
