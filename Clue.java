import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Clue extends Item{
	
	private String Hint;
	
	public Clue(Furniture furniture, String hint, String information, String reaction, Shape sprite, Color color){
		super(furniture, information, reaction, sprite, color);
		setHint(hint);
	}
	
	//method for setting hint
	private void setHint(String hint){
		this.Hint = hint;
	}
	
	//method for getting hint
	public String getHint(){
		return this.Hint;
	}
}
