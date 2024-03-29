import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MazeBoard extends JPanel implements ActionListener{

	Maze maze;
	MazeSolver solver;
	
	public MazeBoard()
	{
    	setBackground(Color.WHITE);
    	maze = new Maze();
    	solver = new MazeSolver(maze);
    	
    	Timer timer = new Timer(1, this);
        timer.start();
        setFocusable(true);
	}
	
	
	public void paintComponent(Graphics g )
	{
	    maze.paint(g);
	    solver.paint(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(maze.solved())
			solver.solve(0,0);
		else
			maze.makeMaze();
		repaint();
	}

}
