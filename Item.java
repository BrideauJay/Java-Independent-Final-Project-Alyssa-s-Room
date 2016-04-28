import javafx.scene.shape.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Item {

	
	/**
	 * initialize data fields
	 */
	private Furniture HeldBy;

	private String Information;

	private String Reaction;

	public Shape sprite;

	private Color color;


	/**
	 * item constructor that takes furniture and other information
	 * 
	 * @param furniture
	 * @param information
	 * @param reaction
	 * @param sprite
	 * @param color
	 */
	public Item(Furniture furniture, String information, String reaction, Shape sprite, Color color) {
		setHolding(furniture); // set the furniture holding the item
		setInfo(information); // set the item's information
		setReact(reaction);
		setSprite(sprite);
		setColor(color);
	}

	/**
	 * method to set the furniture holding the item
	 * 
	 * @param f
	 */
	private void setHolding(Furniture f) {
		this.HeldBy = f;
	}

	/**
	 * method to get furniture item holding item
	 * 
	 * @return
	 */
	public Furniture getHeldBy() {
		return this.HeldBy;
	}

	/**
	 * set the item's information
	 * 
	 * @param info
	 */
	private void setInfo(String info) {
		this.Information = info;
	}

	/**
	 * get the item's information
	 * 
	 * @return
	 */
	public String getInfo() {
		return this.Information;
	}

	/**
	 * set the reaction the player will have to the item
	 * 
	 * @param react
	 */
	private void setReact(String react) {
		this.Reaction = react;
	}

	/**
	 * get the reaction the player has to the item
	 * 
	 * @return
	 */
	public String getReact() {
		return this.Reaction;
	}

	/**
	 * method to set the item's sprite
	 * 
	 * @param sprite
	 */
	private void setSprite(Shape sprite) {
		this.sprite = sprite;
	}

	/**
	 * method to get the item's sprite
	 * 
	 * @return
	 */
	public Shape getSprite() {
		return this.sprite;
	}

	/**
	 * method to get x value of item sprite
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
	 * method to return current y value of item sprite
	 * 
	 * @return
	 */
	public double getY() {
		Rectangle sprite = (Rectangle) getSprite();
		return sprite.getY();
	}

	/**
	 * method to set the y value for the item sprite
	 * 
	 * @param y
	 */
	public void setY(double y) {
		Rectangle sprite = (Rectangle) getSprite();
		sprite.setY(y);
	}

	/**
	 * method to get a Point2d of the x and y of the Item
	 * 
	 * @return
	 */
	public Point2D getCorner() {
		Point2D corner = new Point2D(getX(), getY());
		return corner;
	}

	/**
	 * method to set color of item
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
		this.sprite.setFill(color);
	}

	/**
	 * method to get color of item
	 * 
	 * @return
	 */
	public Color getColor() {
		return this.color;
	}
	
	/** method to tell if the item is a clue or not.
	 * overridden to be true in clue
	 * @return
	 */
	public boolean isClue(){
		return false;
	}
}
