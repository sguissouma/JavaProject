/**
 * 
 */
package helpers;

/**
 * Class that handles a simple 2D coordinate system.
 * 
 * @author Carlos Villavicencio
 *  @version 1.0
 */
public class Coord2D {
	public int x;
	public int y;

	/**
	 * Class constructor
	 * @param x X coordinate for position
	 * @param y Y coordinate for position
	 */
	public Coord2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets X coordinate for position.
	 * @return X coordinate
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Set X coordinate for position.
	 * @param X coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets Y coordinate for position.
	 * @return Y coordinate
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Set Y coordinate for position.
	 * @param Y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

}