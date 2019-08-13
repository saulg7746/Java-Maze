import java.awt.Color;
import java.awt.Graphics;

import java.util.Vector;

public class MazeSolver{
	
	static int CELL_HEIGHT = 50;
	static int CELL_WIDTH = 50;
	// solution will be used to hold the correct path of cells 
	Vector<cell> solution;
	Maze maze;
	// visited is a matrix identical to the dimensions of maze to determine which cells have been visited
	int visited[][];
	
	public MazeSolver(Maze maze)
	{
		solution = new Vector<>();
		visited = new int[maze.xCells][maze.yCells];
		for(int i = 0; i < maze.xCells; i++)
			for(int j = 0; j < maze.yCells; j++)
				visited[i][j] = 0;
		this.maze = maze;
		// Starts in cell[0][0] and marks it visited
		solution.add(maze.cells[0][0]);
		visited[0][0] = 1;
	}
	
	public boolean solve(int x, int y)
	{
		// stopping condition
		if((x == maze.xCells-1) && (y == maze.yCells-1))
			return true;
		/*
		 *  NOTE: We must check for a cell's validity in this order
		 *  	1. Check if there is a wall in the direction we want to go
		 *  	2. Check if the cell we are in is a boundary cell (xCell, yCells)
		 *  	3. Check if the cell we are about to go into is visited 
		 *  	4. Check if the Top/Right/Bottom/Left direction we are about to go in has a wall
		 *  
		 *  	Once we know the cell is valid then we
		 *  	1. add the cell we are about to go into to the end of the solution
		 *  	2. mark the cell we are about to go into as visited
		 *  	3. Recursively call the next cell
		 */
		// Moves top
		if(maze.cells[x][y].top == false && (y != 0) )
			if(visited[x][y-1] == 0 && maze.cells[x][y-1].bottom == false)
			{
				solution.add(maze.cells[x][y-1]);
				visited[x][y-1] = 1;
				if(solve(x, y-1))
					return true;
				else
					solution.remove(solution.size()-1);
			}
		// Moves Right
		if(maze.cells[x][y].right == false && (x < maze.xCells-1))
			if(visited[x+1][y] == 0 && maze.cells[x+1][y].left == false)
			{
				solution.add(maze.cells[x+1][y]);
				visited[x+1][y] = 1;
				if(solve(x+1, y))
					return true;
				else
					solution.remove(solution.size()-1);
			}
		// Moves Bottom
		if(maze.cells[x][y].bottom == false && (y < maze.yCells-1))
			if(visited[x][y+1] == 0 && maze.cells[x][y+1].top == false)
			{
				solution.add(maze.cells[x][y+1]);
				visited[x][y+1] = 1;
				if(solve(x, y+1))
					return true;
				else
					solution.remove(solution.size()-1);
			}
		// Moves Left	
		if(maze.cells[x][y].left == false && (y != 0))
			if(visited[x-1][y] == 0 && maze.cells[x-1][y].right == false)
			{
				visited[x-1][y] = 1;
				solution.add(maze.cells[x-1][y]);
				if(solve(x-1, y))
					return true;
				else
					solution.remove(solution.size()-1);
			}
		

		// if we've exhausted all the possible directions then we reach a dead- end
		// solve() will return false causing it to backtrack to the previous cell
		return false;

	}

	public void paint(Graphics g)
	{
		g.setColor(Color.RED);

		for(int i = 0; i < solution.size(); i++)
			g.fillOval(solution.get(i).xLocation+15, solution.get(i).yLocation+15, 20, 20);
		
		
	}

}
