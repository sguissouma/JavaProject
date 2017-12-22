package model;

import java.util.Random;
/**
 * Represents all the possible directions to move, used by the player or bad boys.
 * @author Carlos Villavicencio
 * @version 1.0
 */
public enum Directions {
	NORTH, EAST, SOUTH, WEST;
	private static Random rnd = new Random();

	/**
	 * Returns a random direction.
	 * @return a direction NORTH, EAST, SOUTH, WEST.
	 */
	public static Directions randomDirection() {
		return Directions.values()[rnd.nextInt(4)];
	}
}
