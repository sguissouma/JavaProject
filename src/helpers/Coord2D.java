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
	 * @param x coordinate x for position 
	 * @param y coordinate y for position
	 */
	public Coord2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets X coordinate for position.
	 * @return x coordinate
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Set X coordinate for position.
	 * @param x coordinate x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets Y coordinate for position.
	 * @return y coordinate
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Set Y coordinate for position.
	 * @param y coordinate y
	 */
	public void setY(int y) {
		this.y = y;
	}

}