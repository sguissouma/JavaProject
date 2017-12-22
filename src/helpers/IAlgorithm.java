package helpers;

import model.Vertex;
/**
 * Interface used to have a common methods for future search algorithms in the game
 * @author Carlos Villavicencio
 *  @version 1.0
 *
 */
public interface IAlgorithm {
	/**
	 * 
	 * Method that loads the algorithm
	 * 
	 * @param source starting vertex
	 * @param target ending vertex
	 */
	public void launch(Vertex source, Vertex target);
}
