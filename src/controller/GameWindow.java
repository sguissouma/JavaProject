package controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class GameWindow extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//TODO Auto-generated method stub
		Controller.getInstance();
		Controller.start(primaryStage);
	}

	public void stop() {
		System.exit(0);
	}


	public GameWindow() {
		super();
	}
	
	public void open() {
		launch();
	}

}
