package model;

/**
 * The Vertex class, that contains info on each case of the labyrinth grid, and will be manipulated by the connection graph
 * @author mporet
 *
 */

public class Vertex implements Comparable<Vertex>{
	/**
	 * Two integers that give the coordinates of the vertex in the graph
	 */
	private int x,y;
	/**
	 * Depth of the vertex in the graph
	 */
	private int nbr;

	/**
	 * Vertex class constructor
	 * @param x horizontal coordinate
	 * @param y vertical coordinate
	 * @param n depth of the nex vertex in the graph
	 */
	public Vertex(int x, int y, int n) {
		this.x=x;
		this.y=y;
		this.setNbr(n);
	}

	/**
	 * get the x coordinate of this vertex
	 * @return the horizontal coordinate
	 */
	public int getX() {
		return x;
	}
	/**
	 * get the y coordinate of this vertex
	 * @return the vertical coordinate
	 */
	public int getY() {
		return y;
	}

/**
 * get the depth of the vertex
 * @return the number, or depth, of the vertex in its graph
 */
	public int getNbr() {
		return nbr;
	}

	/**
	 * change the depth of the vertex in its graph
	 * @param nbr the new depth
	 */
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	/**
	 * Check if this vertex has the same coordinates as another one
	 * @param v the other vertex to compare to
	 * @return true if same coordinates, false otherwise
	 */
	public boolean equals(Vertex v) {
		return (v.x == x && v.y == y);
	}


	@Override
	/**
	 * Compare this vertex with another one, starting with horizontal coordinates, then vertical
	 * @param o the other vertex
	 * @author Maxime Poret
	 */
	public int compareTo(Vertex o) {
		if(x < o.x)
			return -1;
		else if(x > o.x)
			return 1;
		else if(x == o.x) {
			if(y < o.y)
				return -1;
			else if(y > o.y)
				return 1;
			else return 0;
		}
		return 0;
	}

	/**
	 * For debugging purposes, display the vertex as a string of characters describing its coordinates
	 * @author Maxime Poret
	 */
	public String toString() {
		String s = "(" + x + "," + y + ") rang : "+nbr; //affichage provisoire de test sur la profondeur
		return s;
	}

	/**
	 * Checks if two vertices (this one and another) are next to each other on a x,y grid
	 * @param o the other vertex
	 * @return returns if the provided vertex is neighbor to the current vertex instance
	 */
	public boolean isNeighbor(Vertex o) {
		int dx = Math.abs(x - o.x);
		int dy = Math.abs(y - o.y);

		return (dx==0 && dy==1)||(dx==1 && dy==0);
	}

	/**
	 * set the y coordinate
	 * @param i the new y
	 */
	public void setY(int i) {
		y = i;
	}
	/**
	 * set the x coordinate
	 * @param i the new x
	 */
	public void setX(int i) {
		x = i;
	}

	public Vertex moveTo(Directions dir, Labyrinth l) {
		int xt, yt;
		switch (dir) {
		case NORTH:
			xt = x;
			yt = y - 1;
			break;
		case SOUTH:
			xt =x;
			yt = y+1;
			break;
		case WEST:
			xt = x-1;
			yt = y;
			break;
		case EAST:
			xt = x+1;
			yt =y;
			break;

		default:
			xt =x;
			yt =y;
			break;
		}
		Vertex res = l.getGraph().getVertex(xt, yt); //new Vertex(xt, yt, 0);
		return res;
	}

	/**
	 * Checks if the next vertex in the direction we're going is still within the bounds of the grid
	 * @param dir the direction we're going
	 * @param l the labyrinth whose bounds we're checking
	 * @return true if the next vertex is still within bounds, false otherwise
	 */
	public boolean inBorders(Directions dir, Labyrinth l) {
		int xt, yt;
		switch (dir) {
		case NORTH:
			xt = x;
			yt = y - 1;
			break;
		case SOUTH:
			xt =x;
			yt = y+1;
			break;
		case WEST:
			xt = x-1;
			yt = y;
			break;
		case EAST:
			xt = x+1;
			yt =y;
			break;

		default:
			xt =x;
			yt =y;
			break;
		}
		return (xt >= 0 && xt < l.getWidth() && yt >= 0 && yt < l.getHeight());
	}


}
