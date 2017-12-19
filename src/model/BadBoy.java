package model;

import java.util.Observable;
import java.util.Observer;

public class BadBoy extends LabyrinthElement implements Observer{

	public BadBoy(int xPosition, int yPosition) {
		super(xPosition, yPosition, LabyrinthElementType.BADBOY);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Verify when player change position
		// Manhattan distance
	}

}
