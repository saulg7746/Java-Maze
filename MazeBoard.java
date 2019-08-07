import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class MazeBoard extends JPanel implements ActionListener{

	Maze maze;
	
	public MazeBoard()
	{
    	setBackground(Color.WHITE);
    	maze = new Maze();
    	
    	Timer timer = new Timer(10, this);
        timer.start();
        setFocusable(true);
	}
	
	
	public void paintComponent(Graphics g )
	{
	    maze.paint(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		maze.makeMaze();
		repaint();
	}

}
