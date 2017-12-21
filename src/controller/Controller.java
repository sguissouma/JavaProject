package controller;

import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;
import model.Directions;
import model.DoorType;
import model.Edge;
import model.Labyrinth;
import model.LabyrinthElement;
import model.LabyrinthElementType;

public class Controller {

	private static Controller instance = null;
	private static Labyrinth model;
	private boolean gameOver = false;

	private PlayerController playerController;
	private ArrayList<BadBoyController> badBoysControllersList;
	private Timeline timeline;	

	public Controller() {
		model = new Labyrinth();
		badBoysControllersList = new ArrayList<BadBoyController>();
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

	public Labyrinth getLabyrinth() {
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

		if (!gameOver) {	
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
			}else if (!(e == null) && e.getDoorType() == DoorType.OPENED) {
				this.playerController.move(direction);
			}
		}

	}

	public void detectCollitions() {
		if (!gameOver) {	
			ArrayList<LabyrinthElement> elements = Controller.getInstance()
					.getLabyrinth()
					.getElementsAt(playerController.getPlayer().getPosition().x, playerController.getPlayer().getPosition().y);
			if(elements.size()>1) {
				for(LabyrinthElement element : elements) {

					//We ignore the object player
					if (element.getType() == LabyrinthElementType.PLAYER)
						continue;

					//Candy
					if(element.getType() == LabyrinthElementType.CANDY && element.isActive()){
						element.setActive(false);						
					}

					//Bad Guy
					if(element.getType() == LabyrinthElementType.BADBOY){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("GAME OVER");
						alert.setHeaderText("GAME OVER");
						alert.show();
						gameOver = true;	
						this.stopBadBoysSearch();
					}
					
					
					//Exit
					if(element.getType() == LabyrinthElementType.EXIT){
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("YOU WIN");
						alert.setHeaderText("YOU WIN");
						alert.show();
						gameOver = true;	
						this.stopBadBoysSearch();
					}

				}
			}
		}	
	}


}
