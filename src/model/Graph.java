package model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
		//System.out.println("TEST :" + v);
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
	
	public void toDot(String fileName) throws IOException {
		File f = new File(fileName);
		FileWriter w = new FileWriter(f);
		
		w.write("graph MyGraph{\n");
		String buf = new String("");
		
		for (Vertex v : this.vertexSet()) {
			buf = "V_" + v.getX() + "_" + v.getY() + " [label=\"" + v.getX()+ ","+v.getY()+"\"];\n";
			w.write(buf);
 		}
		
		Vertex v1, v2;
		for(Edge e : this.edgeSet()) {
			v1 = this.getEdgeSource(e);
			v2 = this.getEdgeTarget(e);
			
			buf = "V_" + v1.getX() + "_" + v1.getY() + " -- " + "V_" + v2.getX() + "_" + v2.getY() + ";\n";
			
//			System.out.println(this.getEdgeSource(e).toString());
//			System.out.println("|");
//			System.out.println(this.getEdgeTarget(e).toString());
			
			w.write(buf);
		}
		
		w.write("}");;
		
		w.close();
	}

	
}
