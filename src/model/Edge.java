package model;
import org.jgrapht.graph.DefaultEdge;

public class Edge extends DefaultEdge implements Comparable<Edge>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int door; //0 = no door, 1 = closed door, 2 = open door
	
	public Edge() {
		super();
		this.door = 0; //defaults as no door
	}
	
	@Override
	public int compareTo(Edge o) {
		int diffSource = ((Vertex)this.getSource()).compareTo((Vertex)o.getSource());
		if (diffSource !=0)
			return diffSource;
		else
			return  ((Vertex)this.getTarget()).compareTo((Vertex)o.getTarget());
	}
	
	public String toString() {
		String s = "[" + this.getSource().toString() + "<->" + this.getTarget().toString() + "]";
		return s;
	}

}
