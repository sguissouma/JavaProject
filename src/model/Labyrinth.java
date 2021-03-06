package model;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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
					graph.addEdge(vertex, next, new Edge(DoorType.CLOSED_DOOR));
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
	
	public void printGraph(String s) {
		System.out.println(graph.toString()+", NB ARETES : " +graph.edgeSet().size());
		try {
			graph.toDot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Simplifie arbitrairement le labyrinthe en changeant l'état de plusieurs aretes du graphe en "CLOSED_DOOR"
	 * @since 01/12/17
	 */
	public void openDoorRandom() {
		for (int i = 0; i <= 1000; i++) {
			Vertex vertex = graph.randomVertex();		
			if (vertex != null) {
				Directions dir = Directions.randomDirection();			
				if (isWall(vertex, dir)) {
					Vertex vertex2 = graph.getVertexByDir(vertex, dir);
					if(vertex2 != null) {
						Edge edge = graph.getEdge(vertex2, vertex);					
						if(edge == null) {											
							graph.addEdge(vertex, vertex2, new Edge(DoorType.OPENED_DOOR));
						}
					}
				}
			}
		}
	}
	
	/**
	 * Ferme arbitrairement une porte
	 */
	public void closeDoorRandom() {
		Edge edge = graph.randomEdge();
		closeDoor(edge);
	}


	private void closeDoor(Edge edge) {
		edge.setDoor(DoorType.CLOSED_DOOR);		
	}
	
	//prédicats de détection d'état de porte
	
	/**
	 * VÃ©rifie si il n'y a pas de liaison direct entre 2 sommets 
	 * @param v sommet d'origine
	 * @param dir direction permettant d'identifier le deuxiÃšme sommet concernÃ©
	 * @return un booléen sur le fait qu'il existe ou non un arc entre les 2 sommets
	 * @since 01/12/17
	 */
	public boolean isWall(Vertex v, Directions dir) {
		Vertex tmpV = v.moveTo(dir, this);
		return (!graph.containsEdge(v, tmpV));
	}
	
	public boolean isClosed(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge == null) || (edge.getDoor() == DoorType.CLOSED_DOOR));
	}
	
	public boolean isOpened(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge != null) && (edge.getDoor() != DoorType.CLOSED_DOOR));
	}
	
	public boolean isClosedDoor(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge != null) && (edge.getDoor() == DoorType.CLOSED_DOOR));
	}
	
	public boolean isOpenedDoor(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge != null) && (edge.getDoor() == DoorType.OPENED_DOOR));
	}
	
	/**
	 * 
	 * @param source
	 * @param target
	 * @since 4/12/17
	 */
	private void calculateManhattanDistance(Vertex source, Vertex target) {
		Queue<Vertex> fifo = new ArrayDeque<>();
		target.setNbr(1);
		fifo.add(target);
		while(!(fifo.isEmpty())) {
			Vertex actual = fifo.remove();
			for (Directions dir : Directions.values()) {
				if(this.isOpened(actual, dir)) {
					Vertex next = graph.getVertexByDir(actual, dir);
					if(next.getNbr()==0) {
						next.setNbr(actual.getNbr()+1);
						if( next.compareTo(source) != 0) {
							fifo.add(next);
						}
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param source
	 * @param target
	 * @since 4/12/17
	 */
	public void launchManhattan(Vertex source, Vertex target) {
		for (Vertex vertex: graph.vertexSet())
			vertex.setNbr(0);
		calculateManhattanDistance(source, target);
	}

}
