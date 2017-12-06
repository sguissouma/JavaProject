package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Labyrinth {
	public static final int size = 5;
	
	public static final int TOP_BORDER = 0;
	public static final int RIGHT_BORDER = size;
	public static final int LEFT_BORDER = 0;
	public static final int BOTTOM_BORDER = size;

	private List<LabyrinthElement> labElem;
	
	private Graph graph;
	private Random rand;
	
	private int width;
	private int height;
	
	public Labyrinth() {
		this(new Vertex(0,0));
	}
	
	public Labyrinth(Vertex v) {
		width = size;
		height = size;
		graph = new Graph();
		graph.addVertex(v);
		rand = new Random();
		
		buildRandomPath(v);
	}

	
	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	private void buildRandomPath(Vertex vertex) {

		//initialisation des directions
		Vector<Directions> v = new Vector<Directions>();
		for(int i=0; i<4; ++i) {
			v.add(Directions.values()[i]);
		}
		Directions directions[] = new Directions[4];
		for(int i=0; i<directions.length; ++i) {
			int index= rand.nextInt(v.size());
			directions[i]= v.get(index);
			v.remove(index);
		}

		//pour chacune de ces directions, on avance en profondeur d'abord
		for(int i=0;i<4; ++i) {
			Directions dir = directions[i];
			if ((vertex.inBorders(dir,this))) {
				int x = vertex.getX();
				int y = vertex.getY();
				int xt = 0;
				int yt = 0;
				switch(dir) {
				case NORTH : xt= x;
				yt= y-1;
				break;
				case SOUTH : xt=x;
				yt= y+1;
				break;
				case EAST : xt =x+1;
				yt=y;
				break;
				case WEST : xt=x-1;
				yt=y;
				break;				
				}
				Vertex next = new Vertex(xt, yt);
				if(!graph.contains(next)){
					graph.addVertex(next);
					//System.out.println(next.toString());
					//System.out.println(vertex.toString());
					graph.addEdge(vertex, next, new Edge(0));
					buildRandomPath(next); 
				}
			} 
			
		}
	}

	public void printGraph() {
		System.out.println(graph.toString());
		try {
			graph.toDot("Laby.dot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public List<LabyrinthElement> getElementsByType(LabyrinthElementType type) {
		List<LabyrinthElement> res = new ArrayList<LabyrinthElement>();
		
		for(LabyrinthElement i : labElem) {
			if(i.getType() == type) {
				res.add(i);
			}
		}
		return res;
		
	}
	public LabyrinthElement getElementAt(int x, int y) {
		for(LabyrinthElement i : labElem) {
			if(i.getPosition().x == x && i.getPosition().y == y)
				return i;
		}
		return null;
		
	}
	public void removeElement(ILabyrinthElements element) {
		labElem.remove(element);
	}

}
