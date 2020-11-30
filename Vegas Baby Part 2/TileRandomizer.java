import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Section of the code that allows the shapes to be randomized to either a circle or square of various colors 
 *
 */
public class TileRandomizer  {
	TilePanel tPan; 
	

	
	public TileRandomizer(TilePanel tPan) {
		this.tPan=tPan;
		
	}
	
	public void randomize(ArrayList<Tile> tiles) {
		Random rnda = new Random();
		tiles.get(0).setRandomly(rnda);
		tiles.get(1).setRandomly(rnda);
		tiles.get(2).setRandomly(rnda);
		tiles.get(3).setRandomly(rnda);
		tPan.repaint();
		
		
	}
	
	public void spin(ArrayList<Tile> tiles) {
		Random rnda = new Random();

		for (int i=0;i< 400; i++) {
			if(i<100) {
				for (int j=0; j<4; j++) {
					tiles.get(j).setRandomly(rnda);
				}
			}else if(i<200) {
				for (int j=0; j<3; j++) {
					tiles.get(j).setRandomly(rnda);
				}
			}else if(i<200) {
				for (int j=0; j<2; j++) {
					tiles.get(j).setRandomly(rnda);
				}
			}else {
				tiles.get(0).setRandomly(rnda);
			 }
			try {
				Thread.sleep(10);
			} catch(Exception ex) {
				  
			}
			  
		  }
		tPan.repaint();


	  }

}
