package model;

public class Vertex implements Comparable<Vertex>{
	/**
	 * couple d'entiers correspondant à la position du sommet dans le graphe
	 */
	private int x,y;
	/**
	 * profondeur du sommet dans le graphe
	 */
	private int nbr;
	
	public Vertex(int x, int y, int n) {
		this.x=x;
		this.y=y;
		this.setNbr(n);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	

	public int getNbr() {
		return nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	
	public boolean equals(Vertex v) {
		return (v.x == x && v.y == y);
	}
	

	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
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
	
	public String toString() {
		String s = "(" + x + "," + y + ") rang : "+nbr; //affichage provisoire de test sur la profondeur
		return s;
	}
	
	public boolean isNeighbor(Vertex o) {
		int dx = Math.abs(x - o.x);
		int dy = Math.abs(y - o.y);
		
		return (dx==0 && dy==1)||(dx==1 && dy==0);
	}

	public void setY(int i) {
		y = i;
	}
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
