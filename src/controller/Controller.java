package controller;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import model.Directions;
import model.DoorType;
import model.Edge;
import model.Labyrinth;

public class Controller {
	
	private static Controller instance = null;
	private static Labyrinth model;
	
	private PlayerController playerController;
	private ArrayList<BadBoyController> badBoysControllersList = new ArrayList<BadBoyController>();
	private Timeline timeline;

	
	public Controller() {
		model = new Labyrinth();
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(1500),
		        eventMoveBadGuys));
		timeline.setCycleCount(Animation.INDEFINITE);
	}
	
	public static Controller getInstance() {
		if(instance==null)
			instance = new Controller();
		return instance;
	}

	public static Labyrinth getLabyrinth() {
		return model;
	}
	
	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}
	
	public void addBadBoyController(BadBoyController badBoyController) {
		this.badBoysControllersList.add(badBoyController);
	}
	
	public ArrayList<BadBoyController> getBadBoysControllers(){
		return badBoysControllersList;
	}
	
	public void startBadBoysSearch() {
		timeline.play();
	}
	
	public void stopBadBoysSearch() {
		timeline.stop();
	}
	
	public EventHandler<ActionEvent> eventMoveBadGuys = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event) {
			for(BadBoyController ctrl : badBoysControllersList) {
					ctrl.searchPlayer(model,playerController.getPlayer());
			}
		}
	};
	
	public void movePlayer(Directions direction){
		//verify with Labyrinth model if player could move
		//if yes then move player
		int x = this.playerController.getPlayer().getPosition().x;
		int y = this.playerController.getPlayer().getPosition().y;
		Edge e;
		
		if (direction == Directions.WEST){
			e = model.getGraph().getEdge(model.getGraph().getVertex(x,y), model.getGraph().getVertex(x-1,y));
      	}
		else if (direction == Directions.EAST){
			e = model.getGraph().getEdge(model.getGraph().getVertex(x,y), model.getGraph().getVertex(x+1,y));
  		}
		else if (direction == Directions.NORTH){
			e = model.getGraph().getEdge(model.getGraph().getVertex(x,y), model.getGraph().getVertex(x,y-1));
  		}
		else{
			e = model.getGraph().getEdge(model.getGraph().getVertex(x,y), model.getGraph().getVertex(x,y+1));
  		}
		
		if (!(e == null || (e.getDoorType() != DoorType.NONE))) {
			this.playerController.move(direction);
		}
		
	}
	
}
