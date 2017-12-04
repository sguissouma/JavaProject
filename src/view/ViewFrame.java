package view;

import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;


public class ViewFrame {
	private void print(String s) {
		System.out.println(s);
	}	
	
	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.WHITE;
	
	private Scene scene;
	private static Pane pane;
	
	public ViewFrame() {
		ViewFrame.pane = new Pane();
	}
	
	public void drawFrame(Stage stage, int nbrX, int nbrY) {
		scene = new Scene(pane, ((WALL+CELL)*nbrX+WALL)*SPAN, ((WALL+CELL)*nbrY+WALL)*SPAN);
		scene.setFill(SCENE_COLOR);
		
		Rectangle square;
		stage.setScene(scene);
		
		square = new Rectangle(0,0,SPAN*(nbrX*(CELL+WALL)+WALL),WALL*SPAN);
		square.setFill(WALL_COLOR);
		
		//pane.getChildrenUnmodifiable().add(square);
		
		pane.getChildren().add(square);
		
		square = new Rectangle(0,SPAN*(nbrY*(CELL+WALL)),SPAN*(nbrX*(CELL+WALL)+WALL),WALL*SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(0,0,WALL*SPAN,SPAN*(nbrY*(CELL+WALL)+WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		square = new Rectangle(SPAN*(nbrX*(CELL+WALL)),0,WALL*SPAN,SPAN*(nbrY*(CELL+WALL)+WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);
		
		for	(int x = 0; x < nbrX - 1;++x){
		int	offsetX = ((WALL+CELL) + (WALL+CELL)*x)*SPAN;
			for(int	y = 0; y<nbrY-1;++y){
				int	offsetY = ((WALL+CELL) + (WALL+CELL)*y)*SPAN;
				square = new Rectangle(offsetX, offsetY,WALL*SPAN, WALL*SPAN);
				square.setFill(WALL_COLOR);
				pane.getChildren().add(square);
			}
		}
	}

	public static void drawWall(int xs, int	ys,	int	xt, int	yt, Paint color){
		int	x = 0, y = 0, xspan = 0, yspan = 0;
		if(ys==yt){
			x = ((WALL+CELL)+(WALL+CELL)*((int)(xs+xt)/2))*SPAN;
			y = (WALL+ ys*(WALL+CELL))*SPAN;
			xspan = WALL*SPAN;
			yspan = CELL*SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		}
		else if(xs==xt){
			x = (WALL+ xs*(WALL+CELL))*SPAN;
			y = ((WALL+CELL) + (WALL+CELL)*((int)(ys+yt)/2))*SPAN;
			xspan = CELL*SPAN;
			yspan = WALL*SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		}
	}

	public void start(Stage stage, int width, int height) {
		drawFrame(stage, width,height);
		stage.show();
	}
}
