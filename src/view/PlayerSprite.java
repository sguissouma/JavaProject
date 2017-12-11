package view;

import java.util.Observable;
import java.util.Observer;

import controller.PlayerController;
import model.Player;

public class PlayerSprite extends Sprite implements Observer{

	private PlayerController controller;
	private Player player;
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setController(PlayerController controller) {
		this.controller = controller;
	}
	
	public PlayerController getController() {
		return this.controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setPosition(player.getPosition().x*44 + (ViewFrame.SPAN*2), player.getPosition().y*44 + ViewFrame.SPAN*2);
	}
	
}
