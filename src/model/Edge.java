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
	private DoorType door; 
	
	
	public Edge(DoorType doorType) {
		super();
		this.door = doorType;
	}
	/* Constructeur par défaut */
	
	public Edge() {
		super();
		this.door = DoorType.CORRIDOR;
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
	
	public void setDoor(DoorType doorType){
		this.door = doorType;
	}
	
	public DoorType getDoor() {
		return this.door;
	}
