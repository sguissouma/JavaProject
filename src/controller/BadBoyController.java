package controller;

import model.BadBoy;
import model.Directions;
import model.Labyrinth;
import model.Player;
import model.Vertex;

public class BadBoyController {

	private BadBoy badboy;

	public void setBadBoy(BadBoy badboy) {
		this.badboy = badboy;
	}

	public BadBoy getBadBoy(){
		return this.badboy;
	}

	public void searchPlayer(Labyrinth labyrinth, Player player){

		labyrinth.launchManhattan(this.searchMyVertexPosition(labyrinth), labyrinth.getGraph().getVertex(player.getPosition().x, player.getPosition().y ));
		Vertex vertex = this.searchMyVertexPosition(labyrinth);
		for ( Directions dir : Directions.values() ) {
			Vertex next =  labyrinth.getGraph().getVertexByDir(vertex, dir);
			if(labyrinth.getGraph().isConnected(vertex, next) && ( next.getNbr() == vertex.getNbr() -1 ) )
			{
				move(dir);
			}
		}
	}

	private Vertex searchMyVertexPosition(Labyrinth labyrinth)
	{
		Vertex v = new Vertex(this.badboy.getPosition().x, this.badboy.getPosition().y, 0);
		for(Vertex tmp : labyrinth.getGraph().vertexSet())
			if(v.compareTo(tmp) == 0)
				return tmp;

		return null;
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

}
