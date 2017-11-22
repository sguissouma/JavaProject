import model.Constants;
import model.Edge;
import model.Graph;
import model.Labyrinth;
import model.Vertex;

public class Main {
	
	public static void main(String[] args) {
//		int size = Constants.size;
//		Vertex vertices[][] = new Vertex[size][size];
//		
//		Graph graph = new Graph();
//		
//		for(int i=0; i < size; i++)
//			for(int j=0; j<size; j++) {
//				vertices[i][j]= new Vertex(i,j);
//				graph.addVertex(vertices[i][j]);
//			}
//		graph.addEdge(vertices[0][0], vertices[0][1], new Edge(0));
//		
//		System.out.println(graph.toString());
//		
		Labyrinth laby = new Labyrinth(new Vertex(0,0));
		laby.printGraph();
		}
		
}
