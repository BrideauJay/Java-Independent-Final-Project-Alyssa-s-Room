import javafx.scene.shape.*;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Item {

	//initialize data fields
	private Furniture HeldBy;
	
	private String Information;
	
	private String Reaction;
	
	public Shape sprite;
	
	private Color color;
	
	
//	currently scrapped code for simpler creation of items
//  may be implemented in next stage
	//simple constructor to be overloaded based on input
//	public Item(Furniture furniture, String itemName, Color color){
//		switch(itemName){
//		case "brush": 
//			new Item(furniture, "A hairbrush. There's still some hair caught in it.", "Weird. I didn't think Alyssa would have a hairbrush.", new Rectangle (0,0,15,5), color);
//			break;
//		case "pillow":
//			new Item(furniture, "A regular pillow.", "Looks like it's been in a few fights. Pillow fights.", new Rectangle (0,0,40,40), color);
//			break;
//		}
//	}
	
	//item constructor that takes furniture and other information
	public Item(Furniture furniture, String information, String reaction, Shape sprite, Color color){
		setHolding(furniture); //set the furniture holding the item
		setInfo(information); //set the item's information
		setReact(reaction);
		setSprite(sprite);
		setColor(color);
		}
	
	//method to set the furniture holding the item
	private void setHolding(Furniture f){
		this.HeldBy = f;
	}
	
	//method to get furniture item holding item
	public Furniture getHeldBy(){
		return this.HeldBy;
	}
	
	//set the item's information
	private void setInfo(String info){
		this.Information = info;
	}
	
	//get the item's information
	public String getInfo(){
		return this.Information;
	}
	
	//set the reaction the player will have to the item
	private void setReact(String react){
		this.Reaction = react;
	}
	
	//get the reaction the player has to the item
	public String getReact(){
		return this.Reaction;
	}
	
	//method to set the item's sprite
	private void setSprite(Shape sprite){
		this.sprite = sprite;
	}
	
	//method to get the item's sprite
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
		
		/**method to get a point2d of the x and y of the player */
		public Point2D getCorner(){
			Point2D corner = new Point2D(getX(), getY());
			return corner;
		}
	
	//method to set color
	public void setColor(Color color){
		this.color = color;
		this.sprite.setFill(color);
	}
	
	//method to get color
	public Color getColor(){
		return this.color;
	}
}
