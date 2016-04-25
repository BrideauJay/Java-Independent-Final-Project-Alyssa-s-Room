import javafx.application.Application;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.layout.AnchorPane;

public class AlyssasRoom extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		
		/**
		 * SETUP
		 */
		
		/** initialize data for room width and height */
		final double ROOM_WIDTH = 600;
		
		final double ROOM_HEIGHT = 400;
		
		/** create the window, or world, the project will live in */
		StackPane world = new StackPane();

		/**Create a dark background for any part of the window outside the room
		 * This will draw focus to the room, where all functioning code and playable game is
		 */
		Pane background = new Pane();
		Rectangle color = new Rectangle();
		color.widthProperty().bind(world.widthProperty());// bind background to
															// window size
		color.heightProperty().bind(world.heightProperty());
		Color darkPurple = new Color(.146, .16, .206, 1); // create custom background color
		color.setFill(darkPurple);
		background.getChildren().add(color);// add color to pane
		world.getChildren().add(background);// add pane to world

		/**
		 * Create the room the user will interact with. It will be a different
		 * color to set it apart from the background, and will stay centered in
		 * the window. It will hold the furniture, items, and player
		 */
		StackPane room = new StackPane();
		Rectangle roomColor = new Rectangle();
		roomColor.setWidth(ROOM_WIDTH);// set unchanging width and height using data set up 	
		roomColor.setHeight(ROOM_HEIGHT); //earlier
		roomColor.setFill(Color.LIGHTSKYBLUE); //set color of room
		room.getChildren().add(roomColor);// add rectangle of color to create visual room
		
		/** make AnchorPane to precisely position furniture and items
		 * and make the pane the size of the room */
		AnchorPane furnitureLayout = new AnchorPane();
		furnitureLayout.setMaxSize(ROOM_WIDTH, ROOM_HEIGHT);

		
		
		
		/**
		 * MAKE FURNITURE
		 */
		
		
		/** make the bed */
		
		/** make a stackpane for the bed */
		StackPane bedStack = new StackPane();

		/** make a bed Furniture instance */
		Furniture bed = new Furniture(new Rectangle(20, 20, 200, 100), Color.BLUEVIOLET);

		/** add a pillow to the bed */
		Item pillow = new Item(bed, "A regular pillow.", "Looks like it's been in a few fights. Pillow fights.",
				new Rectangle(0, 0, 50, 70), Color.AQUAMARINE);
		bed.addItem(pillow);

		/** add bed and its items to the world*/
		addNewFurniture(bed, 20, 20, bedStack, furnitureLayout, 10, 15);

		
		
		/** make a dresser */

		/** make a stackpane for the dresser and its items */
		StackPane dresserStack = new StackPane();

		/** make a dresser Furniture instance */
		Furniture dresser = new Furniture(new Rectangle(450, 300, 140, 70), Color.BROWN);

		/** make a hairbrush and add it to the dresser*/
		Clue hairbrush = new Clue(dresser,
				"If Alyssa didn't use this hairbrush, who did? Maybe they left some of their hair in it. I should take this and take a closer look later.",
				"A hairbrush. There's still some hair caught in it.",
				"Weird. I didn't think Alyssa would have a hairbrush.", new Rectangle(0, 0, 30, 10), Color.MAGENTA);
		dresser.addItem(hairbrush);
		
		/** add dresser and its items to world */
		addNewFurniture(dresser, 450, 300, dresserStack, furnitureLayout, 10, 5);

		
		
		/** make a set of shelves */

		/** make a stackpane for the shelves */
		StackPane shelvesStack = new StackPane();

		/** make a set of shelves Furniture instance */
		Furniture shelves = new Furniture(new Rectangle(470, 10, 100, 150), Color.CHOCOLATE);

		/** make a book and add it to the shelves */
		Item book = new Item(shelves, "A yearbook from last year.", "It's for Alyssa's fancy private school",
				new Rectangle(0, 0, 4, 40), Color.DIMGRAY);
		shelves.addItem(book);

		// add dresser and its items to world
		//addFurniture(shelves, shelvesPane, furnitureLevel, 3, 0, 85, 15);
		
		/** add dresser and its items to world */
		addNewFurniture(shelves, 470, 10, shelvesStack, furnitureLayout, 85, 15);
		
		/** add furniture AnchorPane to room */
		room.getChildren().add(furnitureLayout);
		
		
		
		
		/**
		 * PLAYER
		 */

		/** create pane for player to move around in */
		AnchorPane playerMove = new AnchorPane();
		playerMove.setMaxSize(ROOM_WIDTH, ROOM_HEIGHT); //set player's AnchorPane to 
														//room size

		/** create Player */
		Player sarah = new Player("Sarah", new Point2D(250, 250), Color.CORNSILK);

		/** add player to AnchorPane */
		playerMove.getChildren().add(sarah.getSprite());

		/** add player's pane to world */
		room.getChildren().add(playerMove);

		
		
		/** add room to world */
		world.getChildren().add(room);
		
		
		
		
		/**
		 * KEY INPUT
		 */
		
		/** let key presses move player character and interact with items */
		sarah.getSprite().setOnKeyPressed(e -> {
			switch (e.getCode()){
			case UP: if (sarah.getY() > 0){ //if up arrow pressed and player within room,
				sarah.setY(sarah.getY() - 10);} break; //player moves up
			case DOWN: if (sarah.getY() < ROOM_HEIGHT - 130){ //down arrow and player in room
				sarah.setY(sarah.getY() + 10);} break; //player moves down
			case LEFT: if (sarah.getX() == 5){ //if left arrow pressed and player within room
				sarah.setX(sarah.getX() - 5);//too close to wall, move left a little
				} else if (sarah.getX() > 0){ //far enough from wall,
					sarah.setX(sarah.getX() - 10);} break; //move left normal amount
			case RIGHT: if (sarah.getX() < ROOM_WIDTH - 70){//right arrow pressed
				sarah.setX(sarah.getX() + 10); //far from wall, move right normal
				} else if (sarah.getX() < ROOM_WIDTH - 65){//too close to wall,
					sarah.setX(sarah.getX() + 5);} break; //move right a little
			case SPACE: /**allow for interaction with items by spacebar*/
				if (sarah.getCorner().distance(hairbrush.getCorner().add(dresser.getCorner())) < 100){
					hairbrush.setColor(Color.AQUA);
				} 
				if (sarah.getCorner().distance(book.getCorner().add(shelves.getCorner())) < 100){
					book.setColor(Color.AQUA);
				} 
				if (sarah.getCorner().distance(pillow.getCorner().add(bed.getCorner())) < 100){
					pillow.setColor(Color.AQUA);
				} break;
			}
		});
		
		
		
		
		/**
		 * SCENE AND STAGE SETUP
		 */

		/** create scene to hold the room, set title, and display */
		Scene scene = new Scene(world, 600, 400);
		primaryStage.setTitle("Alyssa's Room");
		primaryStage.setScene(scene);
		primaryStage.show();

		sarah.getSprite().requestFocus();
	}

	
	/**
	 * Create new method for adding furniture to a specific X and Y coordinate in the window
	 * @param furniture
	 * @param furnX
	 * @param furnY
	 * @param pane
	 * @param layout
	 * @param itemX
	 * @param itemY
	 */
	public void addNewFurniture(Furniture furniture, double furnX, double furnY, 
			StackPane pane, AnchorPane layout, double itemX, double itemY){
		
		/** add furniture to its StackPane*/
		pane.getChildren().add(furniture.getSprite());
		
		/** get items held by furniture */
				ArrayList<Item> itemsHeld = furniture.getItems();

				/** create AnchorPane to position items */
				AnchorPane items = new AnchorPane();
				/** set borderpane's size to size of furniture item */
				double width = ((Rectangle) furniture.getSprite()).getWidth();
				double height = ((Rectangle) furniture.getSprite()).getHeight();
				items.setMaxSize(width, height);

				/** add items to its anchor pane */
				for (Item i : itemsHeld){
					Rectangle itemSprite = (Rectangle) i.getSprite();
					itemSprite.setX(itemX);
					itemSprite.setY(itemY);
					items.getChildren().add(itemSprite);
				}
				pane.getChildren().add(items);
				
				/** set x and y of StackPane */
				pane.setLayoutX(furnX);
				pane.setLayoutY(furnY);
				
				/** add furniture StackPane to window */
				layout.getChildren().add(pane);
				
		
	}

	/** the main function*/
	public static void main(String[] args) {
		Application.launch(args);

	}

}

