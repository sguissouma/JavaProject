/**
 * 
 */
package model;

/**
 * @author Carlos Villavicencio
 *
 */
public abstract class LabyrinthElement {

	Coord2D position;
	LabyrinthElementType type;
	String imageName;
	boolean active;
	
	public LabyrinthElement(int xPosition, int yPosition, LabyrinthElementType type, String imageName) {
		this.position = new Coord2D(xPosition,yPosition);
		this.type = type;
		this.imageName = imageName;
		this.active = true;
	}
	
	public Coord2D getPosition(){
		return this.position;
	}
	
	public void setPosition(int x, int y){
		this.position = new Coord2D(x,y);
	}
	
	public LabyrinthElementType getType(){
		return this.type;
	}

	public boolean isActive(){
		return this.active;
	}

	public String getImageName() {
		return this.imageName;
	}
	public void setActive(boolean active){
		this.active = active;
	}
}
