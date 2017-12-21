package view;

import model.Candy;

public class CandySprite extends Sprite {

	private Candy candy;

	public void setCandy(Candy candy) {
		this.candy = candy;
	}
	
	public Candy getCandy(){
		return this.candy;
	}

}
