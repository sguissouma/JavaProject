package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewFrame;

public class GameWindow extends Application {

	private static ViewFrame view;

	@Override
	public void start(Stage primaryStage) throws Exception {
		view.start(primaryStage, Controller.getLabyrinth());
	}

	public void stop() {
		System.exit(0);
	}


	public GameWindow() {
		super();
		Controller.getInstance();
		view = new ViewFrame();
	}
	
	public void open() {
		launch();
	}

}
