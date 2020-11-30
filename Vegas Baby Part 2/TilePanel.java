import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

/**
 * Part 1 Solution by Professor Klump used
 * Section of the code that allows the mouse to be used, also contains the toString function 
 *
 */
public class TilePanel extends JPanel implements MouseListener {
	private ArrayList<Tile> tiles;
	private Random rnd;
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		addMouseListener(this);
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	  public void spin() {
		  for (int i=0;i< 400; i++) {
			  if(i<100) {
				  for (int j=0; j<4; j++) {
					  tiles.get(j).setRandomly(rnd);
				  }
			  }else if(i<200) {
				  for (int j=0; j<3; j++) {
					  tiles.get(j).setRandomly(rnd);
				  }
			  }else if(i<200) {
				  for (int j=0; j<2; j++) {
					  tiles.get(j).setRandomly(rnd);
				  }
			  }else {
				  tiles.get(0).setRandomly(rnd);
			  }
			  try {
				  Thread.sleep(10);
			  } catch(Exception ex) {
				  
			  }
			  repaint();
		  }
	  }
//	  
//	  public String toString()
//	  {
//	      StringBuilder result = new StringBuilder();
//	      result.append("Shop [ name = "+name+" ");
//
//	      for(Product p : products)
//	      {
//	          result.append("Product name"+" = "+p.getName()+", "+"Price"+" = "+p.getPrice()+" ");
//	      }
//
//	      result.append("]");
//	      return result.toString();
//	  }
	@Override
	public String toString() {
		StringBuilder currArrangement= new StringBuilder();
		currArrangement.append("");
		for(Tile tile: tiles) {
			currArrangement.append(" Color:"+tile.getColorName());
			currArrangement.append(" Shape:"+tile.getShapeAsString());
			currArrangement.append("\n");
		}
		
		return currArrangement.toString();
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
		}
		
	}
}

