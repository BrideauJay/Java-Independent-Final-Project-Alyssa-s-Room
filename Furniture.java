import javafx.geometry.Point2D;
import javafx.scene.shape.*;
import java.util.ArrayList;
import javafx.scene.paint.Color;


public class Furniture{

	//initialize data fields
	//private Point2D location; //location of furniture sprite. irrelevant, make furniture wherever needed
	private Shape sprite; //how furniture looks in world window
	private ArrayList<Item> holding = new ArrayList(); //and items the furniture is holding
	private Color color; //color of furniture
	
//	currently scrapped code for simpler creation of furniture
//  may be implemented in next stage
//	public Furniture (String furnName, Color color){
//		switch(furnName){
//		case "bed": 
//			new Furniture(new Rectangle(0,0,200, 100), color);
//			break;
//		}
//			
//	}
	
	//make a constructor that makes a furniture item with a specific sprite
	public Furniture(Shape sprite, Color color){
		setSprite(sprite);
		setColor(color);
	}
	
	//method to put items into Furniture
	public void addItem(Item i){
		holding.add(i);
	}
	
	//method to list items in Furniture
	public ArrayList getItems(){
		return holding;
	}
	
	//method to set sprite for furniture, only used within this class
	private void setSprite(Shape sprite){
		this.sprite = sprite;
	}
	
	//method to get sprite for furniture, for display
	public Shape getSprite(){
		return this.sprite;
	}
	
	/**method to get x value of sprite */
	public double getX(){
		Rectangle sprite = (Rectangle)getSprite();
		return sprite.getX();
	}
	
	//method to set the x value for the item sprite
		public void setX(double x){
			Rectangle sprite = (Rectangle)getSprite();
			sprite.setX(x);
		}
		
		//method to return current y value of player sprite
		public double getY(){
			Rectangle sprite = (Rectangle)getSprite();
			return sprite.getY();
		}
		
		//method to set the y value for the player's sprite
		public void setY(double y){
			Rectangle sprite = (Rectangle)getSprite();
			sprite.setY(y);
		}
		
		/**method to get a point2d of the x and y of the furniture */
		public Point2D getCorner(){
			Point2D corner = new Point2D(getX(), getY());
			return corner;
		}
	
	//method to set furniture color
	protected void setColor(Color color){
		this.color = color;
		this.sprite.setFill(color);
	}
	
	
}
