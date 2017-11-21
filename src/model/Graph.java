package model;
import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex,Edge>{

	public Graph() {
		super(Edge.class);
	}
	
	public boolean addVertex(Vertex v) {
		boolean ret = super.addVertex(v);
		v.setGraph(this);
		return ret;
	}

	
}
