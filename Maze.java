
import java.awt.Graphics;

import java.util.Random;
import java.util.Stack;
import java.util.Vector;

public class Maze {
	
	// The maze will have cells in a 30x18 matrix
	static int xCells = 30;
	static int yCells = 18;
	private static int WIDTH = 1505;
	private static int HEIGHT = 930;
	Random rand;
	cell cells[][];
	Stack<cell> cellStack;
	int visited;
	
	
	public Maze()
	{
		cellStack = new Stack<>();
		cells = new cell[xCells][yCells];
		rand = new Random();
		for(int i = 0; i < xCells; i++)
			for(int j = 0; j < yCells; j++)
				cells[i][j] = new cell(i,j);
		
		// Starting in the first Cell so we push it on the stack and mark it as visited
		cellStack.push(cells[0][0]);
		cells[0][0].visited = true;
		visited = 1;
				
	}

	public void makeMaze() 
	{
		
		if(visited < (xCells * yCells))
		{
			cell currentCell = cellStack.peek();
			int x = currentCell.xCoordinate;
			int y = currentCell.yCoordinate;
			
			// "neighbors" will hold the possible paths the currentCell can go into
			Vector<Integer> neighbors = new Vector<Integer>();
			// Checks top
			if(y != 0)
				if(cells[x][y-1].visited == false)
					neighbors.add(0);
			// Checks Right
			if(x < xCells-1 )
				if(cells[x+1][y].visited == false)
					neighbors.add(1);
			// Checks Bottom
			if(y < yCells-1)
				if(cells[x][y+1].visited == false)
					neighbors.add(2);
			// Checks Left
			if(x != 0)
				if(cells[x-1][y].visited == false)
					neighbors.add(3);

			// If we have possibilities yet to check 
			if(!neighbors.isEmpty())
			{
				// Pick a random item in the vector 
				int n = rand.nextInt(neighbors.size());
				int direction = neighbors.get(n);
				neighbors.remove(n);
				switch(direction)
				{

					// Moves Top
					case 0: 
						cells[x][y].top = false;
						cells[x][y-1].bottom = false;
						cells[x][y-1].visited = true;
						cellStack.push(cells[x][y-1]);
						break;
					// Moves Right
					case 1: 
						cells[x][y].right = false;
						cells[x+1][y].left = false;
						cells[x+1][y].visited = true;
						cellStack.push(cells[x + 1][y]);
						break;
					// Moves Bottom
					case 2: 
						cells[x][y].bottom = false;
						cells[x][y+1].top = false;
						cells[x][y+1].visited = true;
						cellStack.push(cells[x][y + 1]);
						break;
					// Moves Left
					case 3: 
						cells[x][y].left = false;
						cells[x-1][y].right = false;
						cells[x-1][y].visited = true;
						cellStack.push(cells[x - 1][y]);
						break;
				}
				// Once we break out of the switch statement, we would have traversed 1 cell so visited is increased
				visited++;
			}
			else
				// if we no long have neighbors then we BACKTRACK to the cell that still has neighbors
				// by popping off items until we reach that cell
				cellStack.pop();
		}
				
	}
	
	public boolean solved()
	{
		return visited == (xCells * yCells);
	}
	public void paint(Graphics g)
	{
		for(int i = 0; i < xCells; i++)
			for(int j = 0; j < yCells; j++)
				cells[i][j].paint(g);
	}



}
