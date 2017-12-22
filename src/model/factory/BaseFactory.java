package model.factory;

import java.util.Random;

import controller.LabyrinthController;
import helpers.Coord2D;
import model.Labyrinth;

/**
 * Abstract class from which all the generating classes of game objects inherit.
 * @author Carlos Villavicencio
 *
 */
public abstract class BaseFactory {
	
	/**
	 * Method that generates a coordinate of a space not used in the game. Very useful, because it prevents the overlapping objects generated in the same cell.
	 * @return A free coordinate
	 */
	protected static Coord2D generateFreePosition() {
		//recalculate if the position is not free
		Random rand = new Random();

		int x, y;
		do {
			x = rand.nextInt(Labyrinth.size);
			y = rand.nextInt(Labyrinth.size);
		}while( LabyrinthController.getInstance().getLabyrinth().getElementsAt(x, y).size() > 1 );
		
		return new Coord2D(x,y);
	}
}
