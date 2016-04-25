import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;

public class Player {

	
	/** initialize data fields */
	public String Name;

	private Point2D Location;

	private Rectangle Sprite;

	/**
	 * constructor that takes name and location and creates a Player in that
	 * spot
	 * 
	 * @param name
	 * @param location
	 * @param color
	 */
	public Player(String name, Point2D location, Color color) {
		setName(name);
		setLocation(location);
		setSprite(color, location);

	}

	/**
	 * method to set player name
	 * 
	 * @param name
	 */
	private void setName(String name) {
		this.Name = name;
	}

	/**
	 * method to set player location
	 * 
	 * @param location
	 */
	private void setLocation(Point2D location) {
		this.Location = location;
	}

	/**
	 * method to create player sprite
	 * 
	 * @param color
	 * @param location
	 */
	private void setSprite(Color color, Point2D location) {
		double xLoc = location.getX();
		double yLoc = location.getY();
		Rectangle body = new Rectangle(xLoc, yLoc, 65, 130);
		body.setFill(color);
		this.Sprite = body;
	}

	/**
	 * method to get sprite
	 * 
	 * @return
	 */
	public Shape getSprite() {
		return Sprite;
	}

	/**
	 * method to return current y value of player sprite
	 * 
	 * @return
	 */
	public double getY() {
		Rectangle sprite = (Rectangle) getSprite();
		return sprite.getY();
	}

	/**
	 * method to set the y value for the player's sprite
	 * 
	 * @param y
	 */
	public void setY(double y) {
		Rectangle sprite = (Rectangle) getSprite();
		sprite.setY(y);
	}

	/**
	 * method to return current x value of player sprite
	 * 
	 * @return
	 */
	public double getX() {
		Rectangle sprite = (Rectangle) getSprite();
		return sprite.getX();
	}

	/**
	 * method to set the x value for the player's sprite
	 * 
	 * @param x
	 */
	public void setX(double x) {
		Rectangle sprite = (Rectangle) getSprite();
		sprite.setX(x);
	}

	/**
	 * method to get a Point2d of the x and y of the player
	 * 
	 * @return
	 */
	public Point2D getCorner() {
		Point2D corner = new Point2D(getX(), getY());
		return corner;
	}

}
