package model;
import org.jgrapht.graph.DefaultEdge;

public class Edge extends DefaultEdge implements Comparable<Edge>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private DoorType doortype; 
	
	
	public Edge() {
		super();
		setDoorType(DoorType.NONE);
	}
	
	public Edge (DoorType type) {
		super();
		setDoorType(type);
	}
	
	public Vertex getSource(){
		return (Vertex) super.getSource();
	}
	
	public Vertex getTarget() {
		return (Vertex) super.getTarget();
	}
	
	@Override
	public int compareTo(Edge o) {
		int diffSource = this.getSource().compareTo(o.getSource());
		if (diffSource !=0)
			return diffSource;
		else
			return  this.getTarget().compareTo(o.getTarget());
	}
	
	public String toString() {
		String s = "[" + this.getSource().toString() + "<->" + this.getTarget().toString() + "]";
		return s;
	}
	
	public DoorType getDoorType() {
		return doortype;
	}

	public void setDoorType(DoorType doorType) {
		this.doortype = doorType;
	}
}