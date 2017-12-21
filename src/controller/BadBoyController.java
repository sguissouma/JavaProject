package controller;

import model.BadBoy;
import model.Directions;
import model.Labyrinth;
import model.Vertex;

public class BadBoyController {

	private BadBoy badboy;

	public void setBadBoy(BadBoy badboy) {
		this.badboy = badboy;
	}

	public BadBoy getBadBoy(){
		return this.badboy;
	}
	
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
	
	public Vertex searchVertexPosition(Labyrinth labyrinth)
	{
		Vertex v = new Vertex(this.badboy.getPosition().x, this.badboy.getPosition().y, 0);
		for(Vertex tmp : labyrinth.getGraph().vertexSet())
			if(v.compareTo(tmp) == 0)
				return tmp;
		return null;
	}

}
