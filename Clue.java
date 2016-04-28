import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Clue extends Item {

	/**
	 * initialize data fields
	 */
	private String Hint;

	/**
	 * constructor to create a Clue that calls Item constructor and passes
	 * additional data of Hint
	 * 
	 * @param furniture
	 * @param hint
	 * @param information
	 * @param reaction
	 * @param sprite
	 * @param color
	 */
	public Clue(Furniture furniture, String hint, String information, String reaction, Shape sprite, Color color) {
		super(furniture, information, reaction, sprite, color);
		setHint(hint);
	}

	/**
	 * method for setting Hint
	 * 
	 * @param hint
	 */
	private void setHint(String hint) {
		this.Hint = hint;
	}

	/**
	 * method for getting Hint
	 * 
	 * @return
	 */
	public String getHint() {
		return this.Hint;
	}
	
	/** override of method in item.
	 * tells that item is a clue
	 */
	@Override
	public boolean isClue(){
		return true;
	}
}
