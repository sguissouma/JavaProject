import model.Labyrinth;
import model.Vertex;

import controller.*;
public class Main {

	private GestionnaireGraphique gestion;
	
	public static void main(String[] args) {
	
		//TEst 
		
		Labyrinth laby = new Labyrinth(new Vertex(0,0));
		laby.printGraph();
		
		/* Mise en place du gestionnaire graphique et lancement */
		GestionnaireGraphique gestion = new GestionnaireGraphique();
		gestion.run(); 
	}

}