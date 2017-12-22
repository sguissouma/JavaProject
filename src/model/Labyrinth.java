package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import model.Graph;

/**
 * Model class that represents the labyrinth. Any action that is carried out on it will be affected from this place.
 * @author mporet
 * @author Souhe Guissouma
 * @author Carlos Villavicencio
 * @author Carlos Nezout
 */
public class Labyrinth {
	/**
	 * Labyrinth's size
	 */
	public static final int size = 15;

	/**
	 * Labyrinth's top border
	 */
	public static final int TOP_BORDER = 0;
	/**
	 * Labyrinth's right border
	 */
	public static final int RIGHT_BORDER = size;

	/**
	 * Labyrinth's left border
	 */
	public static final int LEFT_BORDER = 0;

	/**
	 * Labyrinth's bottom border
	 */
	public static final int BOTTOM_BORDER = size;

	private ArrayList<LabyrinthElement> labElem;
	private ArrayList<Edge> doors;

	private Graph graph;
	private Random rand;

	private int width = size;
	private int height = size;

	/**
	 * Labyrinth's constructor
	 */
	public Labyrinth() {
		this(new Vertex(0,0,0));
	}

	/**
	 * Labyrinth's constructor with an initial vertex 
	 * @param v initial vertex
	 */
	public Labyrinth(Vertex v) {
		graph = new Graph();
		graph.addVertex(v);
		rand = new Random();
		doors = new ArrayList<Edge>();	
		//build random path
		buildRandomPath(v);
		//open random doors
		createRandomDoors();

		labElem = new ArrayList<LabyrinthElement>();
	}

