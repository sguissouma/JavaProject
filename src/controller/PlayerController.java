package controller;

import model.Directions;
import model.Player;

public class PlayerController {

	private Player player;
	
	public PlayerController(){
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void move(Directions direction){
		if (direction == Directions.WEST){
			this.player.setPosition(this.player.getPosition().x - 1, this.player.getPosition().y);
      	}
		else if (direction == Directions.EAST){
			this.player.setPosition(this.player.getPosition().x + 1, this.player.getPosition().y);
  		}
		else if (direction == Directions.NORTH){
			this.player.setPosition(this.player.getPosition().x, this.player.getPosition().y - 1);
  		}
		else{
			this.player.setPosition(this.player.getPosition().x, this.player.getPosition().y + 1);
  		}
	}
	
}
