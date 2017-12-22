package view;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

/**
 * Class which represents the Sprite ( http://en.wikipedia.org/wiki/Sprite_(computer_graphics) )
 * Sprite is created with an image.
 * In addition to the image, this class also tries to maintain other options such as position, height and even the speed (contemplated for future versions).
 * @author Carlos Villavicencio
 * @version 1.0
 */
public class Sprite
{
	private Image image;
	private double positionX;
	private double positionY;    
	private double width;
	private double height;
	private double velocityX;
	private double velocityY;

	/**
	 * Constructor method for Sprite
	 */
	public Sprite()
	{
		positionX = 0;
		positionY = 0;  
		velocityX = 0;
		velocityY = 0;
	}

	/**
	 * Set image to image property in Sprite.
	 * @param i a provided image.
	 */
	public void setImage(Image i)
	{
		image = i;
		width = i.getWidth();
		height = i.getHeight();
	}

	/**
	 * Set image to image property in Sprite using a filename.
	 * @param filename is the name of the file that will be loaded into the image.
	 */
	public void setImage(String filename)
	{

		try {
			Image i = new Image(filename);
			/*new Image(filename,
        	     width,
        	     height,
        	     true,
        	     true);*/
			setImage(i);
		}catch(Exception e) {
			System.out.println("No image loaded: "+ e.getMessage());
		}
	}

	/**
	 * Set the coordinates of the Sprite
	 * @param x coordinate x
	 * @param y coordinate y
	 */
	public void setPosition(double x, double y)
	{
		positionX = x *44 + (ViewFrame.SPAN*2) + (36-width)/2;
		positionY = y *44 + (ViewFrame.SPAN*2) + (36-height)/2;
	}

	/**
	 * Set the sprite velocity in the draw context.
	 * @param x velocity in x
	 * @param y velocity in y
	 */
	public void setVelocity(double x, double y)
	{
		velocityX = x;
		velocityY = y;
	}

	/**
	 * Increase the sprite velocity in the draw context.
	 * @param x velocity in x
	 * @param y velocity in y
	 */
	public void addVelocity(double x, double y)
	{
		velocityX += x;
		velocityY += y;
	}

	/**
	 * Get the sprite width
	 * @return the sprite width
	 */
	public double getWidth() {
		return image.getWidth();
	}
	
	/**
	 * Get the sprite height
	 * @return the sprite height
	 */
	public double getHeight() {
		return image.getHeight();
	}

	/**
	 * Used to update the sprite position
	 * @param time time used to calculate the velocity
	 */
	public void update(double time)
	{
		positionX +=  velocityX * time;
		positionY +=  velocityY * time;
	}

	/**
	 * Render the sprite in Canvas.
	 * @param gc A graphics context represents a drawing destination.
	 */
	public void render(GraphicsContext gc)
	{
		gc.drawImage( image, positionX, positionY );
	}

	/**
	 * Gets the sprite Rectangle used to describe the bounds of an object.
	 * @return A bounds of the object.
	 */
	public Rectangle2D getBoundary()
	{
		return new Rectangle2D(positionX,positionY,width,height);
	}
	/**
	 * Test an intersection or collision (used for futures implementations)
	 * @param s another sprite to check with itself
	 * @return returns true if detects a collision, false if not.
	 */
	public boolean intersects(Sprite s)
	{
		return s.getBoundary().intersects( this.getBoundary() );
	}

}