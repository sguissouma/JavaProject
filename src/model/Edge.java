package model;
import org.jgrapht.graph.DefaultEdge;

/**
 * The Edge class, that is used to connect cases of the labyrinth grid together in the connection graph
 * @author mporet
 *
 */
public class Edge extends DefaultEdge implements Comparable<Edge>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * If a certain door is set between two cases of the grid, this will be used to know whether it is locked or opened
	 */
	private DoorType doortype; 

/**
 * Empty class contructor for Edge
 */
	public Edge() {
		super();
		setDoorType(DoorType.NONE);
	}

	/**
	 * Class constructor for Edge, with the possibility to choose with door type is set at this position
	 * @param type the type of door on this edge
	 */
	public Edge (DoorType type) {
		super();
		setDoorType(type);
	}

	/**
	 * get the source of this edge
	 */
	public Vertex getSource(){
		return (Vertex) super.getSource();
	}

	/**
	 * get the target of this edge
	 */
	public Vertex getTarget() {
		return (Vertex) super.getTarget();
	}

	@Override
	/**
	 * Compare this edge to another one
	 * @param o the other edge to compare to
	 * @return the result of a Vertex.compareTo between the source vertices, and if not conclusive, a comparison between the target vertices
	 */
	public int compareTo(Edge o) {
		int diffSource = this.getSource().compareTo(o.getSource());
		if (diffSource !=0)
			return diffSource;
		else
			return  this.getTarget().compareTo(o.getTarget());
	}

	/**
	 * For debugging purposes, turns the edge info into a readable string of characters
	 */
	public String toString() {
		String s = "[" + this.getSource().toString() + "<->" + this.getTarget().toString() + "]";
		return s;
	}

	/**
	 * Get the type of door defined at this edge
	 * @return the type of door for this edge
	 */
	public DoorType getDoorType() {
		return doortype;
	}

	/**
	 * Set the type of door for this edge
	 * @param doorType the new door type
	 */
	public void setDoorType(DoorType doorType) {
		this.doortype = doorType;
	}
}