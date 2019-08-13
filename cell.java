import java.awt.Color;
import java.awt.Graphics;

public class cell {
	
	// Basic variables for Cell 
	static int CELL_HEIGHT = 50;
	static int CELL_WIDTH = 50;
	
	// These will determine if Walls are present on the top, bottom, left, and right of the cell
	boolean top , bottom , left , right ;
	boolean visited;
	
	// Coordinate is the index of the cell in the matrix and Location is it's physical spot on the window
	int xCoordinate;
	int yCoordinate;
	int xLocation;
	int yLocation;
	
	public cell(int x, int y)
	{
		// Assume there are walls present everywhere and the cell has NOT been visited 
		top = true;
		bottom = true;
		left = true;
		right = true;
		visited = false;
		this.xCoordinate = x;
		this.yCoordinate = y;
		xLocation = xCoordinate*CELL_HEIGHT;
		yLocation = yCoordinate*CELL_WIDTH;
		
	}
	

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(xLocation, yLocation, CELL_WIDTH, CELL_HEIGHT);
		g.setColor(Color.BLACK);
		//System.out.println("(" + xLocation + "," + yLocation + ")");
		g.drawString("(" + xCoordinate + "," + yCoordinate + ")" , xLocation+15, yLocation+15);
		// Draws a Line if walls are still present
		if(top)
			g.drawLine(xLocation, yLocation, xLocation+CELL_WIDTH, yLocation);
		if(right)
			g.drawLine(xLocation+CELL_WIDTH, yLocation, xLocation+CELL_HEIGHT, yLocation+CELL_HEIGHT);
		if(left)
			g.drawLine(xLocation, yLocation, xLocation, yLocation+CELL_HEIGHT);
		if(bottom)
			g.drawLine(xLocation, yLocation+ CELL_HEIGHT, xLocation+CELL_HEIGHT, yLocation+ CELL_HEIGHT);

			
			
			
	}
	
	
	

}
