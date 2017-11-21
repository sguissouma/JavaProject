import model.Graph;
import model.Vertex;

public class Main {

	public static void main(String[] args) {
		int size = 4;
		Vertex vertices[][] = new Vertex[size][size];
		
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		
		for(int i=0; i < size; i++)
			for(int j=0; j<size; j++) {
				vertices[i][j]= new Vertex(i,j);
				graph.addVertex(vertices[i][j]);
			}
		graph.addEdge(vertices[0][0], vertices[0][1]);
		
		System.out.println(graph.toString());
		}

}
