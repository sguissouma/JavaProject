package model;
import java.util.ArrayList;

import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex,Edge>{

	public Graph() {
		super(Edge.class);
	}
	
	public boolean addVertex(Vertex v) {
		boolean ret = super.addVertex(v);
		return ret;
	}
	
	public boolean contains(Vertex vertex) {
		ArrayList<Vertex> v = new ArrayList<Vertex>(this.vertexSet());
		System.out.println("TEST :" + v);
		for(Vertex v0 : v) {
			if(v0.equals(vertex))
				return true;
		}
		return false;
	}
	
	/*
	 * 	graph MyGraph{
	 * 	  V_0_0 [label="0,0"];
	 *    etc
	 *    
	 *    V_0_0 -- V_0_1 [];
	 *    
	 *  }
	 *  
	 *  dot -Tpng -o mongraphe.png mongraphe.dot
	 */
	
	public void toDot() {
		
	}

	
}
