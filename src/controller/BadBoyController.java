package controller;

import model.BadBoy;
import model.Directions;

public class BadBoyController {

	private BadBoy badboy;
	
	public BadBoyController(){
	}
	
	public void setBadBoy(BadBoy badboy) {
		this.badboy = badboy;
	}
	
	public void move(Directions direction){
		if (direction == Directions.WEST){
			this.badboy.setPosition(this.badboy.getPosition().x - 1, this.badboy.getPosition().y);
      	}
		else if (direction == Directions.EAST){
			this.badboy.setPosition(this.badboy.getPosition().x + 1, this.badboy.getPosition().y);
  		}
		else if (direction == Directions.NORTH){
			this.badboy.setPosition(this.badboy.getPosition().x, this.badboy.getPosition().y - 1);
  		}
		else{
			this.badboy.setPosition(this.badboy.getPosition().x, this.badboy.getPosition().y + 1);
  		}
	}
	
}
