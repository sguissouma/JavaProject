package view;

import java.util.Observable;
import java.util.Observer;
import controller.BadBoyController;
import model.BadBoy;

public class BadBoySprite extends Sprite implements Observer {

	private BadBoyController controller;
	private BadBoy badboy;

	public void setPlayer(BadBoy badboy) {
		this.badboy = badboy;
	}

	public void setController(BadBoyController controller) {
		this.controller = controller;
	}

	public BadBoyController getController() {
		return this.controller;
	}


	@Override
	public void update(Observable o, Object arg) {
		this.setPosition(badboy.getPosition().x, badboy.getPosition().y);
	}
}

