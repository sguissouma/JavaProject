package controller;

import java.util.ArrayList;
import helpers.Manhattan;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Duration;
import model.Button;
import model.ButtonType;
import model.Directions;
import model.DoorType;
import model.Edge;
import model.Labyrinth;
import model.LabyrinthElement;
import model.Player;
import model.Vertex;


/**
 * Controller class of the labyrinth. It contains all the necessary methods to change and generate the different states of it. 
 * It generates a Singleton object with which its only instance can be accessed from all other classes. 
 * All methods to update the entity and its values are present here.
 * 
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class LabyrinthController {

	private static LabyrinthController instance = null;
	private Labyrinth model;
	private boolean gameOver = false;

	private PlayerController playerController;
	private ArrayList<BadBoyController> badBoysControllersList;
	private Timeline timeline;	
	private Manhattan algorithm;

	/**
	 * The Labyrinth Controller private constructor.
	 */
	private LabyrinthController() {
		model = new Labyrinth();
		this.badBoysControllersList = new ArrayList<BadBoyController>();
		this.timeline = new Timeline(new KeyFrame(
				Duration.millis(1500),
				eventMoveBadGuys));
		this.timeline.setCycleCount(Animation.INDEFINITE);
		this.algorithm = new Manhattan();
	}

	/**
	 * The public Singleton method to get the instance of Labyrinth controller.
	 * @return The labyrinth controller instance.
	 */
	public static LabyrinthController getInstance() {
		if(instance==null)
			instance = new LabyrinthController();
		return instance;
	}

	/**
	 * Getter method to obtain the labyrinth instance
	 * @return  The labyrinth instance.
	 */
	public Labyrinth getLabyrinth() {
		return model;
	}

	/**
	 * Setter method to set the player Controller instance
	 * @param playerController the player controller
	 */
	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}

	/**
	 * Add a BadBoyController to the list of badBoysControllersList.
	 * @param badBoyController an instance of bad boy controller.
	 */
	public void addBadBoyController(BadBoyController badBoyController) {
		this.badBoysControllersList.add(badBoyController);
	}

	/**
	 * getter method to obtain all Bad Boys controller
	 * @return An ArrayList of BadBoyController
	 */
	public ArrayList<BadBoyController> getBadBoysControllers(){
		return this.badBoysControllersList;
	}

	/**
	 * Start the timer which can be used to loop the search by the bad boys.
	 */
	public void startBadBoysSearch() {
		this.timeline.play();
	}

	/**
	 * Stop the timer which can be used to loop the search by the bad boys.
	 */
	public void stopBadBoysSearch() {
		this.timeline.stop();
	}

	/**
	 * EventHandler used to start the search actions by bad boys. 
	 * It basically says to begin the movement of Bad boys.
	 */
	private EventHandler<ActionEvent> eventMoveBadGuys = new EventHandler<ActionEvent>(){
		public void handle(ActionEvent event) {
			for(BadBoyController ctrl : badBoysControllersList) {
				searchPlayer(ctrl);
			}
		}
	};

	/**
	 * Method that is responsible for checking the most appropriate direction to be able to search the player.
	 * @param badControl Controller that contains the necessary methods to obtain and modify the badboy entity. 
	 */
	public void searchPlayer(BadBoyController badControl){
		this.algorithm.launch(badControl.searchVertexPosition(model), model.getGraph().getVertex(playerController.getPlayer().getPosition().x, playerController.getPlayer().getPosition().y));
		Vertex vertex = badControl.searchVertexPosition(model);
		for ( Directions dir : Directions.values() ) {
			Vertex next =  model.getGraph().getVertexByDir(vertex, dir);
			if(model.getGraph().isConnected(vertex, next) && ( next.getNbr() == vertex.getNbr() -1 ) )
			{
				badControl.move(dir);
			}
		}
	}

	/**
	 * Move the player to the indicated direction.
	 * @param direction Direction to which the player is going to move.
	 */
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

	/**
	 * Game handling collisions. Each element game will be checked against the position of the player to know if they are in the same coordinate.
	 */
	public void detectCollitions() {
		if (!this.gameOver) {	

			Player player = this.playerController.getPlayer();
			ArrayList<LabyrinthElement> elements = model.getElementsAt(player.getPosition().x, player.getPosition().y);

			for(LabyrinthElement element : elements) {
				switch (element.getType()) {

				//We ignore the object player
				case PLAYER:
					continue;
					
					//Candy
				case CANDY: 
					if(element.isActive()){
						element.setActive(false);						
					}
					break;

					//Bad Guy
				case BADBOY:
					alert("GAME OVER");
					this.gameOver = true;	
					this.stopBadBoysSearch();
					break;

				case BUTTON:
					Button btn = ((Button)element);
					if (btn.getButtonType() == ButtonType.OPENER) {
						model.openDoor(btn.getDoorEdge());
					}
					else {
						model.closeDoor(btn.getDoorEdge());
					}
					break;
					
					//Exit
				case EXIT:
					alert("YOU WIN !");
					this.gameOver = true;	
					this.stopBadBoysSearch();
					break;
					
				default:
					break;

				}
			}	
		}
	}

	/**
	 * Alert messages to show if the person lost or won the game.
	 * @param message Alert message to be displayed.
	 */
	private void alert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(message);
		alert.setHeaderText(message);
		alert.show();
	}
}



