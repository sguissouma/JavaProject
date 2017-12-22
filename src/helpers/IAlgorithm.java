package helpers;

import model.Vertex;
/**
 * Interface used to have a common methods for future search algorithms in the game
 * @author Carlos Villavicencio
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
