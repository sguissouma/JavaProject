package controller;

import model.BadBoy;
import model.Directions;
import model.Labyrinth;
import model.Vertex;

/**
 * 
 * Controller class which controls a entity of type BadBoy. All necessary methods to update the state of the entity and its position are present here.
 * 
 * @author Carlos Villavicencio
 * @version 1.0
 */

public class BadBoyController {

	private BadBoy badboy;

	/**
	 * Set a BadBoy type object to the badboy instance variable contained in BadBoyController.
	 * 
	 * @param badboy BadBoy type object that represents an evil character in the game.
	 */
	public void setBadBoy(BadBoy badboy) {
		this.badboy = badboy;
	}

	/**
	 * A getter method that is responsible for returning an object of type BadBoy.
	 * 
	 * @return A BadBoy type object that represents an evil character in the game.
	 */
	public BadBoy getBadBoy(){
		return this.badboy;
	}
	
	/**
	 * Update badboy position coordinates.
	 * @param direction Direction to which the badboy object will move.
	 */
	public void move(Directions direction){
		if (direction == Directions.WEST){
			this.badboy.setPosition(this.badboy.getPosition().x - 1, this.badboy.getPosition().y);
		}
		else if (direction == Directions.EAST){
			this.badboy.setPosition(this.badboy.getPosition().x + 1, this.badboy.getPosition().y);
		}
		else if (direction == Directions.NORTH){
			this.badboy.setPosition(this.badboy.getPosition().x, this.badboy.getPosition().y - 1);
		}
		else{
			this.badboy.setPosition(this.badboy.getPosition().x, this.badboy.getPosition().y + 1);
		}
	}
	
	/**
	 * Search for the vertex where the badboy object is.
	 * @param labyrinth Game Labyrinth. Model which contains all labyrinth logic.
	 * @return returns The vertex where the badboy is.
	 */
	public Vertex searchVertexPosition(Labyrinth labyrinth)
	{
		Vertex v = new Vertex(this.badboy.getPosition().x, this.badboy.getPosition().y, 0);
		for(Vertex tmp : labyrinth.getGraph().vertexSet())
			if(v.compareTo(tmp) == 0)
				return tmp;
		return null;
	}

}
