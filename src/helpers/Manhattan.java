package helpers;

import java.util.ArrayDeque;
import java.util.Queue;
import controller.LabyrinthController;
import model.Directions;
import model.Vertex;

/**
 * Class that manages the Manhattan distance calculation algorithm
 * 
 * @author Carlos Villavicencio
 *
 */
public class Manhattan implements IAlgorithm{

	/**
	 * Load the Manhattan algorithm.
	 */
	@Override
	public void launch(Vertex source, Vertex target) {
		for (Vertex vertex: LabyrinthController.getInstance().getLabyrinth().getGraph().vertexSet())
			vertex.setNbr(0);
		calculateManhattanDistance(source, target);
	}
	
	/**
	 *  The distance between two points in a grid based on a strictly horizontal and/or vertical path, 
	 *  as opposed to the diagonal distance.
	 * @param source starting vertex
	 * @param target ending vertex
	 */
	private void calculateManhattanDistance(Vertex source, Vertex target) {
		Queue<Vertex> fifo = new ArrayDeque<>();
		target.setNbr(1);
		fifo.add(target);
		while(!(fifo.isEmpty())) {
			Vertex actual = fifo.remove();
			for (Directions dir : Directions.values()) {
				if(LabyrinthController.getInstance().getLabyrinth().isOpened(actual, dir)) {
					Vertex next = LabyrinthController.getInstance().getLabyrinth().getGraph().getVertexByDir(actual, dir);
					if(next.getNbr()==0) {
						next.setNbr(actual.getNbr()+1);
						if( next.compareTo(source) != 0) {
							fifo.add(next);
						}
					}
				}
			}
		}
	}

}
