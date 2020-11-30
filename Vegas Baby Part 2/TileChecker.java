import java.io.*; 
import java.util.*; 

/**
 * Section of the code that checks for winning combinations of the shapes 
 *
 */
public class TileChecker {
	
	//if 1 returned then all shapes and color
	//if 2 returned then just colors
	//0 if nothing
	Double checkWinningCombinationsMax(ArrayList<Tile> tiles,Double balance) {
		int colorChecker=10;
		int shapeChecker=10;
		
		colorChecker=tiles.get(0).getColor();
		shapeChecker=tiles.get(0).getShape();
		
		if(colorChecker==tiles.get(1).getColor() && colorChecker==tiles.get(2).getColor() && colorChecker==tiles.get(3).getColor() ) {
			if(shapeChecker==tiles.get(1).getShape() && shapeChecker==tiles.get(2).getShape() && shapeChecker==tiles.get(3).getShape() ) {
				return 100.0 *balance;
			}
			else {
				return 25.0 * balance;
			}
			
		}
		else {
			return 0.0;
		}
		
	
	}
	Double checkWinningCombinationsMid(ArrayList<Tile> tiles,Double balance) {
		int colorChecker=10;
		int shapeChecker=10;
		double midBalance= balance/2.0;
		
		colorChecker=tiles.get(0).getColor();
		shapeChecker=tiles.get(0).getShape();
		
		if(colorChecker==tiles.get(1).getColor() && colorChecker==tiles.get(2).getColor() && colorChecker==tiles.get(3).getColor() ) {
			if(shapeChecker==tiles.get(1).getShape() && shapeChecker==tiles.get(2).getShape() && shapeChecker==tiles.get(3).getShape() ) {
				return 50.0 *midBalance;
			}
			else {
				return 10.0 * midBalance;
			}
			
		}
		else {
			return midBalance;
		}
		
	
	}
	Double checkWinningCombinationsMin(ArrayList<Tile> tiles,Double balance) {
		int colorChecker=10;
		int shapeChecker=10;
		double minBalance= balance/10.0;
		colorChecker=tiles.get(0).getColor();
		shapeChecker=tiles.get(0).getShape();
		
		if(colorChecker==tiles.get(1).getColor() && colorChecker==tiles.get(2).getColor() && colorChecker==tiles.get(3).getColor() ) {
			if(shapeChecker==tiles.get(1).getShape() && shapeChecker==tiles.get(2).getShape() && shapeChecker==tiles.get(3).getShape() ) {
				return 10.0 *minBalance;
			}
			else {
				return 5.0 * minBalance;
			}
			
		}
		else {
			return balance-minBalance;
		}
		
	
	}
	

}
