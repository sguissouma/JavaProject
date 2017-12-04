package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class GameDisplay extends Canvas {

	private static final long serialVersionUID = 1L;
	
	private int WIDTH;
	private int HEIGHT;
	public static final int SCALE = 50; //the size of one square in the labyrinth
	
	private BufferedImage image;
	private int[] pixels;
	
	public GameDisplay(int w, int h) {
		super();
		WIDTH = w;
		HEIGHT = h;
		
		setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		for(int i=0; i<pixels.length; i++) {
			pixels[i] = 0xffffff;
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs==null) {
			createBufferStrategy(2); //double buffering should suffice
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
//		g.setColor(Color.WHITE);
//		g.fillRect(0, 0, getWidth(), getHeight());
		
		for(int i=0; i<pixels.length; i++) {
			pixels[i] = 0xffffff;
		}
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
		
	}
	
	
}
