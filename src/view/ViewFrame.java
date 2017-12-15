package view;

import javafx.stage.Stage;
import javafx.util.Duration;
import model.Directions;
import model.PlayerFactory;
import controller.Controller;
import javafx.event.EventHandler;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;


public class ViewFrame{

	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.WHITE;

	private Scene scene;
	private static Pane pane;

	private PlayerSprite playerSprite;

	public ViewFrame() {
		//create player sprite
		this.playerSprite = PlayerFactory.getPlayerView();
		//assign labyrinth controller
		Controller.getInstance().setPlayerController(this.playerSprite.getController());
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
		stage.setTitle( "The MaZe!!" );

		//Draw Labyrinth
		drawFrame(stage, width,height);

		//Set canvas 
		Canvas canvas = new Canvas( ((WALL+CELL)*width+WALL)*SPAN, ((WALL+CELL)*height+WALL)*SPAN );
		pane.getChildren().add(canvas);

		//Set keyboard events
		this.keyboarEvents(scene);

		//Create Graphic context
		GraphicsContext gc = canvas.getGraphicsContext2D();

		//Set player sprite
		playerSprite.setImage("/images/player.png");
		playerSprite.setPosition(SPAN*2, SPAN*2);
		playerSprite.render(gc);

		LongValue lastNanoTime = new LongValue(System.nanoTime());

		//Animation Loop
		new AnimationTimer()
		{
			public void handle(long currentNanoTime)
			{
				// calculate time since last update.
				double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
				lastNanoTime.value = currentNanoTime;

				//playerSprite.update(elapsedTime);

				gc.clearRect(0, 0, ((WALL+CELL)*width+WALL)*SPAN, ((WALL+CELL)*height+WALL)*SPAN );
				playerSprite.render(gc);
			}
		}.start();


		stage.show();
	}


	private void keyboarEvents(Scene theScene){
		theScene.setOnKeyPressed(
				new EventHandler<KeyEvent>()
				{
					public void handle(KeyEvent e)
					{
						if (e.getCode() == KeyCode.LEFT) {
							Controller.getInstance().movePlayer(Directions.WEST);
						}
						if (e.getCode() ==KeyCode.RIGHT) {
							Controller.getInstance().movePlayer(Directions.EAST);
						}
						if (e.getCode() == KeyCode.UP) {
							Controller.getInstance().movePlayer(Directions.NORTH);
						}
						if (e.getCode() == KeyCode.DOWN) {
							Controller.getInstance().movePlayer(Directions.SOUTH);
						}
					}
				});
	}



	private class LongValue
	{
		public long value;

		public LongValue(long i)
		{
			value = i;
		}
	}

}
