import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

/**
 * Part 1 Solution by Professor Klump used 
 * Code that allows the different shapes to be constructed whether it be a circle or square in various colors such as yellow, green, orange,red, and blue
 * 
 *
 */
public class Tile implements Serializable {
	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final String[] shapes = {"circle","square"};
	private int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	private int shape; // 0 - circle, 1 - square, 2 - diamond
	
	//constructors
	public Tile() {
		color = 3;
		shape = 0;
	}
	
	
	public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
	
	
	//getters and setters
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		if (color < 0) {
			this.color = 0;
		} else if (color > 4) {
			this.color = 4;
		} else {
			this.color = color;
		}
	}
	
	//set random function to randomize shapes, takes in rand obj
	public void setRandomly(Random rnd) {
		color = rnd.nextInt(colors.length);
		shape = rnd.nextInt(shapes.length);
	}
	public Color getActualColor() {
		return colors[color];
	}
	public String getColorName() {
		return colorNames[color];
	}
	public int getShape() {
		return shape; 
	}
	public void setShape(int shape) {
		if (shape < 0) {
			this.shape = 0;
		} else if (shape > 1) {
			this.shape = 1;
		} else {
			this.shape = shape;
		}
	}
	public String getShapeAsString() {
		return shapes[shape];
	}
	
	
	//how your able to write tile objects to console or anywhere
	public String toStringFancy() {
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	@Override
	public String toString() {
		return String.format("%d %d",color,shape);

	}
	public int getCode() {
		return color*10+shape;
	}
}

