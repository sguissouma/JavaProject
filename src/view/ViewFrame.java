package view;

import javafx.stage.Stage;
import model.ButtonType;
import model.Directions;
import model.DoorType;
import model.Edge;
import model.Graph;
import model.Labyrinth;
import model.factory.BadBoyFactory;
import model.factory.ButtonFactory;
import model.factory.CandyFactory;
import model.factory.ExitDoorFactory;
import model.factory.PlayerFactory;
import java.util.ArrayList;
import controller.LabyrinthController;
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

/**
 * This is the main view of the game. All Human/Computer interactions with the player will be made here.
 * @author Carlos Villavicencio
 * @version 1.0
 */

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
	private ArrayList<BadBoySprite> badBoySpriteList;
	private ArrayList<ButtonSprite> buttonSpriteList;
	private ArrayList<CandySprite> candySpriteList;
	private ExitSprite exitSprite;
	private ArrayList<RectangleShape> doorList;

	/**
	 * Class constructor of ViewFrame
	 */
	public ViewFrame() {

		//create player sprite
		this.playerSprite = PlayerFactory.createPlayer();
		LabyrinthController.getInstance().setPlayerController(this.playerSprite.getController());

		//create bad guys
		badBoySpriteList = new ArrayList<BadBoySprite>();
		for(int n = 0 ; n < BAD_BOYS_NUMBER; n++) {
			BadBoySprite badSprite = BadBoyFactory.createBadBoy();
			this.badBoySpriteList.add(badSprite);
			LabyrinthController.getInstance().addBadBoyController(badSprite.getController());
			LabyrinthController.getInstance().getLabyrinth().addElement(badSprite.getBadBoy());
		}

		//create buttons
		buttonSpriteList = new ArrayList<ButtonSprite>();
		for(Edge e : LabyrinthController.getInstance().getLabyrinth().getDoorList()) {
			ButtonSprite btn1 = ButtonFactory.createButton(ButtonType.OPENER, e);
			ButtonSprite btn2 = ButtonFactory.createButton(ButtonType.CLOSER, e);
			buttonSpriteList.add(btn1);
			buttonSpriteList.add(btn2);
			//Add element to labyrinth
			LabyrinthController.getInstance().getLabyrinth().addElement(btn1.getButton());
			LabyrinthController.getInstance().getLabyrinth().addElement(btn2.getButton());
		}

		//create bad guys
		candySpriteList = new ArrayList<CandySprite>();
		for(int n = 0 ; n < 6; n++) {
			CandySprite candySprite = CandyFactory.createCandy();
			this.candySpriteList.add(candySprite);
			LabyrinthController.getInstance().getLabyrinth().addElement(candySprite.getCandy());
		}

		//create exit door
		this.exitSprite = ExitDoorFactory.createExitDoor();
		LabyrinthController.getInstance().getLabyrinth().addElement(this.exitSprite.getExit());

		this.doorList = new ArrayList<RectangleShape>();
		
		ViewFrame.pane = new Pane();
	}

	/**
	 * Method to create the game frame without walls or doors.
	 * @param stage The JavaFX Stage instance represents the level JavaFX container.
	 * @param nbrX columns numbers in X
	 * @param nbrY rows numbers in Y
	 */
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

	/**
	 * Method to create walls and doors.
	 * 
	 * @param xs start position x
	 * @param ys start position y
	 * @param xt end position x
	 * @param yt end position y
	 * @param color wall color
	 * @param e edge with a type wall or door
	 */
	public void drawWall(int xs, int	ys,	int	xt, int	yt, Paint color, Edge e){
		int	x = 0, y = 0, xspan = 0, yspan = 0;
		if(ys==yt){
			x = ((WALL+CELL)+(WALL+CELL)*((int)(xs+xt)/2))*SPAN;
			y = (WALL+ ys*(WALL+CELL))*SPAN;
			xspan = WALL*SPAN;
			yspan = CELL*SPAN;
			RectangleShape square = new RectangleShape(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
			
			if (e!= null && e.getDoorType() != DoorType.NONE) {
				square.setEdge(e);
				this.doorList.add(square);
			}
		}
		else if(xs==xt){
			x = (WALL+ xs*(WALL+CELL))*SPAN;
			y = ((WALL+CELL) + (WALL+CELL)*((int)(ys+yt)/2)) * SPAN;
			xspan = CELL*SPAN; //
			yspan = WALL*SPAN; 
			RectangleShape square = new RectangleShape(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
			
			if (e!= null && e.getDoorType() != DoorType.NONE) {
				square.setEdge(e);
				this.doorList.add(square);
			}
		}
	}

	/**
	 * Draw the labyrinth using the graph.
	 * 
	 * @param g graph that contains the information to draw the labyrinth.
	 */
	public void drawGraph(Graph g) {
		Edge e;
		for (int x = 0; x < Graph.WIDTH; x++) {
			for (int y = 0; y < Graph.HEIGHT; y++) {

				if (x + 1 < Graph.WIDTH) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x + 1, y));
					if (e == null || (e.getDoorType() != DoorType.NONE)) {
						drawWall(x, y, x + 1, y, WALL_COLOR,e);
						if (e != null && (e.getDoorType() == DoorType.OPENED)) {
							drawWall(x, y, x + 1, y, Color.RED,e);
						} else if (e != null && (e.getDoorType() == DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.GREEN,e);
						}
					}
				}

				if (y + 1 < Graph.HEIGHT) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x, y + 1));
					if (e == null || (e.getDoorType() != DoorType.NONE)) {
						drawWall(x, y, x, y + 1, WALL_COLOR,e);
						if (e != null && (e.getDoorType() == DoorType.OPENED)) {
							drawWall(x, y, x, y + 1, Color.GREEN,e);
						} else if (e != null && (e.getDoorType() == DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.RED,e);
						}
					}

				}
			}
		}
	}

	/**
	 * Method where the labyrinth is drawn and where the animations are made.
	 * @param stage The JavaFX Stage object it represents the JavaFX container
	 * @param model The Labyrinth
	 */
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

		//LongValue lastNanoTime = new LongValue(System.nanoTime());

		//Animation Loop
		new AnimationTimer()
		{
			public void handle(long currentNanoTime)
			{
				
				// calculate time since last update.
				//double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
				//lastNanoTime.value = currentNanoTime;

				
				//Collision detection
				LabyrinthController.getInstance().detectCollitions(); 
				
				
				//Redraw elements
				gc.clearRect(0, 0, ((WALL+CELL)*Labyrinth.size+WALL)*SPAN, ((WALL+CELL)*Labyrinth.size+WALL)*SPAN );

				for(ButtonSprite buttonSprite : buttonSpriteList) 
					buttonSprite.render(gc);

				playerSprite.render(gc);

				for(BadBoySprite badSprite : badBoySpriteList) 
					badSprite.render(gc);

				for(CandySprite candySprite : candySpriteList) 
					if(candySprite.getCandy().isActive())
						candySprite.render(gc);

				exitSprite.render(gc);
				
				for(RectangleShape door : doorList) {
					if (door.getEdge().getDoorType() == DoorType.OPENED)
						door.setFill(Color.GREEN);
					else
						door.setFill(Color.RED);
				} 


			}
		}.start();


		stage.show();
		
		//start search
		LabyrinthController.getInstance().startBadBoysSearch();
	}

	/**
	 * Method to detect keyboard events in the scene.
	 * 
	 * @param theScene The JavaFX Stage object it represents the JavaFX container
	 */
	private void keyboarEvents(Scene theScene){
		theScene.setOnKeyPressed(
				new EventHandler<KeyEvent>()
				{
					public void handle(KeyEvent e)
					{
						if (e.getCode() == KeyCode.LEFT) {
							LabyrinthController.getInstance().movePlayer(Directions.WEST);
						}
						if (e.getCode() ==KeyCode.RIGHT) {
							LabyrinthController.getInstance().movePlayer(Directions.EAST);
						}
						if (e.getCode() == KeyCode.UP) {
							LabyrinthController.getInstance().movePlayer(Directions.NORTH);
						}
						if (e.getCode() == KeyCode.DOWN) {
							LabyrinthController.getInstance().movePlayer(Directions.SOUTH);
						}
						/*if (e.getCode() == KeyCode.S) {
							Controller.getInstance().startBadBoysSearch();
						}
						if (e.getCode() == KeyCode.D) {
							Controller.getInstance().stopBadBoysSearch();
						}*/
					}
				});
	}

	/**
	 * Tool class used to save a floating number for the FPS (frames per second). It was intended for use in future advanced animations.
	 * 
	 * @author Carlos Villavicencio
	 * @version 1.0
	 */
	@SuppressWarnings("unused")
	private class LongValue
	{
		public long value;

		/**
		 * Set method for a long value.
		 * 
		 * @param i a long type number
		 */
		public LongValue(long i)
		{
			value = i;
		}
	}

}
