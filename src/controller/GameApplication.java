package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewFrame;

public class GameApplication extends Application {

	private static ViewFrame view;

	@Override
	public void start(Stage primaryStage) throws Exception {
		view = new ViewFrame();
		view.start(primaryStage, LabyrinthController.getInstance().getLabyrinth());
	}

	public void stop() {
		System.exit(0);
	}

	public void open() {
		launch();
	}

}
