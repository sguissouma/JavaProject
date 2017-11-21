package model;

public class Vertex implements Comparable<Vertex>{
	
	private Graph graph;
	private int x,y;
	
	public Vertex(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setGraph(Graph g) {
		this.graph = g;
	}
	
	public Graph getGraph() {
		return this.graph;
	}

	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		if(this.graph != o.graph)
			return -1;
		if(x < o.x)
			return -1;
		else if(x > o.x)
			return 1;
		else if(x == o.x) {
			if(y < o.y)
				return -1;
			else if(y > o.y)
				return 1;
			else return 0;
		}
		return 0;
	}
	
	public String toString() {
		String s = "(" + x + "," + y + ")";
		return s;
	}
	
	public boolean isNeighbor(Vertex o) {
		if(graph != o.graph)
			return false;
		int dx = Math.abs(x - o.x);
		int dy = Math.abs(y - o.y);
		
		return (dx==0 && dy==1)||(dx==1 && dy==0);
	}
	
	//Idées de fonctions : "surLeBord"
	// référencer le graphe dans le vertex, pour pouvoir vérifier si deux vertex sont voisins
	// ajouter une fonction public setGraph, qui est appelée à l'ajout du vertex dans le graphe

}
