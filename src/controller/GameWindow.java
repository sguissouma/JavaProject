package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Labyrinth;
import view.ViewFrame;

public class GameWindow extends Application {

	private static ViewFrame view;

	@Override
	public void start(Stage primaryStage) throws Exception {
		view.start(primaryStage, Labyrinth.size, Labyrinth.size);
	}

	public void stop() {
		System.exit(0);
	}


	public GameWindow() {
		super();
		view = new ViewFrame();
		Controller.getInstance();
	}
	
	public void open() {
		launch();
	}

}
