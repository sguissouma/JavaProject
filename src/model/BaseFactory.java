package model;

import java.util.Random;

import controller.Controller;

public abstract class BaseFactory {
	protected static Coord2D generateFreePosition() {
		//recalculate if the position is not free
		Random rand = new Random();

		int x, y;
		do {
			x = rand.nextInt(Labyrinth.size);
			y = rand.nextInt(Labyrinth.size);
		}while( Controller.getInstance().getLabyrinth().getElementsAt(x, y).size() > 1 );
		
		return new Coord2D(x,y);
	}
}
