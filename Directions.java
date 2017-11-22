package model;

import java.util.Random;

public enum Directions {
	NORTH, EAST, SOUTH, WEST;
	private static Random rnd = new Random();
	
	public static Directions randomDirection() {
		return Directions.values()[rnd.nextInt(4)];
	}
}
