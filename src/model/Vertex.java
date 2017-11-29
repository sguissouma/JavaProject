package model;

public class Vertex implements Comparable<Vertex>{
	
	private int x,y;
	
	public Vertex(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
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
		String s = "(" + x + "," + y + ")";
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
