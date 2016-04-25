import javafx.geometry.Point2D;
import javafx.scene.shape.*;
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Furniture {


	/**
	 * initialize data fields
	 */
	private Shape sprite; // how furniture looks in world window

	private ArrayList<Item> holding = new ArrayList(); // items the furniture is
														// holding

	private Color color; // color of furniture


	/**
	 * constructor that makes a furniture item with a specific sprite
	 * 
	 * @param sprite
	 * @param color
	 */
	public Furniture(Shape sprite, Color color) {
		setSprite(sprite);
		setColor(color);
	}

	/**
	 * method to put items into Furniture
	 * 
	 * @param i
	 */
	public void addItem(Item i) {
		holding.add(i);
	}

	/**
	 * method to return ArrayList of items in Furniture
	 * 
	 * @return
	 */
	public ArrayList getItems() {
		return holding;
	}

	/**
	 * method to set sprite for furniture, only used within this class
	 * 
	 * @param sprite
	 */
	private void setSprite(Shape sprite) {
		this.sprite = sprite;
	}

	/**
	 * method to get sprite for furniture, for display
	 * 
	 * @return
	 */
	public Shape getSprite() {
		return this.sprite;
	}

	/**
	 * method to get x value of sprite
	 * 
	 * @return
	 */
	public double getX() {
		Rectangle sprite = (Rectangle) getSprite();
		return sprite.getX();
	}

	/**
	 * method to set the x value for the item sprite
	 * 
	 * @param x
	 */
	public void setX(double x) {
		Rectangle sprite = (Rectangle) getSprite();
		sprite.setX(x);
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
	 * method to get a point2d of the x and y of the furniture
	 * 
	 * @return
	 */
	public Point2D getCorner() {
		Point2D corner = new Point2D(getX(), getY());
		return corner;
	}

	/**
	 * method to set furniture color
	 * 
	 * @param color
	 */
	protected void setColor(Color color) {
		this.color = color;
		this.sprite.setFill(color);
	}

}
