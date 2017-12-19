package model;

import java.util.Observable;
import java.util.Observer;

public class Door implements Observer{
	
	Edge edge;
	
	public Door(Edge edge){
		this.edge = edge;
	}
	
	public void setEdge(Edge edge){
		this.edge = edge;
	}

	public Edge getEdge(){
		return this.edge;
	}
		
	public void closeDoor() {
		edge.setDoorType(DoorType.CLOSED);		
	}
	
	public void openDoor() {
		edge.setDoorType(DoorType.OPENED);		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (edge.getDoorType() == DoorType.CLOSED) {
			openDoor();
		}else {
			closeDoor();
		}
	}
	
}
