package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewFrame;

/**
 * 
 * The entry point of the application in JavaFX. To create a JavaFX application, you need to use 
 * this class and implement its abstract method start(). 
 * 
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class GameApplication extends Application {

	private static ViewFrame view;

	/**
	 * 
	 * In this method, we write the entire code for the JavaFX graphics.
	 * 
	 * @param primaryStage Top level JavaFX container.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		view = new ViewFrame();
		view.start(primaryStage, LabyrinthController.getInstance().getLabyrinth());
	}

	
	/**
	 * This method is called when the application should stop, and provides a convenient place to prepare for application exit and destroy resources.
	 */
	
	public void stop() {
		System.exit(0);
	}

	/**
	 * Launch a standalone application. 
	 */
	public void open() {
		launch();
	}

}
