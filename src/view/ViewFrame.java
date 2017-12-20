package view;

import javafx.stage.Stage;
import model.BadBoyFactory;
import model.ButtonFactory;
import model.ButtonType;
import model.CandyFactory;
import model.Directions;
import model.DoorType;
import model.Edge;
import model.ExitDoorFactory;
import model.Graph;
import model.Labyrinth;
import model.PlayerFactory;
import java.util.ArrayList;
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
import javafx.scene.shape.Rectangle;


public class ViewFrame{

	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.WHITE;
	
	public static final int BAD_BOYS_NUMBER = 4;

	private Scene scene;
	private static Pane pane;

	private PlayerSprite playerSprite;
	private ArrayList<BadBoySprite> badBoySpriteList = new ArrayList<BadBoySprite>();
	private ArrayList<ButtonSprite> buttonSpriteList = new ArrayList<ButtonSprite>();
	private ArrayList<CandySprite> candySpriteList = new ArrayList<CandySprite>();
	private ExitSprite exitSprite = new ExitSprite();
	
	public ViewFrame() {
		
		//create player sprite
		this.playerSprite = PlayerFactory.getPlayerView();
		Controller.getInstance().setPlayerController(this.playerSprite.getController());
		
		//create bad guys
		for(int n = 0 ; n < BAD_BOYS_NUMBER; n++) {
			BadBoySprite sprite = BadBoyFactory.getBadBoyWithPosition();
			this.badBoySpriteList.add(sprite);
			Controller.getInstance().addBadBoyController(sprite.getController());
		}
		
		//create buttons
		for(Edge e : Controller.getLabyrinth().getDoorList()) {
			ButtonSprite btn1 = ButtonFactory.getButton(ButtonType.OPENER, e);
			ButtonSprite btn2 = ButtonFactory.getButton(ButtonType.CLOSER, e);
			buttonSpriteList.add(btn1);
			buttonSpriteList.add(btn2);
		}
		
		//create bad guys
		for(int n = 0 ; n < 6; n++) {
			CandySprite sprite = CandyFactory.getCandySprite();
			this.candySpriteList.add(sprite);
		}
		
		this.exitSprite = ExitDoorFactory.getExitDoorView();
		
		ViewFrame.pane = new Pane();
	}

	public void drawFrame(Stage stage, int nbrX, int nbrY) {
		scene = new Scene(pane, ((WALL+CELL)*nbrX+WALL)*SPAN, ((WALL+CELL)*nbrY+WALL)*SPAN);
		scene.setFill(SCENE_COLOR);

		Rectangle square;
		stage.setScene(scene);

		square = new Rectangle(0,0,SPAN*(nbrX*(CELL+WALL)+WALL),WALL*SPAN);
		square.setFill(WALL_COLOR);

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
			y = ((WALL+CELL) + (WALL+CELL)*((int)(ys+yt)/2)) * SPAN;
			xspan = CELL*SPAN; //
			yspan = WALL*SPAN; 
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		}
	}
	
	public void drawGraph(Graph g) {
		Edge e;
		for (int x = 0; x < Graph.WIDTH; x++) {
			for (int y = 0; y < Graph.HEIGHT; y++) {

				if (x + 1 < Graph.WIDTH) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x + 1, y));
					if (e == null || (e.getDoorType() != DoorType.NONE)) {
						drawWall(x, y, x + 1, y, WALL_COLOR);
						if (e != null && (e.getDoorType() == DoorType.OPENED)) {
							drawWall(x, y, x + 1, y, Color.RED);
						} else if (e != null && (e.getDoorType() == DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.GREEN);
						}
					}
				}

				if (y + 1 < Graph.HEIGHT) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x, y + 1));
					if (e == null || (e.getDoorType() != DoorType.NONE)) {
						drawWall(x, y, x, y + 1, WALL_COLOR);
						if (e != null && (e.getDoorType() == DoorType.OPENED)) {
							drawWall(x, y, x, y + 1, Color.GREEN);
						} else if (e != null && (e.getDoorType() == DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.RED);
						}
					}

				}
			}
		}
	}

	public void start(Stage stage, Labyrinth model) {
		
		stage.setTitle( "The MaZe!!" );

		//Draw Labyrinth
		drawFrame(stage, Labyrinth.size, Labyrinth.size);
		//Draw Graph
		drawGraph(model.getGraph());
		
		//Set canvas 
		Canvas canvas = new Canvas( ((WALL+CELL)*Labyrinth.size+WALL)*SPAN, ((WALL+CELL)*Labyrinth.size+WALL)*SPAN );
		pane.getChildren().add(canvas);

		//Set keyboard events
		this.keyboarEvents(scene);

		//Create Graphic context
		GraphicsContext gc = canvas.getGraphicsContext2D();

		
		//Set initial position badboys sprites
		for(ButtonSprite buttonSprite : buttonSpriteList) {
			buttonSprite.render(gc);
		}
		
		//Set initial position player sprite
		playerSprite.render(gc);
		
		//Set initial position badboys sprites
		for(BadBoySprite badSprite : badBoySpriteList) {
			badSprite.render(gc);
		}
		
		for(CandySprite candySprite : candySpriteList) {
			candySprite.render(gc);
		}
		
		exitSprite.render(gc);
		
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

				//Redraw elements
				gc.clearRect(0, 0, ((WALL+CELL)*Labyrinth.size+WALL)*SPAN, ((WALL+CELL)*Labyrinth.size+WALL)*SPAN );
				
				for(ButtonSprite buttonSprite : buttonSpriteList) 
					buttonSprite.render(gc);
				
				playerSprite.render(gc);
				
				for(BadBoySprite badSprite : badBoySpriteList) 
					badSprite.render(gc);
				
				for(CandySprite candySprite : candySpriteList) 
					candySprite.render(gc);
				
				exitSprite.render(gc);
				
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
						if (e.getCode() == KeyCode.S) {
							Controller.getInstance().startBadBoysSearch();
						}
						if (e.getCode() == KeyCode.D) {
							Controller.getInstance().stopBadBoysSearch();
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
