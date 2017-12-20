package view;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class Sprite
{
	private Image image;
	private double positionX;
	private double positionY;    
	private double width;
	private double height;
	private double velocityX;
	private double velocityY;

	public Sprite()
	{
		positionX = 0;
		positionY = 0;  
		velocityX = 0;
		velocityY = 0;
	}

	public void setImage(Image i)
	{
		image = i;
		width = i.getWidth();
		height = i.getHeight();
	}

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

	public void setPosition(double x, double y)
	{
		positionX = x *44 + (ViewFrame.SPAN*2) + (36-width)/2;
		positionY = y *44 + (ViewFrame.SPAN*2) + (36-height)/2;
	}

	public void setVelocity(double x, double y)
	{
		velocityX = x;
		velocityY = y;
	}

	public void addVelocity(double x, double y)
	{
		velocityX += x;
		velocityY += y;
	}

	public double getWidth() {
		return image.getWidth();
	}

	public double getHeight() {
		return image.getHeight();
	}

	public void update(double time)
	{
		positionX +=  velocityX * time;
		positionY +=  velocityY * time;
	}

	public void render(GraphicsContext gc)
	{
		gc.drawImage( image, positionX, positionY );
	}

	public Rectangle2D getBoundary()
	{
		return new Rectangle2D(positionX,positionY,width,height);
	}

	public boolean intersects(Sprite s)
	{
		return s.getBoundary().intersects( this.getBoundary() );
	}

	public String toString()
	{
		return " Position: [" + positionX + "," + positionY + "]";
	}
}