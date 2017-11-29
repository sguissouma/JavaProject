import model.*;

import controller.*;
public class Main {
	
	private GestionnaireGraphique gestion;
	
	public static void main(String[] args) {
		int size = 4;
		Vertex vertices[][] = new Vertex[size][size];
		
		
		// TODO Auto-generated method stub
		//Instanciation de l'objet graph
		Graph graph = new Graph();
		/* on initialise chaque arêtes de notre graphe */
		for(int i=0; i < size; i++)
			for(int j=0; j<size; j++) {
				vertices[i][j]= new Vertex(i,j);
				graph.addVertex(vertices[i][j]);
			}
		graph.addEdge(vertices[0][0], vertices[0][1]);
		
		System.out.println(graph.toString());
		
		//TEst 
		
		Labyrinth laby = new Labyrinth(new Vertex(0,0));
		laby.printGraph();
		
		/* Mise en place du gestionnaire graphique et lancement */
		GestionnaireGraphique gestion = new GestionnaireGraphique();
		gestion.run(); 
	}

}