	/**
	 * Gets Labyrinth's width
	 * @return returns the labyrinth's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the Labyrinth's width
	 * @param width of the labyrinth to be assigned
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets Labyrinth's height
	 * @return returns the labyrinth's height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the Labyrinth's height
	 * @param height of the labyrinth to be assigned
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Method to access the graph
	 * @return returns the labyrinth graph
	 */
	public Graph getGraph() {
		return graph;
	}
	/**
	 * build a random path from an initial vertex
	 * @param vertex initial vertex
	 */
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
			if ((vertex.inBorders(dir,this)) && graph.doesntExist(vertex, dir)) {
				int x = vertex.getX();
				int y = vertex.getY();
				int xt = 0;
				int yt = 0;

				switch(dir) {
				case NORTH : xt = x; yt = y-1; break;
				case SOUTH : xt = x; yt = y+1; break;
				case EAST : xt = x+1; yt = y; break;
				case WEST : xt = x-1; yt = y; break;				
				}

				Vertex next = new Vertex( xt, yt, vertex.getNbr()+1);
				if(!graph.contains(next)){
					graph.addVertex(next);
					graph.addEdge(vertex, next, new Edge());
					buildRandomPath(next); 
				}
			} 
		}
	}

	/**
	 * Adds an element to the list of elements of the labyrinth.
	 * @param element element to be added.
	 */
	public void addElement(LabyrinthElement element) {
		this.labElem.add(element);
	}

	/**
	 * Obtains a list of labyrinth's elements using the element's type as a reference.
	 * @param type element's type used as a reference.
	 * @return A list of labyrinth's elements filtered by type
	 */
	public ArrayList<LabyrinthElement> getElementsByType(LabyrinthElementType type) {
		ArrayList<LabyrinthElement> res = new ArrayList<LabyrinthElement>();

		for(LabyrinthElement i : labElem) {
			if(i.getType() == type) {
				res.add(i);
			}
		}
		return res;
	}

	/**
	 * get an element of the labyrinth given the coordinates
	 * @param x coordinate in x
	 * @param y coordinate in y
	 * @return A labyrinth element
	 */
	public LabyrinthElement getElementAt(int x, int y) {
		for(LabyrinthElement i : labElem) {
			if(i.getPosition().x == x && i.getPosition().y == y)
				return i;
		}
		return null;
	}

	/**
	 * Gets all labyrinth's elements that are in the same coordinates.
	 * 
	 * @param x coordinate in x
	 * @param y coordinate in y
	 * @return all elements presents in the given position
	 */
	public ArrayList<LabyrinthElement> getElementsAt(int x, int y) {
		ArrayList<LabyrinthElement> elements = new ArrayList<LabyrinthElement>();

		for(LabyrinthElement i : labElem) {
			if(i.getPosition().x == x && i.getPosition().y == y)
				elements.add(i);
		}
		return elements;
	}

	/**
	 * Gets all labyrinth's elements from the labyrinth.
	 * @return a list of elements of the labyrinth
	 */
	public ArrayList<LabyrinthElement> getElements(){
		return this.labElem;
	}

	/**
	 * Remove an element from the labyrinth
	 * @param element element to remove
	 */
	public void removeElement(LabyrinthElement element) {
		labElem.remove(element);
	}

	/**
	 * Removes all the elements of the labyrinth
	 */
	public void removeAllElements() {
		labElem.clear();
	}

	/*	public void printGraph(String s) {
		System.out.println(graph.toString()+", NB ARETES : " +graph.edgeSet().size());
		try {
			graph.toDot(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 */

	/**
	 * Arbitrarily simplifies the labyrinth by changing the state of several edges of the graph to "CLOSED_DOOR"
	 * @since 01/12/17
	 */
	public void createRandomDoors() {
		doors = new ArrayList<Edge>();
		for (int i = 0; i <= 20; i++) {
			Vertex vertex = graph.randomVertex();		
			if (vertex != null) {
				Directions dir = Directions.randomDirection();			
				if (isWall(vertex, dir)) {
					Vertex vertex2 = graph.getVertexByDir(vertex, dir);
					if(vertex2 != null) {
						Edge edge = graph.getEdge(vertex2, vertex);					
						if(edge == null) {					
							Edge doorEdge = new Edge(DoorType.OPENED);
							graph.addEdge(vertex, vertex2, doorEdge);
							doors.add(doorEdge);	
						}
					}
				}
			}
		}
	}

	/**
	 * Get a ArrayList's edge that represent the doors in the labyrinth.
	 * @return list of doors
	 */
	public ArrayList<Edge> getDoorList(){
		return this.doors;
	}

	/**
	 * Close a door by changing the state of an edge to "CLOSED"
	 * @param edge edge that represents the door
	 */
	public void closeDoor(Edge edge) {
		edge.setDoorType(DoorType.CLOSED);		
	}

	/**
	 * Open a door by changing the state of an edge to "OPENED"
	 * @param edge edge that represents the door
	 */
	public void openDoor(Edge edge) {
		edge.setDoorType(DoorType.OPENED);		
	}

	/**
	 * Close a door in an arbitrarily way
	 */
	public void closeDoorRandom (){ 
		Edge edge = graph.randomEdge(); 
		closeDoor(edge);
	}

	/**
	 * Check if there is no direct connection between 2 vertices 
	 * @param v origin's vertex
	 * @param dir direction to identify the second vertex concerned
	 * @return a boolean about whether or not there is an arc between the two vertices
	 * @since 01/12/17
	 */
	public boolean isWall(Vertex v, Directions dir) {
		Vertex tmpV = v.moveTo(dir, this);
		return (!graph.containsEdge(v, tmpV));
	}

	/**
	 * Check if the connection between two vertices is closed. If it does, it returns true, otherwise it returns false.
	 * @param vertex Vertex that will be taken as reference point
	 * @param dir direction around the vertex.
	 * @return boolean saying if the connection is closed or not.
	 */
	public boolean isClosed(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge == null) || (edge.getDoorType() == DoorType.CLOSED));
	}


	/**
	 * Check if the connection between two vertices is open. If it does, it returns true, otherwise it returns false.
	 * @param vertex Vertex that will be taken as reference point
	 * @param dir direction around the vertex.
	 * @return boolean saying if the connection is opened or not.
	 */
	public boolean isOpened(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge != null) && (edge.getDoorType() != DoorType.CLOSED));
	}

	/**
	 * Check if there is an edge representing a closed door attached to the vertex. If it does, it returns true, otherwise it returns false.
	 * @param vertex Vertex that will be taken as reference point
	 * @param dir direction around the vertex.
	 * @return boolean saying if a door is closed
	 */
	public boolean isClosedDoor(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge != null) && (edge.getDoorType() == DoorType.CLOSED));
	}

	/**
	 * Check if there is an edge representing a opened door attached to the vertex. If it does, it returns true, otherwise it returns false.
	 * @param vertex Vertex that will be taken as reference point
	 * @param dir direction around the vertex.
	 * @return boolean saying if a door is opened
	 */
	public boolean isOpenedDoor(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return ((edge != null) && (edge.getDoorType() == DoorType.OPENED));
	}

}
