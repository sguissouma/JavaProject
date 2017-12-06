package model;



import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex,Edge>{

	public Graph() {
		super(Edge.class);
	}
	
	/**
	 * ajout d'un sommet au graphe si tout s'est bien passé
	 * @param v : un sommet 
	 * @return un booléen
	 */
	public boolean addVertex(Vertex v) {
		boolean ret = super.addVertex(v);
		return ret;
	}
	
	/**
	 * 
	 * @param vertex : un sommet
	 * @return
	 */
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
			
			buf = "V_" + v1.getX() + "_" + v1.getY() + " -- " + "V_" + v2.getX() + "_" + v2.getY() +" [label=\""+e.getDoor().toString() +"\"];\n";						
			w.write(buf);
		}
		
		w.write("}");;
		
		w.close();
	}

	public Vertex randomVertex() {
		Vertex v =null;
		Random rnd = new Random();
		int iRand = rnd.nextInt(this.vertexSet().size());
		int i =0;
		for (Vertex v1 : this.vertexSet()) {
			if(i==iRand)
				v= v1;
			i++;
		}
		return v;
	}

	public Vertex getVertexByDir(Vertex vertex, Directions dir) {
		int xt, yt;
		Vertex res =null;
		switch (dir) {
		case NORTH:
			xt = vertex.getX();
			yt = vertex.getY() - 1;
			break;
		case SOUTH:
			xt =vertex.getX();
			yt = vertex.getY()+1;
			break;
		case WEST:
			xt = vertex.getX()-1;
			yt = vertex.getY();
			break;
		case EAST:
			xt = vertex.getX()+1;
			yt =vertex.getY();
			break;

		default:
			xt =vertex.getX();
			yt =vertex.getY();
			break;
		}
		
		Vertex vTmp = new Vertex(xt, yt);
		
		if(this.contains(vTmp)) {			
			for (Vertex v : this.vertexSet()) {				
				if(v.equals(vTmp)) {
					res=v;					
				}
			}
		}
		return res;
	}

	/**
	 * 
	 * @return
	 */
	public Edge randomEdge() {
		Edge e =null;
		Random rnd = new Random();
		int iRand = rnd.nextInt(this.edgeSet().size());
		int i =0;
		for (Edge e1 : this.edgeSet()) {
			if(i==iRand)
				e= e1;
			i++;
		}
		return e;
	}
	
	public Edge getEdge(Vertex vertex, Directions dir) {
		Vertex vRes ;
		int xt, yt;
		switch (dir) {
		case NORTH:
			xt = vertex.getX();
			yt = vertex.getY() - 1;
			break;
		case SOUTH:
			xt =vertex.getX();
			yt = vertex.getY()+1;
			break;
		case WEST:
			xt = vertex.getX()-1;
			yt = vertex.getY();
			break;
		case EAST:
			xt = vertex.getX()+1;
			yt =vertex.getY();
			break;

		default:
			xt =vertex.getX();
			yt =vertex.getY();
			break;
		}
		vRes = new Vertex(xt,yt);		
		return this.getEdge(vertex, vRes);
	}
	
	
	


	
}
