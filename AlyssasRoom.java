import javafx.application.Application;
import javafx.scene.text.*;
import javafx.scene.control.Label;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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

		/**
		 * Create a dark background for any part of the window outside the room
		 * This will draw focus to the room, where all functioning code and
		 * playable game is
		 */
		/** create rectangle to hold background color */
		Pane background = new Pane();
		Rectangle color = new Rectangle();
		/** bind rectangle of background color to window size */
		color.widthProperty().bind(world.widthProperty());
		color.heightProperty().bind(world.heightProperty());
		/** create a custom background color for background and set it */
		Color darkPurple = new Color(.146, .16, .206, 1);
		color.setFill(darkPurple);
		/** add background color to pane */
		background.getChildren().add(color);
		/** add background pane to world */
		world.getChildren().add(background);

		/**
		 * Create the room the user will interact with. It will be a different
		 * color to set it apart from the background, and will stay centered in
		 * the window. It will hold the furniture, items, and player
		 */
		/** create pane and rectangle for room */
		StackPane room = new StackPane();
		Rectangle roomColor = new Rectangle();
		/** set an unchanging width and height for the playable room using data input earlier */
		roomColor.setWidth(ROOM_WIDTH);
		roomColor.setHeight(ROOM_HEIGHT); 
		/** set the color of the room to distinguish it from the background */
		roomColor.setFill(Color.LIGHTSKYBLUE); 
		/** add the rectangle of color to the pane to create the visual room */
		room.getChildren().add(roomColor);

		/**
		 * make AnchorPane to precisely position furniture and items and make
		 * the pane the size of the room
		 */
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

		/** add bed and its items to the world */
		addNewFurniture(bed, 20, 20, bedStack, furnitureLayout, 10, 15);

		/** make a dresser */

		/** make a stackpane for the dresser and its items */
		StackPane dresserStack = new StackPane();

		/** make a dresser Furniture instance */
		Furniture dresser = new Furniture(new Rectangle(450, 300, 140, 70), Color.BROWN);

		/** make a hairbrush and add it to the dresser */
		Clue hairbrush = new Clue(dresser,
				"If Alyssa didn't use this hairbrush, who did?\nMaybe they left some of their hair in it.\nI should take a closer look later.",
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
		Item book = new Item(shelves, "A yearbook from last year.", "It's for Alyssa's fancy private school.",
				new Rectangle(0, 0, 4, 40), Color.DIMGRAY);
		shelves.addItem(book);

		/** add dresser and its items to world */
		addNewFurniture(shelves, 470, 10, shelvesStack, furnitureLayout, 85, 15);

		/** add furniture AnchorPane to room */
		room.getChildren().add(furnitureLayout);

		/**
		 * PLAYER
		 */

		/** create pane for player to move around in */
		AnchorPane playerMove = new AnchorPane();
		/** set the size of the pane the Player can move in to the size of the room */
		playerMove.setMaxSize(ROOM_WIDTH, ROOM_HEIGHT); 

		/** create Player */
		Player sarah = new Player("Sarah", new Point2D(100, 250), Color.CORNSILK);

		/** add player to AnchorPane */
		playerMove.getChildren().add(sarah.getSprite());

		/** add player's pane to world */
		room.getChildren().add(playerMove);

		/** create a pane to hold information and reactions to items */
		StackPane messages = new StackPane();
		messages.setMaxSize(460, 260);

		/** display controls when window is first launched */
		// giveControls(messages);

		/** add room to world */
		world.getChildren().add(room);

		/** add message pane to world */
		world.getChildren().add(messages);

		/**
		 * KEY INPUT
		 */

		/** let key presses move player character and interact with items */
		sarah.getSprite().setOnKeyPressed(e -> {
			switch (e.getCode()) {

			case UP:
				/** check player is within the confines of the room */
				if (sarah.getY() > 0 && 
						/**CHECK FOR SHELVES OVERLAP */
						/** check that the right side of the player's sprite
						 * is not overlapping the shelves */
						(!((sarah.getX() > (shelves.getX() - 70)) &&
								/** check that Player's 'feet' (bottom of sprite)
								 * don't overlap shelves*/
				(sarah.getY() < (shelves.getY() + 35)))) 
						/** CHECK FOR DRESSER OVERLAP */
						/** check that right side of player sprite doesn't overlap dresser */
						&& (!((sarah.getX() > (dresser.getX() - 65)) 
						/** check that player's 'feet' don't climb dresser */
								&& (sarah.getY() > (dresser.getY() - 70)) 
						/** ensure player can still move in front of the dresser */
						&& (sarah.getY() < (dresser.getY() - 40)) 
						))

				) { 
					/** if all conditions met, player moves up */
					sarah.setY(sarah.getY() - 10); 
				}
				break;
			case DOWN:
				/** check player is within confines of room */
				if (sarah.getY() < ROOM_HEIGHT - 130 
						/** CHECK FOR DRESSER OVERLAP */
						/** check that right side of player sprite doesn't overlap dresser */
						&& (!((sarah.getX() > (dresser.getX() - 65)) 
						/** check that player doesn't walk over dresser */
								&& (sarah.getY() > (dresser.getY() - 135))
						/** ensure player can move in front of dresser */
								&&(!(sarah.getY() > (dresser.getY() - 60)))
						))
						) {
					/** if conditions met, player moves down */
					sarah.setY(sarah.getY() + 10); 
				}
				break;
			case LEFT:
				/** if player is close to left wall, ensure they don't move out of room */
				if (sarah.getX() == 5) { 
					/** move left by only 5 so sprite doesn't leave room */
					sarah.setX(sarah.getX() - 5);
					/** if player far from wall, let them move normally */
				} else if (sarah.getX() > 0) { 
					/** move left normally */
					sarah.setX(sarah.getX() - 10); 
				}
				break;
			case RIGHT:
				/** if player well within room, 
				 * move normally */
				if (sarah.getX() < ROOM_WIDTH - 70 && 
						/** CHECK FOR SHELVES OVERLAP */
						/** check right side of sprite not overlapping */
				(!((sarah.getX() > (shelves.getX() - 75)) && 
						/** movement only restricted if shelf is in the way (by height/Y) */
				(sarah.getY() < (shelves.getY() + 30))))
				/** CHECK FOR DRESSER OVERLAP */
				/** check player sprite's right side doesn't overlap */
				&& (!((sarah.getX() > (dresser.getX() - 75))
						/** but only if they would run into the dresser */
						&& (sarah.getY() > (dresser.getY() - 130))
						/** ensure player can move in front of the dresser */
						&&(!(sarah.getY() > (dresser.getY() - 60)))
						))
				) {
					/** if conditions met, move player right */
					sarah.setX(sarah.getX() + 10); 
					/** if player too close to wall, 
					 * prevent them leaving room */
				} else if (sarah.getX() < ROOM_WIDTH - 65 && 
						/** CHECK FOR SHELVES OVERLAP */
						/** check if player sprite's right side overlaps shelves */
						(!((sarah.getX() > (shelves.getX() - 70)) 
								/** check if player 'feet' would overlap dresser by moving right */
								&& (sarah.getY() < (shelves.getY() + 30))))
						/** CHECK FOR DRESSER OVERLAP */
						/** check if right hand side of player would overlap dresser */
						&& (!((sarah.getX() > (dresser.getX() - 70))
								/** check if player feet would overlap dresser */
								&& (sarah.getY() > (dresser.getY() - 130))
								/** ensure player can move in front of dresser */
								&&(!(sarah.getY() > (dresser.getY() - 60)))
								))
						) {
					/** if conditions met, move right by 5 */
					sarah.setX(sarah.getX() + 5); 
				}
				break;
			case SPACE: /** allow for interaction with items by spacebar */
				if (sarah.getCorner().distance(hairbrush.getCorner().add(dresser.getCorner())) < 100) {
					giveInfo(hairbrush, messages);
				}

				if (sarah.getCorner().distance(book.getCorner().add(shelves.getCorner())) < 100) {
					giveInfo(book, messages);
				}
				if (sarah.getCorner().distance(pillow.getCorner().add(bed.getCorner())) < 100) {
					giveInfo(pillow, messages);
				}
				;
				break;
			case X: /** to clear the message pane */
				messages.getChildren().clear();

			}
		});

		/**
		 * SCENE AND STAGE SETUP
		 */

		/** create scene to hold the room, set title, and display */
		Scene scene = new Scene(world, ROOM_WIDTH, ROOM_HEIGHT);
		primaryStage.setTitle("Alyssa's Room");
		primaryStage.setScene(scene);
		primaryStage.show();
		sarah.getSprite().requestFocus();
		
		/** display instructions for controls on startup */
		giveControls(messages);

		
	}

	/**
	 * Create new method for adding furniture to a specific X and Y coordinate
	 * in the window
	 * 
	 * @param furniture
	 * @param furnX
	 * @param furnY
	 * @param pane
	 * @param layout
	 * @param itemX
	 * @param itemY
	 */
	public void addNewFurniture(Furniture furniture, double furnX, double furnY, StackPane pane, AnchorPane layout,
			double itemX, double itemY) {

		/** add furniture to its StackPane */
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
		for (Item i : itemsHeld) {
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

	/**
	 * method to print an Item's information
	 * 
	 * @param item
	 * @param messages
	 */
	public boolean giveInfo(Item item, StackPane messages) {
		/** make a background for the new information */
		Rectangle messageBackground = new Rectangle(20, 20, 460, 260);
		messageBackground.setFill(Color.GRAY);
		messages.getChildren().add(messageBackground);
		/** make a label for the item information */
		Font infoFont = new Font("serif", 20);
		String text = "\n" + item.getInfo();
		Label info = new Label(text);
		StackPane.setAlignment(info, Pos.TOP_CENTER);
		info.setFont(infoFont);
		info.setTextFill(Color.WHITE);
		String react = item.getReact();
		Label reaction = new Label(react);
		StackPane.setAlignment(reaction, Pos.CENTER);
		reaction.setFont(infoFont);
		reaction.setTextFill(Color.ALICEBLUE);
		messages.getChildren().addAll(info, reaction);
		/** add a clue if there is one */
		if (item.isClue()) {
			Clue clueItem = (Clue) item;
			String clue = clueItem.getHint();
			Label clueGive = new Label(clue);
			StackPane.setAlignment(clueGive, Pos.BOTTOM_CENTER);
			clueGive.setFont(infoFont);
			clueGive.setTextFill(Color.AQUAMARINE);
			messages.getChildren().add(clueGive);
		}

		return true;
	}

	/** method to display controls for the game on starting
	 * given a pane to display them in
	 * @param pane
	 */
	public void giveControls(Pane pane) {
		/** create background for message */
		Rectangle blackout = new Rectangle(0, 0, 600, 400);
		/** color the background */
		blackout.setFill(Color.AQUAMARINE);
		/** add the message background to the specified pane */
		pane.getChildren().add(blackout);
		/** this string holds the instructions for the controls for the game */
		String commands = "Controls: \nMove with arrow keys\nPress spacebar to investigate\nPress X to dismiss alert\n \nPress X to start";
		/** make the control string into a label we can put in the pane */
		Label controls = new Label(commands);
		/** set the font for the controls */
		Font controlFont = new Font("serif", 40);
		controls.setFont(controlFont);
		controls.setTextFill(Color.BLACK);
		/** display control instructions in the specified pane */
		pane.getChildren().add(controls);
	}

	/** the main function */
	public static void main(String[] args) {
		Application.launch(args);

	}

}
