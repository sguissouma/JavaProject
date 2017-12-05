package controller;

import javafx.stage.Stage;
import model.Labyrinth;
import model.Vertex;
import view.ViewFrame;

public class Controller {
	
	private static Controller instance = null;
	private static ViewFrame view;
	private static Labyrinth model;
	
	
	public Controller() {
		view = new ViewFrame();
		model = new Labyrinth();
	}
	
	public static Controller getInstance() {
		if(instance==null)
			instance = new Controller();
		return instance;
	}
	
	public static void start(Stage stage) {
		view.start(stage, Labyrinth.size, Labyrinth.size);
	}

}
