package model;

import java.util.Random;

public class Labyrinth {
	private Graph graph;
	private Random rand;
	public static int size = 4;
	
	public static final int TOP_BORDER = 0;
	public static final int RIGHT_BORDER = size;
	public static final int LEFT_BORDER = 0;
	public static final int BOTTOM_BORDER = size;

	private int width;
	private int height;
	
	public Labyrinth(Vertex v) {
		width = size;
		height = size;
		graph = new Graph();
		graph.addVertex(v);
		rand = new Random();
		
		if(graph.contains(new Vertex(0,0)))
			System.out.println("OK");
		
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
		Directions directions[] = Directions.values();

		//pour chacune de ces directions, on avance en profondeur d'abord
		for(int i=0;i<4; i++) {
			Directions dir = directions[i];
			//TODO fonction en prédicat à implémenter si on garde l'exemple du prof
			if ((vertex.inBorders(dir,this)) & (graph.contains(vertex))) {
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
				graph.addVertex(next);
				graph.addEdge(vertex, next);
				buildRandomPath(next); 
				//TODO : ça marche pas !
			} 
		}
	}

	public void printGraph() {
		System.out.println(graph.toString());
	}
	
//	public void buildLabyrinth(Vertex v) {
//		int c;
//		for(int i=0; i<4; i++) {
//			c = rand.nextInt(4);
//			//System.out.println("c = "+ c);
//			Vertex v1 = new Vertex(v.getX(),v.getY());
//			if(c == Constants.D_NORTH) {
//				v1.setY(v1.getY()-1);
//				if(!graph.containsVertex(v1) && v1.getY()>=Constants.TOP_BORDER) {
//					System.out.println("NORTH");
//					graph.addVertex(v1);
//					graph.addEdge(v, v1);
//				}
//			}
//			else if(c == Constants.D_EAST) {
//				v1.setX(v1.getX()+1);
//				if(!graph.containsVertex(v1) && v1.getX()<Constants.RIGHT_BORDER) {
//					System.out.println("EAST");
//					graph.addVertex(v1);
//					graph.addEdge(v, v1);
//				}
//			}
//			else if(c == Constants.D_SOUTH) {
//				v1.setY(v1.getY()+1);
//				if(!graph.containsVertex(v1) && v1.getY()<Constants.BOTTOM_BORDER) {
//					System.out.println("SOUTH");
//					graph.addVertex(v1);
//					graph.addEdge(v, v1);
//				}
//			}
//			else if(c == Constants.D_WEST) {
//				v1.setX(v1.getX()-1);
//				if(!graph.containsVertex(v1) && v1.getX()>=Constants.LEFT_BORDER) {
//					System.out.println("WEST");
//					graph.addVertex(v1);
//					graph.addEdge(v, v1);
//				}
//			}
//			printGraph();
//			buildLabyrinth(v1);
//		}
//	}
	


}
