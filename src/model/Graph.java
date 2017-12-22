package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.jgrapht.graph.SimpleGraph;

/**
 * The Graph structure that contains info on the connections of the Labyrinth (walls and openings)
 * @author Maxime Poret
 * @version 1.0
 */

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex,Edge>{


	/**
	 * Graph Width
	 */
	public static final int WIDTH = 15;
	/**
	 * Graph Height
	 */
	public static final int HEIGHT = 15;

/**
 * Constructor of the Graph class
 */
	public Graph() {
		super(Edge.class);
	}

	/**
	 * Adds a vertex to the graph, and return a boolean value according to the success of the operation
	 * @param v : un sommet 
	 * @return un booléen
	 */
	public boolean addVertex(Vertex v) {
		boolean ret = super.addVertex(v);
		return ret;
	}

	/**
	 * Checks if a vertex is part of the graph (compares coordinates, not references)
	 * @param vertex : a vertex
	 * @return true if yes, false if no
	 * @author Maxime Poret
	 */
	public boolean contains(Vertex vertex) {
		for(Vertex v : this.vertexSet()) {
			if (v.getX() == vertex.getX() && v.getY() == vertex.getY())
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

	/**
	 * For debugging purposes, turn the labyrinth into a graph that can be visualized using Dot
	 * @param fileName
	 * @throws IOException
	 * @author Maxime Poret
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

			buf = "V_" + v1.getX() + "_" + v1.getY() + " -- " + "V_" + v2.getX() + "_" + v2.getY() +" [label=\""+e.getDoorType().toString() +"\"];\n";						
			w.write(buf);
		}

		w.write("}");;

		w.close();
	}

	/**
	 * 
	 * @return
	 */
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

	/**
	 * Gets the next vertex in a graph, depending on the direction we're going. Doesn't take notice of doors or walls.
	 * @param vertex the starting vertex
	 * @param dir the direction we're going
	 * @return the next vertex
	 * @author Maxime Poret
	 */
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

		res = getVertex(xt, yt);
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

	/**
	 * 
	 * @param vertex
	 * @param dir
	 * @return
	 */
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
			yt = vertex.getY();
			break;

		default:
			xt = vertex.getX();
			yt = vertex.getY();
			break;
		}
		vRes = this.getVertex(xt, yt); 	
		return this.getEdge(vertex, vRes);
	}


	/**
	 * Get the vertex defined by the coordinates x and y in the graph
	 * @param x
	 * @param y
	 * @return a reference to the vertex that has x and y for coordinates in the graph
	 */
	public Vertex getVertex(int x, int y) {
		for (Vertex v : vertexSet())
			if (v.getX() == x && v.getY() == y)
				return v;
		return null;
	}

	/**
	 * Checks if two vertices are connected in the graph
	 * @param vertex
	 * @param next
	 * @return true if they are connected, false if not
	 */
	public boolean isConnected(Vertex vertex, Vertex next) {
		return this.containsEdge(vertex, next);
	}

	/**
	 * Checks if there is a vertex defined in the graph, in the direction we're trying to go
	 * @param vertex starting point
	 * @param dir direction we're going
	 * @return true if a vertex does NOT exist, false if it DOES exist
	 */
	public boolean doesntExist(Vertex vertex, Directions dir) {
		Vertex v = getVertexByDir(vertex, dir); 
		return v == null ;
	}

}
